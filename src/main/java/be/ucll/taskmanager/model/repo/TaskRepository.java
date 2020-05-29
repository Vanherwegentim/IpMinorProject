package be.ucll.taskmanager.model.repo;


import be.ucll.taskmanager.model.domain.Task;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class TaskRepository implements JpaRepository<Integer, Task> {
    private Map<Integer, Task> tasks;

    public TaskRepository(){
        tasks =  new HashMap<>();
        Task task1 = new Task("lol", "xd", LocalDate.now(), LocalTime.MIDNIGHT);
        this.addTask(task1);
    }

    public void removeTask(int id){
        tasks.remove(id);
    }

    public Map<Integer, Task> getMaps(){
        return tasks;
    }

    public void addTask(Task task){
        tasks.put(task.getId(),task);
    }

    public Task getTask(int id){
        return tasks.get(id);
    }

    // Mogen misschien weg
    @Override
    public List<Integer> findAll() {
        return null;
    }

    @Override
    public List<Integer> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Integer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Integer> findAllById(Iterable<Task> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Task task) {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public void deleteAll(Iterable<? extends Integer> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Integer> S save(S s) {
        return null;
    }

    @Override
    public <S extends Integer> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Integer> findById(Task task) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Task task) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Integer> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Integer> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Integer getOne(Task task) {
        return null;
    }

    @Override
    public <S extends Integer> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Integer> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Integer> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Integer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Integer> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Integer> boolean exists(Example<S> example) {
        return false;
    }
}
