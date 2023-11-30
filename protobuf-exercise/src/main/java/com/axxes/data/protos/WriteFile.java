package com.axxes.data.protos;

import java.io.FileOutputStream;
import java.util.List;

public class WriteFile {
    public static void main(String[] args) throws Exception {
        var patient = PatientProtos.Patient.newBuilder()
                .setPatientId("a1")
                .setHospitalId("UZA")
                .addAllSensorDots(List.of("sensor1", "sensor3"))
                .addAnnotations(
                        PatientProtos.Annotation.newBuilder()
                                .setId("annotation1")
                                .setAnnotationType(PatientProtos.AnnotationType.afib)
                                .build())
                .build();
        patient.writeTo(new FileOutputStream("patient.bin"));
    }

}
