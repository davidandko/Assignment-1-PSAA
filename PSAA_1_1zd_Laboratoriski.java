/*
 * Да се провери дали два стрингови внесени од тастатура се анаграми (анаграм е збор или
фраза кој може да се добие од буквите на друг збор или фраза).
Пример: banana <-> nabana; Desperation <-> A Rope End It итн.
 */
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class PSAA_1_1zd_Laboratoriski {
    static int GOLEMINA=256; // mora bukvite da bidat mali, pa zatoa vo main gi prakjam kako toLower
    static boolean isAnagram(char[] zbor1,char[] zbor2){
        int []brojac1 = new int [GOLEMINA];
        int []brojac2 = new int [GOLEMINA];
        Arrays.fill(brojac1, 0);
        Arrays.fill(brojac2,0);
        for(int i=0;i<zbor1.length && i<zbor2.length;i++){
            brojac1[zbor1[i]]++; // tuka se zgolemuva brojacot na pozicijata na vrednosta na bukvata vo ascii
            brojac2[zbor2[i]]++;
        }
        for(int i=0;i<GOLEMINA;i++)
            if(brojac1[i] != brojac2[i]) 
                return false;
            
        

        return true;
    }

    public static void main(String [] args){
        System.out.println("Vnesi go prviot zbor: ");
        Scanner input = new Scanner(System.in);
        String zbor1 = input.nextLine();
        boolean is;

        System.out.println("Vnesi go vtoriot zbor: ");
        String zbor2 = input.nextLine();
        System.out.println(zbor1.toUpperCase() + " <-> " + zbor2.toUpperCase());
        zbor1 = zbor1.replace(" ","");
        zbor2 = zbor2.replace(" ","");
        is = isAnagram(zbor1.toLowerCase().toCharArray(),zbor2.toLowerCase().toCharArray());
        
        
        if(is){
            System.out.println("Zborovite se anagram");
        }
        else{
            System.out.println("Zborovite ne se anagram");
        }
        input.close();
    }
}
