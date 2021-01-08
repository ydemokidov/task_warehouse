package warehouse;

import java.util.ArrayList;

public class Box extends ArrayList<PieceLuck> {
    private final int MAX_AMOUNT = 4;

    public boolean isFull(){
        return size()==MAX_AMOUNT;
    }
}
