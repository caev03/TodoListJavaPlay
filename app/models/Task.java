package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Task extends Model
{

	@Id
	public Long id;

	@Required
	public String label;

	
	public String notes;

	public int priority;
	
	public List<Tag> tags = new ArrayList();

	public static Finder<Long,Task> find = new Finder( Long.class, Task.class );
	
	

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	public static List<Task> all() 
	{
		return find.all();
	}

	public static void create(Task task) 
	{
		task.save();
	}

	public static void delete(Long id) 
	{
		find.ref(id).delete();
	}

}