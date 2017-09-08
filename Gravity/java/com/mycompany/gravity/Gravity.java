/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gravity;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/gravityendpoint", encoders = {FigureEncoder.class}, decoders = {FigureDecoder.class})
public class Gravity {
    private static final Logger log = Logger.getLogger(Gravity.class.getName());
     private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
    
     
     @OnMessage
    public void broadcastFigure(Figure figure, Session session) throws IOException, EncodeException {
        log.log(Level.INFO, "broadcastFigure:", figure);
        session.getBasicRemote().sendObject(figure);
 
    } 
   
     @OnOpen
    public void onOpen (Session peer) {
        peers.add(peer);
        log.info("add new ");

    }

    @OnClose
    public void onClose (Session peer) {
        peers.remove(peer);
        log.info("close one ");
    }
    
}