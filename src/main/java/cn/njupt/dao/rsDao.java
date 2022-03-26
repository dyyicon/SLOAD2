package cn.njupt.dao;

import cn.njupt.domain.rsbean;

import java.util.List;

public interface rsDao {
    public List<rsbean> search1(String name,String cancer);
    public List<rsbean> search2(String geneA, String geneB);
    public String[] search3();
}
