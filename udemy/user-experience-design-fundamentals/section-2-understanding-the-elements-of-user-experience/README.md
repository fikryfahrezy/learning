# Section 2 — Understanding the Elements of User Experience

Notes from the three lectures in this section. The whole section is built on
Jesse James Garrett's book *The Elements of User Experience* (Garrett founded
Adaptive Path, a UX firm in San Francisco).

---

## 5. The Elements of User Experience

The core idea: **no part of a user's experience should happen by accident**.
Every possible path, action, and expectation is accounted for on purpose. That
is a huge task taken as a whole, so it gets broken into **five planes**.

### The five planes (abstract → concrete)

| Plane | What it covers |
|---|---|
| **Strategy** | Why the site/system/app exists at all — why we built it, why people need it |
| **Scope** | The features and functions the product contains |
| **Structure** | How many places you can go, organized in the context of use |
| **Skeleton** | Optimized arrangement of on-screen elements (nav, content, controls, buttons, menus) — within a screen *and* across the whole product |
| **Surface** | What the user actually sees and touches: pages, images, text, interaction, animation |

Each plane builds on the one below it, moving from "what are we doing, why, and
for whom" up to something a person can see and interact with.

### The split down the middle

The planes are also split into two columns, reflecting the dual nature of the web:

- **Task / software side** — technology and interface. How does the user get task
  A, B, C done?
- **Information side** — content. What information do we serve up, and what does
  it mean to the people using it?

### Elements per plane

| Plane | Task / software side | Information side |
|---|---|---|
| **Strategy** | *User needs* + *Business objectives* (spans both sides) | |
| **Scope** | Functional specifications | Content requirements |
| **Structure** | Interaction design | Information architecture |
| **Skeleton** | Interface design | Navigation design |
| **Surface** | *Visual design* (spans both sides) | |

- **User needs** — what the audience wants, expects, and needs to do, and how
  that fits their other goals.
- **Business objectives** — success metrics. Make money, save money, or gain
  something.
- **Functional specs** — what the product offers and is able to do.
- **Content requirements** — what data/information must be served up for people
  to manipulate.
- **Interaction design** — how the system behaves when someone does something
  (click a link → what do I get?).
- **Information architecture** — arrangement of content across the whole product,
  how much there is, how deep it goes.
- **Interface design** — arrangement of buttons, menus, tools, controls.
- **Navigation design** — how the user moves through information. I want to know
  where I am, where I can go, and often where I've been.
- **Visual design** — the look of the finished product: fonts, colors, and how
  they reinforce structure, navigation, direction, and feedback.

---

## 6. Exploring the Elements of User Experience

A deeper pass through each plane.

### Strategy — the foundation

Products rarely fail because of technology, and not always because of UX. The
most common cause of failure is that **nobody answered two questions**:

1. What do we want users to get out of this?
2. What do we want to get out of it?

Obvious questions, routinely skipped.

**User needs.** Who are they? What are they typically doing while using the
product? Where do they live, what do they like and hate, what are their cultural
and social references, what's their work environment? All of that imposes
constraints and gives direction.

- What is their *core need* that we exist to satisfy?
- How does it fit with their other goals and the **context** of the activity?
  Example: timesheet software competes with everything else filling the user's
  day — nobody enjoys it and nobody has time for it, so it had better be easy.

**Business objectives.** What defines success — making money, saving money, or
both? Some return on an investment of time, money, or effort. The key question:
**how will we know when we've succeeded?** Traffic targets? Monetizing visits?
Ad residuals? Popularity? Define success up front *and* decide how to measure it.

### Scope — turning strategy into requirements

Two concerns: **functional specification** (what's our feature set?) and
**content requirements** (what information, where does it come from, how much is
there, how do we identify and serve it?).

The lecture uses the classic "tree swing" joke — how the customer explained it →
how the PM heard it → how the designer designed it → how the engineer built it →
what the customer really wanted. Extreme, but not uncommon: everyone has their
own language and mental models, so people leave the same meeting with different
ideas of the end result.

> Strategy becomes scope when user needs and business objectives are turned into
> explicit requirements for content and functionality.

That gives everyone a shared benchmark. Content in particular must be defined —
without it you have no idea of the size, depth, or effort the project requires.

### Structure — user action, system response

**Interaction design**: what happens when someone clicks a button, opens a menu,
submits a form, goes through checkout? Think of it as **call and response** —
patterns and sequences of options and feedback at each stage.

**Information architecture**: how much content is there and how is it organized,
not just per screen but across the entire product. Hundreds of screens means
serious IA challenges.

### Skeleton — what actually goes on screen

**Interface design** arranges the visual elements people interact with.
**Navigation design** is the "means of transportation" from A to B to C and back.

The work here is figuring out how much goes on screen, how to segregate and
organize it, and how to communicate every available option — all in a space
roughly "the surface of a cup of coffee."

Navigation should be **intuitive**, which means two things: it's obvious, and it
**matches the user's mental model** of how to move through the information.

### Surface — visual design

The most concrete expression of UX design, commonly called "look and feel."
Made up of **colors, images, typography, and effects**.

- **Visual choices should never be arbitrary.** They serve specific goals and
  reinforce the meaning of the content.
- Communication happens through words, images, colors, and interactions together.
- Visual design does **wayfinding** — like a good map in a large city.
- Good visual design **reduces cognitive load**: *recognize more, remember less*.
  Recognition → understanding → use.
- Choices must be **culturally and socially appropriate** — not just nationality.
  You wouldn't design for investment bankers the way you'd design for a heavy
  metal record label. Design often fails because the creators don't understand
  the user's culture.

---

## 7. How the Elements Work Together

### The planes are interdependent

Surface depends on skeleton → structure → scope → strategy. When choices on one
plane don't line up with the plane above or below, deadlines slip, schedules
fall apart, and costs rise because the team is forcing together things that
don't fit. Even if they ship it, people probably won't like it.

> Decisions on the strategy plane ripple all the way up. Get strategy wrong and
> you pay for it for the life of the project.

### Every decision constrains the next plane

Choices on one plane are limited by decisions made on the plane below. If you
had five options on the structure plane and you pick one, you may now have only
three on the skeleton plane. **Every decision enables some options and disables
others** — stay aware of the tradeoffs.

### Stay flexible — don't set planes in stone

You'll keep looking back and asking whether an earlier conclusion still makes
sense in light of what you just learned. A visual opportunity at the surface may
send you back to question a piece of functionality at the structure plane.

Better approach: **let work on each plane finish while work on the next plane is
already in progress**, rather than completing each plane in a vacuum. That way
decisions inform each other in both directions, and you don't build the roof
before you know what the foundation looks like. Things then progress from simple
to complex, as they should.

### Additional factors

**Root causes are messy.** It's often hard to tell which element is responsible
for a UX problem. Inappropriate visual design? Broken navigation? A browser
misinterpreting the code? Sometimes it's several things at once. Diagnosing it
takes patience and relentlessness.

**Content is still king.** Content is why users come in the first place — nobody
reads a magazine for the ads, and nobody opens an app for the joy of
well-organized information architecture. They come hoping to find relevant
things. So we need ways to catalog, track, and present content *when, where, and
how people want it*. From the user's side it's self-centered by nature: what are
you doing for me, does it make sense to me, does it respect my time, do I gain
something?

**UX sits at the intersection of design and development.** On one side visual,
graphic, and interface design; on the other front-end, business logic, and
back-end work. User experience has always lived in that intersection even before
it had a name, because the sum of both sides determines whether the result is
positive or negative for creator and user alike.

**Appropriate technology is part of UX, from day one.** The right platform is
critical to delivering the experience, so technology belongs in the *strategy*
conversation — not tacked on at the end, not a "nice to have." Analogy: learning
guitar — knowing the notes, chords, and patterns gives you a bigger repertoire
because you have a solid idea of what's possible. Technology is what lets UX
extend across operating systems, browsers, devices, and form factors (screen
sizes). Touch interaction — tap, swipe, pinch to zoom — changed how we deal with
digital information, so **you have to think beyond point and click**.
