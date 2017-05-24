package com.ubs.opsit.interviews;

public enum Light {

	Red("O", "R"), Yellow("O", "Y");

	private final String off;
	private final String on;

	Light(String off, String on) {
		this.off = off;
		this.on = on;
	}

	public String asDisplay(boolean whenOn) {
		return (whenOn)?on:off;
	}
}