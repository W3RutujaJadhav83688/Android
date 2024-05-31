package com.rutu12m.assign_5;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyviewHolder> {
    Context context;
    List<Employee> employeeList;
    Employee employee;

    public EmployeeAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_employee,null);
        return  new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.textName.setText(employeeList.get(position).getName());
        holder.textDesg.setText(employeeList.get(position).getDesg());
        holder.imageView.setImageResource(employeeList.get(position).getImage());
       // Log.e("EmployeeDetailsActivity","EmployeeDetailsActivity"+employee);
        holder.itemView.setOnClickListener(v-> {

            Intent intent = new Intent(context, EmployeeDetailsActivity.class);
            Log.e("EmployeeAdapter","EmployeeAdapter"+employee);
            intent.putExtra("employee",employee);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        ImageView imageView;
        TextView textName,textDesg;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textName = itemView.findViewById(R.id.textName);
            textDesg = itemView.findViewById(R.id.textDesg);
            imageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, EmployeeDetailsActivity.class);
            intent.putExtra("employee",employeeList.get(getAdapterPosition()));
            context.startActivity(intent);


        }
    }
}
