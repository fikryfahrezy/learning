# Lesson 3: Machine Learning in AI

## Machine learning, neural networks, and AI

Classical machine learning models laid the foundation for training AI systems. As computing power increased and massive datasets became available, AI researchers created neural networks to address increasingly complex problems by automatically adapting and improving.

> A **neural network** is a computer system composed of layers of interconnected units, known as nodes, designed to identify patterns in data and make recommendations or decisions based on that data.

A neural network uses electronic circuitry inspired by the way neurons communicate in the human brain. Neural networks power many of the AI tools you use and interact with every day, from voice assistants to image recognition apps.  Neural networks are a key technology behind many modern AI tools, helping them handle complex tasks such as recognizing speech or sorting images.

## AI and learning types

Neural networks are trained using different machine learning models, depending on the kind of data and task. While you’ve already explored these learning models, you should understand how they apply to neural networks.

*Read the following to learn how neural networks are trained using different machine learning models.*

### Supervised learning

Neural networks trained with **supervised learning** are provided with examples that include both the input and the correct answer. During training, the network adjusts itself to match its perceptions to these labels more accurately over time. The more examples it sees, the better it gets, so it works well with large, labeled datasets such as recognizing handwriting or identifying animals in photos.

For example, a neural network might learn to tell if an X-ray shows signs of pneumonia by studying thousands of labeled medical images.

### Unsupervised learning

When using **unsupervised learning**, engineers give neural networks data without any labels. The networks use layers to examine the data in steps, with each layer identifying key features or details and passing them along to the next layer. These features might include shapes in images, sentence structure in text, or behavior patterns in large datasets. The network builds a deeper understanding of the data over time, even without knowing the correct answer.

For example, scientists use a neural network with unsupervised learning to group different types of galaxies based on telescope images. The model learns to sort them by shape, brightness, or color, without being told what each galaxy is.

### Semi-supervised learning

In **semi-supervised learning**, a neural network starts with a small amount of labeled data and a much larger set of unlabeled data. Neural networks can generate pseudo labels, or confident guesses, for unlabeled data and then continue training using those guesses. Their layered structure allows them to learn complex patterns even from limited labeled examples, making them effective when labeled data is expensive or complicated to obtain.

For example, imagine building an AI model to detect rare genetic diseases in DNA sequences. Researchers might have 500 expert-labeled sequences and hundreds of thousands of unlabeled ones.

### Self-supervised learning

**Self-supervised learning** happens when a neural network creates its own learning tasks. Neural networks use their layered structure to learn increasingly abstract features from raw data without any labels. Early layers detect simple patterns such as edges in images or word fragments in text. Deeper layers combine these into more complex features, including objects or sentence meaning. 

The network trains itself by solving small tasks it creates from the data, such as perceiving missing parts or matching related inputs. This process enables the network to develop a robust internal understanding of the data, which can later be refined for other tasks, even when labeled examples are limited.

For example, large language models such as chatbots are trained by suggesting missing words in millions of sentences. That’s how these models learn grammar, meaning, and tone.

### Reinforcement learning

In **reinforcement learning**, a neural network learns by trying actions, receiving rewards or penalties, and using that feedback to improve its choices over time. Neural networks act as decision makers, or agents, that learn how to reach goals by updating their internal strategy, known as a policy. With each attempt, the network gets better at choosing actions that lead to higher rewards.

For example, a robot learns to walk by trying different steps. If it stays upright longer, it gets a reward. Over time, the network learns which movements help it balance and walk better.

---

Neural networks are flexible and powerful, but they require training to function effectively. Each learning model offers a different way for the network to adjust, improve, and make sense of complex information. By understanding how these models apply to neural networks, you see how modern AI systems learn to solve real-world problems.

### Knowledge check

Let’s check your knowledge about the concepts you just learned.

///

#### Question 1

Which type of machine learning is best suited for a task where the dataset includes both input data and the correct answers for each example?

- Unsupervised learning
- Supervised learning
- Semi-supervised learning
- Self-supervised learning
- Reinforcement learning

**Answer: Supervised learning**

This method uses labeled data to train models for classification.

#### Question 2

A company wants to group customers based on their purchasing patterns, but does not have predefined labels for each group.

Which machine learning approach should the company use?

- Unsupervised learning
- Supervised learning
- Semi-supervised learning
- Self-supervised learning
- Reinforcement learning

**Answer: Unsupervised learning**

Unsupervised learning is used to find patterns or groupings in unlabeled data. 

## How each learning type impacts AI output

Now that you’ve explored the ways AI learns, it’s time to understand why this matters in real-world systems. AI models such as large language models, chatbots, image generators, and recommendation engines are built using combinations of learning types. Each plays a role in shaping how the system works and what kind of output it produces. The learning types for AI systems influence how they make decisions, what they create, and how they improve their capabilities.

*Select each tab to learn how different learning types uniquely affect AI outputs.*

### Structure

AI tools generate **structured outputs** that follow a consistent format, such as summaries with labeled sections, question-and-answer pairs, tables, or formatted code. AI tools produce these outputs when they’ve been trained to recognize and reproduce structure from their training data.

Supervised learning teaches the model what correct responses should be, resulting in more predictable and organized outcomes. Semi-supervised learning helps when labeled data is limited, allowing the model to generalize and apply consistent formatting with minimal guidance.  

Structured outputs are beneficial when accuracy, clarity, or repeatability are important. They make AI-generated content easier to read, verify, or use in real-world situations.

### Creativity

**Creativity** involves generating something new, such as a poem, a design concept, an unusual image, or a clever response in a conversation. AI systems produce creative outputs by learning to explore patterns and blend ideas beyond what you explicitly teach them.

Unsupervised learning supports creativity by revealing hidden relationships in large datasets without following strict labels or instructions. Instead, the AI explores how information relates to other data, helping it to combine ideas in unexpected ways. 

Self-supervised learning also plays a key role. It trains AI to identify how parts of text or images fit together by solving its own puzzles, such as anticipating missing words or aligning captions with pictures. This process builds a deep and flexible model of context and meaning, which helps the AI improvise and invent new ideas. 

Creative outputs are valuable when originality, emotional expression, or innovation is the goal. This includes writing stories, creating visual art, crafting marketing copy, and generating new ideas in response to open-ended prompts. 

### Improvement

**Improvement** refers to an AI system’s ability to get better over time. This means producing more accurate, efficient, or helpful responses; the more it learns from experience, the more it improves.

Reinforcement learning directly supports improvement. The AI receives feedback from its environment and uses it to adjust its future behavior. Each time it makes a decision, it receives a reward or a penalty, which helps it determine which actions lead to better outcomes. Over time, this feedback loop enables the AI to make more informed choices and refine its strategies. 

Supervised learning also contributes to improved outputs by allowing the AI to train on large sets of labeled examples. As more labeled data becomes available, the model becomes more accurate in making recommendations or decisions. This steady exposure to clear input and output pairs strengthens the model’s performance. 

Together, these learning types enable modern AI systems to evolve. They help the model move from “just okay” results to highly refined and effective outputs for tasks such as personalized recommendations, route planning, or content moderation. 

---

Understanding how different learning types shape AI outputs helps explain why modern AI systems achieve significant results. From generating highly structured responses to producing creative content or improving over time, each capability reflects a specific kind of training.

## Activity: Explain how machine learning types impact AI outputs

AI tools use different types of learning to process data and make recommendations. Understanding these learning types helps you see how AI creates outputs and solves real-world problems.

*Match each learning type to its main impact based on the situation. If you answer incorrectly, select Retry to try again.*

**Structure**

- An AI writes well-formatted reports after being trained on hundreds of examples with known inputs and outputs.
- A customer support bot gives consistent, accurate answers because it was trained on labeled conversations.

**Answer: Structure**

Structure comes from models trained with supervised learning, using labels that teach the AI on exactly what kind of answer to provide.

**Creativity**

- A design assistant generates unique logo ideas after learning visual patterns in existing brand assets.
- A music generator creates new songs by identifying patterns in thousands of unlabeled tracks.

**Answer: Creativity**

Creative outputs emerge when AI learns from unlabeled data and forms its own patterns or representations using unsupervised and self-supervised learning.

**Improvement**

- A robot vacuum adjusts its cleaning route over time to cover a larger area more efficiently.
- A game-playing AI gets better at winning by testing different moves and learning which ones work.

**Answer: Improvement**

Improved outputs come from trial-and-error learning, where the AI changes its behavior based on feedback. 

## Points to remember

### Key concepts

1. A neural network is a computer system of layered interconnected nodes that finds patterns in data to generate insights, recommendations, or decisions.

2. Depending on the data type and task, neural networks are trained using the following machine learning models: 

- Supervised learning uses labeled data to produce reliable, structured results. 
- Unsupervised learning uses data without any labels to find key features. 
- Semi-supervised learning uses small sets of labeled data and larger sets of unlabeled data to generate pseudo labels and continue training. 
- Self-supervised learning uses the model’s own layered structure to learn abstract features from raw, unlabeled data. 
- Reinforcement learning uses different actions and learning from feedback in the form of rewards or penalties. 

3. Each learning type affects AI output structure, creativity, and improvement differently.

---

In this lesson, you explored neural networks and how AI learning types apply to different datasets and tasks. You also compared how learning affects AI’s ability to arrive at conclusions, innovate, and improve. In the next lesson, you’ll explore how AI engineers, developers, and users address false results and improve accuracy.
