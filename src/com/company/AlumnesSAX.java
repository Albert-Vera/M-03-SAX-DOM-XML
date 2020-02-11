package com.company;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


public class AlumnesSAX {

    public static class UserHandler extends DefaultHandler{
        boolean bnom;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("Alumne")){
                String edad = attributes.getValue("Edad");
                System.out.println("Edad: " + edad);
            }
            else if (qName.equalsIgnoreCase("Nom")){
            bnom = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("Alumne")){
                System.out.println("End Element :" + qName);
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bnom){
                System.out.println("Nom: " + new String(ch, start, length));
                bnom = false;
            }
        }

    }
    public static void main(String[] args) {
        try {
            File inputFile = new File("/home/dam2a/Escriptori/Alumnes.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}

