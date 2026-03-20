# Java-OOP-Box-Puzzle
# Box Top Side Matching Puzzle 🎲

  A console-based, strategic puzzle game developed in **Java** that simulates an 8x8 grid of manipulatable cubic boxes
  The objective is to maximize the occurrence of a specific target letter on the top sides of the boxes through tactical rolling and tool usage over 4 turns
  

  This project was developed as part of my Programming Fundamentals course and serves as a comprehensive implementation of core **Object-Oriented Programming (OOP)** principles.

## Core OOP Concepts Implemented
**Inheritance & Polymorphism:** Creating a dynamic hierarchy for different box and tool types.
**Interfaces & Abstract Classes:** Structuring the foundation for manipulatable grid objects[cite: 7].
-**Collections:** Utilizing appropriate Java Data Structures to manage the 8x8 BoxGrid efficiently.
**Exception Handling:** Custom exception classes to manage invalid moves gracefully without terminating the app.

###  Box Types
- **RegularBox** : Standard boxes that have a high chance of containing special tools.
- **UnchangingBox**: The stamped letters on its surfaces cannot be altered by tools.
- **FixedBox**: Anchored boxes that cannot be rolled, stopping any domino-effect in its tracks.

###  Special Tools
Acquired by opening boxes, these tools allow you to manipulate the grid:
- **PlusShapeStamp** / **MassRowStamp** / **MassColumnStamp**: Restamps specific patterns of boxes.
- **BoxFlipper**: Inverts a box, swapping its top and bottom sides.
- **BoxFixer**: Converts a standard box into an unmovable FixedBox.
