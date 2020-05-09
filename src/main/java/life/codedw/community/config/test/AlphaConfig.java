package life.codedw.community.config.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @Author wangjiefang
 * @Date 15:16 2020/5/7
 * @Description
 **/
@Configuration
public class AlphaConfig {

    @Bean
    public SimpleDateFormat simpleDateFormat(){

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
