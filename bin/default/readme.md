# StickersApp

## Addresses :

| Address                       | Resource                              |
|:-----------------------------:|:-------------------------------------:|
| /books                        | all books                             |
| /books/[bookID]               | the stickers in a specific book       |  
| /books/[bookID]/[stickerID]   | a specific sticker in a specific book |   

## Authorizations :

- logged as a parent :
  - can only see one book and it's stickers
- logged as a teacher :
  - can see all books

## Request path :

Spark -> StartServer -> gui/UserGUI -> core/UserCore -> dao/UserDAO 
transmitted data are *entity/UserEntity* objects
