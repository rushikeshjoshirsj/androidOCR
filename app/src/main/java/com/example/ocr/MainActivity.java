package com.example.ocr;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnCaptureImage;
    ImageView imageDisplay;
    Button btnResetImage;
    Button nextButton;
    StringBuilder sb ;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btnCaptureImage = (Button)findViewById(R.id.btn_captureImage);
        imageDisplay = (ImageView)findViewById(R.id.imageCapture);
        btnResetImage = (Button)findViewById(R.id.btn_resetImage);
        nextButton = (Button)findViewById(R.id.nextButton);
        sb = new StringBuilder();

        btnCaptureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });
        btnResetImage.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
            @Override
            public void onClick(View view) {
                //imageDisplay.setImageResource(android.R.color.transparent);
                Intent galleryIntent = new Intent();
                galleryIntent.setType("image/*");
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(galleryIntent,"select picture"),PICK_IMAGE);

            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), review_form.class);
                intent.putExtra("data",sb.toString());
                startActivity(intent);

            }
        });
       // ProposedInsured proposedInsured = getIntent().getParcelableExtra("proposedInsured");

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageDisplay.setImageBitmap(bitmap);
            TextRecognizer recognizer = new TextRecognizer.Builder(getApplicationContext()).build();
            if (!recognizer.isOperational()) {
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
            } else {
                Frame frame = new Frame.Builder().setBitmap(bitmap).build();
                SparseArray<TextBlock> items = recognizer.detect(frame);
                for (int i = 0; i < items.size(); i++) {
                    TextBlock myItem = items.valueAt(i);
                    sb.append(myItem.getValue());
                    sb.append("\n");
                }
                Toast.makeText(this, sb.toString() + "hellooooo" + items.size(), Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
                imageDisplay.setImageBitmap(bitmap);
                TextRecognizer recognizer = new TextRecognizer.Builder(getApplicationContext()).build();
                if (!recognizer.isOperational()) {
                    Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
                } else {
                    Frame frame = new Frame.Builder().setBitmap(bitmap).build();
                    SparseArray<TextBlock> items = recognizer.detect(frame);
                    for (int i = 0; i < items.size(); i++) {
                        TextBlock myItem = items.valueAt(i);
                        sb.append(myItem.getValue());
                        sb.append("\n");
                    }
                    Toast.makeText(this, sb.toString() + "hellooooo" + items.size(), Toast.LENGTH_SHORT).show();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
