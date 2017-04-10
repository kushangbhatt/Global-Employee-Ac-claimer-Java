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

import sun.security.util.Password;
import DAO.city_dao;
import DAO.country_dao;
import DAO.emp_dtl_dao;
import DAO.login_dao;
import DAO.reg_dao;
import DAO.state_dao;
import VO.city_vo;
import VO.country_vo;
import VO.emp_dtl_vo;
import VO.login_vo;
import VO.state_vo;

/**
 * Servlet implementation class emp_controller
 */
@WebServlet("/emp_controller")
public class emp_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public emp_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f = request.getParameter("flag");
		if(f!=null && f.equals("delete")){
			update(request, response);
		}
		if(f!=null && f.equals("delete")){
			delete(request, response);

		}
		if(f!=null && f.equals("load")){
			load(request, response);

		}
		if (f!=null && f.equals("loadcsc")){
			loadcsc(request, response);
		}
		if(f!=null && f.equals("loadst"))
		{
			doGetState(request, response);
		}
		if(f!=null && f.equals("loadcity"))
		{
			doGetCity(request, response);
		}
		if(f!=null && f.equals("loadsrc"))
		{
			loadsrc(request, response);
		}
	}
	private void loadsrc(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		emp_dtl_vo ev = new emp_dtl_vo();
		ev.setId(Integer.parseInt(request.getParameter("id")));
		emp_dtl_dao e = new emp_dtl_dao();
		List ls = e.loadsrc(ev);
		
		HttpSession hs = request.getSession();
		hs.setAttribute("list", ls);
		response.sendRedirect("Admin/update_employee_dtl_form.jsp");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		emp_dtl_vo ev = new emp_dtl_vo();
		ev.setId(Integer.parseInt(request.getParameter("id")));
		emp_dtl_dao ed = new emp_dtl_dao();
		ed.update(ev);
		response.sendRedirect("emp_controller?flag=load");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		emp_dtl_vo ev = new emp_dtl_vo();
		ev.setId(Integer.parseInt(request.getParameter("id")));
		emp_dtl_dao ed = new emp_dtl_dao();
		ed.delete(ev);
		response.sendRedirect("emp_controller?flag=load");
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
		
		System.out.println(id);
		
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

	private void loadcsc(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		country_dao cnd = new country_dao();

		List ls2 = cnd.search();
		
		HttpSession hs = request.getSession();

		hs.setAttribute("list2", ls2);
		response.sendRedirect("Admin/form_employee_dtl.jsp");
	}

	private void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		emp_dtl_dao ed = new emp_dtl_dao();
		List ls = ed.search();
		HttpSession session = request.getSession();
		session.setAttribute("list", ls);
		response.sendRedirect("Admin/search_employee.jsp");
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
		String s14 = request.getParameter("ps");
		String s8=request.getParameter("dob");
		String s11=request.getParameter("dept");
		String s12=request.getParameter("type");
		int s13=Integer.parseInt(request.getParameter("salary"));
		long s9=Long.parseLong(request.getParameter("ph"));
		
		emp_dtl_vo ev = new emp_dtl_vo();
		ev.setName(s1);
		ev.setAdd(s2);
		ev.setCity(s3);
		ev.setState(s4);
		ev.setCountry(s5);
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		Date dt;
		try {
			dt = df.parse(s8);
			ev.setDob(dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ev.setGender(s6);
		ev.setPhn(s9);
		ev.setQualification(s10);
		ev.setDepartment(s11);
		ev.setSalary(s13);
		
		login_vo lg = new login_vo();
		
		lg.setUname(s7);
		lg.setPass(s14);
		lg.setUtype(s12);
		
		ev.setLogin(lg);
		
		String f = request.getParameter("flag");
		
		if (f!=null && f.equals("insert")){
			insert(request, response, ev, lg);
			response.sendRedirect("Admin/form_employee_dtl.jsp");
		}
	}

	private void insert(HttpServletRequest request,
			HttpServletResponse response, emp_dtl_vo ev, login_vo lg) {
		// TODO Auto-generated method stub
		login_dao ld = new login_dao();
		boolean b = ld.insert(lg);
		if (b == false){
			System.out.println("Duplicate entries not allowed.");
		}
		
		else{
			emp_dtl_dao ed = new emp_dtl_dao();
			ed.insert(ev);
		}
		
	}

}
