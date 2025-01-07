package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

@Configuration//bu classın yapılandırma ayarları verılecek
@ComponentScan("com.tpe")//bu ıcerisine girdiğimiz path'de yer alan tüm componentları arar
//default path : AppConfiguration classın bulundugu path tanımlıdır

@PropertySource("classpath:application.properties1")



public class AppConfiguration {

@Autowired
private Environment environment;

    @Bean//thirdParty classtan bean olusturulmasını saglar
 public Random random (){
     return new Random ();
 }

 @Bean
 public Scanner scanner (){
        return new Scanner(System.in);

 }

 //value anatosyanu ıle yaptıgımız ıslemı envıronment ve propertıes classlarda da yapabılıyoruz
@Bean//build ın class
    public Properties properties(){
        Properties properties =new Properties();
        //properties.put("mymail","techproed@gmail.com");
        properties.put("mymail",environment.getProperty("eposta"));
        properties.put("myphone",environment.getProperty("phone"));
        properties.put("password",environment.getProperty("password.admin"));
        properties.put("database",environment.getProperty("database.url"));
        return properties;
    }

}
