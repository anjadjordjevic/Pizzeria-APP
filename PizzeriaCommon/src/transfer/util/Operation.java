/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.util;

/**
 *
 * @author Korisnik
 */
public interface Operation {

    public static final int LOGIN = 0;

    public static final int ADD_ADMIN = 1;
    public static final int DELETE_ADMIN = 2;
    public static final int UPDATE_ADMIN = 3;
    public static final int GET_ALL_ADMIN = 4;

    public static final int ADD_PIZZA = 5;
    public static final int DELETE_PIZZA = 6;
    public static final int UPDATE_PIZZA = 7;
    public static final int GET_ALL_PIZZA = 8;

    public static final int GET_ALL_SASTOJAK = 9;

    public static final int ADD_RACUN = 10;
    public static final int GET_ALL_RACUN = 11;

    public static final int GET_ALL_STAVKA_RACUNA = 12;
    
    public static final int GET_ALL_VRSTA_PIZZE = 13;

}
