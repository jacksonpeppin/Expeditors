Given input data (a text file), output each household and number of occupants, followed by: each first name, last name, address and age sorted by last name
then first name where the occupant(s) is older than 18

EXAMPLE

Input data:

"Dave","Smith","123 main st.","seattle","wa","43"

"Alice","Smith","123 Main St.","Seattle","WA","45"

"Bob","Williams","234 2nd Ave.","Tacoma","WA","26"

"Carol","Johnson","234 2nd Ave","Seattle","WA","67"

"Eve","Smith","234 2nd Ave.","Tacoma","WA","25"

"Frank","Jones","234 2nd Ave.","Tacoma","FL","23"

"George","Brown","345 3rd Blvd., Apt. 200","Seattle","WA","18"

"Helen","Brown","345 3rd Blvd. Apt. 200","Seattle","WA","18"

"Ian","Smith","123 main st ","Seattle","Wa","18"

"Jane","Smith","123 Main St.","Seattle","WA","13"

Output:

Address: 123 main st seattle wa Occupants: 4
Address: 234 2nd ave seattle wa Occupants: 1
Address: 234 2nd ave tacoma fl Occupants: 1
Address: 234 2nd ave tacoma wa Occupants: 2
Address: 345 3rd blvd apt 200 seattle wa Occupants: 2

----------------------------------------------------------------------------------------

Brown, George, 345 3rd blvd apt 200, seattle, wa, 18
Brown, Helen, 345 3rd blvd apt 200, seattle, wa, 18
Johnson, Carol, 234 2nd ave, seattle, wa, 67
Jones, Frank, 234 2nd ave, tacoma, fl, 23
Smith, Alice, 123 main st, seattle, wa, 45
Smith, Dave, 123 main st, seattle, wa, 43
Smith, Eve, 234 2nd ave, tacoma, wa, 25
Smith, Ian, 123 main st, seattle, wa, 18
Williams, Bob, 234 2nd ave, tacoma, wa, 26
