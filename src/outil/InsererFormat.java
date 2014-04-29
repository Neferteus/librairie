package outil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Format;
import pojo.Genre;
import test.HibernateUtil;

public class InsererFormat {

	public static void main(String[] args) {
		Session session = null;		
		Transaction tx = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		session = HibernateUtil.instance().openSession();
		try{
			fr = new FileReader("fichier/liste_format.txt");
			br = new BufferedReader(fr);
			tx = session.beginTransaction();
			String ligne;
			Format format = null;
			while ((ligne = br.readLine()) != null){
				format = new Format();
				format.setNomFormat(ligne.trim().toLowerCase());
				session.persist(format);
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
