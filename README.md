# Spring boot with AWS Lambda

Sample application to demonstrate running a Spring Boot application as an AWS Lambda built with Cloud formation.

# AWS Lambda

Build the code and deploy with AWS SAM. Using maven shade plugin.

mvn clean package shade:shade

    * AWS deploy için bucket oluştur. isim uniqiue olmalı (training-aws-spring-boot-lambda-201904)
        aws s3 mb s3://training-aws-spring-boot-lambda-201904  --region us-east-1

aws cloudformation package --template-file sam.yaml --output-template-file target/output-sam.yaml --s3-bucket training-aws-spring-boot-lambda-201904  --region us-east-1
 
    * Aşağıdakini çalıştırmak için aws kullanıcısına cloudformation:CreateStack yetkisi verilmeli.
    *    
    Lambda Deploy için yeni bir policy oluşturulup kullanıcıya verilmeli. 
    {
    "Version": "2012-10-17",
    "Statement": [
    {
    "Sid": "Stmt1449904348000",
    "Effect": "Allow",
    "Action": [
    "cloudformation:CreateStack",
    "cloudformation:CreateChangeSet",
    "cloudformation:ListStacks",
    "cloudformation:UpdateStack",
    "cloudformation:DescribeChangeSet",
    "cloudformation:ExecuteChangeSet"
    ],
    "Resource": [
    "*"
    ]
    }
    ]
    }   
    *
    
aws cloudformation deploy --template-file target/output-sam.yaml --stack-name training-aws-spring-boot-lambda-201904 --capabilities CAPABILITY_IAM --region us-east-1
 
aws cloudformation describe-stacks --stack-name training-aws-spring-boot-lambda-201904  --region us-east-1

# Run

To build and run from a packaged jar locally:

    mvn spring-boot:run

or 

    mvn clean package -Dboot
    java -jar target/spring-boot-lambda-1.0.0-SNAPSHOT.jar

# Docker

To build the image. First build the application, then build the docker image

    mvn package -Dboot
    docker build -t spring-boot-lambda .
    
## Run

    docker run --name spring-boot-lambda -p 8080:8080 -d spring-boot-lambda
    
# Test

    curl http://localhost:8080/languages

