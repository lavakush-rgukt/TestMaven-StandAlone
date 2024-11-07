package org.example;

import java.util.Comparator;
import java.util.Objects;

public class Employee implements Comparable<Employee>,Comparator<Employee>{
    public Employee(String name, int empid, int sal,String dept) {
        this.name = name;
        this.empid = empid;
        this.sal = sal;
        this.dept=dept;
    }

    //Private vaiable
    private String name;
    private int empid;
    private int sal;

    private String dept;

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }




    @Override
    public boolean equals(Object o){
        if(o==null || this.getClass()!=o.getClass()){
            return false;
        }
        if(o==this){
            return true;
        }
        Employee e= (Employee)o;
        return this.getEmpid()==e.getEmpid();
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, empid, sal);
    }


    @Override
    public int compareTo(Employee o) {
        return 0;
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        return 0;
    }
}
