public class TestStaticStuff{
    private static String test = "I haven't used the constructor";

    public TestStaticStuff(){
        this.test = "I have used the constructor";
    }

    public static void printTest(){
        System.out.println(test);
    }
    public static void main(String[] args) {
        TestStaticStuff.printTest();
    }

}