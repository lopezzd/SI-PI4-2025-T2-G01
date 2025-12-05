package com.joaohenrique.ailinter.model.report;

import com.joaohenrique.ailinter.model.user.User;
import com.joaohenrique.ailinter.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String filename;

    @Lob
    private String content;

    @Lob
    private String analysis;

    private LocalDateTime createdAt;
}
