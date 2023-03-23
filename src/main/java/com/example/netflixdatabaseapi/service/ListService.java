package com.example.netflixdatabaseapi.service;

import com.example.netflixdatabaseapi.dao.MediaDao;
import com.example.netflixdatabaseapi.dao.WatchlistRelationshipDao;
import com.example.netflixdatabaseapi.model.Media;
import com.example.netflixdatabaseapi.model.WatchlistRelationship;
import com.example.netflixdatabaseapi.requestmodels.WatchlistMovieRequestModel;
import com.example.netflixdatabaseapi.responsemodels.WatchListMovieResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListService {

    private final MediaDao mediaDao;
    private final WatchlistRelationshipDao watchlistRelationshipDao;

    @Autowired
    public ListService(@Qualifier("postgres") MediaDao mediaDao, @Qualifier("watchlist") WatchlistRelationshipDao watchlistRelationshipDao) {
        this.mediaDao = mediaDao;
        this.watchlistRelationshipDao = watchlistRelationshipDao;
    }

    public List<WatchListMovieResponseModel> getMediaInMyList(Integer userId) {

        List<Media> mediaList = mediaDao.getMediaInMyList(userId);

        List<WatchListMovieResponseModel> responseList = mediaList.stream()
                .map(media -> new WatchListMovieResponseModel(
                        media.getId(),
                        userId,
                        media.getMediaType(),
                        media.getBackdrop_path())
                )
                .collect(Collectors.toList());
        return responseList;
    }

    public int addMovie(WatchlistMovieRequestModel watchlistMovieRequestModel) {
        //check does this film exist already?
        Optional<Media> media = mediaDao.getMediaByIdAndMediaType(watchlistMovieRequestModel.getId(), watchlistMovieRequestModel.getMediaType());
        //add media in media db if the film is not already there.
        if (media.isEmpty()) {
            mediaDao.insertMovie(watchlistMovieRequestModel.getId(), watchlistMovieRequestModel.getMediaType(), watchlistMovieRequestModel.getBackdrop_path());
        }

        return watchlistRelationshipDao.insertWatchlistRelationship(watchlistMovieRequestModel.getUserId(), watchlistMovieRequestModel.getId(), watchlistMovieRequestModel.getMediaType());

    }


    public void deleteMovie(Integer mediaId, Integer userId, String mediaType) {
        //I delete the relationship between user and list
        watchlistRelationshipDao.deleteWatchlistRelationship(mediaId, userId, mediaType);
        //I check is this media piece still in the list of another user?
        Optional<WatchlistRelationship> watchlist = watchlistRelationshipDao.getWatchlistRelationshipById(mediaId, mediaType);
        //If the film is in nobody's list, I delete from the media db.
        if(watchlist.isEmpty()){
            mediaDao.deleteMediaById(mediaId, mediaType);
        }
    }




}
