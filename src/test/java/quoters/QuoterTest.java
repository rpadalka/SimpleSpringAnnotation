package quoters;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by rpadalka on 29.05.16.
 */

// ToDo write right tests
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

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        applicationContext.getBean(T800.class).sayQuote();

        assertTrue( true );
    }
}
