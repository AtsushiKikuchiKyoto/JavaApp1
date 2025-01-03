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

    @Select("SELECT * FROM finbookDemo WHERE id = #{id}")
    KaikeiFinbookEntity findById(@Param("id") Long id);

    @Select("SELECT book.id, book.name, book.fiscal_year AS fiscalYear, " +
            "book.start_date AS startDate, book.end_date AS endDate," +
            "book.group_id AS groupID, gp.name AS groupName " +
            "FROM finbookDemo AS book " +
            "JOIN groupDemo AS gp ON book.group_id = gp.id " +
            "WHERE book.id = #{id}")
    FinbookWithGroupDTO findByIdBindGroupName(@Param("id") Long id);
}