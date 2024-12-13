public class NonstaticOverloading
{

        // Non-static method to multiply two integers
        public int multiply(int a, int b)
        {
            return a * b;
        }

        // Overloaded non-static method to multiply three integers
        public int multiply(int a, int b, int c)
        {
            return a * b * c;
        }

        // Overloaded non-static method to multiply two doubles
        public double multiply(double a, double b)
        {
            return a * b;
        }

        public static void main(String[] args)
        {
            NonstaticOverloading multiplier = new NonstaticOverloading(); // Create an object

            // Calling different versions of the non-static 'multiply' method
            System.out.println("Multiplication of two integers: " + multiplier.multiply(5, 10)); // 50
            System.out.println("Multiplication of three integers: " + multiplier.multiply(2, 3, 4)); // 24
            System.out.println("Multiplication of two doubles: " + multiplier.multiply(5.5, 1.2)); // 6.6
        }
}
