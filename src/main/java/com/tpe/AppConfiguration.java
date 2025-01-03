package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.Scanner;

@Configuration//bu classın yapılandırma ayarları verılecek
@ComponentScan("com.tpe")//bu ıcerisine girdiğimiz path'de yer alan tüm componentları arar
//default path : AppConfiguration classın bulundugu path tanımlıdır

public class AppConfiguration {

    @Bean//thirdParty classtan bean olusturulmasını saglar
 public Random random (){
     return new Random ();
 }

 @Bean
 public Scanner scanner (){
        return new Scanner(System.in);

 }

}
