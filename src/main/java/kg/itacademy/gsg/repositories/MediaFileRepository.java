package kg.itacademy.gsg.repositories;

import kg.itacademy.gsg.entities.MediaFile;
import kg.itacademy.gsg.models.MediaFileModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MediaFileRepository extends JpaRepository<MediaFile, Long> {

    @Query("select new kg.itacademy.gsg.models.MediaFileModel(m.id,m.title,m.filePath,m.clientTasks,m.createdDate) FROM MediaFile m ORDER BY m.id DESC")
    Page<MediaFileModel> findAllMediaFilesWithPagination(Pageable pageable);

    @Query("select new kg.itacademy.gsg.models.MediaFileModel(m.id,m.title,m.filePath,m.clientTasks,m.createdDate) FROM MediaFile m WHERE m.clientTasks.id=:ctId ORDER BY m.id DESC")
    Page<MediaFileModel> findAllMediaFilesByClientTasksId(@Param("ctId") Long ctId, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "delete FROM gsg_mediafiles WHERE  client_task_id =:ct_id", nativeQuery = true)
    void deleteMediaFileByClientTask(@Param("ct_id") Long id);
}
