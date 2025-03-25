@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "ping-pong-exchange";
    public static final String PING_QUEUE = "ping-queue";
    public static final String PONG_QUEUE = "pong-queue";

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Queue pongQueue() {
        return new Queue(PONG_QUEUE, false);
    }

    @Bean
    Binding pongBinding(Queue pongQueue, TopicExchange exchange) {
        return BindingBuilder.bind(pongQueue).to(exchange).with("pong.key");
    }
}