package task02RunnablePerson;

public class RunnablePerson extends Person implements Runnable {

    public RunnablePerson(String name){
        super(name);
    }

    public void run(){
        Thread t = Thread.currentThread();
        t.setName(getName());
        System.out.println(t);
        for (int i = 0; i < 10; i++){
            System.out.println(getName() + ": Hello World");
        }
    }

    public static void main(String[] args){
        System.out.println("Main started");
        Thread t = Thread.currentThread();
        System.out.println(t);
        RunnablePerson p1 = new RunnablePerson("Alice");
        Thread t1 =  new Thread(p1);
        t1.start();
        RunnablePerson p2 = new RunnablePerson("Bob");
        Thread t2 = new Thread(p2);
        t2.start();
        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main stopped");
    }
}
