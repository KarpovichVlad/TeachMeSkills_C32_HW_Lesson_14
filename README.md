# The following task was implemented here:

Let's say there is a file with document numbers.
The document number is a string consisting of letters and numbers (without service characters).
Let this file contain each document number from a new line and no other information in the line, only the document number.
A valid document number must be 15 characters long and begin with the sequence docnum (hereinafter any sequence of letters/numbers) or contract (hereinafter any sequence of letters/numbers).
Write a program to read information from an input file - the path to the input file must be set via the console.
The program should check the document numbers for validity.
Valid docnum document numbers should be recorded in a single report file.
Valid contract numbers should be recorded in another report file.
Invalid document numbers should be written to another report file, but after the document numbers, you should add information about why this document is invalid (incorrect sequence of characters at the beginning/there are service characters