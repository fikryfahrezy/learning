# Lesson 3: The Ethics of Deep Learning

## Where does the data come from?

Every deep learning model relies on large amounts of data to function effectively.

Think of deep learning as building a skyscraper. The strength and shape of that building depend on the materials you use. Data is the foundation of deep learning. The quality and source of this data directly shape how well a model performs and how fair or accurate its outputs are. Where data comes from raises questions about fairness, privacy, and bias.

> A **data source** is the original location, system, or means from which you collect information for training a deep learning model.

For example, a deep learning model that helps doctors identify diseases in medical images depends on thousands of real patient scans. If the data comes from only one hospital or geographic region, the model might not perform well for people from other backgrounds.

Knowing where data comes from helps you understand the possibilities and the limitations of what deep learning can achieve.

*Select each section to explore common data sources.*

### Websites

Companies collect text, multimedia, and structured content from **websites** to train deep learning models. The content gathered includes images for tasks such as photo recognition, text for language models, and product data used to generate recommendations. Website data raises questions about consent because creators might not be aware that their content is being used.

### Social media

Posts, images, videos, and user interaction data from **social media** platforms are used to train models for content moderation, sentiment analysis, and recommendation systems. This data reveals patterns in interests and behaviors that enable AI to understand human preferences. The data might also reflect user demographics and biases, leading to unfair outcomes for underrepresented groups.

### Sensor data

**Sensor data** from cameras, microphones, GPS devices, and environmental monitors trains deep learning models. These models are used by autonomous vehicles, smart buildings, health monitoring systems, and security systems. Real-time data enables AI to respond to conditions and behaviors, but the collection methods raise concerns about privacy and consent.

### Books and text

Published **books and text**, such as news articles and research papers, train language models for tasks including translation, question answering, text generation, and reading comprehension. These data sources offer language patterns, knowledge, and writing styles that enable AI to process human language effectively. The AI ethics concern is that historical texts might contain biases that get embedded in modern AI systems.

---

Now, it’s time to practice what you’ve learned!

Activity: Identify data sources

You have just explored the main data sources that power deep learning. By understanding where data comes from and what challenges each source brings, you are better equipped to recognize the strengths and limitations of AI tools.

*Match each data source to the deep learning application it best supports. If you answer incorrectly, select Retry to try again.*

- Websites: A system that automatically sorts vacation photos
- Social media: A system that suggests people to connect with
- Sensor data: A system that adjusts building temperature based on occupancy
- Books and text: A generative AI tool that writes personalized emails

### Feedback

- Websites + A system that automatically sorts vacation photos: Correct! Website content provides the diverse image data needed for deep learning models to recognize and categorize different objects, locations, and scenes in vacation photos.
- Social media + A system that suggests people to connect with: Correct! Social media posts reveal connection patterns and shared interests, which help deep learning models identify potential relationships and suggest relevant people to connect with.
- Sensor data + A system that adjusts building temperature based on occupancy: Correct! Sensor data provides real-time information about occupancy, movement, and environmental conditions that deep learning models need to make intelligent building temperature adjustments.
- Books and text + A generative AI tool that writes personalized emails: Correct! Books and published texts provide the language patterns and writing styles that deep learning models need to generate personalized emails that sound natural and appropriate.

## Costs and environmental impact of deep learning

Training deep learning models on massive datasets requires substantial amounts of energy and computing power, which can have a significant impact on the environment. The larger the dataset and the more complex the model, the greater the environmental impact. For example, training a single large language model can use as much energy as an average household consumes in several months.

With the growing demand for deep learning, the need for sustainable practices, such as using renewable energy sources or optimizing model efficiency, is important for reducing the overall footprint of AI development.

### Environmental impact

The environmental costs of deep learning fall into two key areas:

- The immediate energy needed to run computing systems
- The long-term carbon emissions produced by this energy use

*Select each section to learn more about the environmental impacts of deep learning.*

#### Energy use

Deep learning requires substantial computing power to process large datasets. Training complex models often involves running powerful servers and graphics processing units (GPUs) nonstop for days or even weeks. The bigger the dataset from sources such as social media or websites, the more energy is needed to process it. As the use of deep learning becomes more common, its overall energy consumption continues to grow.

For example, a company training a model on millions of social media posts might run dozens of servers continuously, resulting in a significant spike in electricity usage and costs.

#### Carbon footprint

Training large AI models consumes a significant amount of electricity. When electricity is generated from coal or natural-gas plants, it produces carbon dioxide (CO₂) emissions, which means that every hour of model training contributes to an organization’s overall carbon footprint. The larger and more complex the model, the more energy it needs and the more emissions it generates. 

For example, depending on the energy source used, training a large language model on text from millions of websites might produce as much carbon dioxide as several transatlantic flights.

---

The energy use and carbon emissions associated with deep learning demonstrate that AI development has tangible environmental consequences. As these technologies continue to spread, reducing their environmental impact becomes an increasingly important focus. Are there solutions? Let’s explore more to find out.

### Potential solutions

Understanding the environmental costs of deep learning helps guide responsible technology choices and encourages efforts to minimize adverse impacts. Awareness of the impact supports the development and use of more sustainable approaches to AI.

*Read the following to learn more about potential solutions for sustainable AI.*

#### Greener AI design and optimization

Smart design choices can significantly reduce the environmental impact of deep learning. Using renewable energy sources, such as solar or wind power, to operate data centers helps reduce carbon emissions. Developing more efficient algorithms means models learn faster while using less energy. Optimizing models to work more efficiently with smaller datasets also reduces computing time and energy consumption.

For example, a company relocates its AI training to a data center powered by solar panels and enhances its algorithms to train models 50% faster, which reduces time and energy costs.

#### Efficient model selection and use

Selecting the right model size for each task reduces energy consumption. Using pretrained models already trained on large datasets means organizations don’t have to start training from scratch. Transfer learning enables smaller models to build upon existing knowledge rather than learning everything anew. Avoiding oversized models for simple tasks prevents unnecessary energy waste.

For example, instead of training a massive language model from scratch, developers use a smaller pretrained model and fine-tune it for their specific task, using 90% less energy.

### Reflect on the environmental impact of deep learning solutions

Now that you’ve learned about the environmental impact and costs of deep learning solutions, let’s explore your own perspective. Take a moment to reflect on the ecological footprint of using deep learning solutions.

Now that you’ve learned about the environmental impact and costs of deep learning solutions, let’s explore your own perspective. Take a moment to reflect on the ecological footprint of using deep learning solutions.

### What do you think?

*Enter your responses in the provided text boxes.* (Writing an answer is a good way to process your thoughts. These answers are for your use only. You have the option to download your response and save it. It will not be saved in the text boxes when you move on in the module.)

### Evaluate your thinking

Do your answers account for the following?

Expand for some more thoughts

1. What are some of the environmental or resource-related costs of training large deep learning models?

Consider that training large deep learning models requires vast amounts of computational power. Running data centers with high-energy-consuming hardware, such as GPUs, for hours or days consumes large amounts of electricity and water, and generates significant carbon emissions. The demand for deep learning models continues to grow, placing pressure on natural resources.

2. How might awareness of deep learning’s environmental impact influence the way AI is developed or used in the future?

Think about potential smarter choices. Using more efficient models, training only when necessary, or using renewable energy sources can have positive impacts. Ecologically conscious citizens suggest that organizations prioritize the design of greener AI or select smaller models that still perform well, and that developers consider the environmental impact of more sustainable and responsible practices.

---

As AI becomes more common in everyday life, understanding its environmental costs helps you think more critically about the technology around you. When using AI-powered apps or considering new AI breakthroughs, think about both the benefits and the environmental impact. At the same time, these challenges open the door to innovative career paths, from designing energy-efficient AI architectures to improving sustainable computing infrastructure. These options provide meaningful roles for individuals who contribute to the future of technology.

## Fairness in deep learning models

> **Fairness** refers to a deep learning model’s ability to produce equitable outcomes for individuals and groups by helping minimize bias.

### Background information

Next, you’ll step into the role of an AI ethics consultant tasked with helping development teams cultivate fairness in their AI systems. Bias can emerge during the AI development process, and AI systems can reflect or even amplify bias if not carefully designed and monitored. Recognizing how and where bias occurs helps address such issues in real-world applications.

Review the following content.

You've just joined IntegrityTech Solutions as their new AI ethics consultant. IntegrityTech Solutions develops AI-powered tools for the healthcare, recruitment, and financial services industries. Your role is to help the development teams understand and promote fairness in their AI systems.

Your manager has asked you to prepare a briefing on fairness for the engineering team. You'll explore what bias is, how it enters AI systems, and examine real-world examples to build expertise.

### What is bias in AI systems?

AI should treat everyone fairly, which means AI tools shouldn't deliver more favorable results to one group of people over another. When AI systems fail to meet this standard, it is referred to as bias. Bias can occur because of flaws in data, design, or human input.

*Select each card to explore different types of bias in AI systems.*

- **Algorithmic bias**: occurs when the models or decision-making processes create unfair outcomes, even when trained on representative data.
- **Data bias**: occurs when training data contains unfair patterns, stereotypes, or underrepresentation of certain groups.
- **Human bias**: occurs when human assumptions, preferences, or prejudices influence the design, training, or implementation of AI systems.

### How is unfairness programmed into AI systems?

Bias can enter AI systems at any stage in the AI development process.

*Select each marker to explore each stage of the AI development process to see where bias can enter the system.*

- **Data collection**: Historical data might reflect the exclusion of certain groups. AI systems might repeat unfair patterns if hiring records from companies exclude certain demographics.
- **Data preparation**: Choices about what data to include or exclude can introduce unfair patterns. Excluding data about certain neighborhoods or regions can cause AI systems to produce biased or skewed research results.
- **Model training**: Biased patterns already present in the data might be increased during training. AI systems might learn that certain names or characteristics are incorrectly linked with success or failure.
- **Real-world use**: Some AI systems can lead to unfair outcomes for certain groups. Facial recognition technology might not work as effectively for some skin tones as it does for others, resulting in unequal experiences.

### Real-world AI bias

As IntegrityTech Solutions' AI ethics consultant, you must understand how bias occurs in real applications.

*Select each card to explore examples of real-world bias.*

- **Healthcare**: An AI system designed to identify patients needing extra care underestimated the needs of patients from rural areas, despite having similar symptoms to those of urban patients. The system learned from historical healthcare data that reflected geographic inequalities in healthcare.
- **Recruitment**: A resume screening AI system revealed bias in favor of candidates from certain universities. The system was trained on 10 years of historical hiring data from companies that primarily recruited from elite institutions, learning to exclude applicants from state schools or community colleges.
- **Financial**: Credit scoring algorithms offered different loan terms to individuals with similar financial profiles based on factors such as zip code, postal code, or country of origin, and voice analysis from phone interviews, even though such characteristics are not relevant.

### Conclusion

Congratulations! You've completed your fairness briefing preparation to help IntegrityTech Solutions build fair AI systems. You explored different types of bias, discovered how bias can enter an AI system, and reviewed real-world examples of bias across different industries.

---

You’ve seen how bias can enter at different stages of the AI development process. Next, you’ll consider how fairness shapes AI model outcomes, and how teams can monitor and improve their systems responsibly.

### Explain the role of fairness in deep learning use cases

Now that you understand what bias is, how it enters AI systems, and have explored real-world examples of AI bias, it’s time to prepare your brief for TechForward’s engineering team. As their AI ethics consultant, you need to clearly communicate why fairness matters in deep learning models and what the team should be aware of.

*Enter your responses in the provided text boxes.* (Writing an answer is a good way to process your thoughts. These answers are for your use only. You have the option to download your response and save it. It will not be saved in the text boxes when you move on in the module.)

### Evaluate your thinking

Do your answers account for the following?

Expand for some more thoughts

1. Explain fairness and bias in deep learning.

Did you consider explaining that AI should treat everyone fairly and not give better results to one group over another? Recall the three types of bias you learned about: algorithmic bias (when mathematical models create unfair outcomes), data bias (when training data contains unfair patterns), and human bias (when human assumptions influence AI design). Did you mention that deep learning models might reflect or amplify bias if not carefully designed and monitored?

2. Describe how to monitor deep learning models for fairness and bias.

Did you consider the four stages at which bias enters AI systems? Recall that bias occurs during data collection (historical data reflecting past discrimination), data preparation (choices about what data to include or exclude), model training (algorithms amplifying biased patterns), and AI use (how and where systems are deployed). Did you emphasize that understanding how and where bias occurs helps recognize and address these issues in real-world applications?

## Robustness in deep learning

Many of today’s AI tools are used in environments where unexpected or unusual data appears. AI systems should be robust.

> **Robustness** refers to a deep learning model’s ability to maintain accurate performance when presented with new, noisy, or challenging data.

A voice recognition tool, for example, should clearly understand commands, even in the presence of background noise or different accents.

Be aware that some threats to robustness are intentional. Adversarial attacks occur when someone deliberately tries to trick AI models into making mistakes. The two main types of adversarial attacks include:

- Hacking attacks, which target models during use
- Poisoning attacks, which corrupt models during training

*Select each tab to learn more about adversarial attacks.*

### Hacking attacks

**Hacking attacks** target AI models during their use by providing specially crafted inputs designed to cause errors. These attacks exploit weaknesses in how models process information, leading to incorrect outputs. Hacking might be as subtle as adding slight, unnoticeable changes to data that cause the model to make mistakes.

For example, an attacker adds imperceptible noise to a stop sign image, causing an autonomous vehicle’s vision system to misidentify it as a speed limit sign.

### Poisoning attacks

**Poisoning attacks** occur when attackers introduce malicious or misleading data into an AI model’s training set. This manipulation might influence the model’s future calculations or behaviors, often without detection. Even small amounts of poisoned data can significantly impact the model’s reliability and accuracy.

For example, a spam filter is trained on emails with a few carefully crafted spam messages labeled as safe, which inadvertently causes the filter to allow similar messages through that are really spam.

---

Adversarial attacks come in different forms, targeting both the training and use of AI models. By learning about hacking and poisoning attacks, along with specific attack methods, you gain insight into the challenges of securing AI systems.

### How to defend against attacks

One effective defense against **adversarial attacks** is adversarial training, where models are trained on both regular and intentionally manipulated examples. Another important defense is **input validation**, which filters out unusual or potentially harmful data before it reaches the model. Combining these strategies with ongoing monitoring helps maintain the reliability of AI systems and protects against evolving threats.

## Transparency in data sources

> **Transparency** refers to a deep learning model’s degree of openness about its design, training data sources, and decision-making process.

You’ve explored various challenges in deep learning, including the origins of data, environmental costs, fairness concerns, and robustness. Transparency in data sources addresses many of these issues by requiring clear documentation about training data.

### Introduction

When AI developers are transparent about their data sources, it becomes easier to understand environmental costs, identify potential bias, and spot security risks. Knowing the origin of AI training data helps people trust the results and make informed decisions about using AI systems.

*Select START to follow the steps for facilitating transparency in AI training data.*

#### Step 1: Find the source

AI developers begin by identifying the source of their training data. They record who collected it, when it was gathered, and how it was obtained. This creates a clear trail that others can follow to understand the data’s background. Knowing the source helps developers identify potential problems and builds trust with users of the AI system.

For example, developers document whether medical images originated from a single hospital or multiple locations worldwide.

**What developers should include:**

- Collection dates and locations
- Any data transformations
- Organizations or individuals involved
- Publicly available documentation

#### Step 2: Check the quality

Developers examine their data for accuracy, completeness, and potential bias. They look for errors, missing information, or patterns that might create unfair results. They check whether the data represents the people or situations that the AI system will encounter. High-quality data leads to more reliable and fair AI systems.

**What developers should check:**

- Duplicate or missing entries
- Outliers or inconsistencies
- Whether the data is up to date
- Any potential sources of bias

#### Step 3: Share information

Developers create clear documentation that explains their data sources and any limitations. They make this information easy to understand, allowing others to review how the data was selected and used. Sharing transparent details helps others trust the process and make informed decisions. 

**What developers should include:**

- Summary of data sources and collection methods 
- Known limitations or gaps 
- Recommended uses and restrictions 
- Documentation accessible to their audience

#### Step 4: Improve data choices

Developers use what they learned from previous steps to make better data choices in future projects. They look for patterns in what worked well and what might be improved. This ongoing process helps create more reliable and fair AI systems over time. 

**What developers should do:**

- Reflect on previous challenges 
- Identify new data needs 
- Set goals for better data quality 
- Track improvements over time 

#### Summary

Transparency in data sources helps build trustworthy deep learning systems. By understanding where data originates and how to document it effectively, developers and users can minimize the impact of potential bias and security risks.


### Practice quiz

Let's check your knowledge about the concepts you just learned.

This is a 5-question quiz. You must get 80% to pass it. Don't worry though! If you aren't successful at first, you can review the content and retake the quiz as many times as needed for completion.

#### Question 1: Excluding incomplete patient records

A health research team builds a deep learning model to detect heart conditions from patient records. Before training, they remove data that seems incomplete, but this step unfairly excludes a large portion of older patients' records.

Which stage of the AI development process is most likely to introduce this bias?

- Model training
- Data preparation
- Real-world use
- Data collection

**Answer: Data preparation**

Decisions made during data cleaning or formatting can unintentionally remove valuable information, leading to biased results.

#### Question 2: Not documenting the origin of training data

A deep learning system developer doesn't document the origin of the training data or whether it has been manipulated. Reviewers raise concerns about fairness and bias in the system's results.

Which step of promoting AI training transparency does this scenario represent?

- Improving data choices
- Finding the source
- Sharing information
- Checking the quality

**Answer: Sharing information**

Communicating clearly about data fosters trust and enables others to evaluate potential risks or biases.

#### Question 3: Anticipating traffic patterns

An AI company trains a deep learning model to anticipate traffic patterns in a busy city. They collect real-time data from cameras, GPS devices, and traffic detectors, which helps the model detect trends in traffic flow and congestion.

What data source is reflected in this scenario?

- Books and text
- Social media
- Sensor data
- Websites

**Answer: Sensor data**

Information collected from cameras, GPS devices, and traffic detectors is an example of sensor data.

#### Question 4: Screening scholarship applications

A company designs an AI tool to screen scholarship applications. The team gathers application information from past winners, but most are from a single geographic region. As a result, the model tends to favor applications from that region unfairly.

Which stage of the AI development process is most likely to introduce this bias?

- Data collection
- Data preparation
- Real-world use
- Model training

**Answer: Data collection**

If teams gather data that doesn't represent all groups fairly, they might introduce bias before any analysis or system design begins.

#### Question 5: Struggling to identify people in low light

An AI image recognition system learns from photos taken mostly in bright daylight. When used in low-light conditions, it struggles to identify people from certain groups fairly.

Which stage of the AI development process is most likely to introduce this bias?

- Data preparation
- Data collection
- Model training
- Real-world use

**Answer: Model training**

The model learned patterns from a narrow set of training conditions, which resulted in uneven performance in other scenarios.

## Points to remember

### Key concepts

1 The fairness and accuracy of deep learning models depend on the quality and variety of their training data. Understanding data sources is essential to identifying potential bias.

2 Four common data sources help in the process of deep learning:

- Websites
- Social media
- Sensor data
- Books and text

3 Deep learning has environmental impacts driven by the energy use of computing systems and the carbon emissions that result over time.

4 Responsible technology choices include promoting sustainable practices:

- Greener AI design and optimization
- Efficient model selection and use

5. Deep learning is exposed to potential adversarial attacks, including:

- Hacking attacks
- Poisoning attacks

6. Promoting transparency in AI training involves four key steps:

- Find the source
- Check the quality
- Share information
- Improve data choices

---

In this lesson, you explored how the quality and variety of training data influence the fairness and accuracy of deep learning models, and why recognizing bias is important. You examined the environmental costs of AI and ways to make technology more sustainable. You also learned about risks from adversarial attacks and steps for greater transparency. You’ve finished the final lesson of this module. Next, you’ll review the module’s learning objectives, explore additional resources related to AI, and take a quiz to assess your understanding.
