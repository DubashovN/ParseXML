package ru.dubashov;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadXML {
    private static final DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

    public static List<Integer> getNumbers(String fileName) {
        List<Integer> list = new ArrayList<>();

        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(fileName);
            NodeList nodeList = doc.getElementsByTagName("numbers");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    NodeList childNodesList = element.getChildNodes();

                    for (int j = 0; j < childNodesList.getLength(); j++) {
                        Node childNode = childNodesList.item(j);
                        if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element childElement = (Element) childNode;
                            Integer number = Integer.valueOf(childElement.getTextContent());
                            if (Number.isSimple(number)) {
                                list.add(number);
                            }
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}


