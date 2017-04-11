# E-commerce Cart Sample

The cart sample includes Cucumber tests and plain old Java objects (POJOs) that model the functionality of a basic shopping cart.

## Requirements

The cart sample uses Maven to satisfies all the dependencies for the code to work.

## Installation

   * Make sure you have a working internet connection. Maven will be downloading packages from the internet in order to configure itself.
   
Note: We expect installation to take 15-30 minutes to setup. If for any reason it is taking longer, please feel free to reach out to us. We are happy to [help](#support).

## Running Tests

After installation, go to the halo-java-cart directory and make sure the tests are wrking:

```bash
$ mvn test
```

The tests should complete without errors. The majority of the tests will be in a pending state.

## Code Layout

Here is a high level overview of the important files in this project:

   * `src/test/java/resources/hautelook/cart.feature` - the gherkin language that describes scenarios (tests cases) for the sample cart code.
   * `src/test/java/hautelook/Stepdefs.java` - the file that parses the above `cart.feature` and executes tests.
   * `src/main/java/hauteLook/Cart.java` - the sample cart class

You may need to add additional files or classes to complete the assignment, so feel free to use whatever editor your are most comfortable with to browse and edit them.

## Challenge

The first scenario has been written for you. Please implement the remaining scenarios in `cart.feature`. We are judging you on the design and the correctness of the code. Make whatever changes you want to the scenario implementations and source code to accomplish that goal. We are excited to see it! Zip up the directory and email it back to us. You can omit the `.git` creating the zip.

### Support

Need help? Please reach out to us! We know computers can be tricky things and we are happy to assist you. Our contact details are in the email we sent you. We will get back to you as soon as we can.
