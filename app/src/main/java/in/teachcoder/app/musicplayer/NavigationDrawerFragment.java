package in.teachcoder.app.musicplayer;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Macbook on 04/08/15.
 */
public class NavigationDrawerFragment extends Fragment {
    private  ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private RecyclerView recyclerView;
    private NavigationDrawerRecycleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //getting RecyclerView from Navigation Drawer
        View layout = inflater.inflate(R.layout.navigation_drawer_frag_layout, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);

        adapter = new NavigationDrawerRecycleAdapter(getActivity(),getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return layout;
    }

    public static List<MusicFile> getData(){

        List<MusicFile> data = new ArrayList<>();
        String[] tvArray = {"baahubali","patanahi","aajao beta","hum se na hopayega"};

        for(int i=0;i<tvArray.length;i++){

            MusicFile musocFileObject = new MusicFile();
            musocFileObject.fileName = tvArray[i];
            data.add(musocFileObject);
        }
        return data;
    }

    public void setUp(DrawerLayout drawerLayout, final Toolbar toolBar) {
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

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if(slideOffset < 0.6) {
                    toolBar.setAlpha(1-slideOffset);
                //if we remove super hamburger animation is not there
                    //This onDrawSlide is for toolBar animation to alpha
                }

            }
        };
        //2.Set the listener to the drawerLayout as drawerToggle overrided methods
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }


}
