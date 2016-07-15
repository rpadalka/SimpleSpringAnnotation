package quoters.applicationcontext;

import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by rpadalka on 15.7.16.
 */
public class PropertyFileApplicationContext extends GenericApplicationContext {

    public PropertyFileApplicationContext(String fileName) {
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
        int beansCount = reader.loadBeanDefinitions(fileName);
        System.out.println("Found " + beansCount + " beans");
        refresh();
    }
}
