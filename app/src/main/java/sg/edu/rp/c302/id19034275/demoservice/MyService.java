package sg.edu.rp.c302.id19034275.demoservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    boolean started;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    @Override
    public void onCreate() {
        Log.d("My service", "Service Created");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (started == false){
            started = true;
            Log.d("My Service", "Service started ");
        }else{
            Log.d("My Service", "Service still running ");
        }
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy() {
        Log.d("My Service", "Service exited");
        super.onDestroy();
    }
    private DownloadBinder mBinder = new DownloadBinder();

    class DownloadBinder extends Binder {
        public void startDownload() {
            Log.d("MyService", "startDownload executed");
        }
        public int getProgress() {
            Log.d("MyService", "getProgress executed");
            return 0;
        }
    }

}