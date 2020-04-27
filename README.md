<h1 align="center">
  <a href="http://www.nitramite.com/"><img src="https://github.com/norkator/Cryptography/blob/master/img/cryptography_repository_image.png" alt="Cryptography"></a>
</h1>


# Cryptography

This repository will slowly get more and more cryptography code samples written in Java. 
Methods are related to Cryptography android application cipher method collection. 
Point of this repository is that users can find everything in one place, modify code, play with these methods 
in any way they want and this way learn how ciphers worked in the past and how they work these days.
In short words this repository is meant to be educational.

This repository is part of this Android application: [Google Play - Cryptography](https://play.google.com/store/apps/details?id=com.nitramite.cryptography)


### Ciphers

##### [A1z26](https://github.com/norkator/Cryptography/blob/master/src/cryptography/ciphers/a1z26/A1z26.java)
##### [Adfgvx](https://github.com/norkator/Cryptography/blob/master/src/cryptography/ciphers/adfgvx/Adfgvx.java)
##### [Atbash](https://github.com/norkator/Cryptography/blob/master/src/cryptography/ciphers/atbash/Atbash.java)
##### [Autokey](https://github.com/norkator/Cryptography/blob/master/src/cryptography/ciphers/autokey/Autokey.java)
##### [Bacon](https://github.com/norkator/Cryptography/blob/master/src/cryptography/ciphers/bacon/Bacon.java)
##### [Beaufort](https://github.com/norkator/Cryptography/blob/master/src/cryptography/ciphers/beaufort/Beaufort.java)
##### [Caesar](https://github.com/norkator/Cryptography/blob/master/src/cryptography/ciphers/caesar/Caesar.java)
##### [Chaocipher](https://github.com/norkator/Cryptography/blob/master/src/cryptography/ciphers/chaocipher/Chaocipher.java)
##### [Gronsfeld](https://github.com/norkator/Cryptography/blob/master/src/cryptography/ciphers/gronsfeld/Gronsfeld.java)
##### [Keyword](https://github.com/norkator/Cryptography/blob/master/src/cryptography/ciphers/keyword/Keyword.java)
##### [Playfair](https://github.com/norkator/Cryptography/blob/master/src/cryptography/ciphers/playfair/Playfair.java)
##### [Rail fence](https://github.com/norkator/Cryptography/blob/master/src/cryptography/ciphers/railfence/RailFence.java)
##### [Scytale](https://github.com/norkator/Cryptography/blob/master/src/cryptography/ciphers/scytale/Scytale.java)
##### [Vigenere](https://github.com/norkator/Cryptography/blob/master/src/cryptography/ciphers/vigenere/Vigenere.java)


### Hashes

Coming later...

### Encoding

##### [Base32](https://github.com/norkator/Cryptography/blob/master/src/cryptography/encoding/base32/Base32.java)
##### [Base64](https://github.com/norkator/Cryptography/blob/master/src/cryptography/encoding/base64/Base64.java)
##### [Base85](https://github.com/norkator/Cryptography/blob/master/src/cryptography/encoding/base85/Base85.java)

<br>

### Installation
1. Download and install eclipse: https://www.eclipse.org/downloads/
2. Download project source code by either cloning it with git or by `Clone or download` menu `Download ZIP` option.
2. Open project in Eclipse `File` - `Open projects from File System...`
3. Navigate to `/src` - `cryptography` - `Ciphers.java` and start play with it. Rest of the folder structure
has method specific code and tests files for running automated tests.


### Running tests
1. Right click on `TestRunner.java`
2. Click `Coverage As`
3. Select `1 Java Application`
4. If everything is fine result is `Tests success: true`


### External libraries

##### commons-codec-1.10.jar
Included for Base32 and Base64 encoding methods.


### Notes

Some ciphers or parts of ciphers originate from web sites, tutorials, repositories or other sources. 
There's unfortunately no links to original references.


### Contributions

##### Rules?
Please, write tests if you make something new.

##### Found problem?
Make new branch and create pull request when problem is fixed.

##### Want to optimize code?
You are free to optimize code, make new branch and create pull request when ready.


### Authors

* **Norkator** - *Initial work* - [norkator](https://github.com/norkator)


### Contributors

None so far.
