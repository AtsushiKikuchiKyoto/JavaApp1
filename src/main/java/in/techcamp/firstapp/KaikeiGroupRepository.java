package in.techcamp.firstapp;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface KaikeiGroupRepository {

    @Insert("insert into groupDemo (name, info) values (#{name}, #{info})")
    void insert(String name , String info);

    @Select("select * from groupDemo")
    List<KaikeiGroupEntity> findAll();

    @Select("SELECT * FROM groupDemo WHERE id = #{id}")
    KaikeiGroupDTO findById(@Param("id") Long id);

    @Update("UPDATE groupDemo SET name = #{name}, info = #{info} WHERE id = #{id}")
    void update(long id, String name, String info);

    @Delete("DELETE FROM groupDemo WHERE id = #{id}")
    void deleteById(Long id);
}
