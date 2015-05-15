package cn.dong.app.model;

import java.util.List;

/**
 * @author dong on 15/5/13.
 */
public class MainResponseInfo {
    public Data data;

    public static class Data {
        public List<Blog> blogs;
    }

    public static class Blog {
        public int id;
        public String isrc;
        public String msg;
    }
}


