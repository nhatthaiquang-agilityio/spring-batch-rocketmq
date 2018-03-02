package example.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class SimpleStep implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		workload();
		System.out.println("Batch Job is done");
		return RepeatStatus.FINISHED;
	}

	private void workload() throws Exception{
		Thread.sleep(5000);
	}

}