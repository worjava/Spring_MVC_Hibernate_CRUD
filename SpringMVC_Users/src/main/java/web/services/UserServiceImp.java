package web.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;
import web.repositories.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserSerInterface {


    private final UserRepository peopleRepository;

    public UserServiceImp(UserRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    @Override
    public List<User> index() {
        return peopleRepository.index();
    }

    @Override
    public User show(int id) {
        return peopleRepository.show(id);

    }

    @Override
    @Transactional
    public void save(User person) {
        peopleRepository.save(person);
    }

    @Override

    @Transactional
    public void update(int id, User person) {
        peopleRepository.update(id, person);
    }


    @Override
    @Transactional
    public void delete(int id) {
        peopleRepository.delete(id);
    }
}

