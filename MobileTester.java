/*Design the Nokia class derived from the Mobile class so that the following output is produced.
 */

public class MobileTester { // Driver code
    public static void main(String[] args) {
        Nokia N3110 = new Nokia("N3110", true, "IMEI-102", 0);
        System.out.println(N3110);
        System.out.println("1========================");
        Nokia N1100 = new Nokia("N1100", false, "IMEI-124", 100);
        System.out.println(N1100);
        System.out.println("2========================");
        System.out.println(N3110.dialCall("88017196xxxx"));
        System.out.println("3========================");
        N3110.rechargeSIMCard(200);
        N1100.rechargeSIMCard(300);
        System.out.println("4========================");
        System.out.println(N3110.dialCall("88017196xxxx"));
        System.out.println("5========================");
        System.out.println(N1100.dialCall("45517196xxxx"));
        System.out.println("6========================");
        N1100.activateSimCard();
        System.out.println("7========================");
        System.out.println(N1100.dialCall("45517196xxxx"));
        System.out.println("8========================");
        System.out.println(N1100.dialCall("96617196xxxx"));
    }
}

// Class starts here

class Mobile { // Parent class
    public String model;
    public String IMEICode;
    public boolean simCardStatus;

    public Mobile(String model, String IMEICode, boolean simCardStatus) {
        this.model = model;
        this.IMEICode = IMEICode;
        this.simCardStatus = simCardStatus;
        System.out.println("Model " + model + " is manufactured.");
    }

    public String getCountryName(String countryCode) {
        if (countryCode.equals("880")) {
            return "Bangladesh";
        } else if (countryCode.equals("455")) {
            return "USA";
        }
        return null;
    }

    public void activateSimCard() {
        if (!simCardStatus) {
            simCardStatus = true;
            System.out.println("SIM card is activated successfully.");
        }
    }

    @Override
    public String toString() {
        return "Mobile Phone Detail:\nModel: " + model + "\nIMEICode: " + IMEICode + "\nSIM Card Status: "
                + simCardStatus;
    }
}

class Nokia extends Mobile {
    public double balance;

    public Nokia(String model, boolean sim, String imei, double balance) {
        super(model, imei, sim);
        this.balance = balance;
    }

    public String toString() {
        return super.toString() + "\nBalance: " + balance + " TK";
    }

    public String dialCall(String contact) {
        if (simCardStatus == false) {
            return "No SIM card available! Please check the SIM card connectivity.";
        }

        if (balance == 0.0) {
            return "Insufficient balance! Please recharge.";
        }

        String code = "" + contact.charAt(0) + contact.charAt(1) + contact.charAt(2);
        String country = getCountryName(code);

        if (country == null) {
            return "Dialing is not allowed in this region.";
        }

        return "Dialing the number " + contact + " to " + country + " region.";
    }

    public void activateSimCard() {
        super.activateSimCard();
    }

    public void rechargeSIMCard(int x) {
        this.balance += (double) x;
        System.out.println("Recharge successful! Current balance " + balance + " TK.");
    }
}
