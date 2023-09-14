public class EmailNotificationService implements OrderPlacedEventHandler{
    @Override
    public void onOrderPlaced(OrderPlacedEvent event) {
        System.out.println("Enviando email de confirmación del pedido al cliente"+event.getCustomerId());
    }
}
