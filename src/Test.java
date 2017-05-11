import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        Class businessLogicClass = MyClass.class;
        for (Method method : businessLogicClass.getMethods()) {
            Todo todoAnnotation = method.getAnnotation(Todo.class);
            if (todoAnnotation != null) {
                System.out.println(" Method Name : " + method.getName());
                System.out.println(" Author : " + todoAnnotation.author());
                System.out.println(" Priority : " + todoAnnotation.priority());
                System.out.println(" Status : " + todoAnnotation.status());
            }
        }

    }
}

class MyClass {
    @Todo(author = "Hehe", priority = Todo.Priority.MEDIUM, status = Todo.Status.STARTED)
    public void test() {

    }

    @Todo(author = "???")
    public void test2() {

    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    public enum Priority {LOW, MEDIUM, HIGH}

    public enum Status {STARTED, NOT_STARTED}

    String author() default "Yash";

    Priority priority() default Priority.LOW;

    Status status() default Status.NOT_STARTED;
}
