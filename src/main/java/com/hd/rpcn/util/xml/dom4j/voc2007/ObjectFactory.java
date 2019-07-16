
package com.hd.rpcn.util.xml.dom4j.voc2007;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hd.rpcn.util.xml.dom4j.voc2007 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Image_QNAME = new QName("", "image");
    private final static QName _Ymin_QNAME = new QName("", "ymin");
    private final static QName _Xmin_QNAME = new QName("", "xmin");
    private final static QName _Pose_QNAME = new QName("", "pose");
    private final static QName _Flickrid_QNAME = new QName("", "flickrid");
    private final static QName _Truncated_QNAME = new QName("", "truncated");
    private final static QName _Difficult_QNAME = new QName("", "difficult");
    private final static QName _Segmented_QNAME = new QName("", "segmented");
    private final static QName _Database_QNAME = new QName("", "database");
    private final static QName _Folder_QNAME = new QName("", "folder");
    private final static QName _Filename_QNAME = new QName("", "filename");
    private final static QName _Depth_QNAME = new QName("", "depth");
    private final static QName _Ymax_QNAME = new QName("", "ymax");
    private final static QName _Xmax_QNAME = new QName("", "xmax");
    private final static QName _Rate_QNAME = new QName("", "rate");
    private final static QName _Name_QNAME = new QName("", "name");
    private final static QName _Width_QNAME = new QName("", "width");
    private final static QName _Height_QNAME = new QName("", "height");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hd.rpcn.util.xml.dom4j.voc2007
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Annotation }
     * 
     */
    public Annotation createAnnotation() {
        return new Annotation();
    }

    /**
     * Create an instance of {@link Source }
     * 
     */
    public Source createSource() {
        return new Source();
    }

    /**
     * Create an instance of {@link Owner }
     * 
     */
    public Owner createOwner() {
        return new Owner();
    }

    /**
     * Create an instance of {@link Size }
     * 
     */
    public Size createSize() {
        return new Size();
    }

    /**
     * Create an instance of {@link Object }
     * 
     */
    public Object createObject() {
        return new Object();
    }

    /**
     * Create an instance of {@link Bndbox }
     * 
     */
    public Bndbox createBndbox() {
        return new Bndbox();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "image")
    public JAXBElement<String> createImage(String value) {
        return new JAXBElement<String>(_Image_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ymin")
    public JAXBElement<String> createYmin(String value) {
        return new JAXBElement<String>(_Ymin_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "xmin")
    public JAXBElement<String> createXmin(String value) {
        return new JAXBElement<String>(_Xmin_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pose")
    public JAXBElement<String> createPose(String value) {
        return new JAXBElement<String>(_Pose_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "flickrid")
    public JAXBElement<String> createFlickrid(String value) {
        return new JAXBElement<String>(_Flickrid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "truncated")
    public JAXBElement<String> createTruncated(String value) {
        return new JAXBElement<String>(_Truncated_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "difficult")
    public JAXBElement<String> createDifficult(String value) {
        return new JAXBElement<String>(_Difficult_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "segmented")
    public JAXBElement<String> createSegmented(String value) {
        return new JAXBElement<String>(_Segmented_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "database")
    public JAXBElement<String> createDatabase(String value) {
        return new JAXBElement<String>(_Database_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "folder")
    public JAXBElement<String> createFolder(String value) {
        return new JAXBElement<String>(_Folder_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "filename")
    public JAXBElement<String> createFilename(String value) {
        return new JAXBElement<String>(_Filename_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "depth")
    public JAXBElement<String> createDepth(String value) {
        return new JAXBElement<String>(_Depth_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ymax")
    public JAXBElement<String> createYmax(String value) {
        return new JAXBElement<String>(_Ymax_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "xmax")
    public JAXBElement<String> createXmax(String value) {
        return new JAXBElement<String>(_Xmax_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "rate")
    public JAXBElement<String> createRate(String value) {
        return new JAXBElement<String>(_Rate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "width")
    public JAXBElement<String> createWidth(String value) {
        return new JAXBElement<String>(_Width_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "height")
    public JAXBElement<String> createHeight(String value) {
        return new JAXBElement<String>(_Height_QNAME, String.class, null, value);
    }

}
