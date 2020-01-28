import java.util.Random;

public class DriverArray
{
    
    
        static DRiver[] dri = new DRiver[5];
        dri[0] = new DRiver("driver1","9800025320","YES",true);
        dri[1] = new DRiver("driver2","9800025321","YES",true);
        dri[2] = new DRiver("driver3","9800025322","YES",true);
    
    static void ChooseDriver(DRiver[] d)
    {
        Random rand = new Random();
        int var=0,i=0,flag=0;
        while(i<d.length && flag==0)
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
            System.out.println("Driver's Mobile Number and Driver's License has been Sent to: " + "DHRUV CUSTOMER KA EMAIL");
        }
        else
        {
            System.out.println("No Driver is available at the moment");
        }
    }
}