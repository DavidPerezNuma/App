import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        int input;

        // Input prompt for the user
        System.out.println("Enter positive integers (maximum 1000, minimum 100). Enter 0 to finish:");

        /*
         * Data input loop: 
         * Accepts integers from the user until the maximum size of 1000 is reached 
         * or until the sentinel value 0 is entered to terminate the input process.
         */
        while (numbers.size() < 1000) {
            input = scanner.nextInt();
            if (input == 0) break;  // Sentinel value to end input
            if (input > 0) numbers.add(input);  // Only accept positive numbers
        }

        /*
         * Validates that at least 100 numbers have been entered 
         * before proceeding with further calculations.
         */
        if (numbers.size() < 100) {
            System.out.println("You must enter at least 100 numbers.");
            scanner.close();
            return;
        }

        // Creates a copy of the original list to find the largest number before sorting
        List<Integer> originalNumbers = new ArrayList<>(numbers);

        // Sort the list in ascending order
        Collections.sort(numbers);
        System.out.println("Numbers in ascending order: " + numbers);

        /*
         * Calculate the median:
         * If the list size is even, the median is the average of the two middle values.
         * If the list size is odd, the median is the middle value.
         */
        double median;
        int n = numbers.size();
        if (n % 2 == 0) {
            median = (numbers.get(n / 2 - 1) + numbers.get(n / 2)) / 2.0;
        } else {
            median = numbers.get(n / 2);
        }
        System.out.println("Median: " + median);

        /*
         * Determine the number that occurs most frequently:
         * Uses a HashMap to count the frequency of each number.
         */
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : numbers) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        int maxFrequency = Collections.max(frequency.values());
        int mostFrequentNumber = numbers.stream().filter(num -> frequency.get(num) == maxFrequency).findFirst().orElse(-1);
        System.out.println("Most frequent number: " + mostFrequentNumber);

        /*
         * Classify numbers into different categories:
         * - Numbers less than 30
         * - Numbers greater than 70
         * - Numbers between 30 and 70 (inclusive)
         */
        List<Integer> lessThan30 = new ArrayList<>();
        List<Integer> greaterThan70 = new ArrayList<>();
        List<Integer> between30And70 = new ArrayList<>();

        for (int num : numbers) {
            if (num < 30) {
                lessThan30.add(num);
            } else if (num > 70) {
                greaterThan70.add(num);
            } else {
                between30And70.add(num);
            }
        }

        // Print classified numbers
        System.out.println("Numbers less than 30: " + lessThan30);
        System.out.println("Numbers greater than 70: " + greaterThan70);
        System.out.println("Numbers between 30 and 70: " + between30And70);

        /*
         * Find the largest number and its position in the original list:
         * The position is 1-based (human-readable format).
         */
        int largestNumber = Collections.max(originalNumbers);
        int position = originalNumbers.indexOf(largestNumber) + 1;  // +1 for human-readable position
        System.out.println("The largest number is: " + largestNumber + " and its position before sorting is: " + position);

        // Close the scanner to avoid resource leaks
        scanner.close();
    }
}
