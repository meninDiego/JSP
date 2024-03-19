package filter;

import java.io.IOException;
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

@WebFilter(urlPatterns = {"/principal/*"}) // Intercepta todas as requisi��es que vierem do projeto
//Ou mapeamento
public class FilterAutenticacao implements Filter {

	public FilterAutenticacao() {
	}

//Encerra os processos quando o servidor � parado
//Mataria o processo de conex�o com o banco
	public void destroy() {
	}

//Intercepta as requisi��es e as repostas ao sistema
//Tudo que fazer no sistema passa por aqui
//Valdidar e fazer redirecionamentos 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		String usuarioLogado = (String) session.getAttribute("usuario");
		String urlParaAutenticar = req.getServletPath();// Url que esta sendo acessada

//validar se esta logado sen�o redireciona para tela de login

		if (usuarioLogado == null
				|| (usuarioLogado != null && usuarioLogado.isEmpty()) &&
				!urlParaAutenticar.contains("principal/ServeletLogin")) {//N�o esta logado
			
			RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
			request.setAttribute("msg", "Por favor realize o login");
			redireciona.forward(request, response);
			return; //Para a execu��o e redireciona para o login
			
		}else {

		chain.doFilter(request, response);
		}
		}

//Inicia os processos ou recursos quando o servidor sobe o projeto
//iniciar a conex�o com o banco 
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
