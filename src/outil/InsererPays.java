package outil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Pays;
import test.HibernateUtil;

public class InsererPays {

	public static void main(String[] args) {
		Session session = null;
		session = HibernateUtil.instance().openSession();		
		Transaction tx = null;

		FileReader fr = null;
		BufferedReader br = null;
		try{
			fr = new FileReader("fichier/liste_pays.txt");
			br = new BufferedReader(fr);
			tx = session.beginTransaction();
			String ligne;
			String[] tab;
			Pays pays = null;
			while ((ligne = br.readLine()) != null){
				tab = ligne.split(";");
				pays = new Pays();
				pays.setCodeIsoPays(tab[0].trim().toLowerCase());
				pays.setNomPays(tab[1].trim().toLowerCase());
				session.persist(pays);
			}			
			tx.commit();
		}
		catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace(); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			session.close(); 
		}
	}

}
