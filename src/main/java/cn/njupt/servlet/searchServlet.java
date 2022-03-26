package cn.njupt.servlet;

import cn.njupt.domain.anabean;
import cn.njupt.domain.rsbean;
import cn.njupt.service.a2Service;
import cn.njupt.service.anaService;
import cn.njupt.service.impl.a2ServiceImpl;
import cn.njupt.service.impl.rsServiceImpl;
import cn.njupt.service.impl.anaServiceImpl;
import cn.njupt.service.rsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchServlet/*")
public class searchServlet extends BaseServlet {
    private rsService service=new rsServiceImpl();
    private anaService service2=new anaServiceImpl();
    private a2Service service3=new a2ServiceImpl();

    public void search1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String cancer = request.getParameter("cancer");
        List<rsbean> rs=service.search1(name,cancer);
        writeValue(rs,response);
    }
    public void search2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("geneA");
        String cancer = request.getParameter("geneB");
        List<rsbean> rs=service.search2(name,cancer);
        writeValue(rs,response);
    }
    public void search3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String geneA = request.getParameter("geneA");
        String geneB = request.getParameter("geneB");
        String cancer= request.getParameter("cancer");
        List<anabean> rs=service2.search(geneA,geneB,cancer);
        writeValue(rs,response);
    }
    public void search4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String geneA = request.getParameter("geneA");
        String geneB = request.getParameter("geneB");
        String table = request.getParameter("table");
        Object[] rs = service3.search(geneA,geneB,table);
        writeValue(rs,response);
    }
    public void search5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object[] rs = service.search3();
        writeValue(rs,response);
    }
}
