public class Database
{
    static int size=3;
    static Customer[] CArray = new Customer[5];
    public static void data()
    {
        CArray[0] = new Customer("Dhruv Sharma","9404341118","1324","dhruvsharma2031@gmail.com","abc123");
        CArray[1] = new Customer("Nitin Wartkar","8149334232","1556","nitinwartkar58@gmail.com","nitin1");
        CArray[2] = new Customer("Omega Warrior","9876514586","1132","crazy@omega.warrior","blastoff");
        CArray[0].feeddata=4;CArray[0].nfeed=3;
        CArray[0].feeddata=3;CArray[0].nfeed=4;
        CArray[0].feeddata=4;CArray[0].nfeed=5;

    }
    public static void Append()
    {
        try
        {
            CArray[size] = new Customer(Registration.Name,Registration.Mobile_no,Registration.Username,Registration.Email,Registration.Password);
            size=size+1;
           // System.out.println(size);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void Display(Customer[] d)
    {
        try
        {
            for(int i=0;i<size;i++)
            {
                System.out.println(d[i].Name);
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
