package com.zaprogramowani;

import static spark.Spark.*;

import com.zaprogramowani.user.UserApi;

public class App {

    public static void main(String[] args) {
        staticFiles.location("/public");
        
        UserApi userApi = new UserApi();

        path("/api", () -> {
            path("/user", () -> {
                post("/add", userApi.add());
                get("/list", userApi.getList());
                post("/delete", userApi.delete());
                post("/edit", userApi.edit());
            });
        });

        get("/status", (req, res) -> {
            res.type("application/json");
            return "{\"message\":\"OK\"}";
        });

        notFound("<html><body><h1>Error 404<h1></body></html>");

    }

}
