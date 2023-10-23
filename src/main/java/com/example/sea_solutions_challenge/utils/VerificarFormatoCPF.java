package com.example.sea_solutions_challenge.utils;


public class VerificarFormatoCPF {

     public  Boolean execute (String Cpf) {
         String regex = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})$";

         if (Cpf.matches(regex))  return  true;


         return false;

     }
}
