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
/*  �NResultSetMetaDataDemo �{�� �d�ߵ��G�G

2
deptno(3, decimal), dname(12, varchar), 
100,IT,
200,Accounting,
300,Marketing,

�g�X���ɮ�OutputEmp.txt �� �ñN�C�@��̫᪺�r�I�R��
(���� ��if��)
*/
public class Homework2 {
	public static void main(String[] args) throws IOException {
		//�H�U���T�{�ɮץH�θ�Ƨ�(���ؿ�)�O�_�s�b
		File f = new File("C:\\JDBC\\workspace\\jdbc_hk\\src", "OutputEmp.txt"); 
		if (!f.exists()) {
			f.getParentFile().mkdirs();
			f.createNewFile();
		} else {
			f.createNewFile();
		}
        //�H�W���T�{�ɮץH�θ�Ƨ�(���ؿ�)�O�_�s�b
		
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

			PrintWriter pw = new PrintWriter(new FileWriter(f));  //�s�W���{��
			pw.println(count);                                    //�s�W���{�� 

			System.out.println(count);

			for (int i = 1; i <= count; i++) {
				System.out.print(rsmd.getColumnLabel(i) + "(" + rsmd.getColumnType(i) + ", " + rsmd.getColumnTypeName(i)
						+ "), ");
				
				//�H�U���s�W���{�� if...
				if (i != count) {             
					pw.write(rsmd.getColumnLabel(i) + "(" + rsmd.getColumnType(i) + ", " + rsmd.getColumnTypeName(i)
							+ "), ");
				} else {
					pw.write(rsmd.getColumnLabel(i) + "(" + rsmd.getColumnType(i) + ", " + rsmd.getColumnTypeName(i)
							+ ") ");
				}
				//�H�W���s�W���{�� else...
			}

			pw.write("\r\n"); //�s�W���{��  �b�g�X���ɮפ�����
			System.out.print("\n");

			while (rs.next()) {
				for (int i = 1; i <= count; i++) {
					
					//�H�U���s�W���{�� if...
					if (i != count) { 
						pw.write(rs.getString(i) + ",");
					} else {
						pw.write(rs.getString(i));
						pw.write("\r\n");
					}
					//�H�W���s�W���{�� else...
					
					System.out.print(rs.getString(i) + ",");
				}
				System.out.print("\n");
			}

			pw.close();  //�s�W���{�� �p�S������ �h�ɮפ��|�����g�X!!
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
