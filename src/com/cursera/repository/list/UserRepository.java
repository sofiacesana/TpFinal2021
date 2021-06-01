package com.cursera.repository.list;

import com.cursera.model.Student;
import com.cursera.model.StudentNtrainer;
import com.cursera.model.Trainer;
import com.cursera.model.User;
import com.cursera.repository.AbstractList;
import com.cursera.util.Direction;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepository extends AbstractList<User> {

    public void registration (){
        Scanner sc = new Scanner(System.in);

        System.out.println(" Seleccionar |modo de registración| \t ALUMNO (1) \t CAPACITADOR (2) " +
                "\t ALUMNO & CAPACITADOR (3) \t\n |0| SALIR \t");
      /*  switch (sc.nextShort()) {
            case 0:

                break;
            case 1:

                break;
            case 2:

                break;

            case 3:

            default:
                System.out.println("\n |INVALIDO| ");
                break;
        }*/
    }

    public User login (String userName){
        User exist = null;
        Scanner sc = new Scanner(System.in);

        for (User whatUser: dataSource){
            if (whatUser.getUsername().equals(userName)){
                System.out.println(" Ingresar |CONTRASEÑA| ");
                if (whatUser.getPsw().equals(sc.nextLine())){
                    exist = whatUser;
                    break;
                }
            }
            break;
        }
        return exist;
    }

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

        if (user.getClass() == Student.class)
            u.setInterests(u.getInterests());
        if (user.getClass() == Trainer.class)
            u.setFirm(u.getFirm());
        if (user.getClass() == StudentNtrainer.class)
            u.setInterests(u.getInterests());
            u.setFirm(u.getFirm());
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
