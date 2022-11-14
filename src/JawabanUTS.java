import java.util.Random;
import java.util.Scanner;

public class JawabanUTS {
    int jumProdi = 3;
    static int totalJumlahMahasiswa = 180;
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

    public static void simpanSiswa(int angkaRandom, String siswa) {
        switch (angkaRandom){
            case 1:
                CheckIndexArray (ti,siswa);
                System.out.println("Anda NIM : TI22");
                printInfoMahasiswa();
                break;
            case 2:
                CheckIndexArray(dkv,siswa);
                System.out.println("Anda Mendapatkan Vaksin Sinopharm");
                printInfoMahasiswa();
                break;
            case 3:
                CheckIndexArray(tk,siswa);
                System.out.println("Anda Mendapatkan Vaksin Moderna");
                printInfoMahasiswa();
                break;
        }
    }
    public static void inputSiswa(){
        Scanner inputData = new Scanner(System.in);
        while (true){
            System.out.print("Nama Mahasiswa =");
            String namaSiswa = inputData.nextLine();
            System.out.print("Program divisi (prodi) =");
            String namaProdi = inputData.nextLine();

            if (namaSiswa.isBlank()){
                System.out.println("Nama Mahasiswa Wajib Di Isi");
                inputSiswa();
            }else {
                Random hasilRandom = new Random();
                int JenisRandom = hasilRandom.nextInt(3)+1;
                simpanSiswa(JenisRandom,namaSiswa);
            }
        }
    }

    public static void main(String[] args){
        inputSiswa();
    }
}