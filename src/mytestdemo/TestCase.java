package mytestdemo;

@TestBean(createBy = "me", priority = TestBean.Priority.HIGH)
public class TestCase {

    @TestMethod
    public void test1() {
        System.out.println("running test1");
    }

    @TestMethod
    public void test2() {
        System.out.println("running test2");
    }

    @TestMethod
    public void test3() {
        System.out.println("running test3");
    }
}

