package com.cursera.repository.list;

import com.cursera.model.Degree;
import com.cursera.repository.AbstractList;
import com.cursera.util.Direction;
import java.util.ArrayList;
import java.util.List;

public class DegreeRepository extends AbstractList<Degree> {

    @Override
    public Degree searchById(Integer id) {
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
    public void edit(Degree degree) {
        Degree d = this.searchById(degree.getDegreeId());

        d.setCourseName(d.getCourseName());
        d.setCourseDuration(d.getCourseDuration());
        d.setDate(d.getDate());
        d.setTrainerName(d.getTrainerName());
        d.setTrainerSurname(d.getTrainerName());
        d.setFirm(d.getFirm());
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
