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
And we got a very small key (this time only two letters a and h): <br> 
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
Now we move the bitset to the left, cause the boolean meaning of the key bit is false.
So we got: <br>
```110011111100110101001001110010011100100001111010```<br>
This will happend for every bit of the key.

### License
You can test the code and use it privately. It is not allowed to use the code without my permission, provided that the using project generates financial income (regardless of the source).
Other non-profit projects must name the origin of the algorithm and the author.
More information: https://twitter.com/swenkalski


