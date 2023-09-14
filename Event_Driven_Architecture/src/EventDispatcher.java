import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import jdk.internal.icu.impl.UBiDiProps;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class EventDispatcher {
    private final Map<Class<?>, List<Object>> eventHandlers = new HashMap<>();


    public void registerEventHandler (Class<?> eventType, Object eventHandler) {
        eventHandlers.computeIfAbsent(eventType, k ->new ArrayList<>()).add(eventHandler);
    }

    public void dispatchEvent (Object event)
    {

        List<Object> handlers = eventHandlers.getOrDefault(event.getClass(), Collections.emptyList());
        handlers.forEach(handler -> invokeEventHandle(handler, event));
    }

    private void invokeEventHandle(Object handler, Object event) {
        try {
            Method method=handler.getClass().getMethod("onOrderPlaced", event.getClass());
            method.invoke(handler, event);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
    }
}
