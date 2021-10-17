package usth.facebook;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HomePageAdapterFacebook extends FragmentPagerAdapter{
    private final int PAGE_COUNT = 5;

//    private String titles[] = new String[] {"New", "Pro", "Watch","Notification","Menu"};
    public HomePageAdapterFacebook(FragmentManager Fm){
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
                return NewFreed.newInstance();
            case 1:
                return ProfileFace.newInstance();
            case 2:
                return WatchFace.newInstance();
            case 3:
                return Notification.newInstance();
            case 4:
                return Menu.newInstance();
        }
        return null;
    }

//    @Override
//    public CharSequence getPageTitle(int page){
//        return titles[page];
//    }

}
