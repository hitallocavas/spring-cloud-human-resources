package br.ufpe.cin.hcs3.hrpayroll.batch.contracts;

import br.ufpe.cin.hcs3.hrpayroll.batch.Context;
import br.ufpe.cin.hcs3.hrpayroll.batch.enums.TaskStatus;

public interface Task {
    TaskStatus execute(Context context);
}
