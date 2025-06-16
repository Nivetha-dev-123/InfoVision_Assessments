package Day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TelecomApp {
    public static void main(String[] args) {
        if (!LoginManager.login()) {
            System.out.println("Exiting application.");
            return;
        }

        TelecomService sms = new SMSService(1.5);
        TelecomService voice = new VoiceCallService(2.0);

        ExecutorService executor = Executors.newFixedThreadPool(2);  // 2 threads

        // Submit tasks for concurrent execution
        executor.submit(() -> runService(sms, 10));
        executor.submit(() -> runService(voice, 5));

        // Shutdown executor after tasks finish
        executor.shutdown();
    }

    private static void runService(TelecomService service, int units) {
        service.start();
        service.billCustomer(units);
        service.stop();
        System.out.println();
    }
}
