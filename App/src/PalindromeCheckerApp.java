import java.util.*;

public class PalindromeCheckerApp {

    // Method 1: Reverse String
    public static boolean reverseMethod(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return str.equals(reversed);
    }

    // Method 2: Two Pointer
    public static boolean twoPointerMethod(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Method 3: Stack
    public static boolean stackMethod(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        long startTime, endTime;

        // Reverse method
        startTime = System.nanoTime();
        boolean r1 = reverseMethod(input);
        endTime = System.nanoTime();
        long time1 = endTime - startTime;

        // Two pointer method
        startTime = System.nanoTime();
        boolean r2 = twoPointerMethod(input);
        endTime = System.nanoTime();
        long time2 = endTime - startTime;

        // Stack method
        startTime = System.nanoTime();
        boolean r3 = stackMethod(input);
        endTime = System.nanoTime();
        long time3 = endTime - startTime;

        System.out.println("\nResults:");
        System.out.println("Reverse Method: " + r1 + " | Time: " + time1 + " ns");
        System.out.println("Two Pointer Method: " + r2 + " | Time: " + time2 + " ns");
        System.out.println("Stack Method: " + r3 + " | Time: " + time3 + " ns");

        sc.close();
    }
}