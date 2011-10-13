/**
 * 
 */
package org.example.jee.service.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.example.jee.service.IService;

/**
 * Short Description goes here.
 * <P>
 * Explanation goes here.
 * <P>
 * 
 */
@Remote(IService.class)
@Stateless(mappedName = "ejb/HelloService")
public class ServiceBean implements IService {

	@Override
	public String sayHello() {
		return "Hello World";
	}
}
