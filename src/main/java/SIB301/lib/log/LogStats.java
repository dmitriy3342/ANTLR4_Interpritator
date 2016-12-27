package SIB301.lib.log;


public class LogStats {

    //флаг разрешающий выводить инфомрацию в лог
    private static boolean log = false;

    public static boolean isLog() {
        return log;
    }

    public static void println(Object o) {
        if (isLog())
            System.out.println(o);
    }

}
