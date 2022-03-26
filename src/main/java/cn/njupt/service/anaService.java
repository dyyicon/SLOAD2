package cn.njupt.service;

import cn.njupt.domain.anabean;
import cn.njupt.domain.rsbean;

import java.util.List;

public interface anaService {
    public List<anabean> search(String geneA, String geneB,String cancer);
}
