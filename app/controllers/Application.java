package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import models.*;

import views.html.*;

public class Application extends Controller 
{
	static Form<Task> taskForm = Form.form(Task.class);
	static Form<Tag> tagForm = Form.form(Tag.class);

	public static Result index() {
		return redirect(routes.Application.tasks());
	}

	public static Result tasks() 
	{
		return ok(views.html.index.render(Task.all(), Tag.all(), taskForm, tagForm));
	}

	public static Result newTask() 
	{
		Form<Task> filledForm = taskForm.bindFromRequest();
		if(filledForm.hasErrors()) 
		{
			return badRequest(
					views.html.index.render(Task.all(), Tag.all(), taskForm, tagForm)
					);
		} 
		else 
		{
			Task.create(filledForm.get());
			return redirect(routes.Application.tasks());  
		}
	}

	public static Result deleteTask(Long id) {
		Task.delete(id);
		return redirect(routes.Application.tasks());
	}
	
	public static Result editTask(Long id) {
		Task.delete(id);
		return redirect(routes.Application.tasks());
	}
	
	public static Result addTag()
	{
		return TODO;
	}
	
	public static Result newTag()
	{
		Form<Tag> filledForm = tagForm.bindFromRequest();
		if(filledForm.hasErrors()) 
		{
			return badRequest(
					views.html.index.render(Task.all(), Tag.all(), taskForm, tagForm)
					);
		} 
		else 
		{
			Tag.create(filledForm.get());
			return redirect(routes.Application.tasks());  
		}
	}

}
