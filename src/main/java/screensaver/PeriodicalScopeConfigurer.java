package screensaver;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rpadalka on 25.7.16.
 */
public class PeriodicalScopeConfigurer implements Scope {

    private Map<String, Pair<LocalTime, Object>> map = new HashMap<>();

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        if (map.containsKey(s)) {
            Pair<LocalTime, Object> pair = map.get(s);
            long secondsSinceLastRequest = ChronoUnit.SECONDS.between(pair.getKey(), LocalTime.now());

            if (secondsSinceLastRequest > 3) {
                map.put(s, new Pair<>(LocalTime.now(), objectFactory.getObject()));
            }
        } else {
            map.put(s, new Pair<>(LocalTime.now(), objectFactory.getObject()));
        }

        return map.get(s).getValue();
    }

    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
