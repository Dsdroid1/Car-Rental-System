public class Customer extends Person
{
    String Email;
    String Username;
    String Password;
    Customer[] CArray = new Customer[4];
    Customer(String Name,String Mobile_no,String  Username,String Email,String Password)
    {
        this.Name = Name;
        this.Mobile_no = Mobile_no;
        this.Email = Email;
        this.Password = Password;
        this.Username = Username;
    }

}
