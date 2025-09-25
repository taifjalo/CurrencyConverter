package dao;

import entity.Currency;
import datasource.MariaDbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CurrencyDao {

    public List<Currency> getAllCurrencies() {
        Connection conn = MariaDbConnection.getConnection();
        List<Currency> currencies = new ArrayList<>();
        String sql = "SELECT abbreviation, name, rateToUSD FROM currency";

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                currencies.add(new Currency(
                        rs.getString("abbreviation"),
                        rs.getString("name"),
                        rs.getDouble("rateToUSD")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currencies;
    }

    public double getRate(String abbreviation) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT rateToUSD FROM currency WHERE abbreviation = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, abbreviation);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getDouble("rateToUSD");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // indicates error
    }
}
