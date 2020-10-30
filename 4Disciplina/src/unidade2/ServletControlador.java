package unidade2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class ServletControlador
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletControlador() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	super.init();
    	ServletContext context = getServletContext();
    	context.setAttribute("classe", getClass());
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		
		HttpSession session = request.getSession();
		session.setAttribute("cpf", cpf);
		session.setAttribute("senha", senha);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ServletLeitor");
		dispatcher.forward(request, response);
		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<HTML>");
//		out.println("<HEAD><TITLE>Servlet</TITLE></HEAD>");
//		out.println("<BODY>");
//		out.print("CPF: " +cpf);
//		out.print(" Senha: " +senha);
//		out.println(" </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
		
		
		
	}

}
