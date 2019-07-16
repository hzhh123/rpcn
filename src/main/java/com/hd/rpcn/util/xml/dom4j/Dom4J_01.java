package com.hd.rpcn.util.xml.dom4j;

import cn.hutool.core.io.FileUtil;
import com.hd.rpcn.util.xml.dom4j.voc2007.Annotation;
import com.hd.rpcn.util.xml.dom4j.voc2007.Owner;
import com.hd.rpcn.util.xml.dom4j.voc2007.Size;
import com.hd.rpcn.util.xml.dom4j.voc2007.Source;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dom4J_01 {
    public static void main(String[] args) throws Exception {
//        //1.将xml文件加载到内存中
//        SAXReader saxReader = new SAXReader();
//        //document 加载执行xml文档获取Document对象
//        InputStream in = Dom4J_01.class.getClassLoader().getResourceAsStream("xml/book.xml");
//        Document document = saxReader.read(in);
//        //2.获取根元素的对象 -- books getRootElement 获取根元素
//        Element rootElement = document.getRootElement();
//        //每个元素的对象 都是Element对象
//        List<Element> elements = rootElement.elements();
//        //3.使用根元素的对象  对其他元素操作操作
//        //3.1获取所有的子元素对象 book
//        for (Element book : elements) {
//            //在循环内拿到了 每个 book  元素对象
//            //3.2获取book的属性值
//            String author = book.attributeValue("author");
//            //3.3获取book的子元素  name price
//            String name = book.element("name").getText();
//            String price = book.element("price").getText();
//            System.out.println(name+" "+author +" "+price );
//        }

//        String content= FileUtil.readString(new File("D:\\workspace\\eclipse_workspace\\work1\\rpcn\\src\\main\\resources\\xml\\book.xml"), Charset.forName("UTF-8"));
//        Books o = (Books)convertXmlStrToObject(Books.class, content);
//        System.out.println(o);
//        List<Book>bookList=new ArrayList<Book>();
//        Books books=new Books();
//        for (int i=0;i<10;i++){
//            Book book=new Book();
//            book.setName("i"+i);
//            book.setPrice("10"+i);
//            if (i%3==0) {
//                book.setAuthor("123");
//            }
//            if (i==9){
//                book.setName(null);
//            }
//            bookList.add(book);
//        }
//        books.setBook(bookList);
//        String xmlStr = convertToXmlStr(books);
//        System.out.println(xmlStr);

       // parseXML2Object();
        Annotation annotation=new Annotation();
        List<Object>content=new ArrayList<>();
        Map<String,Object>map=new HashMap<>();
        map.put("folder","123");
        content.add(map);
        annotation.setContent(content);
        convertToXmlStr(annotation);
    }

    private static void parseXML2Object() throws Exception {
        String content= FileUtil.readString(new File("D:\\workspace\\eclipse_workspace\\work1\\rpcn\\src\\main\\resources\\xml\\3.xml"), Charset.forName("UTF-8"));
        Annotation o = (Annotation)convertXmlStrToObject(Annotation.class, content);
        List<Object> contents= o.getContent();
        for (Object obj:contents){
            if (obj instanceof JAXBElement) {
                JAXBElement jobj=(JAXBElement)obj;
                System.out.println(jobj.getName());
                System.out.println(jobj.getValue());
            }

            if (obj instanceof com.hd.rpcn.util.xml.dom4j.voc2007.Object){
                com.hd.rpcn.util.xml.dom4j.voc2007.Object oo=(com.hd.rpcn.util.xml.dom4j.voc2007.Object)obj;
                System.out.println(oo);
            }
            if (obj instanceof Owner){
                Owner oo=(Owner)obj;
                System.out.println(oo);
            }
            if (obj instanceof Source){
                Source oo=(Source)obj;
                System.out.println(oo);
            }
            if (obj instanceof Size){
                Size oo=(Size)obj;
                System.out.println(oo);
            }
        }
    }

    public static Object convertXmlStrToObject(Class clazz,String xmlStr)throws Exception{
        JAXBContext context=JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller=context.createUnmarshaller();
        StringReader sr=new StringReader(xmlStr);
        return unmarshaller.unmarshal(sr);
    }



    /**
     *对象转换成xmlString
     *
     *createdbycaizhon2018-05-24v1.0
     */
    public static String convertToXmlStr(Object obj)throws Exception{
        //创建输出流
        StringWriter sw=new StringWriter();
        //利用jdk中自带的转换类实现
        JAXBContext context=JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller=context.createMarshaller();
        //格式化xml输出的格式
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xm头声明信息
        //去掉生成xml的默认报文头
        //marshaller.setProperty(Marshaller.JAXB_FRAGMENT,Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        //将对象转换成输出流形式的xml
        marshaller.marshal(obj,sw);
        return sw.toString();
    }
}
