package src;

import java.util.HashMap;
import java.util.Map;


/**
 * 自定义Integer类
 */
public class IntegerExt {

    private int i;

    private static Map<String, IntegerExt> map = new HashMap<>(256);

    private IntegerExt(int i) {
        this.i = i;
    }

    public int toIntValue() {
        return i;
    }

    public static IntegerExt getInstance(int i) {
        String s = String.valueOf(i);
        //查看是否在map中
        if (map.containsKey(s)) {
            return map.get(s);
        }
        IntegerExt rs = new IntegerExt(i);
        //没有就存
        if (i >= -128 && i <= 127) {
            map.put(s, rs);

        }
        return rs;

    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof IntegerExt) {
            return this.i == ((IntegerExt) o).toIntValue();
        }
        return super.equals(o);
    }


}
