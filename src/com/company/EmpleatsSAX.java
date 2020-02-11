package com.company;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


public class EmpleatsSAX {

    public static class UserHandler extends DefaultHandler{
        boolean busername;
        boolean bfirstname;
        boolean blastname;
        boolean bemail;
        boolean bpassword;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("Username")){
            busername = true;
            }
            else if (qName.equalsIgnoreCase("Firstname")){
                bfirstname = true;
            }
            else if (qName.equalsIgnoreCase("Lastname")){
                blastname = true;
            }
            else if (qName.equalsIgnoreCase("Email")){
                bemail = true;
            }
            else if (qName.equalsIgnoreCase("Password")){
                bpassword = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("Empleat")){
                System.out.println("End Element :" + qName);
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (busername){
                System.out.println("Username: " + new String(ch, start, length));
                busername = false;
            }
            else if (bfirstname){
                System.out.println("Firstname: " + new String(ch, start, length));
                bfirstname = false;
            }
            else if (blastname){
                System.out.println("Lastname: " + new String(ch, start, length));
                blastname = false;
            }
            else if (bemail){
                System.out.println("Email: " + new String(ch, start, length));
                bemail = false;
            }
            else if (bpassword){
                System.out.println("Password: " + new String(ch, start, length));
                bpassword = false;
            }
        }

    }
    public static void main(String[] args) {
        try {
            File inputFile = new File("/home/dam2a/Escriptori/Empleats.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}

