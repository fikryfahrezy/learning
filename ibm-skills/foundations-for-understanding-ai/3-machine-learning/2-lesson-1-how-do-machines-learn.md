# Lesson 1: How do Machines Learn?

## Machines learn in five main ways

Streaming services suggest movies you’ll enjoy, your watch tells you your optimal heart rate for exercise, financial systems find new sources of fraud, and stock trades are made within milliseconds of market changes. Artificial intelligence is embedded in many everyday technologies, using various approaches to solve problems and provide possible outcomes based on data. Machine learning is at the core of these capabilities, enabling systems to adapt and improve.

> **Machine learning** is a subset of artificial intelligence that helps computers learn from experience. With machine learning, computers can perform tasks independently and improve as they accumulate more data.

Machine learning encompasses several models, each with a different approach and purpose. Understanding these models reveals how machine learning tools solve real-world problems, from sorting emails to interpreting medical images to personalizing online shopping.

*Select each card to learn more about the different machine learning models and how they are used.*

- **Supervised learning**: In supervised learning, a model learns from examples that already have the correct answers, called labels. The model uses these labeled examples to offer insights and make recommendations about new data.
- **Unsupervised learning**: In unsupervised learning, a model looks for patterns in unlabeled data, grouping similar items or identifying unusual data points.
- **Semi-Supervised Learning**: In semi-supervised learning, a model combines a small amount of labeled data with a large amount of unlabeled data, enabling the model to learn more accurately without requiring the labeling of all data.
- **Self-Supervised Learning**: In self-supervised learning, a model creates its own tasks by hiding parts of the data and attempting to infer what is missing, allowing the model to learn useful features without requiring manual labels.
- **Reinforcement learning**: In reinforcement learning, a model learns by attempting actions and receiving feedback in the form of rewards or penalties, and finds the best way to achieve a goal over time.

## Supervised learning

Developers train AI systems using different models depending on the type of problem they’re addressing. When developers want the AI to learn from verified answers, they often use supervised learning.

> **In supervised learning**, the model trains using labeled examples, allowing it to provide insights for new data.

Supervised learning is helpful when you want the model to learn how to do a specific job, such as recognizing pictures or understanding what someone might prefer. Because the model sees the answers while it’s learning, it gets better at choosing the correct answer later.

*Select each card to learn more about the types of problems that supervised learning helps solve.*

- **Classification Problems**: In classification problems, the model learns to categorize things into distinct groups. For example, it might examine a photo and determine whether it depicts a car or a bus. The answer is one label from a set of choices and is helpful for tasks such as recognizing faces, detecting spam emails, or reading handwriting.
- **Regression Problems**: In regression problems, the model learns to estimate numerical values. For example, it might examine information about a house and estimate its potential cost. Regression is helpful in problems when the answer is a number and not a category, such as offering insights into temperatures, prices, or test scores.

Even when training a model with clean and accurate data, the model doesn’t give a final answer with complete certainty. Instead, it provides a confidence score.

> A **confidence score** is a numerical value that indicates the model's level of certainty about its perception. For example, it might say it’s 85% confident that a photo shows a dog.

These scores help the model determine the strength of its insights and recommendations, and whether it should take action or request additional input. As the model trains on more examples, its confidence and accuracy usually improve.

### How AI classifies images using supervised learning

Watch the following video to explore how labeled examples teach AI to recognize patterns so that the AI can identify new images.

[Supervised learning_video transcript](./video-transcript-supervised-learning.md)

## Unsupervised learning

Not all machine learning tasks come with clear answers. In many cases, the goal is to explore large amounts of information and uncover the relationships between things. This type of learning helps identify patterns that aren’t immediately apparent.

> **Unsupervised learning** is a machine learning model in which the AI tool analyzes data without labeled answers or guidance, looking for patterns or groupings on its own.

Training an AI model with unlabeled data is more difficult because the model can’t make recommendations until it has structured the data itself. Unsupervised learning is helpful because it helps AI tools find hidden structures or relationships in large sets of information, even when you do not know what to look for in advance. Many industries use unsupervised learning because it helps discover trends, organize data, or identify unusual items.

Developers use clustering and anomaly detection in unsupervised machine learning. Both help AI systems make sense of large amounts of unlabeled data.

*Select each section to learn how clustering and anomaly detection help organize data.*

### Clustering

Clustering is a method that groups similar data points based on their characteristics. It helps organize information by identifying natural patterns or groups, even when the data lacks labels. 

Clustering helps with tasks such as exploring large datasets, separating customer types, or identifying trends. It reveals hidden structures that inform decisions in business, science, and technology. 

For example, an AI model might use clustering to categorize shoppers based on their purchasing behavior. A marketing team then uses those groupings to create targeted ads for each customer type. 

## Anomaly detection

Developers use anomaly detection to find data points that stand out from the rest, things that don’t follow the usual pattern. These outliers signal mistakes, security issues, or changes that need attention. 

Anomaly detection is helpful in areas such as finance, cybersecurity, and manufacturing, where identifying unusual behavior early can prevent more significant problems. 

For example, a bank might use an AI model that employs anomaly detection to identify unusual credit card charges that might indicate potential fraud.

---

Clustering and anomaly detection enable machine learning models to understand complex data without requiring labeled answers. By finding patterns on its own, AI helps make sense of complex data and discover new insights.

## How AI clusters information using unsupervised learning

Watch the following video to learn how AI discovers patterns in unlabeled data and groups images without being told the “right” answer.

[Unsupervised learning_video transcript](./video-transcript-unsupervised-learning.md)

## Semi-supervised learning

Sometimes, you have a large amount of labeled data for training an AI model, while at other times, only a small portion of your data is labeled, with the rest remaining unlabeled. This is where you encounter the concept of semi-supervised learning.

> **Semi-supervised learning** is a machine learning model that uses a small amount of labeled data, along with a larger amount of unlabeled data, to train an AI tool.

Businesses use semi-supervised learning when labeling all of the data would take too much time or money. Semi-supervised learning enables enterprises to achieve better results from their AI models, even when they have limited labeled examples.

For example, imagine a doctor looking at five medical images. Only one of them has a label showing the correct diagnosis, while the other four have no labels. A semi-supervised learning model analyzes the labeled image to identify patterns and characteristics associated with that diagnosis. Then, it compares those patterns and characteristics to the unlabeled images to begin making informed recommendations about what they might reveal.

The model uses confidence thresholds to avoid errors, only adding examples it is most certain about. Semi-supervised learning works by using a small amount of labeled data along with a large amount of unlabeled data. It reduces the time and cost of having experts label every single example. At the same time, it helps the system learn faster and with less human effort.

By combining labeled and unlabeled data, semi-supervised learning provides a practical way for developing accurate models without the high cost of manual labeling.

## Self-supervised learning

As developers train AI systems on increasingly larger datasets, it becomes more difficult and expensive to label all of them. In response, developers created new models that allow AI to learn in smarter and more efficient ways. One of the most promising models is self-supervised learning.

> **Self-supervised learning** is a method where an AI system uses parts of its own data to create tasks and learn from them without needing labeled examples.

Self-supervised learning trains AI on tasks where labeled data is limited but raw data is readily available. For example, self-supervised learning is used to train language models, where the AI learns grammar, meaning, and sentence structure just by reading large amounts of text. It’s also common in computer vision tasks, such as helping an AI learn about objects in images without needing someone to label every picture.

To make this possible, the system must create something called supervisory signals.

> A **supervisory signal** is the correct output or label provided during training that guides the model in learning the relationship between inputs and outcomes. It serves as feedback in supervised learning, enabling the model to recognize patterns and offer insights and recommendations.

Supervisory signals guide AI’s own learning by turning raw data into learning tasks.

*Read the following to learn more about pretext tasks and contrastive learning.*

### Pretext tasks

Pretext tasks are small challenges that a model creates from its data, such as anticipating missing words in a sentence or reconstructing part of an image. These tasks are not the ultimate goal, but they help the model build strong internal representations. By solving these puzzles, the model prepares itself for more complex, real-world problems. 

For example, a language model might be given a sentence with a missing word and asked to fill in the blank, learning grammar and context along the way.

### Contrastive learning

In contrastive learning, the AI learns by comparing things. It tries to tell what is similar and what is different. This sharpens its ability to recognize patterns. This approach is used in applications such as image and speech recognition.

For example, an AI might compare two photos of the same object from different angles and learn that they belong together, while pushing apart images of objects that are not the same. 

## Reinforcement learning

Some AI systems learn by receiving feedback from their actions, similar to how you might learn new skills through trial and error. This approach is called reinforcement learning.

> **Reinforcement learning** is a machine learning model in which a tool learns to make decisions by trying different actions and receiving feedback in the form of rewards or penalties.

Reinforcement learning enables AI tools to improve their performance over time without needing detailed instructions for every situation. This model is used in areas such as robotics, games, and automated decisions, where the model must adapt and respond to changing environments.

To understand how reinforcement learning works, let’s explore the components that guide the learning process.

*Select each marker to learn more about the components of reinforcement learning.*

- **Rewards**: Rewards are signals the agent receives after each choice, showing if an action was helpful or not. Earning points for a correct answer or losing points for a mistake are examples of rewards.
- **Environment**: The environment is the setting or world where the agent operates and faces challenges. The environment provides situations for the agent to respond to, such as a maze that the agent must navigate.
- **Actions**:Actions are the choices the agent makes to interact with the setting. For example, moving left or right in a game are possible actions that affect what happens next.
- ***Policy**: The policy is the set of rules or strategy the agent uses to determine its next action. The policy improves as the tool learns which actions lead to better results over time.

### How AI uses trial and error in reinforcement learning

Watch the following video to learn how an AI agent uses rewards and penalties to learn by trial and error.

[Reinforcement learning_video transcript](./video-transcript-reinforcement-learning.md)

## Practice Quiz


Let's check your knowledge about the concepts you just learned.

This is a 5-question quiz. You must get 80% to pass it. If you aren't successful at first, you can review the content and retake the quiz as many times as needed for your completion.

### Question 1: Grouping shoppers by buying patterns

A retailer loads thousands of unlabeled purchase records into an AI that groups shoppers into distinct buying patterns on its own.

Which machine learning model does this represent?

- Reinforcement learning
- Semi-supervised learning
- Supervised learning
- Unsupervised learning
- Self-supervised learning

**Answer: Unsupervised learning**

Identifying data groupings without labels is an example of unsupervised learning.

### Question 2: Sorting labeled flower and tree images

Thousands of labeled images, featuring flowers and trees, are fed into a model, allowing it to sort new images into the correct group.

Which machine learning model does this represent?

- Unsupervised learning
- Reinforcement learning
- Self-supervised learning
- Supervised learning
- Semi-supervised learning

**Answer: Supervised learning**

Supervised learning trains on examples that already carry the correct labels, enabling the model to accurately classify future images.

### Question 3: Stacking boxes for points

A warehouse robot learns to stack boxes by receiving points for stable piles and losing points when a stack falls.

Which machine learning model does this represent?

- Supervised learning
- Semi-supervised learning
- Reinforcement learning
- Unsupervised learning
- Self-supervised learning

**Answer: Reinforcement learning**

Rewarding or penalizing actions drives reinforcement learning.

### Question 4: Combining a few labeled X-rays with many unlabeled ones

Radiologists provide a few labeled X-rays that show pneumonia to a model, then they add thousands of similar but unlabeled X-rays so the model can improve its accuracy.

Which machine learning model does this represent?

- Unsupervised learning
- Supervised learning
- Reinforcement learning
- Semi-supervised learning
- Self-supervised learning

**Answer: Semi-supervised learning**

Mixing a small, labeled set with a larger, unlabeled set is a form of semi-supervised learning.

### Question 5: Hiding words to predict them

A language model hides 15% of the words in sentences it reads online, from which it trains to determine the missing words.

Which machine learning model does this represent?

- Supervised learning
- Unsupervised learning
- Self-supervised learning
- Semi-supervised learning
- Reinforcement learning

**Answer: Self-supervised learning**

Creating its own fill-in-the-blank task from raw text is an example of self-supervised learning.

## Points to remember

### Key concepts

1. Machine learning is a subset of AI that enables computers to learn from data and improve performance over time without being explicitly programmed.

2. There are five main types of machine learning: 

- Supervised learning uses labeled data to produce reliable, structured results, such as sorting emails into spam or non-spam.
- Unsupervised learning finds hidden patterns in unlabeled data, supporting creative insights such as recommending similar products.
- Semi-supervised learning combines a small, labeled set with a large unlabeled set to boost accuracy when labeling everything would be too costly.
- Self-supervised learning generates its own labels from raw data, enabling models to learn useful features at scale without requiring manual labeling. 
- Reinforcement learning helps AI tools get better at tasks through trial and error, such as improving the performance of a navigation app.

3. The data quality, type of feedback, and evaluation all play key roles in building reliable AI.

---

In this lesson, you explored the five main types of machine learning and discovered how machine learning enables computers to learn. In the next lesson, you’ll delve into the classical machine learning models used for training AI to identify patterns, offer insights, and make recommendations.
