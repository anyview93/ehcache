package com.example.ehcache.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.example.ehcache.UserSqlProvider;
import com.example.ehcache.bean.TUser;

@Mapper
public interface TUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_user.t_user
     *
     * @mbg.generated Sat Dec 07 14:07:15 CST 2019
     */
    @Delete({
        "delete from db_user.t_user",
        "where id = #{id,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_user.t_user
     *
     * @mbg.generated Sat Dec 07 14:07:15 CST 2019
     */
    @Insert({
        "insert into db_user.t_user (id, name, age, ",
        "sex)",
        "values (#{id,jdbcType=CHAR}, #{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}, ",
        "#{sex,jdbcType=VARCHAR})"
    })
    int insert(TUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_user.t_user
     *
     * @mbg.generated Sat Dec 07 14:07:15 CST 2019
     */
    @Select({
        "select",
        "id, name, age, sex",
        "from db_user.t_user",
        "where id = #{id,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR)
    })
    TUser selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_user.t_user
     *
     * @mbg.generated Sat Dec 07 14:07:15 CST 2019
     */
    @Select({
        "select",
        "id, name, age, sex",
        "from db_user.t_user",
        "order by age desc,name asc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR)
    })
    List<TUser> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_user.t_user
     *
     * @mbg.generated Sat Dec 07 14:07:15 CST 2019
     */
    @Update({
        "update db_user.t_user",
        "set name = #{name,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "sex = #{sex,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(TUser record);

    @SelectProvider(type = UserSqlProvider.class, method="selectByName")
    List<TUser> selectByName(@Param("name") String name);
}
