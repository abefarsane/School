/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es_invitati3try;

/**
 *
 * @author crist
 */
public class EccezioneFesta extends Exception {

    private String msg = "";

    public EccezioneFesta(String m) {
        this.msg = m;
    }

    public String getMsg() {
        return this.msg;
    }
}
