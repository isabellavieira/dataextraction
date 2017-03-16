package multTask;

/**
 * Created by pianco on 8/16/16.
 */

import dao.DAOImpl;
import model.*;

import java.util.List;
import java.util.concurrent.*;

public class WorkPool {


    public static void executextraction(String project, int year) throws InterruptedException, Exception {

        DAOImpl dao = new DAOImpl();

        List<Object[]> list = dao.getListByDistinctbyProject(project, year, DataVulnFunction.class);

        BlockingQueue<Runnable> queue = new SynchronousQueue<>();



        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), 0L, TimeUnit.MILLISECONDS, queue);

        WorkerThread tasks[] = new WorkerThread[list.size()];


        for (
                int i = 0; i < list.size() / 2; i++)
//
//        {
//            tasks[i] = new WorkerThread(list.get(i));
//            executorPool.execute(tasks[i]);
//        }

            executorPool.shutdown();


    }

    public static void executextraction() throws InterruptedException, Exception {

        DAOImpl dao = new DAOImpl();




        List<TomCatDataBug> list = dao.getAll(TomCatDataBug.class);
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(list.size()));


//        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(list.size()));

        WorkerThread tasks[] = new WorkerThread[list.size()];

        for (
                int i = 0; i < list.size() ; i++)

        {
            tasks[i] = new WorkerThread(list.get(i));
            executorPool.execute(tasks[i]);
        }

        executorPool.shutdown();


    }


}