package web.services;

import web.models.User;

import java.util.List;

interface UserSerInterface {
    public List<User> index() ;

    public User show(int id);

    public void save(User person);

    public void update(int id, User person);
    public void delete(int id);

}
