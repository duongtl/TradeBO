package com.bo.trade.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "result")
public class ResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "method_id")
    private Long methodId;

    @Column(name = "order_type")
    private Integer orderType;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "is_win")
    private Boolean isWin;

    @Column(name = "time_create")
    private Timestamp timeCreate;

    @Column(name = "created_at")
    private Timestamp createdAt;

}
