package com.liumapp.solo.transporter;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.solo.transporter.enums.DataEnums;
import com.liumapp.solo.transporter.loader.JsonFileLoader;
import com.liumapp.solo.transporter.objects.article.Article;
import org.beryx.textio.TextIO;
import org.beryx.textio.system.SystemTextTerminal;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;

import javax.annotation.Resource;
import java.io.FileNotFoundException;

/**
 * file DataTransporterConsole.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/20
 */
@SpringBootApplication
@MapperScan("com.liumapp.solo.transporter.mapper")
public class DataTransporterConsole implements CommandLineRunner {

    private static Logger Logger = LoggerFactory.getLogger(DataTransporterConsole.class);

    public static TextIO textIO;

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private JsonFileLoader jsonFileLoader;

    @Autowired
    private Article article;

    public static void main (String[] args) {
        SpringApplication.run(DataTransporterConsole.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Logger.info("Starting Data Transporter Console program...");
        SystemTextTerminal systemTextTerminal = new SystemTextTerminal();
        taskExecutor.execute(jsonFileLoader);
        textIO = new TextIO(systemTextTerminal);
        DataEnums datas = textIO.newEnumInputReader(DataEnums.class).read("先插入文章还是评论？");

        switch (datas) {
            case Article:
                this.handleArticle();
                break;
            case Comment:
                this.handleComment();
                break;
            default:
        }
    }

    /**
     * 处理文章数据，插入solo数据库中
     */
    private void handleArticle () throws FileNotFoundException {
        Logger.info("开始读取resources目录下的csvjson文件，并识别文章信息");
        String path = article.getArticleTags();
        article.toString();
    }

    /**
     * 处理评论数据
     */
    private void handleComment () {

    }
}
