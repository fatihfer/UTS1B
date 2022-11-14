import java.util.Random;
import java.util.Scanner;

public class JawabanUTS {
    static int totalJumlahMahasiswa = 1050;
    public static String[] ti = new String[500];
    public static String[] dkv = new String[300];
    public static String[] tk= new String[250];

    public static void printInfoMahasiswa(){
        int totalti = 0;
        int totalSisaKuota = 0;
        for (int index = 0; index < ti.length; index++) {
            if (ti[index] != null) {
                totalti++;
            }
        }
        int totaldkv=0;
        for (int index=0;index< dkv.length;index++){
            if (dkv[index]!= null){
                totaldkv++;
            }
        }
        int totaltk=0;
        for (int index=0;index< tk.length;index++){
            if (tk[index] != null){
                totaltk++;
            }
        }
        totalSisaKuota = totalJumlahMahasiswa - totalti - totaldkv - totaltk;
        System.out.println("Total Mahasiswa TI :" + totalti + "| Total Mahasiswa DKV :" + totaldkv + "| Total Mahasiswa Teknik Komputer :" + totaltk);
        System.out.println("Jumlah Seluruh Prodi :" + totalJumlahMahasiswa + "| Total Sisa Kursi :" + totalSisaKuota);
        System.out.println();
    }

    public static void CheckIndexArray(String[] myArray,String siswa){
        int indexNow=0;
        for (int index=0; index<myArray.length; index++){
            if (myArray[index] !=null){
                indexNow = index + 1;
            }
        }
        if (indexNow < myArray.length){
            myArray[indexNow] = siswa;
        }
    }

    public static void simpanSiswa(String siswa) {
        long mathRandom =  (long) Math.floor(Math.random() * 99_000_000L) + 10_000_000L;
        if (siswa== null){
            System.out.println("Masukkan Prodi yang dipilih");
        }else if(siswa.equals("TI")){
            CheckIndexArray(ti,siswa);
            System.out.println("NIM anda : TI22"+mathRandom);
            printInfoMahasiswa();
        } else if (siswa.equals("DKV")) {
            CheckIndexArray(dkv,siswa);
            System.out.println("NIM anda : DK22"+mathRandom);
            printInfoMahasiswa();
        } else if (siswa.equals("TK")) {
            CheckIndexArray(tk,siswa);
            System.out.println("NIM Anda : TK22"+mathRandom);
            printInfoMahasiswa();
        }else{
            System.out.println("Masukkan Prodi :");
            System.out.println("1. TI (Teknik Informatika)");
            System.out.println("2. DKV (Desain Komunikasi Visual)");
            System.out.println("3. TK (Teknik Komputer)");
        }
    }
    public static void inputSiswa(){
        Scanner inputData = new Scanner(System.in);
        while (true){
            System.out.print("Nama Mahasiswa =");
            String namaSiswa = inputData.nextLine();
            System.out.print("Program divisi (prodi) =");
            String namaProdi = inputData.nextLine();

            if (namaProdi.isBlank()){
                System.out.println("Prodi Wajib Di Isi");
                inputSiswa();
            }else {
                simpanSiswa(namaProdi);
            }
        }
    }

    public static void main(String[] args){
        inputSiswa();
    }
}