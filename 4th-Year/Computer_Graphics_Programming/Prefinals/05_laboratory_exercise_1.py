# Marc Plarisan | BSIT701 | Computer Graphics Programming - 05 Lab 1

import pygame
from pygame.locals import *

from OpenGL.GL import *
from OpenGL.GLU import *

pygame.init()
display = (800, 600)
pygame.display.set_mode(display, DOUBLEBUF | OPENGL)
pygame.display.set_caption('05 Lab 1 - Marc Plarisan')

glDisable(GL_DEPTH_TEST)
gluPerspective(45, (display[0] / display[1]), 0.1, 50.0)
glTranslatef(0, 0, -5)
glScalef(0.5, 0.5, 0.5)

vertices = [
    (1, 1, 1),    # 0
    (1, 1, -1),   # 1
    (1, -1, -1),  # 2
    (1, -1, 1),   # 3
    (-1, 1, 1),   # 4
    (-1, 1, -1),  # 5
    (-1, -1, -1),  # 6
    (-1, -1, 1)   # 7
]

faces = [
    # Front face (z = 1)
    (0, 3, 2), (0, 2, 1),
    # Back face (z = -1)
    (4, 5, 6), (4, 6, 7),
    # Left face (x = -1)
    (4, 7, 3), (4, 3, 0),
    # Right face (x = 1)
    (1, 2, 6), (1, 6, 5),
    # Top face (y = 1)
    (0, 1, 5), (0, 5, 4),
    # Bottom face (y = -1)
    (3, 7, 6), (3, 6, 2)
]


def draw_cube():
    # Hello sir, as I mentioned from the previous lab exericises, I did the drawing of the cube
    # slightly different here to adhere clean code principles. Instead of calling the same function
    # over and over again across multiple lines, I stored the positions to draw a cube so I can
    # just iterate over them instead of duplicating multiple function calls.
    # You may find differences in my other functions as well
    glBegin(GL_TRIANGLES)
    for face in faces:
        for vertex in face:
            glVertex3fv(vertices[vertex])
    glEnd()


def draw_object():
    # First Cube
    glPushMatrix()
    try:
        glColor3f(0.0, 0.25, 0.0)  # Dark Green
        glScalef(1.0, 1.0, 1.0)
        draw_cube()
    finally:
        glPopMatrix()

    # Second Cube
    glPushMatrix()
    try:
        glColor3f(0.0, 0.5, 0.0)   # Medium-Dark Green
        glScalef(0.8, 0.8, 0.8)
        draw_cube()
    finally:
        glPopMatrix()

    # Third Cube
    glPushMatrix()
    try:
        glColor3f(0.0, 0.75, 0.0)  # Medium-Light Green
        glScalef(0.6, 0.6, 0.6)
        draw_cube()
    finally:
        glPopMatrix()

    # Fourth Cube
    glPushMatrix()
    try:
        glColor3f(0.0, 1.0, 0.0)   # Bright Green
        glScalef(0.4, 0.4, 0.4)
        draw_cube()
    finally:
        glPopMatrix()


while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            quit()
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_a:
                glTranslatef(-1, 0, 0)
            if event.key == pygame.K_d:
                glTranslatef(1, 0, 0)
            if event.key == pygame.K_w:
                glTranslatef(0, 1, 0)
            if event.key == pygame.K_s:
                glTranslatef(0, -1, 0)

    glRotatef(1, 1, 1, 1)
    glClear(GL_COLOR_BUFFER_BIT)
    draw_object()

    pygame.display.flip()
    pygame.time.wait(15)
