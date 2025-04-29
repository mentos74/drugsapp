package com.mentos74.drugsapp.web.service;


import com.mentos74.drugsapp.web.dto.AttachmentDTO;
import com.mentos74.drugsapp.web.entity.Attachment;
import com.mentos74.drugsapp.web.enums.AttachmentType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface AttachmentService {

    public Attachment saveAttachment(MultipartFile file, AttachmentType attachmentType) throws IOException;
    public Attachment findAttachmentById(Long id);
    public void deleteAttachment(Long id);

}
