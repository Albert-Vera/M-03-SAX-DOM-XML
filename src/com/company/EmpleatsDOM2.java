package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class EmpleatsDOM2 {
    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        try {
            File file = new File("/home/dam2a/Escriptori/Empleats.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Empleat");
            System.out.println("-----------");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                System.out.println(nNode.getNodeName() + " " + (i+1));

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Username: " + eElement.getElementsByTagName("Username").item(0).getTextContent());
                    System.out.println("Firstname: " + eElement.getElementsByTagName("Firstname").item(0).getTextContent());
                    System.out.println("Lastname: " + eElement.getElementsByTagName("Lastname").item(0).getTextContent());
                    System.out.println("Email: " + eElement.getElementsByTagName("Email").item(0).getTextContent());
                    System.out.println("Password: " + eElement.getElementsByTagName("Password").item(0).getTextContent());

                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }






    }
}
