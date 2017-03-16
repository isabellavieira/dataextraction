package util;

import org.eclipse.jdt.core.dom.*;
import dao.DAOImpl;
import model.BugLinesChanged;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedHashSet;
import java.util.Set;

public class CollectMethodsbyDiff {


    public static void main(String[] args) throws IOException {

        DAOImpl dao = new DAOImpl();

        ASTParser parser = ASTParser.newParser(AST.JLS8);

        System.out.println(dao.getAll((BugLinesChanged.class)).size());

        for (final BugLinesChanged bugLinesChanged : dao.getAll(BugLinesChanged.class)) {
            if (bugLinesChanged.getLines_Changed_add().length() > 0) {

                String pathDir = "/Users/pianco/Documents/tempCollect/";

                String path = pathDir
                        + bugLinesChanged.getFile_fix().split("/")[bugLinesChanged.getFile_fix().split("/").length - 1];

                Utils.FileWrite(path, Utils.execueCommand("git show " + bugLinesChanged.getCommitDiff() + ":" + bugLinesChanged.getFile_fix()));

                System.out.println("git show " + bugLinesChanged.getCommitDiff() + ":" + bugLinesChanged.getFile_fix());

                char[] filecontet = Utils.ReadFileToCharArray(path);


                parser.setSource(filecontet);
                parser.setKind(ASTParser.K_COMPILATION_UNIT);
                parser.setBindingsRecovery(true);
                parser.setResolveBindings(true);
                parser.setStatementsRecovery(true);
                parser.setSource(filecontet);

                final Set<String> setMethods = new LinkedHashSet<String>();

                final CompilationUnit cu = (CompilationUnit) parser.createAST(null);

                cu.accept(new ASTVisitor() {

                    @Override
                    public void preVisit(ASTNode node) {
                        int lineNumber = cu.getLineNumber(node.getStartPosition());

                        for (String line : bugLinesChanged.getLines_Changed_add().split(",")) {
                            if (line.length() > 0 && !line.equals("")) {
                                if (lineNumber == Integer.parseInt(line)) {
                                    try {

                                        if (node.getNodeType() == ASTNode.METHOD_DECLARATION) {
                                            MethodDeclaration md = (MethodDeclaration) node;
                                            ASTNode parentNode = node.getParent();
                                            while (parentNode.getNodeType() != ASTNode.TYPE_DECLARATION) {
                                                parentNode = parentNode.getParent();
                                            }
                                            TypeDeclaration td = (TypeDeclaration) parentNode;


                                            String[] splited = bugLinesChanged.getFile_fix().split("/");

                                            String s1 = "";

                                            for (int i = 0; i < splited.length - 1; i++) {
                                                s1 += splited[i] + ".";

                                            }

                                            System.out.println(s1);

                                            setMethods.add("\"" + s1 + td.getName().getFullyQualifiedName() + "." + md.getName() + "(" + md.parameters().toString()
                                                    .substring(1, md.parameters().toString().length() - 1) + ")" + "\"");
                                        } else {
                                            ASTNode parentNode = node.getParent();
                                            while (parentNode.getNodeType() != ASTNode.METHOD_DECLARATION) {
                                                parentNode = parentNode.getParent();

                                            }

                                            MethodDeclaration md = (MethodDeclaration) parentNode;

//                                            while (parentNode.getNodeType() != ASTNode.TYPE_DECLARATION) {
//                                                parentNode = parentNode.getParent();
//                                            }

                                            TypeDeclaration td = (TypeDeclaration) parentNode;
                                            String[] splited = bugLinesChanged.getFile_fix().split("/");

                                            String s2 = "";

                                            for (int i = 0; i < splited.length - 1; i++) {
                                                s2 += splited[i] + ".";

                                            }

                                            setMethods.add("\"" + s2 + td.getName().getFullyQualifiedName() + "." + md.getName() + "(" + md.parameters().toString()
                                                    .substring(1, md.parameters().toString().length() - 1) + ")" + "\"");
                                        }

                                    } catch (NullPointerException e) {
                                        try {
                                            String s2 = Utils.execueCommand("git show " + bugLinesChanged.getCommitDiff()
                                                    + ":" + bugLinesChanged.getFile_fix()) + "line:" + line;
                                            Files.write(Paths.get("/Users/pianco/Desktop/Erros.txt"), ("git show " + bugLinesChanged.getCommitDiff()
                                                            + ":" + bugLinesChanged.getFile_fix() + " line: " + line + "\n").getBytes(),
                                                    StandardOpenOption.APPEND);
                                        } catch (IOException e2) {

                                        }

                                    }
                                }

                            }
                        }
                    }
                });
                String insert = "INSERT INTO camel.bug_fix_methods (bug_id,commit_diff,file_changed,typeModification,methods)"
                        + "VALUES (" + "'" + bugLinesChanged.getBug_id() + "'" + "," + "'" + bugLinesChanged.getCommitDiff()
                        + "'" + "," + "'" + bugLinesChanged.getFile_fix() + "'" + "," + "'" + "Added" + "'"
                        + "," + "'" + setMethods.toString() + "'" + ");";

                String s1 = "\n" + insert;

                try {
                    Files.write(Paths.get("/Users/pianco/Desktop/inserts.sql"), s1.getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                }
                System.out.println(setMethods.toString());
            }
        }

        System.exit(0);
    }


}
