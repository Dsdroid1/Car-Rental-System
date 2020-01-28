import java.util.Scanner;

public class Location
{
    String Loc_name;
    int id;
    static int type=0;
    static int pick_up,via,des;
    int[] km = new int[5];//considering 5 location;
    Location(String Loc_name,int id,int[] km)
    {
        this.id = id;
        this.Loc_name = Loc_name;
        System.arraycopy(km, 0, this.km, 0, 5);
    }
    public static void Display(Location[] loc)
    {
        System.out.println("The locations available are:");
        System.out.println("------------------------------");
        for (int i=0;i<5;i++)
        {
            System.out.println("Id: " + loc[i].id +":" + loc[i].Loc_name );
        }
        System.out.println("------------------------------");
    }
    public static void Options_Display(Location[] loc)
    {
        System.out.println("Enter 1 for Direct Route or 2 for Via-Route:");
        Scanner s1 = new Scanner(System.in);
        int input =  s1.nextInt();
        int correct_input=0;
        while(correct_input==0)
        {
            if(input == 2)//Via Route
            {
                System.out.println("Enter Your Current Location:");
                Display(loc);
                pick_up = s1.nextInt();
                System.out.println("Enter Via Where You Want To Go:");
                Display(loc);
                via = s1.nextInt();
                System.out.println("Enter Your Final Destintion:");
                Display(loc);
                des = s1.nextInt();
                if((pick_up<5&&pick_up>=0)&&(des<5&&des>=0)&&(via<5&&via>=0))
                {
                    correct_input=1;
                    System.out.println("Your data has been successfully taken!");
                    type=1;
                }
                else
                {
                    System.out.println("---------------------------------------------");
                    System.out.println("Please enter the corresponding ids correctly");
                    System.out.println("---------------------------------------------");
                }
            }
            else
            {
                System.out.println("Enter Your Current Location:");
                Display(loc);
                pick_up = s1.nextInt();
                System.out.println("Enter Your Final Destintion:");
                Display(loc);
                des = s1.nextInt();
                if((pick_up<5&&pick_up>=0)&&(des<5&&des>=0))
                {
                    correct_input=1;
                    System.out.println("Your data has been successfully taken!");
                    type=0;
                }
                else
                {
                    System.out.println("---------------------------------------------");
                    System.out.println("Please enter the corresponding ids correctly");
                    System.out.println("---------------------------------------------");
                }
            }
        }
       // s1.close();
    }


}
