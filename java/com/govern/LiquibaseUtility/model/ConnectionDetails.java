/**
 * 
 */
package com.govern.LiquibaseUtility.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Shrirang.Brahmapurikar
 *
 */
@Data
@AllArgsConstructor
public class ConnectionDetails {
	
	private String sqlServer;
	private String dbName;
	private String dbUserName;
	private String dbPassword;
	
	public String getSqlServer() {
		return sqlServer;
	}

	public void setSqlServer(String sqlServer) {
		this.sqlServer = sqlServer;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbUserName() {
		return dbUserName;
	}

	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public ConnectionDetails() {
		
	}

}
