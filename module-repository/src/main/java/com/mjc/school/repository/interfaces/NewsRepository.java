package com.mjc.school.repository.interfaces;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.NewsModel;

import java.util.List;

public interface NewsRepository extends BaseRepository<NewsModel, Long> {
    List<NewsModel> readByParams(Long tagId, String tagName, String authorName, String title, String content);
}
