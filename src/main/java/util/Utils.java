package util;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static char[] ReadFileToCharArray(String filePath) throws IOException {

        StringBuilder fileData = new StringBuilder(1000);
    BufferedReader reader = new BufferedReader(new FileReader(filePath));

    char[] buf = new char[10];
    int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {

        String readData = String.valueOf(buf, 0, numRead);
        fileData.append(readData);
        buf = new char[1024];
    }

		reader.close();

		return fileData.toString().toCharArray();
}

    public static void FileWrite(String fileName, String content) {

        File file = new File(fileName);




        try (FileOutputStream fop = new FileOutputStream(file)) {
            if (!file.exists()) {
                file.createNewFile();
            }

            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String execueCommand(String comando) {

        Process process = null;
        try {
            process = Runtime.getRuntime().exec(comando);
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream inputStream = process.getInputStream();

        String saida = "";

        {
            int n;

            try {
                while ((n = inputStream.read()) != -1) {
                    saida += (char) n;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return saida + "\n";
    }

    public static String execueCommand2(String comando) throws InterruptedException, IOException {

        Runtime rt = Runtime.getRuntime();
        String[] commands = {"system.exe","-get t"};
        Process proc = rt.exec(commands);

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(proc.getErrorStream()));

// read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

// read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
        return s;
    }

    static Set<String> getIntervalLinesChangedMinus(String diff, String commit) {

        commit = commit + "^";
        Set<String> intervalLines = new LinkedHashSet<>();
        String[] gitdiff = diff.split("\n");
        int intLine = 0;
        int endline = 0;
        for (String line : gitdiff) {
            endline++;
            if (commit.contains("^")) {
                if (line.startsWith("+"))
                    endline--;
            } else {
                if (line.startsWith("-"))
                    endline--;
            }
            if (line.matches("@@.*@@.*|diff --git.*")) {
                if (line.contains("@@")) {
                    if (intLine != 0)
                        intervalLines.add((intLine + 3) + "-" + (endline - 4));
                    if (commit.contains("^")) {
                        line = line.replaceAll("@@", "").replaceAll(" ", "").split("[+]")[0].split(",")[0]
                                .split("[-]")[1];
                        intLine = Integer.parseInt(line);
                        endline = intLine;
                    } else {
                        line = line.replaceAll("@@", "").replaceAll(" ", "").split("[+]")[1];
                        line = line.split(",")[0];
                        intLine = Integer.parseInt(line);
                        endline = intLine;
                    }
                } else if (line.contains("diff --git")) {
                    if (intLine != 0)
                        intervalLines.add((intLine + 3) + "-" + (endline - 4));
                    endline = 0;
                }
            }
        }
        if (intLine != 0)
            intervalLines.add((intLine + 3) + "-" + (endline - 4));

        return intervalLines;
    }


    static Set<String> getIntervalLinesChangedAdd(String diff, String commit) {
        Set<String> intervalLines = new LinkedHashSet<>();
        String[] gitdiff = diff.split("\n");
        int intLine = 0;
        int endline = 0;
        for (String line : gitdiff) {
            endline++;
            if (commit.contains("^")) {
                if (line.startsWith("+"))
                    endline--;
            } else {
                if (line.startsWith("-"))
                    endline--;
            }
            if (line.matches("@@.*@@.*|diff --git.*")) {
                if (line.contains("@@")) {
                    if (intLine != 0)
                        intervalLines.add((intLine + 3) + "-" + (endline - 4));
                    if (commit.contains("^")) {
                        line = line.replaceAll("@@", "").replaceAll(" ", "").split("[+]")[0].split(",")[0]
                                .split("[-]")[1];
                        intLine = Integer.parseInt(line);
                        endline = intLine;
                    } else {
                        line = line.replaceAll("@@", "").replaceAll(" ", "").split("[+]")[1];
                        line = line.split(",")[0];
                        intLine = Integer.parseInt(line);
                        endline = intLine;
                    }
                } else if (line.contains("diff --git")) {
                    if (intLine != 0)
                        intervalLines.add((intLine + 3) + "-" + (endline - 4));
                    endline = 0;
                }
            }
        }
        if (intLine != 0)
            intervalLines.add((intLine + 3) + "-" + (endline - 4));// +3 and -4


        return intervalLines;
    }
    public static ArrayList<Set<String>> getSetLineNumberAdd(String commit, String file) throws InterruptedException, IOException {

        List<String> changesadd = new ArrayList<String>();
        Set<String> changesaddLine = new LinkedHashSet<String>();
        Pattern pattern = Pattern.compile("^(\\+)(.*)");
        int menor;
        int maior;
        ArrayList<Set<String>> temp = new ArrayList<Set<String>>();
        final String diff = Utils.execueCommand("git show " + commit + " -- " + file);
        String[] splitted = diff.split("@@ -.*?\\,[\\d]+ @.*");

        if (Utils.getIntervalLinesChangedAdd(diff, commit).size() != 0 && !diff.contains("@@@")) {

            ArrayList<String> listIntervals = new ArrayList<String>();
            for (String s : Utils.getIntervalLinesChangedAdd(diff, commit)) {
                listIntervals.add(s);
            }
            for (int i = 0; i < listIntervals.size(); i++) {
                String[] aux = listIntervals.get(i).split("-");
                menor = Integer.parseInt(aux[0]);
                maior = Integer.parseInt(aux[1]);

                String s2 = splitted[i + 1];

                for (String stringfinder : s2.split("\n")) {
                    if (stringfinder.startsWith("+")) {
                        Matcher matcher = pattern.matcher(stringfinder);
                        matcher.find();
                        changesadd.add(matcher.group(2));
                    }
                }
                for (Iterator<String> iterator = changesadd.iterator(); iterator.hasNext(); ) {

                    String value = iterator.next();
                    if (value.replace("\t", "").replace(" ", "").length() <= 3) {
                        iterator.remove();

                    }

                }
                String[] setFileToAddvedAnalysis = Utils.execueCommand("git show "  + commit + ":" + file).split("\n");



                if(maior>setFileToAddvedAnalysis.length){
                    maior=setFileToAddvedAnalysis.length;
                }

                for (String auxiliar: changesadd) {


                    for (int inter = menor-1 ; inter < maior; inter++) {

                        if (setFileToAddvedAnalysis[inter].replace(" ","").contains(auxiliar.replace(" ",""))) {
                            changesaddLine.add(String.valueOf(inter + 1));
                        }

                    }

                }

                temp.add(changesaddLine);
            }
        } else {
            if (diff.contains("@@@")) {
                changesaddLine.add("@@@");
            } else {
                changesaddLine.add("");
            }
            temp.add(changesaddLine);
        }
        return temp;

    }



    public static ArrayList<Set<String>> getSetLineNumberRemoved(String commit, String file) {

        List<String> changesaREmoved = new ArrayList<String>();
        Set<String> changesLineRemoved = new LinkedHashSet<String>();
        Pattern pattern = Pattern.compile("^(\\-)(.*)");
        int menor;
        int maior;

        ArrayList<Set<String>> temp = new ArrayList<Set<String>>();
        final String diff = Utils.execueCommand("git show " + commit + " -- " + file);
        String[] splitted = diff.split("@@ -.*?\\,[\\d]+ @.*");

        System.out.println("git show " + commit + " -- " + file);

        //System.out.println(diff);

        ArrayList<String> listIntervals = new ArrayList<String>();

        if (Utils.getIntervalLinesChangedMinus(diff, commit).size() != 0 && !diff.contains("@@@")) {


            for (String s : Utils.getIntervalLinesChangedMinus(diff, commit)) {
                listIntervals.add(s);
            }

            for (int i = 0; i < listIntervals.size(); i++) {

                String[] aux = listIntervals.get(i).split("-");
                menor = Integer.parseInt(aux[0]);
                maior = Integer.parseInt(aux[1]);


                String s2 = splitted[i + 1];

                for (String stringfinder : s2.split("\n")) {
                    if (stringfinder.startsWith("-")) {
                        Matcher matcher = pattern.matcher(stringfinder);
                        matcher.find();
                        changesaREmoved.add(matcher.group(2));
                    }
                }
                for (Iterator<String> iterator = changesaREmoved.iterator(); iterator.hasNext(); ) {
                    String value = iterator.next();
                    if (value.replace("\t", "").replace(" ", "").length() <= 3) {
                        iterator.remove();
                    }
                }



                String[] setFileToRemoveddAnalysis = Utils.execueCommand("git show  " + commit + "^:" + file)
                        .split("\n");
                for (String auxiliar : changesaREmoved) {
                    if(maior>setFileToRemoveddAnalysis.length){
                        maior=setFileToRemoveddAnalysis.length;
                    }

                    for (int inter = menor-1; inter<maior; inter++) {
                        if(menor<=0){
                            menor=0;
                        }
                        if (setFileToRemoveddAnalysis[inter].replace(" ","").contains((auxiliar.replace(" ","")))) {

                            changesLineRemoved.add(String.valueOf(inter + 1));
                        }
                    }
                }

                temp.add(changesLineRemoved);
            }

        } else {

            if (diff.contains("@@@")) {
                changesLineRemoved.add("@@@");
            } else {
                changesLineRemoved.add("");
            }
            temp.add(changesLineRemoved);
        }
        return temp;

    }

    public static void main(String[] args) throws InterruptedException, IOException {

       // ArrayList<Set<String>> listChangeSetAdd = Utils.getSetLineNumberAdd("7a9ce7e","java/engine/org/apache/derby/iapi/sql/execute/ResultSetFactory.java");
        ArrayList<Set<String>> listChangeSetAdd = Utils.getSetLineNumberAdd("553ad39","java/org/apache/tomcat/util/net/SocketWrapper.java");


        System.out.println(listChangeSetAdd.get(0));

         String a4 = execueCommand(
                 "git show b430e29 -- test/org/apache/jasper/compiler/TestELParser.java");



        System.out.println(getIntervalLinesChangedAdd(a4,"83fe69a"));

    }
}