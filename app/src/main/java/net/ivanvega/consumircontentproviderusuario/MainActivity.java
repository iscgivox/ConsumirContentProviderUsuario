package net.ivanvega.consumircontentproviderusuario;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lsv;

    public void btnCCP_click(View v){
        consumirContenProviderUser();
        Toast.makeText(getBaseContext(),"Entro",Toast.LENGTH_LONG
        ).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        lsv = (ListView)findViewById(R.id.lsv);

    }

    private void consumirContenProviderUser() {

        Cursor c = getContentResolver().query(
            ContentProviderUsuarioContract.User.CONTENT_URI,
            new String[]{ContentProviderUsuarioContract.User.COLUM_ID,
                    ContentProviderUsuarioContract.User.COLUM_NOMBRE},
                null,null,null);
        SimpleCursorAdapter adp = new SimpleCursorAdapter(getApplicationContext(),
            android.R.layout.simple_list_item_2,c,
            new String[]{ContentProviderUsuarioContract.User.COLUM_ID,
                    ContentProviderUsuarioContract.User.COLUM_NOMBRE},
            new int[]{android.R.id.text1,android.R.id.text2},
            SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE
            );

        lsv.setAdapter(adp);
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
}
