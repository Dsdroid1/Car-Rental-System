import java.io.*;
import java.util.Random;
import java.util.regex.*;


public class Registration
{
    int new_id =0;
    static Random rand = new Random();
    static String Name, Email, Mobile_no, Password, Username;
    static int temo;
    
    public static boolean mobile_verify(String s)
    {
    
    //Then contains 7 or 8 or 9
    //Then contains 9 digits

    Pattern p = Pattern.compile("[7-9][0-9]{9}");
    Matcher m = p.matcher(s);
    return (m.find() && m.group().equals(s));
    }
    public static boolean email_verify(String E)
    {
    String x = "^[a-zA-Z0-9_+&*-]+(?:\\."+
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";
    Pattern p = Pattern.compile(x);
    return p.matcher(E).matches();
    }

    public static void TakeInputOfRegistration()
    {
        Console con = null;
        int new_id =0;
        int flag=0;
        try {
            con = System.console();
            if (con != null) {
                System.out.println("---------Welcome TO Registration---------");
                while(flag==0)
                {
                    Name = con.readLine("Enter Your Name:   ");
                    if(Name.equals(""))
                    {
                        System.out.println("!!!Please enter valid name!!!");
                    }
                    else
                    {
                        flag=1;
                    }
                }
                flag=0;
                while(flag==0)
                {
                    Email = con.readLine("Enter Your Email:   ");
                    if(email_verify(Email))
                    {
                        flag = 1;
                    }
                    else
                    {
                        System.out.println("!!!Please Enter a valid Email!!!");
                    }
                }
                flag=0;
                while(flag==0)
                {
                    
                    Mobile_no = con.readLine("Enter Your Mobile Number:   ");
                    if(mobile_verify(Mobile_no))
                    {
                        flag = 1;
                    }
                    else
                    {
                        System.out.println("!!!Enter a valid number!!!");
                    }
                }
                Password = con.readLine("Enter Your Password:   ");
                
                while(new_id==0)
                {
                    temo = rand.nextInt(10000);
                    Username = Integer.toString(temo);
                    new_id=1;
                    for(int i=0;i<Database.size;i++)
                    {
                        if(Username.equals(Database.CArray[i].Username))
                        {
                            new_id=0;
                        }
                    }   
                }
                int repeat=0;
                for(int i=0;i<Database.size;i++)
                {
                    if(Email.equals(Database.CArray[i].Email))
                    {
                        repeat=1;
                    }
                }
                if(repeat==0)
                {
                    System.out.println("!!!Registration Successful!!!");
                    System.out.println("******************************");
                    System.out.println("Your User Id is:  " + Username);
                    System.out.println("******************************");
                    Login.pos_in_db=Database.size;
                
                //----------Adding in database--------//
                    Database.Append();
                }
                else
                {
                    System.out.println("SAME EMAIL ID IS ALREADY REGISTERED!!");
                    System.out.println("---Redirecting To Login---");
                    Login.TakeInput();
                }
                //Database.Display();//////solve from here
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
