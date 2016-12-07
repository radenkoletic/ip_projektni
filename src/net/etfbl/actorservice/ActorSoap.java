/**
 * ActorSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.etfbl.actorservice;

public interface ActorSoap extends java.rmi.Remote {
    public void insertActor(net.etfbl.actorservice.model.ActorS a) throws java.rmi.RemoteException;
    public net.etfbl.actorservice.model.ActorS[] getAllActors() throws java.rmi.RemoteException;
}
