from datetime import datetime
import datetime

today = datetime.date.today()

def remaining_days () :
    while True :
        print("Please Enter the desired Date in this format : ")
        user_input = input("YYYY-MM-DD : ")
        try :
            # Convert input into a date object
            user_date = datetime.datetime.strptime(user_input,"%Y-%m-%d").date()

            # Check if the date is in the future

            if today<user_date :
                difference = user_date - today                   #This is a timedelta object
                print(f"There are {difference.days} days remaining ... ")
                break
            else :
                print("The date must be in the future. Please try again.")
        except ValueError:
            print("Invalid format! Please enter the date in YYYY-MM-DD format.")

remaining_days()
