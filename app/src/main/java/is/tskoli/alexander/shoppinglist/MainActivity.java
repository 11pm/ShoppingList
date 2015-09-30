package is.tskoli.alexander.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShoppingHelper.add(new ShoppingItem("Angel Eyes", 2));

        ShoppingHelper.add(new ShoppingItem("Eggs", 10));

        //get the actual list
        list = (ListView) findViewById(R.id.ShoppingList);

        //create the adapter for the list
        final ArrayAdapter<ShoppingItem> arrayAdapter = new ShoppingAdapter();

        //connect the adapter to the list
        list.setAdapter(arrayAdapter);


        Button addBtn = (Button) findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText item = (EditText) findViewById(R.id.addText);
                String text = item.getText().toString();
                Log.wtf("wtf", text);

                if(text.length() > 0){
                    ShoppingItem newItem = new ShoppingItem(text, 1);
                    ShoppingHelper.add(newItem);
                    item.setText("");
                }

                list.invalidateViews();


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ShoppingAdapter extends ArrayAdapter<ShoppingItem> {

        public ShoppingAdapter(){
            super(MainActivity.this, R.layout.shopping_item, ShoppingHelper.getAll());
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent){

            View shoppingView = convertView;

            //Variables in a list item
            TextView itemName;
            final ShoppingItem item;
            Button addBtn;
            Button removeBtn;

            //make sure we have a view
            if (shoppingView == null){
                shoppingView = getLayoutInflater().inflate(R.layout.shopping_item, parent, false);
            }

            item      = ShoppingHelper.find(position);
            itemName  = (TextView) shoppingView.findViewById(R.id.itemName);
            addBtn    = (Button) shoppingView.findViewById(R.id.itemAdd);
            removeBtn = (Button) shoppingView.findViewById(R.id.itemRemove);



            itemName.setText(item.getText());

            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //add 1 to the item amount
                    item.addAmount();
                    //update the actual list object item
                    ShoppingHelper.update(position, item);
                    //update the list
                    list.invalidateViews();
                }
            });

            removeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //if the item amount is over 1, so we
                    if(item.amount > 1){
                        //-1 the item
                        item.removeAmount();
                        //update the list object
                        ShoppingHelper.update(position, item);
                        //update the list
                        list.invalidateViews();
                    }

                }
            });



            return shoppingView;

        }

    }
}
