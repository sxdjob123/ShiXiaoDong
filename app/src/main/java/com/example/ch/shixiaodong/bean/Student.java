package com.example.ch.shixiaodong.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 76165
 * on 2019/6/13
 */

@Entity
public class Student {

    @Id(autoincrement = true)
    private Long id;

    @Property
    private Integer image;

    @Property
    private String name;

    @Property
    private String title;

    @Property
    private String url;

    @Generated(hash = 751154365)
    public Student(Long id, Integer image, String name, String title, String url) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.title = title;
        this.url = url;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getImage() {
        return this.image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
