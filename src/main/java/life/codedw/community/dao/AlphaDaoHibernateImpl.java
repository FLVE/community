package life.codedw.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author wangjiefang
 * @Date 14:53 2020/5/7
 * @Description
 **/
@Repository("Hibernate")
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
