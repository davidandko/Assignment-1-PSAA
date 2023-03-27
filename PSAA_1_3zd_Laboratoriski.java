/*
Да се напише функција која како аргумент добива единечно поврзана листа. Функцијата
треба да ги исфрли сите јазли од единечно поврзаната листа кои претставуваат дупликати
на еден јазол (т.е. имаат иста вредност). Дополнително функцијата треба да чува
информација за тоа колку пати се повторувал одреден јазол.
Да се напише главна програма во која ќе се тестира работата на функцијата.
*/


import java.util.Scanner;
    class Node<E>
    {
        protected E data;
        protected Node<E> next;

        public Node(){
            this.data = null;
            this.next = null;
        }
        public Node(E info,Node<E> nextF){
            this.data = info;
            this.next = nextF;
        }
        public void displayData(){
            System.out.print(this.data + " -> ");
        }
    }
    class SLL<E>
    {
        protected Node<E> head;
    
        public boolean isEmpty(){
            return (head==null);
        }
        public void insertFirst(E dataF){
            Node<E> nov = new Node<E>();
            if(isEmpty()){
                nov.data = dataF;
                head = nov;
            }else{
                nov.data = dataF;
            nov.next = head;
            head = nov;
            }
        }
        public Node<E> deleteAndReturnFirst(){
            Node<E> izbrisaniot = head;
            head = head.next;
            return izbrisaniot;
        }
        public void deleteAfter(Node<E> after){
            Node <E> dvizi = head;
            while(dvizi.next != null && dvizi.data != after.data){
                dvizi = dvizi.next;
            }
            if(dvizi.next != null){
                dvizi.next = dvizi.next.next;
            }
        }
        public void deleteThis(Node<E> brisi){
            if(isEmpty()){
                return;
            }
            else{
                Node<E> dvizi = head;
                while(dvizi.next != brisi){
                    dvizi = dvizi.next;
                }
                dvizi.next = dvizi.next.next;
            }
        }
        public void insertLast(E info){
            if(isEmpty()){
                insertFirst(info);
                }else{
                Node <E>dvizi = head;
                while(dvizi.next != null){
                    dvizi = dvizi.next;
                }
                Node<E> nov = new Node<E>();
                nov.data = info;
                dvizi.next = nov;
                nov.next = null;
            }
        }
        public void print(){
            Node<E> dvizi = head;
            while(dvizi.next != null){
                dvizi.displayData();
                dvizi = dvizi.next;
            }
            System.out.print(dvizi.data);
            System.out.println();
        }
    } 




public class PSAA_1_3zd_Laboratoriski<E>{
    public static void isfrli(SLL<Integer> lista){
        Node<Integer> fix = lista.head;
        Node<Integer> garbage = new Node();
        while(fix != null){
            Node<Integer> dvizi = fix.next;
            int brojac = 0;
            while(dvizi!= null){
                if(dvizi.data == fix.data){
                    garbage = dvizi;
                    dvizi = dvizi.next;
                    brojac++;
                    lista.deleteThis(garbage);
                }else{
                dvizi = dvizi.next;
                }
            }
            System.out.println("Vrednosta "+ fix.data + " se povtoruvase "+ (brojac+1) + " pati");
            fix=fix.next;
        }
        
    }
    public static void main(String [] args){
        SLL<Integer> lista = new SLL<Integer>();
        Scanner input = new Scanner(System.in);
        System.out.println("Kolku elementi sakate da vnesete?");
        int n = input.nextInt();
        for(int i=0;i<n;i++){
            int broj = input.nextInt();
            lista.insertLast(broj);
        }
        String dali;
        dali = lista.isEmpty() ? "Listata e prazna ":"Listata ima elementi";
        System.out.println(dali);
        lista.print();
        System.out.println();
        isfrli(lista);
        lista.print();
        input.close();
    }
    
}
    


