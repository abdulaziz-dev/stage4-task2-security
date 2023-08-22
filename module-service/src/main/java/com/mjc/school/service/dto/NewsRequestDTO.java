package com.mjc.school.service.dto;

import java.util.Set;

public record NewsRequestDTO(String title, String content, Long authorId, Set<Long> tagIds) {
}
