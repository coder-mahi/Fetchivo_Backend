package com.mahesh.fetchivo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.mahesh.fetchivo.Platform;
import com.mahesh.fetchivo.DownloadStatus;
import lombok.*;
import java.time.*;

@Data
@Document(collection = "download_requests")
public class DownloadRequest {
    @Id
    private String id;

    private String userId;         // who requested it
    private String videoUrl;       // original URL
    private Platform platform;     // YOUTUBE, INSTAGRAM, etc.

    private DownloadStatus status; // PENDING, COMPLETED, FAILED
    private LocalDateTime requestedAt;
    private LocalDateTime completedAt;

    private String videoId; // Reference to VideoMetadata
}
