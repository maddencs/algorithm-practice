import java.util.Iterator;


public class LinkedList<Item> implements Iterator{
    Node head, current;
    int size = 0;

    public boolean hasNext(){ return this.head != null;}
    public Item next(){
        if(this.current == null){
            this.current = this.head;
        } else {
            this.current = this.current.next;
        }
        return this.current.value;
    }
    LinkedList(int size){this.size = size;}

    private class Node{
        Item value;
        Node next;

        Node(Item value){ this.value = value;}
    }

    public void push(Item item){
        Node newHead = new Node(item);
        newHead.next = this.head;
        this.head = newHead;
    }

    public Item pop(){
        size--;
        Node oldHead = this.head;
        if(this.head.next != null){
            this.head = this.head.next;
        } else{
            this.head = null;
        }
        return oldHead.value;
    }
    public void remove(){};

    public static void main(String[] args){
        int[] testInts = {1, 2, 3, 4};
        LinkedList<Integer> ll = new LinkedList<>(testInts.length);
        for(int i: testInts){
            ll.push(i);
        }
        System.out.println(ll.pop());
        System.out.println(ll.pop());
        while(ll.hasNext()){
            System.out.println(ll.pop());
        }
    }
}
