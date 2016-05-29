package quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by rpadalka on 29.05.16.
 */
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        Field[] declaredFields = o.getClass().getDeclaredFields();

        for (Field field : declaredFields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);

            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();

                Random random = new Random();
                int randomInt = min + random.nextInt(max - min);

                field.setAccessible(true);
                ReflectionUtils.setField(field, o, randomInt);
            }
        }

        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
