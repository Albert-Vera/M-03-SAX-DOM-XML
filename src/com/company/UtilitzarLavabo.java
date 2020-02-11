package com.company;

public class UtilitzarLavabo {

    public static void main(String[] args) {
        Homes home1 = new Homes("Albert", "mascle");
        Homes home2 = new Homes("Lluis", "mascle");
        Homes home3 = new Homes("Marc", "mascle");
        Homes home4 = new Homes("jaume", "mascle");

        Dones dona1 = new Dones("Maria", "femella");
        Dones dona2 = new Dones("Carme", "femella");
        Dones dona3 = new Dones("Alba", "femella");
        Dones dona4 = new Dones("Nathalie", "femella");

        home1.start();
        home2.start();
        home3.start();
        home4.start();
        dona1.start();
        dona2.start();
        dona3.start();
        dona4.start();
    }


}
