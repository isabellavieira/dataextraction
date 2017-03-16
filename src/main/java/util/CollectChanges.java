package util;

import org.eclipse.jdt.core.dom.*;
import dao.DAOImpl;
import model.BugLinesChanged;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class CollectChanges {
    static HashMap<String, ArrayList<Integer>> listChanges;



    public static void main(String[] args) throws IOException {

        DAOImpl dao = new DAOImpl();



        ASTParser parser = ASTParser.newParser(AST.JLS8);

        System.out.println(dao.getAll((BugLinesChanged.class)).size());

        for (final BugLinesChanged bugLinesChanged : dao.getAll(BugLinesChanged.class)) {
            listChanges = new HashMap<String, ArrayList<Integer>>();
            Set<String> setMethods = new LinkedHashSet<String>();

            if (bugLinesChanged.getLines_Changed_removed().length() > 0) {
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("git show " + bugLinesChanged.getCommitDiff() + ":" + bugLinesChanged.getFile_fix());


                String pathDir = "/Users/pianco/Documents/tempCollect/";

                String path = pathDir
                        + bugLinesChanged.getFile_fix().split("/")[bugLinesChanged.getFile_fix().split("/").length - 1];

                Utils.FileWrite(path, Utils.execueCommand("git show " + bugLinesChanged.getCommitDiff() + ":" + bugLinesChanged.getFile_fix()));


                char[] filecontet = Utils.ReadFileToCharArray(path);


                parser.setSource(filecontet);
                parser.setKind(ASTParser.K_COMPILATION_UNIT);
                parser.setBindingsRecovery(true);
                parser.setResolveBindings(true);
                parser.setStatementsRecovery(true);
                parser.setSource(filecontet);


                final CompilationUnit cu = (CompilationUnit) parser.createAST(null);

                cu.accept(new ASTVisitor() {

                    @Override
                    public void preVisit(ASTNode node) {


                        int lineNumber = cu.getLineNumber(node.getStartPosition());

                        for (String line : bugLinesChanged.getLines_Changed_removed().split(",")) {
                            if (line.length() > 0 && !line.equals("")) {
                                if (lineNumber == Integer.parseInt(line)) {
                                    try {


                                        if (node.getNodeType() == ASTNode.METHOD_DECLARATION) {
                                            ASTNode parentNode = node.getParent();

                                            TypeDeclaration td = (TypeDeclaration) parentNode;


                                            ArrayList<Integer> arrayNew = new ArrayList<Integer>();
                                            arrayNew.add(node.getNodeType());


                                            if (listChanges.containsKey(td.getName().getFullyQualifiedName())) {

                                                listChanges.get(td.getName().getFullyQualifiedName()).add(node.getNodeType());

                                            } else {
                                                listChanges.put(td.getName().getFullyQualifiedName(), arrayNew);

                                            }

//
                                        } else if (node.getNodeType() == ASTNode.FIELD_DECLARATION) {
                                            ASTNode parentNode = node.getParent();


                                            TypeDeclaration td = (TypeDeclaration) parentNode;


                                            ArrayList<Integer> arrayNew = new ArrayList<Integer>();
                                            arrayNew.add(node.getNodeType());

                                            if (listChanges.containsKey(td.getName().getFullyQualifiedName())) {

                                                listChanges.get(td.getName().getFullyQualifiedName()).add(node.getNodeType());

                                            } else {
                                                listChanges.put(td.getName().getFullyQualifiedName(), arrayNew);
//
                                            }

                                        } else if (node.getNodeType() == ASTNode.TYPE_DECLARATION) {


                                            TypeDeclaration td = (TypeDeclaration) node;

                                            ArrayList<Integer> arrayNew = new ArrayList<Integer>();
                                            arrayNew.add(node.getNodeType());

                                            if (listChanges.containsKey(td.getName().getFullyQualifiedName())) {

                                                listChanges.get(td.getName().getFullyQualifiedName()).add(node.getNodeType());

                                            } else {
                                                listChanges.put(td.getName().getFullyQualifiedName(), arrayNew);
//
                                            }


                                        } else {

                                            try {
                                                ASTNode parentNode = node.getParent();

                                                while (parentNode.getNodeType() != ASTNode.METHOD_DECLARATION) {
                                                    parentNode = parentNode.getParent();

                                                }
                                                MethodDeclaration md = (MethodDeclaration) parentNode;


                                                while (parentNode.getNodeType() != ASTNode.TYPE_DECLARATION) {
                                                    parentNode = parentNode.getParent();
                                                }
                                                ArrayList<Integer> arrayNew = new ArrayList<Integer>();

                                                TypeDeclaration td = (TypeDeclaration) parentNode;
                                                String methodDescription = td.getName().getFullyQualifiedName() + "." + md.getName() + "(" + md.parameters().toString()
                                                        .substring(1, md.parameters().toString().length() - 1) + ")";

                                                if (listChanges.containsKey(methodDescription)) {

                                                    listChanges.get(methodDescription).add(node.getNodeType());

                                                } else {
                                                    arrayNew.add(node.getNodeType());
                                                    listChanges.put(methodDescription, arrayNew);
//
                                                }


                                            } catch (NullPointerException nullPointer) {
                                                System.out.println(cu.getLineNumber(node.getStartPosition()));
                                            }


                                        }
                                    } catch (Exception e) {
                                        System.out.println("Erro - " + "git show " + bugLinesChanged.getCommitDiff() + ":" + bugLinesChanged.getFile_fix());
                                    }
                                }
                            }
                        }

                    }


                });

                String[] splited = bugLinesChanged.getFile_fix().split("/");

                String s1 = "";

                for (int i = 0; i < splited.length - 1; i++) {
                    s1 += splited[i] + ".";

                }

                Map<String, ArrayList<Integer>> map = listChanges;
                System.out.println(listChanges.size());
                for (
                        Map.Entry<String, ArrayList<Integer>> entry : map.entrySet())

                {


                    System.out.println(s1 + entry.getKey() + "/" + entry.getValue());

                    String insert = "INSERT INTO tomcat.bug_fix_methods_changes(bug_id,commit_diff,file_changed,changesType,method,typeModification)"
                            + "VALUES (" + "'" + bugLinesChanged.getBug_id() + "'" + "," + "'" + bugLinesChanged.getCommitDiff()
                            + "'" + "," + "'" + bugLinesChanged.getFile_fix() + "'" + "," + "'" + entry.getValue() + "'"
                            + "," + "'" + s1 + entry.getKey() + "'" + ","+"'"+"-"+"'"+");";

                    String s2 = "\n" + insert;

                    try

                    {
                        Files.write(Paths.get("/Users/pianco/Desktop/inserts.sql"), s2.getBytes(), StandardOpenOption.APPEND);
                    } catch (
                            IOException e) {
                    }


                }

            }

        }
        System.exit(0);


    }
}
