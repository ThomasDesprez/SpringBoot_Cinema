package com.aston.cinema.models;


public enum TypeSeance {

		IMAX("IMAX",6),
		QUATREDX("4DX",8),
		TROISD("3D",3);
	 
	    private String type;
	    private float prix;
	    
	    TypeSeance(String url, float prix) {
	    	this.type = url;
	    	this.prix = prix;
	    }
	    
	    public String getType() {
	    	return this.type;
	    	
	    }
	    
	    public float getPrix() {
	    	return this.prix;
	    }
}
