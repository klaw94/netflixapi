package com.example.netflixdatabaseapi.service;

import com.example.netflixdatabaseapi.dao.MediaDao;
import com.example.netflixdatabaseapi.model.Media;
import com.example.netflixdatabaseapi.responsemodels.WatchListMovieResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListService {

    private final MediaDao mediaDao;

    @Autowired
    public ListService(@Qualifier("postgres") MediaDao mediaDao){
        this.mediaDao = mediaDao;
    }

    public int addMovie(Integer employeeID, Media media){
        return mediaDao.insertMovie(employeeID, media);
    }

    public List<WatchListMovieResponseModel> getAllMovies(){
        return mediaDao.selectAllMovies();
    }

    /**
     * @param id
     * @param employeeId
     * @return
     */
    public int deleteMovie(Integer id, Integer employeeId){
        return mediaDao.deleteMovieById(id, employeeId);
    }

    public int updateMovie(Integer employeeId, Media media){
        return mediaDao.updateMovieById(employeeId, media);
    }

    public List<WatchListMovieResponseModel> getMoviesInMyList(Integer userId) {

        List<Media> mediaList = mediaDao.getMoviesInMyList(userId);

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

}
