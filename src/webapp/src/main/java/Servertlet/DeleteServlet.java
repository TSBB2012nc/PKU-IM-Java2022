package Servertlet;

import DAO.CountryIndexDAO;
import Impl.CountryIndexImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String Country = request.getParameter("COUNTRY");
        String YEAR = request.getParameter("YEAR");
        System.out.println(Country);
        System.out.println(YEAR);
        CountryIndexDAO ciDao = new CountryIndexImpl();
        ciDao.delCountryIndex(Country, YEAR);
        response.sendRedirect("dataview");
    }
}
