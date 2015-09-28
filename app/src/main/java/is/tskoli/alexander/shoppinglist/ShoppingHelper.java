package is.tskoli.alexander.shoppinglist;

import java.util.ArrayList;

/**
 * Created by alexander on 27.9.2015.
 */
public class ShoppingHelper {

    private static ArrayList<ShoppingItem> items = new ArrayList<ShoppingItem>();

    public static ShoppingItem find(int idx){
        return items.get(idx);
    }

    public static ArrayList<ShoppingItem> getAll(){
        return items;
    }

    public static void add(ShoppingItem item){
        items.add(item);
    }

    public static void update(int idx, ShoppingItem item){
        items.set(idx, item);
    }


}
