package com.example.demo.services;

import com.example.demo.data.models.CensorOfComment;
import com.example.demo.data.models.CensorOfMedia;
import com.example.demo.data.models.CensorOfPost;
import com.example.demo.data.models.subMovie.Medias;
import com.mongodb.client.result.DeleteResult;

import java.util.List;

public interface CensorService {
    //CRUD censor of Post
    CensorOfPost addNewPost(CensorOfPost censorOfPost);
    CensorOfPost editMediasOfPost(String id, List<Medias> medias);
    CensorOfPost findPostById(String id);
    List<CensorOfPost> findAllCensorOfPost(int pageNo, int pageSize);
    DeleteResult deleteCensorOfPostById(String id);
    //CRUD censor of Comment
    CensorOfComment addNewComment(CensorOfComment censorOfComment);
    CensorOfComment editComment(String id, CensorOfComment censorOfComment);
    CensorOfComment findCommentById(String id);
    //CRUD censor of Media
    CensorOfMedia addNewMedia(CensorOfMedia censorOfMedia);
    CensorOfMedia editMedia(String id, CensorOfMedia censorOfMedia);
    CensorOfMedia findMediaById(String id);
}
