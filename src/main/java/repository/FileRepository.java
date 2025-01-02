package repository;

import domain.Message;

public class FileRepository implements Repository {
    @Override
    public void save(Message message) {
        System.out.println("Mesajınız dosyaya kaydedılıyor ");
    }
}
