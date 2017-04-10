package CONTROLLER;

import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DAO.loanmst_dao;
import DAO.login_dao;
import VO.login_vo;


 

/**
 * Servlet Filter implementation class loginController
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		HttpSession session =((HttpServletRequest) request).getSession();
		RequestDispatcher requestDispatcher;
		String logout = request.getParameter("logout");
		String reg = request.getParameter("reg");
		//System.out.println("registration flag===" + reg);
		//	int i = (Integer)session.getAttribute("userID");
		//System.out.println("id = = = = =" + i);
		String uri = ((HttpServletRequest)request).getRequestURI();
		
		
		System.out.println("link =  = = = = " + uri);
		
		if(uri.contains("register")||uri.contains("/Css") || uri.contains("/Js")&&!uri.contains("/jsp")|| uri.contains("/Images")|| uri.contains("/fonts"))
		{
			System.out.println("inside reg!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			
			//requestDispatcher = request.getRequestDispatcher("/user/register.jsp");  
			//requestDispatcher.forward(request,response);  
			
			chain.doFilter(request,response);
			
		}
		
		else if (logout!= null) {
			//session.removeAttribute("userID");
			System.out.println("logout in else if");
		
			session.invalidate();
			System.out.println("after session invalidates");
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/Admin/login.jsp");
			rd.forward(request, response);
			
		}
		
		else if(request.getParameter("flag") != null && request.getParameter("flag").equals("login") )
		{
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			System.out.println(userName+""+password);
			
			login_vo lgin = new login_vo();
			lgin.setUname(userName);
			lgin.setPass(password);
			
			login_dao ld = new login_dao();
			List list = ld.authentication(lgin);
		
			if(list != null && list.size()>=1){
				
				Iterator itr = list.iterator();
				
				//while(itr.hasNext()){
				login_vo user = (login_vo) itr.next();
				
				int y = (Integer)user.getU_id();
				session.setAttribute("userID",y);
				System.out.println(y);
				System.out.println(user.getUtype());
			//	System.out.println(session.getAttribute("userId"));
				String type = user.getUtype();
				session.setAttribute("usertype",type);
				System.out.println(y);
				if(type.equals("EMP"))
				{
				requestDispatcher = request.getRequestDispatcher("/Employee/index.jsp");  
				requestDispatcher.forward(request,response);  
				}
				else if (type.equals("HR"))
				{
					loanmst_dao loan = new loanmst_dao();
					List ls = loan.loansrc();
					HttpSession hs = ((HttpServletRequest)request).getSession();
					hs.setAttribute("loanlist", ls);
					requestDispatcher = request.getRequestDispatcher("/Admin/index.jsp");  
					requestDispatcher.forward(request,response);  
				}
				}
			
			else{
					requestDispatcher = request.getRequestDispatcher("/Admin/login.jsp");  
					requestDispatcher.forward(request,response);  		
				}	
		}
		
		else if(session.getAttribute("userID") != null)
		{
			String h = (String)session.getAttribute("usertype");
			System.out.println("type = = = " + h);
			
			if(h!=null && h.equals("HR") || uri.contains("/Admin")){
				
			System.out.println("chain");
			chain.doFilter(request,response);
			}
			
			else if(h!=null && h.equals("EMP") || uri.contains("/Employee"))
			{
				System.out.println("chain");
				chain.doFilter(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("/user/error.jsp");  
				rd.forward(request,response);  
			}
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/Admin/login.jsp");  
			rd.forward(request,response);  
			
			}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
