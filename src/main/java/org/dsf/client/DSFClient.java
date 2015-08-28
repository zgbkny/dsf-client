package org.dsf.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class DSFClient {
	public String interfaceName;
	public String version;
	public String group;
	
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	
	public void init() {
		System.out.println("DSFClient init" + interfaceName + ";" + version + ";" + group);
		
	}
	
	public <T> T init2() throws ClassNotFoundException {
		Class clazz = Class.forName(interfaceName);
		InvocationHandler handler = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("invoke " + method.getName());
				
				return null;
			}
		};
		T t = (T) Proxy.newProxyInstance(DSFClient.class.getClassLoader(), new Class[] {clazz}, handler);
		return t;
	}
}
