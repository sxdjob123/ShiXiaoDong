package com.example.ch.shixiaodong.model;

import com.example.ch.shixiaodong.R;
import com.example.ch.shixiaodong.bean.Student;
import com.example.ch.shixiaodong.callback.ICallBack;
import com.example.ch.shixiaodong.utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 76165
 * on 2019/6/13
 */
public class HomeModel implements IModel {
    @Override
    public void getData(ICallBack callBack) {

        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Student((long) i, R.drawable.a, "标题" + i, "描述" + i, "www.baidu.com"));
        }
        DbUtils.getDbUtils().insert(list);

        List<Student> query = DbUtils.getDbUtils().query();
        callBack.onSuccess(query);
    }
}
