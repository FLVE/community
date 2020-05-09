package life.codedw.community.service.test;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author wangjiefang
 * @Date 15:01 2020/5/7
 * @Description
 **/
@Service
public class AlphaService {

    public AlphaService(){
        System.out.println("实例化AlphaService");
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化AlphaService");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁alphaService");
    }
}
