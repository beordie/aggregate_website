package com.beordie.service;

import com.beordie.bean.Data;
import org.junit.Test;

import java.util.List;

public class LinkServiceTest {

    @Test
    public void findAll() {
        List<Data> data = LinkService.findAll();
        System.out.println(data);

    }

    @Test
    public void findById() {
        String link = LinkService.findById(100);
        System.out.println(link);

    }
}