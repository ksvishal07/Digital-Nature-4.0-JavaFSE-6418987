public class Main {
    public static void main(String[] args) {
        NotificationFactory factory;
        factory = new EmailNotificationFactory();
        Notification email = factory.createNotification();
        email.notifyUser();
        factory = new SMSNotificationFactory();
        Notification sms = factory.createNotification();
        sms.notifyUser();
    }
}
