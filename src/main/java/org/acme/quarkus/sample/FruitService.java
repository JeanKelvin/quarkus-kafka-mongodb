package org.acme.quarkus.sample;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class FruitService {

    @Inject MongoClient mongoClient;

    List<Fruit> list(){
        List<Fruit> list = new ArrayList<>();

        try (MongoCursor<Document> cursor = this.getCollection().find().iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Fruit fruit = new Fruit();
                fruit.setName(document.getString("name"));
                fruit.setDescription(document.getString("description"));
                list.add(fruit);
            }
        }
        return list;
    }

    void add(Fruit fruit){
        Document document = new Document()
                .append("name", fruit.getName())
                .append("description", fruit.getDescription());
        this.getCollection().insertOne(document);
    }

    private MongoCollection getCollection(){
        return mongoClient.getDatabase("fruit").getCollection("fruit");
    }
}
