package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

//Una contiene los productos y la cantidad
@Entity
public class ProductQuantity extends Model {
    @OneToOne
    public Product product;
    int quantity;

    public ProductQuantity(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
