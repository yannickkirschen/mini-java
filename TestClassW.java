public class TestClassW {
    public TestInstVar var1;

    public TestClassW() {
        var1 = new TestInstVar();
    }

    public int getInstVar(){
        return var1.test;
    }
}
