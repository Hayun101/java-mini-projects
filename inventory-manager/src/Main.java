import java.util.ArrayList;
import java.util.Scanner;

interface Storable {
    void addStock(int amount);
    void removeStock(int amount);
}

abstract class ItemBase {
    protected String name;
    protected int stock;

    public ItemBase(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }
}

class Product extends ItemBase implements Storable {

    public Product(String name, int stock) {
        super(name, stock);
    }

    public void addStock(int amount) {
        if (amount > 0)
            stock += amount;
    }

    public void removeStock(int amount) {
        if (amount > 0 && amount <= stock)
            stock -= amount;
    }
}

public class Main {

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("inventory-manager");
            System.out.println("1) Urun ekle");
            System.out.println("2) Stok arttir");
            System.out.println("3) Stok azalt");
            System.out.println("4) Listele");
            System.out.println("0) Cikis");
            System.out.print("Secim: ");

            String choice = sc.nextLine();

            if (choice.equals("0"))
                break;

            if (choice.equals("1")) {
                System.out.print("Urun adi: ");
                String name = sc.nextLine();
                System.out.print("Baslangic stok: ");
                int stock = Integer.parseInt(sc.nextLine());
                products.add(new Product(name, stock));
            }

            else if (choice.equals("2")) {
                list(products);
                System.out.print("Index: ");
                int i = Integer.parseInt(sc.nextLine());
                System.out.print("Miktar: ");
                int amount = Integer.parseInt(sc.nextLine());
                products.get(i).addStock(amount);
            }

            else if (choice.equals("3")) {
                list(products);
                System.out.print("Index: ");
                int i = Integer.parseInt(sc.nextLine());
                System.out.print("Miktar: ");
                int amount = Integer.parseInt(sc.nextLine());
                products.get(i).removeStock(amount);
            }

            else if (choice.equals("4")) {
                list(products);
            }

            System.out.println();
        }

        sc.close();
    }

    static void list(ArrayList<Product> products) {
        if (products.isEmpty()) {
            System.out.println("(bos)");
            return;
        }

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println(i + ") " + p.getName() + " | Stok: " + p.getStock());
        }
    }
}
