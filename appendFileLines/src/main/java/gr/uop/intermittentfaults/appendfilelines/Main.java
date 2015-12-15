/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittentfaults.appendfilelines;

import gr.uop.intermittent.faults.intermittentfaultstest.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jboss.metrics.jbossautomatedmetricslibrary.MetricsCache;

/**
 *
 * @author Panos
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        
        File file = new File("F:\\Netbeans\\IntermittentFaults\\IntermittentFaultsTest\\src\\main\\java\\gr\\uop\\intermittent\\faults\\utils\\Store.java");
        List<Integer> additionalLines = new ArrayList<>();
        ArrayList<String> paramsToMonitor = new ArrayList<>();
        additionalLines.add(34);
        paramsToMonitor.add("value");
        AddImport.addLines(file, "import org.jboss.metrics.javase.automatedmetricsjavaseapi.JbossAutomatedJavaSeMetrics;");
        AddImport.addLines(file, "import org.jboss.metrics.javase.automatedmetricsjavaseapi.JbossAutomatedJavaSeMetricsDbStore;");
        AddFileLines.addLines(file, additionalLines, paramsToMonitor, "Store");

        Runtime.getRuntime().exec("cmd /c start C:\\Users\\Panos\\Documents\\NetBeansProjects\\appendFileLines\\src\\main\\java\\gr\\uop\\intermittentfaults\\appendfilelines\\runCompile.bat");
        Thread.sleep(10000);
         
        for (int i=0; i<10; i++) {
            MetricsCache cache = Test.test(args);

            if (cache!=null) {
                System.out.println("Cache : " );
                cache.printMetricObjects();
            }
        }
        
        Runtime.getRuntime().exec("cmd /c start C:\\Users\\Panos\\Documents\\NetBeansProjects\\appendFileLines\\src\\main\\java\\gr\\uop\\intermittentfaults\\appendfilelines\\runReset.bat");
    }
}
