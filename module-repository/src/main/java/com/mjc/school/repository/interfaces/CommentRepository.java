package com.mjc.school.repository.interfaces;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.CommentModel;

import java.util.List;

public interface CommentRepository extends BaseRepository<CommentModel, Long> {
    List<CommentModel> getCommentsByNewsId (Long newsId);
}
