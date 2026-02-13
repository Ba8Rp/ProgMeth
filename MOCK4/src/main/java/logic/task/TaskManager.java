package logic.task;


import interfaces.Duplicatable;

import java.util.ArrayList;

public class TaskManager {
	public static ArrayList<Task> getTaskByType(ArrayList<Class> types) {
        ArrayList<Task> tasks = TaskList.getTasks();
        ArrayList<Task>returnTasks = new ArrayList<Task>();

        for(Task t : tasks ){
            for(Class ck : types){
                if(instanceOf(t.getClass(),ck)){
                    returnTasks.add(t);
                    break;
                }
            }
        }
        return returnTasks;
    }
	
    public static void deleteDuplicateTasks() {
        ArrayList<Task> tasks = TaskList.getTasks();

        for(int i= tasks.size()-1;i>=0;i--){
            Task t = tasks.get(i);
            if(instanceOf(t.getClass(), Duplicatable.class)&& t.toString().contains("-")){
                tasks.remove(t);
            }
        }
    }

    public static boolean instanceOf(Class checkClass, Class interfaceClass) {
        return interfaceClass.isAssignableFrom(checkClass);
    }
}
