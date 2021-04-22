package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Localmp3Activity extends Activity implements View.OnClickListener {

    ImageButton Start,Stop;
    Button localBtn;
    MediaPlayer mp;//媒体播放器对象
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localmp3);
        Start=findViewById(R.id.Start);
        Stop=findViewById(R.id.Stop);
        text=findViewById(R.id.text);

        Bundle bb=this.getIntent().getExtras();
        String name=bb.getString("edit");
        text.setText(name);


        Start.setOnClickListener(new mStart());
        Stop.setOnClickListener(new mStop());
        try{
            //项目自带的MP3
            mp=MediaPlayer.create(this,R.raw.abc);
            mp.setLooping(true);
        }catch (Exception e){
            Toast.makeText(this,"play error",Toast.LENGTH_LONG).show();
        }
        localBtn=findViewById(R.id.localBtn);
        localBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent();
        i.setClass(this,LoginActivity.class);
        startActivityForResult(i,0);
    }

    class mStart implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            try{
                if (!mp.isPlaying()){
                    /*播放按钮事件*/
                    mp.start();
                    Start.setImageResource(R.drawable.music_play);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    class mStop implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            /*停止按钮事件，停止播放音乐，不是退出或释放资源*/
            mp.reset();
            try {
                mp=MediaPlayer.create(Localmp3Activity.this,R.raw.abc);
                mp.setLooping(true);
            }catch (Exception e){e.printStackTrace();}
            Start.setImageResource(R.drawable.music_play);
        }
    }
}