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
import java.io.*;
import java.util.ArrayList;

public class EmpleatsDOM1 {
    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        loadUser();
        writeUser();


    }

    static void loadUser() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.bin"));

        User userRead = (User) ois.readObject();
        while (userRead != null) {
            try {
                users.add(userRead);
                System.out.println(userRead);
                userRead = (User) ois.readObject();
            } catch (EOFException e) {
                break;
            }
        }

    }
    static void writeUser(){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            //root element
            Element rootElement = doc.createElement("Empleats");
            doc.appendChild(rootElement);

            for (User u: users) {

                Element empleat = doc.createElement("Empleat");
                rootElement.appendChild(empleat);


                Element username = doc.createElement("Username");
                empleat.appendChild(username);
                username.appendChild(doc.createTextNode(u.getUsername()));

                Element firstname = doc.createElement("Firstname");
                empleat.appendChild(firstname);
                firstname.appendChild(doc.createTextNode(u.getFirstname()));

                Element lastname = doc.createElement("Lastname");
                empleat.appendChild(lastname);
                lastname.appendChild(doc.createTextNode(u.getLastname()));

                Element email = doc.createElement("Email");
                empleat.appendChild(email);
                email.appendChild(doc.createTextNode(u.getEmail()));

                Element password = doc.createElement("Password");
                empleat.appendChild(password);
                password.appendChild(doc.createTextNode(u.getPassword()));





            }


            //write content into xml file

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/home/dam2a/Escriptori/Empleats.xml"));
            t.transform(source, result);
            //output to console for testing

            StreamResult consoleResult = new StreamResult(System.out);
            t.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
