public class IndexMapping
{
    public static void main(String[]args)
    {
        // Define the 2D array
        int[][] array =
                {
                        {10, 21},
                        {22, 13}
                };
        int givenIndex =1;

        // Dimensions of the 2D array
        int rows = array.length;       // Number of rows
        int cols = array[0].length;    // Number of columns

        // Calculate row and column from the 1D index
        int row = givenIndex / cols;   // Integer division
        int col = givenIndex % cols;   // Remainder

        // Fetch the value at the calculated row and column
        int value = array[row][col];

        // Print the value
        System.out.println("Value at index " + givenIndex + ": " + value);
    }
}
