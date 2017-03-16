package multTask;

import model.TomCatDataBug;

import java.io.IOException;

/**
 * Created by pianco on 8/16/16.
 */
public class WorkerThread implements Runnable {

    private TomCatDataBug ObjectList;

    public WorkerThread(TomCatDataBug object) {
        this.ObjectList = object;
    }

    @Override
    public void run() {


        try {
			SetLinesApp.getLinesChangedMultiThread(ObjectList);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
            e.printStackTrace();
        }

    }


}