# Lesson 1: Introduction to Neural Networks

## From simple rules to deep learning

Think about how computers have changed, from following strict rules based on human input to generating new and unique insights that support humans in making decisions. Early computers were limited to performing only the tasks programmers instructed them to do. Today’s AI systems learn from examples and adapt to new situations.  

Watch the following video to explore how AI has evolved from simple rule-based systems to smart technologies that power your phone, make recommendations, and even translate languages in real time.

[From if-then to intelligence_video_transcript.pdf](./video-transcript-from-if-then-to-intelligence-video-transcript.md)

### Knowledge check

Let’s check your knowledge about the concepts you just learned.

The video explains a major problem with early rule-based computer systems that led to the development of machine learning. What was the main limitation of early if-then rule systems that machine learning solved?

Rule-based systems required programmers to think ahead for every possible situation, which became overwhelming. Machine learning solved this by enabling systems to learn patterns from data.

## How a neural network works

Neural networks are a core technology in artificial intelligence, designed to process information in a way that mimics certain aspects of how the human brain organizes data.

> A **neural network** is a computational system composed of layers of interconnected processing units that learn to recognize patterns and perform calculations by analyzing large datasets.

Neural networks enable computers to solve complex problems, such as identifying objects in images or translating languages, by learning from examples rather than following step-by-step instructions. This approach sets neural networks apart from traditional computing methods, which rely on explicit programming for each task.

For example, a neural network learns to identify fraudulent credit card transactions by analyzing thousands of past purchases and identifying patterns that signal unusual activity.

To understand how neural networks operate, it is helpful to observe how the components connect and interact, and how information is transformed as it passes through the system.

*Select each marker to learn more about the function of each layer and how neurons connect.*

### Input layer

The **input layer** receives information, or data, such as numbers, words, or images, and prepares the data for the other layers to process by breaking it down into numerical values. For example, a photo app might prepare the pixels of an image in this layer.

### Hidden layer

**Hidden layers** detect patterns or details in the data by combining and transforming the inputs into usable information. The hidden layers support the network’s learning process by detecting edges, colors, and shapes in a photo, enabling it to identify what an image depicts.

### Output layer

The **output layer** produces a probability score, or result, such as a label, after the data is processed. For example, it might make an output indicating whether an image is a tree, a house, or a car.

---

Now that you’ve explored how information flows through the layers of a neural network, let’s learn more about how this design originated.

## Inspired by the human brain

Did you know your brain is amazing at recognizing patterns? You can identify a friend’s face across a crowded hallway or recognize your teacher’s voice even when others in the classroom are talking. Scientists sought to make computers as intelligent as human brains, so they studied how brains function and attempted to replicate the most effective aspects.

Artificial neural networks are computer programs that work a bit like your brain. They’re not exactly the same, but the AI tools you use daily borrowed inspiration from how your brain cells talk to each other.

*Select each tab to learn more about how artificial neural networks are modeled after human brain structure and function.*

### Neurons and nodes

Your brain is made of special cells called **neurons**. These brain cells receive messages from many other cells simultaneously. A brain cell only sends notifications when it receives enough signals to reach a “trigger point”. 

Computer neural networks work similarly. Neural networks have parts called **nodes** that function like brain cells. These computer nodes collect information from many sources. Like brain cells, they only send out a signal when they receive enough input. This approach helps brains and computers filter out irrelevant information, focusing only on significant patterns. 

For example, when you look at the number “7” written by hand, neurons in your brain collect signals from your eyes. They only get excited when they receive enough clues that say, “This looks like a seven”. Computer networks do the same thing. The nodes examine the pixels in a picture and only become excited when they detect enough clues that spell out the number seven. 

### Synapses and weights

Brain cells connect through bridges called **synapses**. These connections get stronger when you practice something, such as speaking a new language. When you don’t use a connection, it becomes weaker. This is how your brain learns.

Computer neural networks copy this idea using a concept called **weights**. These weights determine the strength of connections between different parts of the network. When the computer performs a task and improves, the weights adjust to strengthen the most effective connections.

For example, when an email app learns to detect spam, it begins by making guesses. Each time it gets an answer right or wrong, it adjusts its weights. The connections that help identify spam become stronger with practice, much like the brain creates pathways when you practice speaking a new language.

---

Learning how computers mimic the human brain helps explain why AI is effective at recognizing images, understanding speech, and generating outputs that support informed decision making. Just like your brain gets better at riding a bike with practice, artificial neural networks get better by practicing with many examples.

But there are significant differences, too. Your brain learns new things quickly and with minimal energy expenditure. Computer networks require numerous examples and a lot of power to learn the same concepts. Understanding how AI works and what it can and can’t do will help you make better and more informed choices about using these tools.

## Traversing a neural network

You’ve probably used AI tools that transform words into images, translate languages, or recognize objects in photos. But have you ever wondered what happens inside these systems when they process your request?  

Watch this video to follow Riley as she uses AI to create a marketing image, and discover how neural networks transform simple text prompts into complex outputs through input layers, hidden layers, and output layers.

Video transcript:

[What happens inside a neural network_video_transcript](./video-transcript-what-happens-inside-a-neural-network.md)

### Knowledge check

Let’s check your knowledge about the concepts you just learned.

The video illustrates how a neural network transforms Riley’s text prompt into an image. What is the role of the hidden layers in the neural network when transforming the prompt into an image?

Hidden layers are where the network processes data step by step through artificial neurons and activation functions to detect patterns and solve problems.

## Trial and error in the learning cycle

Neural networks learn the same way you do by making mistakes and improving. You probably wobbled and fell when you first tried to ride a bike. But each mistake taught you something useful, and you improved with practice. Neural networks work the same way. They make guesses, check whether they’re right, learn from their mistakes, and try again.

### Introduction

Let’s break down how this trial-and-error learning cycle works in neural networks. They follow four key steps to improve with each attempt.

*Select START to explore how trial and error drives the learning cycle in neural networks.*

#### Make an estimation

First, you provide the neural network with new data, such as an image of a handwritten number. The network uses its current knowledge to determine, or **estimate**, what the image represents.

Initially, these estimates might be inaccurate. It might receive one number but identify it as something completely different. This happens because the network starts with limited knowledge. The network needs to generate an initial estimate to learn whether it got the answer right or wrong.

#### Evaluate the estimate

Next, the system **evaluates** its estimate and compares it to the correct answer. This comparison indicates whether the network made an error or provided the correct answer.

This step works like checking your own math homework against an answer key. The network reviews what it generated and compares it to the correct answer to determine whether it was right.

#### Learn from mistakes

Next, the system calculates the error in the determination. It determines whether the mistake was significant or simply a minor error.

The network **learns from mistakes**. Significant errors indicate that the network needs major changes, while small errors suggest it is getting close and only requires minor adjustments. This measurement indicates how much the model needs to improve.

#### Update the calculation

Finally, the network uses the measurement of mistakes to improve its internal processing. It **updates the calculations** to produce more accurate outputs next time.

This process works like adjusting your balance when learning to ride a bike. Each wobble teaches you how to stay upright better. The network repeats this cycle to continue improving its accuracy.

---

The power of this trial-and-error approach is that neural networks learn from vast amounts of data and continually improve their performance over time, much like humans do through practice and experience.

Now, it’s time to practice what you’ve learned!

## Activity: Identify how a neural network learns from data


In this activity, you’ll step into the role of an AI trainer tasked with guiding a neural network through the learning cycle.

### Background information

Every neural network starts with raw input and gradually improves through trial and error. Your team at PhotoSort Pro is training a neural network to automatically categorize vacation photos. The network relies on processing thousands of example images, adjusting its internal connections with each attempt. As you guide the network’s training, focus on the following:

- Nodes and weights
- Learning through a cycle of trial and error

*Complete the following activity.*

You're the new AI trainer for a product development group at SnappySort Pro, a company developing smart photo organization software for home users. Your role is to train a neural network to automatically sort vacation photos into categories such as beach, mountains, city, and food.

Before the neural network can organize millions of photos for users, the AI must learn to recognize these different subjects in images. You'll guide the rest of the team through the learning process, explaining how it works and how it improves the accuracy of photo categorization.

Before the neural network AI training begins, review the key components of SnappySort Pro's neural network. The diagram shows data flowing through the input layers, hidden layers, and output layers of the network.

### Question 1: Ordering the learning cycle

SnappySort Pro's neural network learns through four key steps to correctly categorize an image. Place the following neural network learning steps in the correct order:

1. The network looks at a beach photo and determines it's a "mountain".
2. The network compares its decision to the correct answer, "beach".
3. The network calculates that its determination is incorrect.
4. The network adjusts its weights to more accurately identify beaches.

**Correct!** The network follows this exact sequence: making a determination, scoring the determination against the correct answer, learning from its mistakes, and updating its calculations.

### Question 2: How nodes process signals

Inside SnappySort Pro, the neural network nodes and weights work together to process photos.

What happens when a node in the hidden layer receives signals from multiple input nodes?

- The node collects signals and immediately passes each signal to the next layer.
- The node collects signals and randomly selects some to pass forward, while ignoring others.
- The node collects signals and then stores them in memory for future reference.
- The node collects signals and sends out its own signal when it has enough input.

**Answer: The node collects signals and sends out its own signal when it has enough input.**

In the same manner as neurons in the brain, nodes collect multiple inputs and only send a signal when they receive enough combined input to reach their threshold.

### Question 3: How weights adjust after a mistake

After being presented with an image of a city skyline, SnappySort Pro's AI incorrectly identified it as "food". Just as your brain adjusts when you deliberately practice free throws in basketball, the network needs to adjust its weights to learn from this mistake.

What happens to the weights in SnappySort Pro's network after this incorrect identification?

- The network creates new weights and deletes the old ones.
- All weights in the network get stronger after each identification attempt.
- Weights that were active during the identification process get weaker.
- Weights that were active during the identification process get stronger.

**Answer: Weights that were active during the identification process get weaker.**

Just as synapses in your brain weaken when they lead to mistakes, the weights that were active when SnappySort Pro incorrectly identified "food" will also get weaker.

### Question 4: Why the network needs many learning cycles

SnappySort Pro has now completed 1,000 learning cycles. Each cycle followed the same four steps: making a determination, scoring it, learning from its mistakes, and updating calculations.

Why does the network require multiple repetitions of this process?

- Each learning cycle makes minor adjustments to weights to increase the accuracy.
- Each learning cycle can process only one image category at a time.
- Each learning cycle adjusts only a small, random portion of the network's weights.
- Each learning cycle trains a different layer of the network, working through the network sequentially.

**Answer: Each learning cycle makes minor adjustments to weights to increase the accuracy.**

Just like learning to ride a bike through practice, neural networks improve gradually. Each learning cycle makes minor adjustments to the weights, and thousands of these small improvements create a network that accurately categorizes images.

### Conclusion

Congratulations! You've explored SnappySort Pro's neural network learning process. You examined how neural networks learn from data by reviewing the role each layer plays in processing data, including the four-step learning process, how nodes collect signals and activate like brain neurons, how weights are adjusted to improve insights, and why neural networks need many learning cycles to become accurate.

## Points to remember

### Key concepts

1. Early computers followed fixed if-then rules, but programmers had to anticipate every possible situation in advance, which became overwhelming for complex real-world problems.

2. Neural networks are computational systems made up of layers that learn to recognize patterns by analyzing large amounts of data instead of following pre-written rules.

3. Neural networks have three main components that work together: 

- Input layer 
- Hidden layer 
- Output layer 

4. The human brain inspires neural networks in two ways: 

- Neurons and nodes 
- Synapses and weights 

5. Neural networks learn through a trial-and-error process with four steps: 

- Step 1: Make an estimation 
- Step 2: Evaluate the estimate 
- Step 3: Learn from mistakes 
- Step 4: Update the calculation

---

In this lesson, you learned how neural networks evolved from simple rule-based systems to powerful learning tools inspired by the human brain. In the next lesson, you’ll explore deep learning and how adding more layers creates even more sophisticated AI capabilities.
