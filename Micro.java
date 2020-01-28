
import java.util.Scanner;
public class Micro extends Car{
    Micro(String car_name,String color,String number,int seats)
    {
        this.Category="Micro";
        this.cost_per_km=5;
        this.cost_till_5_km=40;
        super.Initialization(car_name, color, number,seats);
    }

    static void Show_cars(Micro[] cars_micro,int size)
    {/*
        for(int i=0;i<size;i++)
        {
            cars_micro[i].Display();
        }*/
        Micro.minimal_display(cars_micro,size);
    }

    static void minimal_display(Micro[] cars_micro,int size)
    {
        System.out.println("Your choices in this segment are:");
        System.out.println("**********************************************");
        for(int i=0;i<size;i++)
        {
                System.out.println("*Option No: "+i+" **  Car Name:" + cars_micro[i].car_name);
        }
        System.out.println("**********************************************");
    }

    static int ui(Micro[] cars_micro,Location[] obj,DRiver[] dri,int uid,int value_correct,int pos,int book_confirm)
    {
        System.out.println("Which car would you like:");
        Micro.Show_cars(cars_micro, 3);
        Scanner s=new Scanner(System.in);
        while(value_correct==0)
        {
            System.out.println("Enter car no.(position from 0 to 2):");
            pos=s.nextInt();
                        try{
                            if(Location.type==0)//des,pickup only
                            {
                            cars_micro[pos].route_cost(Location.pick_up,Location.des,obj);
                            System.out.println("Cost will be:"+cars_micro[pos].cost);
                            }
                            else
                            {
                            cars_micro[pos].route_cost(Location.pick_up,Location.via,Location.des,obj);
                            System.out.println("Cost will be:"+cars_micro[pos].cost);
                            }
                            value_correct=1;
                            if(cars_micro[pos].Availability==true)
                            {
                                System.out.println("Car Details:");
                                cars_micro[pos].Display();
                                System.out.println("Do you want to continue this booking or select another car from same class?(1 to confirm)");
                            //scan book_confirm
                                 book_confirm=s.nextInt();
                            //book_confirm=1;
                            
                                if(book_confirm==1)
                                {
                                System.out.println("Your booking has been confirmed!!");
                                System.out.println("------------------------------------");
                                System.out.println("Details:");
                                System.out.println("Car Name:"+cars_micro[pos].car_name);
                                System.out.println("Cost:"+cars_micro[pos].cost);
                                DRiver.ChooseDriver(dri);
                                System.out.println("Email id of User:"+Database.CArray[uid].Email);
                                System.out.println("------------------------------------");
                                }
                            } 
                            else if(cars_micro[pos].Availability==false)
                                {
                                    System.out.println("This vehicle is not available!!");
                                    int aflag=0;
                                    for(int j=0;j<cars_micro.length&&aflag==0;j++)
                                    {
                                        if(cars_micro[j].Availability==true)
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