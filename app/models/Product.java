package models;

import play.db.jpa.Model;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

//Tabla de productos
@Entity
public class Product extends Model {

    public String category; //Aqi dentro ponemos a que pertenece, si es tv, telef, impresora....
    public String model;
    public String brand;
    public double price;

    @OneToOne
    public ProductQuantity productQuantity;


    public Product(String category, String model, String brand, float price) {
        this.category = category;
        this.model = model;
        this.brand = brand;
        this.price = price;
    }
}
