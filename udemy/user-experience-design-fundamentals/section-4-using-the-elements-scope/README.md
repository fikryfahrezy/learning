# Section 4 — Using the Elements: Scope

Summary of lectures 16–22. Scope sits directly above strategy: strategy asked *why* we're doing
this, scope asks **what exactly we are going to build**. It splits into two halves — **functional
specifications** (the software/task side) and **content requirements** (the information side).

---

## 16. Defining Scope

### Why define scope at all

- **To avoid perpetual beta.** Get the train on the tracks — get into design and development
  instead of circling forever.
- **To surface conflicts and risks early.** What could derail this? What stands in the way? Asking
  hard questions up front makes the time you later invest actually productive — and a client who
  sees progress is a much less stressed client.
- **To give everyone a shared reference point and vocabulary.** If you have several registration
  flows, "the registration process" means nothing. Name it *client registration*, *manufacturer
  registration*, *advertiser registration* — now everyone knows what's being discussed. Simple, but
  critical.

> Lean and Agile discourage heavy requirements documents, and they're right that a 200-page spec is
> outdated the minute it's finished. But with **nothing** documented, the project turns into a
> snowball rolling downhill. Documentation doesn't have to be epic — a common understanding of
> features, schedules, and milestones puts the end squarely in sight.

### To know what you're building

Without documented requirements you're playing the schoolyard game of telephone — "peas" becomes
"fleas" by the thirtieth person. Two things go wrong:

- Everyone forms a slightly different mental picture of the product.
- **Everyone assumes someone else owns a critical part** — and nobody does. ("I thought *you* were
  doing that.") Defined requirements let you assign responsibility efficiently.

Seeing the whole scope mapped out also reveals **relationships and dependencies** you'd otherwise
miss. The admin side and the help documentation may look like separate features until you write
them down and realize they overlap enough that one team should own both.

### To know what you're *not* building

Ideas keep emerging — from your team, the client, stakeholders, end users — and many of them are
genuinely good. But a good idea may not support the strategic objectives, and new ideas will keep
arriving *after* the project is underway (new information surfaces, you find a third-party widget
that makes the impossible possible).

That's fine — **the earlier it surfaces, the better**. If everyone agrees it's critical and aligned
with the product's reason for being, document it, then immediately ask the ripple-effect questions:
How does this affect time? Resources — do we have people who know how to do this? Budget? Does it
mean another three weeks of development?

Equally important: separate **not at all** from **not right now**. Keep a running list (a whiteboard
with a DO NOT ERASE sign counts). Features 1–6 this month, but 4–6 won't fit — push them to next
iteration. Without the list you're guessing; the human brain can't hold all of it and charge
through reliably, and there are 80,000 miles of research behind that.

### Symptoms of an ill-defined scope

| Scope too **big** | Scope too **small** |
| --- | --- |
| Unrealistic delivery expectations (12 features by Friday, and it's Tuesday) | Unclear path to the full vision — far more questions than answers |
| **Deadlines slip.** However insignificant the date, the moment something slips, pay attention | Each release is unremarkable and watered down — eight weeks in and nothing impressive |
| Constant "can't we *also* have…?", especially mid-design/development — it means nobody knows the scope | Signals that not enough questions were asked up front |
| Designers and developers are nervous, stressed, frustrated — nothing stresses a team more than not seeing the finish line | |

### Scope creep

Scope creep is when extra ideas don't just come up but quietly **make their way into the promised
final product**. A friend calls it *death by a thousand cuts*: each addition looks like a day's
work and no big deal, but together the snowball blows past deadline barricades and budget estimates
on its way to a crash.

Resist the urge to say yes. **List it, but don't promise it** into this release or even a future
one. Table it: "we have to look into how that affects everything else."

### Trade-offs, constraints, and limitations

Michael Porter (Harvard Business Review): *trade-offs are essential to strategy — they create the
need for choice and they* **purposefully limit** *what a company offers.* Those aren't deficiencies
or things missing; they're deliberate decisions.

Both constraints and limitations are boundaries. The difference is where you look:

- **Limitation** — "I can't." You're staring at everything on the *other* side of the boundary.
  Focus is gone, energy wasted on what you can't do. Negative.
- **Constraint** — you know where the boundary is, but you're focused on an objective *inside* it.
  It eliminates options and sharpens focus. Creativity and innovation come from this. Twitter's
  character limit makes people better writers by forcing fewer, shorter words.

**Constraints are your best friend.** IKEA's trade-offs make the case:

| Given up | Gained |
| --- | --- |
| Customer service / staff in-store | Lower overhead → lower prices, and a deliberately simple, intuitive self-serve process (write down the code, find it in the aisle) |
| Preassembled furniture | Flat-pack/knock-down, all in-house products, very modern design |
| Prime downtown locations | Suburban sites with huge on-site inventory — **the store *is* the warehouse**, so it's essentially never out of stock |

Scoping a product is no different: figure out what you're gaining and what you must give up to get it.

### Product evolution: the Long Wow

Defining scope also means defining how the product evolves and stays relevant. The **Long Wow** is
delivering new experiences and **recurring delight** over time, not set-it-and-forget-it.

The contrast:

- A **pedometer** — functional, fits in your hand, records time and distance. The feature set is the
  feature set, forever. You use it the same way on day 1,000 as on day one.
- **Nike + iPod**, then the **FuelBand** — same core purpose, but new features rolled out every few
  months via the connected software: power tracks, social comparison, groups. Activity converted
  into "fuel" as a new fitness currency, LEDs running red→green toward your daily goal, and three
  companion screens with daily stats, targets, and graphs by day/week/month/year. You keep having
  the "wow, isn't this cool" experience all over again. *The economy car gets you there; the race
  car is fun to drive.*

**Four steps to creating a Long Wow:**

1. **Identify your touch points / platforms.** Pick a small set across channels that can be
   coordinated together and remixed into new solutions. The Nike+iPod sports kit combined three:
   the pedometer, the iPod, and a website — it transcends the actual event.
2. **Tackle a wide area of unmet customer needs.** Where is the experience lacking? Pick something
   you're passionate about, have competitive advantage in, and can return to repeatedly for new
   insight — new space, or an old space everyone else neglects.
3. **Create a repeatable, evolving delivery process.** Start from your existing strengths (cost/
   benefit, product quality, audience understanding) and blend them with research, prototyping, and
   design. Focus on the **impact of the experience**, not just interface usability.
4. **Plan and stage the wow experiences.** You can't build every idea at once, and nobody predicts
   the future accurately. Organize a *pipeline* of possible wow moments across your touch points,
   and let it change as you watch how people actually use what you shipped. Introducing the right
   thing at the right time has huge impact. Weight Watchers had meetings, plans, books, and web
   tools — then realized people aren't eating at the meeting or in front of a computer, so they
   built a mobile app that syncs with the diet plan.

---

## 17. Functional Specifications

Requirements can describe the product **as a whole** or a **single specific feature**, plus how
features interrelate. Level of detail scales with complexity: more features → more specification for
how each should be designed and implemented.

Best sources are **users** (people interacting daily with the existing product or the unmet need)
and **stakeholders** (who understand what must happen for value to return to the organization).
Requirements fall into three categories:

### 1. Things people *say* they need

Lots of ideas surface and many are good — but most don't make the final product. Beyond
feasibility, the reason is human:

- People make **confident but false predictions about their own future behavior**, especially with
  something new. Imagining using something and actually using it are different: one is speculation,
  and it's inaccurate precisely because there's no prior experience to draw on. **Familiarity
  changes the game completely.**
- **Preferences are unstable** — subject to emotions, the kind of day you're having, the depth of
  experience you've had so far.

You're asking people to either remember past use or speculate on future use. Either way there's no
solid precedent — just a loosely educated guess. Take these ideas with more than a couple
tablespoons of salt.

### 2. Things people *actually* need

The stated ideas are still a useful **stepping stone**. When something is hard, it's effortless to
imagine a fix — but that fix may be infeasible, or it may address a **symptom rather than the
underlying problem**. Exploring the suggestion often lands you on a completely different feature
that solves the real problem. Those long, seemingly pointless discussions are how you identify the
actual need. Back it with anecdotal evidence, research, and user observation.

### 3. Things people *don't know* they need

This is where it gets interesting. Get people talking and genuinely novel ideas surface that
occurred to no one beforehand — and those often become **core differentiators**.

Brainstorming is invaluable: a room, smart people, a whiteboard, lots of writing, crossing out, and
arguing. **The rule is there are no wrong answers.** Now is not the time to limit thinking — get
everything on the table, *then* whittle it down to what's feasible.

> **Ted Levitt:** *people don't want quarter-inch drills, they want quarter-inch holes.*

The outcome matters infinitely more than the tool's definition. We think about the problem first,
then grab whatever solves it best — possibly the drill, possibly whatever sharp thing is nearby.
So **focus the conversation on the problem**, not features, functions, or product attributes.

### Creating useful specs: user scenarios

Every discipline has a formal method, but the simplest effective approach is a **user scenario** —
a short narrative of how someone might fulfill a specific need. *Sarah has to fill out her time
sheet. Bob needs to compare service rates and delivery times for four suppliers. Jill needs to check
her calendar, see what's coming up, and make an appointment while storing a phone number in the
notes.*

Start with the person, their role, their need, and what they're trying to accomplish — heavy on
real-world context.

**Example — a CMS publishing workflow.** Boxes and arrows, left to right: an author creates new
content or modifies existing content → submits for approval → **business approver** (approve →
onward / decline → back to author) → **legal approver** (same two outcomes) → **site admin**
(approve → publish / reject). Even after it's live, the author can modify it, and the loop starts
again.

That trivial diagram yields real requirements: the author needs to create new content *and* modify
anything existing (live or not); each approver needs to review submissions *and* act on them either
way. Every role's ability to see and act on information falls out of the drawing.

Scenarios also capture **goals beyond function**: the approver needs to stay calm amid chaos and
deadlines, keep authors from getting cranky when work is rejected, keep details straight,
prioritize multiple reviews, and communicate with authors and other approvers to minimize
misunderstanding.

> **Task completion by itself does not equal success.** A workflow is only successful when it meets
> the primary *and* ancillary needs of everyone involved at every stage. That's why a scenario beats
> a strict scientific process — it accounts for more than function.

### Three rules for writing requirements

| Rule | Wrong | Right |
| --- | --- | --- |
| **Be positive** | "The system will not allow the user to purchase a fishing reel without fishing line." | "The system will suggest the user visit the fishing line page if he tries to buy a reel without line." |
| **Be specific** | "The site will be accessible to disabled people." | "The site will contain inline audio help for people with impaired vision or blindness." |
| **Don't be subjective** | "The site will be cool and hip." | "The look of the site will conform to the established company brand guidelines." |

- *Positive:* a negative requirement becomes an error message that annoys someone — "you must
  purchase fishing line to buy this reel," when the buyer already has 600 yards on a spool. You go
  from **prohibitive to proactive**, from **scolding to suggestion**.
- *Specific:* "disabled" spans hundreds of mental and physical conditions. Vision impairment only,
  or every statute of Section 508? Two very different feature sets and timelines.
- *Not subjective:* what's cool to a 44-year-old isn't what's cool to his 13-year-old daughter.
  Brand guidelines already exist — follow them. Clear and not open to interpretation.

---

## 18. Content Requirements

Content is why people come at all — everything they read, consume, absorb, and interact with. Not
just text: **images, audio, and video are content too**, and they often combine to fulfill a single
requirement (an article with photos and clips; a help section with diagrams and video). Knowing the
content types per feature tells you what resources you need to produce it — or whether you can
produce it at all.

### Three things to nail down per feature

1. **Format vs. purpose** — very different things. From Jesse James Garrett's *The Elements of User
   Experience*: stakeholders say "we should have FAQs," which describes only a **format** (a series
   of Q&As). The real **purpose** is *easy access to commonly needed information*, and other content
   can serve that purpose too. When focus lands on format, purpose gets forgotten — which is why
   FAQs so often neglect the "frequently" part and answer whatever the author happened to think of,
   helping nobody.
2. **Size** — word count, pixel dimensions, multiple image sizes, how you browse/collect them. For
   streaming: what bandwidth is required, will the host and internal servers support thousands of
   simultaneous connections?
3. **Resources to produce it** — text needs writers (professional or someone internal). Images need
   a creator, or someone to source, purchase, and hand off stock for the team to crop and optimize.
   Audio and video: who makes it, where is it stored, do we need a third-party service? **Every
   piece of content has ramifications.**

### Content should be strategic: relevant and appropriate

Is it relevant to why people came, and to your reason for being? Is it appropriate to who you are
and to the language of the customer receiving it? Relevance and appropriateness hinge on:

- **Method of delivery** — plain text on screen, animation, audio/video, watched now or downloaded
  for later, saved to the phone?
- **Style and structure** — consistent in theme, tone of voice, and factual truth? Casual or formal,
  rigid or hip — and is that right for *both* the business and the audience? Is the organization,
  flow, categorization, and prioritization appropriate?
- **Substance** — is it genuinely useful and meaningful, or is it what Steve Krug calls **happy
  talk** ("we are a leading provider of blah blah blah")? Are you talking about yourself for twenty
  minutes, or explaining what's in it for them? Most content is very one-sided. Your job isn't to
  say how great you are — it's to say **why any of that matters to them**.

### Identify and validate content sources early

Identify sources **as early as possible** — you don't want to discover twelve departments you should
have talked to six months ago and a novel's worth of content to absorb. Early identification also
lets you spot **inappropriate** content early: content that doesn't further business goals, doesn't
speak to your differentiator, that nobody cares about, or that's simply no longer true.

Then **validate everything against strategic objectives**. Content's core job is to **tell a
compelling story** — whatever the industry — if only to make people stay longer than three seconds.

> Every content idea sounds great when somebody *else* has to create it. Half of it sounds worse
> once it's on your shoulders.

If design and development proceed without validated, sourced content, you're building in a vacuum.
The walls are already up when someone says "I have furniture for 40 rooms and you built ten" — and
now you're renegotiating time and money against "you should have told us that earlier."

### Content should be contextual

People consume content inside a specific context:

- **Physical** — environment and sensory stimuli (noisy crowded office, walking down the street,
  waiting in a grocery line holding items in one hand and the phone in the other), habits and device
  preferences, learning or physical disabilities, colorblindness, hearing difficulties.
- **Emotional** — psychological state, stress level, desires and needs. There's **always some stress
  present** when someone interacts with content, because a need drove the interaction. What do they
  want from you? What happens if they don't get it — is there a consequence?
- **Cognitive** — how we absorb, what we assume, ability to learn. Does it click on first use or
  take multiple tries and reads? Is it suitable for the education and literacy levels of a narrow
  expert group versus a mass-market audience?

So content **requirements** must be contextual too — defined, specific, not open to interpretation.
Watch the progression when you keep pushing a client:

| Answer | Verdict |
| --- | --- |
| "It should sell products." | Far too vague to build a strategy on |
| "It should sell a *specific* product." | Better, but what product, and do people want it? |
| "List and demonstrate the benefits of this product." | Closer — now there's a format |
| **"Show how this product helps middle school teachers."** | **Contextual and specific** — a particular product *and* a particular audience with particular responsibilities and concerns |

### Content should be user-centered

Purpose, strategy, form, and function all revolve around the consumer's perspective.

| Wrong | Right |
| --- | --- |
| A site map mirroring the company's org chart or service offerings | A site map reflecting **prioritized user needs** — the three categories users care about, front and center |
| Using the client's internal mental models, vocabulary, and acronyms (the tech industry is riddled with this) | Matching the **user's** mental model and terms — if they call it a *screen door*, don't call it an *exterior middle door* |
| Going on about how great the organization is and how many millions use it | Every piece saying **"here's what's in it for you"** — why it matters, why it's valuable, why it pays for itself |

### Questions to ask up front

- **Who creates the content?** Us, the client, someone on their team, a third-party copywriter?
- **Who edits and approves it?** Ideally someone on the client's team — they judge appropriateness
  far more accurately than you can.
- **Who manages and updates it?** Who keeps it organized and accessible to design and development,
  ensures it's categorized the same way it'll be structured on the site — and who updates it after
  launch? Identify this so nobody assumes *you'll* do it.
- **What are competitors doing?** If a competitor holds 80% market share they're doing something
  right. Audio? Video? Lots of text? White papers?
- **Will people find this useful and valuable?** Can they act on it afterwards? Will it enable an
  understanding they didn't have?
- **How will people find it?** If the content list is novel-length, can you realistically design
  navigation deep and prioritized enough to reach all of it? Even if you don't create the content,
  be involved enough to raise the flag.
- **How many content types are there?** Each must be displayed, organized, prioritized — and
  someone has to build a platform, widget, or delivery method for it.
- **Where does each type fit in the structure?** Is video spread throughout or in its own
  navigation category? Where do PDF white papers live? Does any activity have to happen before the
  user can see or download it?
- **How will we display it, and what can people do with it?** Start/stop, rewind, forward, jump to
  sections, download the source file?
- **What are the form factor restrictions?** Desktop, laptop, tablet, phone, all of the above? Does
  every piece live on every device or do we cherry-pick? Some multimedia displays badly on a phone —
  or was built in Flash and won't run on the iPhone that makes up 80% of your audience.

---

## 19. Generating Effective Requirements

### Requirements aren't *gathered* — they're *generated*

"Gathering requirements" implies they're hanging on a tree waiting to be picked up. **There are no
existing requirements.** They're created, ideated through discussion with clients and users. You
uncover needs, then make design decisions from what you uncover.

Traditional requirements are mostly based on three unreliable things:

- **Executive opinion.** Educated guesses and hypotheses, absolutely — personal opinion, no.
- **Technology preferences.** IT may have a preference; fine, but everyone still has to ask whether
  that's the right technology for *this* problem. Poke holes in the theory.
- **What customers claim they want.** Look for evidence of **behavior** instead. Go shadow people —
  in B2B you can usually sit with the 40 people using the software for a day, and you learn more
  than any amount of conversation or educated guesswork.

"Gathering" also implies your job is **taking orders** — a pair of hands to make it pretty and push
code buttons. You're in the room because you have expertise, understanding, and hopefully empathy;
it's your job to help figure out what the requirements *should* be. Order-taking (a) devalues your
contribution, and you'll get paid according to that perceived value, and (b) doesn't get them to the
right solution — which comes back to you when it launches and misses its goals.

Without good process and tools, what stays and what gets cut is decided by **popular opinion and
political compromise**. Neither produces a good product.

### Requirements ≠ features

**Requirements are needs. Features are solutions.** In the requirements phase, state needs.

| Solution (feature) | Need (requirement) |
| --- | --- |
| "It has to be web based." | "We won't have time to install software on every PC." |

State the need first and give everyone the chance to see the opportunity and propose better
solutions. People habitually communicate needs *as* solutions — standing in the rain, "I need an
umbrella" is the solution; the underlying need is a way to check the weather before leaving, or to
keep an umbrella in your bag or under the car seat.

So interrogate everything: **is that a need, or a solution?** If it's a solution, someone handed you
a feature — and until you know the need, you can't validate whether that feature is relevant,
appropriate, or valuable.

### Four kinds of requirements

| Kind | Question |
| --- | --- |
| **Objectives** | What does the user want to accomplish? Why are they using this at all? |
| **Functional** | What must the user *do* to reach the objective? What steps, how many, multiple processes, conditional branches? |
| **Non-functional** | What constraints must it perform within? Simultaneous users, growth (200 new employees in six months), bandwidth limits. These describe **attributes**, not actions — close cousins of specifications. |
| **Business rules** | What dynamic constraints apply? Calculations, definitions, legal concerns — "we can only sell this in 12 states," "no sales tax for California residents." |

### Use scenarios

The best generator: get stakeholders (and users if possible) in a room and walk through all the
different ways someone will use the product — task A, how do they do it? Task B?

**Example — insurance agent contracting.** A prospective agent uses the website, picks a product or
a carrier, and requests a contract. Clicking that button fires an automatic email to a third party
responsible for **scrubbing the application** (checking it's accurate and correct), which then feeds
into a further abbreviated process.

Note that the goal was documenting **what happens today** — nail that down and the inefficiencies
and improvement opportunities become visible.

The questions behind a use scenario:

- Who are the users at each point of activity?
- What information do they need?
- What actions do they need to take?
- What should the system do in response?
- What will it take to make that happen? *(Client: "there's nobody to scrub the app — the system
  needs to do that." Now you know you're building something you hadn't planned on.)*
- Are there multiple approaches to the same goal, and which is better? What do we gain or lose?

### Three steps to effective scenarios

1. **Identify the types of scenarios you need.** What situations does the user find themselves in?
   What major activities happen in each? Do those activities occur together? Group them if so, split
   them if not.
2. **Develop each story.** Follow the user down the path: What actions do they take, and how many?
   **Why** do they act — what's the motivation? When and how often — once, repeatedly,
   simultaneously? What data is exchanged — what do they input, what does the system output to them
   or someone else, what's created or manipulated? And what **design principles** apply to make
   these actions simpler, more obvious, more recognizable?
3. **Communicate them** to the client, stakeholders, developers, designers, copywriters:
   - Create a **compelling narrative** — it unfolds over time and has plot points; you're telling
     the story of how people interact and what the outcomes are.
   - Make scenarios **visual, not verbal**. Seeing it conveys how many considerations, screens, and
     hours are involved; if you just stand there talking, nobody grasps the scope implications.
   - Keep diagrams **high level** — boxes and arrows. Don't get bogged down in JavaScript versus SQL
     calls; the implementation details do not matter yet. You're checking whether the scenario is
     *accurate*.
   - **Sketched storyboards** work too (e.g. a machine control on a shop floor — where the person
     stands, where their hands are, what else they're doing). No drawing skill required.
   - **Discuss afterwards.** Walk each scenario and each potential requirement, write down what's
     said (a whiteboard is fine), and let people kick it around. **Validation matters enormously**,
     and this step cements the idea in everyone's head.

### Turning scenarios into requirements

> *After a meeting, Joe pulls out his iPhone to note follow-up items, check the time and location of
> his upcoming meeting, and see if anything important has come up.*

One sentence → four requirements: enter and **save** text; view and edit a calendar; see a list of
messages pertaining to him; a portable device size.

> *Joe sees an indication that he has two emails marked urgent plus a voicemail from a client the
> phone says is top priority. After listening and confirming it's important, he selects the option
> to call the client back.*

→ see email and voicemail **in a single place**; prioritize messages by user-set criteria (the
iPhone's Favorites star assigns that priority); listen to voicemail; **return communication directly
from that message** without leaving the screen.

Tell the story, then go back through it and find the spots that translate into things the user needs
to be able to do.

---

## 20. Prioritizing Specs & Requirements

You can't do everything at once. This applies both to the whole project and to what fits in the next
two-week sprint.

### Associate requirements with strategic objectives — four questions

1. **Does it fulfill a user need?**
2. **Does it fulfill a business objective?** Is it a stepping stone to the ROI, adoption, or stated
   goals they want?
3. **How feasible is it?** Can we design, build, *and test* it with the people, time, and budget we
   have?
4. **Are there conflicts between requirements?** There's at least one on almost every project — two
   things that don't live well together. Usually an **altogether new requirement** emerges from
   resolving it. Explore these before going forward.

> **Rule of thumb: any requirement not in line with the project strategy is out of scope.** If it
> doesn't further user-side or business-side goals, we shouldn't be doing it.

### How does each requirement affect the product? Three buckets

- **Useful** — does it make the product useful to customers, to us, to partners and suppliers?
- **Saleable** — does it help sell the product? "Sell" isn't only dollars: your goal with anything
  is to get people to use it, and there's always convincing to be done.
- **Buildable** — can we affordably build it? Easy or hard? Extra resources? In line with our skill
  set?

Good strategy work should already have produced a clear hierarchy of priorities across all three,
almost without trying.

### Every force evolves requirements

Requirements must be filtered through every force acting on the product and project: **audience
needs, client desires, ethical obligations, aesthetic inclinations, material properties, cultural
presuppositions, functional requirements, time, budget, and resources** (one-man show or six bodies
to divide and conquer?).

Each affects whether you *can* include a feature and how well you'll be able to define, design, and
develop it. Don't lock yourself into the vacuum of "I know exactly what my requirements are, let's
go."

---

## 21. Scope Takeaways

- **Defining scope forces everyone** — your team and the client's — to see and address conflicts and
  rough spots **before** time is invested in designing or building. That's why the scope phase exists
  at all: spot what could derail progress early enough to adjust.
- **Users are the best source of requirements** — but what they say they need isn't always what they
  actually need, and there are things they don't know they need.
- **All content should be user-centered**, and content decisions trickle down into everything that
  follows.
- **Requirements are not gathered, they're generated** — and most of the time they're **negotiated**.
  It's a balancing act between you, the client, and internal and external forces. It's fine not to
  know everything after one hour-long session; it's a process.
- **Use scenarios are your best friend.** They generate requirements faster than anything else —
  two hours of scenarios beats eight hours of typical requirements meetings.
- **The most critical requirements align with strategic objectives.** If they don't, there's a good
  chance they're not important, because nobody understands why they're there.
- **Every force evolves requirements.** Don't set it and forget it once you have the list.

---

## 22. Scope Lab Exercise — Product Evolution Plan

Assume you'll release a digital product in **three staged releases**.

**Step 1.** List each component of your product and assign a **level of effort**: 3 = high,
2 = medium, 1 = low. Given competition, resources, time, and budget, you can accommodate a total of
**12 points across the three releases**.

**Step 2.** Group components into staged offerings that **meaningfully increase value** each time —
both to customers and to your own organization.

**Step 3.** For each release, give a **title**, a short description of what it is and its goals, the
**features** that make up the offering, and the **value to customer and to business** for each.

Worked example — an online hotel site:

| Feature | What it is | Points |
| --- | --- | --- |
| Insider guide | Expert advice, reservations, tickets, day-planning tools | 1 — nice, not earth-shattering |
| One-click reservation | Registered users reserve a room in a single click (like Amazon) | 2 — right in between |
| Dining reservations | Book at restaurants partnered with the hotel | 3 — a big deal when you're out looking for somewhere to eat |
| Wi-Fi rebate | Free hotel Wi-Fi for anyone who signs up for online services | 1 — many hotels already offer free Wi-Fi, so it's weak competitively |

**Step 4.** Plot releases 1, 2, and 3. For each stage, record:

- **Stage description**
- **Customer value** — what customer experiences happen here, what's meaningful
- **Business value** — the strategic or financial contribution
- **Points** — the functionality released in that stage

What you want to see is the **point total increasing from release one to release three** — value and
usefulness growing at each step. That's product evolution: as the product changes and upgrades, the
value to people *and* the value back to you keeps growing.
