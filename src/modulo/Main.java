/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Armando Carvajal
 */
public class Main {
    
    public static void main(String[] args) {
        
        //Clases y API
        
        Scanner entrada = new Scanner(System.in);
        
        //----------------------
        
        
        //Programa
        System.out.println("Reglas: \nS -> aA \nA -> Sb \nA -> b");
        System.out.println("Cadena a evaluar");
        String cadena = entrada.nextLine();
        
        Main validar = new Main();
        
        validar.validador(cadena);
        
        if(validar.validador(cadena) == true)
            System.out.println("Cadena Valida");
        else
            System.out.println("Cadena Invalida");
        
        
        //----------------------     
    }
    
    
    public boolean validador(String cadena){
        
        /*
        Reglas:
        S -> aA
        A -> Sb
        S -> b
        
        */
        
        //Clases y API
        
        Stack pila = new Stack();
        
        //Programa 
        
        if(cadena.length() == 0 && cadena.length()%2!=0){
            return false;
        }
        
        for (int i = 0; i < cadena.length(); i++) {
            switch(cadena.charAt(i)){
                case 'a':
                    if (cadena.charAt(i) == 'a') {
                        pila.push(cadena.charAt(i));
                    }
                    break;
                case 'b':
                    
                    //Validar la b que debe entrar
                    if (pila.peek().equals('a')) 
                        pila.push('A');
                    else
                        pila.push(pila.push(cadena.charAt(i)));
                    //----------------------------
                    
                    
                    //Validación de S -> aA
                    if (pila.peek().equals('A')) {
                        pila.pop();
                        if (pila.peek().equals('a')) {
                            pila.pop();
                            pila.push('S');
                        }else{
                            pila.push('A');
                        }   
                    }
                    //--------------------------
                    
                    //Validación A -> Sb
                    if (pila.peek().equals('b')) {
                        pila.pop();
                        if (pila.peek().equals('S')) {
                            pila.pop();
                            pila.push('A');
                        }else
                            pila.push('b');
                    }
                    //-------------------                    
                    break;
                default:
                    return false;
            }                    
        }
        
        if (pila.empty() == true) {
            return true;
        }else{
            if (pila.peek().equals('S')) {
                    pila.pop();
            }
            if(pila.empty()) {
                return true;
            }else{
                return false;
            }
        } 
        
    }
    
}
