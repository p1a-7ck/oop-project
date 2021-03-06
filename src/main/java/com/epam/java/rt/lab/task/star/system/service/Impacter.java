package com.epam.java.rt.lab.task.star.system.service;

import com.epam.java.rt.lab.task.star.system.model.body.BodyBase;
import com.epam.java.rt.lab.task.star.system.model.StarSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by P1A-7CK on 07.07.2016.
 */
public class Impacter {
    public Impacter(BodyBase guestBodyBase, StarSystem hostSystem, int maxIterations) throws IOException {
        try {
            FileWriter fw = new FileWriter("impacter.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println("guestBodyBase: " + guestBodyBase);
            pw.println("hostSystem: " + hostSystem);
            pw.println("\nChecking host system configuration...");
            int iteration;
            do {
                iteration = 0;
                for (int i = 0; i < hostSystem.countSubEntities(); i++) {
                    if (iterateImpact(hostSystem.getSubEntity(i), hostSystem)) {
                        iteration = 1;
                        break;
                    }
                }
            } while (iteration == 1);

            while (iteration < maxIterations) {
                iteration++;
                for (int i = 0; i < hostSystem.countSubEntities(); i++) {

                }
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Writer crash");
        }

    }

    private boolean iterateImpact(BodyBase impactBodyBase, StarSystem hostSystem) {
        for (int i = 0; i < hostSystem.countSubEntities(); i++) {
            /*double distanceDelta = Math.abs(impactBodyBase.getDistanceFromCenter() - hostSystem.getSubEntity(i).getDistanceFromCenter());
            double radiusSum = (impactBodyBase.getDiameter() + hostSystem.getSubEntity(i).getDiameter()) / 2;
            if ((distanceDelta - radiusSum) < 1) {
                PrintWriter pw = getPrinterWriter("");

                pw.println("\nImpact detected!\nImpacter " + impactBodyBase;
                pw.println("\nVictim " + hostSystem.getSubEntity(i));
                } catch (IOException e) {
                    System.out.println("Writer crash");
                }
                return true;
            }*/
        }
        return false;
    }

    private PrintWriter getPrinterWriter(String outputString) {
        try {
            return new PrintWriter(new BufferedWriter(new FileWriter("impacter.txt")));
        } catch (IOException e) {
            // have no idea what to put here
        }
        return null;
    }
}
