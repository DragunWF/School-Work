# Marc Plarisan | BSIT701 | Computer Graphics Programming - 04 Performance Task 1

import pygame
from pygame.locals import *

from OpenGL.GL import *
from OpenGL.GLU import *

pygame.init()
display = (800, 600)
pygame.display.set_mode(display, DOUBLEBUF | OPENGL)

pygame.display.set_caption('04 Performance Task 1 - Marc Plarisan')
glEnable(GL_DEPTH_TEST)
gluPerspective(45, (display[0] / display[1]), 0.1, 50.0)
glTranslatef(0, 0, -5)
glScalef(0.65, 0.65, 0.65)

vertices = [
    (0, 1.5, 0),    # 0 - Top point
    (1, 0, 0),      # 1 - Right middle
    (0, 0, 1),      # 2 - Front middle
    (-1, 0, 0),     # 3 - Left middle
    (0, 0, -1),     # 4 - Back middle
    (0, -1.5, 0)    # 5 - Bottom point
]

faces = [
    # Top pyramid (4 triangular faces)
    (0, 1, 2),  # Top-Right-Front
    (0, 2, 3),  # Top-Front-Left
    (0, 3, 4),  # Top-Left-Back
    (0, 4, 1),  # Top-Back-Right

    # Bottom pyramid (4 triangular faces)
    (5, 2, 1),  # Bottom-Front-Right
    (5, 3, 2),  # Bottom-Left-Front
    (5, 4, 3),  # Bottom-Back-Left
    (5, 1, 4)   # Bottom-Right-Back
]


def draw_diamond():
    colors = [
        (1, 0, 0),    # Red
        (0, 1, 0),    # Green
        (0, 0, 1),    # Blue
        (1, 1, 0),    # Yellow
        (1, 0, 1),    # Magenta
        (0, 1, 1),    # Cyan
        (1, 0.5, 0),  # Orange
        (0.5, 0, 1)   # Purple
    ]

    glBegin(GL_TRIANGLES)
    for i, face in enumerate(faces):
        glColor3fv(colors[i])

        for vertex in face:
            glVertex3fv(vertices[vertex])
    glEnd()


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
    glRotatef(-1, -1, -1, 1)
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)

    draw_diamond()

    pygame.display.flip()
    pygame.time.wait(15)
