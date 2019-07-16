## 1、添加依赖
```xml
dependency>
    <groupId>org.dom4j</groupId>
    <artifactId>dom4j</artifactId>
    <version>2.1.1</version>
</dependency>
```

## 2、使用dom4j解析xml文件
### 2.1 构建dom4j树
    org.dom4j.io提供了两个类：SAXReader和DOMReader，DOMReader只能一个现有的w3c DOM树构建dom4j树，即只能从一个org.w3c.dom.Document中构建org.dom4j.Document树，而SAXReader则使用SAX解析器，从不同的输入源构建dom4j树，如可以从xml文件中读取并构建dom4j树
 
#### 实例代码：使用SAXReader解析
```xml
    SAXReader reader = new SAXReader();
    Document document = reader.read(new File("d:/skills.xml"));
```
   
#### 实例代码：使用DOMReader解析
```xml
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
File file = new File("d:/skills.xml");
org.w3c.dom.Document domDocument = db.parse(file);
DOMReader reader = new DOMReader();
org.dom4j.Document document = reader.read(domDocument);
```

### 2.2 获取节点
#### 获取根节点
```xml
Element root = document.getRootElement();
```

#### 访问子节点
```xml
List<Element> elements = rootElement.elements();
//3.使用根元素的对象  对其他元素操作操作
//3.1获取所有的子元素对象 book
for (Element book : elements) {
    //在循环内拿到了 每个 book  元素对象
    ...
}
```

#### 访问指定名称的第一个节点
```xml
Element skill = root.element("skill");
```

#### 获取属性
##### 实例代码：获取指定名称的元素
```xml
Element skill = root.element("skill");
Attribute attr1 = skill.attribute("name");
```