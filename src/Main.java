import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Create a new instance of the MetierProduitImpl class
        MetierProduitImpl metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu :");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son id.");
            System.out.println("3. Ajouter un nouveau produit dans la liste.");
            System.out.println("4. Supprimer un produit par id.");
            System.out.println("5. Quitter ce programme.");
            System.out.print("Choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme la ligne restante

            switch (choix) {
                case 1:
                    System.out.println("\nListe des produits !!! :");
                    for (Produit produit : metier.getAll()) {
                        System.out.println(produit);
                    }
                    break;

                case 2:
                    System.out.print("\nEntrez l'id du produit : ");
                    long idRecherche = scanner.nextLong();
                    Produit produitFound = metier.findById(idRecherche);
                    if (produitFound != null) {
                        System.out.println("Produit trouvé : " + produitFound);
                    } else {
                        System.out.println("Produit introuvable.");
                    }
                    break;

                case 3:
                    System.out.print("\nEntrez l'id : ");
                    long id = scanner.nextLong();
                    scanner.nextLine(); // Consomme la ligne restante
                    System.out.print("Entrez le nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez la marque : ");
                    String marque = scanner.nextLine();
                    System.out.print("Entrez le prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Consomme la ligne restante
                    System.out.print("Entrez la description : ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez le nombre en stock : ");
                    int stock = scanner.nextInt();

                    Produit nouveauProduit = new Produit(id, nom, marque, prix, description, stock);
                    metier.add(nouveauProduit);
                    System.out.println("Produit ajouté avec succès !");
                    break;

                case 4:
                    System.out.print("\nEntrez l'id du produit à supprimer : ");
                    long idSuppression = scanner.nextLong();
                    metier.delete(idSuppression);
                    System.out.println("Produit supprimé avec succès.\n");
                    break;

                case 5:
                    System.out.println("\nAu revoir !");
                    scanner.close();
                    return;

                default:
                    System.out.println("\nChoix invalide. Veuillez réessayer.");
            }
        }
    }
}