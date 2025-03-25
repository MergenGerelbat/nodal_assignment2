@Configuration
class RabbitMQConfig {

    companion object {
        const val EXCHANGE_NAME = "ping-pong-exchange"
        const val PING_QUEUE = "ping-queue"
        const val PONG_QUEUE = "pong-queue"
    }

    @Bean
    fun exchange(): TopicExchange {
        return TopicExchange(EXCHANGE_NAME)
    }

    @Bean
    fun pingQueue(): Queue {
        return Queue(PING_QUEUE, false)
    }

    @Bean
    fun pingBinding(pingQueue: Queue, exchange: TopicExchange): Binding {
        return BindingBuilder.bind(pingQueue).to(exchange).with("ping.key")
    }
}