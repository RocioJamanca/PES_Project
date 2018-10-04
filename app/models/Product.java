package models;

import play.db.jpa.Model;
import javax.persistence.Entity;
//Tabla de productos
@Entity
public class Product extends Model {

    public String category; //Aqi dentro ponemos a que pertenece, si es tv, telef, impresora....
    public String model;
    public String brand;
    public float price;


}
