import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new ArrayList<Account>();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void addAccount(Account acct) {
        this.accounts.add(acct);
    }

    public Account getAccount(int index) {
        if (index >= 0 && index < this.accounts.size()) {
            return this.accounts.get(index);
        }
        return null;
    }

    public int getNumOfAccounts() {
        return this.accounts.size();
    }
}