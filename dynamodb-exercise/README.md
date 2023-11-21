# DynamoDB exercise

- Design a database structure that supports the following access patterns: (do these 1 by 1 from start to bottom)
  - Get all patients from a specific hospital by hospital id 
  - Get all annotations from 1 patient, sorted from old to new 
  - Get annotations between 2 dates from 1 patient
  - Get all annotations from a specific type (e.g. bradycardia from patient 1)
  - Get all annotations from a recording
  - If a recording comes in from a certain sensor dot, find the right patient to attach the data to
  - Users can update the patient alias
  - Get all hospitals
  - Get all patients from a specific hospital by sorted by creation time, new to old
  - if a user creates a new patient, make sure the alias is unique within the hospital
- Make an example query for each of these access patterns
- Load the data of the json files into dynamodb