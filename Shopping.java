package week8;
import java.util.*;

class Product{
    String name;
    double price;
    String type;
    Product(String name,double price,String type){
       this.name = name;
       this.price = price;
       this.type = type;
    }
    public String toString(){
        return name + " : Rs " + price +" "+ type;

    }
}
class ShoppingCart{
     LinkedList<Product>cart;
     Stack<Double>discounts;
     Vector<Product>recentlyViewed;
     ShoppingCart(){
    cart = new LinkedList<>();
    discounts = new Stack<>();
    recentlyViewed = new Vector<>();
}
    public void addProduct(Product product){
        cart.add(product);
        trackRecentlyViewed(product);
        System.out.println(product.name+" added to cart");
    }
    public void removeProduct(String name){
        Iterator<Product>iterator = cart.iterator();
        while(iterator.hasNext()){
            Product product = iterator.next();
            if(product.name.equalsIgnoreCase(name)){
                iterator.remove();
                System.out.println(name+" removed from cart");
                return;
            }
        }
        System.out.println(name+" not found in cart");
    }
    public boolean searchProduct(String name){
        for(Product product:cart){
            if(product.name.equalsIgnoreCase(name)){
                System.out.println(name+" is in the cart");
                return true;
            }
        }
        System.out.println(name+" is not in the cart");
                return false;
    }
    public void displayCart(){
        if(cart.isEmpty()){
            System.out.println("shopping cart is empty");
            return;
        }
        System.out.println("products in cart");
          for(Product product : cart){
            System.out.println(product);
          }
    }
    public void applyDiscount(double discountPercent){
        discounts.push(discountPercent);
        System.out.println("discount of "+discountPercent+"% applied");
    }
    public void checkOut(){
        if(cart.isEmpty()){
            System.out.println("shopping cart is empty");
            return;
        }
        double total = 0;
        for(Product product : cart){
            total+=product.price;
        }
        while(!discounts.isEmpty()){
            double discount = discounts.pop();
            total -= total*(discount/100);
        }
        System.out.println("total amount after discount:Rs "+total);
    }
    public void trackRecentlyViewed(Product product){
        if(recentlyViewed.size() == 5){
            recentlyViewed.remove(0);
        }
        recentlyViewed.add(product);
    }
    public void RecentlyViewed(){    
        if(recentlyViewed.isEmpty()){
            System.out.println("no recently viewed products");
            return;
        }
        System.out.println("recently viewed products");
        for(Product products: recentlyViewed){
            System.out.println(products);
        }
    }
}

public class Shopping{
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Product a = new Product("Laptop", 12000,"Electronic");
        Product b = new Product("Phone", 8000,"Electronic");
        Product c = new Product("HeadPhones", 150,"Accessories");
        Product d = new Product("SmartWatch", 2500,"Accessories");
        Product e = new Product("Tab", 15000,"Electronic");

        cart.addProduct(a);
        cart.addProduct(b);
        cart.addProduct(c);
        cart.addProduct(d);
        cart.addProduct(e);
        

        cart.displayCart();

        cart.searchProduct("Phone");
        cart.searchProduct("Charger");
        cart.removeProduct("Phone");
        cart.removeProduct("PowerBank");
        cart.displayCart();

        cart.applyDiscount(8);
        cart.applyDiscount(5);
        cart.checkOut();

        cart.RecentlyViewed();

    }
}