package feedback;
public class feedback
{
    public int f1,f2,f3;
    public float overall;
    public feedback(int f1,int f2,int f3)
    {
        this.f1=f1;
        this.f2=f2;
        this.f3=f3;
        this.overall=(f1+f2+f3)/3;
    }
    
}

