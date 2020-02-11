package com.company;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class AlumnesDOM1 {

    public static void main(String[] args) {


        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            //root element
            Element rootElement = doc.createElement("Alumnes");
            doc.appendChild(rootElement);
            //grau element
            Element alumne = doc.createElement("Alumne");
            rootElement.appendChild(alumne);
            Element dni = doc.createElement("DNI");
            alumne.appendChild(dni);
            dni.appendChild(doc.createTextNode("58887452J"));
            Element nom = doc.createElement("Nom");
            alumne.appendChild(nom);
            nom.appendChild(doc.createTextNode("Daniel"));
            Element cognom1 = doc.createElement("Cognom1");
            alumne.appendChild(cognom1);
            cognom1.appendChild(doc.createTextNode("Alvarez"));
            Element cognom2 = doc.createElement("Cognom2");
            alumne.appendChild(cognom2);
            cognom2.appendChild(doc.createTextNode("Ruiz"));
            Element ciutat = doc.createElement("Ciutat");
            alumne.appendChild(ciutat);
            ciutat.appendChild(doc.createTextNode("Santa Coloma de Gramenet"));
            Element assignatures = doc.createElement("Assignatures");
            alumne.appendChild(assignatures);
            assignatures.appendChild(doc.createTextNode("Biologia"));


            Attr edad = doc.createAttribute("Edad");
            edad.setValue("17");
            alumne.setAttributeNode(edad);

            //write content into xml file

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/home/dam2a/Escriptori/Alumnes.xml"));
            t.transform(source, result);
            //output to console for testing

            StreamResult consoleResult = new StreamResult(System.out);
            t.transform(source, consoleResult);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
