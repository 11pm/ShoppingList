package is.tskoli.alexander.shoppinglist;

/**
 * Created by alexander on 27.9.2015.
 */
public class ShoppingItem {

    protected String item;
    protected int amount;
    protected boolean done;


    public ShoppingItem(String _item, int _amount){
        this.item   = _item;
        this.amount = _amount;
        this.done   = false;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public void setDone(){
        this.done = true;
    }

    public void removeDone(){
        this.done = false;
    }

}
