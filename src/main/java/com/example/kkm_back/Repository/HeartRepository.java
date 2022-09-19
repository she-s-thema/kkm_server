package com.example.kkm_back.Repository;

import com.example.kkm_back.Domain.Heart;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HeartRepository {
    @Insert("insert into Heart values(#{heart_id},#{post_id},#{post_owner_id},#{heart_user_id},#{heart_state})")
    @SelectKey
            (

                    statement="SELECT LAST_INSERT_ID(heart_id) from Heart",
                    keyProperty="heart_id",
                    before=false,
                    resultType=long.class,
                    statementType = StatementType.PREPARED
            )
    long insertHeart(Heart heart);

    //    @SelectKey(statement="CALL IDENTITY()", keyProperty="id", before=false, resultType=Long.class)
//    int insert(Coffee record);
//    @Insert("INSERT INTO Students(id, name , email) VALUES  (#{id}, #{name}, #{email})")
//    @SelectKey(statement="select SEQ_STUDENT.nextval FROM DUAL", keyProperty="id", before=true, resultType=int.class)
//    int insert(Student student);
    @Select("select COUNT(H.heart_id) from Post\n" +
            "inner join Heart H on Post.post_id = H.post_id\n" +
            "where Post.post_id=#{post_id} and heart_state=1")
    int getHeartCount(long post_id);

    @Update("Update Post\n" +
            "inner join Heart H on Post.post_id = H.post_id\n" +
            "set H.heart_state=2\n" +
            "where H.heart_id=#{heart_id}")
    void CancelHeart(long heart_id);
    @Update("Update Post\n" +
            "inner join Heart H on Post.post_id = H.post_id\n" +
            "set H.heart_state=1\n" +
            "where H.heart_id=#{heart_id}")
    void ReHeart(long heart_id);
}