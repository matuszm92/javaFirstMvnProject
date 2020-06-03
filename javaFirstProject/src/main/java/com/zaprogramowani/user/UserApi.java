package com.zaprogramowani.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;

import spark.Route;

public class UserApi {

    private List<User> users = new ArrayList<>();
    private Gson gson;

    public UserApi() {
        gson = new Gson();
    }

    public Route getList() {
        return (req, res) -> {
            res.type("application/json");
            return gson.toJson(users);
        };
    }

	public Route add() {
		return (req, res) -> {
            String body = req.body();
            res.type("application/json");
            return "";
        };
	}

}
