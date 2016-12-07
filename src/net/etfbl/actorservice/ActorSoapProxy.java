package net.etfbl.actorservice;

public class ActorSoapProxy implements net.etfbl.actorservice.ActorSoap {
  private String _endpoint = null;
  private net.etfbl.actorservice.ActorSoap actorSoap = null;
  
  public ActorSoapProxy() {
    _initActorSoapProxy();
  }
  
  public ActorSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initActorSoapProxy();
  }
  
  private void _initActorSoapProxy() {
    try {
      actorSoap = (new net.etfbl.actorservice.ActorSoapServiceLocator()).getActorSoap();
      if (actorSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)actorSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)actorSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (actorSoap != null)
      ((javax.xml.rpc.Stub)actorSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.etfbl.actorservice.ActorSoap getActorSoap() {
    if (actorSoap == null)
      _initActorSoapProxy();
    return actorSoap;
  }
  
  public void insertActor(net.etfbl.actorservice.model.ActorS a) throws java.rmi.RemoteException{
    if (actorSoap == null)
      _initActorSoapProxy();
    actorSoap.insertActor(a);
  }
  
  public net.etfbl.actorservice.model.ActorS[] getAllActors() throws java.rmi.RemoteException{
    if (actorSoap == null)
      _initActorSoapProxy();
    return actorSoap.getAllActors();
  }
  
  
}