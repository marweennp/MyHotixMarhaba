package com.hotix.myhotixmarhaba.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.hotix.myhotixmarhaba.R;
import com.hotix.myhotixmarhaba.fragments.PaxDetailsFragment;
import com.hotix.myhotixmarhaba.helpers.MyParams;
import com.hotix.myhotixmarhaba.helpers.MySettings;
import com.hotix.myhotixmarhaba.models.Pax;

import java.util.ArrayList;
import java.util.List;

import static com.hotix.myhotixmarhaba.helpers.ConstantConfig.GLOBAL_PAX_LIST;
import static com.hotix.myhotixmarhaba.helpers.Utils.setBaseUrl;
import static com.hotix.myhotixmarhaba.helpers.Utils.showSnackbar;

public class EditPaxDetailsActivity extends AppCompatActivity {

    PaxDetailsFragment mFragment;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private String resaId;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private List<String> mFragmentTitleList = new ArrayList<>();

    //AppParams
    private MyParams mParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pax_details);
        bindViews();
        mParams = new MyParams(getApplicationContext());
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setBaseUrl(this);
        if (GLOBAL_PAX_LIST.size() > 0) {
            setupViewPager(viewPager);
            setupTabIcons();
        } else {
            //finish();
            showSnackbar(findViewById(android.R.id.content), getString(R.string.error_message_check_settings));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        int i = 0;
        for (Pax obj : GLOBAL_PAX_LIST) {
            PaxDetailsFragment frag = PaxDetailsFragment.newInstance(i);
            adapter.addFragment(frag, obj.getPrenom());
            i++;
        }
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {

        for (int i = 0; i < GLOBAL_PAX_LIST.size(); i++) {
            tabLayout.getTabAt(i).setIcon(R.drawable.ic_account_circle_white_36dp);
        }
    }

    /**********************************************************************************************/

    private void bindViews() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager_pax);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
    }

    private void init() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        AppCompatTextView toolbarTitle = (AppCompatTextView) toolbar.findViewById(R.id.toolbar_center_title);
        toolbarTitle.setText(R.string.guest_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            resaId = extras.getString("resaId");
        }

        tabLayout.setupWithViewPager(viewPager);

    }

    /**********************************************************************************************/

    class ViewPagerAdapter extends FragmentPagerAdapter {


        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //return mFragmentTitleList.get(position);
            return null;
        }
    }
}
