package Servertlet;

import DAO.CountryIndexDAO;
import Enitiy.CountryIndex;
import Impl.CountryIndexImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.mysql.cj.xdevapi.Type.JSON;

@WebServlet(name = "IndexServerlet", value = "/index")
public class IndexServerlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CountryIndexDAO ciDao = new CountryIndexImpl();
        List<CountryIndex> ciAll = ciDao.getAllCountryIndex();
        ArrayList<String> ciJSON = new ArrayList<>();
        for (CountryIndex ci: ciAll) {
            ciJSON.add(ci.toJSON());
        }
        request.setAttribute("list",ciJSON);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

}
