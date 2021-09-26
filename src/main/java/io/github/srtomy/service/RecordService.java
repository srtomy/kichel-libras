package io.github.srtomy.service;

import io.github.srtomy.model.Record;
import io.github.srtomy.repository.RecordRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecordService implements RecordRepository {
    @Override
    public void create(io.github.srtomy.model.Record record) {
        try {
            var sql = "insert into records(time_duration, name) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, record.getTimeDuration());
            ps.setString(2, record.getName());

            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Record> findTopRecords() {
        var records = new ArrayList<Record>();
        try {
            var sql = "select top 10 id, name, time_duration, date from records order by time_duration asc";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Record record = new Record();
                record.setId(rs.getInt("ID"));
                record.setName(rs.getString("NAME"));
                record.setTimeDuration(rs.getInt("TIME_DURATION"));
                record.setDate(rs.getTimestamp("date").toLocalDateTime());
                records.add(record);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return records;
    }
}
