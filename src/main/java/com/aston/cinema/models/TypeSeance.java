package com.aston.cinema.models;


enum TypeSeance {

		IMAX("IMAX",6),
		QUATREDX("4DX",8),
		TROISD("3D",3);
	 
	    private String url;
	    private float prix;
	    
	    TypeSeance(String url, float prix) {
	    	this.url = url;
	    	this.prix = prix;
	    }
	    
	    public String getUrl() {
	    	return this.url;
	    	
	    }
	    
	    public double getPrix() {
	    	return this.prix;
	    }
}
