package Servertlet;

import DAO.CountryIndexDAO;
import Enitiy.CountryIndex;
import Impl.CountryIndexImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InsertServerlet", value = "/InsertServerlet")
public class InsertServerlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Country = request.getParameter("add-COUNTRY");
        String YEAR = request.getParameter("add-YEAR");
        float D11 = 0;
        float D111 = 0;
        float D112 = 0;
        float D12 = 0;
        float D121 = 0;
        float D122 = 0;
        if (request.getParameter("add-D11") != null) {
            D11 = Float.parseFloat(request.getParameter("add-D11"));
        }
        if (request.getParameter("add-D111") != null) {
            D111 = Float.parseFloat(request.getParameter("add-D111"));
        }
        if (request.getParameter("add-D112") != null) {
            D112 = Float.parseFloat(request.getParameter("add-D112"));
        }
        if (request.getParameter("add-D12") != null) {
            D12 = Float.parseFloat(request.getParameter("add-D12"));
        }
        if (request.getParameter("add-D121") != null) {
            D121 = Float.parseFloat(request.getParameter("add-D121"));
        }
        if (request.getParameter("add-D122") != null) {
            D122 = Float.parseFloat(request.getParameter("add-D122"));
        }
        CountryIndexDAO ciDao = new CountryIndexImpl();
        ciDao.addCountryIndex(Country, D11, D111, D112, D12, D121, D122, YEAR);
        response.sendRedirect("dataview");
    }
}
