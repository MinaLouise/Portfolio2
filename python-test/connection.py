from pymongo import MongoClient

MONGODB_URI = "mongodb+srv://msanford24:msanford24@cluster0.rotyjec.mongodb.net/?retryWrites=true&w=majority"

client =  MongoClient(MONGODB_URI)

for db_name in client.list_database_names():
    print(db_name)