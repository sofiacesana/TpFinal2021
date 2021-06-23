package com.cursera.repository.list;

import com.cursera.model.Student;
import com.cursera.model.StudentNtrainer;
import com.cursera.model.Trainer;
import com.cursera.model.User;
import com.cursera.repository.AbstractList;
import com.cursera.util.Direction;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.cursera.menus.StudentMenu.studentMenu;
import static com.cursera.util.Resources.editInformationListing;
import static com.cursera.util.Resources.optionInput;

public class UserRepository extends AbstractList<User> {


    @Override
    public User searchById(int id) {
        User result = null;
        for (User whatUser : dataSource){
            if (whatUser.getId() == id){
                result = whatUser;
                break;
            }
        }
        return result;
    }


    @Override
    public User edit(User editUser) {
        Scanner scan = new Scanner(System.in);
        System.out.println(editUser.toString());
        editInformationListing(editUser);
        int op;
        if(editUser instanceof Trainer || editUser instanceof Student){
            op = optionInput(1, 10);
        }else{
            op = optionInput(1, 11);
        }
        switch(op){
            case 1:
                System.out.print("Introduce your new name: ");
                editUser.setName(scan.nextLine());
                break;
            case 2:
                System.out.print("Introduce your new surname: ");
                editUser.setSurname(scan.nextLine());
                break;
            case 3:
                System.out.print("Introduce your new username: ");
                editUser.setUsername(scan.next());
                break;
            case 4:
                int flag = 1;
                int i = 0;
                do{
                    System.out.print("Please introduce your old password: ");
                    String pw = scan.next();
                    if(pw != editUser.getPsw()){
                        System.out.println("Incorrect password!");
                        flag = 0;
                        i++;
                    }else{
                        editUser.setPsw(pw);
                    }
                }while(flag == 0 && i < 3);
                break;
            case 5:
                System.out.print("Introduce your new DNI: ");
                editUser.setDNI(scan.next());
                break;
            case 6:
                System.out.println("Introduce your new phone number: ");
                editUser.setTelephone(scan.next());
                break;
            case 7:
                System.out.println("Introduce your new location: ");
                editUser.setLocation(scan.nextLine());
                break;
            case 8:
                System.out.println("Introduce your new province: ");
                editUser.setProvince(scan.nextLine());
                break;
            case 9:
                System.out.println("Introduce your new country: ");
                editUser.setCountry(scan.nextLine());
                break;
            case 10:
                if(editUser instanceof Student){
                    System.out.println("Introduce your new interests: ");
                    editUser.setInterests(scan.nextLine());
                }else{
                    System.out.println("Introduce your new firm: ");
                    try{
                        editUser.setFirm(scan.nextInt());
                    }
                    catch (InputMismatchException e){
                        System.out.println("Wrong data type inserted.");
                    }
                }
                break;
            case 11:
                System.out.println("Introduce your new interests: ");
                editUser.setInterests(scan.nextLine());
                break;
            default:
                System.out.println(" Going to the principal menu... ");
        }
        return editUser;
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

    private int order(String field, User a, User b) {
        int result = 0;

        if (field == "id")
            result = a.getId() - b.getId();
        if (field == "surname")
            result = a.getSurname().compareTo(b.getSurname());
        if (field == "DNI")
            result = a.getDNI().compareTo(b.getDNI());

        return result;
    }

}
