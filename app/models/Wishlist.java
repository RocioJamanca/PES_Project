package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Wishlist extends Model {
    public List<ProductQuantity> products;

}
