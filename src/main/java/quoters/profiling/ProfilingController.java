package quoters.profiling;

/**
 * Created by rpadalka on 29.05.16.
 */
public class ProfilingController implements ProfilingControllerMBean {

    private boolean enabled = false;

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
