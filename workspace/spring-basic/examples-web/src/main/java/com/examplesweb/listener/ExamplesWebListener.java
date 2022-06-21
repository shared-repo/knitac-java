package com.examplesweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener // web.xml 파일의 <listener 설정과 같은 역할
public class ExamplesWebListener implements ServletContextListener, HttpSessionListener {

    public ExamplesWebListener() {
        // TODO Auto-generated constructor stub
    }
    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("1. 서버 시작");
    }    
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("2. 세션 시작 (브라우저를 열어서 처음 요청한 경우)");
    }
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("3. 세션 종료");
    }
    public void contextDestroyed(ServletContextEvent sce)  {
    	System.out.println("4. 서버 종료");

    }


	
}
