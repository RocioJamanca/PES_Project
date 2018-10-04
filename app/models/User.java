package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
//Tabla de usuario
@Entity
public class User extends Model {
    public String username;
    public String email;
    public String password;

    //El constructor nos permite crear el usuario
    public User (String username,String email,String password)
    {
        this.username=username;
        this.email=email;
        this.password=password;
    }

}
