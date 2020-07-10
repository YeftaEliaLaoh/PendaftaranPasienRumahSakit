/*package com.example.pendaftaranpasienrumahsakit;

import android.util.Log;

import androidx.lifecycle.LiveData;


import com.example.pendaftaranpasienrumahsakit.dao.PasienDao;
import com.example.pendaftaranpasienrumahsakit.entity.Pasien;

import java.util.List;*/

/**
 * This class responsible for handling data operations. This is the mediator between different
 * data sources (persistent model, web service, cache, etc.)
 */
/*public class PasienRepository
{
    private static final String LOG_TAG = PasienRepository.class.getSimpleName();

    private PasienDao pasienDao;
    private UserNetworkDataSource mNetworkDataSource;

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static PasienRepository sInstance;

    public PasienRepository( PasienDao pasienDao, UserNetworkDataSource networkDataSource, AppExecutors
            executors )
    {
        this.pasienDao = pasienDao;
        this.mNetworkDataSource = networkDataSource;

        // As long as the repository exists, observe the network LiveData.
        // If that LiveData changes, update the database.
        mNetworkDataSource.getUserList().observeForever(users -> {
            executors.diskIO().execute(() -> {

                Log.d(LOG_TAG, "user table is updating");
                this.pasienDao.updateAll(users);
            });
        });
    }

    public static PasienRepository getInstance( UserDao userDao, UserNetworkDataSource
            networkDataSource, AppExecutors executors )
    {
        Log.d(LOG_TAG, "Getting the repository");
        if( sInstance == null )
        {
            synchronized ( LOCK )
            {
                sInstance = new PasienRepository(userDao, networkDataSource, executors);
                Log.d(LOG_TAG, "Made new repository");
            }
        }
        return sInstance;
    }

    public List<Pasien> getUserList()
    {
        return pasienDao.getAll();
    }

    public void postServiceRequest( ServiceRequest serviceRequest )
    {
        mNetworkDataSource.fetchData(serviceRequest);
    }

}*/
