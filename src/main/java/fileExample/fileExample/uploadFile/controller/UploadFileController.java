package fileExample.fileExample.uploadFile.controller;

import fileExample.fileExample.uploadFile.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UploadFileController {

    private final UploadFileService uploadFileService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(
            @RequestPart List<MultipartFile> uploadFile
    ) throws IllegalStateException, IOException {
        if (uploadFile.isEmpty()) {
            log.info("파일이 없어서 포스팅 실패했습니다.");
            return ResponseEntity
                    .ok("파일이 존재하지 않아 포스팅이 실패했습니다. \n파일을 넣고 다시 등록해주세요");
        }
        uploadFileService.saveFile(uploadFile);
        log.info("file save success");

        return ResponseEntity.ok("파일 저장 성공");
    }

    @GetMapping("/upload/{saveFileName}")
    @ResponseBody
    public Resource showImage(
            @PathVariable("saveFileName") String saveFileName
    ) throws MalformedURLException {
        return new UrlResource("file:C:\\Temp\\upload\\" + saveFileName);
    }
}
