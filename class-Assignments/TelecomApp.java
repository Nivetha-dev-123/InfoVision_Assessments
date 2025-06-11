package Day3;

public class TelecomApp {
    public static void main(String[] args) {
        if (!LoginManager.login()) {
            System.out.println("Exiting application.");
            return;
        }

        // Proceed with telecom services here...
        TelecomService sms = new SMSService(1.5);
        TelecomService voice = new VoiceCallService(2.0);

        runService(sms, 10);
        runService(voice, 5);
    }

    private static void runService(TelecomService service, int units) {
        service.start();
        service.billCustomer(units);
        service.stop();
        System.out.println();
    }
}
