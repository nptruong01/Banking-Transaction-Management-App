package DAO;

import com.raven.chart.ModelChart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author MSI-VN
 */
public class ThongkeDAO extends Connect{


    public List<ModelChart> loadbieudocot() throws SQLException {
        List<ModelChart> data = new ArrayList<>();
        String sql =    "SELECT\n" +
                        "  CAST([date] AS DATE) AS Date,\n" +
                        "  SUM(CASE WHEN [type] = 'naptien' THEN [amount] ELSE 0 END) AS 'Nap tien',\n" +
                        "  SUM(CASE WHEN [type] = 'ruttien' THEN [amount] ELSE 0 END) AS 'Rut tien',\n" +
                        "  SUM(CASE WHEN [type] = 'chuyentien' THEN [amount] ELSE 0 END) AS 'Chuyen tien'\n" +
                        "FROM\n" +
                        "  giaodich\n" +
                        "GROUP BY\n" +
                        "  CAST([date] AS DATE), YEAR(CAST([date] AS DATE)), MONTH(CAST([date] AS DATE))\n" +
                        "ORDER BY\n" +
                        "  CAST([date] AS DATE) DESC";
        try (
            
             PreparedStatement preparedStatement = con.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                java.sql.Date date = resultSet.getDate("date");
                double nap = resultSet.getDouble("Nap tien");
                double rut = resultSet.getDouble("Rut tien");
                double chuyen = resultSet.getDouble("Chuyen tien");
                data.add(new ModelChart(date.toString(), new double[]{nap,rut,chuyen}));
            }
        }
        return data;
    }

    public List<ModelChart> loadbieudoduong() throws SQLException {
        List<ModelChart> data = new ArrayList<>();
        String sql = "SELECT CASE type\n" +
                    "    WHEN 'naptien' THEN 'Nap tien'\n" +
                    "    WHEN 'ruttien' THEN 'Rut tien'\n" +
                    "    WHEN 'chuyentien' THEN 'Chuyen tien'\n" +
                    "    ELSE type\n" +
                    "  END AS type_display,\n" +
                    "  COUNT(*) AS Qty\n" +
                    "FROM giaodich\n" +
                    "GROUP BY type\n" +
                    "ORDER BY\n" +
                    "  CASE\n" +
                    "    WHEN type = 'naptien' THEN 1\n" +
                    "    WHEN type = 'ruttien' THEN 2\n" +
                    "    WHEN type = 'chuyentien' THEN 3\n" +
                    "    ELSE 4\n" +
                    "  END" ;
        try (
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
            String productName = resultSet.getString(1);
            int qty = resultSet.getInt(2);
            data.add(new ModelChart(productName, new double[]{qty}));
        }
        return data;
    }
}

}
