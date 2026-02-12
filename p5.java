import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Loan {
    void takeLoan(Double amt) throws Exception;
    Double checkLimit();
    Double loanLimit();
}

abstract class Customer implements Loan {
    protected String id;
    protected String name;
    protected Double loan;
    protected String phnNo;

    public Customer(String id) {
        this.id = id;
        this.loan = 0.0;
        this.name = "";
        this.phnNo = "";
    }

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        this.loan = 0.0;
        this.phnNo = "";
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phn) {
        this.phnNo = phn;
    }

    public Double getLoan() {
        return loan;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}

class NCustomer extends Customer {
    protected static final Double CREDL = 10000.0;

    public NCustomer(String id) {
        super(id);
    }

    public NCustomer(String id, String name) {
        super(id, name);
    }

    @Override
    public void takeLoan(Double amt) throws Exception {
        if (amt + loan > CREDL)
            throw new Exception("Amount is exceeding Credit Limit");
        loan += amt;
    }

    @Override
    public Double checkLimit() {
        return CREDL;
    }

    @Override
    public Double loanLimit() {
        return CREDL - loan;
    }
}

class PCustomer extends Customer {
    protected static final Double CREDL = 50000.0;

    public PCustomer(String id) {
        super(id);
    }

    public PCustomer(String id, String name) {
        super(id, name);
    }

    @Override
    public void takeLoan(Double amt) throws Exception {
        if (amt + loan > CREDL)
            throw new Exception("Amount is exceeding Credit Limit");
        loan += amt;
    }

    @Override
    public Double checkLimit() {
        return CREDL;
    }

    @Override
    public Double loanLimit() {
        return CREDL - loan;
    }
}

public class p5 {

    public static void main(String[] args) {
        List<NCustomer> nCustomers = new ArrayList<>();
        List<PCustomer> pCustomers = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            String n;
            do {
                Thread.sleep(100);
                banner();
                enter();
                n = sc.nextLine();

                switch (n) {
                    case "1" -> handleNormal(sc, nCustomers);
                    case "2" -> handlePrivileged(sc, pCustomers);
                    case "3" -> System.out.println("Exiting...");
                    default -> System.out.println("Not A Proper Choice");
                }
            } while (!n.equals("3"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void handleNormal(Scanner sc, List<NCustomer> list) throws Exception {
        String k;
        do {
            Thread.sleep(100);
            menu();
            enter();
            k = sc.nextLine();

            switch (k) {
                case "1" -> {
                    enterID();
                    String id = sc.nextLine();
                    list.add(new NCustomer(id));
                }
                case "2" -> {
                    enterName();
                    String id = sc.next();
                    String name = sc.next();
                    sc.nextLine();
                    list.add(new NCustomer(id, name));
                }
                case "3" -> manageAccount(sc, list);
                case "4" -> {}
                default -> System.out.println("Enter A Correct Choice");
            }
        } while (!k.equals("4"));
    }

    private static void handlePrivileged(Scanner sc, List<PCustomer> list) throws Exception {
        String k;
        do {
            Thread.sleep(100);
            menu();
            enter();
            k = sc.nextLine();

            switch (k) {
                case "1" -> {
                    enterID();
                    String id = sc.nextLine();
                    list.add(new PCustomer(id));
                }
                case "2" -> {
                    enterName();
                    String id = sc.next();
                    String name = sc.next();
                    sc.nextLine();
                    list.add(new PCustomer(id, name));
                }
                case "3" -> manageAccount(sc, list);
                case "4" -> {}
                default -> System.out.println("Enter A Correct Choice");
            }
        } while (!k.equals("4"));
    }

    private static <T extends Customer> void manageAccount(Scanner sc, List<T> list) throws Exception {
        enterID();
        String id = sc.nextLine();

        T curr = list.stream()
                .filter(c -> id.equals(c.getId()))
                .findFirst()
                .orElse(null);

        if (curr == null) {
            System.out.println("No Customer Found");
            return;
        }

        String l;
        do {
            Thread.sleep(100);
            account();
            enter();
            l = sc.nextLine();

            switch (l) {
                case "1" -> {
                    System.out.println("Details");
                    System.out.println(curr);
                }
                case "2" -> {
                    System.out.println("Loan");
                    System.out.println(curr.getLoan());
                }
                case "3" -> {
                    System.out.println("Credit Limit");
                    System.out.println(curr.checkLimit());
                }
                case "4" -> {
                    System.out.println("Remaining Loan");
                    System.out.println(curr.loanLimit());
                }
                case "5" -> {
                    System.out.println("Enter Loan Amount Less Than " + curr.loanLimit() + " : ");
                    Double loan = sc.nextDouble();
                    sc.nextLine();
                    curr.takeLoan(loan);
                    System.out.println("Loan Processed");
                }
                case "6" -> {
                    System.out.println("Enter Name : ");
                    String name = sc.nextLine();
                    curr.setName(name);
                    System.out.println("Details Updated");
                }
                case "7" -> {
                    System.out.println("Enter Phone Number : ");
                    String phn = sc.nextLine();
                    curr.setPhone(phn);
                    System.out.println("Details Updated");
                }
                case "8" -> {}
                default -> System.out.println("Enter A Correct Choice");
            }
        } while (!l.equals("8"));
    }

    public static void banner() {
        System.out.println("Menu Of The Bank");
        System.out.println("Press 1. For Entering as a Normal Customer");
        System.out.println("Press 2. For Entering as a Privileged Customer");
        System.out.println("Press 3. To Exit");
    }

    public static void menu() {
        System.out.println("Press 1. To Open Account by ID");
        System.out.println("Press 2. To Open Account by ID and Name");
        System.out.println("Press 3. To Edit An Existing Account or get Details");
        System.out.println("Press 4. To Return to Main Menu");
    }

    public static void account() {
        System.out.println("Press 1. To Show Details");
        System.out.println("Press 2. To Check Loan Amount");
        System.out.println("Press 3. To Check Credit Limit");
        System.out.println("Press 4. To Check Remaining Loan Limit");
        System.out.println("Press 5. To Take Loan");
        System.out.println("Press 6. To Change Name");
        System.out.println("Press 7. To Change Phone Number");
        System.out.println("Press 8. To Return");
    }

    public static void enter() {
        System.out.print("Enter Your Choice : ");
    }

    public static void enterID() {
        System.out.print("Enter ID : ");
    }

    public static void enterName() {
        System.out.print("Enter ID and Name : ");
    }
}
