import java.util.List;

public class Worker{
    boolean isStarted = false;
    boolean isWorking = false;
    List<Task> taskList;
    WorkerThread workerThread;
    public Worker(String workerName) {
        workerThread = new WorkerThread(workerName);
        workerThread.setName(workerName);
    }
    void enqueueTask(String taskName, Task task ){
        task = new Task() {
            @Override
            public void run(int taskNumber) throws InterruptedException {

            }
        };
        taskList.add(task);

    } // dodającą kolejne zadania do wykonania
    void start(){

    } // uruchamia sekwencyjne wykonywanie kolejnych task’ów w nowym wątku; jako pierwsza operacja w nowym wątku wykonuje się onWorkerStarted
    void stop(){

    } // wysyła sygnał przerwania Worker’a; wykonanie tej metody ma spowodować bezpieczne przerwanie wątku – tzn. nie wolno przerwać task’u z poziomu wątku w trakcie jego wykonywania jako ostatnia operacja w wątku wykonuje się onWorkerStoped
    void setListener(WorkerListener workerListener){
        workerListener = new WorkerListener() {
            @Override
            public void onWorkerStarted() {

            }

            @Override
            public void onWorkerStoped() {

            }

            @Override
            public void onTaskStarted(int taskNumber, String taskName) {

            }

            @Override
            public void onTaskCompleted(int taskNumber, String taskName) {

            }
        };

    } // przypisuje zestaw event’ów wykonywanych przez Worker
    boolean isStarted(){
        return isStarted;
    } // informuje o tym czy Worker jest obecnie uruchomiony
    boolean isWorking(){
        return isWorking;
    } // informuje o tym czy Worker wykonuje obecnie jakieś zadania



    class WorkerThread extends Thread {
        private Thread t;
        private String threadName;

        WorkerThread( String name) {
            threadName = name;
            System.out.println("Creating " +  threadName );
        }

        public void run() {
            System.out.println("Running " +  threadName );

            try {
                for(int i = 4; i > 0; i--) {
                    System.out.println("Thread: " + threadName + ", " + i);
                    // Let the thread sleep for a while.
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread " +  threadName + " interrupted.");
            }
            System.out.println("Thread " +  threadName + " exiting.");
        }

        public void start () {
            System.out.println("Starting " +  threadName );
            if (t == null) {
                t = new Thread (this, threadName);
                t.start ();
            }
        }
    }
}
