package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Purchase extends Model {

    @OneToMany
   public List<ProductQuantity> items = new ArrayList<ProductQuantity>();
   //Añadir fecha

    @OneToOne
    public User userP;

public Purchase(List<ProductQuantity> items){
    this.items=items;
}

}
