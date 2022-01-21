/**
* @author Maxime Sotsky 3637964
*/
import java.text.NumberFormat;

public class Stock {

    /**
     * maximum capacity of array inventory
     * number of product stored in array inventory
     * product array (inventory)
     */
    private int maxProduct;
    private int numProducts;
    private Product[] productList;

    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    
    /**
    *
    * stock constructor
    *
    * @param maxProduct - size of productList array
    */

    public Stock(int maxProduct){
        this.maxProduct = maxProduct;
        productList = new Product[maxProduct];
        numProducts = -1;   //empty
    }

    /**
    *
    * adds product to stock
    *
    * @param p - product added to stock
    * @return success or failure of product added to inventory stock array
    */
    public boolean add(Product p){

       if(productList[maxProduct-1] != null){
            System.out.println("Stock capacity is full.");
            return false;
       }
        
        for(int i = 0; i < productList.length && productList[i] != null; i++){
            if(p.getID() == productList[i].getID()){
                System.out.println("Product: " + p.getID() + " ( "+ p.getName() + " ) " + " already exists in the inventory.");
                return false;
            }  
        }
        numProducts++;
        productList[numProducts] = p;
        System.out.println("Product: " + p.getID() + " ( "+ p.getName() + " ) " + " has been added to the inventory");
        return true;
    }

    /**
    *
    * sells product
    *
    * @param p -product sold from inventory stock
    * @return success of failure of selling a product from inventory stock array
    */
    public boolean sell(Product p){
        boolean sold = true;
        if(productList[0] == null){
            System.out.println("There are no products in stock.");
            return false;
        }
        for(int i = 0; i < productList.length; i++){ 
            if(productList[i].getID() == p.getID()){
                sold = productList[i].sellProduct();
                if(sold){
                    System.out.println("Product: " + p.getID() + " ( " + p.getName() + " ) " + "SOLD!");
                    return true;
                }else{
                    System.out.println("Product " + p.getID() + " ( " + p.getName() + " ) " + "is out of stock.");
                    return false;
                }
            }
        }
        System.out.println("Product not found.");
        return false;
    }

    /**
    *
    * remove product from stock
    *
    * @param p - product to be removed from inventory stock array
    * @return success or failure of product removed from inventory stock array
    */
    public boolean remove(Product p){
        if(productList.length == 0 || productList[0] == null){
            System.out.println("Stock is empty.");
            return false;
        }
        for(int i = 0; i < productList.length && productList[i] != null;i++){
            if(productList[i].getID() == p.getID()){
                //shift elements so that null values are on right side
                for(int j = productList.length -1; j >= 0;j--){ 
                    if(productList[j] != null){
                        productList[i] = productList[j];
                        productList[j] = null;
                        numProducts--;
                        System.out.println("Product: " + p.getID() + " ( "+ p.getName() + " ) " + " has been removed from the inventory");
                        return true;
                    }
                }
            }
        }
        System.out.println("Product: " + p.getID() + " ( "+ p.getName() + " ) " +" does not exists");
        return false;
    }

    /**
    *
    * orders products if there are > 5
    *
    * @param p - determine whether this product is running low
    * @return true or false whether it has been replenished (incremented by 10)
    */
    public boolean replenish(Product p){
        if(p.getNumAvailable() < 5){
            p.setNumOrdered(10);
            return true;
        }
        return false;
    }

    /**
    *
    * adds all the prices of the products together
    *
    * @return sum of all products in inventory stock array
    */
    public double totalValue(){
        double total = 0;
        for(Product x : productList){
            total += x.getTotalValue();
        }
        System.out.println("Total value of stock: " + fmt.format(total));
        return total;
    }

    /**
    *
    * displays products in a tabular manner
    *
    */
    public void showList(){
        for(int i = 0; i < productList.length && productList[i] != null; i++){
            //printf used to prevent table from being distorted when product name length >= 8 (TAB)
            System.out.printf((productList[i].getName().length() < 8)? productList[i].getName() + "\t\t" : productList[i].getName() + "\t");
            System.out.println(
                "(id: " + productList[i].getID() + ")" + "\t"
                + "qty: " + productList[i].getNumAvailable() + "   \t"
                + productList[i].getNumOrdered() + " ordered" + "\t"
                + fmt.format(productList[i].getPrice()));
        }
    }
}
