package by.peleng.task12GradlRest.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

import javax.persistence.*;
import javax.swing.*;
import java.time.LocalDateTime;

@Entity
@Table
@ToString(of = {"id","text"})
@EqualsAndHashCode(of = {"id"})
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({Views.Id.class})
    private long id;
    @JsonView({Views.IdName.class})
    private String text;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy,MM.dd HH.mm.ss")
    @JsonView({Views.FullMessage.class})
    @Column(updatable = false)
    private LocalDateTime creationDate;

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
