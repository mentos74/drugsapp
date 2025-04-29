package com.mentos74.drugsapp.web.entity;

import com.mentos74.drugsapp.web.enums.AttachmentType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "attachment")
public class Attachment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
