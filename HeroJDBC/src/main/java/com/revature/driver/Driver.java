package com.revature.driver;

import java.sql.SQLException;

import com.revature.beans.SuperHero;
import com.revature.daoimpl.PowersDAOImpl;
import com.revature.daoimpl.SuperHeroDAOIMPL;

public class Driver {

	public static void main(String[] args) {
		SuperHeroDAOIMPL shdi = new SuperHeroDAOIMPL();
		PowersDAOImpl pdi = new PowersDAOImpl();
		
		/*try {
			pdi.createPowers("flight");
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		try {
			shdi.createSuperHero("FatMan");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
