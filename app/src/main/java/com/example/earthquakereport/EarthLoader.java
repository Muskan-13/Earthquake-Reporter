package com.example.earthquakereport;



import android.content.Context;
import android.content.AsyncTaskLoader;
import java.util.List;

public class EarthLoader extends AsyncTaskLoader<List<Earthquake>> {

    private static final String LOG_TAG = EarthLoader.class.getName();
    private String mUrl;
    public EarthLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}


