public abstract class Food implements Consumable
{
    private String name = null;
    Food(String name)
    {
        this.name = name;
    }
    @Override
    public String toString()
    {
        return name;
    }
    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Food)) return false;
        if (name==null || ((Food) o).name==null) return false;
        return name.equals(((Food)o).name);
    }
}
