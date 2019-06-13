package com.example.ch.shixiaodong.view;

import com.example.ch.shixiaodong.bean.Student;

import java.util.List;

/**
 * Created by 76165
 * on 2019/6/13
 */
public interface IView {
    void onSuccess(List<Student> list);

    void onFail(String error);
}
