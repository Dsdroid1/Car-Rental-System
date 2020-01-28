import java.util.Random;
public class DRiver extends Person
{
    boolean Availability;
    String Driving_License;
    DRiver(String Name,String Mobile_no,String Driving_License,boolean Availability)
    {
        this.Name = Name;
        this.Mobile_no = Mobile_no;
        this.Driving_License = Driving_License;
        this.Availability = Availability;
    }
    static void ChooseDriver(DRiver[] d)
    {
        Random rand = new Random();
        int var=0,i=0,flag=0;
        while(i<10 && flag==0)//10 tries to allocate driver
        {
            var = rand.nextInt(d.length);
            if(d[var].Availability)
            {
                flag = 1;
            }
            i++;
        }
        if(flag==1)
        {
            System.out.println("Your Driver is:  " + d[var].Name);
            System.out.println("Driver's Mobile Number:"+d[var].Mobile_no);
            System.out.println("Driver's License:"+d[var].Driving_License);
            d[var].Availability=false;

        }
        else
        {
            System.out.println("No Driver is available at the moment");
        }
    }
}
