package com.mentos74.drugsapp.web.dto;

import com.mentos74.drugsapp.web.enums.AttachmentType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttachmentDTO {

    private Long id;

    private String fileName;

    private String fileNameOriginal;

    private String filePath;

    private Boolean deleted;

    private LocalDateTime createdAt;

    private Long fileSize;

    @Enumerated(EnumType.STRING)
    private AttachmentType typeAttachment;

}
