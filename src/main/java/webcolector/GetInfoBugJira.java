package webcolector;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import dao.DAOImpl;
import model.DerbyBugInfo;
import model.DerbyFileAndRevisionFix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetInfoBugJira {

	public static void main(String[] args) throws IOException {

		// String s =
		// "\"data-downloadurl=\"${attachment.mimetype}:DERBY-2658.diff:https://issues.apache.org/jira/secure/attachment/12358513/DERBY-2658.diff\">";
		//
		//
		//
		// System.out.println(s.subSequence(s.indexOf("https:"),s.indexOf("\">")).toString());
		//

		//
		//DAOImpl dao = new DAOImpl();
		int a = 0;
		int id = 7590;
		//System.out.println(dao.getAll(DerbyBugInfo.class).size());

		//for (DerbyBugInfo bugDerby : dao.getAll(DerbyBugInfo.class)) {
//			if (bugDerby.getIssueId() >6247) {
				//System.out.println(bugDerby.getIssueId());
				 Document doc =
				 Jsoup.connect("https://issues.apache.org/jira/browse/DERBY-5476").get();

//				Document doc = Jsoup.connect("https://issues.apache.org/jira/browse/DERBY-" + bugDerby.getIssueId())
//						.get();
				try {
					Element elements = doc.getElementById("file_attachments");

					Elements elements2 = elements.getElementsByClass("attachment-thumb");

					Set<String> setDiffs = new HashSet<>();

					for (Element e2 : elements2) {

						// System.out.println(e2.toString());

						// System.out.println("https://issues.apache.org/"+e2.toString().subSequence(e2.toString().indexOf("<a
						// href=\""),e2.toString().indexOf("\"
						// draggable")).toString().replaceAll("<a href=\"/",
						// ""));

						setDiffs.add("https://issues.apache.org/" + e2.toString()
								.subSequence(e2.toString().indexOf("<a href=\""), e2.toString().indexOf("\" draggable"))
								.toString().replaceAll("<a href=\"/", ""));

						// if (!e2.toString().contains(".html.diff")) {
						// if (e2.toString().contains(".diff.txt")) {
						// setDiffs.add(e2.toString().subSequence(e2.toString().indexOf("https:"),
						// e2.toString().indexOf("diff.txt\">")) + "diff.txt");
						//
						// } else {
						//
						// if (e2.toString().contains(".diff") &&
						// !e2.toString().contains(".diff.")
						// && !e2.toString().contains(".diff2")) {
						// System.out.println(e2.toString());
						//
						// setDiffs.add(e2.toString().substring(e2.toString().indexOf("https:"),e2.toString().indexOf("\">")).toString());
						//
						// }
						// }

						// }
					}

					Pattern pattern = Pattern.compile("---(.*?\\.java[ ]+)\\(revision[ ]([\\d]+)\\)\\s");
					Matcher matcher;
					for (String s : setDiffs) {

						if (!s.contains(".xml")&&!s.contains(".java")) {
							Document doc2 = null;
							try {
								doc2 = Jsoup.connect(s).ignoreContentType(true).get();
								System.out.println(s);
							} catch (HttpStatusException e3) {
								String s4 = e3.getMessage() + "\n";
								try {
									Files.write(
											Paths.get(
													"/dataextraction/erros.txt"),
											s4.getBytes(), StandardOpenOption.APPEND);
								} catch (IOException e2) {
								}

							}
							// System.out.println(doc2.getElementsByTag("body").get(0).toString().split("Index:")[2]);

							if (doc2.getElementsByTag("body").get(0).toString().contains("commit")
									|| doc2.getElementsByTag("body").get(0).toString().contains("Index:")) {

								for (String celulaSplit : doc2.getElementsByTag("body").get(0).toString()
										.split("Index:")) {
									matcher = pattern.matcher(celulaSplit);

									while (matcher.find()) {

										System.out.println(matcher.group(1));
										System.out.println(matcher.group(2));

										DerbyFileAndRevisionFix derbyFileAndRevisionFix = new DerbyFileAndRevisionFix();
										derbyFileAndRevisionFix.setId(id);
										derbyFileAndRevisionFix.setBug_id(5476);
										derbyFileAndRevisionFix.setFile_fix(matcher.group(1));
										derbyFileAndRevisionFix.setRevision_fix(matcher.group(2));
										derbyFileAndRevisionFix.setLink_fix(s);
										//dao.save(derbyFileAndRevisionFix);
										id++;

									}

								}
							} else {
								String s2 = "bug_id= " + 5476 + " Nao localizou Revision " + "\n";

								try {
									Files.write(
											Paths.get(
													"/dataextraction/erros.txt"),
											s2.getBytes(), StandardOpenOption.APPEND);
								} catch (IOException e2) {
								}
							}

						}
					}
				}

				catch (NullPointerException e) {
					a++;
					System.out.println(5476 + "Deu Null Point");

					String s = "bug_id= " + 5476 + " Deu Null Point" + " quantidade de NULLs= " + a
							+ "\n";

					try {
						Files.write(
								Paths.get(
										"/dataextraction/erros.txt"),
								s.getBytes(), StandardOpenOption.APPEND);
					} catch (IOException e2) {
					}

				}
				System.out.println("Quantidade de NULL point= " + a);
			}
//		}
//	}
}