import java.util.ArrayList;
import java.util.Scanner;

public class StockManagementSystem {
    public static void main(String[] args) {
        System.out.println("Radhe Radhe");

        Scanner input = new Scanner(System.in);

        ArrayList<Stock> stocks = new ArrayList<>();

        int choice;

        do {
            System.out.println("1. Add stock");
            System.out.println("2. Remove stock");
            System.out.println("3. View stock");
            System.out.println("4. Exit");
            System.out.println("Enter your choice");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of stock: ");
                    String name = input.next();
                    System.out.println("Enter the stock quantity: ");
                    int quantity = input.nextInt();
                    System.out.println("Enter the stock price");
                    double price = input.nextDouble();

                    Stock newStock = new Stock(name, quantity, price);
                    stocks.add(newStock);
                    System.out.println("Stock added successfully");
                    break;

                case 2:
                    System.out.println("Enter the stock name name: ");
                    String stockName = input.next();
                    System.out.println("Enter the quantity to remove: ");
                    int removeQuantity = input.nextInt();

                    boolean stockFound = false;
                    for (Stock stock : stocks) {
                        if (stock.getName().equals(stockName)) {
                            stockFound = true;
                            stock.removeQuantity(removeQuantity);
                            System.out.println("stock removed successfully");
                            break;
                        }
                    }

                    if (!stockFound) {
                        System.out.println("Stock not found");
                    }
                    break;

                case 3:
                    System.out.println("Current display: ");
                    for (Stock stock : stocks) {
                        System.out.println(stock.toString());
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program....");
                    break;

                default:
                    System.out.println("Invalid choice, try again");
                    System.out.println("Radhe Radhe");
                    break;
            }
        } while (choice != 4);
        input.close();

    }
}

class Stock {
    private String name;
    private int quantity;
    private double price;

    public Stock(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;

    }
    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void removeQuantity(int quantityToRemove) {
        if (quantityToRemove <= quantity) {
            quantity -= quantityToRemove;
        } else {
            System.out.println("Not enough quantity to remove");
        }
    }

    public String toString() {
        return name + ", quantity: " + quantity + ", price: $" + price;
    }

}