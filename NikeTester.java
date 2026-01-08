/*We know that Nike has opened their official outlets in Bangladesh. So let's construct a NikeBD class so that they can keep track of their inventory and sales here.
>>[Hint: Only 3 types of products are available: “Jordan”, “Cortez” and “Kobe”] */

public class NikeTester { // Driver code
    public static void main(String[] args) {
        System.out.println("==========1==========");
        NikeBD.status();
        NikeBD dhaka = new NikeBD("Dhaka Banani");
        NikeBD chittagong = new NikeBD("Chittagong GEC");
        System.out.println("==========2==========");
        dhaka.details();
        System.out.println("==========3==========");
        chittagong.details();
        System.out.println("==========4==========");
        dhaka.restockProducts("Jordan", 200);
        System.out.println("==========5==========");
        String[] products = { "Jordan", "Cortez", "Kobe" };
        int[] qty = { 1200, 200, 200 };
        String[] products2 = { "Jordan", "Cortez", "Kobe" };
        int[] qty2 = { 1200, 250, 100 };
        dhaka.restockProducts(products, qty);
        System.out.println("==========6==========");
        chittagong.restockProducts(products2, qty2);
        System.out.println("==========7==========");
        NikeBD.status();
        System.out.println("==========8==========");
        dhaka.details();
        System.out.println("==========9==========");
        chittagong.details();
        dhaka.productSold("Jordan", 760, "Cortez", 90);
        chittagong.productSold("Jordan", 520, "Kobe", 70);
        System.out.println("==========10==========");
        NikeBD.status();
        System.out.println("==========11==========");
        chittagong.details();

    }
}

// Class starts here

class NikeBD {
    public static int total_branch;
    public static int total_sold;
    public static int[] stock = new int[3];
    public static int count_stock;

    public String branch;
    public int[] branchStock = new int[3];
    public int branchSold;

    public static void status() {
        System.out.println("Nike Bangladesh Status: ");
        System.out.println("Branches Opened: " + total_branch);
        System.out.println("Currently Stocked: Jordan: " + stock[0] + ", Cortez: " + stock[1] + ", Kobe: " + stock[2]);
        System.out.println("Sold: " + total_sold);
    }

    public NikeBD(String name) {
        this.branch = name;
        total_branch++;
    }

    public void details() {
        System.out.println("Nike " + branch + " outlet: ");
        System.out.println("Products Currently Stocked: Jordan: " + branchStock[0] + ", Cortez: " + branchStock[1]
                + ", Kobe: " + branchStock[2]);
        System.out.println("Sold: " + branchSold);
    }

    public void restockProducts(String name, int quantity) {
        if (name.equals("Jordan")) {
            branchStock[0] += quantity;
            stock[0] += quantity;
        } else if (name.equals("Cortez")) {
            branchStock[1] += quantity;
            stock[1] += quantity;
        } else if (name.equals("Kobe")) {
            branchStock[2] += quantity;
            stock[2] += quantity;
        }
    }

    public void restockProducts(String[] products, int[] quantity) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].equals("Jordan")) {
                branchStock[0] += quantity[i];
                stock[0] += quantity[i];
            } else if (products[i].equals("Cortez")) {
                branchStock[1] += quantity[i];
                stock[1] += quantity[i];
            } else if (products[i].equals("Kobe")) {
                branchStock[2] += quantity[i];
                stock[2] += quantity[i];
            }
        }
    }

    public void productSold(String name1, int quantity1, String name2, int quantity2) {
        if (name1.equals("Jordan")) {
            branchStock[0] -= quantity1;
            stock[0] -= quantity1;
            branchSold += quantity1;
        } else if (name1.equals("Cortez")) {
            branchStock[1] -= quantity1;
            stock[1] -= quantity1;
            branchSold += quantity1;
        } else if (name1.equals("Kobe")) {
            branchStock[2] -= quantity1;
            stock[2] -= quantity1;
            branchSold += quantity1;
        }

        total_sold += quantity1;

        if (name2.equals("Jordan")) {
            branchStock[0] -= quantity2;
            stock[0] -= quantity2;
            branchSold += quantity2;

        } else if (name2.equals("Cortez")) {
            branchStock[1] -= quantity2;
            stock[1] -= quantity2;
            branchSold += quantity2;

        } else if (name2.equals("Kobe")) {
            branchStock[2] -= quantity2;
            stock[2] -= quantity2;
            branchSold += quantity2;

        }

        total_sold += quantity2;

    }

}
