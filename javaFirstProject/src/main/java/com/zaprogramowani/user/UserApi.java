package com.zaprogramowani.user;

import java.util.ArrayList;
import java.util.List;

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
            res.type("application/json");
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
                user.setId(String.valueOf(users.lastIndexOf(user)));
                return gson.toJson(user);
            }
            return "{}";
        };
	}

	public Route delete() {
		return (req, res) -> {
            res.type("application/json");
            String body = req.body();
            if(body != null) {
                List<String> paramValues = new ArrayList<>();
                String[] params = body.split("&");
                for(String param : params) {
                    String[] paramPair = param.split("=");
                    paramValues.add(paramPair[1]);
                }
                String loginToDelete = paramValues.get(0);
                User userToDelete = users.stream().filter(user -> loginToDelete.equals(user.getLogin())).findAny().orElse(null);
                users.remove(userToDelete);                
            }
            return "{}";
        };
	}

	public Route edit() {
		return (req, res) -> {
            res.type("application/json");
            String body = req.body();
            if(body != null) {
                List<String> paramValues = new ArrayList<>();
                String[] params = body.split("&");
                for(String param : params) {
                    String[] paramPair = param.split("=");
                    paramValues.add(paramPair[1]);
                }

                User userToEdit = users.stream().filter(user -> paramValues.get(0).equals(user.getLogin())).findAny().orElse(null);
                if(userToEdit != null) {
                    userToEdit.setLogin(paramValues.get(0));
                    userToEdit.setFirstName(paramValues.get(1));
                    userToEdit.setLastName(paramValues.get(2));
                    userToEdit.setPassword(paramValues.get(3));
                }
                return gson.toJson(userToEdit);
            }
            return "{}";
        };
	}

}
