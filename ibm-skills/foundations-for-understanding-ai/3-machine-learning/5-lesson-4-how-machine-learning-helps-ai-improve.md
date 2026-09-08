# Lesson 4: How Machine Learning Helps AI Improve

## Generative AI hallucinations

Machine learning enables AI systems to identify patterns in data, provide insights, make recommendations, and continually improve with experience. These capabilities make AI a significant component of health, financial, safety, and legal decisions. Because the stakes are high, engineers, developers, and users should understand AI’s risks and limitations and how to address them.

### Did AI just make that up?

Watch the following video to learn more about how AI can mislead you and what you can do to avoid errors.

[Did AI just make that up_video_transcript](./video-transcript-did-ai-just-make-that-up.md)

### Knowledge Check

Let’s check your knowledge about the concepts you just learned.

#### Question 1

A marketing analyst prompts an AI tool to provide recent industry news and receives the headline, "Acme Corp acquired by a rival competitor". Before adjusting her business plan around this claim, she wants to avoid being misled by a possible AI hallucination.

Which action is the most effective first step to reduce the risk of acting on false information?

- Use the AI's answer because the model was trained and learned on large amounts of data.
- Ask the AI for a more detailed summary of the acquisition and rely on its explanation.
- Add the headline to the analyst's strategy deck now, planning to verify it later if time allows.
- Check the headline against reputable news outlets, press releases, or known databases.

**Answer: Check the headline against reputable news outlets, press releases, or known databases.**

Verifying the claim with reliable, independent sources is the way to confirm whether the acquisition happened.

## Improving the accuracy of AI

Let’s say you’re planning a big trip. You check out a travel blog to help you plan your visit. The photos are beautiful, the descriptions are vivid, and the blog seems like the perfect resource. But once you arrive, you realize things have changed. Restaurants are closed, train schedules are outdated, and the neighborhoods have completely transformed. The blog provided a confident overview, but it was not entirely accurate.

Something similar might happen with AI. AI might respond quickly and confidently, but the information it provides is often outdated, incomplete, or incorrect. In the video, you learned this is called a hallucination. Now, let’s explore some strategies for improving the accuracy of AI systems.

> A **hallucination** is a response from a foundation model that includes off-topic, repetitive, incorrect, or fabricated content. Hallucinations involving fabricating details can happen when a model is prompted to generate text, but the model doesn’t have enough related text to draw upon to generate a result that contains the correct details.

*Select each section to learn how to help AI tools provide more accurate results.*

### Fine-tuning models

**Fine-tuning models** involves adjusting an AI model with new, specific data to improve its performance on specific tasks. This process enables the AI tool to learn patterns and details that are specific to a particular subject or industry. When you fine-tune a model, you improve its ability to provide accurate and relevant answers in real-world situations. Fine-tuning is beneficial when general models fail to meet the specific needs of specialized work.

For example, a healthcare company fine-tunes an AI tool using medical records and terminology to accurately summarize patient notes for doctors.

### Human-in-the-loop feedback

**Human-in-the-loop feedback** involves placing people in the process of reviewing and correcting AI outputs as they are being generated. When humans check and adjust the results mid-process, they identify mistakes early and help guide the AI’s learning over time. This method combines human judgment with the speed of AI, making the overall system more reliable and effective.

For example, a content editor collaborates with an AI writing assistant in real-time, approving or revising sections of a blog post when the AI suggests them, so the output remains on topic and accurate throughout the process.

### Data quality improvements

**Data quality improvements** enable AI to generate better insights and outputs and reduce the likelihood of errors. Clean, accurate, and relevant data is a necessity. The quality of the data used to train an AI tool directly affects the quality of its output.  If the data is messy or wrong, the results will be unreliable. 

For example, a retail company updates its product database to remove outdated or incorrect information before using it to train an AI-powered inventory system.

### Post-generation verification

**Post-generation verification** refers to checking the results after the AI tool has created them. This step helps identify errors, false information, or hallucinations before anyone relies on the output. Unlike human-in-the-loop feedback, which influences the AI during creation, post-generation verification focuses on reviewing the final output to verify its accuracy. Verification involves cross-checking facts, using trusted sources, or having the results reviewed by a human. 

For example, a journalist verifies AI-generated research summaries by comparing them with original scientific articles before publishing a news story.

---

Using these strategies helps reduce errors and improve the accuracy of your AI-generated results. Let’s explore how it might work in practice.

## Activity: Apply strategies for improving AI accuracy

In this activity, you’ll diagnose and resolve issues with AI assistant systems that are presenting incorrect or misleading information to users. You’ll choose a strategy to improve the accuracy of the AI systems based on four use cases.

### Background information

As the newly promoted AI quality specialist with SmartAssist AI, a company that provides AI assistants to clients worldwide, you’ve been assigned cases for clients whose AI assistants are not performing as expected.

Your task is to review and analyze each client’s AI assistant’s use and performance, then recommend the best strategy to improve the AI assistant’s accuracy. The strategies available to you include the following:

- Fine-tuning models
- Human-in-the-loop feedback
- Data quality improvements
- Post-generation verification

*Complete the following activity.*

///

Apply strategies for improving AI accuracy.

Select **Start** to begin.

### Background information

You've just been promoted to AI quality specialist at SmartAssist AI, a company that provides AI assistants to businesses worldwide. Your new role is to diagnose and resolve issues with AI assistant systems that aren't performing well for clients.

Your manager has assigned you four urgent cases. These four cases involve clients whose AI assistants are producing subpar results. You'll need to analyze each situation and recommend the best strategy to improve the AI assistant's accuracy for these clients.

### SmartAssist client cases

- The **TechWrite Solutions** AI writing assistant is producing generic content that doesn't align with their brands, causing writers to spend time on complete rewrites.
- The **Global News Today** research AI assistant created article summaries with factual errors. The errors were caught before publication, damaging their credibility.
- The **City Hospital Network** medical AI assistant uses outdated medical terms and lacks an understanding of new treatment protocols introduced in 2024.
- The **Fresh Foods Market** inventory AI assistant provides limited insights and recommendations because it uses data that includes closed stores and discontinued products.

#### Case 1: TechWrite Solutions

The TechWrite Solutions marketing agency serves 15 clients, each with their own unique brand and personality. The TechWrite Solutions AI assistant produces copy that isn't always accurate and often fails to stay on topic. Writers report spending 3–4 hours completely rewriting AI-generated drafts, and adjusting the tone after generation takes longer than writing original copy.

As the AI quality specialist, which strategy should you apply to improve the accuracy of the AI system?

- Post-generation verification
- Human-in-the-loop feedback
- Data quality improvements

**Answer: Human-in-the-loop feedback**

Human-in-the-loop feedback enables writers to guide AI's output in real time, facilitating alignment with the specific client's brand voice when it's being created.

#### Case 2: Global News Today

The Global News Today platform publishes over 200 AI-assisted articles daily. Their research AI retrieves information from various sources, but frequently confuses similar companies or events.

As the AI quality specialist, which strategy should you apply to improve the accuracy of the AI system?

- Human-in-the-loop feedback
- Data quality improvements
- Post-generation verification
- Fine-tuning models

**Answer: Post-generation verification**

Post-generation verification would identify factual errors by having journalists check the AI's summaries against reliable sources before publication.

#### Case 3: City Hospital Network

The City Hospital Network AI assistant was last updated in 2021. Since then, there have been significant changes in healthcare policies. The AI has been recommending outdated visitor policies, obsolete insurance billing codes, and outdated patient intake procedures.

As the AI quality specialist, which strategy should you apply to improve the accuracy of the AI system?

- Human-in-the-loop feedback
- Fine-tuning models
- Data quality improvements
- Post-generation verification

**Answer: Fine-tuning models**

Fine-tuning the model with current medical data and new treatment protocols will help AI learn modern healthcare practices and terminology specific to the medical field.

#### Case 4: Fresh Foods Market

The Fresh Foods Market grocery chain's inventory AI assistant is ordering products for 50 stores that closed in 2021 and stocking discontinued items. Last month, it sent seasonal cookies to the wrong region and shipped fresh seafood to closed locations. The AI assistant's training data still includes the closed stores. It also includes over 1,200 discontinued products that are incorrectly listed as active.

As the AI quality specialist, which strategy should you apply to improve the accuracy of the AI system?

- Data quality improvements
- Human-in-the-loop feedback
- Post-generation verification
- Fine-tuning models

**Answer: Data quality improvements**

Improving data quality by removing information about closed stores and discontinued products enables AI to offer more accurate inventory insights and recommendations based on clean, current data. 

## AI ethics implications: Hallucinations

A home loan officer relies on AI-generated reports based on credit scores and other financial data. If those reports contain false data, the loan officer might deny qualified borrowers, potentially exposing the bank to legal liabilities.

Similarly, a healthcare provider might use an AI tool to suggest treatment. If the AI suggestions are based on incorrect information, patient safety might be at risk.

As these examples highlight, AI hallucinations pose significant challenges. To help address the challenges, engineers, developers, and users can apply three of the IBM Pillars of Trust: explainability, transparency, and fairness, which are designed to help build trust and promote clear, safe, and respectful AI.

*Read the following to learn more about how applying these Pillars of Trust helps address challenges caused by AI hallucinations.*

### Explainability: Impact on user understanding

**Explainability** enables users to understand why an AI model provided a particular response. In case of a hallucination, users should be able to trace the invalid reasoning behind the hallucination. If a medical AI tool invents a false symptom, a doctor needs to know what patterns or sources the model relied on to make that diagnosis. Without explainability, errors become harder to catch and lead to serious consequences. 

Generative models, such as large language models (LLMs), complicate explainability because they don’t directly retrieve facts from fixed sources. They generate responses based on patterns in massive datasets without following a clear model or dataset, making it difficult to determine exactly why the model gave an answer or whether the answer was grounded in real information. 

To improve explainability, generative AI developers use techniques such as prompt design and citations to clarify model behavior, and researchers explore how to improve reasoning visibility. For example, a medical researcher checks an AI-generated summary and finds a suspicious claim. Because the system is explainable, the researcher can review the data that the AI used to determine whether it misinterpreted an unrelated study. 

### Fairness: Impact on decision equity

**Fairness** advocates that AI systems don’t favor any individual or group over another. Fairness aims to produce equitable outputs and avoid amplifying bias from training data. When hallucinations occur, fairness issues become more serious, especially if the generated content reinforces harmful stereotypes or excludes certain groups. 

Generative AI and LLMs learn from data that reflects the world, including its biases. Suppose the training data contains patterns of discrimination. In that case, these patterns appear in the model’s outputs, making it challenging to facilitate fair treatment across all users when outputs are generated in real time and vary with each prompt.

To support fairness in generative AI, teams audit training data, test outputs for bias, and apply safeguards such as clear prompts, filters, or fairness constraints. User feedback and external evaluations also help identify when the model behaves unfairly or produces biased content. 

For example, an HR team evaluates outputs from an AI resume screener and finds that it ranks candidates from one college higher for leadership roles than candidates from other colleges. They work with the developers to retrain the model and introduce checks to reduce that type of bias in future outputs. 

### Transparency: Impact on trust

**Transparency** means providing clear and open information about how AI models are developed, trained, and function. Users should understand the data sources, models, and system limitations to promote accurate and reliable results. Transparency is important when the AI output might contain hallucinations. 

Transparency is more complex in large language models. Engineers train LLMs on massive datasets that often include a mix of public, private, and proprietary content. Because of this approach, it’s not always clear where a specific piece of generated information originated, or whether the AI created it. 

To support transparency, developers disclose model limitations, provide information on training data, and offer tools such as citations to support their work. These measures help users understand what an AI tool can and cannot do, making it easier to determine when to trust a response or verify it.

For example, a financial institution shares that its generative AI tool does not use real-time financial data and explains how it generates market commentary, so users are aware when to verify the output against current sources.

---

The IBM Pillars of Trust, such as explainability, transparency, and fairness, facilitate the responsible use of generative AI. When building or using generative AI systems, applying these principles enhances trust, mitigates risks, and fosters equitable outcomes.

### What do you think?

Now that you’ve learned about the AI ethics implications of hallucinations, let’s explore your reactions and perspectives. These topics influence how AI impacts your life, including the level of trust you place in its outputs. Take a moment to reflect on how you think about AI’s role in your world and write your thoughts in the spaces provided.

*Enter your responses in the provided text boxes.* (Writing an answer is a good way to process your thoughts. These answers are for your use only. You have the option to download your response and save it. It will not be saved in the text boxes when you move on in the module.)*

### Evaluate your thinking

Do your answers account for the following?

Expand for some more thoughts

1. How do you feel about AI tools generating content that might include false or misleading information?

Think about situations where you or others might rely on AI-generated information without verifying it. It might be a health recommendation, a news summary, or a tool used at work. Consider the risks if that content turns out to be inaccurate.

2. Why do you think explainability and transparency matter when using AI?

Consider how you would react if you received a strange or incorrect output. Would you like to know where the information came from or how the system arrived at its decision? Being able to trace and understand the source helps you judge the quality and trustworthiness of the content.

3. In what situations do you think fairness in AI decisions is most important?

Think about areas such as hiring, healthcare, education, or law enforcement. These are places where AI outputs have a significant impact on people’s lives.

## Points to remember

### Key concepts

1. Generative AI might produce false or misleading outputs, known as hallucinations. These include incorrect news summaries, fake citations in research reports, or completely wrong information.

2. To improve generative AI accuracy and reduce hallucinations, organizations use strategies such as:  

- Fine-tuning with domain-specific data 
- Gathering user feedback 
- Improving training data quality 
- Reviewing and correcting outputs 

3. Responsible use of AI includes focusing on explainability, fairness, and transparency, so that the technology helps build trust and promotes clear, safe, and respectful AI use.

--- 

In this lesson, you explored the real-world effects and AI ethics concerns of generative AI hallucinations. You also reviewed AI responses, identified errors, and selected the most effective strategy to enhance accuracy. Next, you’ll review the module’s learning objectives, explore additional resources related to AI, and take a quiz to assess your understanding.
