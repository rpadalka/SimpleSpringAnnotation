package quoters;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import quoters.applicationcontext.PropertyFileApplicationContext;

/**
 * Created by rpadalka on 29.05.16.
 */

public class QuoterTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public QuoterTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( QuoterTest.class );
    }

    public void testApp() throws InterruptedException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        System.out.println("PostProxy annotation. ContextRefreshedEvent. END\n");

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            applicationContext.getBean(Quoter.class).sayQuote();
        }

        PropertyFileApplicationContext propertyContext = new PropertyFileApplicationContext("context.properties");
        propertyContext.getBean(Quoter.class).sayQuote();
    }
}
