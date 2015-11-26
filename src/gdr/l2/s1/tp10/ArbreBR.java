package gdr.l2.s1.tp10;

import java.util.ArrayList;

/**
 *
 * @author Grégory
 */
public abstract class ArbreBR {

    /**
     * Retourne la racine actuelle de l'arbre
     * @return Integer racine actuelle
     */
    public abstract Integer getRacine();

    /**
     * Retourne l'arbre de gauche de la racine actuelle
     * @return ArbreBR arbre à gauche de la racine actuelle
     */
    public abstract ArbreBR getAg();

    /**
     * Retourne l'arbre à droite de la racine actuelle
     * @return ArbreBR arbre à droite de la racine actuelle
     */
    public abstract ArbreBR getAd();

    /**
     * Setter racine d'un arbre
     * @param s racine à appliquer
     */
    public abstract void setRacine(Integer s);

    /**
     * Setter racine à gauche
     * @param Ag racine à gauche
     */
    public abstract void setAg(ArbreBR Ag);

    /**
     * Setter racine à droite
     * @param Ad racine à droite
     */
    public abstract void setAd(ArbreBR Ad);

    /**
     * Savoir si la racine visée est une feuille
     * @return boolean etat
     */
    public abstract boolean estFeuille();

    /**
     * Retourne l'élément le plus à gauche de l'arbre actuel
     * @return Integer élément le plus à gauche
     */
    public abstract Integer lePlusAGauche();

    /**
     * Retourne l'élément le plus à droite de l'arbre actuel
     * @return Integer élément le plus à droite
     */
    public abstract Integer lePlusADroite();

    /**
     * Affiche l'arbre dans la console
     */
    public abstract void afficheGRD();

    /**
     * Retourne true si l'élément est un arbre vide
     * @return boolean etat
     */
    public abstract boolean estVide();

    /**
     * Insère l'élément rentré en paramètre dans l'arbre
     * @param s élément à insérer
     * @return état de l'insertion
     */
    public abstract ArbreBR insertTo(Integer s);

    /**
     * Recherche un élément dans l'arbre
     * @param e élément à rechercher
     * @return état de la recherche
     */
    public abstract boolean rechercheABR(Integer e);

    /**
     * Supprime un élément dans l'arbre
     * @param e élément à supprimer
     * @return retourne le nouvel arbre
     */
    public abstract ArbreBR supprimer(Integer e);

    /**
     * Crée un ArrayList à partir d'un arbre
     * @param L arbre à copier
     */
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
        int max = list.size();
        int mid = list.size()/2;
        Integer midValue = list.get(mid);
        Integer adValue = list.get(mid-1);
        Integer agValue = list.get(mid+1);
        if(max>0){
            //insère la racine
            this.racine = new ArbreBRCons(midValue,new ArbreBRVide(),new ArbreBRVide());
        } else {
            
        }
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