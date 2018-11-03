public class PositionUtils {
    public static String center(String s, int size) {
        return center(s, size, ' ');
    }

    public static String center(String s, int size, char pad) {
        if (s == null || size <= s.length())
            return s;
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < (size - s.length()) / 2 - 1; i++) {
            sb.append(pad);
        }
        sb.append(s);
//        while (sb.length() <size) {
//            sb.append(pad);
//        }
        return sb.toString();
    }

    public static String Position(String s1, Boolean left, int size, int startSize) {
        return Position(s1, left, size, startSize, ' ');
    }

    public static String Position(String s1, Boolean left, int size, int startSize, char pad) {
        if (s1 == null || size <= s1.length())
            return "";
        StringBuilder sb = new StringBuilder(size);
        if (left) {
            for (int i = 0; i < startSize; i++) {
                sb.append(pad);
            }

        } else {
            for (int i = 0; i < (size - startSize - s1.length()); i++) {
                sb.append(pad);
            }
        }
        sb.append(s1);
//        while (sb.length() <size) {
//            sb.append(pad);
//        }
        return sb.toString();
    }

    public static String Position(String s1, String s2, int size, int leftSize, int rightSize) {
        return Position(s1, s2, size, leftSize, rightSize, ' ');
    }

    public static String Position(String s1, String s2, int size, int leftSize, int rightSize, char pad) {
        if (s1 == null || s2 == null || size <= s1.length() + s2.length())
            return "";
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < leftSize; i++) {
            sb.append(pad);
        }
        sb.append(s1);
        for (int i = 0; i < (size - leftSize - rightSize - s1.length() - s2.length()); i++) {
            sb.append(pad);
        }
        sb.append(s2);
//        while (sb.length() <size) {
//            sb.append(pad);
//        }
        return sb.toString();
    }
}