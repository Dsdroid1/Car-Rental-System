#fgt
import java.util.Scanner;
public class Mini extends Car{
    

    Mini(String car_name,String color,String number,int seats)
    {
        this.Category="Mini";
        this.cost_till_5_km=35;
        super.Initialization(car_name, color, number,seats);
        this.cost_per_km=6;
    }
    static void Show_cars(Mini[] cars_mini,int size)
    {/*
        for(int i=0;i<size;i++)
        {
            cars_mini[i].Display();
        }*/
        Mini.minimal_display(cars_mini, size);
    }

    static void minimal_display(Mini[] cars_mini,int size)
    {
        System.out.println("Your choices in this segment are:");
        System.out.println("**********************************************");
        for(int i=0;i<size;i++)
        {
                System.out.println("*Option No: "+i+" **  Car Name:" + cars_mini[i].car_name);
        }
        System.out.println("**********************************************");
    }

    static int ui(Mini[] cars_mini,Location[] obj,DRiver[] dri,int uid,int value_correct,int pos,int book_confirm)
    {
        System.out.println("Which car would you like:");
        Mini.Show_cars(cars_mini, 3);
        Scanner s=new Scanner(System.in);
        while(value_correct==0)
        {
            System.out.println("Enter car no.(position from 0 to 2):");
            pos=s.nextInt();
                        try{
                            if(Location.type==0)//des,pickup only
                            {
                            cars_mini[pos].route_cost(Location.pick_up,Location.des,obj);
                            System.out.println("Cost will be:"+cars_mini[pos].cost);
                            }
                            else
                            {
                            cars_mini[pos].route_cost(Location.pick_up,Location.via,Location.des,obj);
                            System.out.println("Cost will be:"+cars_mini[pos].cost);
                            }
                            value_correct=1;
                            if(cars_mini[pos].Availability==true)
                            {
                                System.out.println("Car Details:");
                                cars_mini[pos].Display();
                                System.out.println("Do you want to continue this booking or select another car from same class?(1 to confirm)");
                            //scan book_confirm
                                 book_confirm=s.nextInt();
                            //book_confirm=1;
                            
                                if(book_confirm==1)
                                {
                                System.out.println("Your booking has been confirmed!!");
                                System.out.println("------------------------------------");
                                System.out.println("Details:");
                                System.out.println("Car Name:"+cars_mini[pos].car_name);
                                System.out.println("Cost:"+cars_mini[pos].cost);
                                DRiver.ChooseDriver(dri);
                                System.out.println("Email id of User:"+Database.CArray[uid].Email);
                                System.out.println("------------------------------------");
                                }
                            } 
                            else if(cars_mini[pos].Availability==false)
                                {
                                    System.out.println("This vehicle is not available!!");
                                    int aflag=0;
                                    for(int j=0;j<cars_mini.length&&aflag==0;j++)
                                    {
                                        if(cars_mini[j].Availability==true)
                                        {
                                            aflag=1;
                                        }
                                    }
                                    if(aflag==0)
                                    {
                                        book_confirm=1;
                                        value_correct=1;
                                        System.out.println("NO CAR OF THIS CLASS IS AVAILABLE, BOOKING LATER");
                                    }
                                    else{
                                        value_correct=0;
                                    }
                                    
                                }   
                        }
                        catch(ArrayIndexOutOfBoundsException e){
                            System.out.println("Please enter valid position:");
                        }
                        
                    }
         return book_confirm;           

    }
}
