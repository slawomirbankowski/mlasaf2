/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto.{ExecutorHostDto, ExecutorInstanceDto}
import com.mlasaf.utils.MlUtils

/** cutsom DAO for custom not generated methods */
class DaoCustom {

  /** logger */
  val logger = org.slf4j.LoggerFactory.getLogger("DaoCustom");
  /** factory of DAOs */
  var daoFactory : DaoFactory = null;
  /** create new custom DAO */
  def DaoCustom() = {
  }
  def initialize(factory : DaoFactory) = {
    logger.info("Creating DaoCustom ");
    daoFactory = factory;
  }
  /** insert new executor HOST */
  def insertExecutorHost(dto : ExecutorHostDto) = {
    implicit val connection = daoFactory.daoConn.getConnection();
    SQL("insert into executorHost( executorHostId, hostName, hostIp, hostDomain, hostOsType, hostOsVersion) values( {executorHostId}, {hostName}, {hostIp}, {hostDomain}, {hostOsType}, {hostOsVersion}) ")
      .on("executorHostId" -> dto.executorHostId, "hostName" -> dto.hostName, "hostIp" -> dto.hostIp, "hostDomain" -> dto.hostDomain, "hostOsType" -> dto.hostOsType, "hostOsVersion" -> dto.hostOsVersion)
      .executeInsert()(connection)
    daoFactory.daoConn.releaseConnection(connection);
  }
  /** check if executorHost is in database - if not add new one, if there is such host - just get it from DB */
  def registerHost() : ExecutorHostDto = {
    val hostName = MlUtils.getHostName
    logger.info("Try to register CURRENT host for name: " + hostName)
    val hostAddress = java.net.InetAddress.getLocalHost.getHostAddress
    val hostIp = java.net.InetAddress.getLocalHost.getAddress.map(b => b.toInt).map(b => if (b<0) b+256 else b).mkString(".")
    val canonicalHost = java.net.InetAddress.getLocalHost.getCanonicalHostName
    val osName = System.getProperty("os.name")
    val osVersion = System.getProperty("os.version")
    val connection = daoFactory.daoConn.getConnection();
    val queryRes = SQL("select count(*) as cnt from executorHost where hostName = {hostName} and hostIp = {hostIp}")
      .on("hostName" -> hostName, "hostIp" -> hostIp)
      .executeQuery()(connection);
    logger.info("queryRes: " + queryRes)
    val cnt = queryRes.as[Int](SqlParser.int("cnt").single)(connection);
    println("Hosts count for CURRENT name: " + cnt);
    if (cnt == 0) {
      val currentHost : ExecutorHostDto = daoFactory.daos.executorHostDao.createAndInsertExecutorHostDto(hostName, hostIp, "", osName, osVersion, 1);
      logger.info("Registering Executor Host for host: " +  hostName + ", hostAddress: " + hostAddress + ", IP: " + hostIp + ", canonicalHost: " + canonicalHost)
      daoFactory.daoConn.releaseConnection(connection);
      currentHost
    } else {
      logger.info("Try to search for current host in DB: " +  hostName)
      val currentHost : ExecutorHostDto = SQL("select * from executorHost where hostName = {hostName} and hostIp = {hostIp}")
        .on("hostName" -> hostName, "hostIp" -> hostIp)
        .as[ExecutorHostDto](anorm.Macro.namedParser[ExecutorHostDto].single)(connection)
      daoFactory.daoConn.releaseConnection(connection);
      logger.info("Current host in DB: " +  currentHost)
      currentHost
    }
  }
  /**  */
  def registerExecutorInstance(executorTypeId : Long, executorContextId : Long) : ExecutorInstanceDto = {
    implicit val conn = daoFactory.daoConn.getConnection();
    val hostDto : ExecutorHostDto = registerHost();
    logger.info("Registering new Executor for host: " + hostDto);
    val execInst = daoFactory.daos.executorInstanceDao.createAndInsertExecutorInstanceDto(executorTypeId, hostDto.executorHostId, executorContextId, "executor_name", "", "", 1, 0, 8888, new java.util.Date());
    daoFactory.daoConn.releaseConnection(conn);
    execInst;
  }


}
