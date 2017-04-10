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

import DAO.leavemst_dao;
import DAO.reg_dao;
import VO.leavedtl_vo;
import VO.leavemst_vo;

/**
 * Servlet implementation class leave_controller
 */
@WebServlet("/leave_controller")
public class leave_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public leave_controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f = request.getParameter("flag");
		leavemst_vo lv = new leavemst_vo();

		if (f != null && f.equals("load")) {
			load(request, response);
			response.sendRedirect("Admin/search_leave.jsp");
		}
		
		if (f != null && f.equals("loadE")) {
			loadE(request, response);
			response.sendRedirect("Employee/search_leavedtl.jsp");
		}

		if (f != null && f.equals("loadsrc")) {
			int id = Integer.parseInt(request.getParameter("id"));

			loadsrc(request, response, id);
			response.sendRedirect("Admin/update_leavemst_form.jsp");
		}

		if (f != null && f.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			lv.setId(id);

			delete(request, response, lv);

		}
		if(f!=null && f.equals("loadleave"))
		{
			load(request, response);
			response.sendRedirect("Employee/form_leavedtl.jsp");
		}
		if(f!=null && f.equals("loadallowdate"))
		{
			doGetDate(request, response);
		}
	}

	private void loadE(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		leavemst_dao ld = new leavemst_dao();
		List ls = ld.searchE();
		HttpSession hs = request.getSession();
		hs.setAttribute("list", ls);
	}

	private void doGetDate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("Leave_id"));
		System.out.println(id);
		
		leavemst_dao ld = new leavemst_dao();
		List ls = ld.loadsrc(id);
		HttpSession hs = request.getSession();
		hs.setAttribute("leave_details", ls);
		response.sendRedirect("Employee/json_leavedtl.jsp");
	}

	private void delete(HttpServletRequest request,
			HttpServletResponse response, leavemst_vo lv) throws IOException {
		// TODO Auto-generated method stub
		leavemst_dao ld = new leavemst_dao();
		ld.delete(lv);
		response.sendRedirect("leave_controller?flag=load");
	}

	private void loadsrc(HttpServletRequest request,
			HttpServletResponse response, int id) throws IOException {
		// TODO Auto-generated method stub
		leavemst_dao ld = new leavemst_dao();
		List ls = ld.loadsrc(id);

		HttpSession hs = request.getSession();
		hs.setAttribute("ulist", ls);

	}

	private void load(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		leavemst_dao ld = new leavemst_dao();
		List ls = ld.search();
		HttpSession session = request.getSession();
		session.setAttribute("list", ls);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1 = request.getParameter("lt");
		
		String s3 = request.getParameter("ld");

		leavemst_vo lv = new leavemst_vo();
		lv.setLeave_type(s1);
		lv.setLeave_desc(s3);
		
		
		
		
		String f = request.getParameter("flag");
		if (f != null && f.equals("insert")) {
			int s2 = Integer.parseInt(request.getParameter("no"));
			lv.setLeave_no(s2);
			insert(request, response, lv);
		}

		if (f != null && f.equals("update")) {
			int s2 = Integer.parseInt(request.getParameter("no"));
			int id = Integer.parseInt(request.getParameter("id"));
			lv.setLeave_no(s2);
			lv.setId(id);
			update(request, response, lv);
		}
		if(f!=null && f.equals("insertE")){
			leavedtl_vo lv1 = new leavedtl_vo();
			lv1.setDesc(request.getParameter("ld"));
			
			String d1 = request.getParameter("fd");
			String d2 = request.getParameter("td");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dt1 = df.parse(d1);
				Date dt2 = df.parse(d2);
				lv1.setD1(dt1);
				lv1.setD2(dt2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			lv.setId(Integer.parseInt(request.getParameter("lt")));
			
			lv1.setLv(lv);
			insertE(request, response, lv1);
			
		}
	}

	private void insertE(HttpServletRequest request,
			HttpServletResponse response, leavedtl_vo ld) throws IOException {
		// TODO Auto-generated method stub
		leavemst_dao ld1 = new leavemst_dao();
		ld1.insertE(ld);
		response.sendRedirect("Employee/form_leavedtl.jsp");
	}

	private void update(HttpServletRequest request,
			HttpServletResponse response, leavemst_vo lv) throws IOException {
		// TODO Auto-generated method stub
		leavemst_dao ld = new leavemst_dao();
		ld.update(lv);

		response.sendRedirect("leave_controller?flag=load");
	}

	private void insert(HttpServletRequest request,
			HttpServletResponse response, leavemst_vo lv) throws IOException {
		// TODO Auto-generated method stub
		leavemst_dao ld = new leavemst_dao();
		ld.insert(lv);
		response.sendRedirect("Admin/form_leavemst.jsp");
	}

}
