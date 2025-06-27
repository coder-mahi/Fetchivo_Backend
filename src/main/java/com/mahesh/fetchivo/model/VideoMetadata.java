package com.mahesh.fetchivo.model;
import lombok.Data;
import org.springframework.data.annotation.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.*;
import java.time.LocalDateTime;
import com.mahesh.fetchivo.*;

@Document(collection="video_metadata")
@Data
public class VideoMetadata {
    @Id
    private String id;

    private String title;
    private String videoUrl;
    private String downloadedFilePath;
    private String format;
    private long fileSize;
    private String thumbnailUrl;

    private Platform platform;
    private LocalDateTime downloadedAt;
    private String requestedByUserId;
}
