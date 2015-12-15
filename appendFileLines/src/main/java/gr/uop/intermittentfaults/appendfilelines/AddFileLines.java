/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittentfaults.appendfilelines;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Panos
 */
public class AddFileLines {
    public static void addLines(File file, List<Integer> additionalLines, ArrayList<String> paramsToMonitor, String className) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        int i=0;
        for (int line : additionalLines)
            lines.set(line-1, lines.get(line-1) + " " + "try {JbossAutomatedJavaSeMetrics.metric(\"" + className + "\"," + paramsToMonitor.get(i) + ",\"" + paramsToMonitor.get(i) + "\",\"intermittentFaultsGroup\"); JbossAutomatedJavaSeMetricsDbStore.metricsDbStore(\"" + className + "\", new Object[]{" + paramsToMonitor.get(i) + "}, \"intermittentFaultsGroup\", \"statement_1\", new String[]{\"StoreDBMetric\",\"" + paramsToMonitor.get(i++) + "\"});} catch (Exception ex) {ex.printStackTrace();}");
        Files.write(file.toPath(), lines);
    }
}
