/**
* @author Maxime Sotsky 3637964
*/
public class Product {
    
    /**
     * id start generating
     * permanent id for product
     * name of product
     * number of available product
     * number of ordered product
     * price of product
     */
    private  static int idStart = 10000;
    private final int id;
    private String name;
    private int numAvailable;
    private int numOrdered;
    private double price;

    /**
     * 
     * @param name - name of product
     * @param price - price of product
     * @param numAvailable - number of product available
     */

    public Product (String name, double price, int numAvailable){
        this.name = name;
        this.price = price;
        this.numAvailable = numAvailable;
        id = ++idStart;
        numOrdered = 0;
    }
    
    /**
     * Accessor method for product ID
     * 
     * @return product id
     */ 
    public int getID(){
        return this.id;
    }
    /**
     * Accessor method for number of product available
     * 
     * @return number of product available 
     */ 
    public int getNumAvailable(){
        return this.numAvailable;
    }
    /**
     * added Accessor method name (testing)
     * 
     * @return name of product for clarity when testing (print statements)
     */
    public String getName(){
        return this.name;
    }
    /**
     * added Accessor method price (testing)
     * 
     * @return price of product for clarity when testing (print statements)
     */
    public double getPrice(){
        return this.price;
    }
    /**
     * added Accessor method order (testing)
     * 
     * @return number of products ordered for clarity when testing (print statements)
     */
    public int getNumOrdered(){
        return this.numOrdered;
    }

    /**
     * Mutator method order
     * 
     * @return order - setting number of product odered
     */
    public void setNumOrdered(int order){
        this.numOrdered = order;
    }
    /**
     * Mutator method price
     * 
     * @return name of product for clarity when testing
     */
    public void setPrice(int price){
        this.price = price;
    }
    /**
     * cashing in on ordered products
     * 
     */

    public void orderReceived(){ 
        this.numAvailable = (this.numAvailable + this.numOrdered);
        this.numOrdered = 0;
    }
    /** 
     * total value of all products
     * 
     * @return sum of all products in inventory stock array
    */

    public double getTotalValue(){
        return this.numAvailable * this.price;
    }
    /**
     * selling product and decrementing amount available
     * 
     * @return true if product has been sold, false otherwise
     */
    public boolean sellProduct(){
        if(this.numAvailable == 0){
            return false;
        }
            
        else{
            this.numAvailable--;
            return true;
        }
    }
}
