package net.etfbl.movies.bean;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import net.etfbl.actorservice.ActorSoap;
import net.etfbl.actorservice.ActorSoapServiceLocator;
import net.etfbl.actorservice.model.ActorS;

public class Test {
	
	public static void main (String args[]) throws ServiceException, RemoteException {
		ActorSoapServiceLocator locator = new ActorSoapServiceLocator();
		ActorSoap service = locator.getActorSoap();
		ActorS[] actors = service.getAllActors();
		for (ActorS a : actors) {
			System.out.println("actor name: " + a.getName());
		}
	}

}
