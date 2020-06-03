package com.zaprogramowani;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFiles.location("/public");

        get("/status", (req, res) -> {
            res.type("application/json");
            return "{\"message\":\"OK\"}";
        });

    }
}
