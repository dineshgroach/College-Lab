import numpy as np
from sklearn.linear_model import LinearRegression  # linear regression models
from sklearn.ensemble import RandomForestRegressor  # enembly models

# Define custom data 
X_train = np.array([
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [9, 10, 11, 12]
])
y_train = np.array([10, 20, 30])  # Target values

# Define base models 
models = [RandomForestRegressor(random_state=42)]  

# Train base models 
base_model_preds = []
for model in models:
    model.fit(X_train, y_train)
    base_model_preds.append(model.predict(X_train))  # Predict on training data for representation

# Combine predictions into a new feature matrix
X_train_meta = np.column_stack(base_model_preds)

# Define and train the meta-model 
meta_model = LinearRegression()
meta_model.fit(X_train_meta, y_train)


# Print the meta-model representation
print(f"Meta-model representation : {meta_model.coef_}")
