package task06CommonResource;

public class ThreadsApp {

    public static void main(String[] args){
        CommonResource commonResource = new CommonResource();
        for (int i = 0; i < 6; i++){
            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Thread " + i);
            t.start();
           /* try{
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}
