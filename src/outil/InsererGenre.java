package outil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Genre;
import pojo.Pays;
import test.HibernateUtil;

public class InsererGenre {

	public static void main(String[] args) {
		Session session = null;
		session = HibernateUtil.instance().openSession();		
		Transaction tx = null;

		FileReader fr = null;
		BufferedReader br = null;
		try{
			fr = new FileReader("fichier/liste_genre.txt");
			br = new BufferedReader(fr);
			tx = session.beginTransaction();
			String ligne;
			Genre genre = null;
			while ((ligne = br.readLine()) != null){
				genre = new Genre();
				genre.setNomGenre(ligne.trim().toLowerCase());
				session.persist(genre);
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
