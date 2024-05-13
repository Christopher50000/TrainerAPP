package com.example.trainerApplication.models.Deserializer;

import com.example.trainerApplication.models.entities.PersonalTrainer;
import com.example.trainerApplication.models.entities.StrengthAndConditioningCoach;
import com.example.trainerApplication.models.entities.TrainerEntity;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

/**
 * The custom deserializer will extract the value of the trainer_type property, which is trainer_type. It then instantiates a
 * subclass that is a concrete object using the provided data and returns it.
 *
 * This approach allows us to use polymorphism effectively. We can handle objects of different
 * concrete subclasses
 * of TrainerEntity uniformly, without needing to know their exact type beforehand.
 * This is especially useful in scenarios where we want to process data generically or in a type-safe manner.
 */
public class TrainerEntityDeserializer extends StdDeserializer<TrainerEntity> {

    public TrainerEntityDeserializer() {
        this(null);
    }

    public TrainerEntityDeserializer(Class<?> vc) {
        super(vc);
    }

//    @Override
//    public TrainerEntity deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
//        ObjectMapper mapper = (ObjectMapper) jp.getCodec(); // Get ObjectMapper from JsonParser
//        JsonNode node = jp.readValueAsTree(); // Read the JSON node directly
//
//        String trainerType = node.get("trainer_type").asText();
//
//        // Deserialize objects based on the trainer_type
//        if ("Personal Trainer".equals(trainerType)) {
//            return mapper.treeToValue(node, PersonalTrainer.class); // Deserialize the node using ObjectMapper
//        } else if ("Strength and Conditioning Coach".equals(trainerType)) {
//            return mapper.treeToValue(node, StrengthAndConditioningCoach.class); // Deserialize the node using ObjectMapper
//        }
//
//        throw new IOException("Unrecognized trainer type: " + trainerType);
//    }
@Override
public TrainerEntity deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {
    JsonNode node = jp.getCodec().readTree(jp);
    String trainerType = node.get("trainer_type").asText();
    System.out.println(trainerType);
    if ("Personal Trainer".equals(trainerType)) {
        System.out.println("I AM PERSONAL TRAINER");
        return new PersonalTrainer(node.get("first_name").asText(),(node.get("last_name").asText()));
    } else if ("Strength and Conditioning Coach".equals(trainerType)) {
        return new StrengthAndConditioningCoach(node.get("first_name").asText(),(node.get("last_name").asText()));
    }

    throw new IllegalArgumentException("Unsupported trainer type: " + trainerType);
}
}