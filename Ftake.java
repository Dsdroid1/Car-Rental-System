import java.util.Scanner;
interface feedback_setup
{
    int max_rating=5;
    int min_rating=0;
    public void Takefeedback(feedback e);
    public void Showfeedback(feedback e);
}

class Ftake implements feedback_setup
{
    
    public void Takefeedback(feedback e)
    {
  
        System.out.println("Your booking has been completed,please take sometime to give us your valuable feedback!!");
        Scanner s=new Scanner(System.in);
        System.out.println("------------------------------------------");
        System.out.println("1.How was our user interface(from "+min_rating+"-"+max_rating+"):");
        e.f1=s.nextInt();
        while(e.f1<0||e.f1>5)
        {
            System.out.println("Please enter valid number!!");
            e.f1=s.nextInt();
        }
        System.out.println("2.How helpful was this app to you:(from "+min_rating+"-"+max_rating+"):");
        e.f2=s.nextInt();
        while(e.f2<0||e.f2>5)
        {
            System.out.println("Please enter valid number!!");
            e.f2=s.nextInt();
        }
        System.out.println("3.How likely are you to recommend us to a friend(from "+min_rating+"-"+max_rating+"):");
        e.f3=s.nextInt();
        while(e.f3<0||e.f3>5)
        {
            System.out.println("Please enter valid number!!");
            e.f3=s.nextInt();
        }
        System.out.println("Thank You!Your feedback has been recorded!");
        e.overall=(e.f1+e.f2+e.f3)/3;
    
    }
    public void Showfeedback(feedback e)
    {
        System.out.println("Average rating:"+e.overall);

    }
}