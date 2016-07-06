package tomer.edu.takingpicture;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private static final int REQUEST_CODE_TAKE_PICTURE = 1;
    static final Uri mLocationForPhotos = null;

    ImageView ivPicture;
    Button btnPicture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ivPicture = (ImageView) findViewById(R.id.ivImage);
        btnPicture = (Button) findViewById(R.id.btnTakepicture);
    }

    public void TakePhoto(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_CODE_TAKE_PICTURE);



        }
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
         if (requestCode == REQUEST_CODE_TAKE_PICTURE && resultCode == RESULT_OK)
         {
             Bitmap bitmap = data.getParcelableExtra("data");
             ivPicture.setImageBitmap(bitmap);
         }
    }

}
