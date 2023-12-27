public class EllysString {
    public static void main(String[] args) {
        System.out.println(calculateMinOperations("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    public static int calculateMinOperations(String input) {
        // Check if the input is valid
        if (input == null || input.length() < 2) {
            return -1;
        }

        char[] chars = input.toCharArray();
        int numOfOperations = 0;

        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];

            // Check if it's not the first or last character
            if (i > 0 && i < chars.length - 1) {
                char prev = chars[i - 1];
                char next = chars[i + 1];

                if (current != prev && current != next) {
                    // Calculate differences and update character to its twin
                    int leftDiff = Math.abs(current - prev);
                    int rightDiff = Math.abs(current - next);
                    int minDiff = Math.min(leftDiff, rightDiff);

                    chars[i] = (minDiff == rightDiff) ? next : prev;
                    numOfOperations += minDiff;
                }
            } else if (i == 0 && current != chars[i + 1]) {
                // Update first character to its twin and count operations
                numOfOperations += Math.abs(chars[i + 1] - current);
                chars[i] = chars[i + 1];
            } else if (i == chars.length - 1 && current != chars[i - 1]) {
                // Update last character to its twin and count operations
                numOfOperations += Math.abs(current - chars[i - 1]);
                chars[i] = chars[i - 1];
            }
        }

        System.out.println(chars);
        return numOfOperations;
    }
}
