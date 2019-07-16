package com.hd.rpcn.voc2007;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * <p>
 * Title: 
 * </p>
 * 
 * <p>
 * Description: DOM解析器，用于通用XML文档和VO的映射
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: 
 * </p>
 * 
 * @author YER
 * @version 1.0
 */
public class DomParser {
	public DomParser() {
	}

	/**
	 * 
	 * @param path
	 * @throws SAXException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws IllegalArgumentException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Object parseObject(File path, Class clazz) throws SAXException,
			FileNotFoundException, IOException, ParserConfigurationException,
			IllegalArgumentException, ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		return parse(path, clazz);
	}

	/**
	 * 将XML文件解析成VO
	 * 
	 * @param path
	 *            String 文件路径
	 *            String 需要解析成的VO
	 * @return List
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 */
	public static Object parse(File path, Class clazz)
			throws ParserConfigurationException, SAXException, IOException,
			IllegalArgumentException, ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException { 
		DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
	 
		DocumentBuilder dombuilder = domfac.newDocumentBuilder();
		InputStream is = new FileInputStream(path);
		Element root = dombuilder.parse(is).getDocumentElement();
		return parseXml(root, clazz);  
	}

	/**
	 * 实际的解析方法
	 * 
	 *            Element XML文档根对象
	 *            String VO类名称
	 * @return List 返回VO列表
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
	private static Object parseXml(Node node, Class clazz)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		// Field[] fields = clazz.getFields();
		// Method[] setMethods = filterSetMethod(clazz.getMethods(), "set");
		Method[] getMethods = filterSetMethod(clazz.getMethods(), "get");

//		NodeList tableList = rootElement.getElementsByTagName(clazz
//				.getSimpleName()); 
//		for (int i = 0; i < tableList.getLength(); i++) {
			Object o = clazz.newInstance(); 
			// 遍历放入列表
			for (Node subnode = node.getFirstChild(); subnode != null; subnode = subnode
					.getNextSibling()) {
				for (int j = 0; j < getMethods.length; j++) {
					String fieldName = getMethods[j].getName().substring(3);
					fieldName = fieldName.substring(0, 1).toLowerCase()
							+ fieldName.substring(1);
					
					Class fieldClass = getMethods[j].getReturnType();
					if (subnode.getNodeName().equals(fieldName)) {
						String methodName = "set"
								+ fieldName.substring(0, 1).toUpperCase()
								+ fieldName.substring(1);
						String stringValue = subnode.getFirstChild()
								.getNodeValue();
						Object value = null;
						// System.out.println(fieldClass.getName());
						if( "source".equals(fieldName)){
							value = parseXml(subnode, source.class);
						}else if( "owner".equals(fieldName)){
							value = parseXml(subnode, owner.class);
						}if( "size".equals(fieldName)){
							value = parseXml(subnode, size.class);
						}else if( "object".equals(fieldName)){
						}if( "bndbox".equals(fieldName)){
							value = parseXml(subnode, bndbox.class);
						}else if( "object".equals(fieldName)){
								((com.hd.rpcn.voc2007.annotation)o).getObject().add((object) parseXml(subnode, object.class));
							continue;
						}else if (fieldClass.getName().equals("java.lang.String")) {
							value = stringValue;
						} else if (fieldClass.getName().equals(
								"java.lang.Integer")) {
							value = Integer.valueOf(stringValue);
						} else if (fieldClass.getName().equals("int")) {
							value = Integer.valueOf(stringValue);
						} else if (fieldClass.getName().equals(
								"java.lang.Float")) {
							value = Float.valueOf(stringValue);
						} else if (fieldClass.getName().equals("float")) {
							value = Float.valueOf(stringValue);
						} else if (fieldClass.getName().equals(
								"java.lang.Double")) {
							value = Float.valueOf(stringValue);
						} else if (fieldClass.getName().equals("double")) {
							value = Float.valueOf(stringValue);
						} else if (fieldClass.getName().equals(
								"java.math.BigDecimal")) {
							value = new BigDecimal(stringValue);
						} else if (fieldClass.getName()
								.equals("java.util.List")) {
							value = new BigDecimal(stringValue);
						}

						Method[] methods = o.getClass().getMethods();
						for (int g = 0; g < methods.length; g++) {
							Method method = methods[g];
							if (method.getName().equals(methodName)) {
								method.invoke(o, new Object[] { value });
							}
						}
					}
				}
			} 
//		}
		return o;
	}

	private void parseNode(Node node, Method m, Object vo)
			throws InvocationTargetException, IllegalArgumentException,
			IllegalAccessException {
		String fieldName = m.getName().substring(3);
		fieldName = fieldName.substring(0, 1).toLowerCase()
				+ fieldName.substring(1);
		Class fieldClass = m.getReturnType();

		String methodName = "set" + fieldName.substring(0, 1).toUpperCase()
				+ fieldName.substring(1);
		String stringValue = node.getFirstChild().getNodeValue();
		Object value = null;
		if (fieldClass.getName().equals("java.lang.String")) {
			value = stringValue;
		} else if (fieldClass.getName().equals("java.lang.Integer")) {
			value = Integer.valueOf(stringValue);
		} else if (fieldClass.getName().equals("int")) {
			value = Integer.valueOf(stringValue);
		} else if (fieldClass.getName().equals("java.lang.Float")) {
			value = Float.valueOf(stringValue);
		} else if (fieldClass.getName().equals("float")) {
			value = Float.valueOf(stringValue);
		} else if (fieldClass.getName().equals("java.lang.Double")) {
			value = Float.valueOf(stringValue);
		} else if (fieldClass.getName().equals("double")) {
			value = Float.valueOf(stringValue);
		} else if (fieldClass.getName().equals("java.math.BigDecimal")) {
			value = new BigDecimal(stringValue);
		} else if (fieldClass.getName().equals("java.util.List")) {
			for (Node subnode = node.getFirstChild(); subnode != null; subnode = subnode
					.getNextSibling()) {

			}
		}

		Method[] methods = vo.getClass().getMethods();
		for (int g = 0; g < methods.length; g++) {
			Method method = methods[g];
			if (method.getName().equals(methodName)) {
				method.invoke(vo, new Object[] { value });
			}
		}
	}

	private static Method[] filterSetMethod(Method[] ms, String start) {
		if (ms == null) {
			return null;
		}
		List l = new ArrayList();
		for (int i = 0; i < ms.length; i++) {
			String name = ms[i].getName();
			if (name.startsWith(start)) {
				l.add(ms[i]);
			}
		}
		Method[] ret = new Method[l.size()];
		for (int i = 0; i < l.size(); i++) {
			ret[i] = (Method) l.get(i);
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(String.class.getSimpleName());
	}
}
