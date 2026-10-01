# Section 5 — Using the Elements: Structure

Summary of lectures 23–29. Structure is the third plane: it defines **how you get to a given place
and where you can go once you're done there**, plus the categories of information the product
contains. Think of the mall sign with the big red dot that says *you are here*.

Two elements create it:

- **Interaction design** (task side) — presenting information so people can understand and interact
  with it in a way that matches their mental model.
- **Information architecture** (information side) — organization, labeling, search, and navigation:
  everything that lets you move through content, understand it, and sometimes manipulate it.

> **Intuitive means single trial learning.** Not "we automatically know how to use everything we
> see." It means you do it once and remember it forever. This gets repeated four times in the
> section — it's the load-bearing idea.

---

## 23. Defining Structure

Good structure organizes information in a way that provides **intuitive access to content**.

### Determining appropriate structure

Plot structure on two axes: **simple ↔ complex content** and **linear ↔ non-linear navigation**.

| Structure | Content | Fits |
| --- | --- | --- |
| **Linear narrative** | Simple | Reading a book: page 1 → 2 → 3. Training sites, teaching someone a task they've never done, unfamiliar content. Predictable by design. |
| **Mixed linear / non-linear** | Middle | Proceeds in order but you can also bounce from the top page to tier two and back to home. **Most websites live here.** |
| **Non-linear / hyperlinked** | Complex | Very flexible — 1 → 6 → 12 → 24, A → D → F → K. Great when jumping around freely is imperative, but assumes an audience that already deeply understands the content and what they're supposed to do. Otherwise it's confusing. |

So the choice depends on **who the audience is, their aptitude and level of understanding**, and
whether the content demands a rigid process or a flexible one.

### Structure must be flexible — the growth trap

Even a very linear structure has to accommodate change. Think of building a house: structure it so
that adding a room three years later is easy, even if you're not convinced you'll ever need to.

The worked website example:

1. **March** — launch with 8 pages including home. Orderly, between simple and complex, still
   flexible. This is what the audience needs right now.
2. **April** — "we forgot three pages of content." Added at the bottom level. Fine, structure still
   makes sense.
3. **June** — a stakeholder calls: new product and service, roughly fits an existing category, plus
   another new page from last month. Notice what's happening — **the site is growing deeper**, and
   the deeper it gets, the harder people have to work to find content.
4. **September** — wholesale change. Reorganize the top tier, new products in, old products out,
   support options restructured. Now you have a massive unwieldy structure and you're rebuilding
   what you already built.

By the end you're **jamming things in wherever they fit**, because technical and design constraints
are locked in and you're trying like hell not to rebuild everything.

Growth is a necessary function of any business — you can't avoid it. You don't have to know
everything you'll ever do, but in the structure phase you must consider what happens technically,
design-wise, content-wise, structurally, and navigation-wise **if you do have to deal with these
things later**.

---

## 24. Interaction Design

Interaction design describes **possible user behavior** and figures out **how the system will
accommodate and respond to it**. There's a dance between the user and the system; in a good
experience the two are dancing in step, because the user's mental models and expectations are met
by how the system responds.

Its job is to:

- Create a **meaningful** relationship between people and the things they use — it has to matter to
  them, help them accomplish a goal, fulfill a need.
- Communicate **interactivity** ("the system is responding to something I did") and **functionality**
  ("what can I do? what's available to me?").
- Reveal both **simple and complex workflows** and make both readily apparent.
- Inform people of **state changes** — I did A, B happened. File saved. Six of seven steps done.
- **Prevent user error** — an element of forgiveness. Confirm potentially destructive actions ("this
  was downloaded from the internet, are you sure?"). And when a mistake does happen, explain what
  happened, why, and what to do about it.

### The five principles

There are any number of best practices, but focus on these five and everything you do will be a cut
above most of what's out there: **consistent, visible, learnable, predictable, feedback**.

### 1. Consistent

Conventions set expectations in the user's mind. If the primary nav is a long colored bar across the
top, secondary actions sit in the top right, and search lives up there too — those three expectations
must hold on every inner page: same place, same visual treatment, same behavior.

The *content* below should change, because you're on a different page. If an inner page looked
exactly like the home page you'd be signaling "you're still where you started," which is confusing.

> **Don't be different just to be different.** Be different when it's better, when it serves a
> purpose, when it keeps the user interested — not when it confuses, frustrates, or scares them.

**Components with similar behavior should have similar appearance.** Pagination controls, primary
actions (edit cart, continue to checkout), loading feedback (progress bars for long transactions,
spinner sprites for short ones), form error messages, alert messages color-coded by severity — each
family decided once, up front, then used the same way every time.

Consistency happens in two main ways:

- **Behavior** — transitions, rollovers, tooltips all behave the same. Once I see one instance, every
  instance afterward works the same way. This is **leveraging the visitor's prior experience**, which
  is exactly how you create single trial learning.
- **Voice** — labels, terms, and language are the same throughout. Different labels mean different
  information and different outcomes. Voice also covers content and imagery: photos, illustrations,
  and icons should hold a stable, consistent style; don't mix representational icons with some other
  style.

**Design patterns** — a reusable solution to a recurring problem. A dropdown menu, a
username/password/submit login field. We accept them because they're consistent with past
experience; invent a new login design and people are confused *no matter how obvious the labels are*,
because it doesn't jibe with what they know. In a lot of cases there's no reason to reinvent the
wheel. (Search "design patterns" — there's a wealth of showcases out there.)

Content may change, but the basic interactions and processes stay the same, which makes results
**predictable**.

### 2. Visible

Opportunities to interact must be visible — people should tell **at a glance** that interaction is
available. **Discoverability should not involve chance.**

We expend the least effort possible in doing just about anything — not laziness, that's how the
brain is wired to conserve energy. So people **won't scroll without a reason or visual evidence**
that there's something down there. (Like someone in a grocery store staring at a half-folded
newspaper going "do I care? do I care?" — they either pick it up and buy it or ignore it. Nobody
picks it up and reads carefully first.)

- **Avoid false bottoms.** If the browser window cuts the layout off cleanly, there's no reason to
  think more exists below.
- **Use content hinting.** Pull content up so the bottom row of photos is **cut in half** — that
  alone signals there's more. Very subtle decisions make a huge difference.

There are two ways to interact with digital products: **click** or **tap**. We'll attempt to
interact with anything we think *could* be clickable — especially on a tablet where there's no hover
state, so we tap all over the place. Buttons that look like buttons, tabs at the top of a menu,
underlined links, different text colors, 3D objects, and icons all invite interaction.

The failure mode: a row of boxes with arrow icons that *look* like navigation — you tap expecting to
be taken somewhere, and all that happens is the picture changes. The icon and color set it up as a
wayfinding device and it isn't.

**Touch and gesture constraints:**

- **No hover on touch screens.** The dropdown-on-hover and button-highlight-on-mouseover cues that
  advertise interactivity don't exist — you have to work harder to make things obvious.
- **Left- or right-handedness.** A growing number of interfaces are reversible. If every interactive
  button is on the right, a left-handed person must reach across the interface and their hand blocks
  their view. Even right-handed, you often cover 20% of the screen reaching for something — that's
  bad design. **Anything I can't see, I can't interact with.**

### 3. Learnable

Interaction should be easy to learn and easy to remember — ideally used once, learned quickly,
remembered forever. That degree isn't always possible, so expect people to use it a few times,
learn it, and hope they remember next time. Just make it as simple as humanly possible.

**Example — mobile OS home screens.** Android's icon grid looks an awful lot like the iPhone's.
Not a point about which is better: Apple set the precedent, that device came out first, people
became accustomed to rows and columns of icons. It would make no sense to deviate from what people
recognize. They're **building on what's been done before and leveraging what people already know.**

**Example — Songza.** Instead of building playlists from songs or artists, it asks what activity or
mood you're in (unwinding, powerlifting at the gym) and recommends from there. You make one choice,
your options follow from it. You only have to learn it once.

Even easy-to-use interfaces still require learning; the more we use it, the easier it seems. We
learn behaviors from experiences everywhere — the web, devices, real-world places and objects. There
are **no clear dividing lines in human behavior**; we bring everything we know into every new
experience.

**The gesture problem.** Gestures can be arbitrary, and we're at the very beginning of figuring out
touchscreens: tap and release, tap and hold, long hold, double tap, multi-finger tap, tap-hold-drag,
single- and multi-finger drag, pinch, stretch, and on and on. Assigning all of them confuses people —
why can I swipe an image inside a window but not move the whole page? Too many ways to control one
object, with no on-screen hint about which to use. **Stick to the most common gestures and add
others only if absolutely necessary.**

### 4. Predictable

At any given moment — first screen or four levels down — the user should be able to answer:

1. **Where are you?**
2. **How did you arrive here?**
3. **What can you do here?**
4. **Where can you go from here?**

Yes to all four means your interaction design has provided a **strong sense of place**, set correct
expectations, and made outcomes predictable. Ask these four questions from the user's perspective
every time you decide what happens when someone goes from A to B. You're striving for four yeses —
not two, not three.

**Use previews to set expectations.** For new or complex interactions, show what can be done while
the interface is still loading — a high-level view of the structure, like showing a map: here's where
you are, here's everything you can do. Overlays that say "tap this to manage your sources," "tap this
to access other pages," "this row is news and analysis, this row is business" give a lay of the land
at a glance. Previews make great use of labels, instructions, icons, and images. A sense of humor
helps too ("whatever you do, don't push this button" — for setting a meeting).

### 5. Feedback

Feedback answers the burning questions in a person's mind:

- **Location** — where am I in the grand scheme of things?
- **Status** — what's happening right now, and is it still happening?
- **The future** — what will happen next if I do this?
- **Outcomes and results** — something has happened; it's done, it's ready.

The file-send example hits all four on one small screen: *your file is being sent* (status), *36%
completed* + progress bar (how far along), *please don't close this page or hit back until it's sent*
(instruction), *your file has been sent* (result).

**Every action should produce a visible, understandable, immediate reaction.** Acknowledge the
interaction — let people know they've been heard. Failing to do so leads to **unnecessary repetition
of actions**, which causes errors.

> Click Buy Now, nothing happens, so you click three more times because you're sure the system is
> ignoring you — and now you own a three-year supply of fuzzy bunny slippers you don't even like.

So the first time the button is clicked, the system has to say "chill out, we got it" — a temporary
*Got your order, we're working on it, hang tight* message.

**Error prevention is the best way to handle errors.** In messages and guidance, **complement, don't
complicate.** A good error message:

1. Describes **what** happened
2. Explains **why** it happened
3. Suggests a **fix** if at all possible
4. **Never blames the person**

Harsh, abrupt, technical language makes people assume *they* screwed something up — that's human. If
they can't understand what happened, they won't know what to do, they'll repeat the action three or
four times, get the same result, get frustrated, and probably never come back.

Good examples use humor and take ownership: "we may have forgotten to feed the wild tumble beasts
roaming inside our data center, animal control has been alerted"; "we made a mistake and now we're
dealing with its uncanny server-destroying nature"; Twitter's over-capacity message — friendly,
calming, clearly not your fault.

### How the five principles interrelate

**Consistency** helps people use what they already know → **visibility** of those familiar
opportunities invites interaction → **learning** how those interactions work is easier when you can
**predict** the outcome → and **feedback** facilitates that learning, because constant feedback on
your actions teaches you what does what.

### Marching orders

- **You are not designing for yourself.**
- Understand the goals and needs you're designing for.
- Think very hard about the design and the experience.
- Set the user's expectations for that experience.
- Don't hinder, obstruct, or interfere with the experience.
- **Try to break your designs.** Act as your own worst visitor; do things that are unexpected.
- And again: what *you* think is obvious, visible, and learnable is not what your users will think.
  **It's not about you. It's about them.**

---

## 25. Information Architecture

IA is the **organization, grouping, ordering, and presentation of content**. What's the content? How
much is there? How will it be organized? What will we call it? What's its order of importance and
priority to the person receiving it? In short: **organizing, categorizing, prioritizing** — the
creation of organizational and navigational schemes.

A good IA lets people move through content efficiently and effectively, but it's about far more than
finding things. It's also about **educating, informing, and persuading**, often in equal doses:
teaching people what the content is and how it's organized, setting expectations and then meeting
them, and motivating people to take a specific action.

An effective IA is **flexible** and accommodates growth, just like the physical structure. When you
set the buckets and name them, pick categories with a **long shelf life** as the product evolves.

### Organizational patterns

**Hierarchy** — an index page with a series of sub-pages; the model most websites are built on.

- Good for very complex structures that resemble a desktop site or system structure, where a lot of
  complexity has to be strictly organized.
- Downside: multi-tiered depth (primary, secondary, tertiary…) is a problem on small screens, where
  it's hard to see the breadth or depth of your options.

**Hub and spoke** — start at a central index, bounce out to do something, come back. Typical for
software and especially mobile apps.

- Good for **multifunctional tools** where each thing you use has a distinct navigation and purpose.
- Constraint: **users can't go spoke-to-spoke**, they always have to return to the hub. Not great for
  situations that demand multitasking (sub-task A → C → F).

**Nested** — a linear progression from a high level to more detailed to even more detailed, with the
ability to go back to the previous section.

- Provides a quick, easy method of **navigating under stress**. (Not the bad, freaked-out kind of
  stress — every interactive experience carries some stress simply because we have an objective
  we're trying to meet.) If a task has many steps, nesting gives a strong sense of **where you are
  in the process**.
- Good for apps or sites with a singular topic or closely related topics, because relationships are
  easy to see.
- Downside: a barrier to exploring. People can't quickly switch sections; they're forced down a
  narrow path and must experience A before B before C.

**Bento box / dashboard** — start in a single location and navigate out into one of many areas,
displaying portions of related tools or content on a main screen.

- The point is to give a **taste or sample** of what's available: where you can go, what you can do,
  what to expect when you get there. Key information at a glance.
- Better suited to desktop or tablet than mobile — it's complex and needs screen real estate to
  stand it all up properly.
- **Relies heavily on a well-designed UI.** A poorly designed dashboard won't be used, because bad
  design makes it hard to tell one choice from another — and then you have no sense of what's
  possible.
- Good for multifunctional tools and content-based tablet apps with similar themes. As with hub and
  spoke, think hard about how people get **back** — and note they may need to jump straight to
  another subsection rather than return home.

**Filtered view** — common on e-commerce and anywhere you search across complex information sets:
run a search, then narrow the results by attributes/filters to create an alternate view.

- Good for high-volume content. When people know the information set is dense and complex, they will
  almost always **search rather than browse**.
- Good basis for magazine-style apps/sites, or as a **sub-pattern inside another navigational
  pattern**.
- Downside: hard to execute on mobile, because exposing all the possible filters and facets demands
  screen real estate you don't have.

---

## 26. Organizing Principles

A **node** is the basic unit of any information structure. It can be as small as a single number
(a t-shirt size) or as large as an entire library (men's apparel). Dealing in nodes instead of
specific details gives us a **common language** across many different kinds of problems.

**Organizing principles** determine how nodes are arranged — which are grouped together, which are
kept separate, what's related and what isn't.

- Corporate site with top-level categories *Consumer / Business / Investor* → the organizing
  principle is **audience**.
- Travel site with *North America / Europe / Africa* → the organizing principle is **geography**.

In both cases the principle is driven by who the audience is, what their objectives are, and what
their information needs may be.

### Rules of thumb

- **The highest levels of navigation** should use the principles most closely tied to **user needs**
  (what people want) and **business objectives** (what you need to deliver).
- **Lower levels** are usually influenced more by **feature specifications and content
  requirements**.

Every collection of information has a built-in conceptual structure — usually **more than one** —
because human beings bring assumptions and associations to it. Your structure either matches those
expectations or it doesn't. A computer site *could* be organized by weight of the computer, but
consumers care about processor, speed, and cost. **The organizing principle has to match the
person's conceptual model.**

### Facets

These attributes are **facets** — a flexible set of organizing principles for just about any content.
But **using the wrong facets can be worse than using none at all**.

A common failure: exposing every conceivable facet as an organizing principle and saying "we'll let
users pick what's important." Unless the information set is really simple, the architecture,
organization, and navigation become a giant mess, and users can't pick out what matters or find what
they came for. **When users have too many options to sort through, they often can't find anything.**

> It's **our** job, not the user's, to identify the specific attributes of the information that will
> be most useful, most usable, and most valuable to the people using what we create.

---

## 27. Roles and Processes

### Who does what?

It's still common for web teams to have **nobody explicitly responsible for structure**, so it lands
in the developer's lap (unless a designer is involved). Ideally there's an **information architect**
who owns information organization and related interaction design — though that role is increasingly
being folded into design or development.

> Whether you have a specialist isn't really the point. **Somebody needs to do it, somebody needs to
> own it, and it has to be addressed as a specific, unique concern.**

### Ways to communicate structure

Methods vary with the complexity of what you're producing.

**Text outlines** — for high-volume content in a strict hierarchy, a basic outline of major
categories, sub-categories, and their sub-categories is often all you need.

**Visual vocabulary** — a diagramming system coined by **Jesse James Garrett** (author of *The
Elements of User Experience*). A simple version shows a home screen with categories (media,
products, support) and their content underneath: visual, straightforward, and clear about what's a
subcategory of what and how things are prioritized.

**Visual vocabulary for interaction variables** — the same notation, diagramming flows and
conditions rather than just artifacts. Example: continuing from the home screen → login page →
either success (regular login flow → latest news) or failure (wrong username/password → back to the
login page to try again). That's a **condition/variable**. From latest news, a **conditional
selector** marks options available *as a result of* landing in that section — e.g. technical papers,
or continue on to a member list. You're documenting not just pieces of information but **the flows
and processes that get you to them**.

**Hub and spoke diagrams** — for high-volume content in a hub-and-spoke setup: a central hub (e.g.
*producers*) with its related spokes, some of which have multiple areas and choices, and sometimes
**sub-spokes** you venture out to and come back from.

**Decision path** — reads left to right, starting with **who the audience is** (e.g. a prospective
insurance agent). When they hit the first screen, ask: what questions do they have, and what do they
need to do? (*How do I get contracted? What products can I sell? What are the ratings for these
products?*) Moving right, you expose what choices exist within each option. What do I need to see,
how does that motivate me to act, what might I do next?

> Whatever the format, diagrams should always focus on **relationships between content**: which
> categories go together and which don't, how the steps in an interaction sequence fit together, how
> people move through the information, how *we* expect them to — and how *they* expect to.

The critical part is that you **document it in some way**, so you can think the process through.

---

## 28. Structure Takeaways

- Good structure organizes information to provide **intuitive access** to content — and **intuitive
  means single trial learning**. Do it once, remember it forever.
- Structure is created by **interaction design**: presenting information in a way people can
  understand and interact with.
- Structure is also created by **information architecture**: the combination of organization,
  labeling, search, and navigation systems within a digital product.
- Structure should be **appropriate for the audience** and **flexible to accommodate change**, which
  is inevitable.
- Specialist or not, **somebody needs to own it**.
- Above all, **focus on the relationships between content**. Which categories go together and which
  don't? How do the steps in an interaction sequence fit together? What makes sense for completing
  the task at hand — and what will make sense to the user based on their expectations and prior
  experience? How can you leverage that?

---

## 29. Structure Lab Exercise

Assume you have the **same edition of a newspaper in two forms**: an online version and a printed
hard copy in your hands.

**The task:** how would you look for updated news about the trial of a famous athlete from a country
other than your own — in each version?

**Write a narrative of the process:** what you do first, second, third, and what you're thinking as
you do it. Then consider:

- Which process let you find the information **more easily** — online or offline? Why?
- Did that same process let you find it **more quickly**? Was one faster than the other?
- How could **each** information architecture be modified for more speed, efficiency, or ease of use?
- What **significant differences** do you see between the IA of the online version and the printed
  copy — in how information is organized, structured, and prioritized?

Expect to find that the **context of use** differs significantly across multiple areas.
