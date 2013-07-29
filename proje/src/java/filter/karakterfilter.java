/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

/**
 *
 * @author tugdev
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class karakterfilter implements Filter{

  
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

  
    public void doFilter(ServletRequest requset, 
ServletResponse response, FilterChain chain) 
throws IOException, ServletException {

        // TODO Auto-generated method stub
        requset.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(requset, response);
    }


    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        
    }

}