package com.example.kkm_back.Domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Report {
    private long report_id;
    private long report_category;
    private long reporter_id;
    private long reported_id;
    private String comment;

    public Report(long report_id,long report_category,long reporter_id,long reported_id,String comment){
        this.report_id=report_id;
        this.report_category=report_category;
        this.reporter_id=reporter_id;
        this.reported_id=reported_id;
        this.comment=comment;
    }

}
