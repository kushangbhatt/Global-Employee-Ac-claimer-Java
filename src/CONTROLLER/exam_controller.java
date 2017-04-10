package CONTROLLER;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import DAO.cat_dao;
import DAO.etype_dao;
import DAO.exam_dao;
import DAO.que_dao;
import DAO.subcat_dao;
import VO.cat_vo;
import VO.exam_vo;
import VO.examtype_vo;
import VO.subcat_vo;

/**
 * Servlet implementation class exam_controller
 */
@WebServlet("/exam_controller")
public class exam_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public exam_controller() {
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
			response.sendRedirect("Admin/search_exam.jsp");
		}
		if (f!=null && f.equals("loadcat")){
			loadcat(request, response);
		}
		if(f!=null && f.equals("loadetype"))
		{
			loadetype(request, response);
			response.sendRedirect("Admin/form_exam.jsp");
		}
		if(f!=null && f.equals("loadsubcat"))
		{
			doGetSubcat(request, response);
		}
		if(f!=null && f.equals("loadsrc"))
		{
			loadsrc(request, response);
		}
		if(f!=null && f.equals("exam")){
			generate(request, response);
		}
	}

	private void generate(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		exam_dao ed = new exam_dao();
		List ls = ed.loadsrc(id);

	}

	private void loadsrc(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		exam_dao ed = new exam_dao();
		List ls = ed.loadsrc(id);
		
		HttpSession hs = request.getSession();
		hs.setAttribute("ulist", ls);
		loadetype(request, response);
		response.sendRedirect("Admin/update_exam_form.jsp");
	}

	private void doGetSubcat(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("cat_id"));
		System.out.println("id="+id);
		
		cat_vo cv = new cat_vo();
		cv.setId(id);
		
		subcat_vo sv = new subcat_vo();
		sv.setC(cv);
		
		subcat_dao sd = new subcat_dao();
		
		List ls = sd.AJAXSearch(sv);
		
		HttpSession hs = request.getSession();
		hs.setAttribute("subcat_details", ls);
		
		response.sendRedirect("Admin/json_subcat.jsp");
	}

	private void loadetype(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		etype_dao ed = new etype_dao();
		List ls = ed.search();
		
		HttpSession hs = request.getSession();
		hs.setAttribute("list", ls);
	}

	private void loadcat(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("e_type_id"));
		examtype_vo ev = new examtype_vo();
		ev.setId(id);
		
		cat_vo cv = new cat_vo();
		cv.setEv(ev);
		
		cat_dao cd = new cat_dao();
		List ls = cd.AJAXSearch(cv);
		HttpSession hs = request.getSession();
		hs.setAttribute("category_details", ls);

		response.sendRedirect("Admin/json_category.jsp");
	}

	private void load(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		exam_dao ed = new exam_dao();
		List ls = ed.search();
		
		HttpSession hs = request.getSession();
		hs.setAttribute("list", ls);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1 = request.getParameter("et");
		String s2 = request.getParameter("ec");
		String s3 = request.getParameter("esc");
		int s4 = Integer.parseInt(request.getParameter("no"));
		int s5 = Integer.parseInt(request.getParameter("etime"));
		String s6 = request.getParameter("ed");
		
		exam_vo exv = new exam_vo();
		exv.setE_name(s1);
		exv.setE_cat(s2);
		exv.setE_subcat(s3);
		exv.setNo_q(s4);
		exv.setE_duration(s5);
		exv.setE_desc(s6);
		
		String f = request.getParameter("flag");
		if(f!=null && f.equals("insert")){
			insert(request, response, exv);
			
			response.sendRedirect("Admin/form_exam.jsp");
		}
	}

	private void insert(HttpServletRequest request,
			HttpServletResponse response, exam_vo exv) {
		// TODO Auto-generated method stub
		exam_dao exd = new exam_dao();
		exd.insert(exv);
	}

}
