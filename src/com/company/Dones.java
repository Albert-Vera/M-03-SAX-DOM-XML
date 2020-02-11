package com.company;

public class Dones  extends Thread{

     String sexeD = "Femella";
    Lavabo lavabo = new Lavabo();

    public Dones(String name, String sexeD) {
        super(name);
        this.sexeD = sexeD;
    }

    @Override
    public void run() {

        try {
            lavabo.entrar(sexeD);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Estic dintre i pixo tranquil/la  " + getName() );

        try {
            Thread.sleep((long) Math.random() * 3000 + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lavabo.sortir(sexeD);
        try {
            Thread.sleep((long) Math.random() * 3000 + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
