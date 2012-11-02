# COMP 6751 Fall 2012 - Literal Painting
# Author: Bahar Sateli - 9515836

import nltk
from nltk import load_parser
import sys

command = ""
    
for i in range(1, len(sys.argv)):
	command = command + " " + sys.argv[i]

#print command.strip()

parser = load_parser('commandParser.fcfg', trace=0)
my_trees = parser.nbest_parse(command.split())
if len(my_trees) == 0:
	print 'ERROR'
elif len(my_trees) == 1:
		print(my_trees[0])
elif len(my_trees) > 1:
	print 'Ambiguous sentence! I have ' + str(len(my_trees)) +' interpretations:\n'
	for tree in my_trees:
		print tree, '\n'

