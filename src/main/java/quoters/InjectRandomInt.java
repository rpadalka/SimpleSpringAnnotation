package quoters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by rpadalka on 29.05.16.
 */

@Retention(RetentionPolicy.RUNTIME)
@interface InjectRandomInt {
    int min();
    int max();
}
