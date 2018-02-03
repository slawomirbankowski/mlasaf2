/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.domain

import com.mlasaf.base.ThreadBase
import com.mlasaf.dto.ExecutorInstanceDto

/** manager for resources: CPU, DISK, RAM, GPU and others */
class ResourceManager extends ThreadBase {

  /** DTO for resource manager */
  var resourceManagerDto : com.mlasaf.dto.ResourceManagerDto = null;
  var lastCheckDto : com.mlasaf.dto.ResourceManagerCheckDto = null;
  /** get name of thread */
  def getName() : String = "RESOURCE_MANAGER";
  /** run for executor */
  def onRunBegin() = {
    val resourceManagerTypeId = parentContext.daoFactory.daos.resourceManagerTypeDao.getResourceManagerTypeFirstByName("BASIC").get.resourceManagerTypeId;
    resourceManagerDto = parentContext.daoFactory.daos.resourceManagerDao.createAndInsertResourceManagerDto(resourceManagerTypeId, this.parentContext.hostDto.executorHostId, "CREATED");

    // TODO: resource manager initializations

    parentContext.daoFactory.daos.resourceManagerDao.updateField(resourceManagerDto, com.mlasaf.dto.ResourceManagerDto.FIELD_resourceManagerStatus, "INITIALIZED");

  }
  /** running executor in separate thread */
  def onRun() = {
    lastCheckDto = parentContext.daoFactory.daos.resourceManagerCheckDao.createAndInsertResourceManagerCheckDto(resourceManagerDto.resourceManagerId, this.parentContext.hostDto.executorHostId, "OK");
    logger.info("ResourceManager run in thread: " + resourceManagerDto + ", last CHECK: " + lastCheckDto);
    // add all resource values for this host - for all measures
    parentContext.daoFactory.daos.resourceMeasureDao.getResourceMeasuresList().map(m => (m, Class.forName(m.resourceMeasureClass).newInstance().asInstanceOf[com.mlasaf.resource.ResourceMeasureBase]) ).foreach(rmm => {
      val measureValue = rmm._2.getMeasure();
      parentContext.daoFactory.daos.resourceManagerMeasureDao.createAndInsertResourceManagerMeasureDto(resourceManagerDto.resourceManagerId, rmm._1.resourceMeasureId, "", measureValue);
    });
    // TODO:  add resources, manage allocations, get allocations and needs, assign to hosts/executors
    val allocations = parentContext.daoFactory.daos.resourceManagerAllocationDao.getResourceManagerAllocationByFkExecutorHostId(this.parentContext.hostDto.executorHostId);





  }
  //**  */
  def onRunEnd() = {
    isWorking = false;
    logger.info("End of working, try to unregister ResourceManager: " + resourceManagerDto)
    parentContext.daoFactory.daos.resourceManagerDao.updateField(resourceManagerDto, com.mlasaf.dto.ResourceManagerDto.FIELD_resourceManagerStatus, "FINISHED");
    logger.info("End ResourceManager " + resourceManagerDto)
  }
  def onStop() : Unit = {
    logger.info("Stopping ResourceManager...");
  }
  def getInfoJson() = {
    "" // TODO: implement JSON infor for resource manager
  }
}

object ResourceManager {

  val RESOURCE_MEASURE_CPU = "CPU";
  val RESOURCE_MEASURE_GPU = "GPU";
  val RESOURCE_MEASURE_TPU = "TPU";
  val RESOURCE_MEASURE_FPU = "FPU";
  val RESOURCE_MEASURE_RAM = "RAM";
  val RESOURCE_MEASURE_DISK = "DISK";


}