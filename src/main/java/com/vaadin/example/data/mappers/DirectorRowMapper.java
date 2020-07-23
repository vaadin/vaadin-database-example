package com.vaadin.example.data.mappers;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.vaadin.example.data.entity.Director;
import org.springframework.jdbc.core.RowMapper;

public class DirectorRowMapper implements RowMapper<Director> {

    @Override
    public Director mapRow(ResultSet rs, int rowNum)
          throws SQLException {
        return new Director(rs.getString("name"));
    }
}
