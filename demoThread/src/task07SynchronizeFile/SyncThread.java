package task07SynchronizeFile;

public class SyncThread extends Thread {
    private Resource res;
    public SyncThread(String name, Resource rs) {
        super(name);
        this.res = rs;
    }
    public void run(){
        for (int i = 0; i < 5; i++){
            res.writing(getName(), i);
        }
    }
}
