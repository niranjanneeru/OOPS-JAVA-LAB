// Bank Account Object
// Fields
//   --> name
//   --> accNumber
//   --> accountTypeIndex
//   --> accountBalance
// Methods
//   --> deposit
//   --> withdraw  -(Amount)-
//   --> getAccountDetails
//   --> getBalance


public class BankAccount {

    // Data Members
    String name;
    long accNumber;
    String[] accountType = {"Current Deposits", "Savings Deposits", "Recurring Deposits", "Fixed Deposits"};
    int accountTypeIndex;
    long accountBalance;

    // Trigger Method
    public static void main(String[] args) {

        System.out.println("Banking Details\n\n");
        // Test User
        BankAccount test = new BankAccount();
        test.getAccountDetails();
        test.withdraw(1_000L);
        test.deposit(1_000_000_000L);

        System.out.println("_________________________\n\n");

        // New User with a Current Deposit
        BankAccount user_business = new BankAccount("Good", 1717_1717_1717L, 0, 3_000_000_000L);
        user_business.getAccountDetails();
        user_business.withdraw(1_000_000L);
        user_business.deposit(1_000_000_000L);

        System.out.println("_________________________\n\n");

        // New User with Recurring Deposits
        BankAccount user_student = new BankAccount("Bad", 1717_1756_1756L, 2, 3_000L);
        user_student.getAccountDetails();
        user_student.withdraw(1_000L);
        user_student.deposit(200_040L);

        System.out.println("_________________________\n\n");

        // New User with Fixed Deposits
        BankAccount user_employee = new BankAccount("Ugly", 1717_1126_1723L, 3, 3_000_000L);
        user_employee.getAccountDetails();
        user_employee.withdraw(1_000L);
        user_employee.deposit(1_000_000_000L);

        System.out.println("_________________________\n");
    }

    // static Method
    public static void messages(int index) {
        String[] messages = {"Insufficient Balance\n", "Successful Withdrawal\n", "Your Account Type doesn't allow you to Deposit this much Amount\n", "You can't add money in a Fixed Deposit\n", "Successful Deposit\n"};
        System.out.print(messages[index]);
    }

    // Constructors
    public BankAccount() {
        name = "Default";
        accNumber = 1111_1111_1111L;
        accountTypeIndex = 1;
        accountBalance = 0L;
    }

    public BankAccount(String name, long accNum, int index, long balance) {
        name = name;
        accNumber = accNum;
        accountTypeIndex = index;
        accountBalance = balance;
    }

    // Methods
    public void deposit(long amount) {
        System.out.println("\nTrying to Deposit " + amount + "....");
        long check = accountBalance + amount;
        if (accountTypeIndex == 1 || accountTypeIndex == 2) {
            if (check > 10_000_000L) {
                messages(2);
                return;
            }
        } else if (accountTypeIndex == 3) {
            messages(3);
            return;
        }
        accountBalance = check;
        messages(4);
        getBalance();
    }

    public void withdraw(long amount) {
        System.out.println("\nWithdrawing " + amount + "....");
        if (accountBalance >= amount) {
            accountBalance -= amount;
            messages(1);
            getBalance();
        } else {
            messages(0);
        }
    }

    public void getAccountDetails() {
        System.out.println("Account Details");
        System.out.println("Account Holder: " + name + "\nAvailable Balance: " + accountBalance + "\nAccount Type: " + accountType[accountTypeIndex]);
    }

    public void getBalance() {
        System.out.println("Account Balance: " + accountBalance);
    }
}


/*
Banking Details


Account Details
Account Holder: Default
Available Balance: 0
Account Type: Savings Deposits

Withdrawing 1000....
Insufficient Balance

Trying to Deposit 1000000000....
Your Account Type doesn't allow you to Deposit this much Amount
_________________________


Account Details
Account Holder: Good
Available Balance: 3000000000
Account Type: Current Deposits

Withdrawing 1000000....
Successful Withdrawal
Account Balance: 2999000000

Trying to Deposit 1000000000....
Successful Deposit
Account Balance: 3999000000
_________________________


Account Details
Account Holder: Bad
Available Balance: 3000
Account Type: Recurring Deposits

Withdrawing 1000....
Successful Withdrawal
Account Balance: 2000

Trying to Deposit 200040....
Successful Deposit
Account Balance: 202040
_________________________


Account Details
Account Holder: Ugly
Available Balance: 3000000
Account Type: Fixed Deposits

Withdrawing 1000....
Successful Withdrawal
Account Balance: 2999000

Trying to Deposit 1000000000....
You can't add money in a Fixed Deposit
_________________________
*/
