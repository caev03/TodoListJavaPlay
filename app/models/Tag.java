package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Tag extends Model
{

	@Id
	public Long id;

	@Required
	public String label;

	public static Finder<Long,Tag> find = new Finder( Long.class, Tag.class );
	
	

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

	public static List<Tag> all() 
	{
		return find.all();
	}

	public static void create(Tag tag) 
	{
		tag.save();
	}

	public static void delete(Long id) 
	{
		find.ref(id).delete();
	}

}