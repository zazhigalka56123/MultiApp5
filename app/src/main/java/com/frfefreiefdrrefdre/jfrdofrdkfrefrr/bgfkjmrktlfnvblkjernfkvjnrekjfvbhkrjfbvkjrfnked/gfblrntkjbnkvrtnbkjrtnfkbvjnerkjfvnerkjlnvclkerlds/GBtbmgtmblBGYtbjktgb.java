package com.frfefreiefdrrefdre.jfrdofrdkfrefrr.bgfkjmrktlfnvblkjernfkvjnrekjfvbhkrjfbvkjrfnked.gfblrntkjbnkvrtnbkjrtnfkbvjnerkjfvnerkjlnvclkerlds;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.GridView;
import android.view.View;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;

import com.frfefreiefdrrefdre.jfrdofrdkfrefrr.R;

import android.widget.AdapterView;
import android.widget.Toast;

import java.io.IOException;

public class GBtbmgtmblBGYtbjktgb extends AppCompatActivity {
    String mCurrentPhotoPath;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_IMAGE_GALLERY = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fvmkvf_fbtrbvnjgklrfbv);

        AssetManager am = getAssets();
        try {
            final String[] files = am.list("img");

            GridView grid = findViewById(R.id.grid);
            grid.setAdapter(new FGrgfnrtkgjBHrthngbjrtkbgr(this));
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getApplicationContext(), TGktjbhktyhbYThytgvbt.class);
                    intent.putExtra("assetName", files[i % files.length]);
                    startActivity(intent);
                }
            });
        } catch (IOException e) {
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Intent intent = new Intent(this, TGktjbhktyhbYThytgvbt.class);
            intent.putExtra("mCurrentPhotoPath", mCurrentPhotoPath);
            startActivity(intent);
        }
        if (requestCode == REQUEST_IMAGE_GALLERY && resultCode == RESULT_OK) {
            Uri uri = data.getData();

            Intent intent = new Intent(this, TGktjbhktyhbYThytgvbt.class);
            intent.putExtra("mCurrentPhotoUri", uri.toString());
            startActivity(intent);
        }
    }
}
