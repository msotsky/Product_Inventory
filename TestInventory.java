/**
* @author Maxime Sotsky 3637964
*/
public class TestInventory {
    
    public static void main(String[] args) {

        //Test 1 : Create some products
        System.out.println("TEST#1 : CREATING PRODUCTS . . ." + '\n');
        Product scissors = new Product("Scissors", 5.25, 20);
        Product pencil = new Product("Pencil", 0.25, 40);
        Product eraser = new Product("Eraser", 0.65, 30);
        Product pen = new Product("pen", 0.65, 4);

        //Test 2 : Add some products to the stock
        System.out.println("TEST #2 : ADDING CREATED PRODUCTS TO STOCK . . ." + '\n');
        Stock stock = new Stock(4);
        stock.add(scissors);
        stock.add(pencil);
        stock.add(eraser);
        stock.add(pen);

        //Test 3 : Try to add one too many products
        System.out.println("TEST #3 : ATTEMPTING TO ADD ONE TOO MANY PRODUCTS TO STOCK . . ." + '\n');
        Product tape = new Product("Tape", 3.05, 0);
        stock.add(tape);

        //Test 4 : Remove a product successfully
        System.out.println("TEST #4 : REMOVING A PRODUCT . . ." + '\n');
        stock.remove(eraser);

        //Test 5 : Try adding another product
        System.out.println("TEST #5 : ADDING ANOTHER PRODUCT . . ." + '\n');
        stock.add(tape);

        //Test 6 : Remove a product that doesn't exist
        System.out.println("TEST #6 : ATTEMPTING TO REMOVE PRODUCT THAT DNE . . ." + '\n');
        stock.remove(eraser);

        //Test 7 : Sell a product
        System.out.println("TEST #7 : SELLING A PRODUCT . . ." + '\n');
        stock.sell(pencil);

        //Test 8 : Try to sell a product that has no more items available.
        System.out.println("TEST #8 : ATTEMPTING TO SELL PRODUCT WITH ZERO IN STOCK . . ." + '\n');
        stock.sell(tape);

        //Test 9 : Order new products that are running low
        System.out.println("TEST #9 : ORDERING NEW PRODUCTS THAT ARE RUNNING OUT . . ." + '\n');
        stock.replenish(tape);

        //Test 10 : Display the total value of all products (properly formatted)
        System.out.println("TEST #10 : DISPLAYING TOTAL VALUE OF ALL PRODUCTS . . ." + '\n');
        stock.totalValue();

        stock.showList();
    }
}
