package kz.sitedev.springmid.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "jobs_cvs")
@Setter
@Getter
@ToString
public class JobCv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "job_applied")
    private int jobApplied;
    @Column(name = "cv_applied")
    private int cvApplied;

    @Column(name = "job_id")
    private Long jobId;

    @Column(name = "cv_id")
    private Long cvId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", insertable = false, updatable = false)
    private Cv cv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", insertable = false, updatable = false)
    private Job job;
}
