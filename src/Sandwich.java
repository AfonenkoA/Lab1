public class Sandwich extends Food
{
    private String filling1 = null;
    private String filling2 = null;

    public Sandwich(String filling1,String filling2)
    {
        super("Бутерброд");
        this.filling1 = filling1;
        this.filling2 = filling2;
    }
    @Override
    public boolean equals(Object o)
    {
        if(super.equals(o))
        {
            if (!(o instanceof Sandwich)) return false;
            return filling1.equals(((Sandwich) o).filling1) && filling2.equals(((Sandwich) o).filling2);
        }
        return false;
    }
    @Override
    public int calculateCalories() throws Exception
    {
       if(filling1!=null && filling2!=null)
       {
           int calories = 0;
           if(filling1.equals("колбаса"))
               calories += 200;
           if(filling1.equals("сыр"))
               calories += 50;
           return calories;
       }
       throw new Exception("Неизвестная начинка");
    }
    @Override
    public String toString()
    {
        return super.toString() + " с начинкой '" + filling1.toUpperCase() + "' и '" + filling2.toUpperCase() + "'";
    }
    @Override
    public void consume()
    {
        System.out.println(this + " съеден");
    }
}
