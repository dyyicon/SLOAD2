package cn.njupt.service.impl;

import cn.njupt.dao.impl.rsDaoImpl;
import cn.njupt.dao.rsDao;
import cn.njupt.domain.rsbean;
import cn.njupt.service.rsService;

import java.util.List;

public class rsServiceImpl implements rsService {
    private rsDao dao=new rsDaoImpl();
    @Override
    public List<rsbean> search1(String name, String cancer) {

        return dao.search1(name,cancer);
    }
    public List<rsbean> search2(String geneA, String geneB) {

        return dao.search2(geneA,geneB);
    }

    @Override
    public String[] search3() {
        return dao.search3();
    }
}
