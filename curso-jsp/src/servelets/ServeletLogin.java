package servelets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelLogin;

//Os chamados controller são as servelets ou ServeletLoginController
@WebServlet("/ServeletLogin") // Mapeamento de url que em da tela
public class ServeletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServeletLogin() {
		super();

	}

//Recebe os dados da url em parametros 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

	}

// Recebe os dados da url por um formulario 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//Aqui nos transformamos em variaveis 
		
	String login = request.getParameter("login");
	String senha = request.getParameter("senha");
	
	if(login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
		
//Aqui fazemos uma instancia e setamos o login e senha no model
//Passando da tela e criando no back
//E so acontece se login e senha for diferente de null e vazio
		ModelLogin modelLogin = new ModelLogin();
		modelLogin.setLogin(login);
		modelLogin.setSenha(senha);
		
	}else {
		RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
		request.setAttribute("msg", "Informe o login e senha corretamente! ");
		redirecionar.forward(request, response);
	}

	
	}

}
