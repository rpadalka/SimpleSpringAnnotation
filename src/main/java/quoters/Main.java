package quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by rpadalka on 29.05.16.
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        applicationContext.getBean(Quoter.class).sayQuote();
    }
}
