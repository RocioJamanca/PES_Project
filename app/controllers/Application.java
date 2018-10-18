package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render(); //Busca un fichero que teng el mismo nombre de index con un formato HTML


    }

    public static void register(String username,String email,String password){
        User user =new User(username,email,password).save();
        user.save();
        render();
    }

    public static void login(String u,String p){
        User user = User.find("byUsernameAndPassword",u,p).first();
        if (user!=null)
        {
            renderText("Welcome "+ user.username);
        }
        else
        {
            renderText("Sorry you are not registered ");
        }
    }

    public  static void deleteUser(){
        User u= User.find("byUsername","Rocio").first();
        u.delete();

    }

}