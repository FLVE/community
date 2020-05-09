package life.codedw.community;

import life.codedw.community.dao.AlphaDao;
import life.codedw.community.entity.DiscussPost;
import life.codedw.community.mapper.DiscussPostMapper;
import life.codedw.community.service.test.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityUtilApplicationTests implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    void contextLoads() {
        System.out.println(applicationContext.toString());
        AlphaDao alphaDao =applicationContext.getBean(AlphaDao.class);
        System.out.println(alphaDao.select());

        AlphaDao hibername = applicationContext.getBean("Hibernate", AlphaDao.class);
        System.out.println(hibername.select());
    }

    @Test
    public void testBeanManagement(){
        AlphaService alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);
    }

    @Test
    public void testBeanConfig(){
        SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateFormat.format(new Date()));
    }

    @Autowired
    private SimpleDateFormat simpleDateFormat;

    @Autowired
    @Qualifier("Hibernate")
    private AlphaDao alphaDao;

    @Autowired
    private AlphaService alphaService;

    @Test
    public void testDI(){
        System.out.println(alphaDao);
        System.out.println(alphaService);
        System.out.println(simpleDateFormat.format(new Date()));
    }

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectDiscussPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for (DiscussPost discussPost : discussPosts) {
            System.out.println(discussPost);
        }
        int i = discussPostMapper.selectDiscussPostRows(149);
        System.out.println("总行数 "+i);
    }


}
