# Section 7 — Using the Elements: Surface

Summary of lectures 38–45. Surface is the top plane — the things you actually **see**. Like the
other planes it has a software/task side and an information side, except here **visual design spans
both**:

- **Task side** — visual design determines whether something is obvious, intuitive, and quite
  frankly, whether it's used. The appearance of components, controls, and content gives you a clue
  as to what you can do with them and how you can interact with them.
- **Information side** — visual design makes things easier to understand. It increases your ability
  to absorb what's on the screen and minimizes the effort required to read and comprehend it.

> **Visual design is not decoration.** Decoration is purely aesthetic — it has visual impact, but it
> doesn't explain, clarify, or help anybody do anything. Forget about how things look; ask how your
> visual design choices **work**.

---

## 38. Defining the Surface

### Visible language

What we create on the surface plane is **visible language**: all the graphical techniques used to
indicate context and convey information.

| Technique | What it covers |
| --- | --- |
| **Layout** | Formats, proportions, grids, organization — the underlying structure that determines what elements live where on the screen. |
| **Typography** | Font selection and styling — which fonts, and are they bold, italic, large, small. |
| **Color** | Influencing perception and emotion. |
| **Imagery** | Signs, icons, symbols that communicate or signal use; also photography and illustration that reinforce the context of use and the subject at hand. |
| **Sequencing** | An overall approach to visual storytelling. From screen to screen a narrative unfolds, much like a movie — almost anything interactive has film-like qualities, so proper pacing and sequencing apply. |
| **Visual identity** | How the organization or product line expresses itself. Is the brand conservative and refined? Cutting edge? Wild and innovative? Every visual decision communicates this, so be judicious. |

### Three principles of good UI design

1. **Organize** — give the user a clear, consistent conceptual structure of how the thing works.
2. **Economize** — do the most with the least amount of cues. Do more with less, keep it simple.
3. **Communicate** — maybe the most important: match the presentation to the **expectations and
   capabilities** of the user. People arrive already knowing what they want and with a preconceived
   idea of how it will unfold; the design has to reveal that those things exist, and create visual
   cues that let people get in and automatically start understanding how the system works.

### Organize: clear visual hierarchy

A clear **visual hierarchy** enables consistency, signifies relationships between elements, and
improves navigation. It establishes an order of importance — *this first, this next* — that should
ideally match the order of importance the user brings to the situation.

A screen with lots of different sizes and overlapping, intersecting elements might be artistically
interesting, but it's a recipe for disaster for someone trying to accomplish a task. When elements
have a strong visual relationship to one another, you can see at a glance how much there is, which
elements are related, and what each type of content is. The brain's job is to comprehend and make
connections — the more effort you put into ordering elements logically, the more useful and usable
the interface.

### Economize: only what's critical

Include only elements critical to communication and immediately relevant to the task at hand. The
most important elements and actions should be easily perceived; anything non-critical should be
**de-emphasized**.

**Example — the simple inline form** (pick one item from a list, then OK or Cancel):

- **Before:** a title, radio buttons with labels, items five and six centered at the bottom in their
  own little world instead of aligned with either column, and two same-sized, same-weight buttons
  crowded into the bottom right. It's easy to assume a radio button and its label are one item, but
  the brain perceives each separately. Count: **15 elements**.
- **After:** the title sits in a gray bar, clearly a descriptor rather than a choice. The options
  become six boxes in two columns of three; the whole box highlights gray when selected (versus a
  tiny circle). The primary action, **OK**, is larger, darker, and a button; **Cancel** — a secondary
  action — is just a text link. You didn't come to the page to cancel the form. Count: **9
  elements**.

Not consciously, but cognitively, people do process all 15. A couple of extra minutes per form isn't
much — across 40 forms in a large application it's a significant chunk of time. Every element adds
to cognitive load; minimize it.

### Communicate: a balancing act

Every element either enhances understanding or creates confusion. Visual design balances
legibility, readability, typography, symbolism, multiple views, color, and texture.

**Font use** is one of the most important decisions you'll make, because on screen we read, scan,
interpret, and act. It doesn't have to be complex — just make sure fonts are easy to read.

**Pattern recognition** is why. You recognize the letter *A* in many very different styles because
you've seen that pattern — two upward lines bisected by a horizontal line — so many times; the brain
goes "seen that before" in milliseconds. Get too decorative and you interfere with it:

- **Plain Arial default text** — characters recognized instantly, very easy to read.
- **Slightly more decorative font** — still readable, but a tiny fraction slower.
- **Extraordinarily decorative font** — the pattern is abstracted, less recognizable, less readable;
  you have to work to interpret it.

In fine art that's acceptable, even desirable; in interface design, where the goal is to
communicate, it isn't. **Always err on the side of simple, legible, readable, clear, and
recognizable.**

### Design is not decoration

- Visual design should **never be based on personal preference.** The instructor has designed
  hundreds of things he personally didn't care for — they were appropriate to the audience and
  expressed the brand. *I'm designing for them, not for me.*
- Visual design should **never be based on what looks cool.** If someone asks why you chose that
  color, font, image, or big red bar, the answer should never be "because it looks cool." Cool
  doesn't communicate, doesn't help anyone understand, doesn't help anyone accomplish a task.

Ask instead:

- Does the visual design **support established objectives**?
- Does it **clarify the options** available?
- Does it provide **context and guidance** — how things relate, what I can do, what's next?
- Does it establish **clear information and action priority** — so I can predict the outcomes of my
  actions?

---

## 39. Visual Design Principles

There are hundreds of principles, but **the big four** organize visual information: **alignment,
proximity, repetition, and contrast**. They underlie everything we see — on screen, in print, on a
billboard. They're intimately interconnected: you'll almost always use some degree of all four (at
least three). When a design isn't working, usually one of them is missing or misapplied.

### 1. Alignment

Quite possibly the most important — and the rule broken most often. Proper alignment alone makes
designs infinitely more useful, usable, and understandable.

**Tracking text.** We read like an old typewriter carriage: left to right, then return to the left
and start the next line (in English; some languages read right to left). A **consistent left point
to track back to** is what lets us read multiple paragraphs extremely quickly.

With centered text the tracking points are all over the place, so you have to work to find the start
of each line. Comprehension slows and eyes fatigue faster — people get frustrated and stop reading,
often without being able to tell you why.

> **Don't center text ever.** Maybe a single headline or single element — but when you've got
> paragraphs, do not center text, for any reason. "If I had a nickel for every time I've seen this
> approach used, I would be retired, living on an island."

**Alignment in a busy layout.** On a crowded client page (a Nexidia layout), many different things
align with other things — the left edge of a paragraph with the edge of the iPod graphic below it,
the right edge of the *A* in the logo with the left edge of text, the **baseline** of *call centers*
with *user needs* and *events*, a left rule with the top of an image and the top of text. They
aren't all the same element aligning with the same element, but they create clear visual paths for
the eye.

**Alignment provides cognitive stability.** Every element should align with one or more other
elements. Align everything — look for relationships even across opposite sides of the screen, and
if two things are close, adjust both so there is one.

**Example — the 2000 U.S. presidential ballot.** Choices on the left and right, all the punch holes
down the center, holes too close together. It isn't clear which hole goes with which choice.
Consider what followed: double votes for candidates almost directly across from each other; an
improbable number of votes for Pat Buchanan — the most conservative of the conservative — in very
liberal Palm Beach County; and counts that were wrong, recounted, and still didn't match. A
redesign where each candidate is perfectly aligned with its selection area gives a **1-to-1
correlation** — no confusion. It shows both the power of alignment and the potential consequence of
not designing properly.

### 2. Proximity

> **Elements that are visually close to each other are perceived as a single group, related to each
> other.** The assumption is automatic and unconscious.

In the example layout: the four *design and dev* items on the left read as one group; the forward
and back arrows on the top menu form a single chunk (they're controls); the three articles share a
space so they're related; the black voting bar, with lots of space around it, stands on its own
like a banner ad.

The failure: the **Discussion** headline has equal space above (to the black bar) and below (to its
snippets), so it stands on its own — but it belongs to the snippets. Move it down closer to them.

Unrelated items are separated by negative space, have different alignment paths, or disrupt an
existing path. Grouping navigation, featured content, resource links, footer items, and so on makes
each form a whole.

**Example — the contact form.** In usability testing, forms with a big gap between label and field
take longer and people struggle: the labels read as one element and the fields as another, and the
gaps aren't even consistent (*preferred contact number* to its *home* dropdown vs. *work* to its
field — "a football field"). Better:

- Put the **label immediately before its field**, everything left-aligned so you track straight
  down. The **Register** and **Close** buttons move closer because they're related (and Close gets a
  less prominent color because it's less important).
- Or put **labels on top of the fields** — for short forms, testing shows people complete it faster
  and with fewer errors.

Either way, proximity emphasizes the **horizontal pairs**: label goes with field.

**Negative space creates proximity.** It's the space between graphics, margins, gutters, columns,
lines of type — and usually what determines whether things feel close. It **enables focus**; it's
not dead or blank space. In a layout with lots of air around the navigation and the product image,
you can easily shift focus to each part.

> When working in quick iterations with developers: "Give me 20 pixels of padding between every
> single element, and then I'll adjust from there." Start with 10 or 20 pixels and tighten later —
> but always start with a decent degree of negative space.

### 3. Repetition

Not rubber-stamping the same elements over and over — something subtler: **echoing** other parts of
the layout to create **cohesiveness**.

- The main nav's background color and font styling are repeated in the **Learn more** button (same
  background, same font, different font color) and in a sub-nav bar (same color, same font in
  different sizes and configurations).
- The *Shopping Cart Development* headline style is repeated in later headlines and *Request a
  Quote* — same font, echoing the color of the word *cart*, and echoing the orange of the background
  even though that orange doesn't appear in the headline itself.
- **Form** repeats too: circular icons up top echo the circles under the shopping bags (used there as
  slideshow controls). Gray from the top nav reappears in the sub-navigation; orange from the
  background appears in text.

**Design patterns** implement repetition. Once look and feel is settled, apply those styles to every
graphic element, control, and button. The **iPhone** visual templates, **Windows 8**, and **Android**
all have established pattern sets — repetition across font styles, color, visual behavior, icon
style, highlighting, buttons, fields. Elements don't look exactly alike, but as a whole they look
like they belong together, and they give you patterns to reuse for new features and apps.

### 4. Contrast

Like alignment, one of the most misused principles — and one of the most important for making things
instantly recognizable, useful, and usable.

| Combination | Result |
| --- | --- |
| **Black on white** | Stark — you can't get more contrast. Text leaps off the background; almost no eye strain. |
| **White on black** | Not any harder to read. The idea that white on black is hard to read is a myth; a design where text is the brightest element can reduce eye strain by focusing attention. |
| **Low contrast** (colors too close) | Strains the eyes — the cones and rods can't decide which color to focus on, like a camera autofocus hunting in and out. |
| **Two bright complementary colors** (bright pink on bright yellow) | Complementary doesn't mean appropriate. Both too saturated and intense; the eye still strains. |

**Contrast draws attention.** On a dark gray background, a slightly lighter bar up top gets your
focus; add a pure white element below and focus moves there. That's **three stages of attention**:
white first, top bar second, background last. A headline in a shade of the background color frames
your view; text on the white area keeps pulling your eye back to the center. So you now have
information priority and hierarchy.

> Be cognizant of which areas have the most contrast, because that's where attention keeps being
> drawn. If the important element is lower right but the most contrast is upper left, that's a
> problem.

**Examples:**

- **CNN** leads with a red banner across the top; its vibrancy against the white below stimulates
  heightened emotion — an emergency color, but it's really the contrast doing it. With black in the
  images below, **black, red, and white is the ultimate contrast combination** (not that every
  design should use it — be aware of how those colors interact).
- **GOOD** uses color very sparingly with exaggerated negative space — a much calmer approach that
  decreases urgency and invites you to take your time. Contrast still used, very differently.

No hard rules on a lot vs. a little — but the degree of contrast profoundly affects how people
interpret and cognitively perceive what they see.

---

## 40. Following the Eye

Where does the eye go first? Is that first object of attention the most important thing to the user,
or a distraction from their goals? And — since there are business goals behind every design — **is
it what you want them to see first?**

### F pattern and Z pattern

Two patterns come into play in almost any visual cognition (reading, looking, scanning). They're
common because they're a layout convention born of standard practice in print and on screen, and
because we read top to bottom, left to right.

- **F pattern — Los Angeles Times website.** The eye starts at the left of the navigation, scans
  across to the right end, then drops to the large photo in the middle and moves straight across to
  the next big block — **an ad**. That's no accident: the designer knows the eye goes there. Then
  down again, and across to the entertainment headline and photo on the right. Across, down, across.
- **Z pattern — Kickstarter.** A large image in the middle with content below. Start top left
  (ingrained habit), go across and right, take in the photo and headline, then go **diagonally back
  down** to the next corner (*Staff picks: Music* and its image) and read left to right again.

Next time you're on the web, try to spot F and Z patterns — they occur more often than you'd think.

### Why eye flow matters

These patterns don't happen by accident; eye movement is an ingrained, instinctive response. When a
design works, the pattern has two qualities:

1. **The eye moves in a smooth flow.** When someone says a design is **busy** or **cluttered**,
   they're really saying it doesn't lead them around the screen — there's no instinctive path, so
   they're stuck and can't get started or get through.
2. **It gives a guided tour of what's available without overwhelming the user with details.** The
   choices exposed must all support the goals and tasks the person is trying to accomplish.

### A caution on eye-tracking heat maps

Heat maps are cool and innovative, but not totally accurate. Eye tracking records **foveal
fixations** — the smallest, sharpest part of the visual field (think camera autofocus). It doesn't
record **peripheral vision, which makes up 98% of our visual field** and is absorbing everything
else all the time. So the studies don't represent everything participants see.

> It informs behavior and shows focal points, but it doesn't tell you how people move through
> information or how much they absorb, understand, and act upon. **One piece of the puzzle, not the
> complete solution.**

---

## 41. Contrast and Uniformity

Lack of contrast makes the eye bounce around without settling; it gives the impression that
everything is equally important, so nothing stands out.

### Three functions of contrast

1. **Draws attention** to the essential components — the most important options and activities.
2. **Clarifies relationships** between navigational elements and content — how I get from A to B,
   and what I can expect to find at B.
3. **Communicates hierarchy and importance** within and across sets of information — what's primary,
   what's relevant but not necessary. It establishes **information priority**.

Contrast creates visual differences, and we pay attention to differences.

**Examples:**

- **Error message** — red and white against everything else makes it disruptive and interruptive; it
  demands focus until you deal with it. That's exactly what a good error message should do.
- **Online retail promo** — a large spring/summer apparel image contrasts sharply with the white
  background (not hard black-and-white, but it stands out) and, with its size, gets attention first
  — what's potentially most important to the shopper *and* what the retailer wants you to see.
- **Confirmation dialog for a destructive action** — "if you do this, you'll never get it back." The
  background is grayed out: a **modal dialog box**. It's widely adopted because it focuses attention
  on the issue at hand.

### Uniformity

**Uniformity** enables contrast and change while keeping certain elements from overwhelming people.
When content changes — a new screen, the next step in a sequence — some things should stay the same,
giving stability and security.

> Like following a path in the woods with markers at consistent intervals — they reassure you that
> you're on the right path.

**Example — Capgemini.** An underlying grid of six main sections. The large photo and text on the
left, three content areas on the right, and a focus piece at the bottom all change — but the grid,
navigation, featured area, the three right-hand slots, and the bottom feature always stay in the
same place. Familiarity keeps us comfortable while content changes.

Uniform design elements can also be applied consistently and **recombined into new designs** as the
product grows — a precedent of established patterns. The **Android** controls (icons, sliders,
keyboard, field highlighting) are used the same way throughout the OS, so new features next month
look and work the same, and users build on prior experience.

---

## 42. Consistency

> Consistency is **what makes a system a system** — it unifies disparate screens, features, and
> functions so we perceive them as part of the same whole.

It lets people build an **accurate mental model** of how the product works and leverage prior
experience. It also **reduces training and support time and cost**: if prior knowledge lets me grasp
60–70% of what's in front of me, someone spends far less time explaining it — and formal training
and support programs cost organizations money.

### Evaluating consistency

- Are **buttons and controls placed** consistently?
- Is **language** consistent in labels and messages? Full words, or cryptic abbreviations only
  insiders understand? **Acronyms** especially — tempting to use, but most people have no idea what
  that series of capital letters means.
- Are **font styles, images, graphic elements, and color schemes** applied consistently on every
  screen (same fonts for headlines, subheads, body)?
- Are buttons and controls **displayed** consistently? Is the primary action always a big red button,
  or on screen three is it suddenly an orange circle?
- Do buttons and controls **respond** consistently? If clicking a button took me to a new page, I
  expect that next time; if I get a pop-up instead, that's a disconnect — no matter how obvious the
  pop-up's content. **Every inconsistency introduces doubt** about whether I'm using the system
  properly.

### External inconsistency

Different products **within one product family** reflect different design approaches.

**Example — iTunes on iPhone vs. iPad.** On the iPhone (playing *Trouble Comes Running* by Spoon):
time and duration up top, play controls at the bottom, volume at the very bottom. On the iPad: play
controls at the top, a very different duration/time control, volume at the top, and a whole new set
of menu items at the bottom. The instructor had used the phone for four years before getting a
tablet — "like walking into your house and finding that someone has rearranged all your furniture in
the two hours that you were gone."

The artist list is the same story: a simple alphabetical scrolling list on the iPhone (like
contacts), but suddenly all visual on the iPad, requiring a change of orientation and viewpoint to
get back to something resembling the familiar display.

> No matter how popular Apple may be, this is still a mistake. **Introduce change in increments.**
> Wholesale change for its own sake, with no relationship to existing mental models, just frustrates
> people — and when they have other choices, they'll use them.

### Internal inconsistency

Different parts or screens of the **same** application, system, or site reflect very different
design approaches.

**Example — Goucher College website.** Within 3–5 seconds you get the lay of the land: navigation
up top, sub-nav on the left, photos, tour, campus handbook, social media. As an alumnus you click the
**Alumni** link at the far right and get something completely different — nothing familiar relates
to where you came from. The immediate reaction: *Where am I? Did I click the right thing?* — enough
to hit Back.

The team's reasoning ("alumni are a different audience and should have their own corner of the
universe") isn't inaccurate, but visually, to us, it's a completely different website. In usability
tests people click a link, hit Back, click it again, hit Back again. **If one out of 300 does it,
it's an accident; if 200 out of 300 do it, something's wrong.**

The same applies to a private section behind a login: it can't just look different. It has to carry
some of the same elements and structural organization — some flavor of where the person came from —
so they don't feel they made a mistake.

---

## 43. Color and Typography

### Color matters

Color has associated meanings that create **emotional responses**, which drive people to do either
what's intended or what isn't. So color must be used **consistently** (to prevent confusion in
meaning) and **appropriately** (to get the desired emotional response).

**Example — a sleep meditation app.** No stark contrast, no black and white, no bright day-glo
colors — a peach-orange, a tan background, a baby blue header, and a friendly, welcoming typeface
saying *Sleep goals*. Everything is sedate, subtle, pleasant: color in line with the intended calming
response.

What the right color does:

- **Draws the eye** to the most important areas.
- **Maximizes readability and minimizes optical fatigue** — when contrast and saturation are
  balanced, background and text are easy to tell apart.
- **Delivers symbolic meaning** that reinforces the intended idea or concept.
- **Makes things look good** — pleasing the eye sustains visual interest and makes the experience
  pleasurable.

**Example — a physician-information interface.** Blue bars are fixation points that head each chunk
of information, so you can bounce from bar to bar and know what's underneath. An orange **Back to
questions** button at the top contrasts starkly with the blue and white, on a neutral background — a
clear exit route for a core action. Charts ("number of physicians in your area") with pleasant shapes
and numbers alongside make it both well organized and nice to look at.

### Highlight, don't determine

**Color should never be the sole differentiator.** Use it to highlight and guide attention, but also
differentiate through size, font style, and shape — if for no other reason than that some people are
**color blind**.

- For **extended screen use**, use light, muted backgrounds — grays, tans, low-saturation neutrals.
- Use **bright saturated colors only as accents**. Too much bright color everywhere makes everything
  seem equally important — like the boy who cried wolf.
- Start with **one dominant neutral color**, then add one or two **accent colors**, one at a time.
  When things start looking equally important, you're using color too much.

**Examples of sparing accent color:**

- **Messages badge** — a stark orange circle with a white *3* jumps off the gray background: three
  new messages, in less than a second. It's repeated more subtly next to *Inbox*, where only the
  number is colored — still standing out, but secondary.
- **Commissions dashboard** — the selected *Commissions* item is solid orange on the left; the chosen
  table row gets dark gray for the name and orange for the relevant info; the default *Summary* tab
  gets an orange outline, as does the current page number. **As you drill down, color use becomes
  more and more spare** — color used to segregate and differentiate information.

### Evaluating color use

- Are colors used **sparingly**?
- Do they **reinforce or interfere with** hierarchy and content?
- Is the scheme used **consistently** from screen to screen?
- Is color use **functional or just decorative**? Should it be one, the other, or both?
- Does functionality **depend on color** — and would it be just as functional for someone who's
  **colorblind**?

### Typography: serif or sans serif?

Some argue sans serif is easier because it's plain; others argue serifs draw the eye along the
letters.

> Research shows **absolutely no difference** in comprehension, reading speed, or preference between
> serif and sans serif. So when someone asks which is better, "you just say yes."

### Use typography purposefully

- **Multiple typefaces must be visually distinct.** On **Southern Savers**, headline type (logo,
  *Welcome to Southern Savers*, nav like *Printables* and *Learn to Coupon*) is very different from
  body text — a quick distinction between labels and content. **The only reason to use different
  styles at all is to indicate differences in the information being presented.**
- **Nike's Fuel app** — *Workout Summary* is in a very different font from everything else because
  it's a general categorization, distinct from the content you absorb (450 fuel points earned, total
  time, rank, calories, distance). Different information, different style.
- **Font weight** does the same. In a blog-style example, *Just Wonderful* at the top is the core
  heading, separate from categories below (*Dream Interpretation*, *My Trip to England*, *Favorite
  Music*), with very gray, faint dates to the right. Visual weight discerns one type of information
  from the next.
- **Provide clear contrast between styles.** In a reading-list app, headlines are big, bold, and
  black — high contrast against the short description below and the website source above — so
  attention goes straight to them.

### Consistent type styles

1. **Identify content types** — headlines, body text, bullets, charts, etc.
2. **Create a specific style for each** — font, weight (bold vs. regular), color. The example uses
   **five styles**: (1) main headline, (2) body content, (3) callout text, (4) and (5) chart/graphic
   information.
3. **Apply them consistently on every subsequent screen.** On another screen of the same app, style
   1 is the headline again, style 2 body, style 3 the callout, style 5 the visual chart.

That consistency enhances usability, increases comprehension, and improves the overall experience.

---

## 44. Surface Takeaways

- The surface plane can be thought of as **visual language**, created by techniques that indicate
  context and convey information: **layout, typography, color, imagery, sequencing, and visual
  identity**. Together they create our overall impression and understanding.
- Effective visual design serves three purposes: **organize, economize, communicate**.
- The four basic principles for organizing visual information — **alignment, proximity, repetition,
  contrast** — are the core of everything you will ever design.
- Good visual design **leads the eye through the screen in a smooth flow** that gives a guided tour
  of what's available.
- **Consistency** lets users build an accurate mental model of how the product works. Whatever
  treatments and styles you choose, apply them consistently throughout the entire system.
- The **right colors** draw the eye to the most important area and influence emotional response;
  they maximize readability and minimize optical fatigue. The wrong colors do the exact opposite.
- **Typography:** if you use more than one typeface style, each should be visually distinct, and use
  different styles **only to indicate differences in the information**. Don't use a myriad of fonts
  just because they're at your disposal — decide how many levels of information you have and
  designate a specific font treatment for each.

---

## 45. Surface Lab Exercise

Perform a **user interface audit** on a few websites (the lecture refers to three sites provided
with the exercise). Open each in a browser, spend time with just the **home screen**, and write down
your answers to:

- Does the UI reflect the **perspectives and behaviors** of the intended users?
- Are the **images, icons**, etc. appropriate for the intended users — will they automatically know
  what they are and what they're for?
- Are functionally and/or logically connected items **grouped together visually**? Is it easy to see
  relationships between groups of information or functionality?
- Is information presented in **order of importance to the user** — what concerns them most comes
  first?
- **Color:** does it reinforce or interfere with hierarchy and content? Does it help you understand
  what's going on, or distract? Is it functional or merely decorative — does it aid you in moving
  through and understanding the information?
- **Fonts:** are they easy to read on screen? Any difficulty focusing on certain areas or reading
  long lines of text? Does font use reinforce or interfere with hierarchy and content?

Then go back through your answers and see what you learned. Approached critically, you'll be
surprised at some of what you come up with.
