import java.util.ArrayList;
import java.util.Random;

public class ListWorker {
    Random random = new Random();
    ArrayList<Integer> arrayList1 = new ArrayList<>();
    ArrayList<Integer> arrayList2 = new ArrayList<>();

    Object lock1 = new Object();
    Object lock2 = new Object();

    public void list1() {
        synchronized (lock1) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            arrayList1.add(random.nextInt(100));

        }
    }
    public void list2() {
        synchronized (lock2) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            arrayList2.add(random.nextInt(100));
        }
    }

    public void listEkle(){
        for (int i = 0 ; i<1000 ; i++){
            list1();
            list2();
        }
    }

    public void calistir(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                listEkle();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                listEkle();
            }
        });
        long baslangic =System.currentTimeMillis();
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long bitis = System.currentTimeMillis();
        System.out.println("List size 1 = " + arrayList1.size() + " List size 2 = " + arrayList2.size());
        System.out.println("Süre = " + (bitis-baslangic));

    }




}
