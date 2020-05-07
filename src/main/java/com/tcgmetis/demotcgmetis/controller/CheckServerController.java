package com.tcgmetis.demotcgmetis.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tcgmetis.demotcgmetis.models.CompatibilityStatus;
import com.tcgmetis.demotcgmetis.utils.GetOSAndVersiondetailsUsingScriptUtils;
import com.tcgmetis.demotcgmetis.utils.OSInfo;

@RestController
public class CheckServerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CheckServerController.class);
	
	@GetMapping("/check/{hostip:.+}")
	public ResponseEntity<CompatibilityStatus>  checkSystem(@PathVariable String hostip) {	
		
		
		System.out.println("received hostname === "+ hostip);
		
		String getOSVersionScript="lsb_release -a | grep -E 'Distributor ID|Release'";
		String getServiceDetails="service --status-all | grep docker";
		
		GetOSAndVersiondetailsUsingScriptUtils osAndVersion=new GetOSAndVersiondetailsUsingScriptUtils();
		String recOsAndVersion=osAndVersion.getOSAndVersionDetail(hostip,getOSVersionScript);
		
		System.out.println("rec od and version "+ recOsAndVersion);
        
        CompatibilityStatus compStatus=new CompatibilityStatus(0, "Success");
		
		return ResponseEntity.ok().body(compStatus);
	}	
	
	
	
	
	public void getOSAndVersionDetailsOfServer() {
		String[] winVersions = {"7", "10.0"};
		String[] unixVersions = {"16.04", "18.04"};
		String[] macVersions = {"7", "8", "9"};	
		
		System.out.println("OS: " + OSInfo.getOs());
        System.out.println("OS version: " + OSInfo.getOs().getVersion());
        System.out.println("Is mac? " + OSInfo.OS.MAC.equals(OSInfo.getOs())); 
        
        if(!StringUtils.isEmpty(OSInfo.OS.WINDOWS) && !StringUtils.isEmpty(OSInfo.getOs().getVersion()) ) {
        	
        	boolean result = Arrays.stream(winVersions).anyMatch(OSInfo.getOs().getVersion()::equals);
    		if (result) {
    			logger.info("check for windows Os dependency");
    		}
        	
        	
        }else if(!StringUtils.isEmpty(OSInfo.OS.UNIX) && !StringUtils.isEmpty(OSInfo.getOs().getVersion())){
        	
        	boolean result = Arrays.stream(winVersions).anyMatch(OSInfo.getOs().getVersion()::equals);
    		if (result) {
    			logger.info("check for Unix Os dependency");            	
    		}
        	
        }else if(!StringUtils.isEmpty(OSInfo.OS.MAC) && !StringUtils.isEmpty(OSInfo.getOs().getVersion())) {
        	boolean result = Arrays.stream(macVersions).anyMatch(OSInfo.getOs().getVersion()::equals);
    		if (result) {
    			logger.info("check for MAC Os dependency");           	
    		}
        	
        	
        }else {
        	logger.info("check for Others Os dependency");
        }  
	}
	
	

}
