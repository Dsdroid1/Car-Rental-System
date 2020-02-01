
import java.util.Scanner;
import feedback.feedback;


public class Main
{
    static int part_1=0;
    public static void main(String[] args)
    {
        Database.data();
        
        Scanner s = new Scanner(System.in);
       // Database.Display(Database.CArray);
        while(part_1==0)
        {
            
            System.out.println("---------Welcome---------");
            System.out.println("Enter 1 for Login, 2 for Registration");
            int temp;
            temp = s.nextInt();
            if(temp == 1)
            {
                Login.TakeInput();
<<<<<<< HEAD
               
=======
                //part_1=1;
>>>>>>> c974832887a0fec673495c700888ac329ece7921
                
            }
            else
            {
                Registration.TakeInputOfRegistration();
                System.out.println("Returning to main screen!!");
               
                
            }
        }
        int uid=Login.pos_in_db;
        System.out.println("---------------------------------");
            //Database.Display(Database.CArray);
        System.out.println("Hello,"+Database.CArray[uid].Name+" and Welcome!!:");
        

        Mini[] cars_mini=new Mini[3];
        cars_mini[0]=new Mini("Suzuki","White","QWERTY",3);
        cars_mini[1]=new Mini("Hyundai","Black","ASDFGH",3);
        cars_mini[2]=new Mini("Tata","Silver", "ZXCVBN",4);

        Micro[] cars_micro=new Micro[3];
        cars_micro[0]=new Micro("Honda","Grey","POIUYT",2);
        cars_micro[1]=new Micro("Volkswagon","Red","LKJHGF",2);
        cars_micro[2]=new Micro("Jeep","Velvet","MNBVCX",3);

        Prime[] cars_prime=new Prime[3];
        cars_prime[0]=new Prime("Tesla","Crimson","ADRFCS",3);
        cars_prime[1]=new Prime("Mitsubushi","White","JFHTYG",2);
        cars_prime[2]=new Prime("BMW","Violet","DIGHUT",2);

        //Cars initialisation done

        Location[] obj = new Location[5];
        obj[0] = new Location("Nagpur",0,new int[] {0,2,4,6,8});
        obj[1] = new Location("Goa",1,new int[] {2,0,5,7,3});
        obj[2] = new Location("Mumbai",2,new int[] {4,5,0,3,4});
        obj[3] = new Location("Nashik",3,new int[] {6,7,3,0,9});
        obj[4] = new Location("Pune",4,new int[] {8,3,4,9,0});

        //Locations initialisation done
        //Initialise drivers
        DRiver[] dri = new DRiver[3];
        dri[0] = new DRiver("Jake Peralta","9800025320","LPCT19",true);
        dri[1] = new DRiver("Doug Judy","9800025321","DXCE25",true);
        dri[2] = new DRiver("Amy Santiago","9800025322","MANA30",true);

        Location.Options_Display(obj);

        System.out.println("------");
        System.out.println("So, your path is:");
        if(Location.type==0)
        {
            System.out.println(obj[Location.pick_up].Loc_name+" ----> "+ obj[Location.des].Loc_name);
        }
        else
        {
            System.out.println(obj[Location.pick_up].Loc_name+" ---> "+obj[Location.via].Loc_name+" ---> "+ obj[Location.des].Loc_name);
        }

        //cars part starts here!!!
        System.out.println("---------------------------------------");
        
        System.out.println("What type of car would you prefer?:");
        System.out.println("1.Micro[Budget cars for longer distances]");
        System.out.println("2.Mini[Suitable for small distance rides]");
        System.out.println("3.Prime[Luxury cars to get you a KING feeling!]");
        System.out.println("4.Exit");//add defualt condition as exit.
        System.out.println("---------------------------------------");

        int car_type=1;
        car_type=s.nextInt();
        int book_confirm=0;
        feedback e=new feedback(0,0,0);
        Ftake f=new Ftake();
        while(book_confirm!=1)
        {
            int pos=0;
            int value_correct=0;

            switch(car_type)
            {
            case 1: book_confirm=Micro.ui(cars_micro,obj,dri,uid,value_correct,pos,book_confirm);
                    
                    f.Takefeedback(e);
                    f.Showfeedback(e);
                    Database.CArray[uid].feeddata=(Database.CArray[uid].feeddata*Database.CArray[uid].nfeed+(e.overall))/(Database.CArray[uid].nfeed+1);
                    Database.CArray[uid].nfeed=Database.CArray[uid].nfeed+1;
                    System.out.println("Your aggregate feedback:"+Database.CArray[uid].feeddata);
                    break;
                   
                    
            case 2: book_confirm=Mini.ui(cars_mini,obj,dri,uid,value_correct,pos,book_confirm);
                                        
                    f.Takefeedback(e);
                    f.Showfeedback(e);
                    Database.CArray[uid].feeddata=(Database.CArray[uid].feeddata*Database.CArray[uid].nfeed+(e.overall))/(Database.CArray[uid].nfeed+1);
                    Database.CArray[uid].nfeed=Database.CArray[uid].nfeed+1;
                    System.out.println("Your aggregate feedback:"+Database.CArray[uid].feeddata);
                    break;

            case 3: book_confirm=Prime.ui(cars_prime,obj,dri,uid,value_correct,pos,book_confirm);
                    f.Takefeedback(e);
                    f.Showfeedback(e);
                    Database.CArray[uid].feeddata=(Database.CArray[uid].feeddata*Database.CArray[uid].nfeed+(e.overall))/(Database.CArray[uid].nfeed+1);
                    Database.CArray[uid].nfeed=Database.CArray[uid].nfeed+1;
                    System.out.println("Your aggregate feedback:"+Database.CArray[uid].feeddata);
                    break;

            case 4: book_confirm=1;
                    break;
            
            default: book_confirm=1;
                     break;

            }
        }

        


    }
}

