package groszek.camel;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

public class FtpToJMSExample {
    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();
        ConnectionFactory connectionFactory =
        new ActiveMQConnectionFactory("vm://localhost");
        context.addComponent("jms",
        JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("ftp://rider.com/orders?username=rider&password=secret").to("jms:incomingOrders");
            }
        });
        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}
