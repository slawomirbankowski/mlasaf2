/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.sample

object CreateSampleData {

  /** logger for DAO */
  val logger = org.slf4j.LoggerFactory.getLogger("CreateSampleData");

  /** main entry point to run all services for MLASAF, initialization from command line arguments or from xml file */
  def main(args : Array[String]) = {
    logger.info(" MSSQLSERVER - DRIVER ")
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    val connmssql = java.sql.DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS2014;DatabaseName=client_test", "sa", "sapass");
    logger.info(" MSSQLSERVER - CONNECTED ")
    connmssql.createStatement().execute("create table dbo.sales(yearmonth int, product varchar(50), sale_value float, sale_units float)");

    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201501, 'Bike', 5000, 5)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201502, 'Bike', 6000, 6)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201503, 'Bike', 7000, 7)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201504, 'Bike', 8000, 8)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201505, 'Bike', 9000, 9)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201506, 'Bike', 10000, 10)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201507, 'Bike', 10000, 10)");

    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201501, 'Snowboard', 8000, 8)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201502, 'Snowboard', 7000, 7)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201503, 'Snowboard', 6000, 6)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201504, 'Snowboard', 5000, 5)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201505, 'Snowboard', 4000, 4)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201506, 'Snowboard', 3000, 3)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201507, 'Snowboard', 2000, 2)");

    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201501, 'Tennis Table', 5000, 5)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201502, 'Tennis Table', 6000, 6)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201503, 'Tennis Table', 5000, 5)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201504, 'Tennis Table', 6000, 6)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201505, 'Tennis Table', 5000, 5)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201506, 'Tennis Table', 6000, 6)");
    connmssql.createStatement().execute("insert into sales(yearmonth, product, sale_value, sale_units) values (201507, 'Tennis Table', 5000, 5)");

    logger.info(" MSSQLSERVER - EXECUTED SQL ")
    connmssql.close();
    logger.info(" MSSQLSERVER - DISCONNECTED ")
  }


}
