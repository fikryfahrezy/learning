# Quiz 7: Image Tagging

## Question 1

If you ran the command `docker build . -t app1` how would you run the image that gets created?

- [ ] The build command is invalid
- [ ] `docker run 9dfa32gg`
- [x] `docker run app1`

## Question 2

After running the command `docker build .` you see the following output:

```
=> => exporting layers                          0.0s
=> => writing image sha256:9dfadec01fefd446b8a918b  0.0s
```

How would you tag this image with a tag of `app1`?

- [ ] `docker run tag 9dfa app1`
- [x] `docker tag 9dfa app1`
- [ ] I would rerun the build command like so: `docker build . -t app1`

## Question 3

Which of the following `tag` commands correctly follows naming conventions?

- [ ] `docker tag ece24c my-fancy-image`
- [x] `docker tag ece24c dockeruser/my-fancy-image`
- [ ] `docker tag ece24c dockeruser:my-fancy-image`

## Question 4

You decide to use an image created by another engineer with the following name:

`dockeruser/webapp:1.4.3-alpine3.10`

Which of the following is true?

- [ ] This is image version 3.10. It likely used a base image of Alpine 1.4.3
- [ ] This image does not have a tag.
- [x] This is image version 1.4.3. It likely used a base image of Alpine v3.10
