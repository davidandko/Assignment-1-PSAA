/*
 * Да се напише програма која ќе симулира едноставно случајно влечење на карти. На
располагање имате шпил од 52 карти, поделени во две групи: знаци (детелина, баклава,
срце, пик) и ранг (2, 3, 4, 5, 6, 7, 8, 9, 10, џандар, дама, крал, ас).
Најпрво треба да овозможите случаен избор на еден знак и една карта. Потоа, треба да го
формирате шпилот од 52 карти. На крај треба да го измешате погоре креираниот шпил
карти.
 */
import java.util.Random;
import java.util.Scanner;

public class PSAA_1_2zd_Laboratoriski {
    
    
    static void pechati(String [][] spilceto){
        for(int i=0;i<(spilceto.length);i++){ 
            for(int j=0;j<spilceto[i].length;j++){ 
                System.out.print(spilceto[i][j]+ " ");
            }
            System.out.println();
        }
    }
       
    
	public static void main(String[] args) {
	 
		Scanner input = new Scanner(System.in);
		String[] karti = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] znak = {"Detelina", "Baklava", "Srce", "Pik"};
		
		int randomKarta = (int) (Math.random() * 13); 
		int randomZnak= (int) (Math.random() * 4); 
		String odbranZnak = znak[randomZnak]; 
		String odbranBroj = karti[randomKarta] ; 
        String[][] spil = new String[karti.length][znak.length];
		
            for(int i=0;i<(karti.length);i++){ 
                for(int j=0;j<znak.length;j++){
                    spil[i][j] = "|" +znak[j] + " " + karti[i] + "|";
                }
            }
            pechati(spil);


            System.out.println("Izmesaniot spil: ");
            for(int i=0;i<karti.length;i++){ 
                int kar = (int) (Math.random()*13);
                for(int j=0;j<znak.length;j++){
                    int znk = (int) (Math.random()*4);
                    String temp = spil[i][j];
                    spil[i][j] = spil[kar][znk];
                    spil[kar][znk]=temp;
                }
            }
           pechati(spil);
		System.out.println("Ja izbravte kartata: " + odbranZnak + " " + odbranBroj);
        input.close();
            
	
	}

	
	
}