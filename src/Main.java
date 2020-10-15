import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args)
    {
        try
        {
            Food[] breakfast = new Food[20];
            int foodIt = 0;
            for (String arg : args)
            {
                String[] parts = arg.split("/");
                Class myClass = Class.forName(parts[0]);
                if (parts.length == 2)
                {
                    Constructor constructor = myClass.getConstructor(String.class);
                    breakfast[foodIt] = (Food)constructor.newInstance(parts[1]);
                }
                foodIt++;
            }
            for (Food item: breakfast)
                if (item!=null)
                    item.consume();
                else
                    break;
            System.out.println("Всего хорошего!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
