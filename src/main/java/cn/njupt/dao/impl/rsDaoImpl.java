package cn.njupt.dao.impl;

import cn.njupt.dao.rsDao;
import cn.njupt.domain.rsbean;
import cn.njupt.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class rsDaoImpl implements rsDao {
    private  JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<rsbean> search1(String name,String cancer) {
        String sql="select geneA,geneB,num,f1,yz from js where (geneA=? or geneB=?) and "+cancer+"=1";
        return template.query(sql,new BeanPropertyRowMapper<rsbean>(rsbean.class),name,name);
    }
    public List<rsbean> search2(String geneA,String geneB) {
        String sql="select geneA,geneB,num,f1,yz from js where( geneA=? and geneB=?) or(geneB=? and geneA=?)";
        return template.query(sql,new BeanPropertyRowMapper<rsbean>(rsbean.class),geneA,geneB,geneA,geneB);
    }

    @Override
    public String[] search3() {
        String sql="select gn from gn";
        List<Map<String, Object>> maps = template.queryForList(sql);
        String[] arr=new String[maps.size()];
        for (int s=0;s<= maps.size()-1;s++) {
            arr[s] = (String) maps.get(s).get("gn");
        }
        return arr;
    }
}
