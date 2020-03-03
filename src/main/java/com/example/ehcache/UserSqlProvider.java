package com.example.ehcache;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

/**
 * @author shizhiguo
 * @version 1.0.
 * @Description
 * @Date 2019/12/7
 */
public class UserSqlProvider {

    public String selectByName(String name){
        return new SQL(){
            {
                SELECT("*");
                FROM("db_user.T_USER");

                if(!StringUtils.isEmpty(name)){
                    WHERE("name = #{name}");
                }
            }
        }.toString();
    }
}
