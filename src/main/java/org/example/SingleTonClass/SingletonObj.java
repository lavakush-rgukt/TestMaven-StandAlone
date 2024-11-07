package org.example.SingleTonClass;

import java.io.Serializable;

public class SingletonObj implements Serializable,Cloneable {

    //1. create class level object creation with help of static key word
    private static SingletonObj singletonObjInstance;

    //2. make constructor private so that noonce can access
    private void SingletonObj()  {

        //refelction fix
        if(singletonObjInstance==null){
            throw new RuntimeException("Reflecation is not supported used getInstance method to get the singleton object");
        }
    }

    public static SingletonObj getInstance(){
        if(singletonObjInstance==null) {
            singletonObjInstance = new SingletonObj();
        }

        return singletonObjInstance;
    }

    public SingletonObj readResolve(){
        return this.singletonObjInstance;
    }



}
