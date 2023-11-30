package com.axxes.data.protos;

import java.io.FileInputStream;

public class ReadFile {
    public static void main(String[] args) throws Exception {
        var patient = PatientProtos.Patient.parseFrom(new FileInputStream("patient.bin"));
        System.out.println(patient);
    }

}
