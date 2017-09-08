package Tags;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author pc
 */
public class HelloTag extends SimpleTagSupport {

  @Override
  public void doTag() throws IOException {
          JspWriter out = getJspContext().getOut();
          out.println("Hello to the coffee machine!");
  }
    
}
