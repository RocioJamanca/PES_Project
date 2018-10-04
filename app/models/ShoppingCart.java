package models;

import play.db.jpa.Model;
import javax.persistence.Entity;
import java.util.List;
//Tabla de carrito de compra con los productos
@Entity
public class ShoppingCart extends Model {
    public List<ProductQuantity> products;

}
