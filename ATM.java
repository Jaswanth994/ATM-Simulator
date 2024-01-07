//   CS22B020 //
/*
 * I created two user accounts with    acc_num_1=12345 and pin_1=1111     
 *                                     acc_num_2=23456 and pin_2=2222     
 * with the help of abstract class user i intiated all users with their respective details....
 * and in the main menu i intiated all the the functions like depositions,,withdrawl,,pin change etc..
 * in the main class ATM ,declared all the objects and initialised according to it...
 */
import java.util.*;
//creating an abstract class user..and extending it ...
abstract class User{
    protected int account_num;
    private int Savings_acc_amount;
    private int Current_acc_amount;
    protected int pin;
    public int getSavings_acc_amount() {
        return Savings_acc_amount;
    }
    public void setSavings_acc_amount(int Savings_acc_amount) {
        this.Savings_acc_amount = Savings_acc_amount;
    }
    public int getCurrent_acc_amount() {
        return Current_acc_amount;
    }
    public void setCurrent_acc_amount(int current_acc_amount) {
        Current_acc_amount = current_acc_amount;
    }
}
class user1 extends User{
  user1(){
        account_num=12345;
        pin=1111;
        setSavings_acc_amount(1000);
        setCurrent_acc_amount(0000);
   }
}
class user2 extends User{
    user2(){
        account_num=23456;
        pin=2222;
        setSavings_acc_amount(9000);
        setCurrent_acc_amount(2000);
    }
}
//intialising all functions like withdrawl,pinchange... in main_menu... 
class Main_Menu{
    Scanner sc=new Scanner(System.in);
    public void View_my_Balance(int amount){
        System.out.println("\n     Current Balance in Your Account is "+ amount +" rupees\n");
    }
    public int WithDrawl_amount(){
       System.out.println("Choose the Account Type : \n1.Savings_Account\n2.Current_Account");
       int account_type=sc.nextInt();
       System.out.print("Enter amount to be withdrawn : ");
       int amount =sc.nextInt();
       return amount;
    }
    public int Deposits_fund(){
        System.out.println("Choose the Account Type : \n1.Savings_Account\n2.Current_Account");
        int account_type=sc.nextInt();
        System.out.println("___You can Deposite upto 100000 rupees only___\n    Enter the amount you want to deposit  : ");
        int amount=sc.nextInt();
        return amount;
    }
    public int Change_PIN(){
        System.out.print("Enter your Exisiting PIN : ");
        int pin=sc.nextInt();
        System.out.print("Enter NEW PIN :");
        int new_pin=sc.nextInt();
        System.out.println(" \n** New PIN got Reset Successfully **\n");
        return new_pin;
    }

}
//intialising main class atm....
public class ATM {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int no_of_attempts=3;
        Main_Menu menu=new Main_Menu();
        user1 u1=new user1();
        user2 u2=new user2();
        while(no_of_attempts!=0){
        System.out.println("____*Welcome to Atm Machine*____");
        
        System.out.print("Enter Your Account Number : ");
        int account_num=sc.nextInt();
        
        System.out.print("Enter the 4 digit PIN : ");
        int pin=sc.nextInt();

        if(account_num==12345 && pin==u1.pin){
            while(true){
            System.out.println("\nEnter the Actions You Want to Perform : \n1.View_Balance\n2.WithDrawl\n3.Deposit\n4.Change_PIN\n5.Exit");
            int action=sc.nextInt();
            if(action==1)menu.View_my_Balance(u1.getSavings_acc_amount());
            if(action==2){
                int amount=menu.WithDrawl_amount();
                if(amount>u1.getSavings_acc_amount())System.out.println("InSufficient_Balance");
                else {
                    u1.setSavings_acc_amount(u1.getSavings_acc_amount()-amount);
                    System.out.println("  ** pls!! collect your money $$$\n");
                }
            }
            if(action==3){
                int amount=menu.Deposits_fund();
                u1.setSavings_acc_amount(u1.getSavings_acc_amount()+amount);
                System.out.println("\n ____ Amount got deposited Successfully ____\n");
            }
            if(action==4){
                int new_pin=menu.Change_PIN();
                u1.pin=new_pin;
            }
            if(action==5)break;
        }
        }
    
        else if(account_num==23456 && pin==u2.pin){
              while(true){
            System.out.println("\nEnter the Actions You Want to Perform : \n1.View_Balance\n2.WithDrawl\n3.Deposit\n4.Change_PIN\n5.Exit");
            int action=sc.nextInt();
            if(action==1)menu.View_my_Balance(u2.getSavings_acc_amount());
            if(action==2){
                int amount=menu.WithDrawl_amount();
                if(amount>u1.getSavings_acc_amount())System.out.println("InSufficient_Balance");
                else {
                    u2.setSavings_acc_amount(u2.getSavings_acc_amount()-amount);
                    System.out.println("   ** pls!! collect your money $$$ \n");
                }
            }
            if(action==3){
                int amount=menu.Deposits_fund();
                u2.setSavings_acc_amount(u2.getSavings_acc_amount()+amount);
            }
            if(action==4){
                int new_pin=menu.Change_PIN();
                u2.pin=new_pin;
                break;
            }
            if(action==5)break;
        }

        }
        else {
            no_of_attempts--;
            if(no_of_attempts==0)
                System.out.println("     \n *** your ATM card is Blocked *** \n!!! kindly Contact the Bank Manager For Further Transactions !!!\n");
            else{
                System.out.println("\n    *** Enter Valid Account_Num and PIN ***");
                System.out.println("   ----You have "+no_of_attempts+" more attemts----\n ");
            }
        }
        
        }
    }
}
