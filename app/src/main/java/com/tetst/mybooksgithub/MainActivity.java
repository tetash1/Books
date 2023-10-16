package com.tetst.mybooksgithub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.krishna.fileloader.FileLoader;
import com.krishna.fileloader.listener.FileRequestListener;
import com.krishna.fileloader.pojo.FileResponse;
import com.krishna.fileloader.request.FileLoadRequest;
import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FileLoader.with(this)
                .load("https://github.com/tetash1/Books/blob/main/class_six_Bangla_.pdf",false) //2nd parameter is optioal, pass true to force load from network
                .fromDirectory("test4", FileLoader.DIR_INTERNAL)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest request, FileResponse<File> response) {
                        File loadedFile = response.getBody();
                        // do something with the file
                    }

                    @Override
                    public void onError(FileLoadRequest request, Throwable t) {
                    }
                });
    }
}
