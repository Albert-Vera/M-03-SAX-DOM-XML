package com.company;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


public class UsuariExercici2 {

    public static class UserHandler extends DefaultHandler{
        boolean bdescripcio;
        boolean bcategoria;
        boolean bpreu;
        int contador = 1;
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("plat")){
                String codi = attributes.getValue("codi");
                System.out.println("Plat ( " + contador + " )");
                contador++;
                System.out.println("Codi: " + codi);
            }
            else if (qName.equalsIgnoreCase("descripcio")){
                bdescripcio = true;
            }
            else if (qName.equalsIgnoreCase("categoria")){
                bcategoria = true;
            }
            else if (qName.equalsIgnoreCase("preu")){
                bpreu = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("plat")){
                System.out.println("End Element :" + qName);
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bdescripcio){
                System.out.println("Descripcio: " + new String(ch, start, length));
                bdescripcio = false;
            }
            else if (bcategoria){
                System.out.println("Categoria: " + new String(ch, start, length));
                bcategoria = false;
            }
            else if (bpreu){
                System.out.println("Preu: " + new String(ch, start, length));
                bpreu = false;
            }
        }

    }
    public static void main(String[] args) {
        try {
            File inputFile = new File("/home/dam2a/Baixades/cartaplats.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}

