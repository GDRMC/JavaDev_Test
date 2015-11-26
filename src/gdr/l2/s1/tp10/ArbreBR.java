package gdr.l2.s1.tp10;

import java.util.ArrayList;

public abstract class ArbreBR {
    public abstract Integer getRacine();
    public abstract ArbreBR getAg();
    public abstract ArbreBR getAd();
    public abstract void setRacine(Integer s);
    public abstract void setAg(ArbreBR Ag);
    public abstract void setAd(ArbreBR Ad);
    public abstract boolean estFeuille();
    public abstract Integer lePlusAGauche();
    public abstract Integer lePlusADroite();
    public abstract void afficheGRD();
    public abstract boolean estVide();
    public abstract ArbreBR insertTo(Integer s);
    public abstract boolean rechercheABR(Integer e);
    public abstract ArbreBR supprimer(Integer e);
    public abstract void arbreBRenTab(ArrayList L);
}


class ArbreBRVide extends ArbreBR { // sentinelle de structure

    ArbreBRVide() {
    }

    public Integer getRacine() {
        return null;
    }

    public ArbreBR getAg() {
        return this;
    }

    public ArbreBR getAd() {
        return this;
    }

    public void setRacine(Integer s) {
    }

    public void setAg(ArbreBR Ag) {
    }

    public void setAd(ArbreBR Ad) {
    }
    
    public boolean estFeuille() {
        return false;
    }
    
    public Integer lePlusAGauche(){
        return null;
    }
    
    public Integer lePlusADroite(){
        return null;
    }
    
    public void afficheGRD(){
        
    }

    public boolean estVide() {
        return true;
    }

    public ArbreBR insertTo(Integer s) {
        return new ArbreBRCons(s);
    }

    public boolean rechercheABR(Integer e) {
        return false;
    }

    public ArbreBR supprimer(Integer e) {
        //TODO: SUPPRIMER
        return this;
    }
    
    public void arbreBRenTab(ArrayList L){
        
    }
}

class ArbreBRCons extends ArbreBR {

    private Integer racine;
    private ArbreBR Ag;
    private ArbreBR Ad;

    public boolean estVide() {
        return false;
    }

    ArbreBRCons(Integer val, ArbreBR Ag, ArbreBR Ad) { //constructeur
        this.racine = val;
        this.Ag = Ag;
        this.Ad = Ad;
    }

    ArbreBRCons(Integer val) { // constructeur de feuille
        this.racine = val;
        this.Ag = new ArbreBRVide();
        this.Ad = new ArbreBRVide();
    }
    
    ArbreBRCons(ArrayList<Integer> list){
        /*
        int max = list.size();
        int mid = list.size()/2;
        Integer midValue = list.get(mid).intValue();
        Integer adValue = list.get(mid-1).intValue();
        Integer agValue = list.get(mid+1).intValue();
        if(max>0){
            //insère la racine
            this.racine = new ArbreBRCons(midValue,new ArbreBRVide(),new ArbreBRVide());
        } else {
            
        }
        */
    }

    public Integer getRacine() {
        return this.racine;
    }

    public ArbreBR getAg() {
        return this.Ag;
    }

    public ArbreBR getAd() {
        return this.Ad;
    }

    public void setRacine(Integer s) {
        this.racine = s;
    }

    public void setAg(ArbreBR Ag) {
        this.Ag = Ag;
    }

    public void setAd(ArbreBR Ad) {
        this.Ad = Ad;
    }
    
     public boolean estFeuille(){
        return this.getAg().estVide() && this.getAd().estVide();
    }
    
    public Integer lePlusAGauche(){
        Integer i;
        if(this.getAg().estVide()){
             i=this.getRacine();
        } else {
            i=this.getAg().lePlusAGauche();
        }
        return i;
    }
    
    public Integer lePlusADroite(){
        if(this.getAd().estVide()){
            return this.getRacine();
        } else {
            return this.getAd().lePlusADroite();
        }
    }
    
    public void afficheGRD(){
        this.getAg().afficheGRD();
        System.out.print(this.getRacine()+" ");
        this.getAd().afficheGRD();
    }

    public ArbreBR insertTo(Integer val) {
        if (!val.equals(this.getRacine())) {
            if (val.compareTo(this.getRacine()) < 0) {
                return new ArbreBRCons(this.getRacine(), this.getAg().insertTo(val), this.getAd());
            } else {
                return new ArbreBRCons(this.getRacine(), this.getAg(), this.getAd().insertTo(val));
            }
        }
        return this;
    }

    public boolean rechercheABR(Integer e) {
        if (!e.equals(this.getRacine())) {
            if (e.compareTo(this.getRacine()) < 0) {
                return this.getAg().rechercheABR(e);
            } else {
                return this.getAd().rechercheABR(e);
            }
        } else {
            return true;
        }
    }

    public ArbreBR supprimer(Integer e) {
        if(this.getRacine().equals(e)){
            if(this.getAd().estVide()){
                return this.getAg();
            } else {
                Integer val = this.getAd().lePlusAGauche();
                //System.out.println("Remplacement de la valeur par "+val.toString());
                return new ArbreBRCons(val,this.getAg(),this.getAd().supprimer(val));
            }
        } else {
            if(e.compareTo(this.getRacine())<0){
                return new ArbreBRCons(this.getRacine(),this.getAg().supprimer(e),this.getAd());
            } else {
                return new ArbreBRCons(this.getRacine(),this.getAg(),this.getAd().supprimer(e));
            }
        }
    }
    
    public void arbreBRenTab(ArrayList L) {
        this.getAg().arbreBRenTab(L);
        L.add(this.getRacine());
        this.getAd().arbreBRenTab(L);
    }
}