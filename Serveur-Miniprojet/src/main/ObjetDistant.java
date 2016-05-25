package main;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import object.Distante;
import object.Fougere;

/**
 * L'objet distant qui contient l'implémentation des méthodes de l'interface
 * distante.
 * 
 * @author Arnaud Garnier & Lisa Joanno
 * 
 */
public class ObjetDistant extends UnicastRemoteObject implements Distante {

	/**
	 * AUTO-GENERATED serial number
	 */
	private static final long serialVersionUID = 1L;

	private String stubName;

	public ObjetDistant() throws RemoteException {
		
	}

	/**
	 * Test function
	 */
	@Override
	public String saySomething() throws RemoteException {
		Fougere f = new Fougere();
		return f.toString() + " ; The RMI is working well";
	}

	/**
	 * Création d'une queue pour modéliser le magazine.
	 * On y poste 2 messages pour tester côté client que la queue est bien active.
	 */
	@Override
	public void sabonnerFougereMag(String nomClient) throws RemoteException {
		/**** JMS ****/
		
        // Trouver l'objet ConnectionFactory -> là où sera la queue
        javax.jms.ConnectionFactory connectionf = new ActiveMQConnectionFactory(
				"user", "user", "tcp://localhost:61616");
        
		try {
			
            // Créer une connexion JMS
			Connection conn;
			conn = connectionf.createConnection("user", "user");
			javax.jms.Session sps = conn.createSession(false,
					javax.jms.Session.AUTO_ACKNOWLEDGE);
			javax.jms.Queue queue = sps.createQueue("Queue."+nomClient);
			MessageProducer sender = sps.createProducer(queue);
			
			// Envoi d'un message 1
			TextMessage m = sps.createTextMessage();
			m.setText("Les fougères comportent environ 13000 espèces.");
			sender.send(m);
			
			// Envoi d'un message 2
			TextMessage m2 = sps.createTextMessage();
			m2.setText("Les fougères peuvent être assez nombreuses pour former un ensemble végétal appelé fougeraie.");
			sender.send(m2);
			
			// Lancement de la connexion
			conn.start();
			
		} catch (JMSException e) {
			e.printStackTrace();
		} 
	}
	
}
