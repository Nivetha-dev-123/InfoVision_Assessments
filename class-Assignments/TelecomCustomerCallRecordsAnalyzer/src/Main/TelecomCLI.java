package Main;
import java.time.LocalDateTime;
import java.util.*;

import Model.CallRecord;
import Service.CallRecordAnalyzer;

public class TelecomCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CallRecordAnalyzer analyzer = new CallRecordAnalyzer();

        // Sample data
        analyzer.addRecord(new CallRecord("Nivetha", "Nagalingam", LocalDateTime.now().minusMinutes(10), LocalDateTime.now(), "Airtel", "Delhi"));
        analyzer.addRecord(new CallRecord("Nagalingam", "Rathiga", LocalDateTime.now().minusMinutes(5), LocalDateTime.now(), "Jio", "Mumbai"));
        analyzer.addRecord(new CallRecord("Harini", "Indhumathi", LocalDateTime.now().minusMinutes(3), LocalDateTime.now(), "Airtel", "Delhi"));
        analyzer.addRecord(new CallRecord("swetha", "Kavitha", LocalDateTime.now().minusMinutes(8), LocalDateTime.now(), "Vi", "Bangalore"));

        while (true) {
            System.out.println(" Telecom Call Records Analyzer ---");
            System.out.println("1. View Longest Calls");
            System.out.println("2. View Frequent Callers");
            System.out.println("3. Filter by Call Duration");
            System.out.println("4. Group by Operator");
            System.out.println("5. Group by Location");
            System.out.println("6. Exit");
            System.out.print("Select option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Top Longest Calls:");
                    analyzer.getLongestCalls(3).forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Frequent Callers:");
                    analyzer.getCallFrequencyBycaller().forEach((caller, count) ->
                            System.out.println(caller + " made " + count + " calls"));
                    break;
                case 3:
                    System.out.print("Enter minimum call duration (in seconds): ");
                    long minDuration = scanner.nextLong();
                    analyzer.filterByDurationGreaterThan(minDuration).forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Grouped by Operator:");
                    analyzer.groupByOperator().forEach((op, calls) -> {
                        System.out.println("Operator: " + op);
                        calls.forEach(System.out::println);
                    });
                    break;
                case 5:
                    System.out.println("Grouped by Location:");
                    analyzer.groupByLocation().forEach((loc, calls) -> {
                        System.out.println("Location: " + loc);
                        calls.forEach(System.out::println);
                    });
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
