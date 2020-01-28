import java.util.Scanner;
public class Prime extends Car{
    Prime(String car_name,String color,String number,int seats)
        {
            this.Category="Prime";
            this.cost_till_5_km=60;
            super.Initialization(car_name, color, number,seats);
            this.cost_per_km=10;
        }
    static void Show_cars(Prime[] cars_prime,int size)
        {/*
            for(int i=0;i<size;i++)
            {
                cars_prime[i].Display();
            }*/
            Prime.minimal_display(cars_prime,size);
        }

        static void minimal_display(Prime[] cars_prime,int size)
        {
            System.out.println("Your choices in this segment are:");
            System.out.println("**********************************************");
            for(int i=0;i<size;i++)
            {
                    System.out.println("*Option No: "+i+" **  Car Name:" + cars_prime[i].car_name);
            }
            System.out.println("**********************************************");
        }

        static int ui(Prime[] cars_prime,Location[] obj,DRiver[] dri,int uid,int value_correct,int pos,int book_confirm)
        {
            System.out.println("Which car would you like:");
            Prime.Show_cars(cars_prime, 3);
            Scanner s=new Scanner(System.in);
            while(value_correct==0)
            {
                System.out.println("Enter car no.(position from 0 to 2):");
                pos=s.nextInt();
                            try{
                                if(Location.type==0)//des,pickup only
                                {
                                cars_prime[pos].route_cost(Location.pick_up,Location.des,obj);
                                System.out.println("Cost will be:"+cars_prime[pos].cost);
                                }
                                else
                                {
                                cars_prime[pos].route_cost(Location.pick_up,Location.via,Location.des,obj);
                                System.out.println("Cost will be:"+cars_prime[pos].cost);
                                }
                                value_correct=1;
                                if(cars_prime[pos].Availability==true)
                                {
                                    System.out.println("Car Details:");
                                    cars_prime[pos].Display();
                                    System.out.println("Do you want to continue this booking or select another car from same class?(1 to confirm)");
                                //scan book_confirm
                                     book_confirm=s.nextInt();
                                //book_confirm=1;
                                
                                    if(book_confirm==1)
                                    {
                                    System.out.println("Your booking has been confirmed!!");
                                    System.out.println("------------------------------------");
                                    System.out.println("Details:");
                                    System.out.println("Car Name:"+cars_prime[pos].car_name);
                                    System.out.println("Cost:"+cars_prime[pos].cost);
                                    DRiver.ChooseDriver(dri);
                                    System.out.println("Email id of User:"+Database.CArray[uid].Email);
                                    System.out.println("------------------------------------");
                                    }
                                } 
                                else if(cars_prime[pos].Availability==false)
                                    {
                                        System.out.println("This vehicle is not available!!");
                                        int aflag=0;
                                        for(int j=0;j<cars_prime.length&&aflag==0;j++)
                                        {
                                            if(cars_prime[j].Availability==true)
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
