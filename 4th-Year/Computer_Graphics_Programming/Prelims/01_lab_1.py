# Marc Plarisan | BSIT701 | Computer Graphics Programming | 01 Laboratory Exercise 1
import turtle
ts = turtle.Screen()
t = turtle.Turtle()

ts.bgcolor("black")
t.speed(6)

ARM_LENGTH = 70
LEG_LENGTH = 75

t.forward(50)
t.back(10)
t.right(90)
t.left(5)

t.undo()
t.reset()

# Draw head
t.pensize(5)
t.color("green", "lightgreen")
t.begin_fill()
t.circle(50)
t.end_fill()

# Draw legs and arms
t.right(85)
t.pendown()
t.forward(70)
t.right(30)
t.forward(LEG_LENGTH)

t.back(LEG_LENGTH)
t.left(50)
t.forward(LEG_LENGTH)

t.back(LEG_LENGTH)
t.right(200)
t.forward(50)
t.left(75)
t.forward(ARM_LENGTH)

t.back(ARM_LENGTH)
t.right(150)
t.forward(ARM_LENGTH + 10)

# Draw the handle
t.pensize(7)
t.color("brown")
t.right(125)
t.forward(100)
t.back(195)
t.right(80)

# Draw Tip
t.color("gray")
t.right(100)


def draw_tip():
    t.begin_fill()
    t.forward(20)
    t.left(120)
    t.forward(20)
    t.left(120)
    t.forward(20)
    t.left(120)
    t.end_fill()


draw_tip()
t.right(50)
draw_tip()


def draw_star(size):
    for _ in range(5):
        t.forward(size)
        t.right(144)


# Draw Stars
t.penup()
t.goto(-200, 150)
t.pendown()
t.color("yellow")
t.pensize(2)
draw_star(15)

t.penup()
t.goto(180, 200)
t.pendown()
draw_star(12)

t.penup()
t.goto(-150, 250)
t.pendown()
draw_star(10)

t.penup()
t.goto(100, 180)
t.pendown()
draw_star(8)

# Draw moon
t.penup()
t.goto(170, 225)
t.pendown()
t.color("lightyellow", "lightyellow")
t.begin_fill()
t.circle(30)
t.end_fill()

t.hideturtle()
ts.exitonclick()
