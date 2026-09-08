# Lesson 3: The Complexity of Data Today

## Data is growing every day

Every time you shop online, use a smartphone, or interact with a website, the information you create is stored and analyzed. This information enables businesses, organizations, and governments to make informed decisions and enhance their services. To understand how all this works, you need to know what data is.

> **Data** is information that people collect, store, and use for analysis, decision making, or communication in digital systems.

Data underpins the functioning of every AI system, but not all data is the same. AI tools manage a wide range of formats, each with its own structure and challenges.

*Select each tab to learn more about the different types of data.*

### Structured Data

**Structured data** is highly organized information that can be organized in rows and columns. Perhaps you’ve seen structured data in a spreadsheet, such as Google Sheets or Microsoft Excel. Examples of structured data include names, dates, addresses, credit card numbers, and stock information.

### Unstructured Data

**Unstructured data** is typically data that lacks any built-in organization or structure. It cannot be easily processed and analyzed by conventional data tools and methods. Examples of unstructured data include images, texts, customer comments, medical records, and even song lyrics.

### Semi-structured Data

**Semi-structured** data is a type of data that falls between structured and unstructured data. It doesn’t fit neatly into tables like structured data, but it has organizational elements that make it easier to work with than fully unstructured data. For example, a video on a social media site is considered semi-structured data. The video itself is unstructured data, but it includes elements, such as a hashtag, timestamp, and location information that enable the internet to easily categorize the video. 

### Metadata

**Metadata** is information that describes other data. It provides context such as date created, file size, author, or tags that help people and systems use the data more effectively. For example, a recording of a user interview might include the interview date, the user’s email address, and tags summarizing key insights. Metadata plays a key role as an organizational element in semi-structured data.

---

Whether it’s a row of numbers or a block of text, recognizing how data is organized gives you a better grasp of what AI can do and why it works the way it does.

## Activity: Classify the four types of data

A group of new employees is learning how to work with different types of data in their organization’s information systems. Their trainer has provided several examples, but the team needs help organizing them correctly into structured data, unstructured data, semi-structured data, and metadata.

*Match each example with the data type it best represents. If you answer incorrectly, select Retry to try again.*

- Structured data: A spreadsheet containing employee names, job titles, and phone numbers
- Unstructured data: A folder full of raw image files from a product photoshoot
- Semi-structured data: A video uploaded to a platform that includes location and timestamp elements
- Metadata: The artist name, genre, and release date displayed alongside a song on a streaming platform

### Feedback

- Structured data  + A spreadsheet containing employee names, job titles, and phone numbers: These examples include organized information stored in rows and columns, often in spreadsheets or databases.
- Unstructured data + A folder full of raw image files from a product photoshoot: These examples show data without a predefined format, such as freeform text or media, that’s harder to process with conventional tools.
- Semi-structured data + A video uploaded to a platform that includes location and timestamp elements: These examples involve data that includes some structure, such as metadata or tags, but doesn’t fit neatly into rows and columns.
- Metadata + The artist name, genre, and release date displayed alongside a song on a streaming platform: Metadata is information that describes other data. It provides context, such as creator, category, or date, that helps people and systems use and organize the content more effectively.

---

Have you ever thought about just how much data exists for AI systems to analyze? Let’s find out!

## How much data is there?

Every day, people generate an enormous amount of digital data worldwide, often without being aware of it. From sending messages to streaming videos and browsing websites, each action adds to a global data ecosystem that is growing at an incredible pace.

> The world generates 2.5 quintillion bytes of data daily.

[How Much Data Is Generated Every Day in 2024?](https://spacelift.io/blog/how-much-data-is-generated-every-day) Spacelift, Inc. (article), November 29, 2024.

That’s equal to creating 250 billion full-length high-definition movies each day. The amount and scale of data that modern organizations create exceed the capacity of traditional tools to analyze.

### Introduction

Daily, billions of people go about their routines, while in the background, every text, scroll, click, and stream generates digital data. It’s easy to forget how much you contribute to the global flow of information. Let’s explore how by following Jordan, a typical professional, on a typical day. 

*Select START to explore Jordan’s impact on the world of data.*

### Wake-up scroll

Jordan’s alarm buzzes, and without even lifting his head from the pillow, he reaches for his phone. It’s the same routine every morning. First, swipe off the alarm, check the weather, then glance at his calendar, and scroll through notifications. A few taps later, he’s browsing social media apps, catching up on news headlines, and responding to a comment from a friend. 

What seems like a slow start to his day is a burst of digital activity. In the digital background, each action triggers a series of data exchanges. The weather app pulls location data to show local conditions, social media platforms log usage patterns, and notification settings are synchronized across devices. Even the action of swiping away an alert is recorded somewhere.

### At work

Jordan settles in at his desk and opens his laptop. The first task of the morning is to check email and catch up on team messages. A few quick replies, a forwarded file, and a starred message later, he has cleared his inbox. In the team channel, Jordan reacts to a teammate’s update with a thumbs-up emoji and drops a quick message confirming he’s on track for an upcoming deadline. 

While it might feel like a routine check-in, these actions quietly generate valuable data. Email systems log timestamps to track when messages are sent or received, making it easier to thread conversations and sort by priority. The subject line helps with filtering, while attachments are tagged by type for easier access later. Messaging tools record who’s participating in conversations, helping with features such as searchable chat histories, @mentions, and file organization.

### Unwinding at home

After finishing work, Jordan makes himself comfortable on the couch and opens his streaming app. He continues watching a crime series, letting a couple of episodes play while browsing for hiking gear on his tablet. He reads product reviews, saves a few items, and compares prices on two different websites. Before heading to bed, Jordan asks his smart speaker to remind him about a morning call and to dim the lights. 

Even this quiet evening adds to the stream of daily data. The streaming app notes which episodes were watched and for how long, using that information to suggest what to watch next. Jordan’s browsing habits help shopping platforms refine product recommendations and search results. The voice command to the smart speaker is processed and linked to his calendar, while the home assistant logs the lighting change to help automate similar future routines.

### Summary

Jordan didn’t do anything unusual, but his actions created a steady stream of digital data, happening in the background.

--- 

Data helps apps run more smoothly, content feel more relevant, and services respond faster to users’ needs. It also influences how AI learns and adapts.

Some types of data are more challenging to work with than others. Let’s explore why.

### Why are some types of data harder to work with than others?

While structured data fits neatly into rows and columns, much of today’s information is unstructured or semi-structured. Because unstructured and semi-structured data do not fit into traditional tables, they are more challenging to manage, analyze, and derive value from.

The key challenges of unstructured and semi-structured data include:

- **Inconsistency:** These types of data lack a predictable format. For example, customer feedback might be entered in different formats or languages, making it difficult to compare or aggregate results.
- **Variability:** Data might come in various forms, including text, images, audio, and video, each requiring distinct processing techniques and storage solutions. These differences make it hard to standardize tools and workflows and ensure data quality.

Because traditional data tools weren’t designed for this kind of complexity, AI is becoming more critical for analyzing unstructured and semi-structured data. These tools help uncover patterns, interpret meaning, and work with information that doesn’t follow a set format.

## Hidden data

Think about all the images, videos, or documents you’ve saved on your computer but never looked at again. Over time, those files take up a lot of space. When you run out of storage, it can be challenging to determine what to keep and what to delete. Many files have vague names, unclear or no labels, and aren’t organized in any helpful way. You know the information is there, it’s just not easy to work with. That’s what hidden data is like.

> **Hidden data** refers to information that exists in an organization’s systems or processes but is not actively used or analyzed, typically because it’s too difficult to process, organize, or analyze using traditional tools.

Hidden data isn’t a different type of data, such as structured or unstructured data. Hidden data refers to data that already exists but isn’t being used.

*Read the following to learn more about hidden data.*

### Examples of hidden data

Common examples of hidden data include:

- Long text responses
- Recorded customer calls
- Chat transcripts
- User research or marketing videos
- Scanned documents

These files are too complex to be easily searched, sorted, or analyzed using traditional data analysis tools.

### The value of hidden data

Hidden data can hold insights that organizations miss when they only focus on data that is easy to analyze. By examining hidden data, teams can:

- Understand customer behavior more clearly
- Discover problems early before they grow
- Find patterns that lead to better decisions
- Improve products, services, and internal processes

Examining hidden data provides a more complete overview of what’s happening, allowing teams to respond with greater confidence and clarity.

---

Hidden data is often too complex to use with traditional tools. The volume, inconsistency, and lack of structure make it difficult to process, and that’s where AI can help.

## How AI addresses complex data challenges

AI is designed to address the challenges that people encounter when working with unstructured and semi-structured data, enabling them to uncover insights within their data. The capabilities of AI make it a powerful tool for uncovering insights from previously unexplored and unanalyzed data.

*Select each tab to learn more about how different systems process information to handle complex data challenges.*

### Deterministic System

**Deterministic systems** follow strict, preprogrammed rules to process data. They work like a flowchart:  if condition A is met, then action B happens, every time. These systems produce the same output when given identical input, making them predictable and reliable for structured tasks. But deterministic systems have limitations:

- They require clean, structured, and consistently formatted data.
- They cannot adapt to unexpected data variations or extreme cases.

For example, a traditional database query searches for exact matches. If you search for “customer orders from January 2024”, it will only find records matching that exact criteria, character by character.

Deterministic systems fail when encountering data they weren’t specifically programmed to handle. They struggle with typos, formatting variations, or incomplete information, and can’t interpret context or meaning beyond literal matches.

### Probabilistic System

**Probabilistic systems** use statistical models and algorithms to make informed decisions based on patterns and probabilities. Instead of rigid rules, they calculate the probability of different outcomes, allowing them to handle uncertainty and ambiguity in data processing. Unlike deterministic systems, probabilistic systems can:

- Work with messy, incomplete, or inconsistent data
- Handle uncertainty by weighing multiple possibilities
- Adapt processing based on statistical patterns in the data

For example, a probabilistic system analyzing customer feedback can understand that “gr8 product!”, “great product”, and “excellent item” all likely express positive sentiment, even though the exact words and formats differ.

---

The shift from deterministic to probabilistic systems represents a fundamental change in how systems approach data processing. A probabilistic approach enables AI to tackle complex data challenges.

### AI strengths for solving complex data challenges

AI offers three fundamental strengths that make it uniquely capable of unlocking hidden insights. These strengths help organizations approach challenging data problems and turn unusable information into insights.

*Select each section to learn more about the key advantages of AI for solving complex data challenges.*

#### Detects patterns

AI excels at finding hidden patterns and relationships within unstructured data. AI can analyze text to understand sentiment, extract key information from documents, recognize objects in images, and identify trends across different types of content. The power of AI pattern detection includes the following:

- **Content creation:** AI analyzes thousands of internal documents, reports, and communications to automatically generate executive summaries, training materials, and marketing content that maintains brand voice and incorporates company-specific insights.
- **Medical imaging:** AI reviews X-rays, MRIs, and CT scans to detect early signs of diseases, identifying patterns in imaging data that human radiologists might miss or take much longer to spot.
- **Market forecasting:** AI examines news articles, social media sentiment, and financial reports to identify market trends and investment opportunities by finding subtle patterns across vast amounts of unstructured information.

Organizations can now access data sources they previously couldn’t use effectively, such as hidden data, and uncover insights that were previously hidden in their unstructured information.

#### Analyzes massive amounts of data

Traditional analysis methods become impractical when dealing with datasets containing millions or billions of records, and human analysts can only process a fraction of the available information. AI systems can process vast amounts of data simultaneously, analyzing patterns across entire datasets that would take human teams months or years to review. These systems can work continuously without fatigue and maintain consistency across large-scale analysis in the following ways:

- **Supply chain optimization:** Retailers use AI to process inventory data, weather patterns, economic indicators, and consumer trends across thousands of locations to automatically make restocking and distribution decisions.
- **Document generation:** Legal firms use AI to analyze millions of case files, contracts, and legal precedents to automatically generate customized legal documents, briefs, and contract templates tailored to specific client needs.
- **Quality inspection:** Manufacturing companies use AI to analyze images from thousands of products per hour across multiple production lines, consistently detecting defects and variations that indicate quality issues.

Organizations can make data-driven decisions based on comprehensive analysis, rather than relying on small samples, which leads to more accurate insights and better outcomes.

#### Learns continuously from new data

Business environments, customer preferences, and market conditions constantly evolve. AI systems automatically adapt and improve as they encounter new data. They can detect when patterns change, identify emerging trends, and adjust their analysis accordingly without requiring manual intervention or reprogramming. Static analysis tools quickly become outdated, and manually updating traditional systems is time-consuming and often incomplete. The following applications highlight how AI adapts as conditions change:

- **Fraud detection:** Financial institutions use AI tools to learn from new fraud patterns and legitimate transaction behaviors, automatically updating their detection models to identify previously unknown scam techniques while reducing false positives.
- **Personalized content:** Marketing platforms continuously learn from customer interactions and preferences to generate increasingly relevant email campaigns, social media posts, and product descriptions that resonate with evolving audience interests.
- **Autonomous navigation:** Self-driving vehicles continuously learn from road conditions, traffic patterns, and driving scenarios, improving their ability to recognize obstacles, read signs, and navigate complex visual environments.

Organizations maintain competitive advantages by staying current with changing conditions, ensuring their data analysis remains relevant and accurate over time without constant manual updates.

---

These three AI strengths work together to address complex data challenges that traditional systems can’t handle, and can help organizations unlock the full potential of their data.

## Points to remember

### Key concepts

1. Data is information used for analysis, decision making, or communication in digital systems.

2. Data can be categorized into four main types:

3. Hidden data exists in systems and processes and is stored alongside other information, but it isn’t used because it’s challenging to work with.

4. Deterministic systems follow strict, preprogrammed rules to process data.

5. Probabilistic AI systems make informed decisions based on patterns and probabilities.

6. AI’s data-solving strengths include the ability to:

- Detect patterns
- Analyze massive amounts of data
- Learn continuously from new data

> In this lesson, you discovered how the massive growth of data makes traditional analysis challenging. You explored types of data and learned about hidden data and deterministic and probabilistic systems. You also learned about AI’s strengths in solving complex problems. You’ve finished the final lesson of this module. Next, you’ll review the module’s learning objectives, explore additional resources related to AI, and take a quiz to assess your understanding.
