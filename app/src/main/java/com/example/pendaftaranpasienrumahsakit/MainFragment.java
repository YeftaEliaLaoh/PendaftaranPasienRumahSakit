package com.example.pendaftaranpasienrumahsakit;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.evrencoskun.tableview.TableView;
import com.example.pendaftaranpasienrumahsakit.adapter.MyTableAdapter;
import com.example.pendaftaranpasienrumahsakit.dao.PasienDao;
import com.example.pendaftaranpasienrumahsakit.database.AppDatabase;
import com.example.pendaftaranpasienrumahsakit.utility.MyTableViewListener;


public class MainFragment extends Fragment
{

    private static final String LOG_TAG = MainFragment.class.getSimpleName();

    private TableView mTableView;
    private MyTableAdapter mTableAdapter;
    private ProgressBar mProgressBar;
    AppDatabase appDatabase;

    public MainFragment( Context context )
    {
        appDatabase = Room.databaseBuilder(context,
                AppDatabase.class, "database-name").allowMainThreadQueries().build();
    }

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState )
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mProgressBar = view.findViewById(R.id.progressBar);
        mTableView = view.findViewById(R.id.my_TableView);

        initializeTableView(mTableView);

        PasienDao pasienDao = appDatabase.pasienDao();

        mTableAdapter.setPasienList(pasienDao.getAll());
        hideProgressBar();

        return view;
    }


    private void initializeTableView( TableView tableView )
    {

        // Create TableView Adapter
        mTableAdapter = new MyTableAdapter(getContext());
        tableView.setAdapter(mTableAdapter);

        // Create listener
        tableView.setTableViewListener(new MyTableViewListener(tableView));
    }


    public void showProgressBar()
    {
        mProgressBar.setVisibility(View.VISIBLE);
        mTableView.setVisibility(View.INVISIBLE);
    }

    public void hideProgressBar()
    {
        mProgressBar.setVisibility(View.INVISIBLE);
        mTableView.setVisibility(View.VISIBLE);
    }
}
