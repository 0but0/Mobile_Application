package usth.facebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.net.Uri;
import android.view.Menu;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    public static final String mess = "Android";
    private TabLayout tabLayout;
    private VideoView videoView;
    private int position = 0;
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
        PagerAdapter adapter = new HomePageAdapterFacebook(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(5);
        pager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
        createTabIcons();


    }


    private void createTabIcons() {

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout,  menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                Toast toast = Toast.makeText(this, getString(R.string.search), Toast.LENGTH_SHORT);
                toast.show();
                super.onRestart();
                break;

            case R.id.messenger:
                Intent intent = new Intent(this, MessandSear.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();
        // Print Log
        Log.i(mess,"onStart");
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        // Print Log
        Log.i(mess,"onStop");
    }

    /** Called just before the activity is destroyed. */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Print Log
        Log.i(mess,"onDestroy");
    }
    /** Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();
        // Print Log
        Log.i(mess,"onPause");
    }
    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        // Print Log
        Log.i(mess,"onResume");      }


    /** Called just before the activity is restarted. */
    @Override
    protected void onRestart() {
        super.onRestart();
        // Print Log
        Log.i(mess,"onRestart");
    }
}