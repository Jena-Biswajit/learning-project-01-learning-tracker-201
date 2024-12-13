public class MyStaticclass
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

/*
4. Purpose of Static Variables and Methods:
   - Static variables are shared across all instances of a class. They are useful for values that do not change with each object, e.g., constants.
   - Static methods belong to the class itself and can be accessed without creating an object. They are useful for utility or helper methods.
   - Example: A static `sum` method adds two numbers without depending on instance variables.

Link to Project: [Add the link to your GitHub repository here]
*/

