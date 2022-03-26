package cn.njupt.dao.impl;

import cn.njupt.dao.anaDao;
import cn.njupt.domain.anabean;

import cn.njupt.util.JDBCUtils;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class anaDaoImpl implements anaDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<anabean> search(String geneA, String geneB,String cancer) {
        String sql="select * from "+cancer.toLowerCase()+" where gene=? ";
       /* return template.query(sql,new BeanPropertyRowMapper<anabean>(anabean.class),geneA,geneB,geneA,geneB);*/

        return template.query(sql,new BeanPropertyRowMapper<anabean>(anabean.class),geneA,geneB,geneA,geneB);
    }
}
