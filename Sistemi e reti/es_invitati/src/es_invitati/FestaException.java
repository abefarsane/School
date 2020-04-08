/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es_invitati;

/**
 *
 * @author abefa
 */
public class FestaException extends Exception{
    FestaException(String messaggio){
        System.out.println(messaggio);
    }
}
