
import java.util.*;
class bank{
    static  void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("***************************");
        System.out.println("Enter your name :");
        myBank.name=sc.nextLine();
        System.out.println("Enter username :");
        String user=sc.nextLine();
        System.out.println("Enter password :");
        String pass=sc.nextLine();
        System.out.println("Enter your Account number :");
        myBank.accnumber=sc.nextLine();
        System.out.println("REGISTRATION SUCCESSFULLY!");
        System.out.println("***************************");
        myBank.prompt();
    }
}
class transaction{
    static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("------------------");
        System.out.println("Enter amount to withdraw :");
        int wcash=sc.nextInt();
        if(wcash<=myBank.balance){
            myBank.balance=myBank.balance-wcash;
            myBank.history.add(Integer.toString(wcash));
            myBank.history.add("Withdraw");
            System.out.println("Amount Rs"+wcash+"/-withdraw successfully");
            System.out.println("************************");
        }
        else{
            System.out.println("Insufficient balance.");
            System.out.println("************************");
		}
    }
    static void deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------");
        System.out.print("Enter amount to deposit :");
        int dcash=sc.nextInt();
        myBank.updatebalance(dcash);
        myBank.history.add(Integer.toString(dcash));
        myBank.history.add("Deposit");
        System.out.println("Amount Rs."+dcash+"/- deposit successful!");
        System.out.println("*****************************");
    }
    static void transfer(){
        Scanner sc=new Scanner(System.in);
		System.out.println("----------------");
        System.out.println("Enter name of receiver:");
        String s=sc.nextLine();
        System.out.println("Account number of the receiver:");
        int num=sc.nextInt();
        System.out.println("Amount to be transferred:");
        int tcash=sc.nextInt();
        if(tcash<=myBank.balance){
            myBank.balance=myBank.balance-tcash;
            myBank.history.add(Integer.toString(tcash));
            myBank.history.add("transferred");
            System.out.println("Amount Rs."+tcash+"/- transferred successfully.");
            System.out.println("****************************");
        }
        else{
            System.out.println("Insufficient balance.");
            System.out.println("****************************");
        }
    }
}
class check{
    static void checkbalance(){
        System.out.println("---------------------");
        System.out.println("The available balance in the bank account :");
        myBank.showbalance();
        System.out.println("*****************************");
    }
}
class his{
    static void transactionhistory(){
            System.out.println("---------------------");
            System.out.println("Transaction History :");
            int k=0;
            if(myBank.balance>0){
            for(int i=0;i<(myBank.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(myBank.history.get(k)+" ");
                    k++;
                }
                System.out.println("----------------");
            }
			System.out.println("**************************");
            }
            else {
                System.out.println("No transaction history ,Account is empty.");
				System.out.println("**************************");
            }
    }
}
public class myBank {
    public static String name;
    public static int balance=0;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();
    public static void homepage(){
        Scanner sc=new Scanner(System.in);
	    System.out.println("**************************");
        System.out.println("WELCOME TO myBank INTERFACE");
        System.out.println("1. Register");
        System.out.println("2. Exit");
		System.out.println("---------------------");
        System.out.println("Enter your choice");
        int ch =sc.nextInt();
        if (ch==1){
                bank.register();
        }
        else {
            if(ch==2){
                System.exit(0);
            }
	        else{
                System.out.println("Wrong Value! enter again 😊:");
				homepage();
            }
        }
    }
    static void updatebalance(int dcash){
        balance=balance+dcash;
    }
    static void showbalance(){
        System.out.println(balance);
    }
    static void prompt(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Hey "+myBank.name+"! WELCOME TO myBank");
        System.out.println("---------------------");
        System.out.println("Select any option : ");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Check balance");
        System.out.println("6. Quit");
        System.out.print("Enter your choice : ");
        int choice=sc.nextInt();
        switch (choice) {
			case 1:
                his.transactionhistory();
				myBank.prompt();
				break;
            case 2:
                transaction.withdraw();
				myBank.prompt();
				break;
            case 3:
                transaction.deposit();
				myBank.prompt();
				break;
			case 4:
                transaction.transfer();
				myBank.prompt();
				break;
            case 5:
                check.checkbalance();
				myBank.prompt();
  				break;
            case 6:
                System.exit(0);
        }
    }
    public static void main(String[] args) {
        homepage();
    }
} 

