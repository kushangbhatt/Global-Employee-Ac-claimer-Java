package CONTROLLER;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.cat_vo;
import VO.examtype_vo;
import VO.subcat_vo;
import DAO.cat_dao;
import DAO.etype_dao;
import DAO.subcat_dao;

/**
 * Servlet implementation class subcat_controller
 */
@WebServlet("/subcat_controller")
public class subcat_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public subcat_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f = request.getParameter("flag");
		
		if (f!=null && f.equals("loadcat")){
			loadcat(request, response);
		}
		
		if (f!=null && f.equals("load")){
			load(request, response);
		}
		
		if (f!=null && f.equals("loadsrc")){
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			loadsrc(request, response, id);
			
		}
		
		if (f!=null && f.equals("delete")){
			int id = Integer.parseInt(request.getParameter("id"));
			subcat_vo sv = new subcat_vo();
			sv.setId(id);
			delete(request, response, sv);
		}
		if(f!=null && f.equals("loadetype"))
		{
			loadetype(request, response);
			response.sendRedirect("Admin/form_subcategory.jsp");
		}
	}

	private void loadetype(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		etype_dao ed = new etype_dao();
		List ls = ed.search();
		
		HttpSession hs = request.getSession();
		hs.setAttribute("list", ls);
	}

	private void delete(HttpServletRequest request,
			HttpServletResponse response, subcat_vo sv) throws IOException {
		// TODO Auto-generated method stub
		subcat_dao sd = new subcat_dao();
		sd.delete(sv);
		
		response.sendRedirect("subcat_controller?flag=load");
	}

	private void loadsrc(HttpServletRequest request,
			HttpServletResponse response, int id) throws IOException {
		// TODO Auto-generated method stub
		subcat_dao sv = new subcat_dao();
		List ls = sv.loadsrc(id);
		HttpSession hs = request.getSession();
		hs.setAttribute("ulist", ls);
		
		loadetype(request, response);
		response.sendRedirect("Admin/update_subcategory_form.jsp");
	}

	private void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		subcat_dao sv = new subcat_dao();
		List ls = sv.search();
		HttpSession hs = request.getSession();
		hs.setAttribute("ulist", ls);

		response.sendRedirect("Admin/search_subcat.jsp");
	}

	private void loadcat(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1 = request.getParameter("ec");
		String s2 = request.getParameter("subcat");
		String s3 = request.getParameter("desc");
		String s4 = request.getParameter("et");
		String f = request.getParameter("flag");
		
		cat_vo cv = new cat_vo();
		
		cv.setId(Integer.parseInt(s1));
		examtype_vo ev = new examtype_vo();
		ev.setId(Integer.parseInt(s4));
		
		subcat_vo sv = new subcat_vo();
		sv.setSubcat(s2);
		sv.setDesc(s3);
		sv.setC(cv);
		sv.setEv(ev);
		 
		if (f!=null && f.equals("insert"))
		{
			insert(request, response, sv);
		}
		
		if (f!=null && f.equals("update")){
			int id = Integer.parseInt(request.getParameter("id"));
			sv.setId(id);
			update(request, response, sv);
		}
	}



	private void update(HttpServletRequest request,
			HttpServletResponse response, subcat_vo sv) throws IOException {
		// TODO Auto-generated method stub
		subcat_dao sd = new subcat_dao();
		sd.update(sv);
		response.sendRedirect("subcat_controller?flag=load");
	}

	private void insert(HttpServletRequest request, HttpServletResponse response, subcat_vo sv ) throws IOException {
		// TODO Auto-generated method stub
		subcat_dao sd = new subcat_dao();
		sd.insert(sv);
		response.sendRedirect("Admin/form_subcategory.jsp");
	}
}
