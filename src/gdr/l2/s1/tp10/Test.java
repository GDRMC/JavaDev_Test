package gdr.l2.s1.tp10;

import java.util.ArrayList;

/**
 *
 * @author Grégory
 */
public class Test {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ArbreBRCons tree1 = new ArbreBRCons(
                8,
                new ArbreBRCons(3,
                        new ArbreBRCons(2), 
                        new ArbreBRCons(5)),
                new ArbreBRCons(10,
                        new ArbreBRCons(9), 
                        new ArbreBRCons(14))
                );
        afficherArbreBR("Arbre 1 ",tree1);
        ArbreBR tree2 = tree1.supprimer(3);
        afficherArbreBR("Arbre 2 ",tree2);
        
        //transforme l'arbre visé en arraylist trié
        ArrayList<Integer> list = new ArrayList();
        tree1.arbreBRenTab(list);
        afficherArrayList("Arbre R ",list);
        
        Integer toI = new Integer(2);
        ArbreBR treeT = tree1.insertTo(toI);
        afficherArbreBR("Arbre T ",treeT);
        
        //transforme l'arraylist trié en arbre binaire de recherche
        //ArbreBRCons tree3 = new ArbreBRCons(list);
        /*
        ArbreBR tree4 = tree1.insertTo(15);
        afficherArbreBR("Arbre 4 ",tree4);
        ArrayList<Integer> list2 = new ArrayList();
        tree4.arbreBRenTab(list2);
        ArbreBRCons treeR = new ArbreBRCons(list2);
        afficherArbreBR("Arbre R ",treeR);
        */
    }
    
    /**
     * Affiche l'arraylist entré en paramètre dans la console
     * @param list ArrayList à afficher
     */
    public static void afficherArrayList(String str, ArrayList<Integer> list){
        System.out.print(str+" ||  ");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).toString()+" ");
        }
        System.out.println();
    }
    
    /**
     * Affiche l'arbre entré en paramètre dans la console
     * @param tree Arbre à afficher
     */
    public static void afficherArbreBR(String str, ArbreBR tree){
        System.out.print(str+" ||  ");
        tree.afficheGRD();
        System.out.println();
    }
}
