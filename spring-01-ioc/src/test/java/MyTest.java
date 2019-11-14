import com.Cat;
import com.Dog;
import com.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
        User user = context.getBean("user", User.class);
        Dog dog=context.getBean("dog", Dog.class);
        Cat cat=context.getBean("cat", Cat.class);
    }
}
