import demo02.Superman;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
       ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext2.xml");
       Superman man=(Superman)context.getBean("superman");
       System.out.println(man.toString());
    }
}
