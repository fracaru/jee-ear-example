package org.example.jee.service.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.jee.service.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Short Description goes here.
 * <P>
 * Explanation goes here.
 * <P>
 * 
 */
public class InitServlet extends javax.servlet.http.HttpServlet {

	@EJB(name = "ejb/HelloService")
	IService service;
	/**
	 * 
	 */
	private static final long serialVersionUID = 5819860074400891907L;
	/**
	 * The logger.
	 */
	private static Logger logger = LoggerFactory.getLogger(InitServlet.class);

	/**
	 * {@inheritDoc}
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = null;
		if (service != null) {
			msg = service.sayHello();
		}
		response.getWriter().write("Servlet says : " + msg);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig cfg) throws ServletException {
		super.init(cfg);
		logger.info("InitServlet: System init completed."); //$NON-NLS-1$
	}

	/**
	 * This method is called when the servlet container is shut down.
	 */
	@Override
	public void destroy() {
		logger.info("InitServlet: System shutdown completed."); //$NON-NLS-1$
	}

}
