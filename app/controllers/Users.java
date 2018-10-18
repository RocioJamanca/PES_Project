package controllers;

import models.User;
import play.mvc.Controller;

public class Users extends Controller {

    public static void login(String u,String p){

        User user=User.find("byUsernameAndPassword",u,p).first();
        if (user!=null)
        {
           renderText("Welcome "+ user.username);
        }
        else
        {
            renderText("Sorry you are not registered ");
        }
    }




}
