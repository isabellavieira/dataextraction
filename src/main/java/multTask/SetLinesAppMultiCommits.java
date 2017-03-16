package multTask;

import dao.DAOImpl;
import model.TomCatDataBug;
import util.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetLinesAppMultiCommits {


    public static void getLinesChangedMultiThread(TomCatDataBug instance) throws InterruptedException, IOException {
        DAOImpl dao = new DAOImpl();


        final Pattern pattern = Pattern.compile("(commit)\\s*(.*)");

        ArrayList<String> listCommits = new ArrayList<String>();
        String a = Utils.execueCommand("git log --stat --all -- " + instance.getFiles());


        Matcher matcher = pattern.matcher(a);
        while (matcher.find()) {
            if (matcher.group(2).length() == 40) {
                listCommits.add(matcher.group(2));
            }
        }
        for (int i = listCommits.size() - 1; i >= 0; i--) {
            if (listCommits.get(i).equals(instance.getCommit())) {
                break;
            }

            ArrayList<Set<String>> listChangesSetAdd = Utils.getSetLineNumberAdd(listCommits.get(i), instance.getFiles());


            ArrayList<Set<String>> listChangesSetRemoved = Utils.getSetLineNumberRemoved(listCommits.get(i), instance.getFiles());



            String setChagesAdd = String.join(",", listChangesSetAdd.get(0));
            String setChagesRemoved = String.join(",", listChangesSetRemoved.get(0));


            String insert = "INSERT INTO tomcat.BugLinesChanged (commitDiff,lines_Changed_add,lines_Changed_removed"
                    + ",bug_id,file_fix)" + " VALUES (" + "'" + instance.getCommit() + "'" + "," + "'" + setChagesAdd + "'" + "," + "'" + setChagesRemoved + "'" + "," + "'" + instance.getBug_id().toString() + "'" + "," + "'" + instance.getFiles() + "'" + ");";

            String s1 = "\n" + insert;


            try {
                Files.write(Paths.get("/Users/pianco/Documents/Master Graduate/Repository/security-change-history/change-history-code/inserts.sql"), s1.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
            }



        }
    }

}
