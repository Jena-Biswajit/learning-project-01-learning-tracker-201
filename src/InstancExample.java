public class InstancExample
{
    int instanceVariable;

    // Instance block
    {
        instanceVariable = 99;
        System.out.println("Instance block executed. Instance variable initialized.");
    }

    public InstancExample() {
        System.out.println("Constructor executed.");
    }

    public static void main(String[] args) {
        InstancExample obj = new InstancExample();
        System.out.println("Instance Variable: " + obj.instanceVariable);
    }
}
