package is.tskoli.alexander.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShoppingHelper.add(new ShoppingItem("Angel Eyes", 2));

        //get the actual list
        ListView list = (ListView) findViewById(R.id.ShoppingList);

        //create the adapter for the list
        final ArrayAdapter<ShoppingItem> arrayAdapter = new ShoppingAdapter();

        //connect the adapter to the list
        list.setAdapter(arrayAdapter);


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
        public View getView(int position, View convertView, ViewGroup parent){

            View shoppingView = convertView;

            //make sure we have a view
            if (shoppingView == null){
                shoppingView = getLayoutInflater().inflate(R.layout.shopping_item, parent, false);
            }

            ShoppingItem item = ShoppingHelper.find(position);
            Log.wtf("wtf", item.item);

            TextView te = (TextView) shoppingView.findViewById(R.id.itemName);
            te.setText(item.item);

            //TextView te = (TextView) findViewById(R.id.itemName);
            //te.setText(item.item);




            return shoppingView;

        }

    }
}
