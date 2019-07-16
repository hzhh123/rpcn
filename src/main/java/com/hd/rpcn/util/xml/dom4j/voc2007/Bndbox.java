
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
 *         &lt;element ref="{}xmin"/>
 *         &lt;element ref="{}ymin"/>
 *         &lt;element ref="{}xmax"/>
 *         &lt;element ref="{}ymax"/>
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
    "xmin",
    "ymin",
    "xmax",
    "ymax"
})
@XmlRootElement(name = "bndbox")
public class Bndbox {

    @XmlElement(required = true)
    protected String xmin;
    @XmlElement(required = true)
    protected String ymin;
    @XmlElement(required = true)
    protected String xmax;
    @XmlElement(required = true)
    protected String ymax;

    /**
     * ��ȡxmin���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmin() {
        return xmin;
    }

    /**
     * ����xmin���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmin(String value) {
        this.xmin = value;
    }

    /**
     * ��ȡymin���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYmin() {
        return ymin;
    }

    /**
     * ����ymin���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYmin(String value) {
        this.ymin = value;
    }

    /**
     * ��ȡxmax���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmax() {
        return xmax;
    }

    /**
     * ����xmax���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmax(String value) {
        this.xmax = value;
    }

    /**
     * ��ȡymax���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYmax() {
        return ymax;
    }

    /**
     * ����ymax���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYmax(String value) {
        this.ymax = value;
    }

    @Override
    public String toString() {
        return "Bndbox{" +
                "xmin='" + xmin + '\'' +
                ", ymin='" + ymin + '\'' +
                ", xmax='" + xmax + '\'' +
                ", ymax='" + ymax + '\'' +
                '}';
    }
}
