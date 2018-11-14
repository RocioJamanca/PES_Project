import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Before
    public void inicializar(){

       User u5= new User("Ana","ana@gmail.com","ana123").save();
       Product p5= new Product("TV","JK1200","SAMSUNG",1752).save();
       ProductQuantity pq5= new ProductQuantity(p5,150).save();
       List<ProductQuantity> productQuantityList =new ArrayList<ProductQuantity>();
       productQuantityList.add(pq5);
       Purchase pur5= new Purchase(productQuantityList);
       u5.wishlistList.add(p5);
       Assert.assertNotNull(pur5);

    }

    @After

    public void tearDown(){
        Fixtures.deleteDatabase();
    }

    @Test
    public  void testW(){

        Product p1=Product.find("byModel","JK1200").first();
        Assert.assertEquals(p1.model, "JK1200");
        ProductQuantity pq1=new ProductQuantity(p1,30);
        pq1.save();



        User u1=User.find("byUsername","Ana").first();
        Assert.assertEquals(u1.username, "Ana");
        u1.wishlistList.add(p1);


        //Find all products by Category TV,
        List<Product> products= Product.find("byCategory","TV").fetch();
        Assert.assertNotNull(products);

        //get name of a user
        User u = User.find("byEmail", "ana@gmail.com").first();

            Assert.assertNotNull(u);


        //Find all products by Brand Samsung
        List<Product> products1= Product.find("byBrand","SAMSUNG").fetch();

        //Get all products on the shopping cart (include quantity)
        User u2= User.find("byEmail","ana@gmail.com").first();
        Assert.assertNull(u.purchase);

        //Get all products in whishlist
        User u3= User.find("byEmail","ana@gmail.com").first();
        Assert.assertNotNull(u.wishlistList);


    }
}
