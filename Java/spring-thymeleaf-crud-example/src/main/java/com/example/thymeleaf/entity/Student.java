package com.example.thymeleaf.entity;

import com.example.thymeleaf.entity.utils.SensitiveDataUtils;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.example.thymeleaf.entity.utils.SensitiveDataUtils.anonymize;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
@EqualsAndHashCode(of = {"id"})
public class Student {
    @Transient
    private static final Logger logger = LoggerFactory.getLogger(Student.class);
    @Id
    private String id;

    private String name;
    private String email;
    private LocalDate birthday;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        logger.info("Created user {}", anonymize(this));
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", address=" + address +
                '}';
    }
}
