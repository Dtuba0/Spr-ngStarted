package com.tpe.controller;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MessageService;
import com.tpe.service.SlackService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.tpe.repository.Repository;

import java.util.Random;

public class MessageApplicationWithSpring {
    public static void main(String[] args) {

      Message message = new Message ();
      message.setBody("Welcome SPRİNG :) ");


        //config classını okur ve componentscan ile componentlari(bizim olusturdugumuz classlarda)
        // ve beanleri(bizim olusturmadigimiz classlarda) tarar
        //sadece 1 tane spring bean olusturur ve context atar ve hazır olarak bekletir
        //bean istendiginde gerekliyse icine bagimliginini enjekte ederek gonderir

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);

//      //mesajı sms ile gonderelim objeye ihtiyacım var
//
       MessageService service1 = context.getBean(SmsService.class);//new kullanmadık , getbean obje getırırmısın
       service1.sendMessage(message);
//
//
        MessageService service2=context.getBean("slack_service" ,MessageService.class);//sms service
       service2.sendMessage(message);
//        //getbean methodunda parametre olarak paretntı verırsek ve eger bırden fazla chıld component edılmıs ıse bu durumda
//      //beanın ismini belirtmeliyiz
//
//        //slack ile gonderelim
        MessageService service3=context.getBean(SlackService.class);//slack service
        service3.sendMessage(message);

//
      MessageService service4 = context.getBean(SmsService.class);
      service4.sendMessage(message);
     service4.saveMessage(message);//file
//      //smsService newlemedim
//      //service repoya bagımlı ama bız enjekte etmedık
//      //repo objesını de olusturmadık
//      //sprıng SAGOLSUN



        //random bir deger üretip yazdıralım
       // Random rnd = new Random();//bir kere new key word kullanıldı
        Random rnd = context.getBean(Random.class);
        System.out.println("random deger : "+rnd.nextInt(100));

        MessageService service5 = context.getBean(SlackService.class);
        service5.saveMessage(message);

        MessageService service6 = context.getBean(SlackService.class);
        MessageService service7 = context.getBean(SlackService.class);

//        MessageService service8=new SlackService();//yenı bir obje olusturuldu
//        MessageService service9=new SlackService();//kopya deger



        if(service6==service7){
            System.out.println("Aynı objeler");
            System.out.println(service6);
            System.out.println(service7);
        }else{
            System.out.println("Farklı objeler");
            System.out.println(service6);
            System.out.println(service7);
        }
        context.close();



//      MessageService service8=context.getBean(SlackService.class);
//      service8.saveMessage(message);

        //default olarak singleton oluyor : bu classtan sadece bir tane bean uretiyor ve her seferinde bu beani cagiriyor!!!
        //bu olusturulan bean'in life cycle'ini Spring yonetir ve Spring Sorumludur!!!

        //prototype olarak degistirebiliriz : bu ise classtan her cagrildiginda farkli bir obje uretmeyi saglar!!!
        //Beanlerin imhasından Spring sorumlu degildir








    }


}
