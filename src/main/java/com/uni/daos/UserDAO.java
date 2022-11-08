package com.uni.daos;

import com.uni.datautils.ConnectionUtil;
import com.uni.exceptions.DatabaseConnectionException;
import com.uni.exceptions.ImUserCreationException;
import com.uni.exceptions.NoUsernameFoundException;
import com.uni.models.ImUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements CrudDAO<ImUser> {

    public ImUser getByUsername(String username){
        try(Connection connection = ConnectionUtil.getConnection()) {
            String sql = "select * from im_user where username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ImUser user = new ImUser();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(username);
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setHeightInches(rs.getInt("height"));
                user.setWeightLbs(rs.getInt("weight"));
                user.setProfilePic(rs.getString("profile_pic"));
                user.setHideBiometrics(rs.getBoolean("display_biometrics"));
                return user;
            }
            throw new NoUsernameFoundException();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public ImUser createInstance(ImUser imUser) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String sql = "insert into im_user (username, password, role, height, weight, profile_pic, display_biometrics) VALUES (?, ?, ?::im_role, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, imUser.getUsername());
            ps.setString(2, imUser.getPassword());
            ps.setString(3, imUser.getRole());
            ps.setInt(4, imUser.getHeightInches());
            ps.setInt(5, imUser.getWeightLbs());
            ps.setString(6, imUser.getProfilePic());
            ps.setBoolean(7, imUser.isHideBiometrics());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            imUser.setUserId(rs.getInt(1));

            return imUser;
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new ImUserCreationException();
        }
    }

    @Override
    public List<ImUser> getAll() {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String sql = "select * from im_user";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<ImUser> users = new ArrayList<>();

            while (rs.next()) {
                ImUser user = new ImUser();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setHeightInches(rs.getInt("height"));
                user.setWeightLbs(rs.getInt("weight"));
                user.setProfilePic(rs.getString("profile_pic"));
                user.setHideBiometrics(rs.getBoolean("display_biometrics"));

                users.add(user);
            }

            return users;
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new DatabaseConnectionException();
        }
    }
}