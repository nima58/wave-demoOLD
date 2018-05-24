package com.example.wavedemo.repositories;

import com.example.wavedemo.model.POS;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class POSRepositoryMockImpl implements BaseRepository<POS> {

    List<POS> poses;
    public POSRepositoryMockImpl(){
        init();
    }

    private void init() {
        poses = new ArrayList<>();
        POS pos;
        for(int j=0;j<3;j++)
            for(int i=0;i<4;i++) {
                pos = new POS();
                pos.setPosId(i);
                pos.setStoreId(j);
                pos.setName("pos"+i);
                pos.setPrice(i+10);
                poses.add(pos);
        }
    }
   /* private void init() {
        poses = new ArrayList<>();
        POS pos;
        for(int i=0;i<3;i++) {
            pos = new POS();
            pos.setPosId(i);
            pos.setStoreId(i);
            pos.setName("pos"+i);
            pos.setPrice(i+10);
            poses.add(pos);
        }
    }*/

    @Override
    public List<POS> all() {
        return poses;
    }

    public List<POS> all(int storeId) {
        return poses.stream()
                .filter(p -> p.getStoreId().equals(storeId))
                .collect(Collectors.toList());
    }

    @Override
    public POS byId(int id) {
        return poses.get(id);
    }

    public POS byId(int storeId, int posId) {
        List<POS> filtered = poses.stream()
                .filter(p -> p.getStoreId().equals(storeId) && p.getPosId().equals(posId))
                .collect(Collectors.toList());
        return filtered.get(0);
    }
    @Override
    public void create(POS pos) {
        poses.add(pos);
    }

    public void create(int storeId, POS pos) {
        poses.add(pos);
    }

    public void update(int storeId, POS pos) {
        //validate if already exists otherwise??
        POS find = poses.get(pos.getPosId());
        if(find != null ) {
            poses.remove(find);
            poses.add(pos);
        } else {
           // throw new
        }
    }

    @Override
    public void removeById(int id) {
        POS pos = poses.get(id);
        if(pos != null)
            poses.remove(pos);
    }
}
