package fileExample.fileExample.uploadFile.service;

import fileExample.fileExample.uploadFile.dto.UploadFileRequest;
import fileExample.fileExample.uploadFile.repository.UploadFileRepository;
import fileExample.fileExample.uploadFile.util.UploadFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UploadFileService {

    private final UploadFileRepository uploadFileRepository;

    @Transactional
    public void saveFile(
            List<MultipartFile> uploadFile
    ) throws IOException {
        for (MultipartFile file : uploadFile) {
            UUID uuid = UUID.randomUUID();
            String saveFileName = uuid + "_" + file.getOriginalFilename();
            file.transferTo(new File(saveFileName));
            UploadFileRequest dto = UploadFileRequest.builder()
                    .saveFileName(saveFileName)
                    .build();
            uploadFileRepository.save(UploadFileMapper.dtoToEntity(dto));
        }
    }
}
