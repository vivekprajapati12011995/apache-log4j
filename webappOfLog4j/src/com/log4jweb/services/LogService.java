package com.log4jweb.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.module1.Cycle;
import com.module3.Bike;
import com.root.RunApp;
import com.root.Vehicle;

@Path("/logservice")
public class LogService {
	private static final Logger logger = Logger.getRootLogger();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getLoggingDetails(){
		RunApp.start();
		logger.info("data is loading!!!!!!!!!!!!!!!!!");
		int id = 2;
		Enumeration loggers = LogManager.getCurrentLoggers();
		List<LoggerDetails> loggerDetailsList = new ArrayList<LoggerDetails>();
		LoggerDetails rootLogger = new LoggerDetails();
		rootLogger.setId(1);
		rootLogger.setModuleName(LogManager.getRootLogger().getName());
		rootLogger.setLevel(LogManager.getRootLogger().getLevel().toString());
		loggerDetailsList.add(rootLogger);
		
		while (loggers.hasMoreElements()) {
			LoggerDetails loggerDetails = new LoggerDetails();
			Logger logger = (Logger) loggers.nextElement();
			loggerDetails.setId(id);
			loggerDetails.setModuleName(logger.getName());
			loggerDetails.setLevel(logger.getLevel().toString());
			loggerDetails.setAdditivity(logger.getAdditivity());
			loggerDetailsList.add(loggerDetails);
			id++;
		}
		try {
			String json = new ObjectMapper().writeValueAsString(loggerDetailsList);
			return json;
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error occured";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String changeLogLevel( @FormParam("moduleName") final String moduleName,@FormParam("level") final String logLevel){
		System.out.println(moduleName+"     "+logLevel);
		if("root".equalsIgnoreCase(moduleName)){
			Logger rootLogger= Logger.getRootLogger();
			if ("DEBUG".equalsIgnoreCase(logLevel)) {
				rootLogger.setLevel(Level.DEBUG);
			} else if ("INFO".equalsIgnoreCase(logLevel)) {
				rootLogger.setLevel(Level.INFO);
			} else if ("WARN".equalsIgnoreCase(logLevel)) {
				rootLogger.setLevel(Level.WARN);
			} else if ("ERROR".equalsIgnoreCase(logLevel)) {
				rootLogger.setLevel(Level.ERROR);
			} else if ("FATAL".equalsIgnoreCase(logLevel)) {
				rootLogger.setLevel(Level.FATAL);
			}else if ("TRACE".equalsIgnoreCase(logLevel)) {
				rootLogger.setLevel(Level.TRACE);
			}else{
				return "level is not recognized";
			}
		}
		else{
			Logger logger = Logger.getLogger(moduleName);
			if ("DEBUG".equalsIgnoreCase(logLevel)) {
				logger.setLevel(Level.DEBUG);
			} else if ("INFO".equalsIgnoreCase(logLevel)) {
				logger.setLevel(Level.INFO);
			} else if ("WARN".equalsIgnoreCase(logLevel)) {
				logger.setLevel(Level.WARN);
			} else if ("ERROR".equalsIgnoreCase(logLevel)) {
				logger.setLevel(Level.ERROR);
			} else if ("FATAL".equalsIgnoreCase(logLevel)) {
				logger.setLevel(Level.FATAL);
			}else if ("TRACE".equalsIgnoreCase(logLevel)) {
				logger.setLevel(Level.TRACE);
			}else{
				return "level is not recognized";
			}
		}
		return "log level changed successfully";
	}
	
	@GET
	@Path("/logs/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response downloadLogFile( @QueryParam("moduleName") final String moduleName){
		System.out.println("module name is :"+moduleName);
		StreamingOutput fileStream =  new StreamingOutput() 
        {
		
            @Override
            public void write(java.io.OutputStream output) throws IOException, WebApplicationException 
            {
                try
                {
                    java.nio.file.Path path = Paths.get("logs/"+moduleName+".log");
                    System.out.println(path);
                    byte[] data = Files.readAllBytes(path);
                    
                    output.write(data);
                    output.flush();
                } 
                catch (Exception e) 
                {
                    throw new WebApplicationException();
                }
            }
        };
        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition","attachment; filename =" +moduleName+".log")
                .build();
    }
	
	@POST
	@Path("/additivity")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public void setAdditivity(@FormParam("moduleName") final String moduleName,@FormParam("additivity") final Boolean additivity){
		System.out.println(moduleName+"  "+additivity);
		Logger logger = Logger.getLogger(moduleName);
		logger.setAdditivity(additivity);
	}
	
}
