package com.danila.rabbit.dao;

import com.danila.rabbit.dto.RabbitInput;
import com.danila.rabbit.model.Rabbit;
import com.danila.rabbit.util.ConnectionManager;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class RabbitDao {
    private static final RabbitDao rabbitDao = new RabbitDao();

    private static final String GET = "SELECT id, name, age FROM rabbits.rabbit.rabbit";

    public Set<Rabbit> getRabbits(){
        Set<Rabbit> rabbits = new HashSet<>();

        try(Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Rabbit rabbit = new Rabbit().builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .age(resultSet.getInt("age"))
                        .build();
                rabbits.add(rabbit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rabbits;
    }

    private static final String SAVE = "INSERT INTO rabbits.rabbit.rabbit (name, age) VALUES (?, ?)";
    public Integer saveRabbit(RabbitInput rabbitInput){
        Integer id = null;
        Rabbit rabbit = new Rabbit(null, rabbitInput.getName(), rabbitInput.getAge());

        try(Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, rabbitInput.getName());
            preparedStatement.setInt(2, rabbitInput.getAge());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
                rabbit.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }


    public static RabbitDao getInstance(){
        return rabbitDao;
    }
}
