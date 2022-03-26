package cn.njupt.service.impl;

import cn.njupt.dao.a2Dao;
import cn.njupt.dao.impl.a2DaoImpl;
import cn.njupt.service.a2Service;

public class a2ServiceImpl implements a2Service {
    private a2Dao dao=new a2DaoImpl();
    @Override
    public Object[] search(String geneA, String geneB, String table) {
        return dao.search(geneA,geneB,table);
    }
}
