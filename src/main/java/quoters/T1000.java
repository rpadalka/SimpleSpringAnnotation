package quoters;

import quoters.annotation.PostProxy;
import quoters.annotation.Profiling;

/**
 * Created by rpadalka on 23.06.16.
 */

@Profiling
public class T1000 extends T800 implements Quoter {

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("===============================");
        System.out.println("Phase 3");
        System.out.println("I'm liquid!");
        System.out.println("===============================");
    }
}
