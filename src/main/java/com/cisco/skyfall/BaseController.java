package com.cisco.skyfall;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/", produces = { "application/json", "application/xml" })
public interface BaseController {
}