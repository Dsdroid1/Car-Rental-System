import java.util.Scanner;
import java.util.Random;
public class Car{
    String Category;//mini,micro or prime
    String car_name;
    String color;
    String number;
    int cost_till_5_km;
    int cost_per_km;
    int seats;
    int cost;
    boolean Availability;
    
    

    void Initialization(String car_name,String color,String number,int seats)
    {
        this.car_name=car_name;
        this.color=color;
        this.number=number;
        this.seats=seats;
        Random r=new Random();
        this.Availability=r.nextBoolean();
    }

    void Display()
    {
        System.out.println("-----------------------------");
        System.out.println("Category:"+Category);
        System.out.println("Car name:"+car_name);
        System.out.println("Color:"+color);
        System.out.println("Number Plate:"+number);
        System.out.println("Cost till 5km:"+cost_till_5_km);
        System.out.println("Per-Km-Cost(after 5km):"+cost_per_km);
        System.out.println("No.of seats:"+seats);
        System.out.println("-----------------------------");
    }

   

    void route_cost(int pick_up,int des,Location[] locations)
    {
        if(locations[pick_up].km[des]<5)
        {
            this.cost = this.cost_till_5_km;
        }
        else
        {
            this.cost = this.cost_till_5_km+(locations[pick_up].km[des]-5)*this.cost_per_km;
        }
    }
    void route_cost(int pick_up,int via,int des,Location[] locations)
    {
        route_cost(pick_up,via,locations);
        this.cost = this.cost + (locations[via].km[des])*this.cost_per_km;
    }
}