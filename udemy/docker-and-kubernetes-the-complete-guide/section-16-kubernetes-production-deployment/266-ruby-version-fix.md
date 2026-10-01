# Ruby Version Fix

In the upcoming lecture, we will be installing Travis inside a Docker container. This will now require using the latest version of Ruby instead of v2.3 as shown in the video. The command will now look like this:

```sh
docker run -it -v $(pwd):/app ruby sh
```

With this version, we will no longer be passing the `--no-rdoc` or `--no-ri` flags when installing Travis. The command will simply be:

```sh
gem install travis
```
