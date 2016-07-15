package quoters;

import quoters.annotation.DeprecatedClass;
import quoters.annotation.InjectRandomInt;
import quoters.annotation.PostProxy;
import quoters.annotation.Profiling;

import javax.annotation.PostConstruct;

/**
 * Created by rpadalka on 29.05.16.
 */

@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class T800 implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    T800() {
        System.out.println("===============================");
        System.out.println("Phase 1 " + "repeat = " + repeat);
        System.out.println("===============================");
    }

    @PostConstruct
    public void init() {
        System.out.println("===============================");
        System.out.println("Phase 2 " + "repeat = " + repeat);
        System.out.println("===============================");
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("===============================");
        System.out.println("Phase 3 " + "repeat = " + repeat);

        for (int i = 0; i < repeat; i++) {
            System.out.println("Message = " + message);
        }

        System.out.println("===============================");
    }
}
