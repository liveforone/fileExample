package fileExample.fileExample.uploadFile.repository;

import fileExample.fileExample.uploadFile.domain.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadFileRepository extends JpaRepository<UploadFile, Long> {
}
