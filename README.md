# G - Scan

Android application which targets truck drivers to simplify maintenance and repair processes for car rental companies.

# Vision
The idea is to group cars from the truck by its current condition using the ouput from server-side Python ML model,
which can estimate state of the car by feeding series of images taken from several cameras. Cameras are placed on the
special ramp through which truck is entering the car storage.

# Workflow
Truck driver logins to the Android app by using its personal profile. Then in the app he see all the cars that currently are
on the board. When arrived to the car storage, those cars are scanned, analyzed and grouped into 4 groups - fully operatable, 
ones needed a cleaning, ones needed a painting, ones needed a repairing.

Then truck driver can plan visits to specialized services to take care of that cars. Then cars are returned back to the storage
following the same procedure.

# Server-side solution
You can find detailed description and source code by using this link - https://github.com/smejkka3/VivaTech_Hackaton.
