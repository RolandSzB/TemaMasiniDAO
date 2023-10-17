package masini.main;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import masini.dao.*;
import masini.helper.*;
import masini.pojo.*;

public class Main {

	public static void main(String[] args) throws SQLException {

		ArrayList<Masini> masini = MasiniDAO.getAll();
		for (Masini m : masini) {
			System.out.println(m.getId() + "   " + m.getTip_masina());
		}

		Masini m1 = MasiniDAO.getById(1);
		if (m1 != null) {
			System.out.println("Masina cu id=1 are tip " + m1.getTip_masina());
		} else {
			System.out.println("Nu exista cu id 1 ");
		}

		m1.setId(8);
		m1.setTip_masina("Audi");
		boolean actualizat = MasiniDAO.update(m1);
		if (actualizat == true) {
			System.out.println("Masina a fost actualizat");
		} else {
			System.out.println("Masina nu a fot gasit in db");
		}
		
//		String deleted = MasiniDAO.delete("BMW");
//		System.out.println(deleted);
//		
		Date fabricatie = new Date(System.currentTimeMillis());
		Masini masinaNoua = new Masini("Toyota", 4, fabricatie);
		 MasiniDAO.create(masinaNoua);
		 
		
		 
		MasiniHelper.closeConnection();
	}

}
