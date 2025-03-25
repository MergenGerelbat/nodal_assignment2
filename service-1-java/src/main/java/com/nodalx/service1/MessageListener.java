@Component
public class MessageListener {

    @RabbitListener(queues = "pong-queue")
    public void receiveMessage(String message) {
        System.out.println("Service 1 received: " + message);
    }
}