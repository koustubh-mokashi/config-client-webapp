package com.example.configclientwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

	@Value("${application.environment}")
	private String appEnv;

	@Autowired
	private ConfigP configP;

	@RequestMapping(method = RequestMethod.GET, value = "/env")
	public String message() {
		return String.format("Hello %s", appEnv + configP.getEnvironment());
	}

}
