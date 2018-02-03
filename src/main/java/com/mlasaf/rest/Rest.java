package com.mlasaf.rest;

public class Rest {

    public void initialize(com.mlasaf.domain.Context parentContext) {
        //parentContext.daoFactory().daos().algorithmRunDao().getAlgorithmRunFirst().

        spark.Spark.get("/executor-instance", (req, res) -> {
            return "";
        });
    }


}
