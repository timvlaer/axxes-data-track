import { DateTime } from "luxon";
import crypto from "crypto";
import fs from "fs";

type AnnotationType = "afib" | "pauze" | "bradycardia" | "tachycardia";
type Annotation = {
  id: string;
  start: string;
  end: string;
  type: AnnotationType;
  recordingId: string;
};

type Patient = {
  hospitalId: string;
  hospitalName: string;
  alias: string;
  sensorDotIds: string[];
  annotations: Annotation[];
};

const hospitals = [
  { id: "UZG", name: "UZ Gent" },
  { id: "UZA", name: "Universitair Ziekenhuis Antwerpen" },
  { id: "ZOL", name: "Ziekenhuis Oost-Limburg" },
  { id: "YP", name: "Yperman" },
];
const annotationTypes = ["afib", "pauze", "bradycardia", "tachycardia"];

const random = (upper: number): number => Math.floor(Math.random() * upper);
const raise = (err: string): never => {
  throw new Error(err);
};

for (let idx = 0; idx < 20; idx++) {
  const patients = [...Array(100).keys()].map((patientIdx): Patient => {
    const hospital = hospitals[random(4)];
    const alias = crypto.randomBytes(4).toString("hex").substring(1, 4);
    const sensorDots = [
      crypto.randomBytes(8).toString("hex"),
      crypto.randomBytes(8).toString("hex"),
    ];
    const numAnnotations = random(190) + 10;
    const annotations = [...Array(numAnnotations).keys()].map(
      (annotationIdx): Annotation => {
        let start = DateTime.now()
          .minus({ days: 30 })
          .minus({ days: random(30) })
          .minus({ hours: random(24) });
        return {
          id: annotationIdx + crypto.randomBytes(8).toString("hex"),
          start: start.toISO() ?? raise("invalid ts"),
          end:
            start.plus({ seconds: random(10) + 0.5 }).toISO() ??
            raise("invalid ts"),
          type: annotationTypes[random(4)] as AnnotationType,
          recordingId: `rec-${random(10)}`,
        };
      },
    );
    return {
      hospitalId: hospital.id,
      hospitalName: hospital.name,
      alias,
      sensorDotIds: sensorDots,
      annotations,
    };
  });

  fs.writeFileSync(
    "files/patients-" + idx + ".json",
    JSON.stringify(patients, null, 2),
  );
}
