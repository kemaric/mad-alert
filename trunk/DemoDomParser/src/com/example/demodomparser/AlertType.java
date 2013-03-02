package com.example.demodomparser;

public enum AlertType {

	  WEATHER, NONVIOLENT, VIOLENT;

	  public String toString() {
	    switch (this) {
	      case WEATHER:
	        return "WEATHER";
	      case NONVIOLENT:
	        return "NONVIOLENT";
	      case VIOLENT:
	        return "VIOLENT";
	    }

	    return "";
	  }

	}
