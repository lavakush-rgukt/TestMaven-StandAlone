package org.example.customStack;

public class customStack {
    public static void main(String[] args) {

        stack s = new stack(5);

        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());


    }
}

class stack{

    int capacity;
    int[] arr;
    int top;
    public stack(int capacity){

        this.capacity=capacity;
        this.arr = new int[capacity];
        this.top = -1;
    }

    public void push(int x){
        if(top ==capacity-1){
            throw new RuntimeException("Stack is full");
        }
        arr[++top]=x;
    }

    public int peek(){
        if(top==-1){
            throw new RuntimeException("stack is empty");
        }
        return arr[top];
    }

    public int pop(){
        if(top==-1){
            throw new RuntimeException("stack is empty");
        }

        return arr[top--];
    }

    public boolean isEmpty(){
        return capacity==-1;
    }

}