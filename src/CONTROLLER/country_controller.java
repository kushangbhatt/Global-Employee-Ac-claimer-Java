package CONTROLLER;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.country_dao;
import VO.country_vo;

/**
 * Servlet implementation class country_controller
 */
@WebServlet("/country_controller")
public class country_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public country_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f = request.getParameter("flag");
		if (f!=null && f.equals("load")){
			load(request, response);
		}
		
		if (f!=null && f.equals("loadsrc")){
			int id = Integer.parseInt(request.getParameter("id"));
			loadsrc(request, response, id);
		}
		
		if (f!=null && f.equals("delete")){
			int id = Integer.parseInt(request.getParameter("id"));
			country_vo cv = new country_vo();
			cv.setId(id);
			delete(request, response, cv);
		}
	}

	private void delete(HttpServletRequest request,
			HttpServletResponse response, country_vo cv) throws IOException {
		// TODO Auto-generated method stub
		country_dao cd = new country_dao();
		cd.delete(cv);
		response.sendRedirect("country_controller?flag=load");
	}

	private void loadsrc(HttpServletRequest request,
			HttpServletResponse response, int id) throws IOException{
		// TODO Auto-generated method stub
		country_dao cd = new country_dao();
		List ls = cd.loadsrc(id);
		
		HttpSession hs = request.getSession();
		hs.setAttribute("ulist", ls);
		
		response.sendRedirect("Admin/update_country_form.jsp");
	}

	private void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		country_dao cd = new country_dao();
		List ls = cd.search();
		
		HttpSession hs = request.getSession();
		hs.setAttribute("list", ls);
		response.sendRedirect("Admin/search_country.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f = request.getParameter("flag");
		String s1 = request.getParameter("cnt");
		String s2 = request.getParameter("cntd");
		
		country_vo cv = new country_vo();
		cv.setCountry(s1);
		cv.setCnt_desc(s2);
		
		if (f!=null && f.equals("insert")){
			insert(request, response, cv);
		}
		
		if (f!=null && f.equals("update")){
			int id = Integer.parseInt(request.getParameter("id"));
			cv.setId(id);
			update(request, response, cv);
			
		}
	}

	private void update(HttpServletRequest request,
			HttpServletResponse response, country_vo cv) throws IOException {
		// TODO Auto-generated method stub
		country_dao cd = new country_dao();
		cd.update(cv);
		response.sendRedirect("country_controller?flag=load");;
	}

	private void insert(HttpServletRequest request,
			HttpServletResponse response, country_vo cv) throws IOException {
		// TODO Auto-generated method stub
		country_dao cd = new country_dao();
		cd.insert(cv);
		response.sendRedirect("Admin/form_country.jsp");
	}

}
