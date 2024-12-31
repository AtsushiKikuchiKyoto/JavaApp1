package in.techcamp.firstapp;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KaikeiGroupRepository {

    @Insert("insert into groupDemo (name, info) values (#{name}, #{info})")
    void insert(String name , String info);

    @Select("select * from groupDemo")
    List<KaikeiGroupEntity> findAll();

    @Select("SELECT * FROM groupDemo WHERE id = #{id}")
    KaikeiGroupEntity findById(@Param("id") Long id);

}
