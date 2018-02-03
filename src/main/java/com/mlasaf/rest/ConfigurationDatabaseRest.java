package com.mlasaf.rest;

public class ConfigurationDatabaseRest {

    public void initialize(com.mlasaf.domain.Context parentContext) {
        //parentContext.daoFactory().daos().algorithmRunDao().getAlgorithmRunFirst().

        parentContext.daoFactory().daos().executorInstanceDao().getExecutorInstancesList();
        spark.Spark.get("/executor-instance", (req, res) -> {
            return "";
        });


        spark.Spark.init();



    }

}
