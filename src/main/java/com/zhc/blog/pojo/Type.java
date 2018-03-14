package com.zhc.blog.pojo;

public class Type {
    private int id;
    private String name;  //类型名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
