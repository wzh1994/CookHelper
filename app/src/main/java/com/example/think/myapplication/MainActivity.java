package com.example.think.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.think.myapplication.adapter.FragmentAdapter;
import com.example.think.myapplication.structure.Dishes;
import com.example.think.myapplication.structure.MyFragment;
import com.merhold.extensiblepageindicator.ExtensiblePageIndicator;

public class MainActivity extends AppCompatActivity{
    public static Dishes dishes;
    public static int presentActivity=0;
    private ImageView ivDeleteText;
    private EditText  etSearch;
    private LinearLayout chao;
    private Button favorite;
    private Button introduce;
    private Button want;
    private Button search;
    private FragmentAdapter mFragmentAdapter;
    private ViewPager mViewPager;
    private ExtensiblePageIndicator extensiblePageIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        presentActivity=0;
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ivDeleteText = (ImageView) findViewById(R.id.ivDeleteText);
        etSearch = (EditText) findViewById(R.id.etSearch);

        ivDeleteText.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                etSearch.setText("");
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    ivDeleteText.setVisibility(View.GONE);
                } else {
                    ivDeleteText.setVisibility(View.VISIBLE);
                }
            }
        });
        if (dishes==null) dishes = new Dishes();

        chao=(LinearLayout) findViewById(R.id.category_1);
        favorite=(Button) findViewById(R.id.rbtn_love);
        introduce=(Button) findViewById(R.id.rbtn_introduce);
        want=(Button) findViewById(R.id.rbtn_want);
        search=(Button) findViewById(R.id.btnSearch);

        extensiblePageIndicator = (ExtensiblePageIndicator) findViewById(R.id.flexibleIndicator);
        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager());

        mFragmentAdapter.addFragment(MyFragment.newInstance(R.color.frag1, R.drawable.homepage_fish));
        mFragmentAdapter.addFragment(MyFragment.newInstance(R.color.frag2, R.drawable.homepage_lajiao));
        mFragmentAdapter.addFragment(MyFragment.newInstance(R.color.frag3, R.drawable.homepage_chicken));

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mFragmentAdapter);
        extensiblePageIndicator.initViewPager(mViewPager);

        extensiblePageIndicator = (ExtensiblePageIndicator) findViewById(R.id.flexibleIndicator1);
        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager());

        mFragmentAdapter.addFragment(MyFragment.newInstance(R.color.frag1, R.drawable.homepage_cs));
        mFragmentAdapter.addFragment(MyFragment.newInstance(R.color.frag2, R.drawable.homepage_qr));
        mFragmentAdapter.addFragment(MyFragment.newInstance(R.color.frag3, R.drawable.homepage_ysms));
        mViewPager = (ViewPager) findViewById(R.id.container1);
        mViewPager.setAdapter(mFragmentAdapter);
        extensiblePageIndicator.initViewPager(mViewPager);

        chao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dishes.setShow(1);
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        favorite.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dishes.setShow(2);
                Intent intent = new Intent(MainActivity.this, FavoriteActivity.class);
                startActivity(intent);
            }
        });
        introduce.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dishes.setShow(3);
                Intent intent = new Intent(MainActivity.this, IntroduceActivity.class);
                startActivity(intent);
            }
        });
        want.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WantActivity.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                dishes.setShow(etSearch.getText().toString());
            }
        });
    }

    protected void onResume(){
        super.onResume();
        presentActivity=0;
    }
}
