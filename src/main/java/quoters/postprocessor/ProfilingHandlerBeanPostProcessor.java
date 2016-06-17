package quoters.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import quoters.profiling.ProfilingController;
import quoters.annotation.Profiling;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rpadalka on 29.05.16.
 */
public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Class> map = new HashMap<>();
    private ProfilingController controller = new ProfilingController();

    public ProfilingHandlerBeanPostProcessor() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        platformMBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        Class<?> beanClass = o.getClass();

        if (beanClass.isAnnotationPresent(Profiling.class)) {
            map.put(s, beanClass);
        }

        return o;
    }

    @Override
    public Object postProcessAfterInitialization(final Object o, String s) throws BeansException {
        Class beanClass = map.get(s);

        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {
                if (controller.isEnabled()) {
                    System.out.println("+++++ BEGIN Profiling +++++");
                    long before = System.nanoTime();
                    Object retVal = method.invoke(o, args);
                    long after = System.nanoTime();
                    System.out.println(after - before);
                    System.out.println("+++++ END Profiling +++++");

                    return retVal;
                } else {
                    return method.invoke(o, args);
                }
            });
        }

        return o;
    }
}
