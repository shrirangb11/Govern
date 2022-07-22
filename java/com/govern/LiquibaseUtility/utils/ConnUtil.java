/**
 * 
 */
package com.govern.LiquibaseUtility.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.govern.LiquibaseUtility.constants.ApplicationConstant.HOSTNAME_IN_CERTIFICATE;

/**
 * @author Shrirang.Brahmapurikar
 *
 */
@Component
public class ConnUtil {

	private static Logger LOGGER = LoggerFactory.getLogger(ConnUtil.class);

	@Value("${spring.liquibase.change-log}")
	private String changeLogPath;

	@Value("${database.logout.time}")
	private String logoutTime;

	@Value("${database.encrypt}")
	private String encrypt;

	@Value("${database.trust.certificate.server}")
	private String trustCertificate;

	public String createConnectionString(String sqlServerName, String dbName) {
		String connectionString = "";
		connectionString = "jdbc:sqlserver://" + sqlServerName + ".database.windows.net:1433;database=" + dbName
				+ ";encrypt=" + encrypt + ";trustServerCertificate=" + trustCertificate + ";hostNameInCertificate="
				+ HOSTNAME_IN_CERTIFICATE + ";loginTimeout=" + logoutTime + ";"
				+ "connectRetryInterval=10;connectRetryCount=1;maxResultBuffer=-1;sendTemporalDataTypesAsStringForBulkCopy=true;delayLoadingLobs=true;useFmtOnly=false;useBulkCopyForBatchInsert=false;cancelQueryTimeout=-1;sslProtocol=TLS;jaasConfigurationName=SQLJDBCDriver;statementPoolingCacheSize=0;serverPreparedStatementDiscardThreshold=10;enablePrepareOnFirstPreparedStatementCall=false;fips=false;socketTimeout=0;authentication=NotSpecified;authenticationScheme=nativeAuthentication;xopenStates=false;sendTimeAsDatetime=true;replication=false;trustStoreType=JKS;TransparentNetworkIPResolution=true;serverNameAsACE=false;sendStringParametersAsUnicode=true;selectMethod=direct;responseBuffering=adaptive;queryTimeout=-1;packetSize=8000;multiSubnetFailover=false;lockTimeout=-1;lastUpdateCount=true;disableStatementPooling=true;columnEncryptionSetting=Disabled;applicationName=Microsoft JDBC Driver for SQL Server;applicationIntent=readwrite;";

		LOGGER.info("Connection string for dB : " + connectionString);
		return connectionString;
	}

}
