package CONTROLLER;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.cat_dao;
import DAO.etype_dao;
import VO.cat_vo;
import VO.examtype_vo;

/**
 * Servlet implementation class cat_controller
 */
@WebServlet("/cat_controller")
public class cat_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cat_controller() {
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
			System.out.println(id);
			loadsrc(request, response, id);
		}
		
		if (f!=null && f.equals("delete")){
			int id = Integer.parseInt(request.getParameter("id"));
			delete(request, response, id);
		}
		if(f!=null && f.equals("loadetype"))
		{
			loadetype(request, response);
			response.sendRedirect("Admin/form_category.jsp");
		}
	}

	private void loadetype(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		etype_dao ed = new etype_dao();
		List ls = ed.search();
		
		HttpSession hs = request.getSession();
		hs.setAttribute("list", ls);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response, int id) throws IOException {
		// TODO Auto-generated method stub
		cat_dao cd = new cat_dao();
		cd.delete(id);
		response.sendRedirect("cat_controller?flag=load");
	}

	private void loadsrc(HttpServletRequest request,
			HttpServletResponse response, int id) throws IOException {
		// TODO Auto-generated method stub

		cat_dao cd = new cat_dao();
		List ls = cd.loadsrc(id);

		HttpSession hs = request.getSession();
		hs.setAttribute("ulist", ls);
		loadetype(request, response);
		response.sendRedirect("Admin/update_category_form.jsp");
	}

	private void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		cat_dao cd = new cat_dao();
		List ls = cd.search();
		HttpSession hs = request.getSession();
		hs.setAttribute("list", ls);

		response.sendRedirect("Admin/search_category.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f = request.getParameter("flag");
		String s1 = request.getParameter("cat");
		String s2 = request.getParameter("desc");
		String s3 = request.getParameter("et");
		
		examtype_vo ev = new examtype_vo();
		ev.setId(Integer.parseInt(s3));
		
		cat_vo cv = new cat_vo();
		
		cv.setCat(s1);
		cv.setDesc(s2);
		cv.setEv(ev);
			
		if (f!=null && f.equals("insert")){
			insert(request, response, cv);
			
		}
		
		if (f!=null && f.equals("update")){
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			cv.setId(id);
			update(request, response, cv);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response, cat_vo cv) throws IOException {
		// TODO Auto-generated method stub
		cat_dao cd = new cat_dao();
		
 		cd.update(cv);
		response.sendRedirect("cat_controller?flag=load");
	}

	private void insert(HttpServletRequest request,
			HttpServletResponse response, cat_vo cv) throws IOException {
		// TODO Auto-generated method stub
		cat_dao cd = new cat_dao();
		cd.insert(cv);
		response.sendRedirect("Admin/form_category.jsp");
	}
}
