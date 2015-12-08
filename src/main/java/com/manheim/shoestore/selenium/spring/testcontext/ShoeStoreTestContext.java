package com.manheim.shoestore.selenium.spring.testcontext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.manheim.shoestore.selenium.pageobjects.impl" })
public class ShoeStoreTestContext {

}
