package nleite.stressmongo;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MongoExecutor implements ExecutorService {

    public void execute(Runnable arg0) {
        // TODO Auto-generated method stub

    }

    public boolean awaitTermination(long arg0, TimeUnit arg1) throws InterruptedException {
        // TODO Auto-generated method stub
        return false;
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> arg0) throws InterruptedException {
        // TODO Auto-generated method stub
        return null;
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> arg0, long arg1, TimeUnit arg2)
            throws InterruptedException {
        // TODO Auto-generated method stub
        return null;
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> arg0) throws InterruptedException, ExecutionException {
        // TODO Auto-generated method stub
        return null;
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> arg0, long arg1, TimeUnit arg2)
            throws InterruptedException, ExecutionException, TimeoutException {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean isShutdown() {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean isTerminated() {
        // TODO Auto-generated method stub
        return false;
    }

    public void shutdown() {
        // TODO Auto-generated method stub

    }

    public List<Runnable> shutdownNow() {
        // TODO Auto-generated method stub
        return null;
    }

    public <T> Future<T> submit(Callable<T> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    public Future<?> submit(Runnable arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    public <T> Future<T> submit(Runnable arg0, T arg1) {
        // TODO Auto-generated method stub
        return null;
    }

}
