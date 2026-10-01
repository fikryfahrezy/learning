# Section 6 — Using the Elements: Skeleton

Summary of lectures 30–37. Skeleton is the fourth plane, where form starts turning into function. It
does three things: it gives users **the ability to see the structure**, **a way to move through
it**, and **a way to act on what they see**. The concrete questions are about presentation: what form
will the product take, how will users move around, how will they do things, and how will content be
presented and manipulated?

Two elements create it, plus the glue that binds them:

- **Interface design** (task side) — gives users the ability to **do things**: touch, click, tap,
  move, act on what they see. It's the bridge into making the system do something for me.
- **Navigation design** (information side) — gives users the ability to **go places**: screen to
  screen in large sites, enterprise systems, and mobile apps, and sometimes through steps or flows
  within a single screen.
- **Information design** — the glue that ties everything else together, made concrete in
  **wireframes**.

> **Only deviate from a well-established convention when there's a clear, obvious benefit to doing
> so.** Habit and reflex account for most of what we do. The section opens and closes on this idea.

---

## 30. Defining the Skeleton

### What the skeleton has to enable

The decisions made here have to produce a useful, valuable experience that meets the person's need,
serves their expectations, and helps them reach their goals. That breaks down into several
principles:

- **Rapidly establish the product's value** in the user's mind. They have to see and experience
  something, sometimes very quickly, to feel that the time and effort they're about to invest will be
  worthwhile.
- **Lead the person toward continuing the experience**, which furthers the relationship. It's a lot
  like a first date: the quality of this experience and the next ones decides whether you stick
  around.
- **Introduce specific content at the most relevant, appropriate points.** When does the person want
  this information? Are they ready for it? Is this the right place in the workflow? What do they
  need to see here, and what do they need to do with it?
- **Every click, tap, or swipe should add immediate value.** The action I just took was worthwhile
  and got me one step closer to my goal.
- **Small actions should add up to a grander result.** I should always feel I'm on the right path.
  Forward progress, in football terms, even when I'm doing something relatively menial.

Everything the person sees, touches, and interacts with should work together to make what's
happening feel positive, useful, and valuable.

### Features vs. usability

The relationship is simple: **the more features anything has, the less likely its usability is
good.** The number of features or functions on the screen at any moment directly affects how useful
the product is.

**Example: a learning management system with 700+ features.** The company treats the feature count
as a competitive advantage, and from a sales standpoint that makes sense, because people like
checkbox comparisons ("look at all the stuff ours does"). But there's miles of research saying
excessive features:

- Make the product more complex and **steepen the learning curve** for users and administrators
- Add **extra taps, clicks, and steps** to even the most basic tasks
- Demand more effort on the business side to **configure and maintain** them
- **Increase cost**, so there's no hard-dollar benefit for users either
- Break easily: **one browser update** (IE, Firefox, Chrome) is enough to derail a significant
  percentage of them

> More complexity is almost never a good match for usability.

### Why conventions matter: habit and reflex

Ingrained habits and unconscious reflexes make up a large portion of our everyday actions, from
groggily making coffee in the morning without really being aware of it to the common things you do
every time you pick up your phone. Things we **instantly recognize as familiar** let us use those
reflexes, because they match our expectations of what something is supposed to do. No thought
required. A set of common symbols seen on phones, tablets, laptops, and the web always means the
same thing, does the same thing, and acts the same way.

Even when you do deviate from a convention, it's usually minor, because people's relationship to an
established paradigm is so strong.

**Example: the phone dial pad.** The iPhone's layout (three rows of numbers, zero at the bottom
center, star on the left, pound on the right) goes all the way back to the first touch-tone phones
in **1962**. When Android came out it looked visually different, with a different font, different
colors, and none of the iPhone's rigid containers. But the **convention and layout are exactly the
same.** Android needed to identify itself as something different, but it didn't try to get rid of
the convention, because that would break our habit, interfere with our reflex, and frustrate our
first attempt. And if we're frustrated at the first attempt, we probably won't try again. We'll go
toward whatever matches what we already know.

---

## 31. Interface Design

Good interface design is a **balancing act between visual form and technical function**. The
interface is both a **boundary and a bridge**: the midway point between user and system, and a hint
at what lies behind the first screen. To be useful and reliable it has to:

- Give people **what they want or need**
- Give it **when and where** they want it: at which step is it appropriate to surface something,
  and at which points must they be able to act? (Context.)
- Deliver it in a **visual format** that makes sure they can, and want to, access all of it. If they
  don't act, they don't reach any goal or get any of the benefit.

And you're trying to fit all of that onto something the size of **the surface of a cup of coffee**.

### Form is as important as function

Every element on the screen counts. Functionality matters, but the **form** that delivers it is
equally or more important: how content is organized, how the screen is laid out, how audio or video
improve understanding, and how people use their hands and fingers to move through data on touch
screens with all the new gestures.

> No matter how technically superior the code or how deep the functionality, **an application or
> site whose interface is difficult to use will not be used.**

We won't muddle through. We'll quit, call support, or go try one of the 8 million other products
that do the same thing. With infinite choice available, the bar for interface design is much, much
higher, and since we *can* go elsewhere, we absolutely will.

### Ground rules

- **To most people, the user interface *is* the system.** Some people open Google and type a full
  URL into the search field instead of the address bar, because to them Google is the Internet. What
  they see on screen is the sum total of their understanding, so some sense of what's possible
  beyond the first screen has to be made apparent.
- **A well-designed interface lets someone start immediately.** No training, no manuals, no tips.
  Get in, get going.
- **It has to be audience-appropriate.** You're not designing for yourself. For every decision, ask
  whether the intended person would understand it: would this label make sense to them, would they
  know how to use this control, should it be a button or a link?
- **Inappropriate interface design is the number one killer of great product ideas.** Things that
  make perfect sense on paper die because their interfaces are confusing and full of options nobody
  wants, so nobody can see the value.

### Serve the critical few

> **It's infinitely better to perfectly meet the needs of the critical few than to poorly meet the
> needs of many.**

Early software development aimed for flawless, bulletproof software that accounted for every
possible use case, scenario, and exception, and that way of thinking carried through the industry
for a long time. Good UX takes a different approach: you *can't* account for every case, so figure
out what the majority need to do and make sure that critical part of your audience can do it well,
with full understanding, seeing the value of the outcome.

That critical few are your **target users**: the people who will buy the product, recommend it, and
stand to gain the most from it. They're also the people who give the most back to you in use and
sales. You cannot be everything to everyone. Focus on them and forget everything else.

### Core principles

**1. Predictability.** Labels, instructions, icons, and images set expectations. They tell us what
to do (touch this button, click this link), what will happen (open this file, drag this over here),
where we can go (a sense of place), and how the screen will respond. When we can accurately predict
the outcome, we're more confident, comfortable, and safe, and more likely to keep using the product.

**2. Consistency.** Usefulness and usability improve when similar parts of an interface are
expressed in similar ways. **Functional consistency** builds on prior experience: familiar meanings,
familiar actions, navigational reference points. It simplifies usability and increases intuitive
learning, which means **single trial learning: use it once, remember it forever.**

- *Example: Mac OS.* Window controls (close, hide, expand), button styles, and menu components are
  the same on desktop, laptop, iPhone, and tablet. Same icons, visual style, meaning, action, and
  effect. Android phone plus Android tablet shows the same thing.

**3. Progressive disclosure** (one of the most important). Everything should progress naturally
**from simple to complex**, like wading into the shallow end before diving into the deep end. That's
how the brain builds learning. Only **necessary or requested** information is displayed at any given
time, which helps people manage complexity without getting confused, frustrated, or disoriented.

That disorientation comes from **noise**. *Signal to noise* comes from radio and satellite
broadcasting: the signal you care about comes through loud and clear while static is minimized.
**Information presented to someone who isn't interested in it or isn't ready to process it is
noise.**

- *Example: a kitten-care blog on a phone.* Two articles are shown: *Three reasons my new kitten
  keeps meowing* and *Care and feeding of my new kitten*. Choose the first and it drops down with a
  small sample of the article so you can decide if it's what you want, while the other article
  **stays visible**, so your choices are still there. Enough information to choose, then a little
  more after you choose. If you care, move on; if not, go back.

**4. Intuitive.** Again, intuitive means **single trial learning**. We learn behaviors everywhere
(the web, devices, real-world places and objects), and they get called on in similar situations.
Ideally we use something once, learn it quickly, and remember it forever. In reality we often use it
a few times and hope we remember next time. So the process has to be straightforward, simple, and
uncluttered enough that we absorb it and file it away.

- *Example: icon-grid home screens.* iPhone, Android, and even early Windows phones all use
  icon-driven rows and columns, and that layout has held for at least ten years (as of 2013). Aside
  from icon style or how many fit on a screen, it hasn't changed because there's reflex and habit
  there. It's expected, predictable, and intuitive, and it will stay until something leverages an
  even greater memory (which is unlikely).

**5. Context and hierarchy.** Good information design presents components **in context** and in a
**clear hierarchy**: everything on screen is related somehow, and the organization makes that
relationship clear. Questions to ask:

- Are **functionally or logically connected** items grouped visually? Close proximity, the same
  visual styling, or being enclosed in a box all make people assume elements are connected. If you
  do any of those, they *should* be connected. If not, separate them clearly.
- Is information presented **in order of importance to the user**? Do the things they care about
  most take prominent positions, call attention to themselves, and sit higher up or above the fold?
- Does the visual hierarchy and functional behavior match what the person **expects to do first,
  second, third**?
- Is the overall layout consistent with the user's **mental model**, and is that approach used
  **consistently**?

- *Example: a health insurance site.* Prescription drugs at the top, then a big **blue bar** reading
  *Hospital services* with consistently spaced and aligned items beneath it, then another blue bar,
  *Number of physicians in your area*. Rather than just bolding a headline, the bar gives very clear
  segregation: it immediately signals a new set of information.

**6. Hick's Law.** **Every additional choice increases the time required to make a decision.** Put
another way: **the more choice you give people, the easier it is for them to choose nothing.**

> **Clay Shirky:** *It's not information overload, it's filter failure.*

As information gets more complex, people still need access to it, and designers are responsible for
making it available. But the more of it there is, the harder you have to think about letting people
**filter and narrow** what they see. **In the era of infinite choice, we need better filters.**

- *Example: a wine website.* A huge inventory with roughly 20 filters on the left (vintage, color,
  closure, and on and on). Wine connoisseurs are very specific, so that level of control is
  appropriate. **More filters mean fewer choices, which means fewer decisions**, even on a large
  data set.

---

## 32. Navigation Design

Navigation is **any part of the interface that allows people to go places**. It lets users see the
structure and is how they move through it. Think of it as **where the site map meets the design**.
Together with content and its context, it should help someone understand **where they are and where
they can go**.

It usually starts with a **site map**: an index (home) page, choices beneath it, and more choices
under those. That's where you work out how many content areas exist, how they're organized and
prioritized, how many levels deep they go, and so how the navigation has to be designed.

### The trunk test

From **Steve Krug**: you're blindfolded, thrown in the trunk of a car, driven around the city for an
hour, and dumped somewhere random. You'd normally have no idea where you are, but effective wayfinding
and signposts would let you answer four questions:

1. **Where are you?**
2. **How did you arrive here?**
3. **What can you do here?**
4. **Where can you go from here?**

Answering all four correctly means the navigation has:

- Provided a **strong sense of place**, including a general sense of how big and deep your
  surroundings are
- Set **correct expectations** about what you can do and where you can go
- Made it possible to **accurately predict outcomes** ("this way leads here, that way leads there")

Apply it at any point across the app or site. **Any "I don't know" answer means you have a
navigation problem.**

### Ways of finding what you want

- **Browsing** through a navigation system
- **Searching** with keywords or phrases
- **Filtering** large lists or information sets
- **Pagination**, which gives location information and a sense of depth (how big this place might
  be) and lets you move around a large set

*Example: Google Analytics.* A report search on the left, a clear **navigation tree** showing how
things are related and organized, and once you pick an area (e.g. demographics), controls to
manipulate and filter that screen. That's navigation on multiple levels, with several facets, each
specific and contextual to what's shown.

### Revealing depth

One job of navigation is to **reveal the depth of content before people go anywhere**:

- **Dynamic submenus** on the main nav: a mouseover dropdown, or a click that reveals a submenu.
- **Search results**: the volume of results, how you filter them, and how you move through them via
  pagination. Both provide **feedback**: information is delivered when requested, and Google's page
  numbers give an immediate sense of how much there is.
- **Indicators and context** that give a sense of place. Every element on the page, however
  seemingly insignificant, contributes. *Example:* the nav label says **How we do it**, and the page
  title says **How we do it**, not *Our process* or *Our methodology*. That's an immediate, almost
  subconscious signal that *I got what I asked for*.

### Information scent

People estimate, from what they see right now, **how much useful information they're likely to find
on a given path**. They judge the book by its cover, go down the path, and compare the result with
their prediction. **As soon as they no longer expect to find useful information, they move to another
path**, click something else, or leave for another site.

So at every level of a drill-down, people must see **evidence that what they're looking for is
there**.

- *Example: Home Depot.* *Essential products for winter* opens a large contextual menu: snow
  blowers, snow shovels, salt spreaders, ice melt and traction control, whole-house generators,
  portable generators. If I scan the list and see nothing that speaks to what I'm after, I won't click
  anything to find out. I'll probably bail.

That sounds extreme, but it's what most people do: with thousands of other sites at our fingertips,
**there's no penalty for bailing** the minute the scent weakens or doubt creeps in.

### The path is rarely direct

People meander. They follow links based on contextual relevance, interest, or whim. When they don't
know where they are or how they got there, they **back out or navigate to a known location**. That's
why people freak out without a *Home* link or home icon, and why clients ask "where's the home page?"
even though clicking the top-left logo is a well-established convention. People want that safety,
and it also tells you **something is wrong with your navigation model**. You may need more than one
way to navigate.

Nav bars aren't the only method. **Search, filters, tags, and contextual links** all help people find
information. Links inside body text (*healthcare*, an industry I'm interested in, so maybe I'll click)
may not be the primary navigation, but they're equally important. **Consider indirect paths.**

### Icons and labels

| Icon type | How it's understood |
| --- | --- |
| **Representational** | Clear meaning from similarity to familiar objects or actions. You've seen them a hundred thousand times; no label needed. |
| **Abstract** | Needs context and experience to learn. You know them from repeated exposure, not because they resemble anything real. |

If you choose an abstract icon, ask:

- How important is it that someone **recognizes and acts on it**? Will they get it immediately? Have
  they seen it before?
- Is there **additional context**, such as a label under or next to the icon, or other cues on
  screen?
- Most importantly, **is there time to figure it out?** There may not be.

*Example: an app for first responders at disaster sites* (a building on fire, a tornado, a
hurricane), used while they do their jobs. There's no time to figure things out, so abstract icons
make no sense. Instantly recognized icons, whatever their visual style, let people act quickly.

### Designing navigation that works

- **Use meaningful labels** for links and buttons. Don't be cute, and avoid esoteric terms, slang,
  and acronyms. **Call it what it is.**
- **Reduce memory load** by making navigation and links visible, findable, and informative.
- **Reduce cognitive friction.** People shouldn't have to study or decode the navigation.
  **Navigation shouldn't resemble a scavenger hunt**, and it isn't a treasure map, so it shouldn't be
  cryptic. Don't make people chase information and tools; bring them to the person, when and how they
  need them, in context with what they're doing, what they've seen, and their end goal.
- **Be consistent**: the same interactions, behaviors, and visual styles throughout.

### The "seven plus or minus two" myth

A pervasive myth says a nav menu should never have more than seven items because people can't
remember more. It comes from the article *The Magic Number Seven, Plus or Minus Two*, based on an
experiment measuring short-term **recall**: people were shown information, it was taken away, and
minutes later they were asked what they'd seen.

> When was the last time a website or app showed you something, took it away, and made you remember
> it? Never. **Designing an interactive product isn't a recall task. It's a recognition task.**

As long as people can recognize the navigation and the labels are meaningful, a large nav set isn't
a real problem. You're more likely to be limited by the device's **form factor** (monitor size,
screen resolution) than by the number of items.

### Three absolutes of navigation consistency

Navigation elements should **never**:

1. **Appear and disappear**
2. **Rearrange their order**
3. **Move to a different location**

If you do any of these, your navigation is flawed and people will have trouble. Even changing the
organization of the page *underneath* the navigation disrupts people's understanding.

*Example: a university site's top menu.* Click the first item: it highlights in dark gray and drops a
menu of categories (undergraduate, postgraduate, professional development, international students)
with gray titles and subcategory lists. Click the second: same highlight, same dropdown structure,
even with less content. Click *For business*: same again. Now I have an accurate model of how it
works, I never have to think about it again, and I can focus on content and tasks. **Set it, forget
it, focus on what matters.**

---

## 33. Convention and Metaphor

Interface and navigation design rely on **convention and metaphor** to set and keep standards.

### Conventions

The appearance and location of common navigation systems have evolved into conventions over time.

- **Tabbed navigation**, introduced around the early 2000s, got an immediate "that makes so much
  sense" and continues today. It's not the only way to navigate, but we know it on sight.
- **Left-hand main navigation** was once the norm. Then **horizontal navigation across the top** won
  out: it took less screen real estate as monitors got wider rather than taller. Now we find it
  quickly because we're used to seeing it there.

Conventions tell us **what to look for and where to look**. Standard placement means we find things
quickly; standard appearance makes them easy to pick out. A tab at the top reads as navigation. Plain
text next to the logo doesn't as easily say *that's my wayfinding mechanism*.

Breaking a convention is extremely frustrating. If main navigation moved to the bottom of the screen
tomorrow, we'd be staring at the top wondering where it went, because it doesn't match our model of
how things work. **Set standards and apply them consistently.**

### Standard web conventions

**The header:**

| Element | Expectation |
| --- | --- |
| **Site identifier** | A logo in the top-left corner; clicking it returns you home from anywhere |
| **Search** | Almost always present on high-volume sites, as a faster way to find exactly what you want |
| **Main navigation** | The core tool for getting around: all the main categories and an immediate sense of where you can go |
| **Utilities** | Almost always top right: sign in, order status, profile and personalized info, help |
| **Shopping cart** | On e-commerce, what you've put in your cart so far |

**Below the header** (especially e-commerce):

- **Left-hand local navigation** — choices within the current level and category
- **Page name** — reiterates where I am and confirms I landed where I clicked
- **Current or new feature** — something the creator wants me to see, or what I'm most likely to
  need; almost always a link giving a taste of more detailed content
- **Social proof** — driven by the rise of social media: show what other people are doing.
  *Customer favorites*, *Essential reading*, *Under $2.99*, *New releases*, *Spotlight releases*,
  *What's trending*

We recognize and act on all of these without thinking. That's the power of convention: you're
**leveraging what I already know** and matching my expectations about what things are, how they're
organized, where they sit, and how they work.

### Why conventions are valuable

- They **speak directly to habit and reflex**, and let us apply those reflexes in new circumstances.
- They often become **standards for devices unrelated to the one that started them**.
- An interface should be **consistent with other interfaces people already know**. Nobody uses your
  product in a vacuum. Your mobile app's users also use laptops, desktops, and TV screen controls,
  and all of that shapes their expectations.
- An interface should be **consistent with itself**. Once you introduce a behavior, location, look,
  or action, it should carry through every later experience.

*Example: Windows 8.* A bold new interaction paradigm in look, placement, and movement (left-to-right
scrolling), but still rooted in something familiar: **tiled icons on a screen**, a metaphor running
from the first mobile phones to the Windows desktop. So even though it breaks some conventions, it
likely still has a good chance of high adoption. The key for Microsoft is applying the new behaviors
**consistently** across the OS, related apps, and every device (laptops, tablets, phones), and
reinforcing them over and over until they become habit and reflex.

### Metaphors and affordances

For metaphors to work they must be **intuitive and obvious**. Like a spoken metaphor shortcuts
language, a **visual metaphor shortcuts how to use something**. Intuitive interfaces often use
metaphors we recognize from daily life. These are **affordances**: **visual cues for what you can
do and how you can do it.** Gaming and entertainment apps benefit greatly.

- **Virtual DJ app** — a turntable with a slab of vinyl you manipulate by hand, like the real thing.
- **Guitar amp and effects pedal simulator** — looks exactly like the real objects, with the knobs
  in the same places, so guitarists automatically know what to do.
- **Apple's bookshelf app** — your downloaded books and PDFs on a shelf, showing covers instead of
  spines. A truer metaphor would show spines, but it doesn't matter; we get it anyway.
- **Virtual wallet** — credit cards stacked like in a real wallet.

### Use metaphors with caution

They're easy to abuse:

- **Metaphors are culturally subjective.** For global products, what you take for granted may not
  be relevant to people from other cultures.
- **They require mental effort**, so they may be wrong where action must be lightning quick.
- **They can obscure a feature instead of revealing it**, especially when content and functionality
  are diverse. The more options behind a metaphor, the less reliable the guess. Usually it's simpler
  to eliminate guesswork altogether.
- **Universally understood metaphors are hard to come by.** An association that's clear to you is
  just one of many someone else might make.

*Example: the iPhone Maps page curl.* We know it now because we touched it by accident the first time
and saw what happened. With no consequence for not getting it right away, figuring it out is kind of
fun. But hide features under a page curl in a **work-related application** and it's a different
story: work tasks carry more stress, and people don't want to play games. They want to get done and
get out.

> Metaphors are helpful, but be very conscious of the **context** you use them in, and be sure they'll
> be well understood by the **majority of your users**.

---

## 34. Information Design

Information design lives **in between everything else**, tying it together. When it's good we don't
notice it. When it's bad it's really, really obvious:

- Forms that are hard to complete lead to user errors and are **costly to process** on the business
  end
- Poor instructions cause frustration, even **danger**, and can damage the provider's reputation
- Educational materials that **don't promote learning**
- Scientific and technical data that's **open to misinterpretation**
- Manufacturing command-and-control displays that **don't alert an operator** to danger
- Websites that are hard to navigate and unpleasant to look at, full of information that doesn't
  seem relevant to why you came

### The glue analogy

> The lecturer's father, a carpenter, taught him that **nails don't hold anything together; glue
> does.** The nail just holds the wood in place until the glue dries. The glue keeps the joint from
> wiggling later and makes it solid as a rock.

Good information design is what makes good UX work. Its purpose is to **present information so people
can understand it easily, simply, and quickly**. It's visual, but it's not about finished look and
feel. It's about **the effectiveness of the form**: does it communicate, is it understandable, is it
appropriate?

Think of it as **sense making**. If you can't make sense of something, it's hard, unpleasant, and
frustrating to use, and you'll stop. It also speaks to our basic need for **control**: when we
understand our surroundings and how to affect them, we feel comfortable and keep going. So good
information design supports the goals of **both the user and the creator**, who has a vested interest
in people continuing to use the product.

### Appropriate organization: context is everything

Everything we interact with is only valuable **in the context of what we're doing** at the time.
Context involves **habit**, **memory**, and a high degree of **relevance**. If something doesn't
support the task or goal, match our state of being, or fit the workflow, it isn't contextual and
isn't easily understood.

Often information design is simply grouping and arranging. It resonates when it reflects how we
think, matches what we expect, and supports our tasks, and because we're so conditioned to it, we
barely notice.

*Example: a contact block.* Shown in a jumbled order, the list is confusing. In the usual order it's
much easier: **name and job title** together, **job title and company** together, **street address**
followed by **city, state, zip**, and **phone and email** separated from everything else. We don't
consciously think about it, but it's why we can zip through forms: the fields match our context of
use.

### Five ways to organize information

| Method | Use when | Examples |
| --- | --- | --- |
| **Alphabetical** | Information is referential; you need efficient non-linear access to specific items; **no other strategy seems appropriate** (people always default to it) | Dictionary, encyclopedia; phone contacts by first or last name ("Joe Natoli" → go straight to N); general parts categories on auto-parts sites |
| **Categorical** | There are clusters of similarity or a common thread; people naturally seek information by category; large volumes that are hard to comb through individually | College catalog, statistical report; Target's departments (men's, women's, kids', sporting goods, electronics); Home Depot's *Winter essentials* / *Emergency supplies* with subcategories |
| **Continuum** (magnitude) | Lowest to highest, worst to best, smallest to largest; comparing things on a **common measure** | Search results, baseball stats; a chart of America's top ten wealthiest people growing in size and curving up to the apex; processor speeds, hard-drive space, 16 GB vs. 32 GB iPhone |
| **Location** | Orientation and wayfinding matter; information is tied to geography | Emergency exit maps, travel guides, phone maps; a historic-site map ("this pile of stones used to be a settler's cabin in the early 1800s") |
| **Time** | Presenting and comparing events over fixed durations; a time-based sequence is involved | Historical timelines; TV channel guides (DirecTV, Time Warner Cable, Hulu); IKEA flat-pack assembly instructions, step by step |

If you're struggling to organize an information set, **you can always default to alphabetical**. It
almost always makes sense.

### Appropriate form

What's the best visual representation, the one that lets people make sense of it at a glance?

**Business charts and graphs** are grossly overused, but they succeed because they show complex
information visually. *Example: fourth-quarter sales across department, discount, specialty, and
other stores.* Vertical bar chart, line plot, horizontal bar chart, or pie chart? Same data. The
question is which format explains it **most efficiently, coherently, and quickly**. Not just
readable, but understood well enough to **act on**, usually in making a decision.

### Structural form: the inverted pyramid

The traditional five-part essay (**introduction → narration → affirmation → negation →
conclusion**) works when the reader has **already committed** to sitting through 45 pages or a whole
book. That's a very different mode from someone on a laptop, tablet, or phone.

For digital, use the journalist's **inverted pyramid**: convey the most important information first.
Wherever someone stops reading, the main message has already gotten through.

| Layer | Content |
| --- | --- |
| **Most critical** | Lead with the conclusion: who, what, where, when, how. What has to be conveyed for communication to succeed. |
| **Helpful** | Additional facts and details in order of importance. Useful for the whole story, but the message survives without it. |
| **Good but unnecessary** | The weeds: details for the people who really want that level. |

It maps onto an **inverted pyramid of visual design**:

- The **most dominant elements are seen first** and usually carry the page's primary messages.
- Next, a **hierarchy of focal points**: items of equal importance grouped on a layer of equal
  visual weight, each layer with its own message. Heavier layers hold more important information.
  They stand out but **don't compete with the dominant elements**.
- Finally, **details** for those who've expressed interest.

> **Visual organization is the same thing as informational organization.**

*Example: a blog.* A large headline, a quick description, and a *Read more* or *Continue* button. You
get the dominant elements and focal points; go further if you want, but you're not forced to.

### Occam's Razor

From science: **the simplest explanation for a phenomenon is usually the correct one.** In UX, **the
simplest solution is usually the best.** Simple beats complicated, complex, and difficult.

- *Example: an over-stuffed home page.* User testing kept saying "too many things on the home page."
  The company didn't agree at first but tested versions with different user groups and turned out to
  be wrong. The redesign **removed 80% of the content**, leaving one sign-up button and one *Learn
  more* link. **Conversion increased by 300%.**
- *Example: Basecamp (37signals) vs. Microsoft Project.* At a glance Basecamp is simpler, cleaner,
  and more organized. It sacrifices functionality (Project does 101 things Basecamp doesn't), but in
  22 years in corporate industry the lecturer never saw a team use Project efficiently: too much to
  contend with, so communication suffers, updates are late, tracking and reporting slip, and
  everything takes multiple steps. Basecamp does **one thing really well**: team communication in a
  common place, shared document storage, and quick alerts when something happens. The feature list
  is about ten items long. 37signals decided from the start what they would and wouldn't do and
  largely ignored extra feature requests. Anyone who wanted those features wasn't their customer and
  would be better suited to Project.

Appropriate form means **directly answering the core needs of the people using it and forgetting
everything else.**

### Progressive disclosure (again)

Information presented to someone who isn't interested or ready is **noise**. Only necessary or
requested information should be displayed at any given time. That helps manage complexity, keeps
focus, and lets people complete the task in front of them accurately and quickly.

*Example: a blood-drive app on Windows Phone.* The first screen shows only **alerts**, three
choices: an urgent need for A B+, a B+ shortage at another location, and a general blood drive,
plus a small *More* button. Bookings, news, profile, and settings sit off-screen and come into view
with a side-to-side swipe. You deal with one thing at a time and stay on task.

### Hick's Law (again)

Every additional choice increases decision time, and the more choice you give, the easier it is to
choose nothing. When confronted with too much, we shut down. **Not because we're lazy or
procrastinating, but because we're wired for efficiency** and to maximize our resources. With
millions of Google results and seas of information, **we need better filters, more filters**.

- *Example: the wine site again.* Hundreds of thousands of wines from every country. Nobody will
  casually browse 100,000 bottles, so filters on the left (features, region, country, year, type:
  Cabernet, Merlot, Chardonnay, and on and on) let connoisseurs pinpoint what they care about and
  ignore everything else. **Fewer choices, faster decisions.**
- *Example: Twitter's home page.* Early on it was crowded: a *new to Twitter?* box, who's here now,
  top tweets, scrolling trending topics, navigation at the bottom. Nobody used any of it, either
  because nobody cared or because too many choices stopped people from deciding. Today it's
  **choose your language, then log in or sign up**, because those were the only two things people
  used the page for. **Maximize signal, minimize noise.**
- *Example: Pinterest without images.* Pinterest is organized by images, the core information and
  the reason you're there. Remove them and it becomes far less interesting and far less useful,
  because the **context of use is gone**.

> The form you choose dictates how people will use it and whether they can make a choice at all. The
> glue has to be **appropriately organized** and presented in the **appropriate form**.

---

## 35. Wireframes

A **wireframe is the skeleton of a screen.** It shows the priority and organization of what's on
screen, how people get to each part of the site, app, or system, the basic layout of all screens,
the wayfinding mechanisms, and how you'll interact with what's presented.

Wireframes reflect the designer's ideas about:

- **Placement** of elements on the page
- **Labeling** of those elements
- **Navigation**: how you get from one element to another
- **Functionality, behavior, and feedback**: what happens when I click this button or pull down this
  menu, and what choices do I have?

Think of it as a **very finished-looking rough sketch**, a way to work through multiple concepts,
like sketching in a sketchbook but more concrete and usually on screen.

> At this point you're **not making visual decisions.** No fonts, colors, specific images, or look
> and feel. Only: how much information is there, how is it organized from screen to screen and on
> each screen, and how will it all fit? **Form, arrangement, and information volume.**

### Levels of fidelity

| Fidelity | What it looks like | Purpose |
| --- | --- | --- |
| **Rough sketch** | No real content; scribbles and lines stand in for text | Work fast without the details and iterate. The lecturer does 25–30 per screen in a sketchbook just to get a sense of how much stuff and how many types of information there are. |
| **Mid-detail** | More concrete: tab navigation, an obvious title (hotel name, rating), a large hero image, boxes for more images, a form on the right | Flesh out functional details: how you interact, which controls, what they do. Still no fonts, colors, or images. |
| **High fidelity** | For a financial organization: characters per line, categories per table, grays to separate importance and hierarchy | Needed for the sheer volume of information and heavy filtering/viewing in a small space: how to show more detail without sacrificing the high-level view. **Still no visual design decisions.** |

It's normal and acceptable for the **finished design not to match the wireframe**, even in some formal
and structural decisions, because you keep learning and having better ideas along the way.

Once more, because it bears repeating: **wireframes don't show colors, typography, images, or visual
styling of any kind.** Don't wander into "what if this were red?" or "what if I used this font?" Stay
high level: how much stuff there is, how it's organized, what it does.

### Why bother with wireframes?

The lecturer gets asked this at least a dozen times a year, usually by clients eager to see what it
will look like. That's the million-dollar question on everyone's mind, but it's in everyone's
interest, the client's most of all, to call time out. Design has to consider:

- How each screen **fits with the whole** site, app, or system
- What content, links, or interactions meet **both user and business goals** (two camps to satisfy)
- How all the elements **relate to each other**: consistency, context, the signal that item A
  relates to item D relates to item Q, which can be very complex in large systems

Skip it and you'll redo the visual design at least a dozen times, and worse if design and development
run in parallel: every missed piece of information or late client surprise means tearing it all down
and starting again. **Wireframes are cheap to change.** They're just shapes and text, so a missed
feature or something the client forgot to mention three months later is quick, easy, and
cost-effective to accommodate.

*Example: a document scanning, processing, and distribution system.* Starting from the main
interface on the left, they asked what choices the person has, what happens on each choice, then the
next option, and so on: a series of offshoot windows forming an **interaction sequence**. The
wireframe was about four times longer than what's shown and was pasted on a boardroom wall. It let
them check whether they'd accounted for every aspect and action, saving a tremendous amount of time
and money. By finished design, it was **just a matter of skinning it**.

### What wireframes should tell you

- What **content** will be included
- How it's **organized**
- Which parts are **most important**
- Where a screen sits **within the whole system**
- Where users can **go** and what they can **do** there
- How users will **move around** the system: screen to screen, interactions, and workflows. It's
  the sum of all its parts.

### The wireframing process

**1. Revisit strategy.** A gut check on needs and goals from the strategy phase: Why is this valuable
to the intended user? How does it make their life better? How can I make it easier for them to act?
Which actions are most valuable on each screen and across the system? How can I measure the impact?
Every earlier decision should be revisited to see if it still makes sense.

**2. Establish cores and paths.** **Cores** are the primary content and functionality you want
people to see and interact with, the most important elements on each screen and in the app as a
whole. **Paths** are how users enter and leave each screen. Prioritize content, then define clear
paths: How do I get there? What's there for me? How do I leave for the next adventure?

The worksheet used for this:

| Area | Contents |
| --- | --- |
| **Top** | Core user needs and core business goals |
| **Center** | Core content and functionality (what's exposed, what people can do with it), plus supporting information, navigation, and outgoing paths |
| **Left** | **Incoming paths**: every place you can come from to reach this screen |
| **Right** | **Outgoing paths**: main navigation to other pages, and processes started here (e.g. a form) that lead elsewhere |
| **Bottom** | **Trigger words** (suggestions to act; key labels and concepts), **core elements** (a checklist so nothing's missed), and **calls to action** (the primary things you're asking the user to do) |

**3. Sketch.** You'll be tempted to skip it and go straight to the computer. **Don't. There are no
shortcuts.** If nothing else, sketching clears out the garbage in your head, like things you've seen
that are influencing you inappropriately, so you can think clearly. Quickly generate **thumbnail
sketches** (literally thumbnail-sized boxes for some; about three-inch boxes for the lecturer).
Spend **60 seconds to two minutes at most** per sketch, 60 seconds being the better rule. The moment
it feels overworked, move on. Don't get attached or fall in love. As a professor of his put it: *don't
think about usability, don't think about information hierarchy*. Just get as many ideas out as
possible and evaluate later. "Sophisticated scribbles at best."

**4. Prototype rapidly.** Work quickly like sketching: get initial ideas on screen and iterate,
running on instinct informed by the strategy, scope, and structure work already in your head.

- **Pick a tool that works for you:** Visio, OmniGraffle (its Mac counterpart), Balsamiq, or
  **Axure** (the lecturer's pick, since it easily turns flat wireframes into clickable HTML
  prototypes).
- **Don't use PowerPoint, Illustrator, or InDesign.** First, they're a time sink: 30 minutes in
  Balsamiq or Axure becomes three hours. Second, they **tempt you to start designing** with fonts,
  line weights, and color. Use a tool that's barebones by nature.
- **Avoid Lorem ipsum** if at all possible. Use the actual words, labels, fields, and buttons.
  **Content is just as important to the design as button placement and navigation.**
- **You're iterating.** This isn't final design or anything close. Decisions can, will, and should
  change. Build quickly, refine quickly, revise.

**5. Review.** Once you've covered at least the core parts (maybe 70% of the way there, and that's
fine), take a break and come back with these questions:

- Is anything important **missing**? Anything discussed earlier that isn't represented?
- Is the **most important content noticed first**?
- Is there anything that **shouldn't be here**? Something that made sense as a feature a month or two
  ago that nobody will care about now, or additions that overcomplicate the process?
- What content is **related**, on one screen and across screens? Do people need to navigate across
  it, or have pieces in front of them while doing another task?
- Can you get to **all major areas** from here, and more importantly, **should** you? Maybe some
  content or workflows need a specific, structured path.
- Do the **labels make sense**? Full words, not cryptic acronyms or abbreviations? Will people know
  what tabs, buttons, menus, and controls do?
- Is the **purpose of every element** clear and instantly recognizable?
- Does the **flow of tasks and information match the user's needs and expectations**? Is anything
  going to make them ask "why are you asking me for that?"
- Are **additional features or functions** necessary?

### Happy paths vs. errors and exceptions

First wireframes usually design **happy paths**: the person logs in without trouble, follows the
instructions, fills the form perfectly, sends it, and all is bright in the land. They haven't
accounted for:

- **Errors** — the form is filled out incorrectly. What feedback and correction instructions appear
  on screen?
- **Exceptions** — everything is correct, but the system freezes, crashes, or misbehaves on send.
  What do they see, what does it do, and what feedback does it give?

> Wireframes are a critical step because there's a great deal of complexity to account for, and you
> can't do it all in one shot. **You work your way up to it, improving as you go.**

---

## 36. Skeleton Takeaways

- The skeleton plane is created through **interface design** (the ability to **do things**) and
  **navigation design** (the ability to **go places**).
- Good interface design uses **progressive disclosure** to **maximize signal and minimize noise**,
  delivering what we care about most and minimizing everything else.
- A product with a poorly designed interface **will not be used**, no matter how technically superior
  the code or deep the functionality. If it's difficult, confusing, or frustrating, people bail.
- Good navigation design **reveals the depth of content**, provides a **sense of place**, and lets
  users **predict the outcome of an interaction**, which is essential to usability and good UX.
- Good information design is **the glue that holds things together**. It supports the goals of both
  user and creator, and when it fails, everything else falls apart with it. **You can't have good
  navigation, interface, or interaction design without good information design.**
- The only time to deviate from a well-established convention is when there's a **clear, obvious
  benefit** to doing so.

---

## 37. Skeleton Lab Exercise

Consider **labeling and navigation and how the two are related.**

**The task:** find the website of a **large, complex organization** with lots of pages, categories,
and subcategories, like a news site or a university site. Find an example of **particularly good or
particularly bad labeling** in the main menu system. Sub-navigation within one category works too,
e.g. *Academics* on an education site, listing all the class categories and subcategories.

Then consider:

- **Are the labels meaningful?** Do you understand the terms? Do they point you in a direction?
- **Are the labels distinct?** Is there a clear difference between them, or could two (or three,
  four, five, six) mean the same thing?
- **Can you predict and remember** which labels are under which top-level category? More
  importantly, **are you forced to remember, or is it obvious?**
- **Can you tell where you are in the hierarchy** after drilling down one, two, three, four, or five
  levels?
- **Do the navigation labels also serve as page titles?** If not, should they?

Expect to find an important correlation between **effective labeling and effective navigation**.
