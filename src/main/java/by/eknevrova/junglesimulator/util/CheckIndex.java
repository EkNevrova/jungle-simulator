package by.eknevrova.junglesimulator.util;

public class CheckIndex {
    public static int check(int index) {
        if (index > 100) {
            index = 100;
        } else if (index < 0) {
            index = 0;
        }
        return index;
    }
}
