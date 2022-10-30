# L3-president-game-

## Règles : 

Le jeu se joue entre 4 et 7 personnes, et il y a un maître du jeu, non joueur.
Hiérarchie des cartes : 2 - As - Roi - Dame - Valet - 10 - 9 - 8 - 7 - 6 - 5 - 4 - 3.

## Mise en place : 

Le jeu de 52 cartes est distribué dans sa totalité aux joueurs. 

## Déroulement d’une partie (contenant un nombre n de manches) :

   ### Début d’une manche : 

Lors de la première manche, aucun rôle n’est encore attribué. Le joueur qui a la dame de coeur commence puis l’ordre de jeu est déterminé par l’ordre d’arrivée. Une manche est constituée de plusieurs séries de jeu : 
 
   ### Déroulement d’une manche/ série  : 

  #### -> Début 

Le joueur qui commence choisit de poser une carte simple, un double ou une triplette. Les autres joueurs doivent suivre ce nombre de cartes. 

  #### -> Pendant: 

Chacun leur tour, les joueurs posent une carte supérieure ou égale à celle posée précédemment. 

- Si 2 cartes de la même valeur ont été posées à la suite, le prochain joueur doit lui aussi poser une carte de même valeur , ou passer son tour. Idem pour le joueur suivant. S'il pose la quatrième, et dernière, carte de cette valeur, on dit alors qu’il ferme le carré ;

- Si un joueur ne peut ou ne veut pas jouer, il saute son tour ;

- Si un joueur pose quatre cartes de la même valeur il fait une révolution ⇒  la hiérarchie des cartes s’inverse : le 3 devient la meilleure carte et le 2 la moins bonne et ce jusqu’à la fin de la manche en cours. 

 #### -> Fin :

Pour fermer une série , il existe différentes possibilités : 
     - Poser un 2 (qui est la plus haute carte) ;
     - Fermer un carré ;
     - Si aucun joueur ne peut jouer au dessus de la dernière carte posée. C’est le dernier joueur à avoir posé une carte de commencer la suivante 



   ### Fin d’une manche  :

Lorsque les joueurs ont posé toutes leurs cartes, un rôle esr attribué à chacun d'entre eux en fonction de l’ordre dans lequel ils ont finis : 
      - 1er à avoir fini son jeu : Président ;
      - 2e : Vice-Président ;
      - Avant-dernier : Vice-TrouduCul ;
      - Dernier : TrouduCul ;
→ Si l’on joue à plus de 4 joueurs, les autres seront “neutre”.
/!\ Si la dernière carte de la main d’un joueur est un 2, il est alors automatiquement TrouduCul

   ### Début de la manche suivante :

Les joueurs procèdent à un échange de cartes : 
       Le TrouduCul donne ses deux meilleures cartes au Président ;
       Le Vice-TrouduCul donne sa meilleure carte au Vice-Président ;
       Le Président donne les deux cartes de son choix au TrouduCul ;
       Le Vice-Président donne la carte de son choix au Vice-TrouduCul ;
       Les neutres n’échangent pas de carte.
      
C’est le TrouduCul qui commencera la prochaine manche. 


## Fin de la partie : 
Le vainqueur est le joueur qui a eu une tendance à être Président le plus souvent au cours des n manches jouées. 


## Protocole réseau
![This is an image](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=dGl0bGUgUHJlc2lkZW50IEdhbWUKb3B0IGRpc3RyaWJ1dGluZyB0aGUgY2FyZHMgdG8ACAVwbGF5ZXJzCkhvc3QgLT4gR3Vlc3QgMSA6ACEGRm9yWW91KENhcmRbXSkAFw8yAAElMwAnJTQAWxdlbmQAgUEFY2hlY2tpbmcgd2hvIGhhcwCBRQVRdWVlbiBvZiBoZWFydHMgKACBNghoYXMgaXQgaGVyZSAAgSYQMSA6IGhhc0RhbWVkZUNvZXVyKG51bGwAgUkUAAQjMwAoJjQAXRcAgmcILT4gAIJ9BQCBChF0cnVlAIIABmxvb3AgbmJHYW1lcyE9MTAAg1gFdGVsbACDUAhvdGhlcgCDSQgAgiMFc3QAghIFdGhlIGdhbWUgKACDewVTY3VtYmFnIGFmdGVyAIQNBWZpcnN0AB4FAIIZFAAZBVAAhCMFAIJYCQCDdxQABCQzACknNABfGQCCAgkAhTMHSW5UaGVHYW1lKCkhPW51bGwAhTgTcGxheXMoYwCFPgcAgmISAIYNBQAZByxuYkNhcmRzKQphbHQgKAAIBj09MACEMxQAhiUIZmluaXNoZWQgaGlzAIZZBgCGFxMABCkzAC4sNABpHmFsdCBpZiBsYXN0AIdzBSBpcyAyAIc0EyIAh3AIaXMAhBgIIgCHNRMABCM0AC4gAIVhB2FkZFdpbm5lcnModwACBlsAAQcubGVuZ3RoLTFdKQplbHNlABcjAIkQCwCGQAcAhA0RAIliBwCITAhlbmQAghUIAIV4BgCKAwYgdG8gd2luAIEdEHJlc2V0AIQ4CQAxDwCKSgZzZXJpZXMgY2xvc2VkACsVQ2FyZACFAAUAiH4UAIRtNmVuAGEKAIsKCuKAnHJlbWFpbmluZwCLZwdvZiBnAItTB-KAnQCLDxMABDA0ADUzMgCGdBcyAIZqIQCMQw8AhzwWMwAYLzQgOgCIBRQ0AIJRJW9wdCBhc3NpZ24gYSByb2xlIHRvIGVhY2gAhEEIYWNjb3JkAI5vBW8AhRgbAI5mDWRpc3BsYXlSb2xlcwCNRgYsIG5iAI8rBSwgdHlwAIsYBwCOdA0ABDAzADUzNAB2JmVuZApwYXIAhgkId2FwAJBCBXNlIHcAjwUFAIhZC3RoAJEhCywAkEcJABMHVmljZS0ADhEzIAATDQCNPgluZACQOwkAUwgAjVwHAI5TDACQXQpnaXZlAIteBQCLYREAkQQHAJF9CgALIjIAhQoMADogMwCSMQoAaxwAh0oMAIh0DQCJOhsAiXARAIktBgCKFxUAkkwKZW5kIG9mAJAYCQCFABJnYW1lT3ZlcgCEZhIABBYzABsZAIJ1BQBGCGVuZA&s=default)







