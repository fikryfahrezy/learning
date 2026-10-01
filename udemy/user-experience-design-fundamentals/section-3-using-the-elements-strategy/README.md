# Section 3 — Using the Elements: Strategy

Summary of lectures 8–15. Strategy is the bottom plane of the five elements of UX: it defines
**business goals** (what the organization wants) and **user needs** (what people want), and every
decision on the planes above is judged against it.

---

## 8. The Research Process

All good strategy starts with research, because we don't know everything about the problem,
industry, product, or audience — so we find out.

Research doesn't have to be a scientific undertaking with controlled variables and experiments.
At its core it's **asking a lot of questions of human beings** and leveraging the tools in front of
you (mostly Google — there's almost always a precedent to learn from).

The typical flow:

1. **Stakeholder interviews** — a stakeholder is anyone with a vested interest in the product and
   its outcome: marketing director, IT director, product/project manager, up to the CEO signing the
   checks. Ask them what *success* looks like. Do this first: if people on the team disagree about
   what success means, the target keeps moving and you go down six different paths. Disagreements
   must be ironed out **before** any work starts.
2. **Competitor review** — who else is doing this, what works, what doesn't. Complaints about
   competitors are especially valuable: problems you solve that they don't are immediate
   competitive advantage.
3. **User interviews** — get a representative sample. Ask how they'd complete a given task in an
   ideal world, what tools they already use, what they like and dislike about them, and *why* the
   task matters (saves time? looks good to the boss?). The internet is a treasure trove — people
   publicly say what they love and hate on social media, Amazon reviews, etc.
4. **Audit of the existing product** (when it's a v2 / redesign) — repeat all three steps above,
   but asked specifically about the current product: what's good, what's bad, how it helps or hurts
   the organization, how it's faring against competitors, what users wish it did better.
5. **Analysis and review** — read everything back and look for **patterns**: multiple people asking
   for the same thing or complaining about the same thing. Those patterns become the feature set
   that defines scope. No formal process required.

> Research doesn't have to be complicated. You just have to do it.

---

## 9. Identifying Business Goals

Business goals come from stakeholders. Get them in a room and ask:

- **What should the product accomplish for the business?** More leads? More awareness? More sales?
- **Who are your customers/users?** Who have you traditionally marketed and sold to — is it the
  same group this time? Where do they live, how old are they, what do they want?
- **How does this project fit the overall business strategy?** There may be other initiatives in
  flight that affect this product one way or another.
- **How do you expect to differentiate this product?** The internet puts every competitor on your
  doorstep. Why aren't you just the same as everyone else?
- **What technology decisions have already been made?** Established orgs usually have IT
  constraints ("must run on Microsoft IIS, we won't support PHP or open source") plus security
  requirements. Find the parameters before designing to them.
- **Why do you think customers would use a product like this?** An obvious-sounding question that
  people rarely step back to consider — asking it makes everyone re-examine their preconceptions,
  and important things surface.
- **If people use a competitor instead, what's the reason?** Nine times out of ten they know why —
  and that's part of why you're in the room.
- **What do customers complain or ask about most often?** Talk to the call center / help desk.
  The people who field the complaints will teach you a lot about what not to do.

---

## 10. Identifying B2B User Needs

UX creates a **value loop**: if value goes out to the people using the product, value is highly
likely to come back to the business sponsoring it.

**B2B** = you're selling to people *in the context of their jobs* at other companies (e.g. a time
and attendance system). Questions:

- Tell me about your background and your role here.
- **What makes a good workday for you?** Not just software — what makes you feel productive?
- **How does this process work at your company currently?** ("Walk me through how you fill out your
  time sheet.")
- **What groups and roles are involved, and how do they work together?** (Me → my boss → HR →
  finance.) You're mapping who needs the information so you can serve it to every party.
- **How does this compare to previous companies you've worked at?** Better processes they've
  experienced elsewhere are things you may be able to design in.
- **What are the biggest problems and inefficiencies today?** What grinds productivity to a halt?
  Ask a wide cross-section — if 1 of 20 people dislikes the green color, that's noise; a complaint
  repeated by many is signal.
- **What other systems work with this one?** Nothing works in a vacuum, and your design decisions
  will ripple into connected processes.

---

## 11. Identifying B2C User Needs

**B2C** = selling directly to consumers (Amazon purchases, iTunes, App Store apps). Don't ask about
work habits or their employer — those barely influence the decision. Instead:

- **What makes a good experience** (shopping, watching, playing)? What do *you* define as good?
- **What would you usually do first, and why?** Ask open-ended, don't lead them, don't give advice.
  Just listen.
- **What would you put off as long as you can?** This surfaces friction — e.g. re-entering a
  username at checkout after already logging in, or re-typing an address and card from last order.
  What wastes your time? What frustrates you?
- **How often do you use this (kind of) product?** Frequency tells you how valuable it is and
  whether it's part of daily reality.
- **What do you use it for most often?** It's often not what was intended — plenty of people treat
  Google as "the internet" and type full URLs into the search box instead of the address bar.
- **Can you show me how you do that?** What people *say* they do isn't a perfect match for what
  they *do*. Observing reveals unverbalized struggles — fumbling a key combination, wandering the
  screen hunting for a link.
- **What do you use before, during, or after this product?** Those adjacent tools may contain
  features users wish you provided. Critical points of identification.
- **How would you compare this to others you've used?** Or: what are your top three go-to
  sites/apps, and could this become one of them? You're looking for the recurring, useful role your
  product could play in their life.

---

## 12. Three Crucial Questions

### 1. What's worth doing?

Plot every feature/need on two axes:

- **Importance** — how crucial is it to the business and the users?
- **Feasibility/viability** — can we actually pull it off with our time, budget, and people?

| Zone | Action |
| --- | --- |
| Low importance + low feasibility | Don't spend time on it |
| Middle | Accommodate it, but don't pour the majority of your effort in |
| High importance + high feasibility | **Your sweet spot** — must be included *and* designed extremely well, so it delights and feels like an answer to a prayer |

### 2. What are we creating?

Define exactly what it will be — and make sure *everyone* agrees. The client pictures a square,
the PM a triangle, the designer something else entirely. That mismatch derails projects easily.
This is why you need a specification, requirements, a shared understanding of the feature set, and
clarity on the content: what it is, where it comes from, who creates it. Nail this before moving on.

### 3. What value does it provide?

- **Who is our target audience?** Get painfully specific ("African American chefs who specialize in
  baking, roughly 35–40 years old…").
- **What experiences are compelling to them?** (Fresh blueberries in bulk, competitive prices,
  one-click ordering.)
- **How is our offering different from competitors — and substitutes?** Not just other blueberry
  sellers, but the raspberry industry too.

Projects routinely rush into design and development without this. Without it you're shooting in the
dark, and when the launch underperforms, fingers get pointed — one of them at you.

---

## 13. First-Use Questions

The very first time someone sees your screen, they ask a predictable set of questions. These belong
to all human beings, and the screen has to answer them:

- **What is this?** Is it what I expected when I clicked the link?
- **Does it look credible / trustworthy?** True whether you're asking for money or just their time.
- **Does it offer what I want?** A **three-second** judgment. If the answer is no, they're gone.
- **Does it look valuable enough to stick around?** Is it worth clicking through to another screen?
- **What actions can I take now?** If that's unclear, I'll go do something else.
- **How do I learn more?** How do I get more information or contact a person? We have an innate need
  to know a human is reachable — answering it calms people down and signals "we've got you covered."

---

## 14. Strategy Takeaways

- You must have a **clear roadmap to creating value** for *both* users and business. If value
  doesn't go out, it won't come back.
- **Successful UX comes from clear strategy.** Strategy informs the customer experience, the
  technology decisions, what the screen looks like, how it's arranged, the functionality, the look
  and feel. Without it, odds are high you built something people don't want, can't use, or don't
  understand.
- **Overall experience must be driven by business goals and customer needs** — continually. Even
  deep into coding, keep checking: does this still fit the value proposition? Is it still easy to
  use? Does it still meet those needs?
- **Know your users, and remember they are not you.** You design, develop, and organize information
  *for them*, not for yourself. You can't assume they share your frame of reference or level of
  understanding.

---

## 15. Strategy Lab Exercise

A simple, repeatable method for deciding what's worth doing. Use a real project if you have one,
otherwise invent a scenario.

**Step 1.** List multiple business opportunities for the product.

**Step 2.** Rate each on a **1–5 scale** in two columns:
- *Importance* — how crucial is it that the business solves this?
- *Feasibility* — how realistic is it that we can design and build this solution?

Worked example — an online bookseller that wants more sales:

| Problem / Opportunity | Importance | Feasibility |
| --- | --- | --- |
| Increase unique visitors | 4 (more volume → more sales) | 2 (lots of marketing spend for ~2% return) |
| Increase purchases per visit | 5 (low-hanging fruit with current traffic) | 4 (incentives, discounts, 2-for-1 deals) |
| Increase number of titles | 1 (no evidence it drives sales) | 3 (inventory infrastructure, cost, risk) |
| Increase number of authors | 3 (maybe — we may be over-represented by a few) | 3 (lots of outreach and research work) |
| **Total** | **13** | **12** |

**Step 3. The budget formula.** `middle score × number of opportunities = points available`.
Here: `3 × 4 = 12` points. Think of points as dollars — that's the effort you have to spend.

- Feasibility totals 12 — right on the money.
- Importance totals 13 — over budget, so something has to change.

When you're over, **re-evaluate the ratings or cut opportunities**. "Increase number of titles" is
low importance and only medium feasibility — scrap it and reallocate effort to the other three.
The constraint forces you to think about what really counts.

**Step 4. Plot the results** on the importance × feasibility graph:

| Opportunity | Score (I, F) | Verdict |
| --- | --- | --- |
| Increase purchases per visit | 5, 4 | **Include or die** — has to be done |
| Increase unique visitors | 4, 2 | **Strongly consider accommodating** — worth doing, but not the core focus |
| Increase number of authors | 3, 3 | Middle — only if budget remains |
| Increase number of titles | 1, 3 | **Ignore completely** |

**The recommendation to the client:** start with purchases per visit and work out what it takes —
what has to change, be updated, be redesigned. If time and money remain, tackle unique visitors,
then authors.

Do this on your own projects, even personal ones.
