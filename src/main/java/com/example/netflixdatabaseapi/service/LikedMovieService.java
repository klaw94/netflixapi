package com.example.netflixdatabaseapi.service;

import com.example.netflixdatabaseapi.dao.LikeDao;
import com.example.netflixdatabaseapi.dao.MediaDao;
import com.example.netflixdatabaseapi.model.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikedMovieService {

    private final MediaDao mediaDao;
    private final LikeDao likeDao;

    @Autowired
    public LikedMovieService(@Qualifier("postgres") MediaDao mediaDao, @Qualifier("liked") LikeDao likeDao){
        this.mediaDao = mediaDao;
        this.likeDao = likeDao;
    }

    public int addLikedMovie(Integer employeeID, LikedMoviesResponseModel likedMovie){
     //   return likedMovieDao.insertLikedMovie(employeeID, likedMovie);
    }

    public List<LikedMoviesResponseModel> getAllLikedMovies(){
      ///  return likedMovieDao.selectAllLikedMovies();
    }

    public List<Like> getMediaThatILike(Integer userId) {
        return likeDao.selectAllLikesByUserId(userId);

    }

    public int deleteLikedMovie(Integer id, Integer employeeId){
        return likedMovieDao.deleteLikedMovieById(id, employeeId);
    }

    public int updateLikedMovie(Integer employeeId, LikedMoviesResponseModel newLikedMovie){
        return mediaDao.updateLikedMovieById(employeeId, newLikedMovie);
    }
}
