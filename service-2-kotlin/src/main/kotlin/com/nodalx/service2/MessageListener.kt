@Component
class MessageListener(val rabbitTemplate: AmqpTemplate) {

    @RabbitListener(queues = ["ping-queue"])
    fun receiveMessage(message: String) {
        println("Service 2 received: $message")

        val reply = "pong from Service 2"
        println("Service 2 sending: $reply")
        rabbitTemplate.convertAndSend("ping-pong-exchange", "pong.key", reply)

        Thread.sleep(10000) // wait 10 seconds
        val nextPing = "ping from Service 2"
        println("Service 2 sending: $nextPing")
        rabbitTemplate.convertAndSend("ping-pong-exchange", "ping.key", nextPing)
    }
}