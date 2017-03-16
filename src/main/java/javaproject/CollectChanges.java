package javaproject;

/**
 * Created by pianco on 20/02/17.
 */

import org.eclipse.jdt.core.dom.*;
import util.Utils;

import java.io.IOException;
import java.util.*;

public class CollectChanges {


    public static void main(String[] args) throws IOException {


        ASTParser parser = ASTParser.newParser(AST.JLS8);
        final HashMap<String, ArrayList<Integer>> listChanges = new HashMap<String, ArrayList<Integer>>();


        String path = "/Users/pianco/Documents/Master Graduate/Repository/security-change-history/change-history-code/src/main/java/security/br/ufal/ic/webcolector/filetest.java";


        char[] filecontet = Utils.ReadFileToCharArray(path);


        parser.setSource(filecontet);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        parser.setBindingsRecovery(true);
        parser.setResolveBindings(true);
        parser.setStatementsRecovery(true);
        parser.setSource(filecontet);

        Set<String> setMethods = new LinkedHashSet<String>();

        final CompilationUnit cu = (CompilationUnit) parser.createAST(null);

        cu.accept(new ASTVisitor() {


            @Override
            public void preVisit(ASTNode node) {

                int lineNumber = cu.getLineNumber(node.getStartPosition());

                for (int i = 8; i <= 41; i++) {


                    if (lineNumber == (i)) {

                        System.out.println("tamanho do hashmap: " + listChanges.size());


                        System.out.println("Line: " + i + "ast code:" + node.getNodeType());


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

                                }


                            } catch (NullPointerException nullPointer) {
                                System.out.println(cu.getLineNumber(node.getStartPosition()));
                            }
                        }
                    }


                }
            }


        });


        Map<String, ArrayList<Integer>> map = listChanges;
        System.out.println(listChanges.size());
        for (
                Map.Entry<String, ArrayList<Integer>> entry : map.entrySet())

        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
    }


}
