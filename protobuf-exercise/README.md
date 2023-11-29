# Procol Buffers Exercise

## Installation

Download `protoc` (Protocol Buffer Compiler) from
https://github.com/protocolbuffers/protobuf/releases
(you'll find `protoc` under the `/bin` folder)

Or via docker:
```bash
docker pull namely/protoc-all

cd directory/with/proto/files
# example for ruby code generation
docker run -v $PWD:/defs namely/protoc-all -f *.proto -l ruby
# you can ignore the warning about the image's platform

cd gen
```
## Exercise 

1. Write a schema that can contain the data as described in the typescript schema below.
   1. Store this schema somewhere as patient.proto
2. Pick a [supported language](https://protobuf.dev/overview/#cross-lang) and generate the required code via `protoc`
3. Write a program that generates one object of the Patient type and serializes it to a file
4. Write a program that reads the file from step 3 and deserializes it to an object of the Patient type
5. Now add a new field and delete a field to the schema, regenerate the code, and update the program that reads the file (step 4) 
   1. Can it still read the file, despite the removed field? (The field is still in the data because it was written by an older version of the program = backward compatibility)
   2. What does it say for the new field?
6. Add another new field to the schema, regenerate the code, and update the program that writes the file (step 4)
   1. Can the program from step 5 still read the file, despite the new added field? (The field is in the data because it was written by a newer version of the program = forward compatibility)
   

```typescript
type AnnotationType = "afib" | "pauze" | "bradycardia" | "tachycardia";
type Annotation = {
  id: string;
  start: number; // unix timestamp with milliseconds as decimal
  end: number; // unix timestamp with milliseconds as decimal
  type: AnnotationType;
};

type Patient = {
  hospitalId: string;
  patientId: string;
  sensorDotIds: string[];
  annotations: Annotation[];
};
```