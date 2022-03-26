package cn.njupt.service.impl;

import cn.njupt.dao.anaDao;

import cn.njupt.dao.impl.anaDaoImpl;
import cn.njupt.domain.anabean;
import cn.njupt.service.anaService;

import java.util.List;

public class anaServiceImpl implements anaService {
    private anaDao dao=new anaDaoImpl();
    @Override
    public List<anabean> search(String geneA, String geneB,String cancer) {
        return dao.search(geneA,geneB,cancer);
    }
}
