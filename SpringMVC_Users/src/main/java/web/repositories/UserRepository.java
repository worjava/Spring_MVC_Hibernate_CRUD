package web.repositories;

import web.models.User;

import java.util.List;

public interface UserRepository {
    public List<User> index() ;

    public User show(int id);

    public void save(User person);

    public void update(int id, User person);
    public void delete(int id);

}
