package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

//Una contiene los productos y la cantidad
@Entity
public class ProductQuantity extends Model {
    @OneToOne
    public Product product;
   public int quantity;

    @ManyToOne
    public Purchase purchase;

    public ProductQuantity(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
