# 01_Activity_1 -> Boss Fight
# Convert to flowchart using http://flowchart.js.org/
# Command: python -m pyflowchart activity.py

from random import randint

damage_player_took = 0
bosses = [{"name": "Orc", "health": 100}, {
    "name": "Vampire", "health": 150}, {"name": "Dragon", "health": 250}]
boss_damage_max = 100
boss_damage_min = 30
for boss in bosses:
    print(f"{boss.name} has appeared!")
    while boss.health > 0:
        damage = int(input("Choose the amount of damage you wish to deal: "))
        boss.health -= damage
        boss_damage = randint(boss_damage_min, boss_damage_max)
        damage_player_took += boss_damage
    print(f"{boss.name} has been defeated!")
print("Congrats! All the bosses have been defeated!")
print(f"You took {damage_player_took} for the entire run!")
