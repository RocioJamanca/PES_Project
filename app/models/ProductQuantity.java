package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
//Una contiene los productos y la cantidad
@Entity
public class ProductQuantity extends Model {
    public Product product;
    int quantity;
}
