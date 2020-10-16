import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;

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
                if(parts[0].startsWith("-"))
                {
                    if(parts[0].equals("-calories"))
                    {
                        int calories = 0;
                        for(Food f : breakfast)
                            if(f!=null)
                                calories += f.calculateCalories();
                            else break;
                        System.out.println("Общая калорийность " + calories);
                        continue;
                    }
                    if(parts[0].equals("-sort"))
                    {
                        Arrays.sort(breakfast, new Comparator<Food>() {
                            @Override
                            public int compare(Food o1, Food o2)
                            {
                                if (o1 == null) return 1;
                                if (o2 == null) return -1;
                                Integer l1 = o1.getName().length();
                                Integer l2 = o2.getName().length();
                                return l1.compareTo(l2);
                            }
                        });
                        continue;
                    }
                }
                try
                {
                    Class myClass = Class.forName(parts[0]);
                    if (parts.length == 2)
                    {
                        Constructor constructor = myClass.getConstructor(String.class);
                        breakfast[foodIt] = (Food) constructor.newInstance(parts[1]);
                    }
                    if (parts.length == 3)
                    {
                        Constructor constructor = myClass.getConstructor(String.class,String.class);
                        breakfast[foodIt] = (Food) constructor.newInstance(parts[1],parts[2]);
                    }
                    foodIt++;
                }
                catch (ClassNotFoundException | NoSuchMethodException e)
                {
                    System.out.println("Продукт " + parts[0] + " не может быть добавлен в завтрак");
                }
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
