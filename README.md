# Software Engineering Gruppeoppgave

## Introduksjon til prosjektet
I dette prosjektet så er målet å gi brukere med ledig kjøretøy muligheten til å midlertidig låne bort sine kjøretøy til andre brukere for å oppfylle deres midlertige transportbehov. Vi har kommet frem til en løsning som kan utføres ved å utvikle en applikasjon som lett gir brukeren muligheten til å sette opp bilen sin for lån ved å registrere bilskilt og informasjon om bilen. 

## Hvordan vi har planlagt backend
Det kreves først at man må registrere seg selv på applikasjonen. Vi har kommet frem til at man må bruke BankID for å både registrere og logge inn (andre innlogging metode for turister. Mer om dette senere). Dette hjelper til med sikkerheten til hele applikasjonen. Det blir da lett for våre admins å holde kontroll på svindel og lignende. Etter at du har registrert deg som bruker så har du 2 valg. Du kan låne kjøretøy. Først og fremst så må du ha verifisert at du har førerkort. Da må du først sette inn når du vil låne bilen. Etter at du har gjort dette så får du opp en liste med ledige kjøretøy i nærheten av deg. Det kommer senere til å bli lagt til funksjoner som tilatter filtrering hvor du kan for eksempel velge antall seter, bilmerke eller modell. Når du er ferdig med å velge kjøretøy og tidspunkt så får du muligheten til å betale for tjenesten. Du kan få kjøretøyet kjørt hjem til deg for en ekstra utgift hvis kjøretøy eieren har satt seg selv opp for dette. Etter at du har er ferdig med betalingen så blir det sendt en request til låneren som da aksepterer eller avslår din forespørsel. Du har også muligheten til å leie ut kjøretøyet ditt. Du må da fylle ut informasjon om kjørtetøyet, inkludert alle skader som allerede eksisterer på kjøretøyet. Deretter, som nevn tildigere, så kan du for eksempel sette en utgift på å kjøre kjøretøyet bort til låneren. Til slutt så skal du sette en tidsperiode som kjøretøyet er ledig.

Vi har tenkt da at man bestiller tid gjennom appen, eller plukke opp bilen som er tilgjenelig nå på bilen man ønsker, det er også sånn at når du skal dra å hente bilen bruker du appen for å låse opp bilen og kjøre. Mobilen er da bilnøkkelen. Det som skjer da er at appen kobler seg til bilen via bluetooth og åpner den. 

Leie prisen blir oppført på appen, der har prisen forsikring inkludert og kilometer, men bom parkering og drivstoff kommer i tilegg.

Det er også planlagt å gi brukerne mulighet til å gi tilbakemelding og "stjerner" til andre brukere, men det kommer i en senere versjon. 
