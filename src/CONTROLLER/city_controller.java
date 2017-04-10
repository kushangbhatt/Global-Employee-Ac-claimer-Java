package CONTROLLER;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.city_dao;
import DAO.country_dao;
import DAO.state_dao;
import VO.city_vo;
import VO.country_vo;
import VO.state_vo;

/**
 * Servlet implementation class city_controller
 */
@WebServlet("/city_controller")
public class city_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public city_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f = request.getParameter("flag");
		if(f!=null && f.equals("loadst")){
			loadst(request, response);
		}
		if(f!=null && f.equals("load")){
			load(request, response);
		}
		if (f!=null && f.equals("loadCnt")){
			loadCnt(request, response);
		}
	}
	private void loadCnt(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		country_dao cd = new country_dao();
		List ls = cd.search();
		
		HttpSession hs = request.getSession();
		hs.setAttribute("list", ls);
		response.sendRedirect("Admin/form_city.jsp");
	}

	private void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		city_dao cd = new city_dao();
		List ls = cd.search();
		
		HttpSession hs = request.getSession();
		hs.setAttribute("list", ls);
		response.sendRedirect("Admin/search_city.jsp");
	
	}

	private void loadst(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int country_id = Integer.parseInt(request.getParameter("country_id"));
		System.out.println("dsfgaea");
		System.out.println(country_id);
		country_vo acv = new country_vo();
		
		acv.setId(country_id);
		
		state_vo sv = new state_vo();
		
		sv.setCv(acv);
		
		state_dao sd = new state_dao();
		
		List list = sd.AJAXsearch(sv);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("state_details",list);
		
		response.sendRedirect("Admin/jason_loadstate.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f = request.getParameter("flag");
		String s1 = request.getParameter("ct");
		String s4 = request.getParameter("cnt");
		String s2 = request.getParameter("cd");
		String s3 = request.getParameter("st");
		
		city_vo cv = new city_vo();
		cv.setCity(s1);
		cv.setCt_desc(s2);
		
		country_vo cnv = new country_vo();
		cnv.setId(Integer.parseInt(s4));
		
		
		
		state_vo sv = new state_vo();	
		sv.setId(Integer.parseInt(s3));
		cv.setCv(cnv);
		
		cv.setSv(sv);
		
		if (f!=null && f.equals("insert")){
			insert(request, response, cv);
		}
		
		
		
	}

	private void insert(HttpServletRequest request,
			HttpServletResponse response, city_vo cv) throws IOException {
		// TODO Auto-generated method stub
		city_dao cd = new city_dao();
		cd.insert(cv);
		response.sendRedirect("Admin/form_city.jsp");
	}

}
