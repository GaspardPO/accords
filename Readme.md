# Ellerehcseb

Chords Finder

an application where I can enter notes, and it gives me the name of the chord:
C, D#, F#, A  -> Cdim7

Algo:
- all chords are generated,
- then we search in the list for the chord with the same notes as input.

## Archi
[core folder](accords-backend/src/main/kotlin/eu/gaspard/accordsbackend/core): all "business" about music.  
[api folder](accords-backend/src/main/kotlin/eu/gaspard/accordsbackend/api): controllers, rest api.

### api 
- [x] uses character (A, B, C ...)
- [X] error : when character is not a note
- [ ] error ? warning ? when character is a note but not enough to find the chords ?
- [x] uses b or s for flat and sharp
- [ ] uses # for sharp (works in real life but not in tests ?)
- [ ] uses notes (Do, Ré, Mi ...)
- [ ] german notation ?
- [x] output: chord name (A, B, C)
- [ ] output: chord name (Do, Ré, Mi)
- [ ] output: chord info (name, interval, third,
- [ ] display the chord name using b and # ?

### business core: notes to chord
- [x] perfect major
- [x] perfect minor
- [x] (dominant) 7th : maj7, min7, m(maj7)
- [x] diminished
- [x] diminished seventh  
  ...
- [x] Don't use the first notes as root (inversion).
- [ ] say when a chord is reversed
- [x] chords with exactly the given notes
- [ ] chords with other notes (not only the ones given as input : eg: E, C -> Am, C)
- [ ] chords with other notes, using the first as root?  
  ...
- [x] sharp/flat (using fretted instrument, D# == Eb)
- [ ] display Bb and Eb instead of A# and D# 
- [x] error when chord not found
  ...
- [ ] use a csv config file with the chords list ?

###  Chord to notes
From the chord, give the notes.


### Frontend :
- [ ] input: note as character
- [ ] input: note as button
- [ ] input: note on piano keyboard
- [ ] input: note on piano keyboard
- [ ] input: note on guitar/uku/banjo/... neck

### Mobile :
- [ ] input: note as character
- [ ] input: note as button
- [ ] input: note on piano keyboard
- [ ] input: note on piano keyboard
- [ ] input: note on guitar/uku/banjo/... neck

### CI / CD :
- [ ] Unit Tests
- [ ] End-to-End Tests
- [ ] UI Test using mock
- [ ] build apk
- [ ] deploy on store?

