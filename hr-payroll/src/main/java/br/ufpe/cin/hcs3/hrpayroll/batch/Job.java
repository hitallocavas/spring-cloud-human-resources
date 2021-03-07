package br.ufpe.cin.hcs3.hrpayroll.batch;

import br.ufpe.cin.hcs3.hrpayroll.batch.contracts.Task;
import br.ufpe.cin.hcs3.hrpayroll.batch.enums.JobStatus;
import br.ufpe.cin.hcs3.hrpayroll.batch.enums.TaskStatus;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class Job {

    private static final String LAST_TASK = "LastTask";
    private List<Task> tasks;
    private Context context;

    private Context executionContext;

    public Job(Context context) {
        this.tasks = new ArrayList<>();
        this.context = context;
        this.executionContext = new Context();
    }

    public Job addTask(Task task) {
        this.tasks.add(task);
        return this;
    }

    public JobStatus execute() {

        if (this.tasks.isEmpty()) {
            return JobStatus.COMPLETED;
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task task = this.tasks.get(i);
            TaskStatus taskStatus = task.execute(this.context);

            if (taskStatus.equals(TaskStatus.FAIL)) {
                log.error("O job não foi executado pois a task" +
                        task.getClass().getName() +
                        " não foi executado com sucesso");

                return JobStatus.INTERRUPTED;
            }

            this.executionContext.add(LAST_TASK, i);
        }
        return JobStatus.COMPLETED;
    }

    public void retry(){
        Integer lastTask = (Integer) this.executionContext.get(LAST_TASK);

        Stream<Task> nonExecutedTasks = this.tasks
                .stream()
                .filter(t -> tasks.indexOf(t) > lastTask);

        nonExecutedTasks.forEach(t -> t.execute(this.context));
    }

}
