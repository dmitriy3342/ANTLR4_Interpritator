package SIB301.lib.context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EContext<T> {

    private String key;
    private T value;
    private EContext<T> parent;
    private Map<String, EContext<T>> child;

    public EContext(String key, T value, EContext<T> parent, Map<String, EContext<T>> child) {
        this.key = key;
        this.value = value;
        this.parent = parent;
        this.child = child;
    }

    public EContext(String key, T value, EContext<T> parent) {
        this(key, value, parent, new HashMap<>());
    }

    public EContext(String key, T value) {
        this(key, value, null);
    }

    public EContext(String key) {
        this(key, null);
    }

    public EContext() {
        this("_BASE_");
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public EContext<T> getParent() {
        return parent;
    }

    public void setParent(EContext<T> parent) {
        this.parent = parent;
    }

    public Map<String, EContext<T>> getChild() {
        return child;
    }

    public EContext<T> getChildContext(String key) {
        return child.get(key);
    }

    public void setChild(Map<String, EContext<T>> child) {
        this.child = child;
    }

    public void addChild(String key, T element) {
        EContext<T> context = this;
        String[] tmp = key.replace(".", "::").split("::");
        for (String str : tmp) {
            EContext<T> c = context.getChildContext(str);
            if (c == null) {
                c = new EContext<T>(str, null, this);
                context.child.put(str, c);
                context = c;
            } else {
                context = c;
            }
        }
        context.setValue(element);
    }


    public T findChild(String key) {
        EContext<T> context1 = this;
        EContext<T> context2 = this;


        String[] tmp = key.replace(".", "::").split("::");

        ArrayList<String> tmpArr = new ArrayList<String>();

        for(String s: tmp)tmpArr.add(s);


        while (tmp != null) {
            while (context1 != null) {

                EContext<T> c = context1;
                EContext<T> c2 = c;

                for (int i = 0; i < tmpArr.size(); i++) {
                    c2 = c.getChildContext(tmpArr.get(i));
                    if (c2 == null)
                        continue;
                    else {
                        context2 = c = c2;
                    }
                    if (c2.key.equals(tmpArr.get(tmpArr.size() - 1)))
                        return c2.getValue();
                }

                context1 = context1.parent;
            }
            context1 = this;

            if(tmpArr.size()<=1)return null;

            tmpArr.remove(tmpArr.size()-2);
        }
        return null;
    }

}

