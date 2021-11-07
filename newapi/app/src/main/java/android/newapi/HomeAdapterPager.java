package android.newapi;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class HomeAdapterPager extends FragmentPagerAdapter{
    private final int PAGE_COUNT = 5;

    //    private String titles[] = new String[] {"New", "Pro", "Watch","Notification","Menu"};
    public HomeAdapterPager(FragmentManager Fm){
        super(Fm);
    }

    @Override
    public int getCount(){
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int page){
        switch (page){
            case 0:
                return NewfeedFace.newInstance();
            case 1:
                return ProfileFaceBook.newInstance();
            case 2:
                return WatchFaceBook.newInstance();
            case 3:
                return Notification.newInstance();
            case 4:
                return MenuFaceBook.newInstance();
        }
        return null;
    }

}
