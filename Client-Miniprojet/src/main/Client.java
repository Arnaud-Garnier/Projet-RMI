package main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

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
			String monNom = (new Scanner(System.in).nextLine());
			
			Registry reg = LocateRegistry.getRegistry("localhost", 1098);
			Distante id = (Distante) reg.lookup("ObjDist");
			System.out.println(id.saySomething());
			
			// Abonnement au magazine sur les fougères de Distante
			id.sabonnerFougereMag(monNom);
			
			//oijfz
	        javax.jms.ConnectionFactory connectionf = new ActiveMQConnectionFactory(
					"user", "user", "tcp://localhost:61616");
			Connection conn;
			conn = connectionf.createConnection("user", "user");
			javax.jms.Session sps = conn.createSession(false,
					javax.jms.Session.AUTO_ACKNOWLEDGE);
			javax.jms.Queue queue = sps.createQueue("Queue."+monNom);
			javax.jms.MessageConsumer receiver = sps.createConsumer(queue);
			while(true) {
				TextMessage tm = (TextMessage) receiver.receive();
				System.out.println(tm);
				System.out.println(tm.getText());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
