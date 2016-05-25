package main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

import object.Distante;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.processor.idempotent.NoMessageIdException;

/**
 * Une implémentation de client pour se connecter au serveur
 * 
 * @author Arnaud Garnier & Lisa Joanno
 * 
 */
public class Client {

	public static void main(String[] args) {
		try {
			System.out.println("Bienvenue, quel est votre nom ? (pour nommer la queue) ");
			String monNom = (new Scanner(System.in).nextLine());
			
			// Recherche de l'objet distant
			Registry reg = LocateRegistry.getRegistry("localhost", 1098);
			Distante id = (Distante) reg.lookup("ObjDist");
			System.out.println(id.saySomething());
			
			// Abonnement au magazine sur les fougères de Distante
			id.sabonnerFougereMag(monNom);
			
			// Recherche de la queue
	        javax.jms.ConnectionFactory connectionf = new ActiveMQConnectionFactory(
					"user", "user", "tcp://localhost:61616");
			Connection conn;
			conn = connectionf.createConnection("user", "user");
			javax.jms.Session sps = conn.createSession(false,
					javax.jms.Session.AUTO_ACKNOWLEDGE);
			javax.jms.Queue queue = sps.createQueue("Queue."+monNom);
			javax.jms.MessageConsumer receiver = sps.createConsumer(queue);
			
			// Lancement de la connection
			conn.start();
			
			while (true) {
				TextMessage tm = (TextMessage) receiver.receive();
				
				System.out.println(monNom + ", vous avez reçu un message ! Le voici : \n  ----");
				System.out.println(tm.getText());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
