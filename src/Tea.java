public class Tea extends Food implements Nutritious
{
    private String color;
    public Tea(String color)
    {
        super("Чай");
        this.color = color;
    }
    @Override
    public int calculateCalories()
    {
        return 100;
    }
    @Override
    public boolean equals(Object o)
    {
        if(super.equals(o))
        {
            if (!(o instanceof Tea)) return false;
                return color.equals(((Tea) o).color);
        }
        return false;
    }
    @Override
    public  String toString()
    {
        return super.toString() + " цвета '" + color.toUpperCase() + "'";
    }
    @Override
    public void consume()
    {
        System.out.println(this + " выпит");
    }
}
