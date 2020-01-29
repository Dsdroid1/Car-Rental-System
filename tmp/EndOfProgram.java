import java.util.Scanner;
interface feedback_ask
{

    int max_rating=5;
    int min_rating=0;
    public void feedback();
    void checkout();
}

public class EndOfProgram implements feedback_ask
{
    int f1;
    int f2;
    int f3;
    int overall_rating;
    public void feedback(EndOfProgram e)
    {
        System.out.println("Your booking has been completed,please take sometime to give us your valuable feedback!!");
        Scanner s=new Scanner(System.in);
        System.out.println("------------------------------------------");
        System.out.println("1.How was our user interface(from 0-5):");
        e.f1=s.nextInt();
        while(e.f1<0||e.f1>5)
        {
            System.out.println("Please enter valid number!!");
            e.f1=s.nextInt();
        }
        System.out.println("2.How helpful was this app to you(from 0-5):");
        e.f2=s.nextInt();
        while(e.f2<0||e.f2>5)
        {
            System.out.println("Please enter valid number!!");
            e.f2=s.nextInt();
        }
        System.out.println("3.How likely are you to recommend us to a friend(from 0-5):");
        e.f3=s.nextInt();
        while(e.f3<0||e.f3>5)
        {
            System.out.println("Please enter valid number!!");
            e.f3=s.nextInt();
        }
        System.out.println("Thank You!Your feedback has been recorded!");
        e.overall_rating=(e.f1+e.f2+e.f3)/3;
    } 
    public void checkout( EndOfProgram e)
    {
        System.out.println("Averaged Feedback:"+e.overall_rating);
    }
}