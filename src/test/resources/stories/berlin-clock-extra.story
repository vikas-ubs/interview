Story: The Berlin Clock Check Plus

Meta:
@scope interview,candidate

Narrative:
    Additional cases added to make sure our Berlin clock is working fine

Scenario: Morning Walk time
When the time is 06:15:00
Then the clock should look like
Y
ROOO
ROOO
YYROOOOOOOO
OOOO

Scenario: Start preparing lunch
When the time is 11:29:00
Then the clock should look like
Y
RROO
ROOO
YYRYYOOOOOO
YYYY

Scenario: Attend Webinar @ 5 o clock
When the time is 17:00:00
Then the clock should look like
Y
RRRO
RROO
OOOOOOOOOOO
OOOO
