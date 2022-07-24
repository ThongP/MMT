/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author gbrid
 */
public class ShutDownCtr {
    private String command;
    public ShutDownCtr(String c) {
        command = c;
    }
    public String sendShutDown() {
       return command;
    }
}
