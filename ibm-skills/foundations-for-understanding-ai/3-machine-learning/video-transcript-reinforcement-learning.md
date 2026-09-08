# Reinforcement learning

How does an AI system learn through reinforcement learning? Let’s find out as a kitchen robot learns to find orange juice for its owner.

Let’s begin with the agent. In this scenario, the agent is a robot with the capabilities to perceive, explore, and act in its environment.

The environment the agent needs to learn about is the kitchen.

Actions refer to the movements the robot makes, such as left, right, forward, or backward.
The state is the feedback returned after each action, including the robot’s current position and any rewards earned.

This agent learns through trial and error. The robot receives positive reinforcement for correct moves and negative reinforcement for incorrect moves, developing the best policy for reaching its goal.

Watch the robot explore randomly at first, searching everywhere for the juice. When the robot reaches the juice, it gets a reward.

After many training episodes, it discovers shortcuts and learns the optimal path.

Now let’s put the trained robot back at the start. Through reinforcement learning, the agent successfully reaches its goal much quicker by taking the shortest possible route.