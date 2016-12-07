/**
 * ActorS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.etfbl.actorservice.model;

public class ActorS  implements java.io.Serializable {
    private int id;

    private java.lang.String name;

    private java.lang.String restThumbnail;

    private java.lang.String restUrl;

    private java.lang.String surname;

    public ActorS() {
    }

    public ActorS(
           int id,
           java.lang.String name,
           java.lang.String restThumbnail,
           java.lang.String restUrl,
           java.lang.String surname) {
           this.id = id;
           this.name = name;
           this.restThumbnail = restThumbnail;
           this.restUrl = restUrl;
           this.surname = surname;
    }


    /**
     * Gets the id value for this ActorS.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this ActorS.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the name value for this ActorS.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ActorS.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the restThumbnail value for this ActorS.
     * 
     * @return restThumbnail
     */
    public java.lang.String getRestThumbnail() {
        return restThumbnail;
    }


    /**
     * Sets the restThumbnail value for this ActorS.
     * 
     * @param restThumbnail
     */
    public void setRestThumbnail(java.lang.String restThumbnail) {
        this.restThumbnail = restThumbnail;
    }


    /**
     * Gets the restUrl value for this ActorS.
     * 
     * @return restUrl
     */
    public java.lang.String getRestUrl() {
        return restUrl;
    }


    /**
     * Sets the restUrl value for this ActorS.
     * 
     * @param restUrl
     */
    public void setRestUrl(java.lang.String restUrl) {
        this.restUrl = restUrl;
    }


    /**
     * Gets the surname value for this ActorS.
     * 
     * @return surname
     */
    public java.lang.String getSurname() {
        return surname;
    }


    /**
     * Sets the surname value for this ActorS.
     * 
     * @param surname
     */
    public void setSurname(java.lang.String surname) {
        this.surname = surname;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ActorS)) return false;
        ActorS other = (ActorS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.restThumbnail==null && other.getRestThumbnail()==null) || 
             (this.restThumbnail!=null &&
              this.restThumbnail.equals(other.getRestThumbnail()))) &&
            ((this.restUrl==null && other.getRestUrl()==null) || 
             (this.restUrl!=null &&
              this.restUrl.equals(other.getRestUrl()))) &&
            ((this.surname==null && other.getSurname()==null) || 
             (this.surname!=null &&
              this.surname.equals(other.getSurname())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getId();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getRestThumbnail() != null) {
            _hashCode += getRestThumbnail().hashCode();
        }
        if (getRestUrl() != null) {
            _hashCode += getRestUrl().hashCode();
        }
        if (getSurname() != null) {
            _hashCode += getSurname().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ActorS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.actorservice.etfbl.net", "ActorS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.actorservice.etfbl.net", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.actorservice.etfbl.net", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("restThumbnail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.actorservice.etfbl.net", "restThumbnail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("restUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.actorservice.etfbl.net", "restUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("surname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.actorservice.etfbl.net", "surname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
