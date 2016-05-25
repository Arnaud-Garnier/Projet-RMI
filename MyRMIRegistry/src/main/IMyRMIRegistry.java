package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMyRMIRegistry extends Remote {

	void bind(String name, Remote obj) throws RemoteException;

	String[] list() throws RemoteException;

	Remote lookup(String name) throws RemoteException;
	
	void rebind(String name, Remote obj) throws RemoteException;

	void unbind(String name) throws RemoteException;

}
