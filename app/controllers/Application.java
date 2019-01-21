package controllers;
import org.junit.experimental.categories.Categories;
import play.*;
import play.jobs.OnApplicationStart;
import play.mvc.*;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import javax.jws.soap.SOAPBinding;
import models.*;




public class Application extends Controller {

    public static void index() {
        render(); //Busca un fichero que teng el mismo nombre de index con un formato HTML


    }


public static void initProducts() { //Función para la web ya que tenemos inicializado el initial-data.yml

        Product p1= new Product("TV","LG1","LG",400,"1234").save();
        Product p2= new Product("TV","45","LG",500,"1234").save();
        Product p3= new Product("TV","50","LG",600,"1234").save();
        Product p4= new Product("TV","55","LG",700,"1234").save();
        Product p5= new Product("TV","60","LG",800,"1234").save();
        Product p6= new Product("TV","65","LG",900,"1234").save();

        Product p7= new Product("TV","40","SAMSUNG",400,"1234").save();
        Product p8= new Product("TV","45","SAMSUNG",500,"1234").save();
        Product p9= new Product("TV","50","SAMSUNG",600,"1234").save();
        Product p10= new Product("TV","55","SAMSUNG",700,"1234").save();
        Product p11= new Product("TV","60","SAMSUNG",800,"1234").save();
        Product p12= new Product("TV","65","SAMSUNG",900,"1234").save();

        Product p13= new Product("TV","40","SONY",400,"1234").save();
        Product p14= new Product("TV","45","SONY",500,"1234").save();
        Product p15= new Product("TV","50","SONY",600,"1234").save();
        Product p16= new Product("TV","55","SONY",700,"1234").save();
        Product p17= new Product("TV","60","SONY",800,"1234").save();
        Product p18= new Product("TV","65","SONY",900,"1234").save();

        Product p19= new Product("SMARTPHONE","S4","SAMSUNG",400,"1234").save();
        Product p20= new Product("SMARTPHONE","S1","SAMSUNG",500,"1234").save();
        Product p21= new Product("SMARTPHONE","S2","SAMSUNG",600,"1234").save();
        Product p22= new Product("SMARTPHONE","S3","SAMSUNG",700,"1234").save();
        Product p23= new Product("SMARTPHONE","S4","SAMSUNG",800,"1234").save();
        Product p24= new Product("SMARTPHONE","S5","SAMSUNG",900,"1234").save();

        Product p25= new Product("SMARTPHONE","4S","APPLE",600,"1234").save();
        Product p26= new Product("SMARTPHONE","5S","APPLE",700,"").save();
        Product p27= new Product("SMARTPHONE","6S","APPLE",800,"1234").save();
        Product p28= new Product("SMARTPHONE","XS","APPLE",900,"1234").save();
        Product p29= new Product("SMARTPHONE","XR","APPLE",1000,"1234").save();

        Product p30= new Product("PRINTER","ENVY","HP",160,"1234").save();
        Product p31= new Product("PRINTER","OFFICE JET","HP",200,"1234").save();
        Product p32= new Product("PRINTER","OFFICE JET PRO","HP",245,"1234").save();
        Product p33= new Product("PRINTER","OFFICE","CANON",200,"1234").save();
        Product p34= new Product("PRINTER","OFFICE JET","CANON",250,"1234").save();
        Product p35= new Product("PRINTER","OFFICE JET PRO","CANON",272,"1234").save();

        ProductQuantity productQuantity1=new ProductQuantity(p1,5).save();
        ProductQuantity productQuantity2=new ProductQuantity(p2,5).save();
        ProductQuantity productQuantity3=new ProductQuantity(p3,5).save();
        ProductQuantity productQuantity4=new ProductQuantity(p4,5).save();
        ProductQuantity productQuantity5=new ProductQuantity(p5,5).save();
        ProductQuantity productQuantity6=new ProductQuantity(p6,5).save();
        ProductQuantity productQuantity7=new ProductQuantity(p7,5).save();
        ProductQuantity productQuantity8=new ProductQuantity(p8,5).save();
        ProductQuantity productQuantity9=new ProductQuantity(p9,5).save();
        ProductQuantity productQuantity10=new ProductQuantity(p10,5).save();
        ProductQuantity productQuantity11=new ProductQuantity(p11,5).save();
        ProductQuantity productQuantity12=new ProductQuantity(p12,5).save();
        ProductQuantity productQuantity13=new ProductQuantity(p13,5).save();
        ProductQuantity productQuantity14=new ProductQuantity(p14,5).save();
        ProductQuantity productQuantity15=new ProductQuantity(p15,5).save();
        ProductQuantity productQuantity16=new ProductQuantity(p16,5).save();
        ProductQuantity productQuantity17=new ProductQuantity(p17,5).save();
        ProductQuantity productQuantity18=new ProductQuantity(p18,5).save();
        ProductQuantity productQuantity19=new ProductQuantity(p19,5).save();
        ProductQuantity productQuantity20=new ProductQuantity(p20,5).save();
        ProductQuantity productQuantity21=new ProductQuantity(p21,5).save();
        ProductQuantity productQuantity22=new ProductQuantity(p22,5).save();
        ProductQuantity productQuantity23=new ProductQuantity(p23,5).save();
        ProductQuantity productQuantity24=new ProductQuantity(p24,5).save();
        ProductQuantity productQuantity25=new ProductQuantity(p25,5).save();
        ProductQuantity productQuantity26=new ProductQuantity(p26,5).save();
        ProductQuantity productQuantity27=new ProductQuantity(p27,5).save();
        ProductQuantity productQuantity28=new ProductQuantity(p28,5).save();
        ProductQuantity productQuantity29=new ProductQuantity(p29,5).save();
        ProductQuantity productQuantity30=new ProductQuantity(p30,5).save();
        ProductQuantity productQuantity31=new ProductQuantity(p31,5).save();
        ProductQuantity productQuantity32=new ProductQuantity(p32,5).save();
        ProductQuantity productQuantity33=new ProductQuantity(p33,5).save();
        ProductQuantity productQuantity34=new ProductQuantity(p34,5).save();
        ProductQuantity productQuantity35=new ProductQuantity(p35,5).save();

        renderTemplate("Application/shoppingPage.html");
    }

    //Pagina inicial de web
    public static void loadPage(int i){
            if (i==1)
            renderTemplate("Application/login.html");
        else
            renderTemplate("Application/register.html");
        render();
    }
    //Registro web
    public static void register(String username,String email,String password){
        if( email.contains("@")==true) {
            User u = User.find("byUsernameAndEmail",username,email).first();
            if (u == null) {
                User user = new User(username, email, password).save();
                user.save();
                renderTemplate("Application/shoppingPage.html");
            } else {
                String message ="Sorry you are registered";
                renderText(message);
            }
        }
        else
        {
            renderText("Email parameter isn't correct");
        }
    }
    //Registro App
    public static void registerM(String username,String email,String password){
        if( email.contains("@")==true) {
            User u = User.find("byUsername",username).first();
            if (u == null) {
                User user = new User(username, email, password).save();
                user.save();
                renderText("Congratulations! You've been registered correctly");
            } else {
                String message ="Sorry you are registered";
                renderText(message);
            }
        }
        else
        {
            renderText("Email parameter isn't correct");
        }

    }
    //Login web
    public static void login(String username,String password){
        User user = User.find("byUsernameAndPassword",username,password).first();
        if (user!=null)
        {
            if (username=="admin"&password=="admin")
            {
                renderText("Welcome ADMIN " );
            }
            else {

                renderTemplate("Application/shoppingPage.html");
                renderText("Welcome " + user.username);
            }
        }
        else
        {
            renderText("Sorry you are not registered");
        }

    }
    //Login App
    public static void loginM(String username,String password){
        User user = User.find("byUsernameAndPassword",username,password).first();
        if (user!=null)
        {

            renderText("Welcome "+ user.username);
        }
        else
        {
            renderText("Sorry you are not registered ");
        }

    }

    //Mostrar imagenes
    public static void showCategoryImage(String category){
        Product p = Product.find("byCategory",category).first();
        try {
            if (p != null) {
                File imagen = new File("./documentation/images/categories/" + category + ".png");
                response.setContentTypeIfNotSet("image/png");
                renderBinary(imagen);
            }
        }
        catch (Exception e){

        }
    }
    public static void showBrandImage(String brand){
        Product p = Product.find("byBrand",brand).first();
        try {
            if (p != null) {
                File image = new File("./documentation/images/brands/"+brand+".png");
                response.setContentTypeIfNotSet("image/png");
                renderBinary(image);
            }
            else
                renderText("OK");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void showProductImage(String model){
        Product p = Product.find("byModel",model).first();
        try {
            if (p != null) {
                File image = new File("./documentation/images/products/" + model+ ".jpg");
                response.setContentTypeIfNotSet("image/jpg");
                renderBinary(image);
            }
        }
        catch (Exception e){
        }
    }


    //Obtener datos de usuario
    public static void getName(String email){
        User u = User.find("byEmail", email).first();
        if(u == null){
            renderText("Error");
        }
        renderText("Yor username is: "+u.username + "");
    }
    public static void getUser(String username){
        User u=User.find("byUsername",username).first();
        renderJSON(u);
    }


    //Find categories (para saber cuántas categorias tenemos)
    public  static  void findCategories(){
        List<String> categories = new ArrayList<>();
        List<Product> productList = Product.findAll();
        for (int i=0;i<productList.size();i++){
            categories.add(productList.get(i).category);
        }
        renderJSON(categories.stream().distinct().collect(Collectors.toList()));
    }
    //Find brands (para saber cuántas marcas tenemos)
    public  static  void findBrands(){
        List<String> brands = new ArrayList<>();
        List<Product> productList = Product.findAll();
        for (int i=0;i<productList.size();i++){
            brands.add(productList.get(i).brand);
        }
        renderJSON(brands.stream().distinct().collect(Collectors.toList()));
    }
    //Find all products by Category TV,Smartphone... (crear una lista de productos de determinada categoria)
    public static void findByCategories(String category){
        List<Product> products= Product.find("byCategory",category).fetch();
        if(products!=null) {
            renderJSON(products);
        }
        else
            renderText("Please try again we haven't found: '" +category+"'");
    }
    //Find all products by Brand Samsung, Apple...(crear una lista de productos de determinada marca)
    public static void findByBrand(String brand){
        List<Product> products= Product.find("byBrand",brand).fetch();
        if(products!=null) {
            renderJSON(products);
        }
        else
            renderText("Please try again we haven't found: '" +brand+"'");
    }
    //Find product by model
    public  static void findProduct(String model){
        Product product=Product.find("byModel",model).first();
        if(product!=null) {
            renderJSON(product);
        }
        else
            renderText("Please try again we haven't found: '" +product+"'");
    }


    //Aquí tenemos lo relacionado con la wishlist y el carrito(purchase)
    //Obtener todos los productos del carrito
    public static void getPurchase( String username){
        User u= User.find("byUsername",username).first();
        Purchase purchase =Purchase.find("byUserP",u).first();
       renderJSON(purchase.productQuantityList);
    }
    //Obtener todos los productos de la wishlist
    public static void getWishList(String username){
        User u= User.find("byUsername",username).first();
        renderJSON(u.wishlistList);
    }
    //Añadir productos a la wishlist
    public static void addWishlist(String username,String model){
        User u = User.find("byUsername",username).first();
        Product product=Product.find("byModel",model).first();
        u.wishlistList.add(product);
        u.save();
        renderText("ok");

    }
    //Añadir productos al carrito
    public static void addPurchase(String username, String model, int quantity){
        User u = User.find("byUsername",username).first();
       //Introduzco el producto seleccionado y la cantidad
        Product product1= Product.find("byModel",model).first();
        ProductQuantity productQuantity = new ProductQuantity(product1,quantity);
         Purchase purchase = Purchase.find("byUserP",u).first();
        productQuantity.save();
         if(purchase!= null) {
             purchase.productQuantityList.add(productQuantity);

             purchase.save();
         }
         else
         {
             Purchase purchase1=new Purchase(u);
             purchase1.productQuantityList.add(productQuantity);
             purchase1.save();
         }
         renderText("ok");
    }
    //Obtener el precio de los productos(Funcion finalmente no impleentada)
    public static void getPriceOfPurchase(String username){
        User u = User.find("byUsername",username).first();
        Purchase purchase = Purchase.find("byUserP",u).first();

        if (purchase!=null)
        {
            double price=0;
            for(int i=0; i<purchase.productQuantityList.size();i++) {
                price = price + (purchase.productQuantityList.get(i).product.price*purchase.productQuantityList.get(i).quantity);
            }
            renderText(price);
        }
        else
        {
            renderText("Your shopping cart is empty");
        }
    }
}