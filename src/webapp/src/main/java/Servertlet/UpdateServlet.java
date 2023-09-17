package Servertlet;

import DAO.CountryIndexDAO;
import Impl.CountryIndexImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Country = new String (request.getParameter("input-COUNTRY").getBytes("ISO8859-1"),"UTF-8");
        System.out.println(Country);
        String YEAR = new String (request.getParameter("input-YEAR").getBytes("ISO8859-1"),"UTF-8");
        float D11 = Float.parseFloat(request.getParameter("input-D11"));
        float D111 = Float.parseFloat(request.getParameter("input-D111"));
        float D112 = Float.parseFloat(request.getParameter("input-D112"));
        float D12 = Float.parseFloat(request.getParameter("input-D12"));
        float D121 = Float.parseFloat(request.getParameter("input-D121"));
        float D122 = Float.parseFloat(request.getParameter("input-D122"));
        CountryIndexDAO ciDao = new CountryIndexImpl();
        int res = ciDao.updateCountryIndex(Country, D11, D111, D112, D12, D121, D122, YEAR);
        response.sendRedirect("dataview");
    }
}
