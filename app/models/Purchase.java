package models;
import play.db.jpa.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//Clase purchase
@Entity
public class Purchase extends Model {

    @OneToMany
   public List<ProductQuantity> productQuantityList = new ArrayList<ProductQuantity>();
    @OneToOne
    public User userP;
    public Purchase(User user)
    {
        this.userP=user;
    }
}
