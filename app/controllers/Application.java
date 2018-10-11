package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void addUser(){
        User u =new User("Rocio","rocio@gmail.com","123456").save();
        u.save();

    }

    public  static void deleteUser(){
        User u= User.find("byUsername","Rocio").first();
        u.delete();

    }

}