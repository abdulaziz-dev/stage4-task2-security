package com.mjc.school.repository.interfaces;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.AuthorModel;

public interface AuthorRepository extends BaseRepository<AuthorModel, Long> {
    AuthorModel getAuthorByNewsId(Long id);
}
