package transfer;

import org.springframework.stereotype.Component;
import warehouse.Box;

import java.util.ArrayList;
@Component
public class Truck extends ArrayList<Box> {
    private final int MAX_AMOUNT = 10;

    public boolean isFull(){
        return size()==MAX_AMOUNT;
    }

    public int getMAX_AMOUNT() {
        return MAX_AMOUNT;
    }
}
