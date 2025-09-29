# Marc Plarisan | BSIT701 | Computer Graphics Programming - 04 Lab 1

import pygame
from pygame.locals import *

from OpenGL.GL import *
from OpenGL.GLU import *

pygame.init()
display = (800, 600)
pygame.display.set_mode(display, DOUBLEBUF | OPENGL)

pygame.display.set_caption('04 Lab 1 - Marc Plarisan')
glEnable(GL_DEPTH_TEST)
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
    colors = [
        (1, 0, 0),  # Red
        (0, 1, 0),  # Green
        (0, 0, 1),  # Blue
        (1, 1, 0),  # Yellow
        (1, 0, 1),  # Magenta
        (0, 1, 1)   # Cyan
    ]

    glBegin(GL_TRIANGLES)

    # Hallo I am using an alternative to multiple glVertex3f() statements
    # Instead I am using a loop with the edges in a list with
    for i, face in enumerate(faces):
        face_index = i // 2
        glColor3fv(colors[face_index])

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
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)

    draw_cube()

    pygame.display.flip()
    pygame.time.wait(15)
