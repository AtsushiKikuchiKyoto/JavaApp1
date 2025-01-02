package in.techcamp.firstapp;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;

@Mapper
public interface KaikeiFinbookRepository {
    @Insert("INSERT INTO finbookDemo (name, fiscal_year, start_date, end_date, group_id) VALUES (#{name}, #{fiscalYear}, #{startDate}, #{endDate}, #{groupId})")
    void insert(String name , long fiscalYear , LocalDate startDate , LocalDate endDate , long groupId );
}
