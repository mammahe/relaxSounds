package sairamkrishna.relax.relaxsounds;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class soundpage extends AppCompatActivity {
    private NotificationManager manager;
    private int counter;
    private TextView play;
    private TextView mCvCountdownView;
    private CountDownTimer countDownTimer;
    private AudioManager audioManager = null;
    private MediaPlayer player;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soundpage);
        startService(new Intent(this, YourService.class));
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
        mCvCountdownView = findViewById(R.id.Timer);
        Intent extra = getIntent();
        String Imagetitle = extra.getStringExtra("Image");
        String title = extra.getStringExtra("Tittle");
        int intValue = extra.getIntExtra("soung", 0);

        if (player != null && player.isPlaying()) {
            player.stop();
            player.release();
            player = MediaPlayer.create(getApplicationContext(), intValue);
            player.setLooping(true);
        } else {
            player = MediaPlayer.create(getApplicationContext(), intValue);
            player.setLooping(true);
        }


        LinearLayout l1 = findViewById(R.id.layout);
        int productImageId = getResources().getIdentifier(
                Imagetitle, "drawable", getPackageName());
        l1.setBackgroundResource(productImageId);
        TextView tittle = findViewById(R.id.tittle);
        TextView time = findViewById(R.id.time);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> mAnimals = new ArrayList<>();
                mAnimals.add("1" + " " + "Minute");
                mAnimals.add("3" + " " + "Minutes");
                mAnimals.add("5" + " " + "Minutes");
                mAnimals.add("10" + " " + "Minutes");
                mAnimals.add("15" + " " + "Minutes");
                mAnimals.add("20" + " " + "Minutes");
                mAnimals.add("30" + " " + "Minutes");
                mAnimals.add("45" + " " + "Minutes");
                mAnimals.add("60" + " " + "Minutes");
                //Create sequence of items
                final CharSequence[] Animals = mAnimals.toArray(new String[mAnimals.size()]);
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(soundpage.this);
                dialogBuilder.setTitle("Select Timer Duration");
                dialogBuilder.setItems(Animals, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        if (player != null && player.isPlaying()) {
                        } else {
                            player.start();
                        }
                        final String selectedText = Animals[item].toString().replaceAll(" .+$", "").trim();
                        if (countDownTimer != null) {
                            countDownTimer.cancel();
                        }
                        countDownTimer = new CountDownTimer(TimeUnit.MINUTES.toMillis(Long.parseLong(selectedText)), 1000) {
                            @SuppressLint("DefaultLocale")
                            public void onTick(long millisUntilFinished) {
                                mCvCountdownView.setVisibility(View.VISIBLE);
                                mCvCountdownView.setText(String.format("%d min, %d sec",
                                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                                counter++;
                                play.setText("Stop");
                            }

                            public void onFinish() {
                                mCvCountdownView.setText("FINISH!!");
                                mCvCountdownView.setVisibility(View.GONE);
                                if (countDownTimer != null) {
                                    countDownTimer.cancel();
                                }
                                play.setText("Play");
                                player.stop();
                                player.release();
                                finish();
                            }
                        };

                        countDownTimer.start();

                    }
                });
                //Create alert dialog object via builder
                AlertDialog alertDialogObject = dialogBuilder.create();
                //Show the dialog
                alertDialogObject.show();
            }
        });
        tittle.setText(title);
        initControls();

        play = findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (play.getText().equals("Play")) {
                    play.setText("Stop");
                    player.start();

                } else if (play.getText().equals("Stop")) {
                    play.setText("Play");
                    if (player != null && player.isPlaying()) {
                        player.stop();
                    }
                    finish();

                }
            }
        });
    }


    private void initControls() {
        try {
            SeekBar volumeSeekbar = findViewById(R.id.seekBar1);
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            assert audioManager != null;
            volumeSeekbar.setMax(audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            volumeSeekbar.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC));


            volumeSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onStopTrackingTouch(SeekBar arg0) {
                }

                @Override
                public void onStartTrackingTouch(SeekBar arg0) {
                }

                @Override
                public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                            progress, 0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        player.stop();
        player.release();
        finish();
    }

    @Override
    protected void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.notification)
                        .setContentTitle("Relax Notification")
                        .setContentText("Relax Melodies are working");


        Intent notificationIntent = new Intent(this, soundpage.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                0);
        builder.setContentIntent(contentIntent);
        Notification n;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            n = builder.build();
        } else {
            n = builder.getNotification();
        }

        n.flags |= Notification.FLAG_NO_CLEAR | Notification.FLAG_ONGOING_EVENT;
        // Add as notification
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(12345,n);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.cancel(12345);
    }


    @Override
    protected void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();

        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.cancel(12345);
    }
}
