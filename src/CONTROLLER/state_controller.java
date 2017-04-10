package CONTROLLER;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.country_vo;
import VO.state_vo;
import DAO.country_dao;
import DAO.state_dao;

/**
 * Servlet implementation class state_controller
 */
@WebServlet("/state_controller")
public class state_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public state_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f = request.getParameter("flag");
		if(f!=null && f.equals("loadcnt")){
			loadst(request, response);
		}
		if(f!=null && f.equals("load")){
			load(request, response);
		}
	}

	private void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		state_dao sd = new state_dao();
		List ls = sd.search();
		
		HttpSession hs = request.getSession();
		hs.setAttribute("list", ls);
		response.sendRedirect("Admin/search_state.jsp");
	}

	private void loadst(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		country_dao cd = new country_dao();
		List ls = cd.search();
		
		HttpSession hs = request.getSession();
		hs.setAttribute("list", ls);
		response.sendRedirect("Admin/form_state.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f = request.getParameter("flag");
		String s1 = request.getParameter("st");
		String s2 = request.getParameter("sd");
		String s3 = request.getParameter("cnt");
		
		country_vo cv = new  country_vo();
		cv.setId(Integer.parseInt(s3));
		
		state_vo sv = new state_vo();
		sv.setCv(cv);
		sv.setState(s1);
		sv.setSt_desc(s2);
		
		if (f!=null && f.equals("insert")){
			insert(request, response, sv);
		}
	}

	private void insert(HttpServletRequest request,
			HttpServletResponse response, state_vo sv) throws IOException {
		// TODO Auto-generated method stub
		state_dao sd = new state_dao();
		sd.insert(sv);
		response.sendRedirect("Admin/form_state.jsp");
	}

}
	