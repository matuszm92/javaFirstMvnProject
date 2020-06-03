package com.zaprogramowani.user;

import spark.Route;

public class UserApi {

    public static Route getList() {
        return (req, res) -> {
            return "Powinienem zwrocic liste";
        };
    }

}
