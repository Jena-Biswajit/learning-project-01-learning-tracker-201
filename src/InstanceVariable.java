public class InstanceVariable
{
    String name;

    public static void main(String[] args)
    {
        // Creating objects
        InstanceVariable obj1 = new InstanceVariable();
        InstanceVariable obj2 = new InstanceVariable();

        // Assigning values to instance variables
        obj1.name = "Biswa";
        obj2.name = "Jit";

        // Accessing instance variables
        System.out.println("Object 1 Name: " + obj1.name); // Output: Alice
        System.out.println("Object 2 Name: " + obj2.name); // Output: Bob
    }
}
