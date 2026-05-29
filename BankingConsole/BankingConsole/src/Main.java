import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        double balance = 897.34;
        double amt;
        int choice;
        boolean isRunning = true;

        while(isRunning) {
            System.out.println("****************************");
            System.out.println("BANKING APPLICATION");
            System.out.println("****************************");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("*****************************");

            System.out.print("Enter Your Choice(1-4)");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> showBalance(balance);
                case 2 -> {
                        System.out.print("Enter your amount that you wants to deposit: ");
                        amt = sc.nextDouble();
                        Deposit(amt,balance);
                }

                case 3 -> {
                        System.out.print("Enter the amount you wants to withdraw:");
                        amt = sc.nextDouble();
                        Withdraw(amt,balance);
                }
                case 4 -> isRunning = false;
                default -> System.out.println("INVALID CHOICE!");
            }
        }
    }

    static void showBalance(double balance){
        System.out.printf("Rs. %.2f\n",balance);
    }

    static void Deposit(double amt,double balance){
        balance+=amt;
        System.out.println("Amount of Rupees "+amt+" is successfully Deposited");
        System.out.printf("Rs. %.2f\n : ",balance);
    }

    static void Withdraw(double amt,double balance){
        balance-=amt;
    }
}