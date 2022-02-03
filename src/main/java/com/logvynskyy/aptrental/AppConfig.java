//package com.logvynskyy.aptrental;
//
//import org.springframework.entities.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
////public class AppConfig implements WebApplicationInitializer {
////
////    @Override
////    public void onStartup(ServletContext servletContext) throws ServletException {
////        // Load Spring web application configuration
//////        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//////        context.register(AppConfig.class);
////
////        // Create and register the DispatcherServlet
//////        DispatcherServlet servlet = new DispatcherServlet(context);
////        DispatcherServlet servlet = new DispatcherServlet();
////        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcherServlet", servlet);
////        registration.setLoadOnStartup(1);
////        registration.addMapping("/");
////    }
////}
//
//@EnableWebMvc
//@Configuration
//@ComponentScan({"com.logvynskyy.aptrental.controllers"})
//public class AppConfig {
//    private final ApplicationContext applicationContext;
//
//    @Autowired
//    public AppConfig(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }
//}
