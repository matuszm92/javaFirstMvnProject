package com.zaprogramowani;

import static spark.Spark.*;

import com.zaprogramowani.user.UserApi;

public class App {

    public static void main(String[] args) {
        staticFiles.location("/public");

        path("/api", () -> {
            path("/user", () -> {
                get("/list", UserApi.getList());
            });
        });

        get("/status", (req, res) -> {
            res.type("application/json");
            return "{\"message\":\"OK\"}";
        });

        notFound("<html><body><h1>Error 404<h1></body></html>");

    }

}
