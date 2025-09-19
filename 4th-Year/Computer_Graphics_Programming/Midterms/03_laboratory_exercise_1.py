# Marc Plarisan | BSIT701 | Computer Graphics Programming - 03 Lab 1

import pygame
from pygame.locals import *

from OpenGL.GL import *
from OpenGL.GLU import *

pygame.init()
display = (800, 600)
pygame.display.set_mode(display, DOUBLEBUF | OPENGL)

pygame.display.set_caption('03 Lab 1 - Marc Plarisan')
gluPerspective(45, (display[0] / display[1]), 0.1, 50.0)
glTranslatef(0, 0, -5)

vertices = [
    (1, 1, 1),    # 0
    (1, 1, -1),   # 1
    (1, -1, -1),  # 2
    (1, -1, 1),   # 3
    (-1, 1, 1),   # 4
    (-1, -1, -1),  # 5
    (-1, -1, 1),  # 6
    (-1, 1, -1)   # 7
]

edges = [
    (0, 1), (1, 2), (2, 3), (3, 0),
    (4, 7), (7, 5), (5, 6), (6, 4),
    (3, 6), (0, 4), (2, 5), (1, 7)
]


def draw_cube():
    glBegin(GL_LINES)
    for edge in edges:
        for vertex in edge:
            glVertex3fv(vertices[vertex])
    glEnd()


while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            quit()
    glRotatef(1, 1, 1, 1)
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)

    draw_cube()

    pygame.display.flip()
    pygame.time.wait(15)
