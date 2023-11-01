import pandas as pd
import joblib
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier
import warnings
warnings.filterwarnings("ignore")

# Load your dataset (CSV file or any other format)
# Assuming your dataset has columns 'SO2', 'NO2', and 'RSPM'

# Read your dataset
b = pd.read_csv('D:\\desh.csv')

# Extract features (SO2 and NO2) and target (RSPM)
X = b[['SOi', 'Noi']]
Y = b['rpi']

# Split the data into training and testing sets
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.2, random_state=42)

# Create a decision tree classifier model and train it
model=DecisionTreeClassifier()
model.fit(X_train,Y_train)

# Save the model to a file
joblib.dump(model,'rspm_prediction_model.pkl')


# Load the trained model
model=joblib.load('rspm_prediction_model.pkl')

def predict_rspm(so2, no2):
    # Make a prediction using the loaded model
    prediction = model.predict([[so2, no2]])
    return prediction[0]

if __name__ == '__main__':
    # Get input from the user
    try:
        so2 = float(input("Enter SO2 value: "))
        no2 = float(input("Enter NO2 value: "))
        
        # Predict RSPM value
        predicted_rspm = predict_rspm(so2, no2)
        print("Predicted RSPM value:", predicted_rspm)
        
    except ValueError:
        print("Invalid input. Please enter numeric values for SO2 and NO2.")
if(predicted_rspm<50):
    print("it is safe for humans")
else:
    print("it is not safe for humans")



