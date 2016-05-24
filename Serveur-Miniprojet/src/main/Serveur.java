package main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Le serveur de l'application
 * 
 * @author Arnaud Garnier & Lisa Joanno
 * 
 */
public class Serveur {

	/**
	 * Constructeur
	 * 
	 * @param rmiPort
	 *            le port sur lequel le rmiregistry est lancé
	 */
	public Serveur(int rmiPort) {
		ObjetDistant od;
		try {
			/**** RMI ****/
			
			od = new ObjetDistant();
                        Registry reg = LocateRegistry.getRegistry("localhost", 1098);
			IMyRMIRegistry myReg = (IMyRMIRegistry) reg.lookup("MyRMI");
			reg.rebind("ObjDist", od);
            System.out.println(myReg.list());
            
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
