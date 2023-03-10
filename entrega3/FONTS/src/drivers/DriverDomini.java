package FONTS.src.drivers;

import FONTS.src.main.domain.classes.exceptions.*;
import FONTS.src.main.domain.controllers.CtrlDomini;
import FONTS.src.main.persistencia.excepcions.ErrorIntern;
import FONTS.src.main.persistencia.excepcions.NoExisteixPath;
import FONTS.src.main.persistencia.excepcions.PathJaExisteix;

import java.util.*;

/**
 * Driver del Controlador de Domini.
 */
public class DriverDomini {
    /** Controlador de Domini */
    private CtrlDomini cd;
    /** Scanner per l'entrada de dades */
    private static Scanner in;

    /**
     * Creadora per defecte.
     */
    public DriverDomini() {
        cd = new CtrlDomini();
        in = new Scanner(System.in);
    }

    /**
     * Main
     * @param args Arguments.
     */
    public static void main(String[] args) {
        DriverDomini dd = new DriverDomini();
        System.out.println("---------------------------------------");
        System.out.println("Driver de Domini (PROP Grup 32.3).\n");
        System.out.println("Per veure les funcionalitats prem la tecla '0'.");

        int input = Integer.parseInt(in.nextLine());
        while (input != -1) {
            switch (input) {
                case 0: {
                    dd.mostrarMenu();
                    break;
                }
                case 1: {
                    dd.testAltaDocument();
                    break;
                }
                case 2: {
                    dd.testBaixaDocument();
                    break;
                }
                case 3: {
                    dd.testObrirDocument();
                    break;
                }
                case 4: {
                    dd.testTancarDocument();
                    break;
                }
                case 5: {
                    dd.testEditarAutor();
                    break;
                }
                case 6: {
                    dd.testEditarTitol();
                    break;
                }
                case 7: {
                    dd.testEditarContingut();
                    break;
                }
                case 8: {
                    dd.testLlistarAutorsPerPrefix();
                    break;
                }
                case 9: {
                    dd.testLlistarKDocumentsSemblantsD();
                    break;
                }
                case 10: {
                    dd.testLlistarKDocumentsRellevantsPParaules();
                    break;
                }
                case 11: {
                    dd.testLlistarTitolsAutors();
                    break;
                }
                case 12: {
                    dd.testLlistarTitolsPerExpressioGuardada();
                    break;
                }
                case 13: {
                    dd.testLlistarTitolsPerExpressioNoGuardada();
                    break;
                }
                case 15: {
                    dd.testOrdenarAutors();
                    break;
                }
                case 16: {
                    dd.testOrdenarDocuments();
                    break;
                }
                case 14: {
                    dd.testLlistarContingutDocumentPerAutorTitol();
                    break;
                }
                case 17: {
                    dd.testAfegirExpressio();
                    break;
                }
                case 18: {
                    dd.testEliminarExpressio();
                    break;
                }
                case 19: {
                    dd.testModificarExpressio();
                    break;
                }
                case 20: {
                    dd.testConsultarExpressio();
                    break;
                }
                case 21: {
                    dd.testLlistarExpressions();
                    break;
                }
                case 22: {
                    dd.testGuardarDocument();
                    break;
                }
                case 23: {
                    dd.testImportarDocument();
                    break;
                }
                case 24: {
                    dd.testExportarDocument();
                    break;
                }
                default: {
                    System.out.println("Comanda inv??lida");
                    break;
                }
            }
            input = Integer.parseInt(in.nextLine());
        }
        System.out.println("Guardant tota la configuracio...");
        dd.testTancarAplicacio();
    }

    /**
     * Mostra les funcionalitats del Driver.
     */
    private void mostrarMenu() {
        System.out.println("Introdueix el n??mero de l'esquerra per provar el m??tode de la part dreta.");
        System.out.println("0  ??? Men??");
        System.out.println("1  ??? Alta Document");
        System.out.println("2  ??? Baixa Document");
        System.out.println("3  ??? Obrir Document");
        System.out.println("4  ??? Tancar Document");
        System.out.println("5  ??? Editar Autor Document");
        System.out.println("6  ??? Editar T??tol Document");
        System.out.println("7  ??? Editar Contingut Document");
        System.out.println("8  ??? Llistar Autors Per Prefix");
        System.out.println("9  ??? Llistar K Documents Semblants a D");
        System.out.println("10 ??? Llistar K Documents M??s Rellevants a P Paraules");
        System.out.println("11 ??? Llistar Titols Autors");
        System.out.println("12 ??? Llistar Documents Per Expressi?? Guardada");
        System.out.println("13 ??? Llistar Documents Per Expressi?? No Guardada");
        System.out.println("14 ??? Llistar Contingut Document Donat T??tol i Autor");
        System.out.println("15 ??? Ordenar Consulta d'Autors");
        System.out.println("16 ??? Ordenar Consulta de Documents");
        System.out.println("17 ??? Afegir Expressi?? Booleana");
        System.out.println("18 ??? Eliminar Expressi?? Booleana");
        System.out.println("19 ??? Modificar Expressi?? Booleana");
        System.out.println("20 ??? Consultar Expressi?? Booleana");
        System.out.println("21 ??? Llistar Expressions Booleanes");
        System.out.println("22 ??? Guardar document actual");
        System.out.println("23 ??? Importar");
        System.out.println("24 ??? Exportar");
        System.out.println("-1  ??? Sortir de l'aplicaci??");
    }

    /**
     * Test del m??tode altaDocument.
     */
    public void testAltaDocument() {
        System.out.println("S'est?? provant l'alta d'un nou document.");
        System.out.print("Introdueix el nom de l'autor: ");
        String autor = in.nextLine();
        System.out.print("Introdueix el t??tol: ");
        String titol = in.nextLine();
        System.out.print("Introdueix el path: ");
        String path = in.nextLine();

        try {
            cd.AltaDocument(autor, titol, path + ".ojmj");
            System.out.println("S'ha donat d'alta el nou document correctament.");
        } catch (DocumentJaExisteix e) {
            System.out.println("ERROR: Ja existeix un document amb t??tol " + titol + " i autor " + autor + ".");
        }  catch (PathJaExisteix e) {
            System.out.println("ERROR: Ja existeix un document amb path " + path + ".");
        }
    }
    
    /**
     * Test del m??tode baixaDocument.
     */
    public void testBaixaDocument() {
        System.out.println("S'est?? provant la baixa d'un document");
        System.out.print("Introdueix el path del document a eliminar: ");
        String path = in.nextLine();
        System.out.print("Vols eliminar el document completament del Sistema Operatiu? si/no: ");
        String decisio = in.nextLine();
        Boolean perm = decisio.equals("si");

        try {
            cd.BaixaDocument(path + ".ojmj", perm);
            System.out.println("El document " + path + " s'ha eliminat correctament.");
        }  catch (NoExisteixPath e) {
            System.out.println("ERROR: El document " + path + " no existeix.");
        } catch (EliminarDocumentObert e) {
            System.out.println("ERROR: S'est?? intentant donar de baixa el document actualment obert.");
            System.out.println("Tanca primer el document per poder donar-lo de baixa.");
        } catch (FormatNoReconegut e) {
            System.out.println("ERROR: El format del document " + path + " no ??s acceptat pel gestor.");
        }
    }

    /**
     * Test del m??tode obrirDocument.
     */
    public void testObrirDocument() {
        System.out.println("S'est?? provant el m??tode d'obrir un document.");
        System.out.print("Insereix el path del document a obrir: ");
        String path = in.nextLine();
        path += ".ojmj";

        try {
            cd.ObrirDocument(path);
            System.out.println("El document " + path + " s'ha obert correctament.");
        } catch (NoExisteixPath e) {
            System.out.println("ERROR: No existeix cap document amb path " + path + ".");
        } catch (JaExisteixDocumentObert e) {
            System.out.println("ERROR: S'ha intentat obrir un document quan ja hi ha un document actualment obert.");
        }
    }

    /**
     * Test del m??tode tancarDocument.
     */
    public void testTancarDocument() {
        System.out.println("S'est?? provant el m??tode de tancar el document actualment obert.");

        try {
            ArrayList<String> rd = cd.getDocumentObert();
            cd.TancarDocument();
            System.out.println("El document " + rd.get(2) + " s'ha tancat correctament.");
        } catch (DocumentNoObert e) {
            System.out.println("ERROR: No hi ha cap document obert.");
        } catch (DocumentNoGuardat e) {
            System.out.println("Hi ha un document obert que no s'ha guardat");
        }
    }

    /**
     * Test del m??tode editarAutor.
     */
    public void testEditarAutor() {
        System.out.println("S'est?? provant l'edici?? de l'autor d'un document.");
        System.out.print("Introdueix el t??tol del document: ");
        String titol = in.nextLine();
        System.out.print("Introdueix el nom de l'autor del document a modificar: ");
        String autorAnterior = in.nextLine();
        System.out.print("Introdueix el nom del nou autor del document: ");
        String nouAutor = in.nextLine();

        try {
            cd.EditarAutor(autorAnterior, nouAutor, titol);
            System.out.println("L'autor del document s'ha canviat correctament a " + nouAutor + ".");
        } catch (DocumentJaExisteix e) {
            System.out.println("ERROR: Ja existeix un document amb t??tol " + titol + " i autor " + nouAutor + ".");
        } catch (NoExisteixPath e) {
            System.out.println("ERROR: No existeix un document amb t??tol " + titol + " i autor " + autorAnterior + ".");
        }
    }

    /**
     * Test del m??tode editarTitol.
     */
    public void testEditarTitol() {
        System.out.println("S'est?? provant l'edici?? del titol d'un document.");
        System.out.print("Introdueix el nou nom del document: ");
        String nouTitol = in.nextLine();
        System.out.print("Introdueix el nom antic del document: ");
        String titolAnterior = in.nextLine();
        System.out.print("Introdueix el nom de l'autor del document: ");
        String autor = in.nextLine();

        try {
            cd.EditarTitol(nouTitol, titolAnterior, autor);
            System.out.println("El t??tol del document s'ha canviat correctament a " + nouTitol + ".");
        } catch (DocumentJaExisteix e) {
            System.out.println("ERROR: Ja existeix un document amb t??tol " + nouTitol + " i autor " + autor + ".");
        } catch (NoExisteixPath e) {
            System.out.println("ERROR: No existeix un document amb t??tol " + titolAnterior + " i autor " + autor + ".");
        }
    }

    /**
     * Test del m??tode editarContingut.
     */
    public void testEditarContingut() {
        System.out.println("S'est?? provant la modificaci?? del contingut del document actualment obert.");
        System.out.println("Insereix el nou contingut:");
        String contingut = in.nextLine();

        try {
            cd.EditarContingut(contingut);
            ArrayList<String> rd = cd.getDocumentObert();
            System.out.println("El contingut del document " + rd.get(2) + " s'ha modificat correctament.");
        } catch (DocumentNoObert e) {
            System.out.println("ERROR: No hi ha cap document obert.");
        }
    }

    /**
     * Test del m??tode llistarAutorsPerPrefix.
     */
    public void testLlistarAutorsPerPrefix() {
        System.out.println("S'est?? provant la cerca d'autors per prefix.");
        System.out.print("Introdueix el prefix a cercar: ");
        String prefix = in.nextLine();

        ArrayList<ArrayList<String>> arr = cd.LlistarAutorsPerPrefix(prefix);
        System.out.println("S'han trobat " + arr.size() + " autors.");
        for (ArrayList<String> aux : arr) {
            System.out.println("Nom: " + aux.get(0) + ", T??tols: " + aux.get(1) + ".");
        }
    }

    /**
     * Test del m??tode llistarKDocumentsSemblantsD.
     */
    public void testLlistarKDocumentsSemblantsD() {
        System.out.println("S'est?? provant la consulta dels K documents m??s semblants a un document D.");
        System.out.print("Introdueix el nombre de documents K: ");
        int k = Integer.parseInt(in.nextLine());
        System.out.print("Introdueix el path del document D: ");
        String path = in.nextLine();
        int metode = -1;
        while (metode != 0 && metode != 1) {
            System.out.print("Escolleix si vols utilitzar el m??tode de TFIDF (escriu 0) o BM25 (escriu 1): ");
            metode = Integer.parseInt(in.nextLine());
        }

        try {
            ArrayList<ArrayList<String>> arr = cd.LlistarKDocumentsSemblantsD(k, path + ".ojmj", metode);
            System.out.println("S'han trobat " + arr.size() + " documents:");
            for (ArrayList<String> aux : arr) {
                System.out.println("T??tol: " + aux.get(1) + ", Autor: " + aux.get(0) + ".");
            }
        } catch (NoExisteixDocument e) {
            System.out.println("ERROR: No existeix cap document amb path " + path + ".");
        } catch (FormatNoReconegut e) {
            System.out.println("ERROR: El format de l'arxiu " + path + " no ??s acceptat pel gestor.");
        } catch (NumDocumentsIncorrecte e) {
            System.out.println("ERROR: El nombre de documents K introdu??t no ??s correcte.");
        }
    }

    /**
     * Test del m??tode llistarKDocumentsRellevantsPParaules.
     */
    public void testLlistarKDocumentsRellevantsPParaules() {
        System.out.println("S'est?? provant la consulta de K documents rellevants a P paraules.");
        System.out.print("Introdueix el nombre de documents K: ");
        int k = Integer.parseInt(in.nextLine());
        System.out.print("Introdueix el nombre de paraules P: ");
        int p = Integer.parseInt(in.nextLine());
        TreeSet<String> conjParaules = new TreeSet<String>();
        System.out.println("Introdueix el conjunt de " + p + " paraules:");
        for (int i = 0; i < p; ++i) {
            String paraula = in.nextLine();
            conjParaules.add(paraula);
        }
        int metode = -1;
        while (metode != 0 && metode != 1) {
            System.out.print("Escolleix si vols utilitzar el m??tode de TFIDF (escriu 0) o BM25 (escriu 1): ");
            metode = Integer.parseInt(in.nextLine());
        }

        try {
            ArrayList<ArrayList<String>> arr = cd.LlistarKDocumentsRellevantsPParaules(k, conjParaules, metode);
            System.out.println("S'han trobat " + arr.size() + " documents:");
            for (ArrayList<String> aux : arr) {
                System.out.println("T??tol: " + aux.get(1) + ", Autor: " + aux.get(0) + ".");
            }
        } catch (NumDocumentsIncorrecte e) {
            System.out.println("ERROR: El nombre de documents K a cercar ??s incorrecte.");
        }
    }

    /**
     * Test del m??tode llistarTitolsAutors.
     */
    public void testLlistarTitolsAutors() {
        System.out.println("S'est?? provant la cerca de documents donat el nom d'un autor.");
        System.out.print("Introdueix el nom de l'autor a cercar: ");
        String autor = in.nextLine();

        try {
            ArrayList<ArrayList<String>> arr = cd.LlistarTitolsAutors(autor);
            System.out.println("L'autor amb nom " + autor + " t?? un total de " + arr.size() + " t??tols.");
            for (ArrayList<String> aux : arr) {
                System.out.println("T??tol: " + aux.get(0) + ", Path: " + aux.get(1));
            }
        } catch (NoExisteixAutor e) {
            System.out.println("ERROR: L'autor amb nom " + autor + " no existeix.");
        }
    }

    /**
     * Test del m??tode llistarTitolsPerExpressioGuardada.
     */
    public void testLlistarTitolsPerExpressioGuardada() {
        System.out.println("S'est?? provant la cerca de documents donat el nom d'una expressi?? booleana guardada.");
        System.out.print("Introdueix el nom de l'expressi?? a cercar: ");
        String nom = in.nextLine();

        try {
            ArrayList<ArrayList<String>> arr = cd.LlistarTitolsPerExpressioGuardada(nom);
            System.out.println("S'han trobat " + arr.size() + " resultats:");
            for (ArrayList<String> aux : arr) {
                System.out.println("T??tol: " + aux.get(1) + ", Autor: " + aux.get(0) + ".");
            }
        } catch (NoExisteixExpressio e) {
            System.out.println("ERROR: No existeix cap expressi?? guardada amb nom " + nom + ".");
        }
    }

    /**
     * Test del m??tode llistarTitolsPerExpressioNoGuardada.
     */
    public void testLlistarTitolsPerExpressioNoGuardada() {
        System.out.println("S'est?? provant la cerca de documents donada una expressi?? booleana introdu??da per l'usuari.");
        System.out.print("Introdueix l'expressi?? a cercar: ");
        String exp = in.nextLine();

        try {
            ArrayList<ArrayList<String>> arr = cd.LlistarTitolsPerExpressioNoGuardada(exp);
            System.out.println("S'han trobat " + arr.size() + " resultats:");
            for (ArrayList<String> aux : arr) {
                System.out.println("T??tol: " + aux.get(1) + ", Autor: " + aux.get(0) + ".");
            }
        } catch (ExpressioNoValida e) {
            System.out.println("ERROR: L'expressi?? " + exp + " no ??s v??lida.");
        }
    }

    /**
     * Test del m??tode llistarContingutDocumentPerAutorTitol.
     */
    public void testLlistarContingutDocumentPerAutorTitol() {
        System.out.println("S'est?? provant la consulta d'un document donat el seu t??tol i autor.");
        System.out.print("Introdueix el nom de l'autor: ");
        String autor = in.nextLine();
        System.out.print("Introdueix el nom del t??tol: ");
        String titol = in.nextLine();

        try {
            String arr = cd.LlistarContingutDocumentPerAutorTitol(autor, titol);
            System.out.println(arr);
        } catch (NoExisteixDocument e) {
            System.out.println("ERROR: No existeix cap document amb t??tol " + titol + " i autor " + autor + ".");
        }
    }

    public void testOrdenarAutors() {
        System.out.println("S'est?? provant el m??tode d'ordenar l'??ltim resultat de consulta d'autors.");
        int manera = -1;
        while (manera != 0 && manera != 1) {
            System.out.print("Escolleix si vols ordenar els resultats alfab??ticament per nom (escriu 0) o per n??mero de documents escrits (escriu 1): ");
            manera = Integer.parseInt(in.nextLine());
        }

        ArrayList<ArrayList<String>> arr = cd.OrdenarResultatAutors(manera);
        for (ArrayList<String> aux : arr) {
            System.out.println("T??tol: " + aux.get(1) + ", Autor: " + aux.get(0) + ".");
        }
    }

    public void testOrdenarDocuments() {
        System.out.println("S'est?? provant el m??tode d'ordenar l'??ltim resultat de consulta de documents.");
        int manera = -1;
        while (manera < 0 || manera > 4) {
            System.out.print("Escolleix si vols ordenar els resultats per semblan??a (escriu 0), per nom d'autor (escriu 1), per t??tol (escriu 2), per mida (escriu 3) o per data de creaci?? (escriu 4): ");
            manera = Integer.parseInt(in.nextLine());
        }

        ArrayList<ArrayList<String>> arr = cd.OrdenarResultatDocuments(manera);
        for (ArrayList<String> aux : arr) {
            System.out.println("T??tol: " + aux.get(1) + ", Autor: " + aux.get(0) + ".");
        }
    }

    /**
     * Test del m??tode afegirExpressio.
     */
    public void testAfegirExpressio() {
        System.out.println("S'est?? provant l'addici?? d'una nova expressi??.");
        System.out.print("Introdueix el nom de la nova expressi??: ");
        String nom = in.nextLine();
        System.out.print("Introdueix la nova expressi??: ");
        String exp = in.nextLine();

        try {
            cd.AfegirExpressio(nom, exp);
            System.out.println("Expressi?? afegida correctament.");
        } catch (JaExisteixExpressio e) {
            System.out.println("ERROR: Ja existeix una expressi?? amb nom " + nom + ".");
        } catch (ExpressioNoValida e) {
            System.out.println("ERROR: L'expressi?? " + exp + " no ??s v??lida.");
        }
    }

    /**
     * Test del m??tode eliminarExpressio.
     */
    public void testEliminarExpressio() {
        System.out.println("S'est?? provant l'eliminaci?? d'una expressi?? guardada.");
        System.out.print("Introdueix el nom de l'expressi?? a eliminar: ");
        String nom = in.nextLine();

        try {
            cd.EliminarExpressio(nom);
            System.out.println("Expressi?? eliminada correctament.");
        } catch (NoExisteixExpressio e) {
            System.out.println("ERROR: L'expressi?? amb nom " + nom + " no existeix.");
        }
    }

    /**
     * Test del m??tode modificarExpressio.
     */
    public void testModificarExpressio() {
        System.out.println("S'est?? provant la modificaci?? d'una expressi?? guardada.");
        System.out.print("Introdueix el nom de l'expressi?? a modificar: ");
        String nom = in.nextLine();
        System.out.print("Introdueix la nova expressi??: ");
        String exp = in.nextLine();

        try {
            cd.ModificarExpressio(nom, exp);
            System.out.println("Expressi?? modificada correctament.");
        } catch (NoExisteixExpressio e) {
            System.out.println("ERROR: L'expressi?? amb nom " + nom + " no existeix.");
        } catch (ExpressioNoValida e) {
            System.out.println("ERROR: L'expressi?? " + exp + " no es v??lida.");
        }
    }

    /**
     * Test del m??tode consultarExpressio.
     */
    public void testConsultarExpressio() {
        System.out.println("S'est?? provant la consulta d'una expressi?? guardada.");
        System.out.print("Introdueix el nom de l'expressi?? a consultar: ");
        String nom = in.nextLine();

        try {
            String exp = cd.ConsultarExpressio(nom);
            System.out.println("L'expressi?? " + nom + " t?? com a contingut: " + exp);
        } catch (NoExisteixExpressio e) {
            System.out.println("ERROR: L'expressi?? amb nom " + nom + " no existeix.");
        }
    }

    public void testLlistarExpressions() {
        System.out.println("S'est?? provant el m??tode de llistar totes les expressions booleanes.");
        ArrayList<String> al = cd.LlistarExpressions();
        System.out.println("S'han trobat " + al.size() + " resultats:");
        for (int i = 0; i < al.size(); ++i)
            System.out.println(al.get(i));
    }
    public void testGuardarDocument(){
        System.out.println("S'est?? provant el m??tode de guardar Document actual.");
        try {
            cd.GuardarDocument();
        } catch (DocumentNoObert e) {
            System.out.println("No hi ha cap document obert per guardar");
        }
        System.out.println("S'ha guardat de manera correcta");
    }
    public void testTancarAplicacio(){
        cd.TancarAplicacio();
    }
    public void testImportarDocument(){
        System.out.println("S'est?? provant el m??tode de Importar Document");
        System.out.println("Introdueix el archivo a importar:");
        String origen= in.nextLine();
        System.out.println("Introdueix el path on vols importar:");
        String desti = in.nextLine();
        desti +=".ojmj";
        try {
            cd.Importar(origen, desti);
        } catch (ErrorIntern e) {
            System.out.println("Error Intern");
        } catch (PathJaExisteix e) {
            
            System.out.println("Ja existeix el path on es vol trobar");
        } catch (DocumentJaExisteix e) {
            // TODO Auto-generated catch block
            System.out.println("Existeix un document amb el mateix titol i autor");
        }
    }
    public void testExportarDocument(){
        System.out.println("S'est?? provant el m??tode de Exportar Document");
        System.out.println("Introdueix el archivo a exportar:");
        String origen= in.nextLine();
        origen +=".ojmj";
        System.out.println("Introdueix el path on vols exportar:");
        String desti = in.nextLine();
        try {
            cd.Exportar(origen, desti);
        } catch (ErrorIntern e) {
            System.out.println("Error Intern");
        } catch (NoExisteixPath e) {
            // TODO Auto-generated catch block
           System.out.println("No existeix path");
        }
    }
}
