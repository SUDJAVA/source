package com.om.hib.test;

import java.util.List;

import com.om.hib.dao.HelicopterDAO;
import com.om.hib.dto.HelicopterDTO;

public class Tester {

	public static void main(String[] args) {
		HelicopterDTO helicopter = new HelicopterDTO();
		helicopter.sethCountryName("ApppA");
		helicopter.setHName("hhh");
		helicopter.sethPrice(57.23);
		HelicopterDAO dao = new HelicopterDAO();
		//dao.save(helicopter);
      // dao.fetchNameAndPrice();
		//dao.fetchNameAndPrice(42);
		/*
		 * //1.fetch based on country name HelicopterDTO
		 * hdto=dao.fetchByCountryName("IND"); System.out.println(hdto);
		 * //2.fetch based on name or, price HelicopterDTO
		 * heldto=dao.fetchBasedByNameOrPrice(null,768.23);
		 * System.out.println(heldto);
		 * 
		 * //3.fetch only name based on price String
		 * hedto=dao.fetchNameByPrice(768.23);
		 * System.out.println("#####>>>Helicopter Name Is:="+hedto);
		 * 
		 * //4.fetch id based on name & country name & price int
		 * i=dao.fetchIdBYNameCnamePrice("AryaHeli","IND",568.23);
		 * System.out.println
		 * ("#####>>>ID for AryaHeli, IND, RS.568.23  is:="+i);
		 * 
		 * //5.fetch different helicopter name List<HelicopterDTO>
		 * list=dao.getHelicopterList(); if(list!=null){
		 * System.out.println("Size:"+list.size()); for (HelicopterDTO dto :
		 * list) { System.out.println("HelicopterName:"+dto.getHName());
		 * //6.fetch single row,multi columns dao.fetchBrandAndPrice(3); }
		 * 
		 * }
		 */
		dao.fetchBYcountryName("Ind");

	}

}
