package nleite.stressmongo;

import java.text.MessageFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class StressThreadPoolExecuter extends ThreadPoolExecutor {

    public StressThreadPoolExecuter(int corePoolSize, int maxPoolSize, long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> queue) {
        super(corePoolSize, maxPoolSize, keepAliveTime, unit, queue);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable th) {
        // TODO Auto-generated method stub
        super.afterExecute(r, th);
        Date now = new Date();
        System.out.println(MessageFormat.format("Starting to execute:{0} at {1}", r.toString(), now));
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        // TODO Auto-generated method stub
        super.beforeExecute(t, r);
        Date now = new Date();
        System.out.println(MessageFormat.format("Finished to execute:{0} at {1}", r.toString(), now));
    }

}
