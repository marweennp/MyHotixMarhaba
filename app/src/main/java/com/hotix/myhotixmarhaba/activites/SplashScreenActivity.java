package com.hotix.myhotixmarhaba.activites;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import com.hotix.myhotixmarhaba.R;
import com.hotix.myhotixmarhaba.helpers.MySettings;
import com.hotix.myhotixmarhaba.models.HotelSettings;
import com.hotix.myhotixmarhaba.retrofit.RetrofitClient;
import com.hotix.myhotixmarhaba.retrofit.RetrofitInterface;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.hotix.myhotixmarhaba.helpers.ConstantConfig.FINAL_APP_ID;
import static com.hotix.myhotixmarhaba.helpers.Utils.setBaseUrl;
import static com.hotix.myhotixmarhaba.helpers.Utils.stringEmptyOrNull;

public class SplashScreenActivity extends AppCompatActivity {

    private static final String TAG = "SplashScreenActivity";

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;

    private MySettings mMySettings;

    // Views
    private RelativeLayout rlMainContainer;
    private AppCompatTextView tvSplashHeader;
    private AppCompatImageView ivSplashLogo;
    private LinearLayoutCompat llSplashProgress;
    private AppCompatTextView tvSplashProgress;
    private ContentLoadingProgressBar pbSplashProgress;

    // Infos View
    private RelativeLayout rlInfosView;
    private AppCompatImageView ivInfosIcon;
    private AppCompatTextView tvInfosMsg;
    private AppCompatButton btnInfosRefresh;

    private Drawable mIconOne, mIconTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        bindViews();

        //settings
        mMySettings = new MySettings(getApplicationContext());

        init();

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mMySettings.getConfigured()) {
            setBaseUrl(this);
            if (mMySettings.getAutoUpdate()) {
                try {
                    UpdateHotelInfos(mMySettings.getHotelCode());
                } catch (Exception e) {
                    Log.e("SPLASH LOG", e.toString());
                }
            } else {
                startDelay();
            }
        } else {
            startDelay();
        }
    }

    /**********************************************************************************************/

    private void startDelay() {

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(SplashScreenActivity.this, HomeActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                finish();

            }
        }, SPLASH_TIME_OUT);

    }

    /**********************************************************************************************/

    private void bindViews() {
        rlMainContainer = (RelativeLayout) findViewById(R.id.rl_splash_main_container);
        tvSplashHeader = (AppCompatTextView) findViewById(R.id.tv_splash_screen_header);
        ivSplashLogo = (AppCompatImageView) findViewById(R.id.iv_splash_logo);
        llSplashProgress = (LinearLayoutCompat) findViewById(R.id.ll_splash_progress);
        tvSplashProgress = (AppCompatTextView) findViewById(R.id.tv_spalsh_progress);
        pbSplashProgress = (ContentLoadingProgressBar) findViewById(R.id.pb_spalsh_progress);

        rlInfosView = (RelativeLayout) findViewById(R.id.rl_infos_view);
        ivInfosIcon = (AppCompatImageView) findViewById(R.id.iv_infos_icon);
        tvInfosMsg = (AppCompatTextView) findViewById(R.id.tv_infos_msg);
        btnInfosRefresh = (AppCompatButton) findViewById(R.id.btn_infos_refresh);
    }

    private void init() {

        //load logo
        Picasso.get().load(R.drawable.logo).fit().placeholder(R.drawable.logo).into(ivSplashLogo);

        //Check android vertion and load image
        if (android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            mIconOne = getResources().getDrawable(R.drawable.svg_internet_grey_512, this.getTheme());
            mIconTwo = getResources().getDrawable(R.drawable.svg_server_grey_512, this.getTheme());
        } else {
            mIconOne = VectorDrawableCompat.create(this.getResources(), R.drawable.svg_internet_grey_512, this.getTheme());
            mIconTwo = VectorDrawableCompat.create(this.getResources(), R.drawable.svg_server_grey_512, this.getTheme());
        }

        btnInfosRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
    }

    /**********************************************************************************************/

    public void UpdateHotelInfos(String code) {

        llSplashProgress.setVisibility(View.VISIBLE);
        tvSplashProgress.setText(R.string.loading_hotel_settings);

        RetrofitInterface service = RetrofitClient.getHotixSupportApi().create(RetrofitInterface.class);
        Call<HotelSettings> userCall = service.getHotelInfosQuery(code, FINAL_APP_ID);

        userCall.enqueue(new Callback<HotelSettings>() {
            @Override
            public void onResponse(Call<HotelSettings> call, Response<HotelSettings> response) {
                llSplashProgress.setVisibility(View.GONE);
                tvSplashProgress.setText("");

                if (response.raw().code() == 200) {
                    HotelSettings hotelSettings = response.body();

                    //Get Public IP
                    if (!stringEmptyOrNull(hotelSettings.getHotelIPPublic())) {
                        mMySettings.setPublicIp(hotelSettings.getHotelIPPublic());
                        mMySettings.setPublicBaseUrl("http://" + hotelSettings.getHotelIPPublic() + "/");
                        mMySettings.setPublicIpEnabled(true);
                    } else {
                        mMySettings.setPublicIp("xxx.xxx.xxx.xxx");
                        mMySettings.setPublicBaseUrl("http://xxx.xxx.xxx.xxx/");
                        mMySettings.setPublicIpEnabled(false);
                    }

                    //Get Local IP
                    if (!stringEmptyOrNull(hotelSettings.getHotelIPLocal())) {
                        mMySettings.setLocalIp(hotelSettings.getHotelIPLocal());
                        mMySettings.setLocalBaseUrl("http://" + hotelSettings.getHotelIPLocal() + "/");
                        mMySettings.setLocalIpEnabled(true);
                    } else {
                        mMySettings.setLocalIp("xxx.xxx.xxx.xxx");
                        mMySettings.setLocalBaseUrl("http://xxx.xxx.xxx.xxx/");
                        mMySettings.setLocalIpEnabled(false);
                    }

                    //Get Hotel ID
                    if (!stringEmptyOrNull(hotelSettings.getHotelCode())) {
                        mMySettings.setHotelCode(hotelSettings.getHotelCode());
                    } else {
                        mMySettings.setHotelCode("0000");
                    }

                    //Get Hotel Name
                    if (!stringEmptyOrNull(hotelSettings.getHotelName())) {
                        mMySettings.setHotelName(hotelSettings.getHotelName());
                    } else {
                        mMySettings.setHotelName("MY HOTEL");
                    }

                    //Get API Version
                    if (!stringEmptyOrNull(hotelSettings.getAPIVersion())) {
                        mMySettings.setApiVersion(hotelSettings.getAPIVersion());
                    } else {
                        mMySettings.setApiVersion("v0");
                    }

                    mMySettings.setSettingsUpdated(true);

                } else {
                    mMySettings.setSettingsUpdated(false);
                }
                startDelay();
            }

            @Override
            public void onFailure(Call<HotelSettings> call, Throwable t) {
                llSplashProgress.setVisibility(View.GONE);
                tvSplashProgress.setText("");
                mMySettings.setSettingsUpdated(false);
                startDelay();
            }
        });

    }

}
