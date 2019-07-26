package mq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


public class Customer {

    // 默认连接用户名
    //private static final String USERNAME = "admin";
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

    // 默认连接密码
    //private static final String PASSWORD = "admin";
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

    // 默认连接地址
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) throws JMSException {
        // 连接工厂
        ConnectionFactory connectionFactory;
        // 连接
        Connection connection = null;
        // 会话 接受或者发送消息的线程
        Session session;
        // 消息的目的地
        Destination destination;
        // 消息的消费者
        MessageConsumer messageConsumer;
        // 实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
        // 通过连接工厂获取连接
        connection = connectionFactory.createConnection();
        // 启动连接
        connection.start();
        // 创建session
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建一个连接HelloWorld的消息队列
        destination = session.createQueue("HelloWorld");
        // 创建消息消费者
        messageConsumer = session.createConsumer(destination);
        while (true) {
            TextMessage textMessage = (TextMessage) messageConsumer.receive(100000);
            if (textMessage != null) {
                System.out.println("收到的消息:" + textMessage.getText());
            } else {
                break;
            }
        }
    }
}
