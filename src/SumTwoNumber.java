public class SumTwoNumber
{
    // Static variable
    static String message = "The sum is:";

    // Static method
    public static int sum(int a, int b)
    {
        return a + b;
    }

    public static void main(String[] args)
    {
        // Call the static method
        int result = sum(10, 20);

        // Print the result using the static variable
        System.out.println(message + " " + result);
    }
}
