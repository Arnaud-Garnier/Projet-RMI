


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


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
		try {
			ObjetDistant od = new ObjetDistant();
            Naming.rebind("rmi://localhost:1098/ObjDist", od);
			//IMyRMIRegistry myReg = (IMyRMIRegistry) reg.lookup("MyRMI");
			//reg.rebind("ObjDist", od);
                        //System.out.println(myReg.list());
		} catch (RemoteException | MalformedURLException e) {
			System.err.println(e);
		}
	}

}
