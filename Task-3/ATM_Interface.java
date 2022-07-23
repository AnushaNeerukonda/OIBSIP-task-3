import java.util.*;
class Account
{
    String name,username,password;
    long acc_no;
    double limit_d=1000000,limit_w=100000,limit_t=50000,balance, x;
    int transactions=0;
    String t_history= "";
    void login()
    {
        int attempts=3;
        Scanner sc=new Scanner(System.in);
        System.out.println("\n\t\t****Login*****");
        while(attempts>=0)
        {
            try 
            {
                String user_name,password_;
                System.out.print("Enter Username: ");
                user_name=sc.nextLine();
                System.out.print("Enter password: ");
                password_=sc.nextLine();
                if(user_name.equals(username) && password_.equals(password))
                {
                    while(true)
                    {
                        System.out.print("\n1. Check Balance\n2. Withdraw\n3. Deposit\n4. Transfer\n5. Transaction History\n6. Exit\nEnter your choice: ");
                        int ch=sc.nextInt();
                        switch(ch)
                        {
                        case 1: check_balance();
                            break;
                        case 2: withdraw();
                            break;
                        case 3: deposit();
                            break;
                        case 4: transfer();
                            break;
                        case 5: transaction_history();
                            break;
                        case 6: System.out.print("Do you want to quit? y/n: ");
                            char y_n=sc.next().charAt(0);
                            if(y_n == 'y' || y_n == 'Y')
                            {
                            	System.out.println("Exiting...");
                            	System.exit(0);                      
                            }
                                  
                            else
                                continue;
                        }
                    }
                }
                else
                {
                    System.out.println("username or password is incorrect.");
                    attempts--;
                    if(attempts>0)
                    System.out.println(attempts+" more attempts left.");
                    else
                    {
                        System.out.println("No more attempts left.\nLogging out...");
                        break;
                    }
                }
            } 
            catch(Exception  e)
            {
            
            }
        }
    }
    void registration()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n\t\t*****Registration*****");
        System.out.print("Enter name: ");
        this.name=sc.nextLine();
        System.out.print("Enter username: ");
        this.username = sc.nextLine();
        System.out.print("Enter password: ");
        this.password = sc.nextLine();
        
        while(true)
        {
            System.out.print("Confirm password: ");
            String p = sc.nextLine();
            if(p.equals(this.password))
            {
                
                break;
            }
            else
            {
                System.out.println("Confirm password is incorrect. Try Again...");
                
            }
        }
        System.out.print("Enter account number: ");
        this.acc_no = sc.nextLong();
        System.out.println("Registration completed successfully.\nYou're redirected to login page...\n");
        login();
    }
    void check_balance()
    {
        System.out.println("\nYour Balance: Rs."+balance+"/-\n");
    }
    void deposit()
    {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            try
            {
                System.out.print("\nEnter Amount: ");
                x=sc.nextDouble();
                if(x<=limit_d)
                {
                    balance=balance+x;
                    String str="Rs."+x+"/- deposited.\n";
                    t_history = t_history.concat(str);
                    transactions++;
                    System.out.println("Amount has been deposited successfully.");
                    break;
                }
                else
                {
                    System.out.println("Amount is exceeded the limit. Try Again!");
                    continue;
                }
            }
            catch(Exception e)
            {
                System.out.println("Something went wrong. Try Again!");
                continue;
            }
            //break;
        }
        
    }
    void withdraw()
    {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            try
            {
                System.out.print("\nEnter Amount: ");
                x=sc.nextDouble();
                if(x<=limit_w)
                {
                    if(balance < x)
                        System.out.println("Insufficient Balance.");
                    else
                    {   
                    balance=balance-x;
                    String str="Rs."+x+"/- withdrawn.\n";
                    t_history = t_history.concat(str);
                    transactions++;
                    System.out.println("Amount has been withdrawn successfully.");
                    break;
                    }
                }
                else
                {
                    System.out.println("Amount is exceeded the limit. Try Again!");
                    continue;
                }
            }
            catch(Exception e)
            {
                System.out.println("Something went wrong. Try Again!");
                break;
            }
            break;
        }
    }
    void transfer()
    {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            try
            {
            
                System.out.print("Enter recipent name: ");
                String name_=sc.nextLine();
                System.out.print("Enter recipent account number: ");
                long accno = sc.nextLong();
                System.out.print("\nEnter Amount: ");
                x=sc.nextDouble();
                if(x<=limit_t)
                {
                    if(balance < x)
                        System.out.println("Insufficient Balance.");
                    else
                    {
                        balance=balance-x;
                        String str="Rs."+x+"/- transfered to "+name_+".\n";
                        t_history = t_history.concat(str);
                        transactions++;
                        System.out.println("Rs."+x+"/-has been transfered successfully to "+name_+".");
                        break;
                    }
                }
                else
                {
                    System.out.println("Amount is exceeded the limit. Try Again!");
                    continue;
                }
            }
            catch(Exception e)
            {
                System.out.println("Something went wrong. Try Again!");
                break;
            }
            break;
        }
    }
    void transaction_history()
    {
        if(transactions!=0)
        System.out.println("\nYour trasactions:\n"+t_history);
        else
        System.out.println("\nNo transactions have done yet.");
    }
}

public class ATM_Interface
{
    public static void main(String args[])
    {
        while(true)
        {
            Scanner sc=new Scanner(System.in);
            Account acc = new Account();
            int ch;
            System.out.print("1. Register 2. Exit\nEnter Choice: ");
            switch(ch = sc.nextInt())
            {
                case 1: acc.registration();
                    break;
                case 2: System.out.println("Exiting...");
                	System.exit(0);  
                    break;
                default: System.out.println("Enter valid number: ");
                    break;
            }
        }
    }
}