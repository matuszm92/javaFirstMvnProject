package com.zaprogramowani;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFiles.location("/public");
        
        get("/hello/:name", (req, res) -> {
            return "Witaj: " + req.params(":name");
        });
    }
}
