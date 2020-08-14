package kg.itacademy.gsg.services.impls;

import kg.itacademy.gsg.entities.ClientTasks;
import kg.itacademy.gsg.entities.MediaFile;
import kg.itacademy.gsg.entities.Notification;
import kg.itacademy.gsg.models.MediaFileModel;
import kg.itacademy.gsg.models.NewsModel;
import kg.itacademy.gsg.models.SomeFile;
import kg.itacademy.gsg.repositories.MediaFileRepository;
import kg.itacademy.gsg.services.ClientTasksService;
import kg.itacademy.gsg.services.MediaFileService;
import kg.itacademy.gsg.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MediaFileServiceImpl implements MediaFileService {
    @Autowired
    ClientTasksService clientTasksService;

    @Autowired
    MediaFileRepository mediaFileRepository;

    @Autowired
    NotificationService notificationService;

    @Override
    public List<MediaFile> getAllMediaFiles() {
        return mediaFileRepository.findAll();
    }

    @Override
    public Page<MediaFileModel> findAll(Pageable pageable) {
        return mediaFileRepository.findAllMediaFilesWithPagination(pageable);
    }

    @Override
    public MediaFile getMediaFileById(Long id) {
        Optional<MediaFile> m = mediaFileRepository.findById(id);
        return m.orElse(new MediaFile());
    }


    @Override
    public void deleteMediaFileById(Long id) {
        mediaFileRepository.deleteById(id);
    }

    @Override
    public MediaFile saveMediaFile(SomeFile someFile, Long id) {
        FileOutputStream out;
        String modifiedTitle = System.currentTimeMillis() + someFile.getDocs().getOriginalFilename();
        String filePath = "D://docs/" + modifiedTitle;
        try {
            out = new FileOutputStream(filePath);
            out.write(someFile.getDocs().getBytes());
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        ClientTasks clientTask = clientTasksService.getById(id);
        MediaFile mediaFile = new MediaFile();
        mediaFile.setTitle(modifiedTitle);
        mediaFile.setFilePath(filePath);
        mediaFile.setClientTasks(clientTask);
        Notification notification = new Notification();
        notification.setTitle("Новое уведомление по задаче ");
        notification.setIsOpen(Boolean.FALSE);
        notification.setMessage("К задаче " + clientTask.getTask().getTitle() + "прикреплен новый файл");
        notification.setUserTo(clientTask.getClient());
        notification.setUserFrom(clientTask.getManager());
        notification.setCategory("Документы");
        notificationService.saveNotification(notification);
        return mediaFileRepository.save(mediaFile);
    }

    @Override
    public String saveMediaNotification(NewsModel newsModel) {
        FileOutputStream out;
        String modifiedTitle = System.currentTimeMillis() + newsModel.getMultipartFile().getOriginalFilename();
        String filePath = "D://posters/" + modifiedTitle;
        try {
            out = new FileOutputStream(filePath);
            out.write(newsModel.getMultipartFile().getBytes());
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return modifiedTitle;
    }

    @Override
    public Page<MediaFileModel> findAllMediaFilesByClientTasksId(Long ctId, Pageable pageable) {
        return mediaFileRepository.findAllMediaFilesByClientTasksId(ctId, pageable);
    }

    @Override
    public void deleteMediaFileByClientTask(Long id) {
        mediaFileRepository.deleteMediaFileByClientTask(id);
    }
}
