# Linear Regression

Linear regression is perhaps one among the foremost necessary and wide used regression techniques. It’s among the only regression ways. one among its main blessings is that the simple deciphering results.

## Problem Formulation

When implementing regression toward the mean of some variable quantity variable quantity the set of freelance variables 𝐱 = (𝑥₁, …, 𝑥ᵣ), wherever wherever is that the variety of predictors, you assume a linear relationship between 𝑦 and 𝐱: 𝑦 = 𝛽₀ + 𝛽₁𝑥₁ + ⋯ + 𝛽ᵣ𝑥ᵣ + 𝜀. This equation is that the regression of y on x. 𝛽₀, 𝛽₁, …, 𝛽ᵣ area unit the regression coefficients, and 𝜀 is that the random error.

Linear regression calculates the estimators of the regression coefficients or just the expected weights, denoted with 𝑏₀, 𝑏₁, …, 𝑏ᵣ. They outline the calculable regression operate 𝑓(𝐱) = 𝑏₀ + 𝑏₁𝑥₁ + ⋯ + 𝑏ᵣ𝑥ᵣ. This operate ought to capture the dependencies between the inputs and output sufficiently well.

The calculable or expected response, 𝑓(𝐱ᵢ), for every for every = one, …, 𝑛, ought to be as shut as potential to the corresponding actual response 𝑦ᵢ. The variations variations - 𝑓(𝐱ᵢ) for all observations 𝑖 = one, …, 𝑛, area unit known as the residuals. Regression is regarding deciding the most effective expected weights, that's the weights adore the littlest residuals.

To get the most effective weights, you always minimize the add of square residuals (SSR) for all observations 𝑖 = one, …, 𝑛: SSR = Σᵢ(𝑦ᵢ - 𝑓(𝐱ᵢ))². This approach is named the tactic of normal statistical procedure.

## Regression Performance

The variation of actual responses 𝑦ᵢ, 𝑖 = 1, …, 𝑛, happens partially thanks to the dependence on the predictors 𝐱ᵢ. However, there's additionally a further inherent variance of the output.

The constant of determination, denoted as 𝑅², tells you which of them quantity of variation in 𝑦 will be explained by the dependence on 𝐱 mistreatment the actual regression model. Larger 𝑅² indicates a better fit and means that the model can better explain the variation of the output with different inputs.

The value 𝑅² = 1 corresponds to SSR = 0, that is to the perfect fit since the values of predicted and actual responses fit completely to each other.

## Implementing Linear Regression in Python

It’s time to start implementing linear regression in Python. Basically, all you should do is apply the proper packages and their functions and classes.

### Python Packages for Linear Regression

The package NumPy is a fundamental Python scientific package that allows many high-performance operations on single- and multi-dimensional arrays. It also offers many mathematical routines. Of course, it’s open source.

If you’re not familiar with NumPy, you can use the official [NumPy User Guide](https://docs.scipy.org/doc/numpy/user/index.html) .

The package scikit-learn is a widely used Python library for machine learning, built on top of NumPy and some other packages. It provides the means for preprocessing data, reducing dimensionality, implementing regression, classification, clustering, and more. Like NumPy, scikit-learn is also open source.

You can check the page [Generalized Linear Models](https://scikit-learn.org/stable/modules/linear_model.html) on the [scikit-learn web site](https://scikit-learn.org/stable/) to learn more about linear models and get deeper insight into how this package works.

If you want to implement linear regression and need the functionality beyond the scope of scikit-learn, you should consider statsmodels. It’s a powerful Python package for the estimation of statistical models, performing tests, and more. It’s open source as well.

You can find more information on statsmodels on its [official web site](https://www.statsmodels.org/stable/index.html).

### Simple Linear Regression With scikit-learn

Let’s start with the simplest case, which is simple linear regression.

There are five basic steps when you’re implementing linear regression:

- Import the packages and classes you need.
- Provide data to work with and eventually do appropriate transformations.
- Create a regression model and fit it with existing data.
- Check the results of model fitting to know whether the model is satisfactory.
- Apply the model for predictions.

These steps are more or less general for most of the regression approaches and implementations.

**Step 1: Import packages and classes**

The first step is to import the package numpy and the class LinearRegression from sklearn.linear_model:

```
import numpy as np
from sklearn.linear_model import LinearRegression
```

Now, you have all the functionalities you need to implement linear regression.

The fundamental data type of NumPy is the array type called numpy.ndarray. The rest of this article uses the term array to refer to instances of the type numpy.ndarray.

The class sklearn.linear_model.LinearRegression will be used to perform linear and polynomial regression and make predictions accordingly.

**Step 2: Provide data**
The second step is defining data to work with. The inputs (regressors, 𝑥) and output (predictor, 𝑦) should be arrays (the instances of the class numpy.ndarray) or similar objects. This is the simplest way of providing data for regression:

```
x = np.array([5, 15, 25, 35, 45, 55]).reshape((-1, 1))
y = np.array([5, 20, 14, 32, 22, 38])
```

Now, you have two arrays: the input x and output y. You should call .reshape() on x because this array is required to be two-dimensional, or to be more precise, to have one column and as many rows as necessary. That’s exactly what the argument (-1, 1) of .reshape() specifies.

This is how x and y look now:

```
>>> print(x)
[[ 5]
 [15]
 [25]
 [35]
 [45]
 [55]]
>>> print(y)
[ 5 20 14 32 22 38]
```

As you can see, x has two dimensions, and x.shape is (6, 1), while y has a single dimension, and y.shape is (6,).

**Step 3: Create a model and fit it**
The next step is to create a linear regression model and fit it using the existing data.

Let’s create an instance of the class LinearRegression, which will represent the regression model:

```
model = LinearRegression()
```

This statement creates the variable model as the instance of LinearRegression. You can provide several optional parameters to LinearRegression:

- fit_intercept is a Boolean (True by default) that decides whether to calculate the intercept 𝑏₀ (True) or consider it equal to zero (False).
- normalize is a Boolean (False by default) that decides whether to normalize the input variables (True) or not (False).
- copy_X is a Boolean (True by default) that decides whether to copy (True) or overwrite the input variables (False).
- n_jobs is an integer or None (default) and represents the number of jobs used in parallel computation. None usually means one job and -1 to use all processors.

This example uses the default values of all parameters.

It’s time to start using the model. First, you need to call .fit() on model:

```
model.fit(x, y)
```

With .fit(), you calculate the optimal values of the weights 𝑏₀ and 𝑏₁, using the existing input and output (x and y) as the arguments. In other words, .fit() fits the model. It returns self, which is the variable model itself. That’s why you can replace the last two statements with this one:

```
model = LinearRegression().fit(x, y)
```

This statement does the same thing as the previous two. It’s just shorter.

**Step 4: Get results**

Once you have your model fitted, you can get the results to check whether the model works satisfactorily and interpret it.

You can obtain the coefficient of determination (𝑅²) with .score() called on model:

```
>>> r_sq = model.score(x, y)
>>> print('coefficient of determination:', r_sq)
coefficient of determination: 0.715875613747954
```

When you’re applying .score(), the arguments are also the predictor x and regressor y, and the return value is 𝑅².

The attributes of model are .intercept*, which represents the coefficient, 𝑏₀ and .coef*, which represents 𝑏₁:

```
>>> print('intercept:', model.intercept_)
intercept: 5.633333333333329
>>> print('slope:', model.coef_)
slope: [0.54]
```

The code above illustrates how to get 𝑏₀ and 𝑏₁. You can notice that .intercept* is a scalar, while .coef* is an array.

The value 𝑏₀ = 5.63 (approximately) illustrates that your model predicts the response 5.63 when 𝑥 is zero. The value 𝑏₁ = 0.54 means that the predicted response rises by 0.54 when 𝑥 is increased by one.

You should notice that you can provide y as a two-dimensional array as well. In this case, you’ll get a similar result. This is how it might look:

```
>>> new_model = LinearRegression().fit(x, y.reshape((-1, 1)))
>>> print('intercept:', new_model.intercept_)
intercept: [5.63333333]
>>> print('slope:', new_model.coef_)
slope: [[0.54]]
```

As you can see, this example is very similar to the previous one, but in this case, .intercept* is a one-dimensional array with the single element 𝑏₀, and .coef* is a two-dimensional array with the single element 𝑏₁.

**Step 5: Predict response**

Once there is a satisfactory model, you can use it for predictions with either existing or new data.

To obtain the predicted response, use .predict():

```
>>> y_pred = model.predict(x)
>>> print('predicted response:', y_pred, sep='\n')
predicted response:
[ 8.33333333 13.73333333 19.13333333 24.53333333 29.93333333 35.33333333]
```

When applying .predict(), you pass the regressor as the argument and get the corresponding predicted response.

This is a nearly identical way to predict the response:

```
>>> y_pred = model.intercept_ + model.coef_ * x
>>> print('predicted response:', y_pred, sep='\n')
predicted response:
[[ 8.33333333]
 [13.73333333]
 [19.13333333]
 [24.53333333]
 [29.93333333]
 [35.33333333]]
```

In this case, you multiply each element of x with model.coef* and add model.intercept* to the product.

The output here differs from the previous example only in dimensions. The predicted response is now a two-dimensional array, while in the previous case, it had one dimension.

If you reduce the number of dimensions of x to one, these two approaches will yield the same result. You can do this by replacing x with x.reshape(-1), x.flatten(), or x.ravel() when multiplying it with model.coef\_.

In practice, regression models are often applied for forecasts. This means that you can use fitted models to calculate the outputs based on some other, new inputs:

```
>>> x_new = np.arange(5).reshape((-1, 1))
>>> print(x_new)
[[0]
 [1]
 [2]
 [3]
 [4]]
>>> y_new = model.predict(x_new)
>>> print(y_new)
[5.63333333 6.17333333 6.71333333 7.25333333 7.79333333]
```

Here .predict() is applied to the new regressor x_new and yields the response y_new. This example conveniently uses arange() from numpy to generate an array with the elements from 0 (inclusive) to 5 (exclusive), that is 0, 1, 2, 3, and 4.

You can find more information about LinearRegression on the [official documentation page](https://scikit-learn.org/stable/modules/generated/sklearn.linear_model.LinearRegression.html).

### Multiple Linear Regression With scikit-learn

You can implement multiple linear regression following the same steps as you would for simple regression.

**Steps 1 and 2: Import packages and classes, and provide data**

First, you import numpy and sklearn.linear_model.LinearRegression and provide known inputs and output:

```
import numpy as np
from sklearn.linear_model import LinearRegression

x = [[0, 1], [5, 1], [15, 2], [25, 5], [35, 11], [45, 15], [55, 34], [60, 35]]
y = [4, 5, 20, 14, 32, 22, 38, 43]
x, y = np.array(x), np.array(y)
```

That’s a simple way to define the input x and output y. You can print x and y to see how they look now:

```
>>> print(x)
[[ 0  1]
 [ 5  1]
 [15  2]
 [25  5]
 [35 11]
 [45 15]
 [55 34]
 [60 35]]
>>> print(y)
[ 4  5 20 14 32 22 38 43]
```
In multiple linear regression, x is a two-dimensional array with at least two columns, while y is usually a one-dimensional array. This is a simple example of multiple linear regression, and x has exactly two columns.

**Step 3: Create a model and fit it**

The next step is to create the regression model as an instance of LinearRegression and fit it with .fit():

```
model = LinearRegression().fit(x, y)
```

The result of this statement is the variable model referring to the object of type LinearRegression. It represents the regression model fitted with existing data.

**Step 4: Get results**

You can obtain the properties of the model the same way as in the case of simple linear regression:

```
>>> r_sq = model.score(x, y)
>>> print('coefficient of determination:', r_sq)
coefficient of determination: 0.8615939258756776
>>> print('intercept:', model.intercept_)
intercept: 5.52257927519819
>>> print('slope:', model.coef_)
slope: [0.44706965 0.25502548]
```

You obtain the value of 𝑅² using .score() and the values of the estimators of regression coefficients with .intercept* and .coef*. Again, .intercept* holds the bias 𝑏₀, while now .coef* is an array containing 𝑏₁ and 𝑏₂ respectively.

In this example, the intercept is approximately 5.52, and this is the value of the predicted response when 𝑥₁ = 𝑥₂ = 0. The increase of 𝑥₁ by 1 yields the rise of the predicted response by 0.45. Similarly, when 𝑥₂ grows by 1, the response rises by 0.26.

**Step 5: Predict response**

Predictions also work the same way as in the case of simple linear regression:

```
>>> y_pred = model.predict(x)
>>> print('predicted response:', y_pred, sep='\n')
predicted response:
[ 5.77760476  8.012953   12.73867497 17.9744479  23.97529728 29.4660957
 38.78227633 41.27265006]
```

The predicted response is obtained with .predict(), which is very similar to the following:

```
>>> y_pred = model.intercept_ + np.sum(model.coef_ * x, axis=1)
>>> print('predicted response:', y_pred, sep='\n')
predicted response:
[ 5.77760476  8.012953   12.73867497 17.9744479  23.97529728 29.4660957
 38.78227633 41.27265006]
```

You can predict the output values by multiplying each column of the input with the appropriate weight, summing the results and adding the intercept to the sum.

You can apply this model to new data as well:

```
>>> x_new = np.arange(10).reshape((-1, 2))
>>> print(x_new)
[[0 1]
 [2 3]
 [4 5]
 [6 7]
 [8 9]]
>>> y_new = model.predict(x_new)
>>> print(y_new)
[ 5.77760476  7.18179502  8.58598528  9.99017554 11.3943658 ]
```

That’s the prediction using a linear regression model.
