package com.akshabi.firstrest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {
private String name;
private int points;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPoints() {
	return points;
}
public void setPoints(int points) {
	this.points = points;
}

public String toString() {
	return "Alien[name=" + name + ",points="+ points+"]";
}

}
