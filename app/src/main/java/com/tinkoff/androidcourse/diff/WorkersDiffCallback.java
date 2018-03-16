package com.tinkoff.androidcourse.diff;

import android.support.v7.util.DiffUtil;

import com.tinkoff.androidcourse.model.Worker;

import java.util.List;

public class WorkersDiffCallback extends DiffUtil.Callback {

    private final List<Worker> mOldEmployeeList;
    private final List<Worker> mNewEmployeeList;

    public WorkersDiffCallback(List<Worker> mOldEmployeeList, List<Worker> mNewEmployeeList) {
        this.mOldEmployeeList = mOldEmployeeList;
        this.mNewEmployeeList = mNewEmployeeList;
    }

    @Override
    public int getOldListSize() {
        return mOldEmployeeList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewEmployeeList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldEmployeeList.get(oldItemPosition).getId() == mNewEmployeeList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final Worker oldEmployee = mOldEmployeeList.get(oldItemPosition);
        final Worker newEmployee = mNewEmployeeList.get(newItemPosition);
        return oldEmployee.getName().equals(newEmployee.getName());
    }

}
