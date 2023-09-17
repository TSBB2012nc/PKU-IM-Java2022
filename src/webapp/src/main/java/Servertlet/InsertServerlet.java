package Servertlet;

import DAO.CountryIndexDAO;
import Enitiy.CountryIndex;
import Impl.CountryIndexImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Year;

@WebServlet(name = "InsertServerlet", value = "/InsertServerlet")
public class InsertServerlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Country = new String (request.getParameter("add-COUNTRY").getBytes("ISO8859-1"),"UTF-8");
        String YEAR = new String (request.getParameter("add-YEAR").getBytes("ISO8859-1"),"UTF-8");
        float D11 = 0;
        float D111 = 0;
        float D112 = 0;
        float D12 = 0;
        float D121 = 0;
        float D122 = 0;
        if (request.getParameter("add-D11") != "") {
            D11 = Float.parseFloat(request.getParameter("add-D11"));
        }
        if (request.getParameter("add-D111") != "") {
            D111 = Float.parseFloat(request.getParameter("add-D111"));
        }
        if (request.getParameter("add-D112") != "") {
            D112 = Float.parseFloat(request.getParameter("add-D112"));
        }
        if (request.getParameter("add-D12") != "") {
            D12 = Float.parseFloat(request.getParameter("add-D12"));
        }
        if (request.getParameter("add-D121") != "") {
            D121 = Float.parseFloat(request.getParameter("add-D121"));
        }
        if (request.getParameter("add-D122") != "") {
            D122 = Float.parseFloat(request.getParameter("add-D122"));
        }
        CountryIndexDAO ciDao = new CountryIndexImpl();
        int res = ciDao.addCountryIndex(Country, D11, D111, D112, D12, D121, D122, YEAR);
        response.sendRedirect("dataview");
    }
}
