public class Tea extends Food
{
    private String color;
    public Tea(String color)
    {
        super("Чай");
        this.color = color;
    }
    @Override
    public int calculateCalories() throws Exception
    {
        if(color.equals("чёрный"))
            return 100;
        else
        {
            if(color.equals("зелёный"))
                return 50;
            throw new Exception("Неизвестный тип чая");
        }
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
