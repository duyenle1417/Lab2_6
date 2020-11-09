package com.example.lab2_recycleview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    ArrayList<Employee> employees;

    public EmployeeAdapter(ArrayList<Employee> obj) {
        employees = obj;
    }

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder{
        public TextView textView_fullname;
        public TextView textView_staff;
        public ImageView imageView_manager_ic;
        public LinearLayout llParent;
        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_fullname = itemView.findViewById(R.id.item_employee_tv_fullname);
            textView_staff = itemView.findViewById(R.id.item_employee_tv_position);
            imageView_manager_ic = itemView.findViewById(R.id.item_employee_ic_manager);
            llParent = itemView.findViewById(R.id.item_employee_layout);
        }
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_item_lv, parent, false);
        EmployeeViewHolder holder = new EmployeeViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employees.get(position);

        // Set fullname
        if (employee.getName()!=null) {
            holder.textView_fullname.setText(employee.getName());
        }
        else holder.textView_fullname.setText("");

        // If this is a manager -> show icon manager. Otherwise, show Staff in tvPosition
        if (employee.isManager())
        {
            holder.imageView_manager_ic.setVisibility(View.VISIBLE);
            holder.textView_staff.setVisibility(View.GONE);
        }
        else
        {
            holder.imageView_manager_ic.setVisibility(View.GONE);
            holder.textView_staff.setVisibility(View.VISIBLE);
        }

        // Show different color backgrounds for 2 continuous employees
        if (position%2==0)
        {
            holder.llParent.setBackgroundResource(R.color.white);
        }
        else
        {
            holder.llParent.setBackgroundResource(R.color.light_blue);
        }
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }
}
