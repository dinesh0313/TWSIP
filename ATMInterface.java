package topperworldintership;
import java.util.Scanner;
public class ATMInterface {
    public static void main(String[] args) {
        int balance=200000,withdraw,deposite,num;
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("welcome to the ATM Machine");
            System.out.println("1.Withdraw");
            System.out.println("2.Deposite");
            System.out.println("3.Check Balance");
            System.out.println("4.Exit");
            num=sc.nextInt();
            switch(num)
            {
                case 1:
                    System.out.println("enter amount to withdraw");
                    withdraw=sc.nextInt();
                    if(balance>=withdraw)
                    {
                       balance=balance-withdraw;
                        System.out.println("remaining balance amount is: "+balance);
                        System.out.println("please collect your money");
                    }
                    else
                    {
                        System.out.println("insufficient balanace");
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("enter the amount to deposite");
                    deposite=sc.nextInt();
                    deposite+=balance;
                    System.out.println("Your mony is sucessfully deposited");
                    System.out.println("Now balance is: "+balance);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("your current balance is: "+balance);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Thanks for using our services");
                    System.exit(0);
                    System.out.println();
                    break;
                
            }
        }
    }
    
}
