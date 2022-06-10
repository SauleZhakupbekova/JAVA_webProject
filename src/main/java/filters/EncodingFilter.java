/*for tomcat automize choose Add new configuration --> Tomcat server --> local --> give name "START" --> Appcation Server --> "bottom "Configuration" --> "Downloads User Tomcat OK" --> Deployment --> Fixed (below) -->JAVA 2829 war--> Application Context" empty --> apply --> ok --> */

package filters;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    @Override /*is used when tomcat is caused*/
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override /*is used before controller. This filter should be switched on. It is done in file "web.xml" in section WEB-INFO*/
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override /*is used when tomcat is caused*/
    public void destroy() {

    }
}
