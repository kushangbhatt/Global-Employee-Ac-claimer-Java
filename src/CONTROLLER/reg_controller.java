package CONTROLLER;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.city_dao;
import DAO.country_dao;
import DAO.reg_dao;
import DAO.state_dao;
import VO.city_vo;
import VO.country_vo;
import VO.reg_vo;
import VO.state_vo;

/**
 * Servlet implementation class reg_controller
 */
@WebServlet("/reg_controller")
public class reg_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reg_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f = request.getParameter("flag");
		if(f!=null && f.equals("load")){
			load(request, response);
			response.sendRedirect("Admin/search_candidate.jsp");
		}
		
		if (f!=null && f.equals("loadcountry")){
			loadcountry(request, response);
			response.sendRedirect("Admin/form_registration.jsp");
		}
		if (f!=null && f.equals("loadsrc"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			loadsrc(request, response, id);
		}
		if(f!=null && f.equals("loadst"))
		{
			doGetState(request, response);
		}
		if(f!=null && f.equals("loadcity"))
		{
			doGetCity(request, response);
		}
		if(f!=null && f.equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			reg_vo rv = new reg_vo();
			rv.setId(id);
			
			delete(request, response, rv);
		}
	}

	private void delete(HttpServletRequest request,
			HttpServletResponse response, reg_vo rv) throws IOException {
		// TODO Auto-generated method stub
		reg_dao rd = new reg_dao();
		rd.delete(rv);
		response.sendRedirect("reg_controller?flag=load");
	}

	private void doGetCity(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("state_id"));
		System.out.println(id);
		
		state_vo sv =new state_vo();
		sv.setId(id);
		
		city_vo cv =new city_vo();
		cv.setSv(sv);
		
		city_dao cd = new city_dao();
		List ls = cd.AJAXSearch(cv);
		
		HttpSession hs = request.getSession();
		
		hs.setAttribute("city_details", ls);
		
		response.sendRedirect("Admin/jason_loadcity.jsp");
	}
	private void doGetState(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("country_id"));
		System.out.println("id="+id);
		
		country_vo cv = new country_vo();
		cv.setId(id);
		
		state_vo sv = new state_vo();
		sv.setCv(cv);
		
		state_dao sd = new state_dao();
		
		List ls = sd.AJAXsearch(sv);
		
		HttpSession hs = request.getSession();
		
		hs.setAttribute("state_details", ls);
		
		response.sendRedirect("Admin/jason_loadstate.jsp");
	}

	private void loadcountry(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		country_dao cnd = new country_dao();
		
		List ls = cnd.search();
		
		HttpSession hs = request.getSession();
		hs.setAttribute("list2", ls);
	}

	private void loadsrc(HttpServletRequest request,
			HttpServletResponse response, int id) throws IOException {
		// TODO Auto-generated method stub
		reg_dao rd = new reg_dao();
		List ls = rd.loadsrc(id);
		
		HttpSession hs = request.getSession();
		hs.setAttribute("ulist", ls);
		loadcountry(request, response);
		response.sendRedirect("Admin/update_registration_form.jsp");
	}



	private void load(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		reg_dao rd = new reg_dao();
		List ls = rd.search();
		HttpSession session = request.getSession();
		session.setAttribute("list", ls);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1=request.getParameter("nm");
		String s2=request.getParameter("ad");
		String s3=request.getParameter("ct");
		String s4=request.getParameter("st");
		String s5=request.getParameter("cnt");
		String s6=request.getParameter("optionsRadios");
		String s10=request.getParameter("q");
		String s7=request.getParameter("em");
		String s8=request.getParameter("dob");
		double s9=Double.parseDouble(request.getParameter("ph"));
		
		reg_vo rv = new reg_vo();
		rv.setName(s1);
		rv.setAdd(s2);
		rv.setCity(s3);
		rv.setState(s4);
		rv.setCountry(s5);
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		Date dt;
		try {
			dt = df.parse(s8);
			rv.setDob(dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rv.setGender(s6);
		rv.setEmail(s7);
		rv.setPhn(s9);
		rv.setQualification(s10);
		
		String f = request.getParameter("flag");
		
		if (f!=null && f.equals("insert")){
			insert(request, response, rv);
			response.sendRedirect("Admin/form_registration.jsp");
		}
		if (f!=null && f.equals("update"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			rv.setId(id);
			update(request, response, rv);
		}
	}
	
	private void update(HttpServletRequest request,
			HttpServletResponse response, reg_vo rv) throws IOException {
		// TODO Auto-generated method stub
		reg_dao rd = new reg_dao();
		rd.update(rv);
		response.sendRedirect("reg_controller?flag=load");
	}

	public void insert(HttpServletRequest request, HttpServletResponse response, reg_vo rv) throws ServletException{
		reg_dao rd = new reg_dao();
		rd.insert(rv);
	}

}
