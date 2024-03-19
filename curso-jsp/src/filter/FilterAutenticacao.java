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

@WebFilter(urlPatterns = {"/principal/*"}) // Intercepta todas as requisições que vierem do projeto
//Ou mapeamento
public class FilterAutenticacao implements Filter {

	public FilterAutenticacao() {
	}

//Encerra os processos quando o servidor é parado
//Mataria o processo de conexão com o banco
	public void destroy() {
	}

//Intercepta as requisições e as repostas ao sistema
//Tudo que fazer no sistema passa por aqui
//Valdidar e fazer redirecionamentos 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		String usuarioLogado = (String) session.getAttribute("usuario");
		String urlParaAutenticar = req.getServletPath();// Url que esta sendo acessada

//validar se esta logado senão redireciona para tela de login

		if (usuarioLogado == null
				|| (usuarioLogado != null && usuarioLogado.isEmpty()) &&
				!urlParaAutenticar.contains("principal/ServeletLogin")) {//Não esta logado
			
			RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
			request.setAttribute("msg", "Por favor realize o login");
			redireciona.forward(request, response);
			return; //Para a execução e redireciona para o login
			
		}else {

		chain.doFilter(request, response);
		}
		}

//Inicia os processos ou recursos quando o servidor sobe o projeto
//iniciar a conexão com o banco 
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
