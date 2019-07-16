
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
 *         &lt;element ref="{}name"/>
 *         &lt;element ref="{}pose"/>
 *         &lt;element ref="{}truncated"/>
 *         &lt;element ref="{}difficult"/>
 *         &lt;element ref="{}rate"/>
 *         &lt;element ref="{}bndbox"/>
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
    "name",
    "pose",
    "truncated",
    "difficult",
    "rate",
    "bndbox"
})
@XmlRootElement(name = "object")
public class Object {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String pose;
    @XmlElement(required = true)
    protected String truncated;
    @XmlElement(required = true)
    protected String difficult;
    @XmlElement(required = true)
    protected String rate;
    @XmlElement(required = true)
    protected Bndbox bndbox;

    /**
     * ��ȡname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * ����name���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * ��ȡpose���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPose() {
        return pose;
    }

    /**
     * ����pose���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPose(String value) {
        this.pose = value;
    }

    /**
     * ��ȡtruncated���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTruncated() {
        return truncated;
    }

    /**
     * ����truncated���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTruncated(String value) {
        this.truncated = value;
    }

    /**
     * ��ȡdifficult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDifficult() {
        return difficult;
    }

    /**
     * ����difficult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDifficult(String value) {
        this.difficult = value;
    }

    /**
     * ��ȡrate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRate() {
        return rate;
    }

    /**
     * ����rate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRate(String value) {
        this.rate = value;
    }

    /**
     * ��ȡbndbox���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Bndbox }
     *     
     */
    public Bndbox getBndbox() {
        return bndbox;
    }

    /**
     * ����bndbox���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Bndbox }
     *     
     */
    public void setBndbox(Bndbox value) {
        this.bndbox = value;
    }

    @Override
    public String toString() {
        return "Object{" +
                "name='" + name + '\'' +
                ", pose='" + pose + '\'' +
                ", truncated='" + truncated + '\'' +
                ", difficult='" + difficult + '\'' +
                ", rate='" + rate + '\'' +
                ", bndbox=" + bndbox +
                '}';
    }
}
