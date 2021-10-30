package com.example.mediaappmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtTitle, txtTimeSong, txtTimeTotal;
    SeekBar skSong;
    ImageButton btnPrev, btnPlay, btnStop, btnNext;
    ArrayList<Song> arraySong;
    int position = 0;
    MediaPlayer mediaPlayer;
    Animation animation;
    ImageView imgHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        AddSong();

        animation = AnimationUtils.loadAnimation(this, R.anim.disc_rotate);
        KhoiTaoMediaPlayer();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    //neu dang phat thi pause va doi hinh
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.playms);
                }
                else {
                    //dang ngung thi phat va doi hinh pause
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.pause);
                    imgHinh.startAnimation(animation);
                }
                SetTimeTotal();
                UpdateTimeSong();
                imgHinh.startAnimation(animation);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                btnPlay.setImageResource(R.drawable.playms);
                KhoiTaoMediaPlayer();
                imgHinh.clearAnimation();

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                if(position > arraySong.size() - 1){
                    position = 0;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                KhoiTaoMediaPlayer();
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.pause);
                SetTimeTotal();
                UpdateTimeSong();
                imgHinh.startAnimation(animation);
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                if(position < 0){
                    position = arraySong.size() - 1;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                KhoiTaoMediaPlayer();
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.pause);
                SetTimeTotal();
                UpdateTimeSong();
                imgHinh.startAnimation(animation);
            }
        });

        skSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(skSong.getProgress());
            }
        });

    }

    private void UpdateTimeSong(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
                txtTimeSong.setText(dinhDangGio.format(mediaPlayer.getCurrentPosition()));
                //update progress skSong
                skSong.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(this, 500);

                //Kiem tra thoi gian bai hat -> ket thuc thi next
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        position++;
                        if(position > arraySong.size() - 1){
                            position = 0;
                        }
                        if (mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        KhoiTaoMediaPlayer();
                        mediaPlayer.start();
                        btnPlay.setImageResource(R.drawable.pause);
                        SetTimeTotal();
                        UpdateTimeSong();
                    }
                });
            }
        }, 100);
    }

    private void SetTimeTotal(){
        SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
        txtTimeTotal.setText(dinhDangGio.format(mediaPlayer.getDuration()));
        //gan max cua skSong = getDuration()
        skSong.setMax(mediaPlayer.getDuration());
    }

    private  void KhoiTaoMediaPlayer(){
        mediaPlayer = MediaPlayer.create(MainActivity.this, arraySong.get(position).getFile());
        txtTitle.setText(arraySong.get(position).getTitle());
    }
    private void AddSong() {
        arraySong = new ArrayList<>();
        arraySong.add(new Song("Anh đau đấy", R.raw.anh_dau_day));
        arraySong.add(new Song("Anh không tha thứ", R.raw.anh_khong_tha_thu));
        arraySong.add(new Song("Anh mệt rồi", R.raw.anh_met_roi));
        arraySong.add(new Song("Anh phải sống thế nào", R.raw.anh_phai_song_the_nao));
        arraySong.add(new Song("Buồn làm chi em ơi", R.raw.buon_lam_chi_em_oi));
    }

    private void AnhXa(){
        txtTitle = (TextView) findViewById(R.id.textviewTitle);
        txtTimeSong = (TextView) findViewById(R.id.textviewTimeSong);
        txtTimeTotal = (TextView) findViewById(R.id.textviewTimeTotal);
        skSong = (SeekBar) findViewById(R.id.seekBarSong);
        btnPrev = (ImageButton) findViewById(R.id.imageButtonPrev);
        btnPlay = (ImageButton) findViewById(R.id.imageButtonPlay);
        btnStop = (ImageButton) findViewById(R.id.imageButtonStop);
        btnNext = (ImageButton) findViewById(R.id.imageButtonNext);
        imgHinh = (ImageView) findViewById(R.id.imageViewDisc);
    }
}