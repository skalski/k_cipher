# k_cipher
This encryption is still in the test stage.

## Important Notice:
Please do not (yet) use the cipher. It is still in the development stage and many tests are still necessary. 

## The acceptance criteria were:
- easy to learn how it works (must be understood by an 8-year-old child)
- the key must not be limited in its length
- the code must work quickly and can be created with just a few lines
- the encryption must withstand common decryption methods

### Functionality:
The test and key will be converted from a string to a binary code.
The key runs through the text with 2 bits each. The 2 bit set decides which of the four tranlationsMaps will be used.

![schema of k_cipher](https://raw.githubusercontent.com/skalski/k_cipher/master/readme_assets/01.png)


The text to be encrypted is then moved by 1 bit. Here the 2 bit set decides whether negative or positive. This decision is set by the odd/ even state of the bit set.

### License
You can test the code and use it privately. It is not allowed to use the code without my permission, provided that the using project generates financial income (regardless of the source).
Other non-profit projects must name the origin of the algorithm and the author.
More information: https://twitter.com/swenkalski


