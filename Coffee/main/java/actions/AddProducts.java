package actions;


import DTO.UserDTO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.ServiceFactory;
import services.ServiceReceive;

public class AddProducts implements Action{
         
    public Boolean makeOrder(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
         HttpSession session = req.getSession();
        if ( session != null && session.getAttribute("user") != null&& 
                ((UserDTO)session.getAttribute("user")).getIsAdmin() == 1){
            ServiceReceive serviceReceive = ServiceFactory.getServiceReceive(); 
            String[] strIngridients = req.getParameterValues("textToSendIngridients");
            String[] dataIngridients = strIngridients[0].split(",");
            ArrayList <Integer> ingIds = new ArrayList();
            for (int i = 0; i < dataIngridients.length;i++){
                if (!dataIngridients[i].isEmpty())
                ingIds.add(Integer.parseInt(dataIngridients[i]));
            }
             String[] strDrinks = req.getParameterValues("textToSendDrinks");
            String[] dataDrinks = strDrinks[0].split(",");
            ArrayList <Integer> drinksIds = new ArrayList();
            for (int i = 0; i < dataDrinks.length;i++){
                if (!dataDrinks[i].isEmpty())
                drinksIds.add(Integer.parseInt(dataDrinks[i]));
            }
            return (serviceReceive.receiveProducts(drinksIds, ingIds));
        }else{
            return false;
        }
          
    }
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (makeOrder(request,response))     return "success";
        else  return "error";
    }
    
}