# Lesson 2: Classical Machine Learning Models

## Introduction to classical machine learning models

To understand how AI systems offer insights and make recommendations, you need to know about the different models they use to process data. Classical machine learning models are fundamental.

> **Classical machine learning** is a group of models where computers use mathematical calculations to identify patterns in data and make suggestions or decisions based on those patterns.

Classical machine learning models and modern AI use different tools to learn from data. Classical machine learning uses simple models that perform well with structured data, such as spreadsheets with rows and columns. These models are easy to understand and do not need large amounts of data or powerful computers. They are often used for tasks such as offering insights about sales or sorting emails.

Modern AI is more complex. It uses learning structures called **neural networks**, made of multiple layers of interconnected nodes. Each layer progressively identifies patterns in complex inputs such as images of cars and buses. To sort an image into a “bus” category, one of the hidden layers of a neural network might identify shape patterns, while another layer identifies wheel size or window style patterns.

These models are more effective at processing unstructured data, such as recognizing faces or objects in images, understanding spoken language, or translating text between languages. However, they usually require significantly more data and computing power to function effectively.

Even though modern AI solves more complex problems, classical machine learning is still helpful when the data is small, the task is simple, or you need to understand how the system made its decision.

*Select each tab to explore more about how and where classical machine learning is still relevant.*

### Small Datasets

Classical machine learning learns from small datasets, where only a limited number of examples are available. For example, a school might use a few years of test score data to offer insights into how students are likely to perform this year.

Classical models, such as linear regression, work well in this case because they do not require thousands of examples to find patterns. Modern AI typically requires significantly more data to function correctly.

### Fast Training

Classical models are trained quickly, often in just seconds or minutes. For example, a business might want to quickly test different methods for recommending which customers are likely to sign up for a new service.

Because these models are simpler, developers can test and adjust them more quickly than deep learning systems, which can take hours or even days to train.

### Low Computational Costs

Classical machine learning performs well on basic computers without requiring specialized hardware. For example, a small company might use a basic laptop to develop a model that provides recommendations on inventory needs.

These models are appropriate when there’s limited access to powerful computing tools, unlike modern AI, which often requires much more processing power.

### Transparency

Classical models are simpler and easier to understand; when using them, how the model made a decision is more obvious. For example, a healthcare provider might use a decision tree to understand which symptoms lead to a certain diagnosis. In situations when it’s necessary to explain results, classical models provide more clarity than other, more complex models.

---

Classical machine learning remains valuable for its simplicity and transparency, while modern AI enables new ways to process complex information and carry out advanced tasks.

Typical models used in classical computing include the following:

- Decision tree
- Linear regression
- Logistic regression

Let’s explore each model in detail.

## Decision tree

When you use AI tools to sort information or make recommendations, the technology relies on different methods to make choices. A decision tree is a standard classical machine learning model.

> A **decision tree** is a classical machine learning model that splits data into nodes to reach decisions or classifications.

Decision trees work by asking a series of yes-or-no questions that help the system move step by step toward a final answer. At each step, the model checks one feature in the data and uses that to decide which direction to go next.

In the following graphic, notice that the decision tree in the diagram helps decide whether it’s a good day to surf. It starts by asking if there is swell. If the answer is yes, it checks the wind conditions. Based on how strong the wind is and which direction it’s blowing, the model makes a final decision: surf or don’t surf.

*Select each marker to learn more about how the decision tree model works.*

- **Root node**: A node is a question or decision point. The **root node** splits the data based on one condition. For example, “Is there swell?” is a node that helps the system decide what to check next.
- **Internal nodes**: **Internal nodes** connect one part of the tree to another. It shows the possible answers to a question. For example, “Yes” or “No” are internal nodes that lead to different paths based on the answer.
- **Leaf node**: A **leaf node** is the final result or decision the model makes. For example, “Surf” or “Don’t surf” are leaf nodes that show the outcome once the data has been fully processed.

---

Decision trees are one of the most common models used in classical machine learning. They show how a system makes decisions without needing large amounts of data or complex tools. Decision trees are easy to understand, which makes them useful in situations where there’s a need to explain how the AI reached its answer.

## Linear regression

When you want to determine a value, such as the amount of rainfall or the number of sales, you need a way to find patterns in data and gain insights and recommendations for forecasts. Linear regression, another common approach in machine learning, is excellent for these types of tasks.

> **Linear regression** is a machine learning model that recommends continuous outcomes by fitting a straight line to observed data points.

In linear regression, a continuous outcome is a result that is any number within a range, rather than just one of a few predefined categories. For example, a business might believe that more advertising spending leads to better sales. They might graph the data as a series of dots that form a rising straight line, as illustrated in the following chart.

As suggested in the chart, as advertising increases, so do sales. There are many possible outcomes (different amounts of advertising spend lead to different amounts of sales), but the change rises on the graph in a straight line.

If the company wanted to sell 10,000 cars, the linear regression model might suggest placing about seven ads at sporting events to reach that goal.

But real-life decisions are often more complex. A company might need to consider other factors such as where the ads appear, when they run, and how often they’re shown. When there’s more than one input, machine learning models use multiple linear regressions instead of a simple linear regression.

*Select each tab to learn more about simple linear regression and multiple linear regression.*

### Simple linear regression

**Simple linear regression** enables machine learning models to identify the relationship between two variables: one input and one output. It draws a straight line through the data to show how a change in one value affects the result.

For example, a coach uses simple linear regression to provide insights into how fast a runner will complete a race based on the number of minutes they train each day.

Simple linear regression is useful when there is only one primary factor affecting the outcome, and you want clear, easy-to-understand insights.

### Multiple linear regression

**Multiple linear regression** examines multiple inputs to determine a single outcome. It still uses a straight-line approach, but in more dimensions.

For example, a school uses multiple linear regression to estimate a student’s final grade based on attendance, homework scores, and test performance.

This method is helpful when multiple factors interact to influence the outcome. It provides AI with a more complete picture, enabling it to make more informed recommendations.

---

Understanding linear regression helps show how machine learning models make recommendations based on numbers that change over time, such as scores, time, or cost. Understanding the distinction between simple and multiple linear regression helps explain how models function with either one input or multiple inputs and builds a foundation for learning more advanced AI methods.

## Logistic regression

Have you ever checked the weather and decided whether to bring an umbrella? Maybe if there’s a high chance of rain, you take one with you, but if the forecast looks clear, you don’t bother. Machine learning uses logistic regression to aid in making decisions of this type, which are typically yes or no.

> **Logistic regression** is a classical machine learning model that helps solve problems where the goal is to estimate one of two possible outcomes based on input variables.

For example, a bank might use logistic regression to estimate the likelihood that someone will repay a loan. The model does not directly say “yes” or “no”. Instead, it gives a probability, such as a 70% chance that the person will repay the loan. That number is then used to help make a decision.

While decision trees use step-by-step questions to reach a result, logistic regression uses a curve to calculate the probability based on patterns in the data. Unlike linear regression, which provides insights into values such as price or time, logistic regression estimates the likelihood of an outcome.

*Select each section to learn more about logistic regression.*

### Odds and probability

In logistic regression, the model does not guess yes or no directly. Instead, it first calculates something called odds and probability, then turns those **odds into a probability** between 0 and 1.

- **Odds** compare the chance that something will happen to the chance it won’t. For example, if 8 out of 10 people respond to a survey, the odds are 8 to 2 (meaning 8 responded, 2 did not).
- **Probability** is the chance that something will happen. It’s a number between 0 and 1. In the example, the probability is 8 divided by 10, or 0.8. A 0.8 probability means there is an 80% chance of something happening.

Understanding odds and probability helps explain how logistic regression makes its recommendations.

### The logistic (sigmoid) function

The **logistic, or sigmoid, function** is a mathematical formula that turns odds into a probability value between 0 and 1. The function creates an S-shaped curve, starting low, rising quickly in the middle, and flattening near the top. The shape of the curve means the model is most confident when the number is very high or very low, and least confident when it’s in the middle.

### Threshold and binary decision

After logistic regression transforms its results into a probability using the sigmoid function, it still needs to make a final binary decision: Is the answer “yes” or “no”?

That’s where the **threshold** comes in. A threshold is a set point that determines how a probability is converted into a final yes or no outcome.

In most cases, the threshold is set at 0.5. That means:

- If the probability is above 0.5, the answer is yes.
- If the probability is below 0.5, the answer is no.

This is how logistic regression transforms the odds into a final yes-or-no decision.

Adjusting the threshold alters the model’s sensitivity. A lower threshold means more yes answers, but it also might mean more mistakes. A higher threshold makes the model stricter and less likely to return a “yes” response.

For example, a company might use logistic regression to decide which customers are likely to buy a product. If the model suggests a 70% chance for one customer and a 40% chance for another, the company might set a threshold (such as 0.6) to decide who receives a special offer.

---

Classical machine learning uses various models to train AI systems to assist in decision making, provide insights, and offer recommendations. Decision trees, linear regression, and logistic regression each approach data and choices in different ways. Next, you’ll use your knowledge of these models to make recommendations within a realistic setting.

## Activity: Use decision trees, linear regression, and logistic regression to offer insights

In this activity, you’ll guide the PlanSmart AI data science team through the process of evaluating machine learning models for PlanSmart AI’s new app. As the new data science lead, you and your team will examine the characteristics of each model and determine the most suitable option for processing data.

### Background information

PlanSmart AI is a startup company developing recommendation apps for everyday decisions. The team is currently developing a “Weekend Plans” recommendation engine app that suggests weekend activities to users based on various factors. App performance is critical, but cost and time-to-market factors should also be considered.

Before evaluating complex AI models, your chief technology officer (CTO) wants you to review decision trees, linear regression, and logistic regression as potential models for building the new app.

*Complete the following activity.*

///

Use decision trees, linear regression, and logistic regression to offer insights and make recommendations.

Select **Start** to begin.

### Background information

It's your first day as the new lead data scientist at PlanSmart AI, a startup developing recommendation apps for everyday decisions. Your team is building a "Weekend Plans" recommendation engine app that recommends weekend plans to users.

Before diving into complex AI models, your chief technology officer (CTO) wants you to explore whether PlanSmart can use classical machine learning models. You'll explore three different models using PlanSmart data to determine which performs best.

### The PlanSmart dataset: Historical weekend recommendations

Before exploring the models, review the following data from eight beta testers who received recommendations and then rated their satisfaction.

| Temperature | Budget | Number of friends | Recommended activity | Indoor or outdoor | Satisfaction | Minutes in app |
| --- | --- | --- | --- | --- | --- | --- |
| 75°F (24°C) | $40 | 5 | Concert | Outdoor | 9/10 | 45 |
| 45°F (7°C) | $15 | 2 | Coffee shop | Indoor | 8/10 | 25 |
| 68°F (20°C) | $25 | 3 | Concert | Indoor | 7/10 | 18 |
| 82°F (28°C) | $10 | 6 | Beach day | Outdoor | 9/10 | 35 |
| 38°F (3°C) | $10 | 4 | Gaming night | Indoor | 6/10 | 12 |
| 72°F (22°C) | $35 | 4 | Concert | Indoor | 8/10 | 28 |
| 55°F (13°C) | $25 | 2 | Movies | Indoor | 7/10 | 22 |
| 85°F (30°C) | $15 | 1 | Hiking | Outdoor | 10/10 | 55 |

### Exploring the decision tree model

Next, you'll explore how PlanSmart AI's decision tree model works by selecting the outcome boxes to discover which activity is recommended for the different scenarios. Notice that the decision tree begins with the temperature, followed by either the budget only or the budget and the number of friends, before making a recommendation.

Take a moment to explore the PlanSmart AI recommendations AI decision tree.

| Temperature | Budget | Number of friends | Activity recommendation |
| --- | --- | --- | --- |
| Greater than 65°F (18°C) | Greater than $25 | Any | Concert |
| Greater than 65°F (18°C) | Less than $25 | Greater than 2 | Beach day |
| Greater than 65°F (18°C) | Less than $25 | Less than 2 | Hiking |
| Less than 65°F (18°C) | Greater than $25 | Any | Movie |
| Less than 65°F (18°C) | Less than $25 | Greater than 2 | Game night |
| Less than 65°F (18°C) | Less than $25 | Less than 2 | Coffee shop |

**Scenario:** Your friend Amisha is planning a weekend with these conditions:

- **Temperature:** 58°F (14°C)
- **Budget:** $35
- **Friends available:** 5 people

Using PlanSmart's decision tree, which activity will PlanSmart recommend for Amisha?

- Coffee shop
- Game night
- Hiking
- Movie

**Answer: Movie**

Since the temperature is 58°F (14°C), which is less than 65°F (18°C), follow the right branch. Since the budget is $35, which is greater than $25, the decision tree leads directly to Movie, regardless of how many friends Amisha has.

### Exploring the linear regression model

PlanSmart is also considering the linear regression model to offer insights about user satisfaction based on app usage time. In this scenario, three new users spent different amounts of time in the app: user A spent 25 minutes, user B spent 42 minutes, and user C spent 16 minutes.

Using the regression line built from the historical data above, the satisfaction scores for the three users are:

- **User A** (25 minutes): 7.5/10 satisfaction score
- **User B** (42 minutes): 9.1/10 satisfaction score
- **User C** (16 minutes): 6.8/10 satisfaction score

**Scenario:** Jamal spent 30 minutes exploring options in PlanSmart before choosing a weekend activity. Using the linear regression model, what satisfaction score does PlanSmart suggest for Jamal?

- 8.0/10
- 9.1/10
- 7.2/10
- 6.5/10

**Answer: 8.0/10**

Following the regression line at 30 minutes leads to a predicted satisfaction score of 8.0/10.

### Exploring the logistic regression model

PlanSmart is also considering using the logistic regression model to offer insights about the probability of choosing outdoor versus indoor activities based on temperature. The S-curve indicates that warmer weather increases the likelihood of outdoor activity.

With the default 50% threshold, the curve reaches that point at 65°F (18.3°C) — above this temperature, PlanSmart recommends an outdoor activity. With a stricter 70% threshold, the curve doesn't reach that point until 75°F (23.9°C) — at 72°F (22°C), which falls below that point, PlanSmart recommends an indoor activity instead.

**Scenario:** PlanSmart has been receiving complaints from users that their outdoor activity recommendations are too cold. They're currently using a 50% threshold. Based on these complaints, PlanSmart's team wants to make outdoor recommendations more selective by raising the threshold to 70%.

Using the logistic regression model, what effect will raising the threshold to 70% have on PlanSmart's recommendations?

- With a 70% threshold, PlanSmart will only recommend outdoor activities when the temperature reaches 75°F (23.9°C) or higher.

**Answer: With a 70% threshold, PlanSmart will only recommend outdoor activities when the temperature reaches 75°F (23.9°C) or higher.**

This should reduce complaints about cold outdoor recommendations.

### Conclusion

Congratulations! You've explored how classical machine learning models work by experimenting with decision trees, linear regression, and logistic regression using PlanSmart's weekend recommendation data.

## Points to remember

### Key concepts

1. Classical machine learning models rely on mathematical and statistical methods to uncover patterns in data and use them to offer insights, and make recommendations or decisions.

2. Three of the more common classical machine learning models include the following: 

- Decision trees break down choices into simple yes-or-no questions, making it easy to follow how a decision is reached. 
- Linear regression helps suggest values such as sales numbers based on trends. 
- Logistic regression sorts data into two categories, such as whether a transaction is likely fraudulent or not.

3. Classical machine learning models work well when you have smaller amounts of data, need quick results, or must clearly explain how a decision was made.

---

In this lesson, you discovered that classical machine learning models are used in business, healthcare, finance, and other fields where there’s a need for transparency and speed. In the next lesson, you’ll dive deeper into machine learning models and consider how they impact AI outputs.

