public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker("First worker");
        worker.workerThread.start();
    }
}
