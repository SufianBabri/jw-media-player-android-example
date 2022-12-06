package com.example.jwmediaplayersample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jwplayer.pub.api.JWPlayer;
import com.jwplayer.pub.api.UiGroup;
import com.jwplayer.pub.api.configuration.PlayerConfig;
import com.jwplayer.pub.api.configuration.UiConfig;
import com.jwplayer.pub.api.license.LicenseUtil;
import com.jwplayer.pub.api.media.playlists.PlaylistItem;
import com.jwplayer.pub.view.JWPlayerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new LicenseUtil().setLicenseKey(this, BuildConfig.JW_PLAYER_LICENSE_KEY);
        JWPlayerView playerView = findViewById(R.id.jwplayerview);
        JWPlayer player = playerView.getPlayer();

        List<PlaylistItem> playlist = new ArrayList<>();
        playlist.add(new PlaylistItem.Builder().file("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4").build());
        playlist.add(new PlaylistItem.Builder().file("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4").build());

        UiConfig uiConfig = new UiConfig.Builder()
                .displayAllControls()
                .hide(UiGroup.NEXT_UP)
                .build();
        PlayerConfig config = new PlayerConfig.Builder()
                .playlist(playlist)
                .uiConfig(uiConfig)
                .autostart(true)
                .build();
        player.setup(config);
    }
}