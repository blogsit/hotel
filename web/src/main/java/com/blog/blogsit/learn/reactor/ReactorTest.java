package com.blog.blogsit.learn.reactor;

import java.io.IOException;

public class ReactorTest {
    public static void main(String[] args) throws IOException {
        Reactor reactor = new Reactor();
        new Handler(reactor.selector);
        reactor.run();
    }

}
