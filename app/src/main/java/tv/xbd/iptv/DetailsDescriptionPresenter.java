package tv.xbd.iptv;

import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;

import tv.xbd.iptv.entity.TvShowEntity;

public class DetailsDescriptionPresenter extends AbstractDetailsDescriptionPresenter {

    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object item) {
        TvShowEntity movie = (TvShowEntity) item;

        if (movie != null) {
            viewHolder.getTitle().setText(movie.getTitle());
            viewHolder.getSubtitle().setText(movie.getCountry());
            viewHolder.getBody().setText(movie.getProvince());
        }
    }
}