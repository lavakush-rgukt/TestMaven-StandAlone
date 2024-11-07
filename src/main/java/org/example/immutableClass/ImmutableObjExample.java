package org.example.immutableClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//1. make class not inheritable with final keyword
public final class ImmutableObjExample {


    //2. make all the variable  private so that not accessable to outside of this class
    //make all variable final so that once inistilization is done none can be re-assigned with another values.
    final private int a;
    final private List<String> list;

    final private Date dt;


    //3. no setter methods to change the values of the variables
    public int getA() {
        return a;
    }

    public List<String> getList() {

        List<String> tempList=new ArrayList<>();

        //4.while returning the non-immutable objects we need to deep copy insted of sending the refrence of the object
        for(String st:this.list){
            tempList.add(st);
        }

        return tempList;
    }

    public Date getDt() {
        Date tempDate=new Date(this.dt.getTime());
        return tempDate;
    }

    public ImmutableObjExample(int a, List<String> l, Date dt){
        this.a=a;

        List<String> tempList=new ArrayList<>();

        for(String st:l){
            tempList.add(st);
        }
        this.list=tempList;

        Date tempDate = new Date(dt.getTime());

        this.dt = tempDate;
    }




}
