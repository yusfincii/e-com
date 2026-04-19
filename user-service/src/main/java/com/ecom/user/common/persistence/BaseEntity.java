package com.ecom.user.common.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "version")
    @Version
    private Long version;

    @Column(name = "created_by")
    private UUID createdBy;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "updated_by")
    private UUID updatedBy;

    @Column(name = "update_time")
    private LocalDateTime updateTime;
}
