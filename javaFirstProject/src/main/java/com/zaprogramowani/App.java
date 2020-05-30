package com.zaprogramowani;

import static spark.Spark.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {

    static List<User> registeredUsers;

    public static void main(String[] args) {
        registeredUsers = new ArrayList<>();

        registeredUsers.add(new User("janusz", "paciaciak"));
        registeredUsers.add(new User("admin", "admin"));

        staticFiles.location("/public");
        
        get("/hello/:name", (req, res) -> {
            return "Witaj: " + req.params(":name");
        });

        post("/getDate", (req,res) -> {
            return LocalDate.now(); 
        });
     
        get("/login/:login/:pass", (req,res) -> {
            String login = req.params(":login");
            String password = req.params(":pass");
            
            for(User user : registeredUsers) {
                if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    return "Jestes zalogowany";
                }
            }
            return "Cos poszlo nie tak";
        });

    }

    static class User {
        private String login;
        private String password;

        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

    }
}
