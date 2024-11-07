package org.example;

public class PassByValueOrRefrence {
    public static void main(String[] args) {
        //pass by value
        int a=2;
        changePassByValue(a);
        System.out.println(a);//a will be 2 only


        //pass by ref
        Artist ar = new Artist();
        ar.setName("ab");
        ar.setId(1);
        cahngePassByRef(ar);
        System.out.println(ar.getName());//name will be updated to bbc



    }

    private static void cahngePassByRef(Artist ar) {
        ar.setName("bbc");
    }

    private static void changePassByValue(int a) {
        a=10;
    }


}


class Artist{
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
