/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es_invitati4try;

/**
 *
 * @author abefa
 */
public class FestaException extends Exception{
    private String error = "";
    
    FestaException(String error){
        this.error = error;
    }
    String getError(){
        return error;
    }
}
