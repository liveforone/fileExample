package fileExample.fileExample.uploadFile.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UploadFileRequest {

    private Long id;
    private String saveFileName;
}
