package example;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * This class demonstrates how to send messages to brokers using provided {@link DefaultMQProducer}.
 */
@Component
public class ProducerMsg {
    private String testTopic = "RunJob";

    @Resource
    private RMQConfigure rMQConfigure;


    public void sendMessages() throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer(testTopic + "Group");
        producer.setNamesrvAddr(rMQConfigure.getNamesrvAddr());
        producer.setVipChannelEnabled(false);
        producer.start();

        try {
            /*
            * Create a message instance, specifying topic, tag and message body.
            */
            Message msg = new Message(testTopic /* Topic */,
                "TagA" /* Tag */,
                "Keys",
                ("Hello RocketMQ").getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );

            /*
            * Call send message to deliver message to one of brokers.
            */
            SendResult sendResult = producer.send(msg);

            System.out.printf("%s%n", sendResult);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error send message");
            System.out.println(e);
        }

        /*
         * Shut down once the producer instance is not longer in use.
         */
        producer.shutdown();
    }

}
