package cn.njupt.dao.impl;

import cn.njupt.dao.a2Dao;
import cn.njupt.util.JDBCUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class a2DaoImpl implements a2Dao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Object[] search(String geneA ,String geneB, String table) {
        String sql1="select * from "+table.toLowerCase()+"m"+" where rn=?";
        Map<String, Object> map1 = template.queryForMap(sql1, geneA);
        Double[] arr1=new Double[map1.size()-1];
        for (int s=0;s<= map1.size()-2;s++) {
           arr1[s] = (Double) map1.values().toArray()[s+1];
        }
        Map<String, Object> map2 = template.queryForMap(sql1, geneB);
        Double[] arr2=new Double[map2.size()-1];
        for (int s=0;s<= map2.size()-2;s++) {
            arr2[s] = (Double) map2.values().toArray()[s+1];
        }

        String sql2="select * from "+table.toLowerCase()+"c"+" where gene=?";
        Map<String, Object> map3 = template.queryForMap(sql2, geneA);
        Double[] arr3=new Double[map3.size()-1];
        for (int s=0;s<= map3.size()-2;s++) {

            arr3[s] = (Double) map3.values().toArray()[s+1];
        }
        Map<String, Object> map4 = template.queryForMap(sql2, geneB);
        Double[] arr4=new Double[map4.size()-1];
        for (int s=0;s<= map4.size()-2;s++) {
            arr4[s] = (Double) map4.values().toArray()[s+1];
        }

        String sql3="select * from "+table.toLowerCase()+" where gene=?";
        Map<String, Object> map5 = template.queryForMap(sql3, geneA);
        Double[] arr5=new Double[map5.size()-1];
        for (int s=0;s<= map5.size()-2;s++) {
            arr5[s] = (Double) map5.values().toArray()[s+1];
        }
        Map<String, Object> map6 = template.queryForMap(sql3, geneB);
        Double[] arr6=new Double[map6.size()-1];
        for (int s=0;s<= map6.size()-2;s++) {
            arr6[s] = (Double) map6.values().toArray()[s+1];
        }
        Double[] d1= ArrayUtils.addAll(arr1,arr2);
        Double[] d2 =ArrayUtils.addAll(arr3,arr4);
        Double[] d3 =ArrayUtils.addAll(arr5,arr6);
        return new Double[][]{d1,d2,d3};
    }
}
