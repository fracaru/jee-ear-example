package org.example.jee.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.example.jee.service.IService;

/**
 * This Bean is used to initialize things at application server startup and free
 * resources at application server shutdown. By using the @Startup annotation,
 * you can force the container to instantiate the singleton instance during
 * application initialization.
 * 
 * @author AKKA
 */
@Singleton
@Startup
@SuppressWarnings("unused")
public class MyStartupBean {

	@EJB(name = "ejb/HelloService")
	IService service;

	/**
	 * @PostConstruct method that is guaranteed to be called at startup time.
	 */
	@PostConstruct
	private void startup() {
		System.out.println("Loaded " + service.sayHello());
	}

	/**
	 * @PreDestroy method for a singleton is guaranteed to be called when the
	 *             application is shutting down.
	 */
	@PreDestroy
	private void shutdown() {
	}
}