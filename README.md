# Planificator de grădină

<img width="1011" height="655" alt="image" src="https://github.com/user-attachments/assets/d4bae3ea-4008-4e3a-bc8c-b55307194f9e" />


Aplicație desktop în Java (Swing, NetBeans) pentru desenarea planului unei grădini. Poți așeza pe o suprafață verde copaci, straturi, iazuri și alei curbe, le poți muta și redimensiona, iar la final poți salva scena și o poți încărca din nou.

Proiectul pornește de la aplicația de desenare prezentată la curs (interfața `Desenabil`, clasa abstractă `Figura`, câte o clasă pentru fiecare formă) și adaugă **linii curbe mutabile** (aleile), plus forme noi cu aspect propriu.

## Funcționalități

- Patru tipuri de obiecte: **Copac**, **Strat**, **Iaz**, **Alee** (linie curbă desenată liber cu mouse-ul).
- Redimensionare în timpul desenării, prin tragere cu mouse-ul.
- Mutarea obiectelor după ce au fost puse.
- Alegerea culorii pentru obiectele noi.
- Ștergerea unui obiect selectat sau a întregii scene.
- Salvarea scenei într-un fișier și încărcarea ei ulterioară.
- Desenul rămâne pe loc când fereastra este redimensionată, minimizată sau acoperită.

## Rulare

1. Deschide proiectul în NetBeans (recomandat un JDK recent, de exemplu 21).
2. Click dreapta pe `Interfata.java` → **Run File** (Shift+F6).
3. Dacă NetBeans cere clasa principală: **Project Properties → Run → Main Class** → `gradina.Interfata`.

## Ghid de utilizare

### Bara de unelte (dreapta)

| Element | Ce face |
|---|---|
| **Copac**, **Strat**, **Iaz**, **Alee** | Alege ce obiect desenezi la următoarea tragere cu mouse-ul |
| **Culoare** + pătrățelul de lângă ea | Alege culoarea obiectelor următoare; pătrățelul arată culoarea curentă |
| **Șterge selectata** | Șterge obiectul marcat cu cruce roșie |
| **Curăță tot** | Șterge toate obiectele de pe scenă |
| **Salvează** | Salvează scena în fișierul `gradina.txt` |
| **Încarcă** | Încarcă scena din `gradina.txt` |

### Cum adaugi un obiect

1. Apasă unul dintre butoanele **Copac**, **Strat**, **Iaz** sau **Alee**.
2. **Ține apăsat click** pe suprafața verde, în locul unde vrei obiectul.
3. **Fără să dai drumul**, mișcă mouse-ul. Obiectul se redimensionează în timp real.
4. Dă drumul la click. Obiectul rămâne pe loc, iar unealta se deselectează automat.

Pentru următorul obiect trebuie să alegi din nou o unealtă.

### Ce face mișcarea mouse-ului la fiecare obiect

| Obiect | Punctul unde apeși | Cum se modifică la tragere |
|---|---|---|
| **Copac** | Centrul coroanei | Cu cât te îndepărtezi de centru, în orice direcție, cu atât coroana și tulpina cresc. Spre centru, se micșorează. |
| **Strat** | Centrul dreptunghiului | Mișcarea **stânga-dreapta** schimbă lățimea, mișcarea **sus-jos** schimbă înălțimea. Sus-jos mărește sau micșorează stratul pe verticală. |
| **Iaz** | Centrul elipsei | La fel ca la strat: lățimea după mișcarea orizontală, înălțimea după cea verticală. Numărul de pietricele se adaptează mărimii. |
| **Alee** | Începutul aleii | Mouse-ul **trasează traseul**. Aleea urmează drumul pe care îl faci și se netezește automat. |

Obiectele noi au mereu mărimea inițială foarte mică. Dacă dai doar un click scurt, fără tragere, obiectul abia se vede.

### Cum muți un obiect

1. Asigură-te că **nicio unealtă nu este apăsată**.
2. Dă click pe **centrul** obiectului (la copac, strat și iaz) sau pe un punct al traseului (la alee). Apare o **cruce roșie**, care arată că obiectul este selectat.
3. **Ține apăsat și trage.** Obiectul se mută odată cu mouse-ul.

Dacă mai multe obiecte se suprapun, se selectează cel desenat ultimul (cel de deasupra). Click pe un loc gol deselectează obiectul.

### Cum ștergi

- **Un obiect:** selectează-l (cruce roșie), apoi apasă **Șterge selectata**.
- **Tot:** apasă **Curăță tot**.

### Culoarea

Apasă **Culoare**, alege din paletă și confirmă. Culoarea se aplică doar obiectelor desenate de acum încolo. Cele deja puse își păstrează culoarea. Câteva sugestii:

- **Copac:** nuanțe de verde.
- **Strat:** maro, verde sau galben.
- **Iaz:** albastru.
- **Alee:** bej sau maro deschis (pe verde, aleea se confundă cu iarba).

### Salvare și încărcare

- **Salvează** scrie toate obiectele din scenă în fișierul `gradina.txt`, în folderul proiectului. Dacă fișierul există, este suprascris.
- **Încarcă** citește `gradina.txt` și înlocuiește scena curentă cu cea salvată. Obiectele existente sunt șterse.
- Poți deci să salvezi, să apeși **Curăță tot** și, apoi, cu **Încarcă**, scena reapare exact cum era (poziții, mărimi, culori și traseele aleilor).

### Exemplu de flux

1. Alege culoarea albastră, apasă **Iaz** și desenează iazul în mijloc.
2. Alege verde, apasă **Copac** și pune câțiva copaci în jurul iazului.
3. Alege maro, apasă **Strat** și desenează două straturi lungi.
4. Alege bej, apasă **Alee** și trasează o potecă curbă între straturi.
5. Mută un copac care este prea aproape de iaz: fără nicio unealtă apăsată, click pe centrul lui, apoi tragi.
6. Apasă **Salvează**.

## Aspectul obiectelor

- **Copac:** coroană făcută din trei cercuri suprapuse și tulpină maro, proporțională cu coroana.
- **Strat:** dreptunghi cu patru rânduri pe lungime și punctișoare mai închise la culoare, ca niște semințe sau flori.
- **Iaz:** elipsă transparentă înconjurată de pietricele de mărimi și nuanțe de gri diferite.
- **Alee:** bandă lată, cu margine mai închisă și floricele de culori diferite (galben, roșu, mov, roz, alb, portocaliu) presărate pe traseu.

Pietricelele, punctele de pe strat și floricelele sunt generate cu un număr aleator fix. Rămân pe loc la mutare, redesenare și încărcare, deci nu "tremură".

## Structura proiectului

| Fișier | Rol |
|---|---|
| `Desenabil.java` | Interfața comună tuturor obiectelor (desenare, mutare, redimensionare, selectare, salvare) |
| `Figura.java` | Clasă abstractă: poziție, culoare, marcaj de selecție, mutare, salvarea părții comune |
| `Copac.java` | Copac (coroană și tulpină) |
| `Strat.java` | Strat de flori sau legume |
| `Iaz.java` | Iaz cu pietricele pe margine |
| `Alee.java` | Linie curbă mutabilă, netezită, cu floricele |
| `PanouDesen.java` | Suprafața de desenare; reface desenul în `paintComponent` |
| `Interfata.java` | Fereastra principală: butoane, evenimente de mouse, salvare și încărcare |

Adăugarea unui obiect nou înseamnă o clasă nouă care extinde `Figura`, un buton nou și un `case` nou în metoda **Încarcă**.

## Format fișier `gradina.txt`

Fișier text, câte o valoare pe linie. Fiecare obiect începe cu un cod (`0` copac, `1` strat, `2` iaz, `3` alee), urmat de `x`, `y` și culoare, apoi de datele proprii: raza la copac, lățime și înălțime la strat și iaz, numărul de puncte și coordonatele lor la alee.

## Limitări cunoscute

- Un obiect poate fi redimensionat doar în momentul desenării. După ce a fost pus, poate fi doar mutat sau șters.
- Nu există anulare (undo).
- Selectarea se face prin click lângă centrul obiectului (aproximativ 10 pixeli), nu oriunde pe suprafața lui.
- La alee, tragerea mută întreaga alee. Pentru rezultatul cel mai previzibil, apucă aleea de începutul ei.
- Scena se salvează într-un singur fișier fix, `gradina.txt`.

## Idei de extindere

- Curbe Bézier cu puncte de control.
- Selector de grosime pentru alee.
- Obiecte noi (bancă, gard, felinar, brad) ca încă o clasă derivată din `Figura`.
- Anulare și refacere (undo/redo).
- Alegerea numelui fișierului la salvare, cu `JFileChooser`.
