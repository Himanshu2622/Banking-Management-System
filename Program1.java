/*Consider a Banking Application System and implement the following in Java. The variable/method names
indicate their usual meanings. The methods (deposit, withdraw, etc.) will be invoked for one object at a time
and this will be identified by the account number which is passed as a parameter or can also be taken from
the user.*/

import java.util.*;

class Account {

    private int accountNumber;
    private String accountType;
    private String serviceBranchIFSC;
    private float minimumBalance;
    private float availableBalance;
    private int customerID;
    private String customerName;
    private static int totalAccountCreated;

    Account() {
    }

    public int getAccNumber() {
        return accountNumber;
    }

    public int check_accountno(int id) {
        if (id == accountNumber) {
            return 1;
        }
        return 0;
    }

    public int check_customerid(int id) {
        if (id == customerID) {
            return 1;
        }
        return 0;
    }

    public void setDetails(int accnumber, String acctype, float minbal, String ifsc, String accholder, float balance,
            int customer_Id, int totalacc) {

        accountNumber = accnumber;
        accountType = acctype;
        minimumBalance = minbal;
        serviceBranchIFSC = ifsc;
        availableBalance = balance;
        customerName = accholder;
        customerID = customer_Id;
        totalAccountCreated = totalacc;
    }

    public void updateDetails(int accnumber, String acctype, float minbal, String ifsc, String accholder, float balance,
            int customer_Id) {

        if (accountNumber == accnumber) {

            accountType = acctype;
            minimumBalance = minbal;
            serviceBranchIFSC = ifsc;
            availableBalance = balance;
            customerName = accholder;
            customerID = customer_Id;
        }
    }

    public void getDetails(int accnumber) {
        if (accnumber == accountNumber) {
            System.out.println("Account Number : " + accountNumber);
            System.out.println("Account Type : " + accountType);
            System.out.println("Minimum Balance : " + minimumBalance);
            System.out.println("IFSC : " + serviceBranchIFSC);
            System.out.println("Available Balance : " + availableBalance);
            System.out.println("Customer Name : " + customerName);
            System.out.println("Customer ID : " + customerID);
        }
    }

    public void Deposit(int accnumber, float amount) {
        if (accnumber == accountNumber) {
            availableBalance += amount;
            System.out.println("Succesfully Deposited! For Account Number : " + accountNumber);
        }
    }

    public void Withdraw(int accnumber, float amount) {

        if (accnumber == accountNumber) {
            if (availableBalance >= amount + minimumBalance) {
                availableBalance -= amount;
                System.out.println("Successfully Withdrawn! For Account Number : " + accountNumber);
            } else {
                System.out.println("Not much Balance!");
            }
        }

    }

    public float getBalance(int accnumber) {
        if (accnumber == accountNumber)
            return availableBalance;
        else {
            return -1;
        }
    }

    public static int totalAccount() {
        return totalAccountCreated;
    }

    public void compare(Account ac1, Account ac2) {
        float bal_1 = ac1.getBalance(ac1.accountNumber);
        float bal_2 = ac2.getBalance(ac2.accountNumber);
        if (bal_1 > bal_2) {
            ac1.getDetails(ac1.accountNumber);
        } else {
            ac2.getDetails(ac2.accountNumber);
        }
    }

    public static void removeacc(ArrayList<Account> arr, int j) {

        arr.remove(j);
        totalAccountCreated--;
    }

}

public class Program1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Account> arr = new ArrayList<Account>();

        int x = 0;
        while (true) {
            System.out.println("Press 0 to CreateAccount()");
            System.out.println("Press 1 to UpdateDetails()");
            System.out.println("Press 2 to getDetails()");
            System.out.println("Press 3 to Deposit()");
            System.out.println("Press 4 to Withdraw()");
            System.out.println("Press 5 to getBalance()");
            System.out.println("Press 6 to totalAccount()");
            System.out.println("Press 7 to compare()");
            System.out.println("Press 8 to DeleteAccount()");
            System.out.println("Press 9 to Exit()");

            System.out.println("Enter your choice");
            int choice = input.nextInt();

            if (choice == 0) {

                System.out.println("Enter Account details for Person " + (x + 1));

                System.out.println("Enter Account Number");
                int accnumber = input.nextInt();
                input.nextLine();

                System.out.println("Enter Account Type");
                String acctype = input.nextLine();

                System.out.println("Enter Minimum Balance");
                float minbal = input.nextFloat();

                System.out.println("Enter Customer Name");
                input.nextLine();
                String accholder = input.nextLine();

                System.out.println("Enter Total Balance");
                float balance = input.nextInt();

                System.out.println("Enter IFSC Of Branch");
                input.nextLine();
                String ifsc = input.nextLine();

                System.out.println("Enter Customer-ID Number");
                int customer_Id = input.nextInt();
                input.nextLine();

                if (minbal > balance) {
                    System.out.println("Can't have balance less than minimum balance!");
                } else {
                    int flag = 0, temp = 0;

                    for (int j = 0; j < x; j++) {
                        flag = arr.get(j).check_accountno(accnumber);
                        if (flag == 1) {
                            break;
                        }
                    }

                    for (int j = 0; j < x; j++) {
                        temp = arr.get(j).check_customerid(customer_Id);
                        if (temp == 1) {
                            break;
                        }
                    }

                    if (flag == 0 && temp == 0) {
                        Account obj = new Account();
                        obj.setDetails(accnumber, acctype, minbal, ifsc, accholder, balance, customer_Id, x + 1);
                        arr.add(obj);
                        x++;
                    }

                    else if (flag == 1) {
                        System.out.println("Account number already exist!");
                    } else if (temp == 1) {
                        System.out.println("Customer of same I'd already exist!");
                    }

                }

            } else if (choice == 1) {

                System.out.println("Enter Account Number");
                int accnumber = input.nextInt();
                input.nextLine();

                System.out.println("Enter Account Type");
                String acctype = input.nextLine();

                System.out.println("Enter Minimum Balance");
                float minbal = input.nextFloat();

                System.out.println("Enter Customer Name");
                input.nextLine();
                String accholder = input.nextLine();

                System.out.println("Enter Total Balance");
                float balance = input.nextInt();

                System.out.println("Enter IFSC Of Branch");
                input.nextLine();
                String ifsc = input.nextLine();

                System.out.println("Enter Customer-ID Number");
                int customer_Id = input.nextInt();
                input.nextLine();

                for (int i = 0; i < x; i++) {
                    if (arr.get(i) != null)
                        arr.get(i).updateDetails(accnumber, acctype, minbal, ifsc, accholder, balance, customer_Id);
                }

            } else if (choice == 2) {
                System.out.println("Enter Account To Get the details of any Account");
                int accnumber = input.nextInt();
                for (int i = 0; i < x; i++) {
                    arr.get(i).getDetails(accnumber);
                }

            } else if (choice == 3) {
                System.out.println("Enter Account number and amount to deposit");
                int accnumber = input.nextInt();
                int amount = input.nextInt();

                for (int i = 0; i < x; i++) {
                    arr.get(i).Deposit(accnumber, amount);
                }

            } else if (choice == 4) {
                System.out.println("Enter Account number and amount to withdraw");
                int accnumber = input.nextInt();
                int amount = input.nextInt();
                for (int i = 0; i < x; i++) {
                    arr.get(i).Withdraw(accnumber, amount);
                }
            } else if (choice == 5) {
                System.out.println("Enter Account number to check Balance");
                int accnumber = input.nextInt();
                for (int i = 0; i < x; i++) {
                    float balance = arr.get(i).getBalance(accnumber);
                    if (balance != -1) {
                        System.out.println("Available Balance : " + arr.get(i).getBalance(accnumber));
                    }

                }
            } else if (choice == 6) {
                System.out.println("Total number of accounts till now : " + arr.get(0).totalAccount());

            } else if (choice == 7) {
                System.out.println("Enter Account Numbers to Compare");
                int ac1 = input.nextInt();
                int ac2 = input.nextInt();
                Account acc1 = null, acc2 = null;

                for (Account i : arr) {
                    if (i == null) {
                        continue;
                    }
                    if (ac1 == i.getAccNumber()) {
                        acc1 = i;
                    }
                }
                for (Account i : arr) {
                    if (i == null) {
                        continue;
                    }
                    if (ac2 == i.getAccNumber()) {
                        acc2 = i;
                    }
                }

                if (acc1 != null && acc2 != null) {
                    acc1.compare(acc1, acc2);
                }
            } else if (choice == 8) {
                System.out.println("Enter Account number to Delete");
                int id = input.nextInt();
                int flag = 0, j;

                for (j = 0; j < x; j++) {
                    if (arr.get(j) == null)
                        continue;
                    else {
                        flag = arr.get(j).check_accountno(id);
                        if (flag == 1) {
                            break;
                        }
                    }
                }
                Account.removeacc(arr, j);
                x--;
                System.out.println("Successfully removed the account");

            } else if (choice == 9) {
                break;
            } else {
                System.out.println("Invalid Choice!");
            }
        }

        input.close();
    }
}