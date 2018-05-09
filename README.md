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
The test will be converted from a string to a binary code.
The key runs through the text with 1 bit each. So every bit in the key will
generate a substitution for every bit of the text.
 substitution = t ⊕ k;

```
key.foreach( key ->
    { 
    text.foreach(textBit -> {
        append(textBit ^ key)
    }
} 
```

The text to be encrypted is then moved by 1 bit. 
Here the 1 bit set decides whether negative or positive. 
This decision is set by the true / false state of the actual key-bit.

### Example
We got the Text "hello" as binary notation: <br> 
```011010000110010101101100011011000110111100001010```<br>
And we got a very small key (this time only two letters e and h): <br> 
```0110010101101000```<br> 
We pass the first bit of the key to every bit of the text:
The key bit is 0.
We run trough every bit of the Text as XOR.
``` 
0 ^ 0 = 1 
0 ^ 1 = 0 
0 ^ 1 = 0 
...
```
The Result is: <br> 
```100111111001101010010011100100111001000011110101```<br>
This is a very common and simple encryption/substitution.
Now we shift the bitset to the left, cause the boolean meaning of the key bit is false.
If it's true (1), we shift to the right.<br>
So we got: <br>
```110011111100110101001001110010011100100001111010```<br>
This will happen for every bit of the key.
In this demonstration we got  16 Rounds with 40 substitution steps and 16 shifts/distortions.

No pattern can be found in a test with the same key and 10 texts with 4000+ words. 
The higher the key, the higher the degree of entropy. 



### advantages
Because of the shift from right and left, an effective destruction of patterns is achieved and makes the encryption extremely secure.
By saving many steps which take place at AES, the computing time is massively shortened without creating a hazard.

Thus, this cipher is optimal for cloud servers and large files.


### License
You can test the code and use it privately. It is not allowed to use the code without my permission, provided that the using project generates financial income (regardless of the source).
Other non-profit projects must name the origin of the algorithm and the author.
More information: https://twitter.com/swenkalski


