package mytestdemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Class[] classes = { TestCase.class, MediumTestCase.class, OtherTestClass.class };
        for (Class klass: classes) {
            TestBean testBean = (TestBean) klass.getAnnotation(TestBean.class);
            if (testBean == null || !testBean.createBy().equals("me"))
                continue;
            // submit test
            Method[] methods = klass.getMethods();
            for (Method method : methods) {
                TestMethod testMethod = method.getAnnotation(TestMethod.class);
                if (testMethod == null)
                    continue;
                try {
                    method.invoke(klass.newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
