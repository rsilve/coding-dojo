package net.silve.dojo;


public class App {

    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            System.out.printf("%3d %10s\n", i, toRoman(i));
        }
    }


    public static String toRoman(Integer value) {
        return new String(new char[value]).replace('\0', 'I')
                .replaceAll("IIIII", "V")
                .replaceAll("IIII", "IV")
                .replaceAll("VV", "X")
                .replaceAll("VIV", "IX")
                .replaceAll("XXXXX", "L")
                .replaceAll("XXXX", "XL")
                .replaceAll("LL", "C")
                .replaceAll("LXL", "XC")
                .replaceAll("CCCCC", "D")
                .replaceAll("CCCC", "CD")
                .replaceAll("DD", "M")
                .replaceAll("DCD", "CM");
    }

}
