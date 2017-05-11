package mytestdemo;

@TestBean(createBy = "me", priority = TestBean.Priority.LOW)
class MediumTestCase {

    @TestMethod
    public void test3() {
        System.out.println("running test3 on MediunTest");
    }
}
