package com.example.ch.shixiaodong.utils;

import com.example.ch.shixiaodong.R;
import com.example.ch.shixiaodong.bean.Student;
import com.example.ch.shixiaodong.common.DbApplication;
import com.example.ch.shixiaodong.dao.DaoMaster;
import com.example.ch.shixiaodong.dao.DaoSession;
import com.example.ch.shixiaodong.dao.StudentDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 76165
 * on 2019/6/13
 */
public class DbUtils {
    private static volatile DbUtils dbUtils;
    private final StudentDao studentDao;

    public static DbUtils getDbUtils() {
        if (dbUtils == null) {
            synchronized (DbUtils.class) {
                if (dbUtils == null) {
                    dbUtils = new DbUtils();
                }
            }
        }
        return dbUtils;
    }

    public DbUtils() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(DbApplication.getDbApplication(), "student.db");
        DaoMaster daoMaster = new DaoMaster(helper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        studentDao = daoSession.getStudentDao();
    }

    public void insert(List<Student> list) {
        studentDao.insertOrReplaceInTx(list);
    }

    public List<Student> query() {
        List<Student> list = studentDao.queryBuilder().list();
        return list;
    }
}
