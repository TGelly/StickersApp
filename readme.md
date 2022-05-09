# StickersApp

This project is an app that allows teachers in preschool to give children good or bad stickers representing their behavior. Each child has a digital book that the parents may look into.

## Functionning

In a child's book, there may be stickers from three different colors :

- &#x26AA; **White** : the child has performed a very good deed that benefited the group.
- &#x1F7E2;<span style = "color : green"> **Green** </span> : the child has behaved well.
- &#x1F534; <span style = "color : red"> **Red** </span> : the child misbehaved.

For each good or bad sticker, the teacher who attributes it writes a description stating why the child got this sticker, which is available to the parents.

## API :

| Address                       | Resource                              |
|:-----------------------------:|:-------------------------------------:|
| /books                        | all books                             |
| /books/[bookID]               | the stickers in a specific book       |  
| /books/[bookID]/[stickerID]   | a specific sticker in a specific book |   

## Request path :

Spark -> StartServer -> gui/UserGUI -> core/UserCore -> dao/UserDAO 
transmitted data are *entity/UserEntity* objects

## Authorizations :

- logged as a parent :
  - can only see one book and it's stickers
- logged as a teacher :
  - can see all books

## Deployment

/!\ Upcoming : the app's deployment /!\