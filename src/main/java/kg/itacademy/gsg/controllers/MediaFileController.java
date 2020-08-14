package kg.itacademy.gsg.controllers;

import kg.itacademy.gsg.entities.MediaFile;
import kg.itacademy.gsg.entities.User;
import kg.itacademy.gsg.models.MediaFileModel;
import kg.itacademy.gsg.models.NotificationModel;
import kg.itacademy.gsg.models.SomeFile;
import kg.itacademy.gsg.services.MediaFileService;
import kg.itacademy.gsg.services.NotificationService;
import kg.itacademy.gsg.services.impls.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mediaFile")
public class MediaFileController {
    @Autowired
    private MediaFileService mediaFileService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private NotificationService notificationService;

    User user;

    @GetMapping(value = "/{taskId}/list")
    public String getMediaFileList(@PathVariable("taskId") Long taskId, @PageableDefault(5) Pageable pageable, Model model, Authentication authentication) {
        getUserInfo(authentication);
        List<NotificationModel> notificationList = notificationService.getAllNotificationsByUserId(user.getId());
        List<NotificationModel> posterURL = new ArrayList<>();
        int count = 0;
        for (NotificationModel notif: notificationList ) {
            if (notif.getPoster()!=null && count<3){
                posterURL.add(notif);
                count++;
            }
        }
        model.addAttribute("posterURL", posterURL);
        Page<MediaFileModel> mediaFileList = mediaFileService.findAllMediaFilesByClientTasksId(taskId, pageable);
        model.addAttribute("fileList", mediaFileList);
        model.addAttribute("user", user);
        model.addAttribute("notificationList", notificationList);
        return "admin/list_of_mediaFiles";
    }

    @PostMapping(value = "/{taskId}/create")
    public String addMediaFIle(@PathVariable("taskId") Long taskId, @Valid @ModelAttribute("somefile") SomeFile someFile) throws IOException {
        mediaFileService.saveMediaFile(someFile, taskId);
        return "redirect:/mediaFile/" + taskId + "/list";
    }

    @RequestMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("id") Long id) throws IOException {
        MediaFile mediaFile = mediaFileService.getMediaFileById(id);
        Path path = Paths.get(mediaFile.getFilePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + mediaFile.getTitle())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }


    @PostMapping(value = "/{taskId}/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        mediaFileService.deleteMediaFileById(id);
        return "redirect:/mediaFile/list";
    }

    private void getUserInfo(Authentication authentication) {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        user = userService.findByEmail(userPrincipal.getUsername());
    }
}