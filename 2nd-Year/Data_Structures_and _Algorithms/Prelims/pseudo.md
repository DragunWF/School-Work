1. Import randint from random module
2. damage_player_took = 0
3. bosses = [{'name': 'Orc', 'health': 100}, {'name': 'Vampire', 'health': 150}, {'name': 'Dragon', 'health': 250}]
4. boss_damage_max = 30
5. boss_damage_min = 100
6. for boss in bosses
7. Inside for loop -> Print f'{boss.name} has appeared!'
8. Inside for loop -> while boss.health > 0
9. Inside for loop -> Inside while loop -> Enter Damage
10. Inside for loop -> Inside while loop -> Subtract boss.health to damage
11. Inside for loop -> Inside while loop -> boss_damage = randint(boss_damage_max, boss_damage_min)
12. Inside for loop -> Inside while loop -> damage_player_took += boss_damage
13. Inside for loop -> Print f'{boss.name} has been defeated!'
14. Print 'Congrats! All the bosses have been defeated!'
15. Print f'You took {damage_player_took} for the entire run!'
