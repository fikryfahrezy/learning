# Lesson 2: Deep Learning

## What makes learning “deep”?

You’ve learned how neural networks with a few layers recognize patterns and generate estimates. Deep learning takes this concept further by using neural networks with many more layers. This difference in depth changes everything about what these systems learn and solve.

> **Deep learning** is a type of machine learning that uses artificial neural networks with multiple layers. Deep learning identifies complex patterns by learning simple features first and then combining them into more advanced concepts.

Traditional machine learning requires people to manually select which features or patterns the system should look for. In contrast, deep learning uses neural networks with multiple layers to automatically identify useful features in the data.

Deep learning allows computers to solve problems that are too complicated for traditional programming methods. Deep learning systems use multiple layers to break down complex information into simpler components and enhance their learning capabilities.

Deep learning solves problems that previously seemed impossible. While basic neural networks might recognize simple patterns, deep learning understands complex, layered concepts. It learns step by step, building from basic features to advanced understanding.

One of the key differences is that basic neural networks might learn to recognize that a photo contains curved lines and straight edges. But a deep learning system uses those same curved lines and edges to recognize eyes, then uses eyes to recognize faces, and subsequently uses faces to identify specific individuals.

## Why does deep learning work so well?

Imagine trying to solve a giant puzzle with thousands of pieces. Each piece represents a bit of information from the world around you. Deep learning acts like a powerful sorting tool, quickly finding patterns and connections that would take much longer to spot by hand.

*Select each tab to explore key advantages of deep learning.*

### Performs automatic feature learning

Deep learning systems identify patterns in raw data and **automatically learn features**, eliminating the need for manual guidance and saving time and effort. For example, instead of being taught how to spot edges in a photo by a human, deep learning algorithms solve it on their own. This ability makes deep learning more flexible and powerful when working with complex information.

### Handles large volumes of data

Deep learning models improve as they **process larger datasets**, generating more accurate estimates over time. Unlike traditional models, deep learning continues to learn and improve with the addition of more data. For example, voice assistants perform better when they are trained on a larger number of speech examples from individuals with diverse languages, accents, dialects, and speech patterns.

### Adapts to many different problems

Deep learning can be **applied to solve a wide range of problems**, from recognizing images to understanding language, to providing insights and recommendations, and generating estimates from numerical data. You do not need to create a new system for each task; you just adjust the existing setup. This **flexibility** makes deep learning particularly valuable in fields such as healthcare, finance, and entertainment.

---

Now that you’ve explored why deep learning is effective for complex tasks, you’ll better understand how it learns automatically, handles large amounts of data, and adapts to different problems. Next, you’ll learn how these strengths apply in real-world scenarios across various industries.

## Reflect on the challenges and limitations of deep learning

Deep learning offers several key advantages, making it a powerful tool across many industries. Deep learning automatically identifies patterns in large datasets, making it useful for tasks such as recognizing faces in photos or detecting fraud in financial transactions. Deep learning’s ability to handle vast amounts of information means it can solve complex problems that would be too difficult or time-consuming for humans. For example, deep learning enables healthcare professionals to analyze medical images more quickly and accurately, improving patient care.

Think about which of these advantages stands out most to you. Is it the speed, the accuracy, or the ability to handle vast amounts of data? Consider a real-world situation from your own experience or interests where these strengths might make a difference.

### What do you think?

Now that you’ve explored deep learning advantages, you’ll reflect on how challenges or limitations might arise in real-world situations.

*Enter your responses in the provided text boxes.* (Writing an answer is a good way to process your thoughts. These answers are for your use only. You have the option to download your response and save it. It will not be saved in the text boxes when you move on in the module.)

### Evaluate your thinking

Do your answers account for the following?

Expand for some more thoughts

1. What is an advantage of deep learning that you find valuable?

You might find automatic pattern recognition particularly powerful because it enables systems to learn directly from raw data without requiring manual programming.  

2. What type of situation might it make a considerable difference in?

This might be particularly useful in areas such as medical diagnosis, where deep learning facilitates early detection by analyzing anomalies in complex images that humans might overlook.

## Challenges and limitations of deep learning

Deep learning has transformed many industries with its ability to process vast amounts of data and identify complex patterns. Several practical challenges limit its effectiveness in certain situations.

*Select each section to learn more about the challenges that limit the effectiveness of deep learning.*

### Requires large amounts of data

Deep learning models **require substantial amounts of high-quality data** to function effectively. Without sufficient data, these models cannot identify patterns or produce accurate results. Collecting and labeling this data is costly and time-consuming. Many organizations lack sufficient data for deep learning to work effectively.

For example, a healthcare company aims to use deep learning to identify rare diseases. But they struggle to collect enough patient records to train the model properly.

### Lacks clear explanations

Deep learning models often work like “black boxes”. This means it’s hard to understand how they generate their outputs. You can see the input and output in a black box, but not what happens inside. This **lack of transparency** makes it difficult for people to trust the model’s results. Should you need to explain decisions, this might be a problem.

For example, a bank that uses a deep learning model for loan approval decisions but cannot explain why applications are rejected.

### Amplifies existing biases

Deep learning models learn from the data they are presented with. If the training data contains unfair treatment of certain groups, **the model might perpetuate or even exacerbate those biases**. This might lead to unfair outcomes, especially in hiring, lending, or law enforcement. Addressing bias is necessary to facilitate fair decision making when using deep learning.

For example, a company uses deep learning to screen job applicants. They notice that candidates from certain backgrounds consistently get lower ratings, reflecting unfair biases in the training data.

### Consumes high computing resources

Training and running deep learning models **require powerful computers and substantial energy resources**. This makes deep learning expensive and might limit its use to only organizations with significant resources. High computing costs also create environmental concerns. Smaller businesses or projects with limited budgets might struggle to use deep learning effectively.

For example, a startup wants to analyze customer data using deep learning. They discover that the required hardware and cloud services cost more than their budget allows.

---

Deep learning faces several challenges that affect its practical use. These limitations mean that, despite its powerful capabilities, deep learning is not the right solution for every problem.

Now, it’s time to practice what you’ve learned!

## Activity: Identify the challenges and limitations of deep learning

In this activity, you’ll step into the role of a new product manager for a social media platform, ConnectSphere. You’ve been tasked with evaluating ConnectSphere’s existing systems to identify performance issues and address rising costs.

### Background information

ConnectSphere, a social media platform with 50 million users, relies on deep learning for personalized feeds, automatic image captions, and content moderation. Recently, performance has been inconsistent, and operational costs are rising. Your manager has asked you to review these systems to identify technical issues, enabling the team to make more informed decisions about resources and product priorities.

As you perform your evaluation, focus on these four common deep-learning limitations:  

- Requires large amounts of data
- Lacks clear explanations
- Amplifies existing biases
- Consumes high computing resources

*Complete the following activity.*

Your manager has asked you to evaluate the current systems to identify the main cause of the issues. Your analysis will help ConnectSphere make more informed decisions about resource allocation and product development priorities.

### Question 1: The feed personalization system

ConnectSphere's personalized feed system displays content that users are most likely to engage with. The system performs well for users in major cities and more common demographic groups, but provides less relevant recommendations for users in rural areas or users from underrepresented communities. User engagement metrics are significantly lower for these groups.

What challenge is ConnectSphere's feed personalization system most likely experiencing?

- Amplifies existing biases
- Requires large amounts of data
- Consumes high computing resources
- Lacks clear explanations

**Answer: Amplifies existing biases**

When a deep learning system works well for some user groups but poorly for others, it typically indicates bias in the training data. The system likely received more data from users in major cities and popular demographics, leading to biased recommendations that don't serve all users equally well.

### Question 2: The image captioning feature

ConnectSphere plans to expand its automatic caption feature to help users describe their photos more effectively, but the company currently has only 5,000 labeled image-caption pairs in its database. Early testing reveals that the captions are often inaccurate or unrelated to the images, rendering the feature unreliable.

What challenge is most likely preventing ConnectSphere's captioning feature from working effectively?

- Requires large amounts of data
- Amplifies existing biases
- Consumes high computing resources
- Lacks clear explanations

**Answer: Requires large amounts of data**

Deep learning models for image captioning typically need thousands or millions of labeled examples to generate accurate captions. With only 5,000 image-caption pairs, ConnectSphere lacks sufficient training data for the model to learn effective patterns.

### Question 3: The content moderation system

ConnectSphere's deep learning system automatically removes posts that violate community guidelines. But when users appeal these decisions, the customer service team struggles to explain how the system determined which posts to remove. This has led to user complaints and made it difficult to improve the accuracy of the moderation system.

What challenge is ConnectSphere's content moderation system demonstrating?

- Lacks clear explanations
- Consumes high computing resources
- Amplifies existing biases
- Requires large amounts of data

**Answer: Lacks clear explanations**

While the system effectively identifies policy violations, it can't provide clear explanations for its decisions, making it difficult for customer service to assist users in understanding the decisions or for engineers to improve the system.

### Question 4: The technology budget

ConnectSphere wants to improve all its deep learning features, but its monthly technology budget has already reached $200,000. The engineering team estimates that training more advanced models would triple this cost and require six months of continuous processing using specialized hardware.

What challenge is limiting ConnectSphere's ability to enhance its deep learning systems?

- Consumes high computing resources
- Amplifies existing biases
- Requires large amounts of data
- Lacks clear explanations

**Answer: Consumes high computing resources**

The $200,000 monthly bill and the potential tripling of costs demonstrate the high computing resource demands that limit the implementation of deep learning.

### Conclusion

Congratulations! You've evaluated ConnectSphere's deep learning systems and explored challenges that limit their effectiveness. By working through real-world scenarios, including feed personalization, caption generation, and content moderation, you've learned to recognize common limitations, such as data requirements, lack of explainability, bias amplification, and high computational demands.

## Deep learning in action

Deep learning is a valuable tool for solving complex problems. Deep learning systems work in the background of apps you use daily, from translating text between languages to recognizing objects in photos. These systems excel at identifying patterns in large datasets, making them particularly well-suited for tasks involving images, speech, and text.

The following examples illustrate how deep learning operates in real-world scenarios and what makes it effective for addressing such challenges.

*Read the following to learn more about deep learning in your everyday life.*

### Language translation

Deep learning analyzes patterns in millions of translated texts to understand the relationships between different languages. This ability allows it to translate speech or text in real time, even for sentences in complex languages.

### Recommendation systems

Deep learning analyzes your previous choices and behavior patterns to generate recommendations for you. It processes millions of user preferences to suggest movies, music, products, or content that matches your interests.

### Self-driving cars

Deep learning processes information from multiple sensors, such as cameras and radar, to interpret everything happening around the vehicle. It recognizes objects, estimates their movements, and offers real-time insight to support driving decisions.

### Medical diagnoses

Deep learning analyzes medical data, including X-rays, blood tests, and patient symptoms, to identify patterns that might indicate specific conditions or diseases. Deep learning rapidly processes vast amounts of medical information, enabling doctors to make more accurate diagnoses.

---

You’ve explored how deep learning drives innovation in translation, image recognition, autonomous vehicles, and medical diagnoses, demonstrating the strengths and limitations of deep learning across different industries. As you continue, consider how these technologies might evolve and the challenges that might shape future solutions.

## Points to remember

### Key concepts

1. Deep learning presents three key advantages: 

- Performs automatic feature learning 
- Handles large volumes of data 
- Adapts to many different problems 

2. Despite the advantages, four main challenges limit the effectiveness of deep learning: 

- Requires large amounts of data 
- Lacks clear explanations 
- Amplifies existing biases 
- Consumes high computing resources 

3. Deep learning drives real-world impact by powering advanced solutions in four key areas: 

- Language translation 
- Recommendation systems 
- Self-driving cars 
- Medical diagnoses 

---

In this lesson, you learned about the concept of deep learning and how additional layers allow for more advanced AI capabilities. In the next lesson, you’ll explore the sources of data used in deep learning and why it’s important to check AI outputs to prevent them from reproducing or amplifying existing biases.
