
package com.hd.rpcn.util.xml.dom4j.voc2007;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}folder" minOccurs="0"/>
 *         &lt;element ref="{}filename" minOccurs="0"/>
 *         &lt;element ref="{}source" minOccurs="0"/>
 *         &lt;element ref="{}owner" minOccurs="0"/>
 *         &lt;element ref="{}size" minOccurs="0"/>
 *         &lt;element ref="{}segmented" minOccurs="0"/>
 *         &lt;element ref="{}object" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "annotation")
public class Annotation {

    @XmlElementRefs({
        @XmlElementRef(name = "folder", type = JAXBElement.class, required = true),
        @XmlElementRef(name = "object", type = com.hd.rpcn.util.xml.dom4j.voc2007.Object.class, required = true),
        @XmlElementRef(name = "filename", type = JAXBElement.class, required = true),
        @XmlElementRef(name = "segmented", type = JAXBElement.class, required = true),
        @XmlElementRef(name = "source", type = Source.class, required = true),
        @XmlElementRef(name = "owner", type = Owner.class, required = true),
        @XmlElementRef(name = "size", type = Size.class, required = true)
    })
    @XmlMixed
    protected List<java.lang.Object> content;

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link com.hd.rpcn.util.xml.dom4j.voc2007.Object }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link String }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link Source }
     * {@link Owner }
     * {@link Size }
     * 
     * 
     */
    public List<java.lang.Object> getContent() {
        if (content == null) {
            content = new ArrayList<java.lang.Object>();
        }
        return this.content;
    }

    public void setContent(List<java.lang.Object> content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "Annotation{" +
                "content=" + content +
                '}';
    }
}
