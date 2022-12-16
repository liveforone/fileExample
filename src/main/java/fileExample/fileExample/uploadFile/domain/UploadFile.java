package fileExample.fileExample.uploadFile.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UploadFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String saveFileName;

    /*
    * 연관관계 걸거면 걸어도 상관없음.
    * 거나 안거나 파일을 가져오는데에는 큰 문제가 없음.
     */

    @Builder
    public UploadFile(Long id, String saveFileName) {
        this.id = id;
        this.saveFileName = saveFileName;
    }
}
