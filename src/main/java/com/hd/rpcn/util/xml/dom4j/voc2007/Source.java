
package com.hd.rpcn.util.xml.dom4j.voc2007;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{}database"/>
 *         &lt;element ref="{}annotation"/>
 *         &lt;element ref="{}image"/>
 *         &lt;element ref="{}flickrid"/>
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
    "database",
    "annotation",
    "image",
    "flickrid"
})
@XmlRootElement(name = "source")
public class Source {

    @XmlElement(required = true)
    protected String database;
    @XmlElement(required = true)
    protected Annotation annotation;
    @XmlElement(required = true)
    protected String image;
    @XmlElement(required = true)
    protected String flickrid;

    /**
     * ��ȡdatabase���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatabase() {
        return database;
    }

    /**
     * ����database���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatabase(String value) {
        this.database = value;
    }

    /**
     * ��ȡannotation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Annotation }
     *     
     */
    public Annotation getAnnotation() {
        return annotation;
    }

    /**
     * ����annotation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Annotation }
     *     
     */
    public void setAnnotation(Annotation value) {
        this.annotation = value;
    }

    /**
     * ��ȡimage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImage() {
        return image;
    }

    /**
     * ����image���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * ��ȡflickrid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlickrid() {
        return flickrid;
    }

    /**
     * ����flickrid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlickrid(String value) {
        this.flickrid = value;
    }

    @Override
    public String toString() {
        return "Source{" +
                "database='" + database + '\'' +
                ", annotation=" + annotation +
                ", image='" + image + '\'' +
                ", flickrid='" + flickrid + '\'' +
                '}';
    }
}
