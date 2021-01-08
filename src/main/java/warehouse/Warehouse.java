package warehouse;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;

//наследуется от ArrayList, чтобы работать с объектами PieceLuck
@Component
public class Warehouse extends ArrayList<PieceLuck>{
    //файл
    private final Path filename;

    //вызываем конструктор и заполняем склад
    public Warehouse(int amount,Path filename) throws IOException {
        super();
        this.filename = filename;
        for(int i=0;i<amount;i++) {
            this.add(new PieceLuck());
        }
        saveStateToFile(size());
    }
    // переопределяем удаление из списка, добавляем запись в файл
    @Override
    public boolean remove(Object o) {
        boolean result = super.remove(o);
        if(result) {
            try {
                saveStateToFile(size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    //переопределяем добавление в список, добавляем запись в файл

    @Override
    public boolean addAll(Collection<? extends PieceLuck> c) {
        boolean result = super.addAll(c);
        if(result){
            try {
                saveStateToFile(size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    //работу с файлом пока не проверял, вероятно надо будет доработать
    private void saveStateToFile(int amount) throws IOException {
        Files.write(filename,String.valueOf(amount).getBytes());
    }
}
