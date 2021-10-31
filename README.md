# Team Bongo Java Project

## Problem Statement
Everyone has been in a situation where they've found an online recipe they like
only for the relevant information to be on a cluttered and unreadable site. Between having to hear
about stories from the author's childhood, ads, popups and everthing else, getting the recipe can be a 
straight up hassle. This project plans to use Jsoup in order to scrape and parse a popular
recipe site and provide only relevant data in the form of an api. 

This service will do the following:
- Get a single recipe in the form of JSON.
- Get all recipes in the form of JSON.
- Get a list of recipes based on food type.
- Get a list of recipes based on serving size.
- Get a list of recipes based on preptime.

## Technologies Used

| Name  | Technology    |
|-----------|-----------|
| Security/Authentication | Spring Security & JSON Web Token |
| Database | MySQL 8 |
| ORM Framework | Hibernate 5 |
| Dependency Management | Maven 3 |
| Logging | Log4J2 |
| Hosting | AWS Elastic Beanstalk |
| Unit Testing | JUnit 5 tests |
| IDE | IntelliJ IDEA |
| VCS | Git |
|HTML Parser | Jsoup  | 


## Resources
**Recipe**

| Property | Description | Type/Format |
|---|---|---|
| id | ID for Recipe | number |
| name | Name of Recipe | String | 
| servingSize | Serving size of recipe | number |
| time | Time it takes to make recipe | number |
| ingredients | Ingredients in recipe | Array of Strings |
| steps | Steps/ instructions to make recipe | Array of Strings |

## Team Docs 
- [Link to Team Charter](https://github.com/mad-java-ent-f21/teamBongo/blob/main/Documents/Charter.md)
- [Link to Team Resume](https://github.com/mad-java-ent-f21/teamBongo/blob/main/Documents/Resume.md)
- Link to Design Documents
- Other Links