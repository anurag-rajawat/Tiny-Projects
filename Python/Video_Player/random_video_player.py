#!/bin/python3
import random
import os

choice = int(input("\nWhat would you like to watch?\n\t1.Random Videos\n\t2.Friends Show\n\t>>> "))
print()
vid_path = "/home/anurag/Videos"
show_path = "/home/anurag/Videos/Friends"

if choice == 1:
    os.chdir(vid_path)
    videos = os.listdir(os.getcwd())
    rand_episode = random.choice(videos)
    print(f"Playing, {rand_episode}\nEnjoy!")
    os.system(f"xdg-open \"{rand_episode}\"")

else:
    os.chdir(show_path)
    episodes = os.listdir(os.getcwd())
    rand_episode = random.choice(episodes)
    print(rand_episode)
    # print(f"Playing, {rand_episode}\nEnjoy!")
    os.system(f"xdg-open \"{rand_episode}\"")
