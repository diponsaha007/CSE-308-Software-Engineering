import java.util.ArrayList;
import java.util.Scanner;

class Account {
    protected String name;
    protected int balance;
    protected int loan;
    protected int year;
    protected int req_loan;
    protected String type;

    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.loan = 0;
        this.year = 0;
        this.req_loan = 0;
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println (amount + "$ deposited.");
        query ();
    }

    public void withdraw(int amount) {
        if (balance < amount) {
            System.out.println ("Invalid transaction!");
            query ();
            return;
        }
        balance -= amount;
        System.out.println (amount + "$ withdrawn.");
        query ();
    }

    public void request_loan(int amount) {
        req_loan += amount;
        System.out.println ("Loan request successful, sent for approval.");
    }

    public void query() {
        System.out.println ("Current balance, " + balance + "$ Loan " + loan + "$");
    }

    public void increment(double interest_rate) {
        balance = (int) (balance * (1 + interest_rate / 100.0) - loan * (0.1));
        year++;
    }
}

class Savings extends Account {

    public Savings(String name, int balance) {
        super (name, balance);
        super.type = "Savings";
        System.out.println ("Savings account for " + name + " created. Initial balance " + balance + "$");
    }

    @Override
    public void withdraw(int amount) {
        if (balance - amount < 1000) {
            System.out.println ("Invalid transaction!");
            super.query ();
            return;
        }
        super.withdraw (amount);
    }

    @Override
    public void request_loan(int amount) {
        if (amount > 10000) {
            System.out.println ("Invalid transaction!");
            super.query ();
            return;
        }
        super.request_loan (amount);
    }

    @Override
    public void increment(double interest_rate) {
        super.increment (interest_rate);
        balance -= 500;
    }
}

class Student extends Account {
    public Student(String name, int balance) {
        super (name, balance);
        super.type = "Student";
        System.out.println ("Student account for " + name + " created. Initial balance " + balance + "$");
    }

    @Override
    public void withdraw(int amount) {
        if (amount > 10000) {
            System.out.println ("Invalid transaction!");
            super.query ();
            return;
        }
        super.withdraw (amount);
    }

    @Override
    public void request_loan(int amount) {
        if (amount > 1000) {
            return;
        }
        super.request_loan (amount);
    }
}

class Fixed extends Account {
    public Fixed(String name, int balance) {
        super (name, balance);
        super.type = "Fixed";
        assert (balance >= 100000);
        System.out.println ("Fixed deposit account for " + name + " created. Initial balance " + balance + "$");
    }

    @Override
    public void deposit(int amount) {
        if (amount < 50000) {
            System.out.println ("Invalid transaction!");
            super.query ();
            return;
        }
        super.deposit (amount);
    }

    @Override
    public void withdraw(int amount) {
        if (year < 1) {
            System.out.println ("Invalid transaction!");
            super.query ();
            return;
        }
        super.withdraw (amount);
    }

    @Override
    public void request_loan(int amount) {
        if (amount > 100000) {
            System.out.println ("Invalid transaction!");
            super.query ();
            return;
        }
        super.request_loan (amount);
    }

    @Override
    public void increment(double interest_rate) {
        super.increment (interest_rate);
        balance -= 500;
    }
}

class Cashier {
    public void lookup(Account ac) {
        System.out.println ("Account name : " + ac.name + ".");
        ac.query ();
    }

    public void approve_loan(Bank bank) {
        System.out.println ("You don’t have permission for this operation.");
    }

    public void change_interest_rate(Bank bank, String type, double amount) {
        System.out.println ("You don’t have permission for this operation.");
    }

    void see_internal_fund(Bank bank) {
        System.out.println ("You don’t have permission for this operation.");
    }
}

class Officer extends Cashier {
    @Override
    public void approve_loan(Bank bank) {
        for (int i = 0; i < bank.accounts.size (); i++) {
            if (bank.accounts.get (i).req_loan == 0)
                continue;
            if (bank.getInternal_fund () < bank.accounts.get (i).req_loan) {
                System.out.println ("Cannot approve loan for " + bank.accounts.get (i).name + " due to shortage of money.");
                continue;
            }
            bank.accounts.get (i).balance += bank.accounts.get (i).req_loan;
            bank.accounts.get (i).loan += bank.accounts.get (i).req_loan;
            bank.setInternal_fund (bank.getInternal_fund () - bank.accounts.get (i).req_loan);
            bank.accounts.get (i).req_loan = 0;
            System.out.println ("Approved loan for " + bank.accounts.get (i).name);
        }
    }
}

class ManagingDirector extends Officer {
    @Override
    public void change_interest_rate(Bank bank, String type, double amount) {
        if (type.equals ("Student")) {
            bank.setStudent_interest (amount);
            System.out.println ("Student interest changed to " + amount);
        }
        else if (type.equals ("Savings")) {
            bank.setSavings_interest (amount);
            System.out.println ("Savings interest changed to " + amount);
        }
        else if (type.equals ("Fixed")) {
            bank.setFixed_interest (amount);
            System.out.println ("Fixed Deposit interest changed to " + amount);
        }
        else {
            System.out.println ("Invalid type.");
        }
    }

    @Override
    void see_internal_fund(Bank bank) {
        System.out.println ("Current internal fund " + bank.getInternal_fund ());
    }
}

class Bank {
    protected ArrayList<Account> accounts;
    private Cashier md;
    private Cashier[] officers;
    private Cashier[] cashiers;
    private int internal_fund;
    private int year;
    private double student_interest;
    private double savings_interest;
    private double fixed_interest;

    public Bank() {
        accounts = new ArrayList<> ();
        md = new ManagingDirector ();
        officers = new Officer[2];
        for (int i = 0; i < 2; i++) {
            officers[i] = new Officer ();
        }
        cashiers = new Cashier[5];
        for (int i = 0; i < 5; i++) {
            cashiers[i] = new Cashier ();
        }
        internal_fund = 1000000;
        year = 0;
        student_interest = 5;
        savings_interest = 10;
        fixed_interest = 15;
        System.out.println ("Bank Created; MD, O1, O2, C1, C2, C3, C4, C5 created.");
    }

    public void create_account(String name, String type, int amount) {
        for (Account ac : accounts) {
            if (ac.name.equals (name)) {
                System.out.println ("Can not create account. This name already exists!");
                return;
            }
        }
        Account ac;
        if (type.equals ("Student")) {
            ac = new Student (name, amount);
        }
        else if (type.equals ("Savings")) {
            ac = new Savings (name, amount);
        }
        else if (type.equals ("Fixed")) {
            if (amount < 100000) {
                System.out.println ("Not enough balance to open fixed deposit account.");
                return;
            }
            ac = new Fixed (name, amount);
        }
        else {
            System.out.println ("Invalid account type.");
            return;
        }
        accounts.add (ac);
        query_on_account (accounts.get (accounts.size () - 1));
    }

    public void increment() {
        year++;
        for (Account ac : accounts) {
            if (ac.type.equals ("Student")) {
                ac.increment (student_interest);
            }
            else if (ac.type.equals ("Savings")) {
                ac.increment (savings_interest);
            }
            else {
                ac.increment (fixed_interest);
            }
        }
        System.out.println ("1 year passed.");
    }

    private boolean check_loans_for_approval() {
        for (Account ac : accounts) {
            if (ac.req_loan > 0) {
                return true;
            }
        }
        return false;
    }

    public void open(String name) {
        for (Account ac : accounts) {
            if (ac.name.equals (name)) {
                System.out.println ("Welcome Back " + name);
                query_on_account (ac);
                return;
            }
        }
        //Not a account then must be employee
        if (name.equals ("MD")) {
            System.out.println (name + " active.");
            if (check_loans_for_approval ()) {
                System.out.println ("There are loan approvals pending.");
            }
            query_on_cashier (md);
            return;
        }

        char c = name.charAt (1);
        int idx = Integer.parseInt (String.valueOf (c));
        idx--;
        if (name.charAt (0) == 'O') {
            System.out.println (name + " active.");
            if (check_loans_for_approval ()) {
                System.out.println ("There are loan approvals pending.");
            }
            query_on_cashier (officers[idx]);
        }
        else if (name.charAt (0) == 'C') {
            System.out.println (name + " active.");
            query_on_cashier (cashiers[idx]);
        }
        else {
            System.out.println ("Invalid Command.");
        }


    }

    public void query_on_cashier(Cashier c) {
        String flag;
        Scanner sc = new Scanner (System.in);
        while (true) {
            flag = sc.next ();
            if (flag.equals ("Lookup")) {
                String name = sc.next ();
                boolean f = false;
                for (Account ac : accounts) {
                    if (ac.name.equals (name)) {
                        c.lookup (ac);
                        f = true;
                        break;
                    }
                }
                if (!f) {
                    System.out.println ("Account not found!");
                }
            }
            else if (flag.equals ("Approve")) {
                String tmp = sc.next ();
                c.approve_loan (this);
            }
            else if (flag.equals ("Change")) {
                String type = sc.next ();
                double amount = sc.nextDouble ();
                c.change_interest_rate (this, type, amount);
            }
            else if (flag.equals ("See")) {
                c.see_internal_fund (this);
            }
            else if (flag.equals ("Close")) {
                System.out.println ("Logged out!");
                break;
            }
            else {
                System.out.println ("Invalid command!");
            }

        }
    }

    public void query_on_account(Account account) {
        String flag;
        Scanner sc = new Scanner (System.in);
        while (true) {
            flag = sc.next ();
            if (flag.equals ("Deposit")) {
                int amount = sc.nextInt ();
                account.deposit (amount);
            }
            else if (flag.equals ("Withdraw")) {
                int amount = sc.nextInt ();
                account.withdraw (amount);
            }
            else if (flag.equals ("Query")) {
                account.query ();
            }
            else if (flag.equals ("Request")) {
                int amount = sc.nextInt ();
                account.request_loan (amount);
            }
            else if (flag.equals ("Close")) {
                System.out.println ("Transaction Closed.");
                break;
            }
            else {
                System.out.println ("Invalid command!");
            }
        }
    }

    public double getStudent_interest() {
        return student_interest;
    }

    public void setStudent_interest(double student_interest) {
        this.student_interest = student_interest;
    }

    public double getSavings_interest() {
        return savings_interest;
    }

    public void setSavings_interest(double savings_interest) {
        this.savings_interest = savings_interest;
    }

    public double getFixed_interest() {
        return fixed_interest;
    }

    public void setFixed_interest(double fixed_interest) {
        this.fixed_interest = fixed_interest;
    }

    public int getInternal_fund() {
        return internal_fund;
    }

    public void setInternal_fund(int internal_fund) {
        this.internal_fund = internal_fund;
    }
}

public class Main {


    public static void main(String[] args) {
        Bank bank = new Bank ();
        Scanner sc = new Scanner (System.in);
        String flag;
        while (true) {
            flag = sc.next ();
            if (flag.equals ("Create")) {
                String name = sc.next (), type = sc.next ();
                int amount = sc.nextInt ();
                bank.create_account (name, type, amount);
            }
            else if (flag.equals ("Open")) {
                String name = sc.next ();
                bank.open (name);
            }
            else if (flag.equals ("INC")) {
                bank.increment ();
            }
            else if (flag.equals ("Quit")) {
                break;
            }
        }
    }
}
