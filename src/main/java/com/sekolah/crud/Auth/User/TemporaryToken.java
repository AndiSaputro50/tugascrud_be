package com.sekolah.crud.Auth.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "table_temporary_token")
public class TemporaryToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;
    @Column(name = "expired_date")
    private Date expiredDate;
    @Column(name = "sekolah_id")
    private long sekolahId;

    public TemporaryToken() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public long getSekolahId() {
        return sekolahId;
    }

    public void setSekolahId(long sekolahId) {
        this.sekolahId = sekolahId;
    }
}
