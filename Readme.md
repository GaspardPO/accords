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
- [ ] uses character (A, B, C ...)
- [ ] uses # or s for sharp
- [ ] uses b for flat
- [ ] uses notes (Do, Ré, Mi ...)
- [ ] output: chord name
- [ ] output: chord info (name, interval, third,
- [ ] display the chord name using b and # ?

### business core:
- [x] perfect major
- [x] perfect minor
- [x] (dominant) 7th : maj7, min7, m(maj7)
- [x] diminished
- [x] diminished seventh  
  ...
- [x] Don't use the first notes as root (inversion).
- [ ] say when a chord is reversed
- [x] chords with exactly the given notes
- [ ] chords with other notes (not only the ones given as input)
- [ ] chords with other notes, using the first as root?  
  ...
- [x] sharp/flat (using fretted instrument, D# == Eb)
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

