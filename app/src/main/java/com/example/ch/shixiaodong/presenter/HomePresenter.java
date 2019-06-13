package com.example.ch.shixiaodong.presenter;

import com.example.ch.shixiaodong.bean.Student;
import com.example.ch.shixiaodong.callback.ICallBack;
import com.example.ch.shixiaodong.model.IModel;
import com.example.ch.shixiaodong.view.IView;

import java.util.List;

/**
 * Created by 76165
 * on 2019/6/13
 */
public class HomePresenter implements IPresenter, ICallBack {

    private IModel iModel;
    private IView iView;

    public HomePresenter(IModel iModel, IView iView) {
        this.iModel = iModel;
        this.iView = iView;
    }

    @Override
    public void getData() {
        if (iModel != null) {
            iModel.getData(this);
        }
    }

    @Override
    public void onSuccess(List<Student> list) {
        if (iView != null) {
            iView.onSuccess(list);
        }
    }

    @Override
    public void onFail(String error) {
        if (iView != null) {
            iView.onFail(error);
        }
    }
}
