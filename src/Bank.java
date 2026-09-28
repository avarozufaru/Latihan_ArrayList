public class Bank {
    private Customer[] customers;
    private int numberOfCustomers;

    public Bank() {
        this.customers = new Customer[10];
        this.numberOfCustomers = 0;
    }

    public void addCustomer(String firstName, String lastName) {
        if (this.numberOfCustomers < this.customers.length) {
            Customer newCustomer = new Customer(firstName, lastName);
            this.customers[this.numberOfCustomers] = newCustomer;
            this.numberOfCustomers++;
        } else {
            System.out.println("Kapasitas bank penuh!");
        }
    }

    public int getNumOfCustomers() {
        return this.numberOfCustomers;
    }

    public Customer getCustomer(int index) {
        if (index >= 0 && index < this.numberOfCustomers) {
            return this.customers[index];
        }
        return null;
    }
}