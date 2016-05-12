package main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Une implémentation de client pour se connecter au serveur
 * 
 * @author Arnaud Garnier & Lisa Joanno
 * 
 */
public class Client {

	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1098);
			Distante id = (Distante) reg.lookup("ObjDist");
			System.out.println(id.saySomething());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
