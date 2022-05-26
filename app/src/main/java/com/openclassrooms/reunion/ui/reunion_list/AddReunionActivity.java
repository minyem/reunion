package com.openclassrooms.reunion.ui.reunion_list;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.openclassrooms.reunion.R;
import com.openclassrooms.reunion.di.DI;
import com.openclassrooms.reunion.model.Reunion;
import com.openclassrooms.reunion.service.ReunionApiService;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddReunionActivity extends AppCompatActivity {


    ImageView avatar;
    TextInputLayout nameInput;
    TextInputLayout phoneInput;
    TextInputLayout addressInput;

    TextView aboutMeInput;
    MaterialButton addButton;

    TextInputLayout addMail;

    private ReunionApiService mApiService;
    private String mNeighbourImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  //      setContentView(R.layout.activity_add_neighbour);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mApiService = DI.getReunionApiService();

  //      n  = findViewById(R.id.aboutMeLyt);
  //      avatar  = findViewById(R.id.avatar);
  //      nameInput  = findViewById(R.id.nameLyt);
  //      phoneInput  = findViewById(R.id.phoneNumberLyt);
  //      addressInput  = findViewById(R.id.addressLyt);
  //      aboutMeInput  = findViewById(R.id.aboutMe);
  //      addButton  = findViewById(R.id.create);



        init();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home : {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {
        mNeighbourImage = randomImage();
        Glide.with(this).load(mNeighbourImage).placeholder(R.drawable.ic_account)
                .apply(RequestOptions.circleCropTransform()).into(avatar);
        nameInput.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                addButton.setEnabled(s.length() > 0);
            }
        });

    }

   // @OnClick(R.id.create)
  //  void addNeighbour() {
   //     Reunion reunion = new Reunion(
   //             System.currentTimeMillis(),
  //              nameReunion.getEditText().getText().toString(),
   //             mNeighbourImage,
  //              addressInput.getEditText().getText().toString(),
   //             phoneInput.getEditText().getText().toString(),
  //              aboutMeInput.getText().toString(),
  //              addMail.getEditText().getText().toString(),
  //              false
  //      );
  //      mApiService.createReunion(reunion);
   //     finish();
  //  }

    /**
     * Generate a random image. Useful to mock image picker
     * @return String
     */
    String randomImage() {
        return "https://i.pravatar.cc/150?u="+ System.currentTimeMillis();
    }

    /**
     * Used to navigate to this activity
     * @param activity
     */
    public static void navigate(FragmentActivity activity) {
        Intent intent = new Intent(activity, AddReunionActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }
}
