public class StaticExample
{
    static int staticVariable;

    // Static block
    static
    {
        staticVariable = 42;
        System.out.println("Static block executed. Static variable initialized.");
    }

    public static void main(String[] args)
    {
        System.out.println("Static Variable: " + staticVariable);
    }
}
