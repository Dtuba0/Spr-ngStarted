package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.tpe.repository.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component//bu classın objelerı sprıng tarafından olusturulacak ve yonetılıcek
//sprıng bean adı verılır

public class SmsService  implements MessageService{

    //field enjection
//    @Autowired//bagımlılıgın enjekte edılmesını sagladım
//    @Qualifier("dbRepository")//birden fazla aynı data tipinde bean varsa belirleyici kullanıyoruz
//    private Repository repo;


   //---------------------------------------------------------------------
//    //setter enjectıon
//    private Repository repo;
//    @Autowired
//    @Qualifier("fileRepository ")
//    public void setRepo(Repository repo){
//        this.repo=repo;
//    }


//    ----------------------------------------------------

    //constructer enjection : daha guvenli daha anlasılır ve test etmesı daha kolay
    private Repository repo;

    @Autowired
    public SmsService(@Qualifier("dbRepository")Repository repo){
        this.repo= repo;
    }




    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajınız sms ile gönderiliyor. Mesaj : "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {
    repo.save(message);
    }

    @PostConstruct
    public void postContructor(){
        System.out.println("-----------Sms service objesi oluşturuldu");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("-----------Sms service objesi imha edildi");
    }
}
