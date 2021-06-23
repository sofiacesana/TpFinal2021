package com.cursera.repository.list;

import com.cursera.model.Degree;
import com.cursera.repository.AbstractList;
import com.cursera.util.Direction;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.cursera.util.Resources.*;

public class DegreeRepository extends AbstractList<Degree> {

    @Override
    public Degree searchById(int id) {
        Degree result = null;
        for (Degree whatDegree: dataSource){
            if ( whatDegree.getDegreeId() != null && whatDegree.getDegreeId().equals(id)){
                result = whatDegree;
                break;
            }
        }
        return result;
    }

    @Override
    public Degree edit(Degree editDegree) {

        Scanner scan = new Scanner(System.in);
        editInformationDegree();

        int op = optionInput(1, 5);

        switch(op){
            case 1:
                System.out.print("Introduce the new name: ");
                editDegree.setCourseName(scan.nextLine());
                break;
            case 2:
                System.out.print("Introduce the new course duration: ");
                editDegree.setCourseDuration(scan.nextLine());
                break;
            case 3:
                System.out.print("Introduce the new trainer name: ");
                editDegree.setTrainerName(scan.next());
                break;
            case 4:
                System.out.print("Introduce the new trainer surname: ");
                editDegree.setTrainerSurname(scan.next());
                break;
            case 5:
                System.out.print("Introduce the new firm: ");
                editDegree.setFirm(scan.nextInt());
                break;
        }
        return editDegree;
    }

    @Override
    public List<Degree> list(String field, Direction dir) {
        List<Degree> orderedList = new ArrayList<>(this.dataSource);

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

    private static int order(String field, Degree a, Degree b) {
        int result = 0;

        if (field == "id")
            result = a.getDegreeId().compareTo(b.getDegreeId());
        if (field == "trainer surname")
            result = a.getTrainerSurname().compareTo(b.getTrainerSurname());

        return result;
    }
}
