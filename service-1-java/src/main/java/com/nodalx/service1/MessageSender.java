@Component
public class MessageSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 20000) // every 20s
    public void sendPing() {
        String message = "ping from Service 1";
        System.out.println("Service 1 sending: " + message);
        rabbitTemplate.convertAndSend("ping-pong-exchange", "ping.key", message);
    }
}