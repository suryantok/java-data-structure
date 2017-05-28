package com.datastruct.app;


public class StackGenericLinkList<T> {
    Node first = null;

    private class Node {
        T item;
        Node next;

        public Node (T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(T item){
        Node node = new Node(item, first);
        first = node;
    }

    public T pop(){
        Node retval = first;
        first = retval.next;
        return retval.item;
    }

}
