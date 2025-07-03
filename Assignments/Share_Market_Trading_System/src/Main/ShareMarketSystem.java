package Main;

import Auth.LoginService;
import Entity.Market;
import Entity.Stock;
import Entity.Trader;

import java.util.Scanner;

public class ShareMarketSystem {
    public static void main(String[] args) {
        Market market = new Market();
        market.addStock(new Stock("STK1", "TechCorp", 100.0, 50));
        market.addStock(new Stock("STK2", "HealthInc", 150.0, 60));

        LoginService loginService = new LoginService();

        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("=== Welcome to Share Market Trading System ===");
			System.out.println("Login options:");
			System.out.println("1. Username/Password");
			System.out.println("2. Mobile Number/OTP");
			System.out.print("Choose login method (1 or 2): ");

			int choice = Integer.parseInt(scanner.nextLine());
			String loggedInUser = null;

			if (choice == 1) {
			    loggedInUser = loginService.login();
			} else if (choice == 2) {
			    loggedInUser = loginService.loginByMobile();
			} else {
			    System.out.println("Invalid choice. Exiting.");
			    return;
			}

			if (loggedInUser == null) {
			    System.out.println("Access denied. Exiting...");
			    return;
			}

			
			Trader trader = switch (loggedInUser.toLowerCase()) {
			    case "alice" -> new Trader(1, "Alice", market);
			    case "bob" -> new Trader(2, "Bob", market);
			    case "charlie" -> new Trader(3, "Charlie", market);
			    default -> null;
			};

			if (trader == null) {
			    System.out.println("No trader profile found for user: " + loggedInUser);
			    return;
			}

			System.out.println("\nLogged in as " + loggedInUser + ". Starting trading session...\n");

			
			boolean running = true;
			while (running) {
			    System.out.println("1. Buy Stock");
			    System.out.println("2. Sell Stock");
			    System.out.println("3. Show Portfolio");
			    System.out.println("4. Exit");
			    System.out.print("Enter your choice: ");

			    try {
			        int option = Integer.parseInt(scanner.nextLine());
			        switch (option) {
			            case 1 -> {
			                System.out.print("Enter Stock ID to buy: ");
			                String stockId = scanner.nextLine();
			                System.out.print("Enter quantity: ");
			                int qty = Integer.parseInt(scanner.nextLine());
			                trader.buyStock(stockId, qty);
			            }
			            case 2 -> {
			                System.out.print("Enter Stock ID to sell: ");
			                String stockId = scanner.nextLine();
			                System.out.print("Enter quantity: ");
			                int qty = Integer.parseInt(scanner.nextLine());
			                trader.sellStock(stockId, qty);
			            }
			            case 3 -> trader.printPortfolio();
			            case 4 -> {
			                running = false;
			                System.out.println("Exiting trading session. Goodbye!");
			            }
			            default -> System.out.println("Invalid option.");
			        }
			    } catch (Exception e) {
			        System.err.println("Error: " + e.getMessage());
			    }
			    System.out.println();
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
