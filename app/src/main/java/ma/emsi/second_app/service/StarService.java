package ma.emsi.second_app.service;

import java.util.ArrayList;
import java.util.List;

import ma.emsi.second_app.classes.Star;
import ma.emsi.second_app.dao.IDao;

public class StarService implements IDao<Star> {

    private List<Star> stars;
    private static StarService instance;

    public StarService() {
        this.stars = new ArrayList<>();
    }

    public static StarService getInstance() {
        if (instance == null)
            instance=new StarService();
        return instance;
    }

    @Override
    public boolean create(Star o) {
        return stars.add(o);
    }

    @Override
    public boolean update(Star o) {
        for (Star d: stars) {
            if(o.getId() == d.getId()){
                d.setImg(o.getImg());
                d.setName(o.getName());
                d.setStar(o.getStar());
            }
        }
        return true ;
    }

    @Override
    public boolean delete(Star o) {
        return stars.remove(o);
    }

    @Override
    public List<Star> findAll() {
        return stars;
    }

    @Override
    public Star findById(int id) {
        for(Star d : stars) {
            if (d.getId() == id)
                return d;
        }
        return null ;
    }
}
