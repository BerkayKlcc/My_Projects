package Utility;

public class MyFunc {

    public static void wait(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void LoadingReport(){
        System.out.println("Muzik Yukleniyor");
        String mzk="";
        for (int i=0; i<=10; i++){
            MyFunc.wait(1);
            System.out.println("\r"+"\033[42m"+mzk+"\033[0m"+"%"+(i*10));
            mzk=mzk.concat("     ");
        }
        System.out.println();
    }
}
