/**
 * 
 */
package com.govern.LiquibaseUtility.controller;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.govern.LiquibaseUtility.Service.LiquibaseService;
import com.govern.LiquibaseUtility.model.ConnectionDetails;

import liquibase.Liquibase;

/**
 * @author Shrirang.Brahmapurikar
 *
 */
@RestController
@RequestMapping("/liquibase")
public class LiquibaseController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(LiquibaseService.class);
	
	@Autowired
	private LiquibaseService liquibaseService;
	
	@CrossOrigin
	@PostMapping(value = "/init", consumes = "application/json", produces = "application/json")
	public void triggerLiquibase(@RequestBody ConnectionDetails connDetails[]) throws Exception {
		LOGGER.debug("Connection details coming from Community Database : " + connDetails);
		for (ConnectionDetails connDetail : connDetails) {
			liquibaseService.implementLiquibaseChange(connDetail.getSqlServer(), connDetail.getDbName(), connDetail.getDbUserName(), connDetail.getDbPassword());
			//LOGGER.debug("Status of thread : " + obj.isDone());
		}			
	}

}
