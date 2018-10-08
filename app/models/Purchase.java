package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Purchase extends Model {

    @OneToMany
   public List<ProductQuantity> items;
   //Añadir fecha



    public  Purchase(){
       this.items=new ArrayList<ProductQuantity>();
   }

}
