package main;

/**
 * La classe principale qui lance le serveur.
 * 
 * @author Arnaud Garnier & Lisa Joanno
 * 
 */
public class Main {

	public static void main(String[] args) {
		int port = 1098;
		System.out.println("Lancement du serveur...");
		System.out.println("Port du rmiregistry : " + port);
		new Serveur(port);
	}

}
