import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Before
    public void inicializar(){

        new User("Azucar","azucar@gmail.com","Aazucar1").save();
        new Product("TV","JK1200","SAMSUNG",1752).save();
    }

    @After

    public void tearDown(){
        Fixtures.deleteDatabase();
    }

    @Test
    public  void testW(){

        Product p1=Product.find("byModel","JK1200").first();
        Assert.assertEquals(p1.model, "JK1200");
        ProductQuantity pq1=new ProductQuantity(p1,130);
        pq1.save();


        User u1=User.find("byUsername","Azucar").first();
        Assert.assertEquals(u1.username, "Azucar");
        u1.shoppingCartList.add(pq1);
        u1.save();

    }
}
