# Sprint 3
### Participants
- Love-Divine Onwulata
- Dominic Richard Cianfrani
- Andrew Scott Evert
## Completed Tasks
- Added a checkout cart to Main page
- Added a checkout button to Main page to checkout items
- Added an add to cart functionality for items
- Added a remove to cart functionality
- Created a checkout page
- Added logic between checkout and main page to allow data transfer
- Added functionality to login buttons
- Added logic to checkout button
- Edited values in database
- Created Lambdas Function to access database and return data
- Created basic API
- Created an encrypt function for passwords so passwords aren't stored in database as plaintext
## Complications
- The Lambdas Function has some bugs. It needs fixing
## Tasks for Next Week
- Debug Lambdas Function
- Get API working. Things needed:
  * get name, cost, item_num, and description from database
  * modify data
  * create new items
  * encrypt password data from api call
  * decrypt data when sending it back
- Create classes that implement abstraction and MVC that connect with the API
ie:
  * Item Class
  * ValidateUsername - Checks credentials on login
  * APIHelper - Gives access to the database to the classes that need it
  * UpdateInventory - Updates the database when checking out items
- "Reset" Screen when checkout is cancelled or completed
