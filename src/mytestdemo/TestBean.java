package mytestdemo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestBean {
    enum Priority {LOW, MEDIUM, HIGH}

    String createBy() default "admin";

    Priority priority() default Priority.MEDIUM;
}
