package com.company;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class UsuariExercici1 {

    public static void main(String[] args) {


        try {
            //crear documentos
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("/home/dam2a/Baixades/cartaplats.xml");

            //root element
            Element rootElement = doc.getDocumentElement();

            //grau element
            Element plat = doc.createElement("plat");
            rootElement.appendChild(plat);
            Element descripcio = doc.createElement("descripcio");
            plat.appendChild(descripcio);
            descripcio.appendChild(doc.createTextNode("Spaghetti al pesto"));
            Element categoria = doc.createElement("categoria");
            plat.appendChild(categoria);
            categoria.appendChild(doc.createTextNode("Pasta"));
            Element preu = doc.createElement("preu");
            plat.appendChild(preu);
            preu.appendChild(doc.createTextNode("8"));


            Attr codi = doc.createAttribute("codi");
            codi.setValue("P7");
            plat.setAttributeNode(codi);


            //write content into xml file

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/home/dam2a/Baixades/cartaplats.xml"));
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
