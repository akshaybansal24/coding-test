package com.synthesis.coding.codingtest.logging;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class CustomLogging extends PatternLayout{

	private String patternsProperty;
	private Optional<Pattern> pattern;

	public String getPatternsProperty() {
	    return patternsProperty;
	}

	public void setPatternsProperty(String patternsProperty) {
	    this.patternsProperty = patternsProperty;
	    if (this.patternsProperty != null) {
	        this.pattern = Optional.of(Pattern.compile(patternsProperty, Pattern.MULTILINE));
	    } else {
	        this.pattern = Optional.empty();
	    }
	}

	    @Override
	    public String doLayout(ILoggingEvent event) {
	        final StringBuilder message = new StringBuilder(super.doLayout(event));
	        System.out.println(message);
	        if (pattern.isPresent()) {
	            Matcher matcher = pattern.get().matcher(message);
	            while (matcher.find()) {

	                int group = 1;
	                while (group <= matcher.groupCount()) {
	                    if (matcher.group(group) != null) {
	                       int startPos = message.lastIndexOf("=") + 1;
	                       while(startPos < message.length()-1) {
	                    	   message.setCharAt(startPos, '*');
	                    	   startPos++;
	                       }
	                    }
	                    group++;
	                }
	            }
	        }
	        return message.toString();
	    }
}
