/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.rest.instances

import com.mlasaf.base.RestBase

class StorageRests extends RestBase {

  def initialize() : Unit = {
    spark.Spark.get("/storage-resource-list", (req: spark.Request, resp: spark.Response) => {
      resp.raw().setContentType("application/json");
      val storageResources = parentRest.parentContext.daoFactory.daos.vExecutorStorageViewDao.getDtosByExecutorStorage_executorHostId(parentRest.parentContext.hostDto.executorHostId);
      "[ " + storageResources.map(r => r.toJson()).mkString(",") + " ] "
    });
    spark.Spark.get("/storage-resource-download", (req: spark.Request, resp: spark.Response) => {
      val storageViewId = 1;
      val storageResourcesToDownload = parentRest.parentContext.daoFactory.daos.vExecutorStorageViewDao.getDtosByExecutorStorageViewId(storageViewId);
      val storagesBuffer = new StringBuilder();
      storagesBuffer.append("[ { path:EMPTY }");
      storageResourcesToDownload.foreach(res => {
        //
        val foundStorages = parentRest.parentContext.storages.filter(s => s.storageDto.executorStorageId == res.executorStorage_executorStorageId);
        if (foundStorages.size > 0) {
          // try to download resource: res.executorStorageResource_resourcePath
          storagesBuffer.append(" , {path:" + res.executorStorageResource_resourcePath + "}");
          //resp.raw().
          // TODO: read resource from storage and send as JSON with metadata

        } else {
          // nothing to download - no storage running
          ""
        }
      });
      storagesBuffer.append("]")
      storagesBuffer.toString();
    });
  }

}
