package com.example.budjettiharjoitustyo;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.io.*;

/**
 * Kasittelee menojen rahamaaria, seka meno-olion tiedostoon kirjoitusta ja tiedostosta lukemista
 */
public class Menot implements Serializable {
    /**
     * kasiteltava vuokran rahamaara desimaaleina
     */
    private double vuokra;
    /**
     * kasiteltava ruuan rahamaara desimaaleina
     */
    private double ruoka;
    /**
     * kasiteltava muiden menojen rahamaara desimaaleina
     */
    private double muuMeno;
    /**
     * kasiteltavien menojen olemassaolo
     */
    private boolean onkoMenoja;
    /**
     * kasiteltavien menojen yhteenlaskettu arvo desimaalilukuina
     */
    private double menoMuutosMaara;

    /**
     * luokan parametriton alustaja
     */
    public Menot(){

    }

    /**
     * alustaja, jolla on kolme menojen kenttaa
     * @param vuokra vuokran maara desimaalilukuina
     * @param ruoka ruokaan meneva rahamaara desimaaleina
     * @param muutMeno muihin menoihin meneva rahamaara desimaaleina
     */
    public Menot(double vuokra, double ruoka,double muutMeno){
        this.vuokra=vuokra;
        this.ruoka=ruoka;
        this.muuMeno=muutMeno;

    }

    /**
     * palauttaa vuokran maaran desimaaleina
     * @return vuokran desimaaliluku
     */
    public double getVuokra() {
        return vuokra;
    }

    /**
     * asettaa vuokran maaran
     * @param vuokra annettu desimaaliluku vuokralle
     */
    public void setVuokra(int vuokra) {
        this.vuokra = vuokra;
    }

    /**
     * palauttaa ruokaan menevan rahamaaran desimaaleina
     * @return rahasumma desimaaleina
     */
    public double getRuoka() {
        return ruoka;
    }

    /**
     * asettaa ruokaan menevan rahamaaran desimaaleina
     * @param ruoka annettu summa desimaaleina
     */
    public void setRuoka(double ruoka) {
        this.ruoka = ruoka;
    }

    /**
     * palauttaa muihuin menoihin menevan rahasumman desimaaleina
     * @return summan desimaalilukuna
     */
    public double getMuuMeno() {
        return muuMeno;
    }

    /**
     * asettaa muihin menoihin menevan rahasumman desimaaleina
     * @param muuMeno annettu summa muihim menoihin desimaaleina
     */
    public void setMuuMeno(double muuMeno) {
        this.muuMeno = muuMeno;
    }

    /**
     * palauttaa menojen olemassaolon
     * @return totuusarvo onko menoja
     */
    public boolean getOnkoMenoja() {
        return onkoMenoja;
    }

    /**
     * asettaa menojen olemassaoloarvon
     * @param onkoMenoja annettu totuusarvo menoista
     */
    public void setOnkoMenoja(boolean onkoMenoja) {
        this.onkoMenoja = onkoMenoja;
    }

    /**
     * palauttaa yhteenlaskettujen menojen maaran desimaaleina
     * @return summa menoista desimaaleina
     */
    public double getMenoMuutosMaara() {
        return menoMuutosMaara;
    }

    /**
     * asettaa yhteenlaskettujen menojen maaran desimaaleina
     * @param menoMuutosMaara annettu desimaaliluku
     */
    public void setMenoMuutosMaara(double menoMuutosMaara) {
        this.menoMuutosMaara = menoMuutosMaara;
    }

    /**
     * kirjoitetaan Menot-luokan olion tietueet binaaritiedostoon.
     * virhetilanteessa kaytetaan pop-up ikkunoita
     * @param menoOlio olio jonka tiedot halutaan kirjoittaa
     */
    public void lueMenoTiedostoon(Object menoOlio){
        File fileStreamMeno = new File("Menotiedot.dat");
        ObjectOutputStream olioTiedostoMeno =null;
        try{
            olioTiedostoMeno =new ObjectOutputStream(new FileOutputStream(fileStreamMeno));
            olioTiedostoMeno.writeObject(menoOlio);
            olioTiedostoMeno.close();
        } catch (IOException | NumberFormatException error) {
            Alert ioAlert=new Alert(Alert.AlertType.ERROR,"Nyt ei onnistunut!", ButtonType.CLOSE);
            ioAlert.showAndWait();
        }
    }

    /**
     * luetaan tiedostosta Menot-luokan olion tietoja ja lasketaan menojen maara muutosMaaraan.
     * virhetilanteissa tulee pop-up ikkuna
     */
    public void menoOlioTiedostonLuku() {
        File tiedostonNimi = new File("Menotiedot.dat");
        if (!tiedostonNimi.exists()) {
            Alert nullAlert = new Alert(Alert.AlertType.ERROR, "Tiedostoa ei ole!", ButtonType.CLOSE);
            nullAlert.showAndWait();
            System.exit(0);
        } else {
            try {
                FileInputStream tiedostoMeno = new FileInputStream(tiedostonNimi);
                ObjectInputStream luetaanMeno = new ObjectInputStream(tiedostoMeno);
                Object luettu=luetaanMeno.readObject();
                if(luettu instanceof Menot){
                    Menot olio= (Menot) luettu;
                    this.vuokra = olio.getVuokra();
                    this.ruoka = olio.getRuoka();
                    this.muuMeno = olio.getMuuMeno();
                    this.menoMuutosMaara = vuokra + ruoka + muuMeno;
                }
                else{
                    Alert catcherAlert = new Alert(Alert.AlertType.ERROR, "Tiedosto ei ole oikea!", ButtonType.CLOSE);
                    catcherAlert.showAndWait();
                    return;
                }
            } catch (IOException | ClassNotFoundException e) {
                Alert catcherAlert = new Alert(Alert.AlertType.ERROR, "Ei onnistunut!", ButtonType.CLOSE);
                catcherAlert.showAndWait();
            }
        }
    }

}
