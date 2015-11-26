package gdr.l2.s1.tp10;

import java.util.ArrayList;

public class Test {

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
        tree1.afficheGRD();
        System.out.println();
        ArbreBR tree2 = tree1.supprimer(3);
        tree2.afficheGRD();
        System.out.println();
        
        ArrayList<Integer> list = new ArrayList();
        tree1.arbreBRenTab(list);
        afficherArrayList(list);
        
        ArbreBRCons tree3 = new ArbreBRCons(list);
        tree3.afficheGRD();
    }
    
    public static void afficherArrayList(ArrayList<Integer> list){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).toString()+" ");
        }
        System.out.println();
    }
}
