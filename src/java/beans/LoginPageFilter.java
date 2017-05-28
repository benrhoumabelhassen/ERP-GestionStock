/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.FilterDefinition;

/**
 *
 * @author benrh
 */
public class LoginPageFilter implements Filter
{
   public void init(FilterConfig filterConfig) throws ServletException
   {

   }

   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,   FilterChain filterChain) throws IOException, ServletException
   {
       HttpServletRequest request = (HttpServletRequest) servletRequest;
       HttpServletResponse response = (HttpServletResponse) servletResponse;

       if(request.getUserPrincipal() != null){ //If user is already authenticated
           response.sendRedirect("/index.xhtml");// or, forward using RequestDispatcher
       } else{
           filterChain.doFilter(servletRequest, servletResponse);
       }
   }

   public void destroy()
   {

   }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FilterDefinition getFilterDefinition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Filter setParameter(String string, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Filter setParameterList(String string, Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Filter setParameterList(String string, Object[] os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void validate() throws HibernateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
