package longerinoentertainment.canditoworkout.Settings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import longerinoentertainment.canditoworkout.R;

public class SettingsOptionalLegs extends AppCompatActivity {
    Button menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_optional_legs);
        menu = (Button) findViewById(R.id.menuButton);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerForContextMenu(menu);
                openContextMenu(menu);
            }
        });
    }
    /*
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_contextual_menu,menu);
    }*/

    final int CONTEXT_MENU_VIEW =1;
    final int CONTEXT_MENU_EDIT =2;
    final int CONTEXT_MENU_ARCHIVE =3;
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo) {
        //Context menu
        menu.setHeaderTitle("My Context Menu");
        menu.add(Menu.NONE, CONTEXT_MENU_VIEW, Menu.NONE, "Add");
        menu.add(Menu.NONE, CONTEXT_MENU_EDIT, Menu.NONE, "Edit");
        menu.add(Menu.NONE, CONTEXT_MENU_ARCHIVE, Menu.NONE, "Delete");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId())
        {
            case CONTEXT_MENU_VIEW:
            {
                menu.setText("view");
            }
            break;
            case CONTEXT_MENU_EDIT:
            {
                menu.setText("edit");

            }
            break;
            case CONTEXT_MENU_ARCHIVE:
            {
                menu.setText("archive");

            }
            break;
        }

        return super.onContextItemSelected(item);
    }
}
