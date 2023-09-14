public class Main {
    public static void main(String[] args) {

        System.out.println("Bienvenido al event-driven architecture");
        EventDispatcher eventDispatcher= new EventDispatcher();

        eventDispatcher.registerEventHandler(OrderPlacedEvent.class, new InventoryManagementService());
        eventDispatcher.registerEventHandler(OrderPlacedEvent.class, new EmailNotificationService());

        OrderPlacedEvent orderPlacedEvent = new OrderPlacedEvent("12345 ", "Cliente 123");
        eventDispatcher.dispatchEvent(orderPlacedEvent);

    }
}