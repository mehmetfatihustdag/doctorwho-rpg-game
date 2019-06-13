package com.company.factory;

/**
 *
 * @author fustdag <br>
 *         <b>Abstract Factory Interface</b>
 *
 */
public interface AbstractFactory<T> {


     /**
      *  <b>Abstract create method</b>
      * @param name name of the character to create
      * @param type enum type of the character to create
      * @return entity which is the type of T
      */
     T create(String name,String type);
}