package fileExample.fileExample.uploadFile.util;

import fileExample.fileExample.uploadFile.domain.UploadFile;
import fileExample.fileExample.uploadFile.dto.UploadFileRequest;

public class UploadFileMapper {

    public static UploadFile dtoToEntity(UploadFileRequest uploadFileRequest) {
        return UploadFile.builder()
                .id(uploadFileRequest.getId())
                .saveFileName(uploadFileRequest.getSaveFileName())
                .build();
    }
}
