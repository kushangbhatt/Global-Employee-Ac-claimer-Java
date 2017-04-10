package CONTROLLER;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.etype_dao;
import VO.examtype_vo;

/**
 * Servlet implementation class etype_controller
 */
@WebServlet("/etype_controller")
public class etype_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public etype_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f = request.getParameter("flag");
		if (f!= null && f.equals("load"))
		{
			load(request, response);
		}
		if(f!=null && f.equals("loadsrc"))
		{
			loadsrc(request, response);
		}
		if(f!=null && f.equals("delete"))
		{
			delete(request,response);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		etype_dao ed = new etype_dao();
		ed.delete(id);
		response.sendRedirect("etype_controller?flag=load");
	}

	private void loadsrc(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		examtype_vo ev = new examtype_vo();
		ev.setId(id);
		
		etype_dao ed = new etype_dao();
		List ls = ed.loadsrc(ev);
		
		HttpSession hs = request.getSession();
		hs.setAttribute("ulist", ls);
		response.sendRedirect("Admin/update_examtype_form.jsp");
	}

	private void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		etype_dao ed = new etype_dao();
		List ls = ed.search();
		
		HttpSession hs = request.getSession();
		hs.setAttribute("list", ls);
		response.sendRedirect("Admin/search_examtype.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String  f = request.getParameter("flag");
		String e1 = request.getParameter("et");
		String e2 = request.getParameter("e_desc");
		
		examtype_vo ev = new examtype_vo();
		
		ev.setE_type(e1);
		ev.setE_desc(e2);
		
		if(f!=null && f.equals("insert"))
		{
			insert(request, response, ev);
		}
		if(f!=null && f.equals("update"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			ev.setId(id);
			update(request, response, ev);
		}
	}


	private void update(HttpServletRequest request,
			HttpServletResponse response, examtype_vo ev) throws IOException {
		// TODO Auto-generated method stub
		etype_dao ed = new etype_dao();
		ed.update(ev);
		response.sendRedirect("etype_controller?flag=load");
	}

	private void insert(HttpServletRequest request,
			HttpServletResponse response, examtype_vo ev) throws IOException {
		// TODO Auto-generated method stub
		etype_dao ed = new etype_dao();
		ed.insert(ev);
		response.sendRedirect("Admin/form_examtype.jsp");
	}

}
