package com.hotix.myhotixmarhaba.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ContentLoadingProgressBar;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.hotix.myhotixmarhaba.R;
import com.hotix.myhotixmarhaba.helpers.MyParams;
import com.hotix.myhotixmarhaba.helpers.MySettings;

import static com.hotix.myhotixmarhaba.helpers.Utils.setBaseUrl;

public class ParamsActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private SwitchCompat swFirstName;
    private SwitchCompat swLastName;
    private SwitchCompat swGender;
    private SwitchCompat swBirthday;
    private SwitchCompat swFamiliSituation;
    private SwitchCompat swPhone;
    private SwitchCompat swEmail;
    private SwitchCompat swAddress;
    private SwitchCompat swCountry;
    private SwitchCompat swPostalCode;
    private SwitchCompat swCity;
    private SwitchCompat swProfession;
    private SwitchCompat swTypeDocId;
    private SwitchCompat swHandicap;
    private SwitchCompat swSmoker;

    //AppParams
    private MyParams mParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_params);
        bindViews();
        mParams = new MyParams(getApplicationContext());
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadParams();
        setBaseUrl(this);
    }

    @Override
    public void onBackPressed() {
        saveParams();
        setBaseUrl(this);
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /**********************************************************************************************/

    private void bindViews() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        swFirstName = (SwitchCompat) findViewById(R.id.sw_param_first_name);
        swLastName = (SwitchCompat) findViewById(R.id.sw_param_last_name);
        swGender = (SwitchCompat) findViewById(R.id.sw_param_gender);
        swBirthday = (SwitchCompat) findViewById(R.id.sw_param_birthday);
        swFamiliSituation = (SwitchCompat) findViewById(R.id.sw_param_famili_situation);
        swPhone = (SwitchCompat) findViewById(R.id.sw_param_phone);
        swEmail = (SwitchCompat) findViewById(R.id.sw_param_email);
        swAddress = (SwitchCompat) findViewById(R.id.sw_param_address);
        swCountry = (SwitchCompat) findViewById(R.id.sw_param_country);
        swPostalCode = (SwitchCompat) findViewById(R.id.sw_param_postal_code);
        swCity = (SwitchCompat) findViewById(R.id.sw_param_city);
        swProfession = (SwitchCompat) findViewById(R.id.sw_param_profession);
        swTypeDocId = (SwitchCompat) findViewById(R.id.sw_param_type_doc_id);
        swHandicap = (SwitchCompat) findViewById(R.id.sw_param_handicap);
        swSmoker = (SwitchCompat) findViewById(R.id.sw_param_smoker);
    }

    private void init() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.text_user_parameters);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        swFirstName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swFirstName.setText(R.string.all_on);
                } else {
                    swFirstName.setText(R.string.all_off);
                }
            }
        });

        swLastName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swLastName.setText(R.string.all_on);
                } else {
                    swLastName.setText(R.string.all_off);
                }
            }
        });

        swGender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swGender.setText(R.string.all_on);
                } else {
                    swGender.setText(R.string.all_off);
                }
            }
        });

        swBirthday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swBirthday.setText(R.string.all_on);
                } else {
                    swBirthday.setText(R.string.all_off);
                }
            }
        });

        swFamiliSituation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swFamiliSituation.setText(R.string.all_on);
                } else {
                    swFamiliSituation.setText(R.string.all_off);
                }
            }
        });

        swPhone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swPhone.setText(R.string.all_on);
                } else {
                    swPhone.setText(R.string.all_off);
                }
            }
        });

        swEmail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swEmail.setText(R.string.all_on);
                } else {
                    swEmail.setText(R.string.all_off);
                }
            }
        });

        swAddress.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swAddress.setText(R.string.all_on);
                } else {
                    swAddress.setText(R.string.all_off);
                }
            }
        });

        swCountry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swCountry.setText(R.string.all_on);
                } else {
                    swCountry.setText(R.string.all_off);
                }
            }
        });

        swPostalCode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swPostalCode.setText(R.string.all_on);
                } else {
                    swPostalCode.setText(R.string.all_off);
                }
            }
        });

        swCity.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swCity.setText(R.string.all_on);
                } else {
                    swCity.setText(R.string.all_off);
                }
            }
        });

        swProfession.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swProfession.setText(R.string.all_on);
                } else {
                    swProfession.setText(R.string.all_off);
                }
            }
        });

        swTypeDocId.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swTypeDocId.setText(R.string.all_on);
                } else {
                    swTypeDocId.setText(R.string.all_off);
                }
            }
        });

        swHandicap.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swHandicap.setText(R.string.all_on);
                } else {
                    swHandicap.setText(R.string.all_off);
                }
            }
        });

        swSmoker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {

                if (bChecked) {
                    swSmoker.setText(R.string.all_on);
                } else {
                    swSmoker.setText(R.string.all_off);
                }
            }
        });

    }

    private void loadParams() {

        swFirstName.setChecked(mParams.getFirstName());
        swLastName.setChecked(mParams.getlastName());
        swGender.setChecked(mParams.getGender());
        swBirthday.setChecked(mParams.getBirthDay());
        swFamiliSituation.setChecked(mParams.getFamilySituation());
        swPhone.setChecked(mParams.getPhone());
        swEmail.setChecked(mParams.getEmail());
        swAddress.setChecked(mParams.getAddress());
        swCountry.setChecked(mParams.getCountry());
        swPostalCode.setChecked(mParams.getPostalCode());
        swCity.setChecked(mParams.getCity());
        swProfession.setChecked(mParams.getProfession());
        swTypeDocId.setChecked(mParams.getTypeDocId());
        swHandicap.setChecked(mParams.getHandicap());
        swSmoker.setChecked(mParams.getSmoker());

    }

    private void saveParams() {

        mParams.setFirstName(swFirstName.isChecked());
        mParams.setLastName(swLastName.isChecked());
        mParams.setGender(swGender.isChecked());
        mParams.setBirthDay(swBirthday.isChecked());
        mParams.setFamilySituation(swFamiliSituation.isChecked());
        mParams.setPhone(swPhone.isChecked());
        mParams.setEmail(swEmail.isChecked());
        mParams.setAddress(swAddress.isChecked());
        mParams.setCountry(swCountry.isChecked());
        mParams.setPostalCode(swPostalCode.isChecked());
        mParams.setCity(swCity.isChecked());
        mParams.setProfession(swProfession.isChecked());
        mParams.setTypeDocId(swTypeDocId.isChecked());
        mParams.setHandicap(swHandicap.isChecked());
        mParams.setSmoker(swSmoker.isChecked());

    }
}
