package in.techcamp.firstapp;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface KaikeiFinbookRepository {
    @Insert("INSERT INTO finbookDemo (name, fiscal_year, start_date, end_date, group_id) VALUES (#{name}, #{fiscalYear}, #{startDate}, #{endDate}, #{groupId})")
    void insert(String name , long fiscalYear , LocalDate startDate , LocalDate endDate , long groupId );

    @Select("SELECT * FROM finbookDemo WHERE group_id = #{id}")
    List<KaikeiFinbookEntity> findByGroupId(@Param("id") Long id);
}