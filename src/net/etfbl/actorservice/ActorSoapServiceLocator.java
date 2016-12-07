/**
 * ActorSoapServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.etfbl.actorservice;

public class ActorSoapServiceLocator extends org.apache.axis.client.Service implements net.etfbl.actorservice.ActorSoapService {

    public ActorSoapServiceLocator() {
    }


    public ActorSoapServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ActorSoapServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ActorSoap
    private java.lang.String ActorSoap_address = "http://localhost:8080/ActorSoap/services/ActorSoap";

    public java.lang.String getActorSoapAddress() {
        return ActorSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ActorSoapWSDDServiceName = "ActorSoap";

    public java.lang.String getActorSoapWSDDServiceName() {
        return ActorSoapWSDDServiceName;
    }

    public void setActorSoapWSDDServiceName(java.lang.String name) {
        ActorSoapWSDDServiceName = name;
    }

    public net.etfbl.actorservice.ActorSoap getActorSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ActorSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getActorSoap(endpoint);
    }

    public net.etfbl.actorservice.ActorSoap getActorSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.etfbl.actorservice.ActorSoapSoapBindingStub _stub = new net.etfbl.actorservice.ActorSoapSoapBindingStub(portAddress, this);
            _stub.setPortName(getActorSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setActorSoapEndpointAddress(java.lang.String address) {
        ActorSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.etfbl.actorservice.ActorSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                net.etfbl.actorservice.ActorSoapSoapBindingStub _stub = new net.etfbl.actorservice.ActorSoapSoapBindingStub(new java.net.URL(ActorSoap_address), this);
                _stub.setPortName(getActorSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ActorSoap".equals(inputPortName)) {
            return getActorSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://actorservice.etfbl.net", "ActorSoapService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://actorservice.etfbl.net", "ActorSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ActorSoap".equals(portName)) {
            setActorSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
