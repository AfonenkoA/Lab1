public class Cheese extends Food
{
    public Cheese()
    {
        super("Сыр");
    }
    @Override
    public int calculateCalories() throws Exception
    {
        return 60;
    }
    @Override
    public void consume()
    {
        System.out.println(this + " съеден");
    }
}
