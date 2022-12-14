package ru.t1.dkononov.tm.api.repository;

import org.apache.ibatis.annotations.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.t1.dkononov.tm.dto.model.SessionDTO;

import java.util.List;

public interface ISessionRepository {

    @Insert("INSERT INTO tm.tm_session (id,user_id,date,role) " +
            "VALUES (#{id},#{userId},#{date},#{role})")
    void add(@NotNull SessionDTO session);

    @Delete("DELETE FROM tm.tm_session WHERE user_id = #{userId}")
    void clear(@NotNull @Param("userId") String userId);

    @Select("SELECT * FROM tm.tm_session WHERE user_id = #{userId}")
    @Results(value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "date", column = "date"),
            @Result(property = "role", column = "role"),
            @Result(property = "id", column = "id")
    })
    @Nullable List<SessionDTO> findAllWithUserId(@NotNull @Param("userId") String userId);

    @Select("SELECT * FROM tm.tm_session")
    @Nullable List<SessionDTO> findAll();

    @Select("SELECT * FROM tm.tm_session WHERE id = #{id} LIMIT 1")
    @Results(value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "date", column = "date"),
            @Result(property = "role", column = "role"),
            @Result(property = "id", column = "id")
    })
    @Nullable SessionDTO findById(@NotNull @Param("id") String id);

    @Select("SELECT * FROM tm.tm_session WHERE user_id = #{userId} LIMIT 1 OFFSET #{index}")
    @Results(value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "date", column = "date"),
            @Result(property = "role", column = "role"),
            @Result(property = "id", column = "id")
    })
    @Nullable SessionDTO findByIndex(@NotNull @Param("userId") String userId, @NotNull @Param("index") Integer index);

    @Delete("DELETE FROM tm.tm_session WHERE user_id = #{userId} AND id = #{id}")
    void remove(@NotNull SessionDTO session);

}
