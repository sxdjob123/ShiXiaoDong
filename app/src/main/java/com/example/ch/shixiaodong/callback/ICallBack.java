package com.example.ch.shixiaodong.callback;

import com.example.ch.shixiaodong.bean.Student;

import java.util.List;

/**
 * Created by 76165
 * on 2019/6/13
 */
public interface ICallBack {
    void onSuccess(List<Student> list);

    void onFail(String error);
}
