package models;

import play.db.jpa.Model;
import javax.persistence.Entity;

@Entity
public class Product extends Model {

    public String category;
    public String model;
    public String brand;
    public float price;


}
