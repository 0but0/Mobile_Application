package android.newapi;

import android.content.Intent;
;
import android.newapi.ButtonComment.ButttomComment_1;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity  {

    private TabLayout tabLayout;
    private VideoView videoView;

    private int[] tabIcons = {
            R.drawable.ic_tab_newfeedhome,
            R.drawable.ic_tab_profile,
            R.drawable.ic_tab_watch,
            R.drawable.ic_tab_notification,
            R.drawable.ic_tab_menu
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PagerAdapter adapter = new HomeAdapterPager(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(5);
        pager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
        createTabIcons();

//
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action,  menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.search), Toast.LENGTH_SHORT);
                toast.show();
                super.onRestart();
                break;

            case R.id.messenger:
                Intent intent = new Intent(getApplicationContext(), Messe.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void createTabIcons() {

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
    }


}