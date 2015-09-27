package is.tskoli.alexander.shoppinglist;

/**
 * Created by alexander on 27.9.2015.
 */
public class ShoppingItem {

    protected String item;
    protected boolean done;

    public ShoppingItem(String _item){
        this.item = _item;
        this.done = false;
    }

    public void setDone(){
        this.done = true;
    }

    public void removeDone(){
        this.done = false;
    }

}
