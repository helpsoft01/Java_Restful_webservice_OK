package sonvh.webservice.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Groups {
	HashMap<String, Group> listGroup = new HashMap<String, Group>();

	public Groups() {

		Group t = new Group();
		t.setId(1);
		t.setName("mot");
		listGroup.put("1", t);

		t = new Group();
		t.setId(2);
		t.setName("hai");
		listGroup.put("2", t);

		t = new Group();
		t.setId(3);
		t.setName("ba");
		listGroup.put("3", t);

	}

	public boolean updateGroup(Group group) {

		boolean flag = true;
		String key = String.valueOf(group.getId());
		if (listGroup.get(key) != null) {
			listGroup.replace(key, group);
		} else {
			// not exists
			flag = false;
		}
		return flag;
	}

	public boolean addGroup(Group group) {

		boolean flag = true;
		String key = String.valueOf(group.getId());
		if (listGroup.get(key) == null) {
			listGroup.put(key, group);
		} else {
			// duplicate
			flag = false;
		}
		return flag;
	}

	public Group findUser_byID(int id) {

		Group result = listGroup.get(String.valueOf(id));

		return result;
	}

	public List<Group> getGroups() {
		List<Group> result = new ArrayList<Group>(listGroup.values());
		return result;
	}
}
