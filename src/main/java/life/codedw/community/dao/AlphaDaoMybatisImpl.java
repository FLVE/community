package life.codedw.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @Author wangjiefang
 * @Date 14:58 2020/5/7
 * @Description
 **/
@Repository
@Primary
public class AlphaDaoMybatisImpl implements AlphaDao{
    @Override
    public String select() {
        return "mybatis";
    }
}
