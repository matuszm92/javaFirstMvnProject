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
            if(body != null) {
                List<String> paramValues = new ArrayList<>();
                String[] params = body.split("&");
                for(String param : params) {
                    String[] paramPair = param.split("=");
                    paramValues.add(paramPair[1]);
                }
                User user = new User();
                user.setLogin(paramValues.get(0));
                user.setFirstName(paramValues.get(1));
                user.setLastName(paramValues.get(2));
                user.setPassword(paramValues.get(3));
                users.add(user);
            }
            res.type("application/json");
            return "";
        };
	}

}
