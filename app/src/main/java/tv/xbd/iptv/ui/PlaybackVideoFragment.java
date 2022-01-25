package tv.xbd.iptv.ui;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;

import androidx.leanback.app.VideoSupportFragment;
import androidx.leanback.app.VideoSupportFragmentGlueHost;
import androidx.leanback.media.MediaPlayerAdapter;
import androidx.leanback.media.PlaybackTransportControlGlue;
import androidx.leanback.widget.PlaybackControlsRow;

import tv.xbd.iptv.db.entity.TvShowEntity;

/**
 * Handles video playback with media controls.
 */
public class PlaybackVideoFragment extends VideoSupportFragment {

    private PlaybackTransportControlGlue<MediaPlayerAdapter> mTransportControlGlue;
    private MediaPlayerAdapter playerAdapter;

    @SuppressLint("UnsafeOptInUsageError")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final TvShowEntity movie =
                (TvShowEntity) getActivity().getIntent().getSerializableExtra(UiUtils.TV_SHOW);

        playerAdapter = new MediaPlayerAdapter(getActivity());
        playerAdapter.setRepeatAction(PlaybackControlsRow.RepeatAction.INDEX_NONE);

        VideoSupportFragmentGlueHost glueHost =
                new VideoSupportFragmentGlueHost(PlaybackVideoFragment.this);

        mTransportControlGlue = new PlaybackTransportControlGlue<>(getActivity(), playerAdapter);
        mTransportControlGlue.setHost(glueHost);
        mTransportControlGlue.setTitle(movie.getTitle());
        mTransportControlGlue.playWhenPrepared();
        playerAdapter.setDataSource(Uri.parse(movie.getBestRouteUri()));
        playerAdapter.play();

    }

    @Override
    public void onPause() {
        super.onPause();
        if (playerAdapter != null) {
            playerAdapter.pause();
        }
        if (mTransportControlGlue != null) {
            mTransportControlGlue.pause();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (playerAdapter != null) {
            playerAdapter.pause();
            playerAdapter = null;
        }
        if (mTransportControlGlue != null) {
            mTransportControlGlue = null;
        }
    }
}