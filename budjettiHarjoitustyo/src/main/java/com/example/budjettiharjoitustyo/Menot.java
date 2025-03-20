package com.example.budjettiharjoitustyo;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.io.*;

public class Menot implements Serializable {
    private double vuokra;
    private double ruoka;
    private double muuMeno;
    private boolean onkoMenoja;

    public Menot(){

    }

    public Menot(double vuokra, double ruoka,double muutMeno){
        this.vuokra=vuokra;
        this.ruoka=ruoka;
        this.muuMeno=muutMeno;

    }


    public double getVuokra() {
        return vuokra;
    }

    public void setVuokra(int vuokra) {
        this.vuokra = vuokra;
    }

    public double getRuoka() {
        return ruoka;
    }

    public void setRuoka(double ruoka) {
        this.ruoka = ruoka;
    }

    public double getMuuMeno() {
        return muuMeno;
    }

    public void setMuuMeno(double muuMeno) {
        this.muuMeno = muuMeno;
    }

    public boolean getOnkoMenoja() {
        return onkoMenoja;
    }

    public void setOnkoMenoja(boolean onkoMenoja) {
        this.onkoMenoja = onkoMenoja;
    }

    public void lueMenoTiedostoon(Object menoOlio){
        File fileStreamMeno = new File("Menotiedot.dat");
        ObjectOutputStream olioTiedostoMeno =null;

        try{
            olioTiedostoMeno =new ObjectOutputStream(new FileOutputStream(fileStreamMeno));
            olioTiedostoMeno.writeObject(menoOlio);
            olioTiedostoMeno.close();
        } catch (IOException | NumberFormatException error) {
            Alert ioAlert=new Alert(Alert.AlertType.ERROR,"Nyt ei onnistunut!", ButtonType.CLOSE);
        }
    }

    public Object menoOlioTiedostonLuku() {
        File tiedostonNimi = new File("Menotiedot.dat");
        Menot lukuolio = null;
        if (!tiedostonNimi.exists()) {
            Alert nullAlert = new Alert(Alert.AlertType.ERROR, "Tiedostoa ei ole!", ButtonType.CLOSE);
            int i = 0;
            System.exit(i);
        } else {
            try {
                boolean tiedostoLoppui = false;
                FileInputStream tiedostoMeno = new FileInputStream(tiedostonNimi);
                ObjectInputStream luetaanMeno = new ObjectInputStream(tiedostoMeno);
                while (!tiedostoLoppui) {
                    lukuolio = (Menot) luetaanMeno.readObject();
                }
                luetaanMeno.close();
            } catch (IOException | ClassNotFoundException e) {
                Alert catcherAlert = new Alert(Alert.AlertType.ERROR, "Ei Onnistunut!", ButtonType.CLOSE);
            }
        }
        return lukuolio;
    }

}
