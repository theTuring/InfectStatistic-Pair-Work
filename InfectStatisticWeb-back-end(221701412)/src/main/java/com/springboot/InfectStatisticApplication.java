package com.springboot;

import com.springboot.domain.Nation;
import com.springboot.utils.jsontool.AnalysisJson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.sql.SQLException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * InfectStatisticApplication
 * TODO
 * @description springboot启动类
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.3.8
 */

@SpringBootApplication
//exclude表示自动配置时不包括Multipart配置
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
@ServletComponentScan
public class InfectStatisticApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {

        // 创建定时器
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            // 在run方法中的语句就是定时任务执行时运行的语句。
            public void run() {

                //json解析类实例化
                AnalysisJson analysisJson = new AnalysisJson();

                try {
                    analysisJson.TimerExecute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
            // 表示在3秒之后开始执行，并且每8640秒（一天）执行一次
        }, 3000, 8640000);


        SpringApplication.run(InfectStatisticApplication.class, args);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(InfectStatisticApplication.class);
    }

//    /**
//     * 显示声明CommonsMultipartResolver为mutipartResolver
//     */
//    @Bean(name = "multipartResolver")
//    public MultipartResolver multipartResolver() {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("UTF-8");
//        //resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
//        resolver.setResolveLazily(true);
//        resolver.setMaxInMemorySize(40960);
//        resolver.setMaxUploadSize(8 * 1024 * 1024);//上传文件大小 8M 8*1024*1024
//        return resolver;
//    }

    /**
     * ajax跨域
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
