package Servertlet;

import DAO.CountryIndexDAO;
import Enitiy.CountryIndex;
import Impl.CountryIndexImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryServlet", value = "/dataview")
public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CountryIndexDAO ciDao = new CountryIndexImpl();
        List<CountryIndex> ciAll = ciDao.getAllCountryIndex();
        request.setAttribute("list",ciAll);
        request.getRequestDispatcher("dataview.jsp").forward(request,response);
    }
}
