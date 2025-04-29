package com.mentos74.drugsapp.web.service.impl;

import com.mentos74.drugsapp.web.dto.AttachmentDTO;
import com.mentos74.drugsapp.web.entity.Attachment;
import com.mentos74.drugsapp.web.enums.AttachmentType;
import com.mentos74.drugsapp.web.repository.AttachmentRepository;
import com.mentos74.drugsapp.web.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AttachmentServiceImpl implements AttachmentService {


    @Autowired
    AttachmentRepository attachmentRepository;

    @Override
    public Attachment saveAttachment(MultipartFile file, AttachmentType attachmentType) throws IOException {

        Attachment attachment = new Attachment();

        try {

            String uploadPath = System.getProperty("user.dir") + File.separator + "uploads";
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                boolean dirCreated = uploadDir.mkdirs();
                System.out.println("Uploads directory created: " + dirCreated);
            }

            String fileName = UUID.randomUUID().toString();
            String filePath = Paths.get(uploadPath, fileName).toString();
            String fileNameOriginal = file.getOriginalFilename();


            System.out.println("File path: " + filePath);
            file.transferTo(new File(filePath));

            attachment.setCreatedAt(LocalDateTime.now());
            attachment.setTypeAttachment(attachmentType);
            attachment.setFileName(fileName);
            attachment.setFileNameOriginal(fileNameOriginal);
            attachment.setFileSize(file.getSize());
            attachment.setDeleted(false);
            attachment.setFilePath(filePath);

            attachmentRepository.save(attachment);

        } catch (Exception e) {
            System.err.println("Error saving file: " + file.getOriginalFilename());
            e.printStackTrace();
        }
        return attachment;
    }

    @Override
    public Attachment findAttachmentById(Long id) {
        return attachmentRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteAttachment(Long id) {

    }
}
