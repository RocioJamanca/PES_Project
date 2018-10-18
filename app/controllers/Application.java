package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render(); //Busca un fichero que teng el mismo nombre de index con un formato HTML


    }

    public static void loadPage(int i){
        if (i==1)
            renderTemplate("Application/login.html");
        else
            renderTemplate("Application/register.html");
        render();
    }

    public static void register(String username,String email,String password){

        User u = User.find("byUsername",username).first();
        if(u==null)
        {
            User user =new User(username,email,password).save();
            user.save();
            renderText("You've been registered correctly!");
        }
        else {
            renderText("Sorry you are registered ");
        }

       // render();
    }



    public static void login(String username,String password){
        User user = User.find("byUsernameAndPassword",username,password).first();
        if (user!=null)
        {
            renderText("Welcome "+ user.username);
        }
        else
        {
            renderText("Sorry you are not registered ");
        }

        //render();
    }

    public  static void deleteUser(){
        User u= User.find("byUsername","Rocio").first();
        u.delete();

    }

}