# QuickFoxSort
Sorts strings into everyone's favorite dummy sentence, "the quick brown fox jumps over the lazy dog", using Quicksort

Order between uppercase and lowercase letters is not preserved.  
Characters that are not included in the sentence "the quick brown fox jumps over the lazy dog" are placed at the end according to their unicode value.

Examples

```java
QuickFoxSort.sort("sz o q trylow pdhumejoetracvxfn o uihbgk  e");
//>> the quick brown fox jumps over the lazy dog
```
```java
QuickFoxSort.sort(
    "!?Aa bB Cc Dd eE Ff gG Hh iI Jj kK Ll mM Nn oO Pp qQ Rr sS Tt uU Vv wW Xx yY Zz?!");
//>> tHe    qQuiIcCkK   BbRowWNn   fFOXx   JjUMmPpsS   VvEr   Th   lLAaZzyY   DdGg!!??
```

## What are the use cases?
There have been `None` reported use cases.  

### Theoretical use cases
If you know that a string of characters contains the letters needed to create the string "the quick brown fox jumps over the lazy dog" but for some reason the characters are not ordered, e.g. the Intern dropped the USB-Drive, you can use it to reorder the characters.
