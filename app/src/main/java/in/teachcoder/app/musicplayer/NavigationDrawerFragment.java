package in.teachcoder.app.musicplayer;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Macbook on 04/08/15.
 */
public class NavigationDrawerFragment extends Fragment {
    private  ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.navigation_drawer_frag_layout, container, false);
    }

    public void setUp(DrawerLayout drawerLayout, Toolbar toolBar) {
        mDrawerLayout = drawerLayout;
       //1.Create a new Instance of ActionBarDrawerToggle
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(),drawerLayout,toolBar,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        //2.Set the listener to the drawerLayout as drawerToggle overrided methods
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }
}
