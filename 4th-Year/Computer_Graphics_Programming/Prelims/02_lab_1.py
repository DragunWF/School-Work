# Marc Plarisan | BSIT701 | Computer Graphics Programming
import turtle

screen = turtle.Screen()
screen.listen()

t = turtle.Turtle()
t.speed(7)

# + ===== Movement Section ===== +


def move_left():
    t.penup()
    t.setheading(180)
    t.fd(100)


def move_right():
    t.penup()
    t.setheading(0)
    t.fd(100)


def move_up():
    t.penup()
    t.setheading(90)
    t.fd(100)


def move_down():
    t.penup()
    t.setheading(270)
    t.fd(100)


screen.onkey(move_left, "Left")
screen.onkey(move_right, "Right")
screen.onkey(move_up, "Up")
screen.onkey(move_down, "Down")

# + ===== Draw Shapes Section ===== +


def draw_square():
    t.pendown()
    t.color("red", "darkred")
    t.begin_fill()
    for i in range(4):
        t.fd(50)
        t.rt(90)
    t.end_fill()

    t.penup()
    t.color("black")


def draw_rectangle():
    t.pendown()
    t.color("green", "lightgreen")
    t.begin_fill()
    for i in range(4):
        t.fd(50 if i % 2 == 0 else 100)
        t.rt(90)
    t.end_fill()

    t.penup()
    t.color("black")


def draw_circle():
    t.pendown()
    t.color("blue", "lightblue")
    t.begin_fill()
    t.circle(30)
    t.end_fill()

    t.penup()
    t.color("black")


screen.onkey(draw_square, "S")
screen.onkey(draw_rectangle, "R")
screen.onkey(draw_circle, "C")
