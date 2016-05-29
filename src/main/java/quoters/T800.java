package quoters;

import javax.annotation.PostConstruct;

/**
 * Created by rpadalka on 29.05.16.
 */

@Profiling
public class T800 implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

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
    public void sayQuote() {
        System.out.println("===============================");

        for (int i = 0; i < repeat; i++) {
            System.out.println("Message = " + message);
        }

        System.out.println("===============================");
    }
}
