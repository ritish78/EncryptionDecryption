<h1>EncryptionDecryption</h1>
<h4>Program to encrypt and decrypt texts</h4>

<h4>How to use</h4>
To test the encryption and decryption, first, clone the .java file. 
It is made to run through command line. Instead of using 'Scanner' class, 
arguments in command line is used to provide the option of encryption or decryption in any order.
For encryption and decryption, we have two algorithm. One is to add a certain value to a single character
and even if it exceeds alphabet characters, we use it. And the other algorithm is Ceaser (shift in this program) algorithm.
<h5>It can also read from file and write to a file.</h5>

<h4>Examples of command</h4>
<h5>java EncryptDecrypt -key 5 -alg shift -data "Ijhwduynsl ymj jshwduyji rjxxflj" -mode dec</h5>
<h5>Explanation: </h5> Here the decryption key is 5, the algorithm used is shift (also called Ceaser) and the data is provided.
We have used decryption mode.

<h5>java EncryptDecrypt -mode enc -in file_to_read.txt -out file_to_output.txt -key 9 -alg unicode</h5>
<h5>Explanation: </h5> Here the encryption key is 9, the algorithm used is unicode. We are reading from 'file_to_read.txt' and 
then writing in 'file_to_output.txt' after the encryption is completed.



After you have cloned/downloaded/copied from the .java file, compile using the command: 
<i>javac EncryptDecrypt.java</i>
![First compiling the java file](https://user-images.githubusercontent.com/36816476/98441235-23b40500-2151-11eb-95db-1ae2da41b8f5.PNG)

Then, you can type encryption/decryption commands through the command line.
![Running the encryption through command](https://user-images.githubusercontent.com/36816476/98441265-55c56700-2151-11eb-9da9-287e9a8184a5.PNG)

You can also encrypt/decrypt from a file and then write to another file.
![Encrypting from 'encrypt txt' and writing to a new file 'decrypt txt'](https://user-images.githubusercontent.com/36816476/98441286-742b6280-2151-11eb-8172-953709829615.PNG)

The 'encrypt.txt' file used in previous command is:
![Encrypt txt file](https://user-images.githubusercontent.com/36816476/98441308-902f0400-2151-11eb-8aae-dd817937c85e.PNG)


The 'decrypt.txt' file which the previous command creates is:
![decrypt txt file](https://user-images.githubusercontent.com/36816476/98441323-a63cc480-2151-11eb-96a6-dfc1dcd82b3b.PNG)

