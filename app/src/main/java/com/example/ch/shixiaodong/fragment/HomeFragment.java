package com.example.ch.shixiaodong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ch.shixiaodong.Message;
import com.example.ch.shixiaodong.R;
import com.example.ch.shixiaodong.adapter.RlvAdapter;
import com.example.ch.shixiaodong.bean.Student;
import com.example.ch.shixiaodong.model.HomeModel;
import com.example.ch.shixiaodong.presenter.HomePresenter;
import com.example.ch.shixiaodong.view.IView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements IView, RlvAdapter.MyClickListener {

    private RecyclerView mRv;
    private ArrayList<Student> arrayList;
    private RlvAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
    }

    private void initView() {
        View view = getView();
        mRv = view.findViewById(R.id.rv);

        arrayList = new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRv.setLayoutManager(manager);

        adapter = new RlvAdapter(getActivity(), arrayList);
        mRv.setAdapter(adapter);

        adapter.setMyClickListener(this);

        HomePresenter homePresenter = new HomePresenter(new HomeModel(), this);
        homePresenter.getData();
    }

    @Override
    public void onSuccess(List<Student> list) {
        arrayList.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {

    }

    @Override
    public void MyClick(int position) {
        EventBus.getDefault().postSticky(new Message(arrayList.get(position).getUrl()));
    }
}
