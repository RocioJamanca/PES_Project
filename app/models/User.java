package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
        //this.shoppingCartList = new ArrayList<ProductQuantity>();
        this.wishlistList  = new ArrayList<Product>();
        //this.purchaseList = new ArrayList<Purchase>();
    }
    @OneToOne //(mappedBy = "userP",cascade = CascadeType.ALL)
    public Purchase purchase;

  //  @OneToMany
  //  public List<ProductQuantity> shoppingCartList;

   @OneToMany
    public List<Product> wishlistList;


}
