package com.ten951.consistent;

import java.util.StringJoiner;

/**
 * @author Darcy
 * Created By Darcy on 2019-05-08 14:52
 */
public class Server {

    private String url;

    public Server(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Server.class.getSimpleName() + "[", "]")
                .add("url='" + url + "'")
                .toString();
    }
}
