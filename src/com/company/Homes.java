package com.company;

public class Homes extends Thread {

    String sexeH= "mascle";
    Lavabo lavabo = new Lavabo();

    public Homes(String name, String sexe) {
        super(name);
        this.sexeH = sexe;
    }

    @Override
    public void run() {
        while(true) {
            try {
                lavabo.entrar(sexeH);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Estic dintre i pixo tranquil/la  " + getName());

            try {
                Thread.sleep((long) Math.random() * 5000 + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lavabo.sortir(sexeH);
            try {
                Thread.sleep((long) Math.random() * 5000 + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
