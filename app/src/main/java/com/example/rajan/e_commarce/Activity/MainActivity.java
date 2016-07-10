package com.example.rajan.e_commarce.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.rajan.e_commarce.Adapter.ItemDetailAdapter;
import com.example.rajan.e_commarce.Adapter.RecipeAdapter;
import com.example.rajan.e_commarce.BaseActivity;
import com.example.rajan.e_commarce.Model.Product_Detail;
import com.example.rajan.e_commarce.R;
import com.example.rajan.e_commarce.vertical.Recipe;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends BaseActivity implements RecyclerView.OnClickListener,BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    private SliderLayout mDemoSlider;
    private LayoutInflater mInflator;
    TextView textView;
    ArrayList mArrayList1;
    private Toolbar toolbar;
    DrawerLayout Drawer;
    RecyclerView mRecyclerView;
    RecipeAdapter mAdapter;
    LinearLayoutManager mLayoutManager;
    ActionBarDrawerToggle mDrawerToggle;
    CardView cardView;
    RecyclerView mRecyclerView_ring;
    ItemDetailAdapter mAdapter_ring;
    LinearLayoutManager mLayoutManager_ring;
    RecyclerView mRecyclerView_newly;
    ItemDetailAdapter mAdapter_newly;
    LinearLayoutManager mLayoutManager_newly;
    RecyclerView mRecyclerView_necklace;
    ItemDetailAdapter mAdapter_necklace;
    LinearLayoutManager mLayoutManager_necklace;
    RecyclerView mRecyclerView_earrings;
    ItemDetailAdapter mAdapter_earrings;
    LinearLayoutManager mLayoutManager_earrings;
    RecyclerView mRecyclerView_bracelets;
    ItemDetailAdapter mAdapter_bracelets;
    LinearLayoutManager mLayoutManager_bracelets;

    public ArrayList<Product_Detail> mArraylistRing;
    public ArrayList<Product_Detail> mArraylistEarRing;
    public ArrayList<Product_Detail> mArraylistNecklace;
    public ArrayList<Product_Detail> mArraylistNewly;
    public ArrayList<Product_Detail> mArraylistBracelets;
    
    public MainActivity setCardView(CardView cardView) {
        this.cardView = cardView;

        return this;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
            try {
                Method m = menu.getClass().getDeclaredMethod(
                        "setOptionalIconsVisible", Boolean.TYPE);
                m.setAccessible(true);
                m.invoke(menu, true);
            } catch (NoSuchMethodException e) {
                Log.e("Overflow Menu", "onMenuOpened", e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        mDemoSlider = (SliderLayout)findViewById(R.id.slider);



        ArrayList catagory = new ArrayList<String>();
        catagory.add("beef");
        catagory.add("cheese");
        catagory.add("salsa");
        catagory.add("tortilla");
        catagory.add("ketchup");
        catagory.add("bun");

        Recipe taco = new Recipe("Rings", Arrays.asList("Diamond", "Gold", "Silver", "Platinum","Engagement Rings"));
        Recipe quesadilla = new Recipe("Necklace", Arrays.asList("Traditional", "Western"));
        Recipe burger = new Recipe("Ear Rings", Arrays.asList("Diamond", "Western"));
        final List<Recipe> recipes = Arrays.asList(taco, quesadilla, burger);


        mArrayList1 = new ArrayList<String>();
        mArrayList1.add("Rings");
        mArrayList1.add("NeckLace");
        mArrayList1.add("Bracelets");
        mArrayList1.add("Bangles");
        mArrayList1.add("bracelets5");

        mArraylistRing = new ArrayList<Product_Detail>();
        mArraylistRing.add(new Product_Detail("Rings",2,R.drawable.rings));

        mArraylistEarRing = new ArrayList<Product_Detail>();
        mArraylistEarRing.add(new Product_Detail("EarRings",3,R.drawable.earrings));

        mArraylistBracelets = new ArrayList<Product_Detail>();
        mArraylistBracelets.add(new Product_Detail("Bracelets",4,R.drawable.bracelets));

        mArraylistNecklace = new ArrayList<Product_Detail>();
        mArraylistNecklace.add(new Product_Detail("Necklace",5,R.drawable.necklace));

        mArraylistNewly= new ArrayList<Product_Detail>();
        mArraylistNewly.add(new Product_Detail("Newly",2,R.drawable.newly));




        maping();


        mAdapter = new RecipeAdapter(this, recipes);
        mAdapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            @Override
            public void onListItemExpanded(int position) {
                Recipe expandedRecipe = recipes.get(position);
                String toastMsg = getResources().getString(R.string.expanded, expandedRecipe.getName());
                Toast.makeText(MainActivity.this, toastMsg, Toast.LENGTH_SHORT)
                        .show();

            }

            @Override
            public void onListItemCollapsed(int position) {
                Recipe collapsedRecipe = recipes.get(position);

                String toastMsg = getResources().getString(R.string.collapsed, collapsedRecipe.getName());
                Toast.makeText(MainActivity.this, toastMsg, Toast.LENGTH_SHORT)
                        .show();
            }
        });

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        /*newly*/
        mRecyclerView_newly.setHasFixedSize(true);
        mAdapter_newly = new ItemDetailAdapter(mArrayList1,"Newly");
        mRecyclerView_newly.setAdapter(mAdapter_newly);
        mLayoutManager_newly = new LinearLayoutManager(this);
        mLayoutManager_newly.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView_newly.setLayoutManager(mLayoutManager_newly);



        /*Rajan*/
        mRecyclerView_necklace.setHasFixedSize(true);
        mAdapter_necklace = new ItemDetailAdapter(mArrayList1,"Rings");
        mRecyclerView_necklace.setAdapter(mAdapter_necklace);
        mLayoutManager_necklace = new LinearLayoutManager(this);
        mLayoutManager_necklace.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView_necklace.setLayoutManager(mLayoutManager_necklace);

        /*ring*/

        mRecyclerView_ring.setHasFixedSize(true);
        mAdapter_ring = new ItemDetailAdapter(mArrayList1,"Bracelets");
        mRecyclerView_ring.setAdapter(mAdapter_ring);
        mLayoutManager_ring = new LinearLayoutManager(this);
        mLayoutManager_ring.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView_ring.setLayoutManager(mLayoutManager_ring);

         /*earrings*/

        mRecyclerView_earrings.setHasFixedSize(true);
        mAdapter_earrings = new ItemDetailAdapter(mArrayList1,"Necklace");
        mRecyclerView_earrings.setAdapter(mAdapter_earrings);
        mLayoutManager_earrings = new LinearLayoutManager(this);
        mLayoutManager_earrings.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView_earrings.setLayoutManager(mLayoutManager_earrings);

        /*bracelets*/

        mRecyclerView_bracelets.setHasFixedSize(true);
        mAdapter_bracelets = new ItemDetailAdapter(mArrayList1,"Ear Rings");
        mRecyclerView_bracelets.setAdapter(mAdapter_bracelets);
        mLayoutManager_bracelets = new LinearLayoutManager(this);
        mLayoutManager_bracelets.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView_bracelets.setLayoutManager(mLayoutManager_bracelets);

        /*drower*/
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.openDrawer,R.string.closeDrawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }

        };
         // Drawer Toggle Object Made
        Drawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();



        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Rings",R.drawable.rings);
        file_maps.put("Necklace",R.drawable.necklace);
        file_maps.put("Newly",R.drawable.newly);
        file_maps.put("Braceletes", R.drawable.bracelets);
        file_maps.put("Ear Rings", R.drawable.earrings);
        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);




    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        Intent i;
        //noinspection SimplifiableIfStatement
        switch (id){

            case R.id.action_orders:
                i = new Intent(this,Cart.class);
                startActivity(i);
                break;

            case R.id.action_Account:
                i = new Intent(MainActivity.this,MyAccount.class);
                startActivity(i);

                break;
            case R.id.action_login:
                i = new Intent(MainActivity.this,Login.class);
                startActivity(i);

                break;

            case R.id.action_SignOut:
                i = new Intent(MainActivity.this,Signup.class);
                startActivity(i);

                break;
        }


        return super.onOptionsItemSelected(item);
    }

    public void maping(){
        cardView = (CardView)findViewById(R.id.cardview_project_detail);

        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mRecyclerView_ring = (RecyclerView) findViewById(R.id.RecyclerView_ring);
        mRecyclerView_newly = (RecyclerView) findViewById(R.id.RecyclerView_newly);
        mRecyclerView_necklace = (RecyclerView) findViewById(R.id.RecyclerView_necklace);
        mRecyclerView_earrings = (RecyclerView) findViewById(R.id.RecyclerView_earrings);
        mRecyclerView_bracelets = (RecyclerView) findViewById(R.id.RecyclerView_bracelets);

        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);

    }




    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}




    @Override
    public void onClick(View v) {
        Toast.makeText(this,"rrrrr",Toast.LENGTH_SHORT).show();
    }



}