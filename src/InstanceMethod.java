public class InstanceMethod
{
    // Instance variable
    int age;
    // Instance method
    public void setAge(int newAge)
    {
        age = newAge; // Modifying the instance variable
    }
    public int getAge()
    {
        return age; // Accessing the instance variable
    }

    public static void main(String[] args)
    {
        // Creating an object
        InstanceMethod person = new InstanceMethod();

        // Using instance method to set age
        person.setAge(25);

        // Using instance method to get age
        System.out.println("Person's Age: " + person.getAge()); // Output: 25
    }
}

