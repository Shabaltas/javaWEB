package task04ThreadManagement;

import java.util.concurrent.TimeUnit;

public class JoinThread extends Thread {
    public JoinThread(String name){
        super(name);
    }

    public void run(){
        String nameT = getName();
        long timeout = 0;
        System.out.println(nameT + " started");
        try{
            switch(nameT){
                case "First":
                    timeout = 200;
                    break;
                case "Second":
                    timeout = 1_000;
            }
            TimeUnit.MILLISECONDS.sleep(timeout);
            System.out.println(nameT + " stopped");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
