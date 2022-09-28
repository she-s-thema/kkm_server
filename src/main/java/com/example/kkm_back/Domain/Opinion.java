package com.example.kkm_back.Domain;

public class Opinion {
    private long op_id;
    private String title;
    private String description;
    private long write_user_id;

    public Opinion(long op_id,String title,String description,long write_user_id){
        this.op_id=op_id;
        this.title=title;
        this.description=description;
        this.write_user_id=write_user_id;
    }

}
