import java.util.Objects;

public class BankAccount { //defining the class and your attributes
    private String accountUser;
    private int accountNumber;
    protected String accountType;
    private float accountBalance;
    private  boolean accountStatus;


    public BankAccount() { //defining the constructor method
        this.setAccountBalance(0);
        this.setAccountStatus(false);
    }

//****************************************************************

    //defining setters and getters of the all attributes

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

//-----------------------------------------------------------

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return this.accountType;
    }

//-----------------------------------------------------------

    public void setAccountUser(String accountUser) {
        this.accountUser = accountUser;
    }

    public String getAccountUser() {
        return this.accountUser;
    }

//-----------------------------------------------------------

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public float getAccountBalance() {
        return this.accountBalance;
    }

//-----------------------------------------------------------

    private void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }

    private boolean getAccountStatus() {
        return this.accountStatus;
    }

//-----------------------------------------------------------

    //defining public methods

    public void openAccount(String accountType) {
        this.setAccountType(accountType);
        this.setAccountStatus(true);


        if (Objects.equals(getAccountType(), "CA")) {
            this.setAccountBalance(50);
        }

        else if (Objects.equals(getAccountType(), "SA")) {
            this.setAccountBalance(150);
        }

        System.out.println("Your account has been opened successfully!!!");

    }

//-----------------------------------------------------------

    public void closeAccount() {
        if (getAccountBalance() < 0) {
            System.out.println("Impossible to close the account, you have a negative balance!!!");
            System.out.println("Your balance in the account is of R$ " + getAccountBalance());
        }

        else if (getAccountBalance() > 0) {
            System.out.println("Impossible to close the account, you still have balance in the account!!!");
            System.out.println("Your balance in the account is of R$ " + getAccountBalance());
        }

        else {
            this.setAccountStatus(false);
            System.out.println("Your account has been closed successfully!!!");
        }
    }

//-----------------------------------------------------------

    public void depositAccount(float accountBalance) {
        if (getAccountStatus()) {
            this.setAccountBalance(getAccountBalance() + accountBalance);
            System.out.println("Your deposit has been completed successfully!!!");
            System.out.println("The balance of the account is of: R$ " + getAccountBalance());
        }

        else {
            System.out.println("Impossible to deposit into a closed account!!!");
        }
    }

//-----------------------------------------------------------

    public void withdrawAccount(float accountBalance) {

        if (accountBalance == 0) {
            System.out.println("Please enter a valid number!!!");
        }
        else if((getAccountStatus()) && (getAccountBalance() >= accountBalance)) {
            this.setAccountBalance(getAccountBalance() - accountBalance);
            System.out.println("Your withdraw has been completed successfully!!!");
            System.out.println("The balance of the account is of: R$ " + getAccountBalance());
        }

       else if (accountBalance > getAccountBalance()) {
           System.out.println("impossible to withdraw, the amount entered is greater than your balance!!!");
       }

    }

//-----------------------------------------------------------

    public void monthlyPayment() {
        int  monthlyValue = 0;
        if (getAccountType() == "CA") {
            monthlyValue = 12;
        }
        else if (getAccountType() == "SA") {
            monthlyValue = 20;
        }
        if (getAccountStatus()) {
            this.setAccountBalance(this.getAccountBalance() - monthlyValue);
            System.out.println("The monthly payment has been completed successfully!!!");
            System.out.println("The balance of the account is of: R$ " + getAccountBalance());
        }
        else {
            System.out.println("Impossible to make monthly payments on a closed account!!!");
        }

    }

    public void accountInfo() {
        if (getAccountStatus()) {
            System.out.println("The account belongs to: " + getAccountUser());
            System.out.println("The number of the account is: " + getAccountNumber());
            System.out.println("The account is the type: " + getAccountType());
            System.out.println("The balance of the account is of: R$ " + getAccountBalance());
        }
        else if (!getAccountStatus()) {
            System.out.println("The account is closed! Unable to show information!!!");
        }
    }

}