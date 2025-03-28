package com.example.budjettiharjoitustyo;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.io.*;

/**
 * Luokka toteuttaa tuloja kasittelen olion luomisen, seka sen
 * tietojen kasittelyn tiedostoon ja tiedostosta lukemisen
 */
public class Tulot implements Serializable {
    /**
     * kaytettava ansio desimaalilukuna
     */
    private  double ansio;
    /**
     * kaytettava etuus desimaalilukuna
     */
    private double etuus;
    /**
     * kaytettava muun tulon rahamaara desimaalilukuna
     */
    private double muuTulos;
    /**
     * maarittelee onko tuloja ollenkaan
     */
    private boolean onkoTuloja;
    /**
     * yhteenlaskettuna tietueiden rahallinen maara desimaalilukuna
     */
    private double muutosMaara;

    /**
     * luo luokan parametritttoman alustajan
     */
    public Tulot(){

    }

    /**
     * alustaja oliolle, jolla on ansio, etuus ja muut tulot-kentat
     *
     * @param ansio saatu ansio desimaalilukuna
     * @param etuus saatu etuus desimaalilukuna
     * @param muuTulo saatu muut tulot desimaalilukuna
     */
    public Tulot(double ansio,double etuus,double muuTulo){
        this.ansio=ansio;
        this.etuus=etuus;
        this.muuTulos=muuTulo;
    }

    /**
     * palauttaa ansion maaran desimaalilukuna
     *
     * @return ansion desimaaliluku
     */
    public double getAnsio() {
        return ansio;
    }

    /**
     * asettaa annetun ansion tietueeseen
     *
     * @param ansio annettu desimaaliluku
     */
    public void setAnsio(double ansio) {
        this.ansio = ansio;
    }

    /**
     * palauttaa etuuden maaran desimaalilukuna
     *
     * @return etuuden desimaaliluku
     */
    public double getEtuus() {
        return etuus;
    }

    /**
     * asettaa etuuden desimaaliluvun tietueelle
     *
     * @param etuus annettu desimaaliluku
     */
    public void setEtuus(double etuus) {
        this.etuus = etuus;
    }

    /**
     * palauttaa mahdolliset muut tulot
     *
     * @return muiden tulojen desimaaliluku
     */
    public double getMuuTulos() {
        return muuTulos;
    }

    /**
     * asettaa mahdolliset muut tulot tietueelle desimaalilukuisena
     *
     * @param muuTulos annettu desimaaliluku
     */
    public void setMuuTulos(double muuTulos) {
        this.muuTulos = muuTulos;
    }

    /**
     * asettaa arvoksi onko tuloja olemassa vai ei
     *
     * @param onkoTuloja haluttu arvo tulojen olemassaolosta
     */
    public void setOnkoTuloja(boolean onkoTuloja) {
        this.onkoTuloja = onkoTuloja;
    }

    /**
     * palauttaa onko tuloja olemassa vai ei
     *
     * @return tulojen olemassaolo
     */
    public boolean getOnkoTuloja(){
        return onkoTuloja;
    }

    /**
     * palauttaa tulojen yhteenlasketun arvon desimaalilukuna
     *
     * @return rahamaara desimaalilukuina
     */
    public double getMuutosMaara() {
        return muutosMaara;
    }

    /**
     *asettaa kaikkien tulojen yhteenlasketunarvon desimaalilukuna
     *
     * @param muutosMaara tulojen yhteenlaskettu arvo
     */
    public void setMuutosMaara(double muutosMaara) {
        this.muutosMaara = muutosMaara;
    }

    /**
     * kirjoittaa annetun Tulot-objektin tiedot oliobinaaritiedostoon. Jos tiedostokirjoitus ei onnistu
     * antaa varoitusilmoituksen
     *
     * @param tuloOlio Tulot-objektin jonka tietoja kirjoitetaan
     */
    public void lueTuloTiedostoon(Object tuloOlio){
        File fileStream= new File("Tulotiedot.dat");
              ObjectOutputStream olioTiedosto=null;

              try{
                  olioTiedosto=new ObjectOutputStream(new FileOutputStream(fileStream));
                  olioTiedosto.writeObject(tuloOlio);
                  olioTiedosto.close();
              } catch (IOException | NumberFormatException error) {
                  Alert ioAlert=new Alert(Alert.AlertType.ERROR,"Nyt ei onnistunut!", ButtonType.CLOSE);
                  ioAlert.showAndWait();
              }
    }

    /**
     * Luetaan tiedostosta olion tiedot, ja asetetaan yhteenlasketut rahamaarat muutosmaara-tietueeseen
     * ongelmatilanteissa tulee pop-up ikkuna
     */
    public void olioTiedostonLuku(){
        File tiedostonNimi=new File("Tulotiedot.dat");
        if (!tiedostonNimi.exists()){
            Alert nullAlert=new Alert(Alert.AlertType.ERROR,"Tiedostoa ei ole!", ButtonType.CLOSE);
            nullAlert.showAndWait();
            System.exit(0);
        }
        else{
            try{
                FileInputStream tiedostoTulo=new FileInputStream(tiedostonNimi);
                ObjectInputStream luetaanTulo=new ObjectInputStream(tiedostoTulo);
                Object luettu =luetaanTulo.readObject();
                if(luettu instanceof Tulot) {
                    Tulot olio=(Tulot)luettu;
                     this.ansio = olio.getAnsio();
                     this.etuus = olio.getEtuus();
                    this.muuTulos = olio.getMuuTulos();
                    this.muutosMaara = ansio + etuus + muuTulos;
                }
                else{
                    Alert catcherAlert=new Alert(Alert.AlertType.ERROR,"Tiedosto ei ole oikea!", ButtonType.CLOSE);
                    catcherAlert.showAndWait();
                    return;
                    }
            } catch (IOException | ClassNotFoundException e) {
                Alert catcherAlert=new Alert(Alert.AlertType.ERROR,"Ei onnistunut", ButtonType.CLOSE);
                catcherAlert.showAndWait();
            }
        }
    }


}
