public class InventoryManagementService implements OrderPlacedEventHandler{
    @Override
    public void onOrderPlaced(OrderPlacedEvent event) {
        System.out.println("Procesando orden " + event.getOrderId()+
                "por el cliente" + event.getCustomerId());
    }
}
