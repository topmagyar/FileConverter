package com.develop.converter.parsers;

import com.develop.converter.entity.Car;
import com.develop.converter.parsers.base.Parser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlParser implements Parser {

    public List<Car> convertFrom(String filePath) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(filePath);
        doc.getDocumentElement().getNodeName();
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("Car");
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            nNode.getNodeName();
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                String date = element.getElementsByTagName("Date").item(0).getTextContent();
                String brandName = element.getElementsByTagName("BrandName").item(0).getTextContent();
                String price = element.getElementsByTagName("Price").item(0).getTextContent();
                list.add(new Car(date, brandName, price));
            }
        }
        return list;
    }

    public void convertTo(String filePath, List<Car> cars) throws Exception {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("Document");
        document.appendChild(root);

        for (Car car : cars) {
            Element carElement = document.createElement("Car");
            root.appendChild(carElement);
            Element dateElement = document.createElement("Date");
            dateElement.appendChild(document.createTextNode(car.getDate()));
            carElement.appendChild(dateElement);
            Element brandNameElement = document.createElement("BrandName");
            brandNameElement.appendChild(document.createTextNode(car.getBrandName()));
            carElement.appendChild(brandNameElement);
            Element priceElement = document.createElement("Price");
            priceElement.appendChild(document.createTextNode(car.getPrice()));
            carElement.appendChild(priceElement);
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(filePath));
        transformer.transform(domSource, streamResult);
    }
}
