# Morphy Examples

This repository contains the folowing examples of Morphy test specifications and experiment data. 

SinTest.java -- Morphy test specification for testing trogonometric function sin(x). 

Triangle classification case study -- The files are in the TriangleClassification folder. It contains the following files:

-- Triangle.java : the input class to the triangle classification test case

-- TriangleType.java : the output class of the triangle classification test case

-- Triangle 1.java, Triangle2.java, Triangle3.java, Triangle4.java: the program under test, which are 4 different implementations of the traingle classification problem. Triangle1.java and Triangle2.java contains bugs pruposefully. Triangle3.java and Triangl4.java are correct. 

-- TriangleTestSpec.java : the common part of the test specification class for testing triangle classification programs. 

-- TriangleTest1.java, TriangleTest2.java, TraingleTest3.java and TriangleTest4.java : test specification files that contain test executers for invoking the corresponding triangle classification classes. 

Trigonometric function case study -- The files are in the Trigonometric Folder. It contains the following files: 

-- Trigonometrics.java : the output calsss of test cases;

-- TrigonometricTest.java : the test specification;

-- VisualizeTrignometricalFunctions.java : A class that implements the visualisation of the test results. 

Face Recognition case study -- The files are in the FaceRegnition folder. It contains the following files: 

-- FaceRecBaiduTest.java : Test specification for testing Baidu.com

-- FaceRecFacePlusTest.java : Test specification for testing Faceplus.com

-- FaceRecSeetaFaceTest.java : Test specification for testing SeetaFace;

-- FaceRecTencentTest.java : Test specification for tetsing Tencent.com

-- TwoImage.java : The input class of test cases

-- ImageConfig.java : configuration file to set the paths to the images used as the test data

-- TwoImageDatamorphsims.java : test specification of datamorphisms for testing face recognition

-- TwoImageRandomTesting.java : test specification of test case generation and test result analysis

-- SeetaFace.rar : compressed file of a packages to run face recognition applications

# The Morphy Testing Tool

You can also download the tool here. The following two files are needed:

-- Morphy.jar : the testing tool to execute test specifications. It is executable. 

-- MorphyAnnotations.jar : the java package to develop test specification. You should download the package to you IDE and put the this package in your build path. 

# Installation of Morphy 
-- Download Morphy.jar file

-- Download the folder icones

-- Create a folder, e.g. Morphy on you machine, say on C drive at the root direcotory C:/. This is the installation folder. 

-- Copy Morphy.jar to the installation folder

-- Copy the icons folder to the installation fold. 

-- Create a batch file with the following two lines:

cd C:/Morphy 

java -jar Morphy.jar

# Start Morphy Tool

Double click on the Morphy batch file.

Or, open a CMD window and type the following lines of command:

cd C:/Morphy

java -jar Morphy


The GUI of the Morphy tool will apprea on your screen. 

