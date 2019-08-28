public class main {
    public static void main(String[] args) {

        ListWorker worker = new ListWorker();
        worker.calistir();

    }

}
// 2 ayrı thread a 2 ayrı Lock vererek aynı anda çalıştırdık.
// Böylece işlem süresi 2 Thread kullanara yarıya düşmüş oldu

/*
* We did use diffirent 2 lock key for two Threads
* Thus process time was reduced by half by using 2 thread
* */