# Marc Plarisan | BSIT701 | Computer Graphics Programming
import turtle
import random

# --- GAME CONSTANTS ---
PLAYER_MOVE_DISTANCE = 25
PLAYER_MOVE_SPEED = 5
COLLISION_DISTANCE = 25
NUM_SHAPES = 10

# --- SCREEN SETUP ---
screen = turtle.Screen()
screen.bgcolor("black")

# --- PLAYER SETUP ---
player = turtle.Turtle()
player.shape("turtle")
player.color("darkgreen")
player.speed(PLAYER_MOVE_SPEED)
player.penup()

# --- SCOREBOARD SETUP ---
shapes_left = NUM_SHAPES
scoreboard = turtle.Turtle()
scoreboard.speed(0)
scoreboard.color("white")
scoreboard.penup()
scoreboard.hideturtle()
scoreboard.goto(screen.window_width()/2 - 250, screen.window_height()/2 - 50)


def update_scoreboard():
    scoreboard.clear()
    scoreboard.write("Shapes Left: {}".format(shapes_left),
                     align="center", font=("Courier", 20, "normal"))


# --- SHAPES SETUP ---
shapes = []
shape_colors = [
    "red", "orange", "yellow", "lightgreen", "blue", "purple",
    "pink", "cyan", "magenta", "brown", "black", "white",
    "gray", "gold", "lime", "indigo", "violet", "turquoise"
]
shape_types = [
    "circle", "square", "triangle"
]

for _ in range(NUM_SHAPES):
    shape = turtle.Turtle()
    shape.shape(random.choice(shape_types))
    shape.color(random.choice(shape_colors))
    shape.penup()
    shape.speed(0)
    rand_x = random.randint(-250, 250)
    rand_y = random.randint(-200, 200)
    shape.goto(rand_x, rand_y)
    shapes.append(shape)


def show_win_screen():
    winner_text = turtle.Turtle()
    winner_text.hideturtle()
    winner_text.color("lime")
    winner_text.write("You Win!\nGame By: Marc Plarisan",
                      align="center",
                      font=("Courier", 18, "bold"))


def check_collision():
    global shapes_left
    for shape in shapes[:]:
        if player.distance(shape) < COLLISION_DISTANCE:
            shape.hideturtle()
            shapes.remove(shape)
            shapes_left -= 1
            update_scoreboard()
            if shapes_left == 0:
                show_win_screen()


def move_left():
    player.setheading(180)
    player.forward(PLAYER_MOVE_DISTANCE)
    check_collision()


def move_right():
    player.setheading(0)
    player.forward(PLAYER_MOVE_DISTANCE)
    check_collision()


def move_up():
    player.setheading(90)
    player.forward(PLAYER_MOVE_DISTANCE)
    check_collision()


def move_down():
    player.setheading(270)
    player.forward(PLAYER_MOVE_DISTANCE)
    check_collision()


def set_controls():
    screen.listen()
    screen.onkey(move_up, "Up")
    screen.onkey(move_down, "Down")
    screen.onkey(move_left, "Left")
    screen.onkey(move_right, "Right")


set_controls()
update_scoreboard()
screen.mainloop()
