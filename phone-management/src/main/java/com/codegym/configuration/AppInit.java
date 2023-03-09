package com.codegym.configuration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new Filter[]{characterEncodingFilter};
    }




//Cau hinh tieng viet spring mvc
// ...    @Override Truyen tai unicode tu html len server
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        FilterRegistration.Dynamic filterRegistration =
//                servletContext.addFilter("encoding-filter", new CharacterEncodingFilter());
//        filterRegistration.setInitParameter("encoding", "UTF-8");
//        filterRegistration.setInitParameter("forceEncoding", "true");
//        //make sure encodingFilter is matched most first, by "false" arg
//        filterRegistration.addMappingForUrlPatterns(null, false, "/*");
//        super.onStartup(servletContext);
//    }
//    //
}