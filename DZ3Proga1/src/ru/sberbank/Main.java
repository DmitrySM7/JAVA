package ru.sberbank;

public class Main {

    public static void main(String[] args) {
        ReferenceBook tom = new ReferenceBook();
        System.out.println(tom.size());
        tom.insert(1, "odin");
        tom.insert(2, "dva");
        tom.insert(3, "tri");
        tom.insert(4, "chetire");
        System.out.println(tom.get(2));
        System.out.println(tom.size());
        tom.delete(3);
        System.out.println(tom.get(2));
        System.out.println(tom.size());
        System.out.println(tom.get(3));
        System.out.println(tom.contains(4));
    }
}
