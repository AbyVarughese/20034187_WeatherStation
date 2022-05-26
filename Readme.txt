Starter- Weather Station

Version 1: Starter
The application launches and reads a YAML file (.yml) of readings for a small number of
weather stations. Each reading consists of:
• Weather Code (number in range 100-800), integer
• Temp (C) decimal
• Wind Speed (kM/hr) decimal
The application then presents these readings on a dashboard.

==================================================

Baseline - Weather Station

This version includes all features in Starter, with one additional piece of data in the
reading for each station:
• Pressure (hPa) Number

Outputs:
The dashboard for the application should present, for each station, the Latest Weather at that station. The latest weather is derived from the most recent (last) reading for the
station, and should contain:
1. Station Name
2. Weather conditions - code presented as a description
3. Temp in both C & F
4. Wind in Beaufort
5. Pressure
======================================================
Release 1 - Weather Station

This version includes all features in baseline, with one additional piece of data in the
reading for each station:
• Wind Direction

Outputs
For each station, the wind summary is expanded to include:
• Wind Compass
• Wind Chill

New Features
The application   permits 2 additional features:
1. Add Station

The default view of the application is changed to now present a list of station names on
the dashboard (without current conditions or readings)
A station can be added via the “Add Station” button, accepting the Station name.
Clicking on the Folder button will open station view, summarising the latest weather at
the station (as before).

2. Add Reading
When the Station is opened, current conditions + readings appear.
New readings can be entered and submitted
=================================================
Release 2 - Weather Station

New Features
This version includes all features in the previous release, plus 4 new capabilities
1. User Accounts

To use this version of the application users must log in (or signup/register first). When
the application launches, a login page is presented. Unregistered users can access a signup form. Users and their associated stations and readings can be loaded from the data.yml
file.

2. Location of Station

When creating a station, the user must also enter the latitude and longitude for the
station. Accept and store in decimal degrees (DD) format. Note this changes the data.yml
file.

3. Current Weather Icon

Each weather code is associated with a corresponding icon.

4. Max/Min

The station report is now included maximum and minimum values of the following
readings:
• Temperature
• Wind Speed
• Pressure
=======================================================================================

Version 5 : Release 3 - Weather Station

New Features:-

This version includes all features in the previous release, plus 6 new capabilities:-

1. Trends
2. Date/Time stamp on each reading
3. All Stations Summary
4. Station/Reading delete support
5. Deployed to the cloud
6. Members can edit their personal details

1. Trends:-

Trends are created for
• Temperature
• Wind Speed
• and Pressure

A trend is:
• Rising : the three most recent measurements are increasing
• Falling : the three most recent measurements are falling
• Steady: neither of the above

2. Date/Time stamp on each reading

When a reading is added, it is time stamped with the current time.

3. Station Summary
On the main dashboard, the latest conditions (but not the readings) for each station is shown.

4. Delete Support
Delete buttons next to each reading and station

5. Deployed
Application deployed to a cloud service

6. Member Details
Provide option to enable Member details to be edited