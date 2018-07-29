package homework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/*  將ResultSetMetaDataDemo 程式 查詢結果：

2
deptno(3, decimal), dname(12, varchar), 
100,IT,
200,Accounting,
300,Marketing,

寫出至檔案OutputEmp.txt 內 並將每一行最後的逗點刪除
(提示 用if做)
*/
public class Homework2 {
	public static void main(String[] args) throws IOException {
		//以下為確認檔案以及資料夾(父目錄)是否存在
		File f = new File("C:\\JDBC\\workspace\\jdbc_hk\\src", "OutputEmp.txt"); 
		if (!f.exists()) {
			f.getParentFile().mkdirs();
			f.createNewFile();
		} else {
			f.createNewFile();
		}
        //以上為確認檔案以及資料夾(父目錄)是否存在
		
		Connection conn = null;
		try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");

			String qryStmt = "SELECT * FROM department";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();


			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();

			PrintWriter pw = new PrintWriter(new FileWriter(f));  //新增的程式
			pw.println(count);                                    //新增的程式 

			System.out.println(count);

			for (int i = 1; i <= count; i++) {
				System.out.print(rsmd.getColumnLabel(i) + "(" + rsmd.getColumnType(i) + ", " + rsmd.getColumnTypeName(i)
						+ "), ");
				
				//以下為新增的程式 if...
				if (i != count) {             
					pw.write(rsmd.getColumnLabel(i) + "(" + rsmd.getColumnType(i) + ", " + rsmd.getColumnTypeName(i)
							+ "), ");
				} else {
					pw.write(rsmd.getColumnLabel(i) + "(" + rsmd.getColumnType(i) + ", " + rsmd.getColumnTypeName(i)
							+ ") ");
				}
				//以上為新增的程式 else...
			}

			pw.write("\r\n"); //新增的程式  在寫出的檔案中換行
			System.out.print("\n");

			while (rs.next()) {
				for (int i = 1; i <= count; i++) {
					
					//以下為新增的程式 if...
					if (i != count) { 
						pw.write(rs.getString(i) + ",");
					} else {
						pw.write(rs.getString(i));
						pw.write("\r\n");
					}
					//以上為新增的程式 else...
					
					System.out.print(rs.getString(i) + ",");
				}
				System.out.print("\n");
			}

			pw.close();  //新增的程式 如沒有關閉 則檔案不會完全寫出!!
			rs.close();
			stmt.close();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		} 
		finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class ResultSetMetaDataDemo
