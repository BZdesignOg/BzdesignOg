package com.bs.fan.myjob.ui;


import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public abstract class SwingWorkerProxy<T> {
    private SwingWorker<List<T>,Object> worker=null;
    public SwingWorkerProxy(){
        worker=new SwingWorker<List<T>, Object>() {
            @Override
            protected void process(List<Object> chunks) {
                super.process(chunks);
                System.out.print("_-_-_-_-");
            }

            @Override
            protected List<T> doInBackground() throws Exception {
                return triggerData();
            }
            @Override
            protected void done(){
                try {
                    List<T> data=get();
                    updateAfterDone(data);
                } catch (InterruptedException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };

    }
    abstract  protected List<T> triggerData() throws  NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    abstract  protected void updateAfterDone(List<T> data) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    public void work(){
//        if(!isWorking()){
//            worker.execute();
//        }
        worker.execute();
    }

    public boolean isWorking()
    {
        if(worker==null)
            return false;
        if(worker.isDone()||worker.isCancelled()){
            return false;
        }
        return true;
    }
}
