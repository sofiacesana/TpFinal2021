package com.cursera.repository.list;

import com.cursera.model.Student;
import com.cursera.model.User;
import com.cursera.repository.AbstractList;
import com.cursera.util.Direction;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends AbstractList<User> {

    @Override
    public User searchById(Integer id) {
        User result = null;
        for (User whatUser: dataSource){
            if (whatUser.getmId() != null && whatUser.getmId().equals(id)){
                result = whatUser;
                break;
            }
        }
        return result;
    }

    @Override
    public void edit(User user) {
        User u = this.searchById(user.getmId());

        u.setName(u.getName());
        u.setSurname(u.getSurname());
        u.setUsername(u.getUsername());
        u.setPsw(u.getPsw());
        u.setDNI(u.getDNI());
        u.setTelephone(u.getTelephone());
        u.setLocation(u.getLocation());
        u.setProvinc(u.getProvinc());
        u.setCountry(u.getCountry());

        if (user.getClass() == Student.class) {
            u.setInterests(u.getInterests());
        } else {
            u.setFirm(u.getFirm());
        }
    }

    @Override
    public List<User> list(String field, Direction dir) {
        List<User> orderedList = new ArrayList<>(this.dataSource);

        orderedList.sort((a,b) ->{
            int result = 0;
            if (dir == Direction.ASC){
                result = order(field, a, b);
            }
            else if (dir == Direction.DESC){
                result = order(field, b, a);
            }
                return result;
        });
        return orderedList;
    }

    private static int order(String field, User a, User b) {
        int result = 0;

            if (field == "id")
                    result = a.getmId().compareTo(b.getmId());
            if (field == "surname")
                result = a.getSurname().compareTo(b.getSurname());
            if (field == "DNI")
                result = a.getDNI().compareTo(b.getDNI());

        return result;
    }




}
