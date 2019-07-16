package com.hd.rpcn.voc2007.result;

import cn.hutool.core.io.FileUtil;
import com.hd.rpcn.util.xml.XmlUtil;
import com.hd.rpcn.voc2007.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 结果集处理
 */
public class ResultProcess {
    /**
     * 识别率
     */
    private static final double RATE = 0.95d;
    /**
     * 未识别的图片路径
     */
    private static final String UN_CORRECT = "D:\\hzhh123\\AI\\uncorrect\\";
    /**
     * 已识别的图片路径
     */
    private static final String RECOGNIZED = "D:\\hzhh123\\AI\\recognized\\";
    /**
     * 文件样本数据目录
     */
    private static final String INPUT = "D:\\hzhh123\\AI\\input\\";

    public static void main(String[] args) {
        //convertXMLResult("D:\\hzhh123\\AI\\output", "output");
        markRecognized2UnCorrect("D:\\hzhh123\\AI\\recognized\\15.png");
    }

    private static annotation parseXML(String xmlPath) {
        DomParser d = new DomParser();
        try {
            annotation a = (annotation) d
                    .parseObject(new File(xmlPath), annotation.class);
            System.out.println(a);
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 处理字符
     *
     * @param str
     */
    public static object HandleCharacters(String str) {
        String clazz = str.substring(0, str.indexOf(":"));
        String bndBox = str.substring(str.indexOf(":") + 1,
                str.lastIndexOf(":"));
        bndbox bbox = new bndbox();
        String[] bndBoxArr = bndBox.split(" ");
        bbox.setXmin(bndBoxArr[0]);
        bbox.setYmin(bndBoxArr[1]);
        bbox.setXmax(bndBoxArr[2]);
        bbox.setYmax(bndBoxArr[3]);
        String rate = str.substring(str.lastIndexOf(":") + 1, str.length());
        object obj = new object();
        obj.setName(clazz);
        obj.setRate(rate);
        obj.setBndbox(bbox);
        return obj;
    }

    /**
     * 读取文本字符串转换为XML
     *
     * @param folder 文件目录名称
     * @param path   文件目录地址
     */
    public static void convertXMLResult(String path, String folder) {
        File f = new File(path);
        if (f.exists() && f.isDirectory()) {
            File[] listFiles = f.listFiles();
            if (listFiles.length > 0) {
                for (File f1 : listFiles) {
                    String fileName = f1.getName();
                    String FileSuffix = fileName.substring(
                            fileName.lastIndexOf(".") + 1, fileName.length());
                    if (FileSuffix.equals("txt")) {
                        List<String> ss = toArrayByFileReader(f1
                                .getAbsolutePath());
                        if (ss.size() > 0) {
                            List<object> objects = new ArrayList<object>();
                            annotation an = new annotation();
                            an.setFolder("VOC2007");
                            fileName = fileName.replace(".txt", "");
                            size sizez = new size();
                            sizez.setDepth("3");
                            String[] wh = getPicWidthAndHeight(INPUT+ fileName);
                            sizez.setWidth(wh[0]);
                            sizez.setHeight(wh[1]);
                            an.setSize(sizez);
                            an.setFilename(fileName);
                            for (String s : ss) {
                                object obj = HandleCharacters(s);
                                objects.add(obj);
                            }
                            an.setObject(objects);
                            String filePath = path
                                    + File.separator
                                    + fileName.substring(0,
                                    fileName.lastIndexOf(".")) + ".xml";
                            List<object> oobjs = an.getObject();
                            boolean flag = true;
                            for (object obj : oobjs) {
                                double rate1 = Double
                                        .parseDouble(obj.getRate());
                                if (rate1 - RATE < 0) {
                                    flag = false;
                                }
                            }
                            if (flag) {
                                // 移动到已识别的文件夹里
                                HandlerRecognized(path, f1, fileName, an);
                            } else {
                                // 识别率低,将文件导入到修正文件夹里
                                // 移动到已识别的文件夹里
                                HandlerUncorrect(path, f1, fileName, an);
                            }
                        } else {
                            // 没有任何标注的，需要重新放在需要修正的目录中
                            f1.delete();// 删除txt空的文件
                            fileName = fileName.replace(".txt", "");
                            // System.out.println(fileName);
                            String filePath = UN_CORRECT + fileName;
                            FileUtil.move(new File(path, fileName), new File(UN_CORRECT), true);
                        }
                    }
                }
            }
        }
    }

    /**
     * 处理识别率较低的图片
     * @param path
     * @param f1
     * @param fileName
     * @param an
     */
    private static void HandlerUncorrect(String path, File f1, String fileName, annotation an) {
        String filePath;
        fileName = fileName.replace(".txt", "");
        String fileSuffix=fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        //String filePath1 = UN_CORRECT + fileName;
        File f11 = new File(path, fileName);
        //复制
        File inputFile = new File(INPUT, fileName);
        String newPath=INPUT+fileName.replace(fileSuffix,"jpg");
        if (inputFile.exists()) {
            //修改图片格式为jpg,其他格式的图片在标记时使用标记软件无法识别
            if (!fileSuffix.equals("jpg")){
                FileUtil.copy(f11, new File(newPath), true);
                //ModifyFileSuffix.modify(inputFile.getPath(),"jpg");
            }
            FileUtil.copy(new File(newPath), new File(UN_CORRECT), true);
            if (!fileSuffix.equals("jpg")){
                new File(newPath).delete();
            }
        }

        filePath = UN_CORRECT
                + fileName.substring(0,
                fileName.lastIndexOf("."))
                + ".xml";
        // 生成新的标注文件
        if (!fileSuffix.equals("jpg")){
            an.setFilename(fileName.replace(fileSuffix,"jpg"));
        }
        createNewMarkXml(an, filePath);
        f1.delete();
        f11.delete();
    }

    /**
     * 处理已识别的文件
     * @param path
     * @param f1
     * @param fileName
     * @param an
     */
    private static void HandlerRecognized(String path, File f1, String fileName, annotation an) {
        String filePath;
        fileName = fileName.replace(".txt", "");
        String filePath1 = RECOGNIZED + fileName;
        System.out.println(filePath1);
        File f11 = new File(path, fileName);
        System.out.println(f11.getAbsolutePath());
        FileUtil.move(f11, new File(RECOGNIZED), true);
        filePath = RECOGNIZED
                + fileName.substring(0,
                fileName.lastIndexOf("."))
                + ".xml";
        createXml(an, filePath);
        f1.delete();
    }

    /**
     * 返回读取文本列数组集合
     *
     * @param name
     * @return
     */
    public static List<String> toArrayByFileReader(String name) {
        // 使用ArrayList来存储每行读取到的字符串
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回数组
        return arrayList;
    }

    /**
     * 生成结果的XML 构建转换成XML
     */
    private static void createXml(annotation an, String path) {
        try {
            String content = buildXmlBody(an, path, true);
            byte[] data = XmlUtil.outPut(content);
            if (data != null) {
                try {
                    content = new String(data, "UTF-8");
                    FileUtil.writeString(content, path, Charset.forName("UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成标注的XML
     *
     * @param an
     * @param path
     */
    private static void createNewMarkXml(annotation an, String path) {
        try {
            String content = buildXmlBody(an, path, false);
            byte[] data = XmlUtil.outPut(content);
            if (data != null) {
                try {
                    content = new String(data, "UTF-8");
                    FileUtil.writeString(content, path, Charset.forName("UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 构建XML
     *
     * @param an
     * @param path
     * @param hasRate
     * @return
     * @throws ParserConfigurationException
     * @throws TransformerFactoryConfigurationError
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    private static String buildXmlBody(annotation an, String path,
                                       boolean hasRate) throws ParserConfigurationException,
            TransformerFactoryConfigurationError,
            TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();// 新建DOM
        doc.setXmlStandalone(true);
        Element root = doc.createElement("annotation");
        doc.appendChild(root);
        Element folder = doc.createElement("folder");
        folder.setTextContent(an.getFolder());
        root.appendChild(folder);
        Element filename = doc.createElement("filename");
        filename.setTextContent(an.getFilename());
        root.appendChild(filename);
        Element source = doc.createElement("source");
        root.appendChild(source);
        Element database = doc.createElement("database");
        database.setTextContent("The VOC2007 Database");
        source.appendChild(database);
        Element annotation = doc.createElement("annotation");
        annotation.setTextContent("PASCAL VOC2007");
        source.appendChild(annotation);
        Element image = doc.createElement("image");
        image.setTextContent("flickr");
        source.appendChild(image);
        Element flickrid = doc.createElement("flickrid");
        flickrid.setTextContent("319318625");
        source.appendChild(flickrid);

        Element owner = doc.createElement("owner");
        root.appendChild(owner);
        Element flickrid1 = doc.createElement("flickrid");
        flickrid1.setTextContent("El Mitch");
        owner.appendChild(flickrid1);
        Element name = doc.createElement("name");
        name.setTextContent("kaicheng");
        owner.appendChild(name);
        Element size = doc.createElement("size");
        root.appendChild(size);
        Element width = doc.createElement("width");
        width.setTextContent(an.getSize().getWidth());
        size.appendChild(width);

        Element height = doc.createElement("height");
        height.setTextContent(an.getSize().getHeight());
        size.appendChild(height);
        Element depth = doc.createElement("depth");
        depth.setTextContent(an.getSize().getDepth());
        size.appendChild(depth);
        Element segmented = doc.createElement("segmented");
        segmented.setTextContent("0");
        root.appendChild(segmented);
        if (an.getObject() != null && an.getObject().size() > 0) {
            for (object obj : an.getObject()) {
                Element object = doc.createElement("object");
                root.appendChild(object);
                Element name1 = doc.createElement("name");
                name1.setTextContent(obj.getName());
                object.appendChild(name1);
                if (hasRate) {
                    Element rate = doc.createElement("rate");
                    rate.setTextContent(obj.getRate());
                    object.appendChild(rate);
                } else {
                    Element pose = doc.createElement("pose");
                    pose.setTextContent("Unspecified");
                    object.appendChild(pose);
                    Element truncated = doc.createElement("truncated");
                    truncated.setTextContent("0");
                    object.appendChild(truncated);
                    Element difficult = doc.createElement("difficult");
                    difficult.setTextContent("0");
                    object.appendChild(difficult);
                }
                if (obj.getBndbox() != null) {
                    Element bndbox = doc.createElement("bndbox");
                    object.appendChild(bndbox);
                    Element xmin = doc.createElement("xmin");
                    xmin.setTextContent(obj.getBndbox().getXmin());
                    bndbox.appendChild(xmin);
                    Element ymin = doc.createElement("ymin");
                    ymin.setTextContent(obj.getBndbox().getYmin());
                    bndbox.appendChild(ymin);
                    Element xmax = doc.createElement("xmax");
                    xmax.setTextContent(obj.getBndbox().getXmax());
                    bndbox.appendChild(xmax);
                    Element ymax = doc.createElement("ymax");
                    ymax.setTextContent(obj.getBndbox().getYmax());
                    bndbox.appendChild(ymax);
                }
            }
        }
        TransformerFactory tfactory = TransformerFactory.newInstance();
        Transformer transformer = tfactory.newTransformer();
        DOMSource source1 = new DOMSource(doc);
        StreamResult resultXML = new StreamResult(new File(path));
        transformer.setOutputProperty("encoding", "UTF-8");
        transformer.transform(source1, resultXML);
        String content = FileUtil.readString(path, Charset.forName("UTF-8"));
        return content;
    }

    /**
     * 获取图片的宽度和高度
     *
     * @param path
     * @return
     */
    public static String[] getPicWidthAndHeight(String path) {
        String[] wh = new String[2];
        File picture = new File(path);
        try {
            FileInputStream in = new FileInputStream(picture);
            BufferedImage sourceImg = ImageIO
                    .read(in);
            wh[0] = "" + sourceImg.getWidth();
            wh[1] = "" + sourceImg.getHeight();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wh;
    }

    /**
     * 标记已识别的图片为未识别的
     */
    public static void markRecognized2UnCorrect(String imgPath) {
        File imgFile = new File(imgPath);
        String imgName = imgFile.getName();
        if (!imgFile.exists()) {
            throw new RuntimeException(imgName+"文件不存在");
        }
        String fileSuffix = imgName.substring(imgName.lastIndexOf("."),
                imgName.length());
        System.out.println(fileSuffix);
        String xmlPath = imgPath.replace(fileSuffix, ".xml");
        String xmlName = imgName.replace(fileSuffix, ".xml");
        System.out.println(xmlName);
        File xmlFile = new File(xmlPath);
        DomParser d = new DomParser();
        try {
            if (xmlFile.exists()) {
                annotation an = (annotation) d.parseObject(new File(xmlPath),
                        annotation.class);
                for (object obj : an.getObject()) {
                    obj.setPose("Unspecified");
                    obj.setTruncated("0");
                    obj.setDifficult("0");
                }
                System.out.println(an);
                String path = UN_CORRECT + xmlName;
                if (!fileSuffix.equals(".jpg")){
                    an.setFilename(imgName.replace(fileSuffix,".jpg"));
                }
                createNewMarkXml(an, path);
                //xmlFile.delete();
                String newPath = INPUT + imgName;
                String newCopyFilePath=INPUT+imgName.replace(fileSuffix,".jpg");
                String newMoveFilePath=UN_CORRECT+imgName.replace(fileSuffix,".jpg");
                System.out.println("newCopyFilePath::"+newCopyFilePath);
                System.out.println("newMoveFilePath::"+newMoveFilePath);
                if (!fileSuffix.equals(".jpg")){
                    FileUtil.copy(new File(newPath),new File(newCopyFilePath),true);
                }
                //ModifyFileSuffix.modify(newPath,"jpg");
                FileUtil.copy(new File(newCopyFilePath),new File(newMoveFilePath),true);
                if (!fileSuffix.equals(".jpg")){
                    new File(newCopyFilePath).delete();
                }
                imgFile.delete();
                xmlFile.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
