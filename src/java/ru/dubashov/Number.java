package ru.dubashov;

public class Number {
    public static boolean isSimple(Integer integer) {
        if (integer < 2) {
            return false;
        }
        if (integer % 2 == 0) {
            return integer == 2;
        }
        if (integer % 3 == 0) {
            return integer == 3;
        }
        for (int i = 5; i * i <= integer; i += 6) {
            if (integer % i == 0 || integer % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
