package cn.njupt.dao;

import cn.njupt.domain.anabean;


import java.util.List;

public interface anaDao {
    public List<anabean> search(String geneA, String geneB,String cancer);
}
