/**
 * GrpSettings.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Mar 02, 2009 (07:08:06 PST) WSDL2Java emitter.
 */

package com.google.api.ads.dfp.axis.v201405;


/**
 * {@code GrpSettings} contains information for a line item that will
 * have a target demographic
 *             when serving. This information will be used to set up
 * tracking and enable reporting on the
 *             demographic information.
 */
public class GrpSettings  implements java.io.Serializable {
    /* Specifies the minimum target age (in years) of the {@link LineItem}.
     * This field is only
     *                 applicable if {@link GfpSettings#provider} is not
     * null. */
    private java.lang.Long minTargetAge;

    /* Specifies the maximum target age (in years) of the {@link LineItem}.
     * This field is only
     *                 applicable if {@link GfpSettings#provider} is not
     * null. */
    private java.lang.Long maxTargetAge;

    /* Specifies the target gender of the {@link LineItem}. This field
     * is only applicable if
     *                 {@link GfpSettings#provider} is not null. */
    private com.google.api.ads.dfp.axis.v201405.GrpTargetGender targetGender;

    /* Specifies the GRP provider of the {@link LineItem}. */
    private com.google.api.ads.dfp.axis.v201405.GrpProvider provider;

    public GrpSettings() {
    }

    public GrpSettings(
           java.lang.Long minTargetAge,
           java.lang.Long maxTargetAge,
           com.google.api.ads.dfp.axis.v201405.GrpTargetGender targetGender,
           com.google.api.ads.dfp.axis.v201405.GrpProvider provider) {
           this.minTargetAge = minTargetAge;
           this.maxTargetAge = maxTargetAge;
           this.targetGender = targetGender;
           this.provider = provider;
    }


    /**
     * Gets the minTargetAge value for this GrpSettings.
     * 
     * @return minTargetAge   * Specifies the minimum target age (in years) of the {@link LineItem}.
     * This field is only
     *                 applicable if {@link GfpSettings#provider} is not
     * null.
     */
    public java.lang.Long getMinTargetAge() {
        return minTargetAge;
    }


    /**
     * Sets the minTargetAge value for this GrpSettings.
     * 
     * @param minTargetAge   * Specifies the minimum target age (in years) of the {@link LineItem}.
     * This field is only
     *                 applicable if {@link GfpSettings#provider} is not
     * null.
     */
    public void setMinTargetAge(java.lang.Long minTargetAge) {
        this.minTargetAge = minTargetAge;
    }


    /**
     * Gets the maxTargetAge value for this GrpSettings.
     * 
     * @return maxTargetAge   * Specifies the maximum target age (in years) of the {@link LineItem}.
     * This field is only
     *                 applicable if {@link GfpSettings#provider} is not
     * null.
     */
    public java.lang.Long getMaxTargetAge() {
        return maxTargetAge;
    }


    /**
     * Sets the maxTargetAge value for this GrpSettings.
     * 
     * @param maxTargetAge   * Specifies the maximum target age (in years) of the {@link LineItem}.
     * This field is only
     *                 applicable if {@link GfpSettings#provider} is not
     * null.
     */
    public void setMaxTargetAge(java.lang.Long maxTargetAge) {
        this.maxTargetAge = maxTargetAge;
    }


    /**
     * Gets the targetGender value for this GrpSettings.
     * 
     * @return targetGender   * Specifies the target gender of the {@link LineItem}. This field
     * is only applicable if
     *                 {@link GfpSettings#provider} is not null.
     */
    public com.google.api.ads.dfp.axis.v201405.GrpTargetGender getTargetGender() {
        return targetGender;
    }


    /**
     * Sets the targetGender value for this GrpSettings.
     * 
     * @param targetGender   * Specifies the target gender of the {@link LineItem}. This field
     * is only applicable if
     *                 {@link GfpSettings#provider} is not null.
     */
    public void setTargetGender(com.google.api.ads.dfp.axis.v201405.GrpTargetGender targetGender) {
        this.targetGender = targetGender;
    }


    /**
     * Gets the provider value for this GrpSettings.
     * 
     * @return provider   * Specifies the GRP provider of the {@link LineItem}.
     */
    public com.google.api.ads.dfp.axis.v201405.GrpProvider getProvider() {
        return provider;
    }


    /**
     * Sets the provider value for this GrpSettings.
     * 
     * @param provider   * Specifies the GRP provider of the {@link LineItem}.
     */
    public void setProvider(com.google.api.ads.dfp.axis.v201405.GrpProvider provider) {
        this.provider = provider;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GrpSettings)) return false;
        GrpSettings other = (GrpSettings) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.minTargetAge==null && other.getMinTargetAge()==null) || 
             (this.minTargetAge!=null &&
              this.minTargetAge.equals(other.getMinTargetAge()))) &&
            ((this.maxTargetAge==null && other.getMaxTargetAge()==null) || 
             (this.maxTargetAge!=null &&
              this.maxTargetAge.equals(other.getMaxTargetAge()))) &&
            ((this.targetGender==null && other.getTargetGender()==null) || 
             (this.targetGender!=null &&
              this.targetGender.equals(other.getTargetGender()))) &&
            ((this.provider==null && other.getProvider()==null) || 
             (this.provider!=null &&
              this.provider.equals(other.getProvider())));
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
        if (getMinTargetAge() != null) {
            _hashCode += getMinTargetAge().hashCode();
        }
        if (getMaxTargetAge() != null) {
            _hashCode += getMaxTargetAge().hashCode();
        }
        if (getTargetGender() != null) {
            _hashCode += getTargetGender().hashCode();
        }
        if (getProvider() != null) {
            _hashCode += getProvider().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GrpSettings.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.google.com/apis/ads/publisher/v201405", "GrpSettings"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minTargetAge");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.google.com/apis/ads/publisher/v201405", "minTargetAge"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxTargetAge");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.google.com/apis/ads/publisher/v201405", "maxTargetAge"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("targetGender");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.google.com/apis/ads/publisher/v201405", "targetGender"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://www.google.com/apis/ads/publisher/v201405", "GrpTargetGender"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provider");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.google.com/apis/ads/publisher/v201405", "provider"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://www.google.com/apis/ads/publisher/v201405", "GrpProvider"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
