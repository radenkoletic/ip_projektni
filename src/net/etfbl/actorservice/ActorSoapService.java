/**
 * ActorSoapService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.etfbl.actorservice;

public interface ActorSoapService extends javax.xml.rpc.Service {
    public java.lang.String getActorSoapAddress();

    public net.etfbl.actorservice.ActorSoap getActorSoap() throws javax.xml.rpc.ServiceException;

    public net.etfbl.actorservice.ActorSoap getActorSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
