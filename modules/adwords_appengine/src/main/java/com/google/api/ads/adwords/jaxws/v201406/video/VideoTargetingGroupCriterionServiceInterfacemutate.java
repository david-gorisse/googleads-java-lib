
package com.google.api.ads.adwords.jaxws.v201406.video;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             Adds, updates, or removes targeting group criteria.
 *             Note: TargetingGroupCriterionOperation does not support the REMOVE operator. To
 *             remove a targeting group, set its status to REMOVED.
 *             @param operations A list of unique operations.
 *             @return The list of updated targeting group criteria, returned in the same order as the
 *             operations array.
 *             @throws ApiException if problems occurred while updating targeting group criteria.
 *           
 * 
 * <p>Java class for mutate element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="mutate">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element name="operations" type="{https://adwords.google.com/api/adwords/video/v201406}TargetingGroupCriterionOperation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "operations"
})
@XmlRootElement(name = "mutate")
public class VideoTargetingGroupCriterionServiceInterfacemutate {

    protected List<TargetingGroupCriterionOperation> operations;

    /**
     * Gets the value of the operations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TargetingGroupCriterionOperation }
     * 
     * 
     */
    public List<TargetingGroupCriterionOperation> getOperations() {
        if (operations == null) {
            operations = new ArrayList<TargetingGroupCriterionOperation>();
        }
        return this.operations;
    }

}
