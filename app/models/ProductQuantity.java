package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class ProductQuantity extends Model {
    public Product product;
    int quantity;
}
