package app;

import static utils.Constants.PASSWORD;
import static utils.Constants.URL;
import static utils.Constants.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Exercise02 {

	private static String[] getColumnNames(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		String[] output = new String[count];
		for (int i = 0; i < output.length; i++) {
			output[i] = rsmd.getColumnName(i + 1);
		}
		return output;
	}

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement("select EMPNO, ENAME, JOB from EMP");
				ResultSet rs = pstmt.executeQuery();) {
			String[] result = getColumnNames(rs);
			for (String str : result) {
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
