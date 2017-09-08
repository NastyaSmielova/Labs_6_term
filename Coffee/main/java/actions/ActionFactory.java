/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pc
 */
public class ActionFactory {
    private static final Map<String, Action> actions;
    static {
        actions = new HashMap();
        actions.put("login", new Login());
        actions.put("addProducts", new AddProducts());
        actions.put("makeOrder", new MakeOrder());
        actions.put("userInit", new InitUser());
        actions.put("adminInit", new InitAdmin());
    }
    
    /**
     * Get appropriate handler by the requested path
     * @param request http request
     * @return handler for the request
     */
    public static Action getAction(String request) {
        return actions.get(request);
    }
}
