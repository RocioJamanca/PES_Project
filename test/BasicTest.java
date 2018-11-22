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
       Purchase pur5= new Purchase(u5);
       pur5.productQuantityList.size();
       Assert.assertNotNull(pur5.productQuantityList);
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
        Assert.assertNull(u2.purchase);

        //Get all products in whishlist
        User u3= User.find("byEmail","ana@gmail.com").first();
        Assert.assertNotNull(u.wishlistList);

        //Add to shoping cart
        String email="ana@gmail.com";
        Product p4= new Product("SAMSUNG","MODEL","BRAND",1582);
        User u4 = User.find("byEmail",email).first();
        ProductQuantity productQuantity = new ProductQuantity(p4,78);
        Purchase pur= new Purchase(u4);
        pur.productQuantityList.add(productQuantity);

      //Get price
        Purchase purchase2 = Purchase.find("byUserP",u4).first();

        if (purchase2!=null)
        {
            double price=0;
            for(int i=0; i<purchase2.productQuantityList.size();i++) {
                price = price + (purchase2.productQuantityList.get(i).product.price*purchase2.productQuantityList.get(i).quantity);

            }
        }


    }
}
