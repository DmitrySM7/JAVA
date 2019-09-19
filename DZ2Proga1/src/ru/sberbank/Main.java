package ru.sberbank;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        FileReader fr= new FileReader(s);
        Scanner scan1 = new Scanner(fr);

        scan1.nextLine();
        String s2 = scan1.nextLine();
        String s3 = scan1.nextLine();
        fr.close();

        String[] string2 = s2.split("=");
        String type = string2[1];

        String[] string3 = s3.split("=");
        int pr = Integer.parseInt(string3[1]);

        switch (type) {
            case ("FX_SPOT"):
                FX_SPOT fxspot = new FX_SPOT(pr);
                fxspot.start();
                break;
            case ("BOND"):
                BOND bond = new BOND(pr);
                bond.start();
                break;
            case ("COMMODITY_SPOT"):
                COMMODITY_SPOT commodity_spot = new COMMODITY_SPOT(pr);
                commodity_spot.start();
                break;
            case ("IR_SWAP"):
                IR_SWAP ir_swap = new IR_SWAP(pr);
                ir_swap.start();
                break;
        }
    }
}
