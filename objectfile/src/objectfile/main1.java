package objectfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class main1 {
    static ArrayList<article> listArticle = new ArrayList();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
	menu();
    }

    private static void menu() throws IOException, ClassNotFoundException {
	File arxiu = new File("botiga.txt");
	if (arxiu.exists()) {
	    FileInputStream i = new FileInputStream("botiga.txt");
	    ObjectInputStream oi = new ObjectInputStream(i);
	    listArticle.clear();
	    while (i.available() > 0) {
		article var_Article = (article) oi.readObject();
		listArticle.add(var_Article);
	    }
	}
	int opcio = 0;
	while (opcio != 4) {
	    Scanner lector = new Scanner(System.in);
	    System.out.println("------------------------------------");
	    System.out.println("BENVINGUT A LA PRÀCTICA 1 D'OBJECTES");
	    System.out.println("------------------------------------");
	    System.out.println("Escull alguna de les opcions següents!");
	    System.out.println("------------------------------------");
	    System.out.println("1. Demanar dades del producte i insertar-les al fitxer.");
	    System.out.println("2. Mostrar el preu d'un determinat producte.");
	    System.out.println("3. Modificar el preu d'un determinar producte.");
	    System.out.println("4. Sortir.");
	    System.out.println("------------------------------------");
	    opcio = lector.nextInt();
	    System.out.println("------------------------------------");
	    if (opcio == 1) {
		insertarArticle();
	    }
	    if (opcio == 2) {
		mostrarPreu();
	    }
	    if (opcio == 3) {
	    }
	}
    }

    private static void insertarArticle() throws IOException, ClassNotFoundException {
	Scanner lector = new Scanner(System.in);
	int quantitatArticlesPerEntrar = 0;
	int contadorWhile = 0;
	String identificadorArticle = "";
	String nom = "";
	String categoria = "";
	String preu = "";
	System.out.print("Quants articles desitja entrar? ");
	quantitatArticlesPerEntrar = lector.nextInt();
	lector.nextLine();
	FileOutputStream f = new FileOutputStream("botiga.txt");
	ObjectOutputStream o = new ObjectOutputStream(f);
	article article = new article();
	while (contadorWhile < quantitatArticlesPerEntrar) {
	    article = new article();
	    System.out.print("Introdueix una ID per l'Article: ");
	    identificadorArticle = lector.nextLine();
	    article.setID(identificadorArticle);
	    System.out.print("Introdueix el nom de l'Article: ");
	    nom = lector.nextLine();
	    article.setNom(nom);
	    System.out.print("Introdueix la categoria de l'Article: ");
	    categoria = lector.nextLine();
	    article.setCategoria(categoria);
	    System.out.print("Introdueix el preu de l'Article: ");
	    preu = lector.nextLine();
	    article.setPreu(preu);
	    listArticle.add(article);
	    contadorWhile++;
	}
	for (int x = 0; x < listArticle.size(); x++) {
	    
	    article varArticle = listArticle.get(x);
	    o.writeObject(varArticle);
	}
	
	o.close();
    }

    private static void mostrarPreu() throws IOException, ClassNotFoundException {
	Scanner lector = new Scanner(System.in);
	article article = new article();
	FileInputStream i = new FileInputStream("botiga.txt");
	ObjectInputStream oi = new ObjectInputStream(i);
	String buscador = "";
	System.out.print("Introdueix la ID o nom de l'Article: ");
	buscador = lector.nextLine();
	for (int x = 0; x < listArticle.size(); x++) {
	    article a = (article) oi.readObject();
	    if ((listArticle.get(x).getID().equals(buscador))
		    || (listArticle.get(x).getNom().equals(buscador))) {
		System.out.println(listArticle.get(x));
	    }
	}
	oi.close();
	/*
	 * if (identificadorArticle == id)//||(article.getNom().equals(nom))) {
	 * System.out.print("Entreu el preu nou de l'article: "); preuNou =
	 * lector.nextDouble(); article.setPreu(preuNou); }
	 */
    }
}