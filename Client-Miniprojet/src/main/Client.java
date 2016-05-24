package main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Une implémentation de client pour se connecter au serveur
 * 
 * @author Arnaud Garnier & Lisa Joanno
 * 
 */
public class Client {

	public static void main(String[] args) {
		try {
//			Registry reg = LocateRegistry.getRegistry("localhost", 1098);
//			Distante id = (Distante) reg.lookup("ObjDist");
//			System.out.println(id.saySomething());
			
			javax.jms.ConnectionFactory connectionf = new ActiveMQConnectionFactory(
					"user", "user", "tcp://localhost:61616");
			Connection conn;
			
			try {
				conn = connectionf.createConnection("user", "user");
				javax.jms.Session sps = conn.createSession(false,
						javax.jms.Session.AUTO_ACKNOWLEDGE);
				javax.jms.Queue queue = sps.createQueue("Queue.Ex21");
				MessageProducer sender = sps.createProducer(queue);

				conn.start();

				for (int i = 0; i < 5; i++) {
					TextMessage m = sps.createTextMessage();
					m.setText("Contenu du message : " + i);
					sender.send(m);
				}
				
				javax.jms.MessageConsumer receiver = sps.createConsumer(queue);
				while(true) {
					TextMessage m = (TextMessage) receiver.receive();
					System.out.println(m);
					System.out.println(m.getText());
				}
				
			} catch (JMSException e) {
				e.printStackTrace();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
