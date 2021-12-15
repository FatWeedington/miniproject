package btx.prog.one.miniproject.hospital.repo;

import btx.prog.one.miniproject.hospital.domain.Patient;

import java.util.*;

public class PatientRepository implements Repository{
    public static long nextId = 0;
    public static final PatientRepository INMEMORYREPO = new PatientRepository();

    private SortedMap<Object,BaseEntity> patientRepo = new TreeMap<>();

    @Override
    public BaseEntity findById(long id) {
        return patientRepo.get(id);
    }

    @Override
    public SortedMap findAll() {
        return patientRepo;
    }

    @Override
    public Object add(BaseEntity object) {
        object.setId(createId());
        patientRepo.put(object.getId(),object);
        return object.getId();
    }

    @Override
    public void update(BaseEntity object) {
        patientRepo.put(object.getId(),object);
    }

    @Override
    public void drop(BaseEntity object) {
        patientRepo.remove(object.getId(),object);
    }

    @Override
    public int size() {
        return patientRepo.size();
    }

    @Override
    public void clear() {
        patientRepo.clear();
    }

    public long createId(){
        nextId ++;
        return nextId;
    }
}
