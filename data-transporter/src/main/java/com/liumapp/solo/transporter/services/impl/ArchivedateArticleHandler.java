package com.liumapp.solo.transporter.services.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liumapp.solo.transporter.contents.JsonFileContents;
import com.liumapp.solo.transporter.db.entity.B3SoloArchivedateArticle;
import com.liumapp.solo.transporter.db.mapper.B3SoloArchivedateArticleMapper;
import com.liumapp.solo.transporter.services.HandDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * file ArchivedateArticleHandler.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/21
 */
@Service
public class ArchivedateArticleHandler implements HandDataService {

    @Autowired
    private B3SoloArchivedateArticleMapper mapper;

    @Autowired
    private JsonFileContents jsonFileContents;

    @Override
    public void handle() {
        JSONArray archivedates = jsonFileContents.getArchivedateArticle();
        B3SoloArchivedateArticle archivedateArticle = new B3SoloArchivedateArticle();
        for (Iterator iterator = archivedates.iterator(); iterator.hasNext();) {
            JSONObject archivedate = (JSONObject) iterator.next();
            
        }
    }

}
