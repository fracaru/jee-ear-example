package org.example.jee.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.example.jee.service.IService;

/**
 * Short Description goes here.
 * <P>
 * Explanation goes here.
 * <P>
 * 
 */

public class TestServiceEjb {
	public static void main(String args[]) {

		// EJB lookup
		Properties props = new Properties();

		props.setProperty("java.naming.factory.initial",
				"com.sun.enterprise.naming.SerialInitContextFactory");

		props.setProperty("java.naming.factory.url.pkgs",
				"com.sun.enterprise.naming");

		props.setProperty("java.naming.factory.state",
				"com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

		// Optional. Defaults to localhost. Only needed if web server is running
		// on a different host than the appserver
		props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");

		// optional. Defaults to 3700. Only needed if target orb port is not
		// 3700.
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

		// Build the context
		Context ctx;
		try {
			ctx = new InitialContext(props);

			String portableJNDIName = "java:global/myproject-gf/project-server-ejb-gf-1.0-SNAPSHOT/ServiceBean";
			String nonPortableJNDIName = "ejb/HelloService";

			IService ejb = (IService) ctx.lookup(portableJNDIName);
			System.out.println(ejb.sayHello());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}