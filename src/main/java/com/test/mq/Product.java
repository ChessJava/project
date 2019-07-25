package com.test.mq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.JmsException;

import javax.jms.*;

public class Product {

    // 默认连接用户名
    //private static final String USERNAME = "admin";
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    // 默认连接密码
    //private static final String PASSWORD =  "admin";
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    // 默认连接地址
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    // 发送的消息数量
    private static final int SENDNUM = 10;

    //发送消息
    public static void sendMessage(Session session,
                                   MessageProducer messageProducer) throws Exception {
        for (int i = 0; i < Product.SENDNUM; i++) {
            // 创建一条文本消息
            TextMessage message = session.createTextMessage("ActiveMQ 发送消息" + i);
            System.out.println("发送消息：Activemq 发送消息" + (i+1));
            // 通过消息生产者发出消息
            messageProducer.send(message);
        }
    }

    public static void main(String[] args) throws Exception{
        // 连接工厂
        ConnectionFactory connectionFactory;
        // 连接
        Connection connection = null;
        // 会话 接受或者发送消息的线程
        Session session;
        // 消息的目的地
        Destination destination;
        // 消息生产者
        MessageProducer messageProducer;
        // 实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
        // 通过连接工厂获取连接
        connection = connectionFactory.createConnection();
        // 启动连接
        connection.start();
        // 创建session
        session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        // 创建一个名称为HelloWorld的消息队列
        destination = session.createQueue("HelloWorld");
        // 创建消息生产者
        messageProducer = session.createProducer(destination);
        // 发送消息
        sendMessage(session, messageProducer);
        //关闭连接
        session.commit();
    }
}
