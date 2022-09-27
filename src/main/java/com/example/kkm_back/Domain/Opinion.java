package com.example.kkm_back.Domain;

public class Opinion {
    private long op_id;
    private String title;
    private String description;

    public Opinion(long op_id,String title,String description){
        this.op_id=op_id;
        this.title=title;
        this.description=description;
    }

}
