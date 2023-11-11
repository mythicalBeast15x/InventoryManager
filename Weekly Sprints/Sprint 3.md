# Sprint 3
### Participants
- Love-Divine Onwulata
- Dominic Richard Cianfrani
- Andrew Scott Evert
## Completed Tasks
- Created the Main Screen that displays all of the items + descriptions (just a temporary model)
- Created the Login Screen at the Moment, it it has no values; waiting for API for user validataion
- Login Leads into Main Screen
- Finally got Database online and working
- Populated Database with example values
- Populated Tables according to Schema
  * Tables: Employee, Item, Credentials, Lot, Access
- Developed Encryption + Decryption method to ensure user security
## Complications
- Azure Database revoked access for some reason during API development complicating work
- Amazon AWS RDS was used instead, but took much time to get online and functional
## Tasks for Next Week
- Get API working. Things needed:
  * get name, cost, item_num, and description from database
  * modify data
  * create new items
  * encrypt password data from api call
  * decrypt data when sending it back
- Create a CheckOut Screen
- Send items selected in main to checkout screen
- Send Items back to main if returning to checkout
- "Reset" Screen when checkout is cancelled or completed
