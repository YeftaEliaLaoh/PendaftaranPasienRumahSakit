package com.example.pendaftaranpasienrumahsakit;

import android.view.Gravity;

import com.example.pendaftaranpasienrumahsakit.entity.Pasien;
import com.example.pendaftaranpasienrumahsakit.model.CellModel;
import com.example.pendaftaranpasienrumahsakit.model.ColumnHeaderModel;
import com.example.pendaftaranpasienrumahsakit.model.RowHeaderModel;

import java.util.ArrayList;
import java.util.List;

public class MyTableViewModel
{

    private List<ColumnHeaderModel> mColumnHeaderModelList;
    private List<RowHeaderModel> mRowHeaderModelList;
    private List<List<CellModel>> mCellModelList;

    public int getCellItemViewType( int column )
    {
        return 0;
    }
     /*
       - Each of Column Header -
            "Id"
            "Name"
            "Nickname"
            "Email"
            "Birthday"
            "Gender"
            "Age"
            "Job"
            "Salary"
            "CreatedAt"
            "UpdatedAt"
            "Address"
            "Zip Code"
            "Phone"
            "Fax"
     */

    public int getColumnTextAlign( int column )
    {
        switch ( column )
        {
            // Id
            case 0:
                return Gravity.CENTER;
            // Name
            case 1:
                return Gravity.LEFT;
            // Nickname
            case 2:
                return Gravity.LEFT;
            // Email
            case 3:
                return Gravity.LEFT;
            // BirthDay
            case 4:
                return Gravity.CENTER;
            // Gender (Sex)
            case 5:
                return Gravity.CENTER;
            // Age
            case 6:
                return Gravity.CENTER;
            // Job
            case 7:
                return Gravity.LEFT;
            // Salary
            case 8:
                return Gravity.CENTER;
            // CreatedAt
            case 9:
                return Gravity.CENTER;
            // UpdatedAt
            case 10:
                return Gravity.CENTER;
            // Address
            case 11:
                return Gravity.LEFT;
            // Zip Code
            case 12:
                return Gravity.RIGHT;
            // Phone
            case 13:
                return Gravity.RIGHT;
            // Fax
            case 14:
                return Gravity.RIGHT;
            default:
                return Gravity.CENTER;
        }

    }

    private List<ColumnHeaderModel> createColumnHeaderModelList()
    {
        List<ColumnHeaderModel> list = new ArrayList<>();

        // Create Column Headers
        list.add(new ColumnHeaderModel("Nama"));
        list.add(new ColumnHeaderModel("Alamat"));
        list.add(new ColumnHeaderModel("Tahun"));
        list.add(new ColumnHeaderModel("Jenis Kelamin"));

        return list;
    }

    private List<List<CellModel>> createCellModelList( List<Pasien> pasienList )
    {
        List<List<CellModel>> lists = new ArrayList<>();

        // Creating cell model list from User list for Cell Items
        // In this example, User list is populated from web service

        for( int i = 0; i < pasienList.size(); i++ )
        {
            Pasien user = pasienList.get(i);

            List<CellModel> list = new ArrayList<>();

            // The order should be same with column header list;
            list.add(new CellModel("1-" + i, user.nama));          // "Id"
            list.add(new CellModel("2-" + i, user.alamat));        // "Name"
            list.add(new CellModel("3-" + i, user.tahun));
            list.add(new CellModel("4-" + i, user.jenisKelamin));

            // Add
            lists.add(list);
        }

        return lists;
    }

    private List<RowHeaderModel> createRowHeaderList( int size )
    {
        List<RowHeaderModel> list = new ArrayList<>();
        for( int i = 0; i < size; i++ )
        {
            // In this example, Row headers just shows the index of the TableView List.
            list.add(new RowHeaderModel(String.valueOf(i + 1)));
        }
        return list;
    }


    public List<ColumnHeaderModel> getColumHeaderModeList()
    {
        return mColumnHeaderModelList;
    }

    public List<RowHeaderModel> getRowHeaderModelList()
    {
        return mRowHeaderModelList;
    }

    public List<List<CellModel>> getCellModelList()
    {
        return mCellModelList;
    }


    public void generateListForTableView( List<Pasien> pasiens )
    {
        mColumnHeaderModelList = createColumnHeaderModelList();
        mCellModelList = createCellModelList(pasiens);
        mRowHeaderModelList = createRowHeaderList(pasiens.size());
    }

}



