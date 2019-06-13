package com.example.ch.shixiaodong.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ch.shixiaodong.R;
import com.example.ch.shixiaodong.bean.Student;

import java.util.ArrayList;

/**
 * Created by 76165
 * on 2019/6/13
 */
public class RlvAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Student> students;

    public RlvAdapter(Context context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = null;
        RecyclerView.ViewHolder holder = null;
        if (i == 0) {
            view = LayoutInflater.from(context).inflate(R.layout.item_a, viewGroup, false);
            holder = new ViewHolder1(view);
        } else if (i == 1) {
            view = LayoutInflater.from(context).inflate(R.layout.item_b, viewGroup, false);
            holder = new ViewHolder2(view);

        } else if (i == 2) {
            view = LayoutInflater.from(context).inflate(R.layout.item_c, viewGroup, false);
            holder = new ViewHolder3(view);

        }

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            ViewHolder1 viewHolder1 = (ViewHolder1) viewHolder;
            viewHolder1.tva.setText(students.get(i).getTitle());
            viewHolder1.iva.setImageResource(students.get(i).getImage());

        } else if (itemViewType == 1) {
            ViewHolder2 viewHolder2 = (ViewHolder2) viewHolder;
            viewHolder2.tvb.setText(students.get(i).getTitle());
            viewHolder2.ivb.setImageResource(students.get(i).getImage());

        } else if (itemViewType == 2) {
            ViewHolder3 viewHolder3 = (ViewHolder3) viewHolder;
            viewHolder3.tvc.setText(students.get(i).getTitle());
            viewHolder3.ivc.setImageResource(students.get(i).getImage());

        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myClickListener != null) {
                    myClickListener.MyClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 3) {
            return 1;
        } else {
            return 2;
        }
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private TextView tva;
        private ImageView iva;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            tva = itemView.findViewById(R.id.tv_a);
            iva = itemView.findViewById(R.id.iv_a);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {

        private TextView tvb;
        private ImageView ivb;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            tvb = itemView.findViewById(R.id.tv_b);
            ivb = itemView.findViewById(R.id.iv_b);
        }
    }

    public class ViewHolder3 extends RecyclerView.ViewHolder {

        private TextView tvc;
        private ImageView ivc;

        public ViewHolder3(@NonNull View itemView) {
            super(itemView);
            tvc = itemView.findViewById(R.id.tv_c);
            ivc = itemView.findViewById(R.id.iv_c);
        }
    }

    public interface MyClickListener {
        void MyClick(int position);
    }

    private MyClickListener myClickListener;

    public void setMyClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }
}
