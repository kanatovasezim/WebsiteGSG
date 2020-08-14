package kg.itacademy.gsg.services;

import kg.itacademy.gsg.entities.MediaFile;
import kg.itacademy.gsg.entities.Notification;
import kg.itacademy.gsg.models.MediaFileModel;
import kg.itacademy.gsg.models.NewsModel;
import kg.itacademy.gsg.models.SomeFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MediaFileService {
    List<MediaFile> getAllMediaFiles();

    Page<MediaFileModel> findAll(Pageable pageable);

    MediaFile getMediaFileById(Long id);

//    MediaFile saveMediaFile(MediaFileModel mediaFileModel);

    void deleteMediaFileById(Long id);

    String saveMediaNotification(NewsModel newsModel);

    MediaFile saveMediaFile(SomeFile file, Long id);

    Page<MediaFileModel> findAllMediaFilesByClientTasksId(Long ctId, Pageable pageable);

    void deleteMediaFileByClientTask(Long id);

}
