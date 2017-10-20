package utng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utng.dom.ClouserDOM;
import utng.model.Clouser;
/**
 * Servlet implementation class ClouserController
 */
@WebServlet("/ClouserController")
public class ClouserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Clouser clouser;
	private List<Clouser> clousers;
	private ClouserDOM clouserDOM;

	private List<String> ids = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	// Inicializacion de objetos
	public ClouserController() {
		super();
		clouser = new Clouser();
		clousers = new ArrayList<Clouser>();
		clouserDOM = new ClouserDOM();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("btn_save") != null) {

			clouser.setName(request.getParameter("name"));
			clouser.setCreationDate(request.getParameter("creationDate"));
			clouser.setModificationDate(request.getParameter("modificationDate"));
			clouser.setUsername(request.getParameter("username"));

			if (clouser.getId() == "") {

				String newId = "Clo" + String.format("%02d", 1);
				clouser.setId(newId);
				if (clousers.size() > 0) {
					ids.clear();
					for (Clouser s : clousers) {
						ids.add(s.getId());
					}
					for (int i = 0; i <= ids.size(); i++) {
						newId = "Clo" + String.format("%02d", i + 1);
						if (!ids.contains(newId)) {
							clouser.setId(newId);
							break;
						}
					}
				}

				clouserDOM.add(clouser);
			} else {
				clouserDOM.update(clouser);
			}

			clousers = clouserDOM.getClousers();

			request.setAttribute("clousers", clousers);
			request.getRequestDispatcher("clouser_list.jsp").forward(request, response);

		} else if (request.getParameter("btn_new") != null) {
			clouser = new Clouser();
			request.getRequestDispatcher("clouser_form.jsp").forward(request, response);
		} else if (request.getParameter("btn_edit") != null) {
			try {

				String id = request.getParameter("id");
				clouser = clouserDOM.findById(id);

			} catch (Exception e) {
				clouser = new Clouser();
			}
			request.setAttribute("clouser", clouser);
			request.getRequestDispatcher("clouser_form.jsp").forward(request, response);

		} else if (request.getParameter("btn_delete") != null) {
			try {
				String id = request.getParameter("id");
				clouserDOM.delete(id);
				clousers = clouserDOM.getClousers();
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("clousers", clousers);
			request.getRequestDispatcher("clouser_list.jsp").forward(request, response);
		} else {
			clousers = clouserDOM.getClousers();
			request.setAttribute("clousers", clousers);
			request.getRequestDispatcher("clouser_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}