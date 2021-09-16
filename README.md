### Instructions

I have to admit here that I think it is quite annoying to compile and run my code in other computers. 

#### Database

The blog relies on the mysql database which is defined in the `application.properties`.

![image-20210819102323672](https://user-images.githubusercontent.com/82575585/130000778-94715612-4b01-4b12-8583-8aef58c9af05.png)

When run the program first time, I have to insert the role manually. 

```
INSERT INTO `myblog`.`role`
(`role_id`,
`role`)
VALUES
(1, 'ADMIN'),
(2, 'USER');
```

In order to create administrator's account, change the "USER" to `ADMIN` in the `saveUser ` method of the `UserService` class, and then change it back after register successfully. 

![image-20210819103401698](https://user-images.githubusercontent.com/82575585/130000802-6e9ab5f8-0886-4d12-a45b-50cf9f43b1b4.png)

#### Bugs

There are too many bugs and unhandled errors in the blog system. The blog only supports basic operations for now. 

#### Reflection

Get started on the project as early as possible. After the code walkthrough, I realize I didn't use many complicated stuff or techniques in the project. However, I have spent a great deal of time finding the right java libraries and methods in order to make the blog work properly.
