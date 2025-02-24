# Encryption/Decryption Program
## _Kulnazarova Aiana COMCEH-24_ 

## Overview

This project implements a simple encryption and decryption program in Java. It allows users to choose between several encryption and decryption algorithms: Caesar cipher and Vigenère cipher. The program uses a console-based interface with color-coded output for a better user experience. The user can input text to be encrypted or decrypted and can choose different cipher types to apply.

## Design Choices

- **User Interface**: The program uses `fusesource.jansi` for colored console output to enhance user experience.
- **Input Validation**: Before processing, user input is validated for allowed characters (letters, numbers, and punctuation marks).
- **Algorithms**: The program implements both Caesar cipher and Vigenère cipher, which are classic encryption techniques.
- **Extensibility**: The design allows easy addition of more cipher algorithms in the future if needed.

## Algorithms and Data Structures

### Caesar Cipher:
- **Encryption**: Each letter in the text is shifted by a given number of positions in the alphabet. The shift wraps around if it exceeds the end of the alphabet.
- **Decryption**: The decryption process reverses the shift to recover the original message.

### Vigenère Cipher:
- **Encryption**: Each letter in the plaintext is shifted by the corresponding letter of the keyword. The keyword repeats itself if it's shorter than the text.
- **Decryption**: Decrypting a message involves reversing the shifts applied during encryption.

### Data Structures:

- **StringBuilder**: 
  - Used in the encryption and decryption methods (`CaesarE`, `CaesarD`, `VigenereE`, `VigenereD`) to build the final result. It is chosen for its performance benefits when appending characters repeatedly, as strings are immutable in Java.

- **Scanner**:
  - Captures user input throughout the program, including cipher selection, text to encrypt or decrypt, and key inputs (shift value or keyword). It also handles input validation by checking text with regular expressions.

- **Regular Expressions**:
  - Employed to validate the input text, ensuring that it only contains letters, digits, and acceptable punctuation marks. This avoids issues when processing the text during encryption and decryption.

- **Ansi (fusesource.jansi)**:
  - Although not a traditional data structure, `Ansi` from the `fusesource.jansi` library is used for styling the console output. It enhances the user experience by adding color to different prompts and results (e.g., yellow for input prompts, red for errors, and cyan for outputs).


## Improvements Made to Initial Implementation
- **Text Validation**: Enhanced input validation to ensure that the user inputs only valid characters, preventing errors during encryption and decryption.
- **User Interface**: Added color coding for a more visually appealing user interface using the `Ansi` class from the `fusesource.jansi` library.

## Input/Output

- **Input**: User provides text to be encrypted or decrypted and a key (either a shift number for Caesar or a keyword for Vigenère):
![Example 1](images/example1.png)

- **Output**: The program outputs the encrypted or decrypted text to the console.

## Challenges

- **Handling Special Characters**: Ensuring that special characters (like punctuation) are not altered during encryption and decryption was a challenge. The solution was to check for character types (letters, digits, or special characters) and apply the cipher only to the appropriate characters.
- **Validation of Input**: Ensuring that the user enters valid text (letters, numbers, or specific symbols) required the implementation of input validation with regular expressions.

## Usage

1. **Run the Program**: Execute the `Main` class.
2. **Choose an Option**: The program will prompt you to select between Caesar or Vigenère encryption/decryption.
3. **Enter Text**: Input the text you want to encrypt or decrypt.
4. **Provide a Key**: For encryption, provide the shift value (Caesar) or keyword (Vigenère). For decryption, the same shift value or keyword must be used.
5. **Get Results**: The encrypted or decrypted text will be displayed.

## Dependencies
- **fusesource.jansi**: A library for providing ANSI escape sequences to colorize terminal output.


## License
This project is licensed under the MIT License.
