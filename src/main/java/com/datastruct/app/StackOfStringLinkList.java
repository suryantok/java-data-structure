package com.datastruct.app;


public class StackOfStringLinkList {
    Node first = null;
    private class Node {
        String item;
        Node next;

        public Node (String item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item){
        Node node = new Node(item, first);
        first = node;
    }

    public String pop(){
        Node retval = first;
        first = retval.next;
        return retval.item;
    }

}
