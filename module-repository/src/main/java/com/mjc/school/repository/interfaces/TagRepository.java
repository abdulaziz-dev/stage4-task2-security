package com.mjc.school.repository.interfaces;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.TagModel;

import java.util.List;

public interface TagRepository extends BaseRepository<TagModel, Long> {
    List<TagModel> getTagsByNewsId(Long newsId);
}
