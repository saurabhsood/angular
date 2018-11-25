package config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import model.DupUser;
import model.User;

public class UserProcessor implements ItemProcessor<User, DupUser> {


@Override
public DupUser process(User user) throws Exception {
	// TODO Auto-generated method stub
	DupUser dup = null;
		dup = new DupUser();
		dup.setFirst_Name("X"+user.getFirstName());
		dup.setLast_Name("Y"+user.getLastName());
	return dup;
}


}