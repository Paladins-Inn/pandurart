# PANDURART - Helping organizing events

> What man is a man who does not make the world better.
>
> -- Balian, Kingdom of Heaven

## Abstract
PANDURART is a software to help organizing events.
Events are organized by organizations and take place in venues.
They may have multiple tracks combined of multiple sessions.
Every session has at least one speaker and multiple participants.


## History
This project evolved from Torganized Play and the https://rollenspiel-cons.info RPG Convention Calendar.
Since there is a new and better calendar (https://con-kalender.org), I moved on to implement step two of the 
organization tool.


## License
The license for the software is LGPL 3.0 or newer. 


## Architecture

tl;dr (ok, only the bullshit bingo words):
- Immutable Objects
- Relying heavily on generated code
- 100 % test coverage of human generated code
- Every line of code not written is bug free!

Code test coverage for human generated code should be 100%, machinge generated code is considered bugfree until proven 
wrong. But every line that needs not be written is a bug free line without need to test it. So aim for not writing code.


## A note from the author
I'm working on another project that can be found on github [(PANDURART)](https://github.com/paladins-inn/pandurart). And while
developing that piece of software I ran on the blocker not being able to nicely handle OIDC UMA. I looked around and
found no library to abstract away UMA from my code. So I decided to write one.

If someone is interested in getting it faster, we may team up. I'm open for that. But be warned: I want to do it 
_right_. So no short cuts to get faster. And be prepared for some basic discussions about the architecture or software 
design :-).

---
Bensheim, 2026-04-05
