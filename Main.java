public class Main {
    public static void main(String[] args) {
        System.out.println(calculateMinOperations("NOZAPHODJUSTVERYVERYIMPROBABLE"));
    }

    //"ESPRIT" ===> ""
    public static int calculateMinOperations(String input) {
        if (input == null || input.length() < 2)
            return -1;
        char[] chars = input.toCharArray();
        int numOfOperations = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                if (chars[i] != chars[i + 1]) {
                    numOfOperations += Math.abs(chars[i + 1] - chars[i]);
                    chars[i] = chars[i + 1];
                }
            } else if (i == chars.length - 1) {
                if (chars[i] != chars[i - 1]) {
                    numOfOperations += Math.abs(chars[i - 1] - chars[i]);
                    chars[i] = chars[i - 1];
                }
            } else {
                if (chars[i] != chars[i - 1] && chars[i] != chars[i + 1]) {
                    int leftDiff = Math.abs(chars[i] - chars[i - 1]);
                    int rightDiff = Math.abs(chars[i] - chars[i + 1]);
                    int minDiff = Math.min(leftDiff, rightDiff);
                    chars[i] = minDiff == rightDiff ? chars[i + 1] : chars[i - 1];
                    numOfOperations += minDiff;
                }
            }
        }
        System.out.println(chars);
        return numOfOperations;
    }
}
