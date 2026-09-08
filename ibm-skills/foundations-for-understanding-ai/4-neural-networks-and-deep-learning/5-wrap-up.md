# Wrap-Up

## Learning objectives

After completing this module, you should be able to:

- Identify how a neural network learns from data
- Identify the challenges and limitations of deep learning
- Explain the role of fairness and bias in deep learning models
- Determine potential sources of bias in deep learning

## Explore more resources!

To explore concepts covered in this module in more depth, check out these resources:

- [Neural Networks Explained in 5 minutes](https://www.youtube.com/watch?v=jmmW0F0biz0) – In this video, Martin Keen, an IBM Cloud master inventor, explains some important points about neural networks.
- [What is a neural network?](https://www.ibm.com/think/topics/neural-networks) – This IBM article explains how neural networks mimic the brain and learn from data, including intuitive examples like decision making and surfing scenarios.
- [The 5 biggest AI adoption challenges for 2025](https://www.ibm.com/think/insights/ai-adoption-challenges) – This IBM article highlights real-world barriers to deep learning adoption, including bias, data limitations, and ethical concerns.
- [What is AI bias?](https://www.ibm.com/think/topics/ai-bias) – This IBM article explains types of bias (algorithmic, data, exclusion, and stereotyping) and how they affect deep learning outcomes.
- [Machine learning and bias](https://developer.ibm.com/articles/machine-learning-and-bias/) – This IBM article provides examples of bias in real-world systems and explains how they arise from data and model design.

## Show what you know!

It's time to show what you know!

The following assessment requires you to apply your knowledge of the concepts and skills in this module. Studies show that the more you apply your knowledge in different contexts, the better you retain that information.

There are 15 questions. You must achieve a score of 80% to pass. Don't worry though! If you aren't successful at first, you can review the course content and retake the quiz as many times as needed for your course completion.

#### Question 1: Forecasting product demand without enough data

A startup wants to use a deep learning tool to forecast product demand. But, because the company is new, it hasn't collected enough information about user behavior to train the model effectively.

What challenge of deep learning might prevent the tool from achieving its goal?

- Amplifies existing biases
- Consumes high computing resources
- Lacks clear explanations
- Requires large amounts of data

**Answer: Requires large amounts of data**

Deep learning models improve after processing large datasets, enabling them to generate more accurate forecasts over time.

#### Question 2: Personalizing a homepage from frequent shoppers

An online retail store customizes its homepage for each user based on shopping habits, browsing history, and real-time behavior. But the recommendation system was primarily trained on data from frequent shoppers in major cities.

Which type of bias is most likely affecting this AI system?

- Data bias
- Algorithmic bias
- Human bias

**Answer: Data bias**

Deep learning systems analyze users' past behavior to anticipate users' needs and make valuable recommendations.

#### Question 3: Traffic ticketing deployed in certain neighborhoods

A city implements an AI-powered traffic ticketing system. Even though the team used balanced data, they installed the system only in certain neighborhoods, which resulted in more violations being recorded for those residents.

Which stage of the AI development process is most likely to introduce this bias?

- Real-world use
- Data collection
- Model training
- Data preparation

**Answer: Real-world use**

Even a well-trained, fair model can lead to unfair outcomes if it's deployed in a way that disproportionately impacts one group over others.

#### Question 4: Training a content moderation tool only in English

A team develops a content moderation tool to identify harmful posts. To save time, the team trains the tool only on English-language examples, which leads the tool to miss harmful content in other languages.

Which type of bias is most likely affecting this AI system?

- Data bias
- Human bias
- Algorithmic bias

**Answer: Human bias**

The bias originates from the team's decision to restrict the scope of training examples, rather than from patterns or calculations in existing data.

#### Question 5: Forecasting learner performance from historical records

An educational institution is implementing a deep learning tool to generate forecasts about learner performance and identify students at risk. The system must analyze years of historical academic records from thousands of former students.

What capability of deep learning makes it particularly effective for this task?

- Performs automatic feature learning
- Handles large volumes of data
- Adapts to many different problems
- Detects and avoids existing biases

**Answer: Handles large volumes of data**

Deep learning is capable of processing large amounts of data to obtain a polished output.

#### Question 6: Comparing an estimation to the correct answer

In a neural network, the model provides an estimation based on input data. The model compares the result to the correct answer to measure how far off it was.

Which step of the learning cycle does this scenario describe?

- Evaluate the estimate
- Learn from mistakes
- Update the calculation
- Make an estimation

**Answer: Evaluate the estimate**

After estimating a possible answer, the network evaluates how close it was to the correct result.

#### Question 7: Producing an initial guess from training data

When a neural network is presented with training data, it produces initial guesses based on its current configuration.

Which step of the learning cycle does this scenario describe?

- Evaluate the estimate
- Learn from mistakes
- Update the calculation
- Make an estimation

**Answer: Make an estimation**

The first step is making an educated guess based on what the network has learned so far.

#### Question 8: Spam detection with if-then rules

A team programmed a system to detect email spam using fixed if-then rules. The system missed many spam emails with unfamiliar words.

How might a neural network be more effective in this case?

- It's trained to detect all possible spam emails.
- Its rules involve more possible scenarios.
- Its layers work together to find patterns in input.
- It recognizes a broader number of words.

**Answer: Its layers work together to find patterns in input.**

Neural networks recognize patterns in data rather than focusing on a limited set of predefined rules.

#### Question 9: Reusing a pretrained model from a different specialty

An imaging team selects a pretrained model to conserve energy and resources. But the model was initially trained on data from a medical specialty other than the one the clinic plans to use it for.

How might this data source introduce bias into the model?

- The model might perform poorly in diagnosing unknown diseases.
- The model might not be able to analyze enormous amounts of data.
- The model might confuse the results from different age groups.
- The model might not work well for people of different backgrounds.

**Answer: The model might perform poorly in diagnosing unknown diseases.**

Training data from a different medical specialty might cause the model to perform poorly when diagnosing conditions it was never trained to recognize.

#### Question 10: A loan-approval scoring formula weighted by zip code

A loan-approval system's scoring formula gives disproportionate weight to applicants' zip codes. Among applicants with similar credit scores, those from specific zip codes receive lower scores and are more likely to be rejected for loans than applicants from other neighborhoods.

Which type of bias is most likely affecting this AI system?

- Human bias
- Algorithmic bias
- Data bias

**Answer: Algorithmic bias**

The way the scoring formula processes inputs creates an imbalance, leading to unfair outcomes.

#### Question 11: Handling complex medical images

A research team is exploring deep learning techniques for medical diagnosis.

What capability of deep learning allows it to handle complex medical images more effectively than traditional methods?

- Performs automatic feature learning
- Handles large volumes of data
- Provides clear explanations for its decisions
- Adapts to many different problems

**Answer: Performs automatic feature learning**

Deep learning automatically learns features from raw data, eliminating the need for manual guidance and accelerating the diagnosis process.

#### Question 12: Flagging signs of illness in chest X-rays

A medical center is using a deep learning model to analyze chest X-rays and flag signs of illness.

What challenge of deep learning might prevent doctors from understanding and trusting the model's decisions?

- Requires large amounts of data
- Consumes high computing resources
- Amplifies existing biases
- Lacks clear explanations

**Answer: Lacks clear explanations**

Deep learning models offer more accurate recommendations or insights, but they often fail to provide transparent explanations. This lack of clarity can be a significant concern in high-stakes fields such as healthcare.

#### Question 13: Detecting rare diseases from a single population group

A healthcare organization is developing a deep learning model to detect rare diseases in patients. But the model is trained mostly on data from a single population group.

What challenge of deep learning might result in an erroneous diagnosis of a condition in a patient from a different population group?

- Consumes high computing resources
- Lacks clear explanations
- Amplifies existing biases
- Requires large amounts of data

**Answer: Amplifies existing biases**

If the training data contains incomplete information about certain groups, it might lead to inappropriate treatment of patients.

#### Question 14: Diagnosing diseases using only local-region data

A hospital uses a deep learning model to aid doctors in diagnosing diseases from medical images. The hospital is only using data from the local region.

How might this data source introduce bias into the model?

- The model might confuse the results from different age groups.
- The model might perform poorly in diagnosing unknown diseases.
- The model might not work well for people of different backgrounds.
- The model might not be able to analyze enormous amounts of data.

**Answer: The model might not work well for people of different backgrounds.**

A lack of variety in the data source might lead to the model being less accurate for underrepresented groups.

#### Question 15: Improving shipping cost estimations over time

A team trains a neural network to calculate shipping costs based on thousands of examples of past deliveries. The first estimations are often wrong, but after weighing the errors and refreshing its configuration, the network improves its next estimations.

What step of the learning cycle helps the network get better?

- Learn from mistakes
- Evaluate the estimate
- Update the calculation
- Make an estimation

**Answer: Update the calculation**

The neural network improves by updating its internal calculations based on input from earlier estimations.

## Module completion

### Congratulations!

Confirm that module completion shows as **100%** at the top of the navigation menu. If module completion is not 100%, go to any page that does not have a checkmark beside it and select the **Next** button. You can then close this window and return to IBM SkillsBuild to continue your learning journey.