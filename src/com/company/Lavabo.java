package com.company;

public class Lavabo {

    int totalHomes ;
    int totalDones ;
    boolean disponibleHomes = true;
    boolean disponibleDones = true;


    public synchronized void entrar(String sexe) throws InterruptedException {


        if (sexe.equalsIgnoreCase("mascle")){
            while (!disponibleHomes ) wait();
            disponibleDones = false;

            totalHomes++;
            notifyAll();
            System.out.println("entro home i som : " + totalHomes);
        }else {
            while (!disponibleDones ) wait();
            disponibleHomes = false;
            totalDones ++;
            notifyAll();
            System.out.println("entro dona i som : " + totalDones);

        }

        if (totalHomes == 4 ) {
            disponibleHomes = false;
        }
        if (totalDones == 4 ){
            disponibleDones = false;
        }



    }
    synchronized void sortir(String sexe){
        if (sexe.equalsIgnoreCase("mascle")){
            totalHomes--;
            if (totalHomes == 0) {
                disponibleDones = true;
            }
            System.out.println("home sortin");
        }else {
            totalDones--;
            if (totalDones == 0){
                disponibleHomes= true;
            }
        }
    }
}
