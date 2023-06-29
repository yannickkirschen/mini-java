public class TestClassW {
    public TestInstVar ti = new TestInstVar();

    public TestClassW() {
    }

    public int get() {
        ++ti.test;
        return ti.test;
    }
}
