import java.io.Console;


public class Login
{
    
    static String Usname="",Pwd;
    static char[] pwd;
    static int pos_in_db=0;
    //--------------------------------------------------------+---------------------------------------------//
    public static void Check(Customer[] c,String Username,String Pswd)
    {
        Database.data();
        int i=0,flag1=0,flag=0;
        while(i<Database.size && flag ==0)
        {
            if(Username.equals(c[i].Username))
            {
                flag1 = 1;
                if(Pswd.equals(c[i].Password))
                {
                    System.out.println("Login Successful");//dhruv's next
                    flag = 1;
                    pos_in_db=i;
                }
                else
                {
                    System.out.println("Your Password is Incorrect");
                    System.out.println("Try Logging in Again:");
                    System.out.println("---------------------------");
                    Login.TakeInput();
                }
            }
            i++;
        }

        if((flag1==0))
        {
            System.out.println("!!!You need to Register First!!!");
            System.out.println("Redirecting to Register Screen...");
            System.out.println("");
            System.out.println("/////////////////////////////////LOADING COMPLETE");
            System.out.println("");
            Registration.TakeInputOfRegistration();
        }

    }
    public static void TakeInput()
    {
        
        Console con = null;
        try
        {
            con = System.console();
            if(con!=null)
            {
                
                Usname = con.readLine("Enter Your Username:   ");
                while(Usname.equals(""))
                {
                    System.out.println("!!!Enter A Valid Username!!!");
                    Usname = con.readLine("Enter Your Username:   ");
                }
                pwd = con.readPassword("Enter Your Password:   ");
                Pwd = new String(pwd);
                Check(Database.CArray,Usname,Pwd);
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
