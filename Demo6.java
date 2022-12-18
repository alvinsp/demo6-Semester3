import java.io.*;
import java.util.*;

/**
 * Author: Alvin Suwarno Putra
 * DEMO - 6 PROGRAM LANJUT :)
 */
public class Demo6 {

    // Array List untuk memasukkan array dari data
    static ArrayList<String> inString = new ArrayList<String>();
    static ArrayList<Integer> inInt = new ArrayList<Integer>();
    static int option, index, optionPilih;
    // File digunakan untuk penyediaan file nantinya
    static File fileInt = new File("integerData.txt");
    static File fileString = new File("StringData.txt");

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            do {
                menu();
                option = input.nextInt();
                switch (option) {
                    case 1:
                        try {
                            // jika file tidak ada maka akan dibuat 
                            if (!fileInt.exists()) {
                                fileInt.createNewFile();
                            }else if(!fileString.exists()){
                                fileString.createNewFile();
                            }

                            // masukkan panjang array yang ingin dimasukkan
                            System.out.print("Masukkan Size: ");
                            int size = input.nextInt();
                            for (int i = 0; i < size; i++) {
                                System.out.print("Masukkan Data: ");
                                String data = input.next();
                                // Function isNum digunakan untuk pengecekan apakan string berupa integer atau string
                                if (isNum(data)) {
                                    // add untuk menambahkan dalam index dan replace all digunakan untuk menghilangkan sesuai regex
                                    inInt.add(Integer.parseInt(data.replaceAll("([a-z])", "")));
                                    // Write int digunakan untuk menuliskan hasil kedalam file
                                    writeInt(fileInt, inInt);
                                } else {
                                    // add untuk menambahkan dalam index dan replace all digunakan untuk menghilangkan sesuai regex
                                    inString.add(data.replaceAll("([0-9])", ""));
                                    // Write int digunakan untuk menuliskan hasil kedalam file
                                    writeString(fileString, inString);
                                }
                                System.out.println("int : " + inInt + "\n str : " + inString);
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }

                        break;

                    case 2:
                        pilih();
                        optionPilih = input.nextInt();
                        switch (optionPilih) {
                            case 1:
                                System.out.println("Pilih index yang ingin dihapus: ");
                                index = input.nextInt();
                                // get disini akan mengambil index dari inputan int
                                inInt.get(index);
                                inInt.remove(index);
                                //  menghapus sesuai index yang di pilih
                                System.out.println(inInt);
                                // lalu menuliskan kembali untuk update an array
                                writeInt(fileInt, inInt);
                                break;
                                case 2:
                                System.out.println("Pilih index yang ingin dihapus: ");
                                index = input.nextInt();
                                // get disini akan mengambil index dari inputan int
                                inString.get(index);
                                //  menghapus sesuai index yang di pilih
                                inString.remove(index);
                                System.out.println(inString);
                                // lalu menuliskan kembali untuk update an array
                                writeString(fileString, inString);
                                break;
                        }
                        while (optionPilih != 2)
                            ;
                    case 3:
                        System.exit(0);
                }
            } while (option != 3);
        } catch (Exception j) {
            j.getStackTrace();
        }

    }

    public static void menu() {
        System.out.println("MENU");
        System.out.println("1: Add Data");
        System.out.println("2: Delete Data");
        System.out.println("3: Exit program");
        System.out.print("Enter your selection : ");
    }

    public static void pilih() {
        System.out.println("PILIH DATA YANG INGIN DIHAPUS: ");
        System.out.println("1: Integer Array");
        System.out.println("2: String Array");
    }

    // Function untuk mengecek apakah data adalah integer or string
    static boolean isNum(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) == false)
                return false;
        }
        return true;
    }

    static void writeInt(File filename, ArrayList<Integer> x) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        outputWriter.write(x + "\n");
        outputWriter.flush();
        outputWriter.close();
    }

    static void writeString(File filename, ArrayList<String> x) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        outputWriter.write(x + "\n");
        outputWriter.flush();
        outputWriter.close();
    }
}