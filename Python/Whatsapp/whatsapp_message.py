#!/bin/python3

from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.keys import Keys
from time import sleep
import random

chrome=webdriver.Chrome(ChromeDriverManager().install())

sleep(5) # To install or load required drivers

chrome.get("https://web.whatsapp.com")
sleep(8) # So that web page load properly and we also login to whatsapp

search_box=chrome.find_element_by_class_name("_13NKt")
# search_box.send_keys("Nikki")
# search_box.send_keys("Sanyog")
search_box.send_keys("Nimmi")

search_box.send_keys(Keys.ENTER)

emojis=[":-)", ";-)", ">_<", ":-(", "^_^"]

for i in range(0,50):
	message_box=chrome.find_element_by_xpath('//*[@id="main"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[2]')
        message_box.send_keys("Just Testing!!!")
        message_box.send_keys(Keys.ENTER)    
        message_box.send_keys(random.choice(emojis))
        message_box.send_keys(Keys.ENTER)

