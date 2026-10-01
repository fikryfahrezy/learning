# GitHub Actions Instead of Travis CI

If you do not wish to use Travis CI, or, you have run out of credits, we have provided code and guidance to use GitHub Actions instead. GitHub Actions is a free CI/CD automation tool built directly into GitHub repositories. It eliminates the need for external services.

## How GitHub Actions Works

GitHub Actions uses YAML files to define workflows, which are automated processes that run one or more jobs. These jobs are sets of steps that execute on the same runner, which is a virtual machine. Steps within a job can run commands, setup tasks, or run an action. GitHub Actions revolves around four main concepts: triggers (when to run), jobs (what to do), steps (how to do it), and actions (reusable units of code).

Folder Structure

```
project-root/
├── .github/
│   └── workflows/
│       └── main.yml
└── (rest of your project files)
```

The `.github/workflows` directory in your repository root is where you place your workflow files.

## Replacement Code

For every lecture that we write Travis configuration code, we have provided replacement code that uses GitHub Actions instead. This is available as a separate zip file that has the words **gh-actions** within it.

example:

Lecture 88: A Touch More Travis Setup

Refer to the zip file:

88-touch-more-gh-actions.zip

You may also refer to the completed and finished example here (scroll past the lecture video to see the featured question):

https://www.udemy.com/course/docker-and-kubernetes-the-complete-guide/learn/lecture/11437142#questions/17673926

